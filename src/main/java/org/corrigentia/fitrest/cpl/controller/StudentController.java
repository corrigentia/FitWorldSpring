package org.corrigentia.fitrest.cpl.controller;

import jakarta.ws.rs.NotFoundException;
import org.corrigentia.fitrest.adal.domain.entity.security.StudentEntity;
import org.corrigentia.fitrest.bbll.service.StudentService;
import org.corrigentia.fitrest.model.vo.MartialArtistRegisterForm;
import org.corrigentia.fitrest.model.vo.StudentVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin // (origins = {"http://localhost:4200"})
@RequestMapping(path = "/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<StudentVO>> getAllAction(
            @RequestParam(defaultValue = "0", required = false) final int page,
            @RequestParam(defaultValue = "5", required = false) final int size) {
        var response = this.studentService.findByEnabledTrue(page, size);

        var students = response.map(StudentVO::fromBLL).toList();

        return ResponseEntity.ok(students);
    }

    @GetMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<StudentVO> getOneAction(@PathVariable(name = "id") final int id) {
        /*
        final StudentEntity entity = this.studentService.findOneById(id)
                .orElseThrow(() -> new NotFoundException("Student id=" + id + " not" + " found"));
        */
        final var entityOptional =
                this.studentService.findOneById(id);

        if (entityOptional.isPresent()) {
            final var entity = entityOptional.get();
            return ResponseEntity.ok(StudentVO.fromBLL(entity));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<StudentVO> postStudentAction(@Validated @RequestBody final MartialArtistRegisterForm form) {
        final var entity = (StudentEntity) form.toEntity();

        this.studentService.insert(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(StudentVO.fromBLL(entity));
    }

    @PutMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<StudentVO> putOneAction(@PathVariable(name = "id") int id,
                                                  @Validated @RequestBody MartialArtistRegisterForm form) {
        var entityOptional = studentService.findOneById(id);

        if (entityOptional.isPresent()) {
            var updated = studentService.update(id,
                    (StudentEntity) form.toEntity());

            return ResponseEntity.ok(StudentVO.fromBLL(updated));
        }

        var entity = (StudentEntity) form.toEntity();

        studentService.insert(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(StudentVO.fromBLL(entity));

    }


    @DeleteMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<StudentVO> deleteOneAction(@PathVariable(name =
            "id") final int id) {

        var entity = studentService.findOneById(id)
                .orElseThrow(() -> new NotFoundException("Student id=" + id +
                        " " +
                        "not found"));

        studentService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(StudentVO.fromBLL(entity));
    }

}
