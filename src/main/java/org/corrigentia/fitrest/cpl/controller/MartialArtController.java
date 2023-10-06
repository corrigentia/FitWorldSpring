package org.corrigentia.fitrest.cpl.controller;

import jakarta.ws.rs.NotFoundException;
import org.corrigentia.fitrest.adal.domain.entity.MartialArtEntity;
import org.corrigentia.fitrest.bbll.service.MartialArtService;
import org.corrigentia.fitrest.model.vo.MartialArtForm;
import org.corrigentia.fitrest.model.vo.MartialArtVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin // (origins = {"http://localhost:4200"})
@RequestMapping(path = "/api/martialArts")
public class MartialArtController {

    private final MartialArtService service;

    public MartialArtController(MartialArtService service) {
        this.service = service;
    }


    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<MartialArtVO>> getAllAction(
            @RequestParam(defaultValue = "0", required = false, name = "page") final int page,
            @RequestParam(defaultValue = "5", required = false, name = "size") final int size) {
        System.out.println("paged martial arts");
        final var response = this.service.findByEnabledTrue(page, size);

        final var list = response.stream().map(MartialArtVO::fromBLL).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<MartialArtVO> getOneAction(@PathVariable(name = "id") int id) {
        /*
        var entity = martialArtService.findOneById(id)
                .orElseThrow(() -> new NotFoundException("Martial Art id=" + id + " not found"));
        */

        final var entityOptional = this.service.findOneById(id);

        if (entityOptional.isPresent()) {
            final var entity = entityOptional.get();
            return ResponseEntity.ok(MartialArtVO.fromBLL(entity));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<MartialArtVO> postMartialArtAction(@Validated @RequestBody final MartialArtForm form) {
        final MartialArtEntity entity = form.toEntity();

        this.service.insert(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(MartialArtVO.fromBLL(entity));
    }


    @PutMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<MartialArtVO> putOneAction(@PathVariable(name = "id") final long id,
                                                     @Validated @RequestBody final MartialArtForm form) {
        final var entityOptional = service.findOneById(id);

        if (entityOptional.isPresent()) {
            final var updated = service.update(id, form.toEntity());

            return ResponseEntity.ok(MartialArtVO.fromBLL(updated));
        }

        final var entity = form.toEntity();

        service.insert(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(MartialArtVO.fromBLL(entity));

    }


    @DeleteMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<MartialArtVO> deleteOneAction(@PathVariable(name =
            "id") final long id) {

        final var entity = this.service.findOneById(id)
                .orElseThrow(() -> new NotFoundException("Equipment id=" + id + " " +
                        "not found"));

        service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(MartialArtVO.fromBLL(entity));
    }
}
