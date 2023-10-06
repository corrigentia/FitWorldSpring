package org.corrigentia.fitrest.cpl.controller;

import jakarta.ws.rs.NotFoundException;
import org.corrigentia.fitrest.adal.domain.entity.MartialArtClassEntity;
import org.corrigentia.fitrest.bbll.service.MartialArtClassService;
import org.corrigentia.fitrest.bbll.service.mapper.MartialArtClassMapper;
import org.corrigentia.fitrest.model.vo.MartialArtClassForm;
import org.corrigentia.fitrest.model.vo.MartialArtClassVO;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = {"/api/classes", "/api/martial-art-classes"})
public class MartialArtClassController {
    private final MartialArtClassService service;
    private final MartialArtClassMapper martialArtClassMapper;

    public MartialArtClassController(final MartialArtClassService service, MartialArtClassMapper martialArtClassMapper) {
        this.service = service;
        this.martialArtClassMapper = martialArtClassMapper;
    }

    /*
     * @PreAuthorize(value = "hasAnyAuthority('ROLE_USER') or hasAnyAuthority" +
     * "('HR_GROUP')")
     */
//	@CrossOrigin
    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<MartialArtClassVO>> getAllAction(
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "5", required = false) int size) {
        Page<MartialArtClassEntity> response = this.service.findByEnabledTrue(page,
                size);

        List<MartialArtClassVO> list = response.stream().map(MartialArtClassVO::fromBLL).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<MartialArtClassVO> getOneAction(@PathVariable(name = "id") final int id) {
        /*
        final MartialArtClassEntity entity = this.service.findOneById(id)
                .orElseThrow(() -> new NotFoundException("MartialArtClass id=" + id + " " + "not found"));
        */
        final var entityOptional = this.service.findOneById(id);

        if (entityOptional.isPresent()) {
            final var entity = entityOptional.get();

            System.out.println("localDateTime: ");
            System.out.println(entity.getDateTime());
            System.out.println(entity.getDateTime().toString());

            return ResponseEntity.ok(MartialArtClassVO.fromBLL(entity));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<MartialArtClassVO> postMartialArtClassAction(
            @Validated @RequestBody MartialArtClassForm form
    ) {
//        final MartialArtClassEntity entity = form.toEntity();
        final MartialArtClassEntity entity = this.martialArtClassMapper.toEntity(form);

        this.service.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(MartialArtClassVO.fromBLL(entity));
    }


    @PutMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<MartialArtClassVO> putOneAction(@PathVariable(name = "id") final long id,
                                                          @Validated @RequestBody final MartialArtClassForm form) {
        final var entityOptional = service.findOneById(id);

        if (entityOptional.isPresent()) {
//            final var updated = service.update(id, form.toEntity());
            final var updated = service.update(id,
                    this.martialArtClassMapper.toEntity(form)
            );

            return ResponseEntity.ok(MartialArtClassVO.fromBLL(updated));
        }

//        var entity = form.toEntity();
        final var entity = this.martialArtClassMapper.toEntity(form);

        service.insert(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(MartialArtClassVO.fromBLL(entity));

    }


    @DeleteMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<MartialArtClassVO> deleteOneAction(@PathVariable(name =
            "id") final long id) {

        final var entity = this.service.findOneById(id)
                .orElseThrow(() -> new NotFoundException("Equipment id=" + id + " " +
                        "not found"));

        service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(MartialArtClassVO.fromBLL(entity));
    }
}
