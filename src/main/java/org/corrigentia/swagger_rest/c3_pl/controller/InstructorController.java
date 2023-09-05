package org.corrigentia.swagger_rest.c3_pl.controller;

import jakarta.ws.rs.NotFoundException;
import org.corrigentia.swagger_rest.a0_dal.domain.entity.security.InstructorEntity;
import org.corrigentia.swagger_rest.b2_bll.service.InstructorService;
import org.corrigentia.swagger_rest.model.vo.InstructorVO;
import org.corrigentia.swagger_rest.model.vo.MartialArtistRegisterForm;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin//(origins = {"http://localhost:4200"})
@RequestMapping(path = {"/instructors"})
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<InstructorVO>> getAllAction(
            @RequestParam(defaultValue = "0", required = false) final int page,
            @RequestParam(defaultValue = "5", required = false) final int size
    ) {
        final Page<InstructorEntity> response = this.instructorService.findAll(page, size);

        final List<InstructorVO> instructors =
                response.map(InstructorVO::fromBLL).toList();

        return ResponseEntity.ok(instructors);
    }

    @GetMapping(path = {"/{id:[0-9]+}"})
    public ResponseEntity<InstructorVO> getOneAction(@PathVariable(name = "id") final int id) {
        final InstructorEntity entity = this.instructorService.findOneById(id)
                .orElseThrow(() -> new NotFoundException("Instructor id=" + id + " not" +
                        " found"));

        return ResponseEntity.ok(InstructorVO.fromBLL(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<InstructorVO> postInstructorAction(
            @Validated @RequestBody MartialArtistRegisterForm form
    ) {
        InstructorEntity entity = (InstructorEntity) form.toEntity();

        this.instructorService.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(InstructorVO.fromBLL(entity));
    }

}
