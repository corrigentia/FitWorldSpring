package org.corrigentia.swagger_rest.c3_pl.controller;

import java.util.List;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.security.StudentEntity;
import org.corrigentia.swagger_rest.b2_bll.service.StudentService;
import org.corrigentia.swagger_rest.model.vo.MartialArtistRegisterForm;
import org.corrigentia.swagger_rest.model.vo.StudentVO;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.ws.rs.NotFoundException;

@RestController
@CrossOrigin // (origins = {"http://localhost:4200"})
@RequestMapping(path = {"/students"})
public class StudentController {
    private final StudentService studentService;

    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = {"/all"})
    public ResponseEntity<List<StudentVO>> getAllAction() {
        final List<StudentEntity> response = this.studentService.findAll();

        final List<StudentVO> students = response.stream().map(StudentVO::fromBLL).toList();

        return ResponseEntity.ok(students);
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<StudentVO>> getAllAction(
            @RequestParam(defaultValue = "0", required = false) final int page,
            @RequestParam(defaultValue = "5", required = false) final int size) {
        final Page<StudentEntity> response = this.studentService.findAll(page, size);

        final List<StudentVO> students = response.map(StudentVO::fromBLL).toList();

        return ResponseEntity.ok(students);
    }

    @GetMapping(path = {"/{id:[0-9]+}"})
    public ResponseEntity<StudentVO> getOneAction(@PathVariable(name = "id") final int id) {
        final StudentEntity entity = this.studentService.findOneById((long) id)
                .orElseThrow(() -> new NotFoundException("Student id=" + id + " not" + " found"));

        return ResponseEntity.ok(StudentVO.fromBLL(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<StudentVO> postStudentAction(@Validated @RequestBody final MartialArtistRegisterForm form) {
        final StudentEntity entity = (StudentEntity) form.toEntity();

        this.studentService.insert(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(StudentVO.fromBLL(entity));
    }

}
