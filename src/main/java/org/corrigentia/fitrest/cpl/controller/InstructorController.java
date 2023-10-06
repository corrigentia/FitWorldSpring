package org.corrigentia.fitrest.cpl.controller;

import jakarta.ws.rs.NotFoundException;
import org.corrigentia.fitrest.adal.domain.entity.security.InstructorEntity;
import org.corrigentia.fitrest.bbll.service.InstructorService;
import org.corrigentia.fitrest.model.vo.InstructorVO;
import org.corrigentia.fitrest.model.vo.MartialArtistRegisterForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin//(origins = {"http://localhost:4200"})
@RequestMapping(path = "/api/instructors")
public class InstructorController {
    private final InstructorService service;

    public InstructorController(InstructorService service) {
        this.service = service;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<InstructorVO>> getAllAction(
            @RequestParam(defaultValue = "0", required = false) final int page,
            @RequestParam(defaultValue = "5", required = false) final int size
    ) {
        final var response = this.service.findByEnabledTrue(page, size);

        final var instructors =
                response.map(InstructorVO::fromBLL).toList();

        return ResponseEntity.ok(instructors);
    }

    @GetMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<InstructorVO> getOneAction(@PathVariable(name = "id") final int id) {
        final var entity = this.service.findOneById(id)
                .orElseThrow(() -> new NotFoundException("Instructor id=" + id + " not" +
                        " found"));

        return ResponseEntity.ok(InstructorVO.fromBLL(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<InstructorVO> postInstructorAction(
            @Validated @RequestBody MartialArtistRegisterForm form
    ) {
        var entity = (InstructorEntity) form.toEntity();

        this.service.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(InstructorVO.fromBLL(entity));
    }

    @PutMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<InstructorVO> putOneAction(@PathVariable(name = "id") long id,
                                                     @Validated @RequestBody MartialArtistRegisterForm form) {
        var entityOptional = this.service.findOneById(id);

        if (entityOptional.isPresent()) {
            var updated = this.service.update(id, (InstructorEntity) form.toEntity());

            return ResponseEntity.ok(InstructorVO.fromBLL(updated));
        }

        var entity = (InstructorEntity) form.toEntity();

        this.service.insert(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(InstructorVO.fromBLL(entity));

    }


    @DeleteMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<InstructorVO> deleteOneAction(@PathVariable(name =
            "id") long id) {

        var entity = service.findOneById(id)
                .orElseThrow(() -> new NotFoundException("Instructor id=" + id + " " +
                        "not found"));

        this.service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(InstructorVO.fromBLL(entity));
    }

}
