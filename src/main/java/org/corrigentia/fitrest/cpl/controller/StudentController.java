package org.corrigentia.fitrest.cpl.controller;

import jakarta.ws.rs.NotFoundException;
import org.corrigentia.fitrest.adal.domain.entity.security.RoleType;
import org.corrigentia.fitrest.adal.domain.entity.security.StudentEntity;
import org.corrigentia.fitrest.bbll.service.StudentService;
import org.corrigentia.fitrest.cpl.utils.JwtUtil;
import org.corrigentia.fitrest.model.dto.UserTokenDTO;
import org.corrigentia.fitrest.model.vo.StudentForm;
import org.corrigentia.fitrest.model.vo.StudentVO;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
@RequestMapping(path = "/api/students")
public class StudentController {
    private final StudentService studentService;
    private final JwtUtil util;
    private final PasswordEncoder passwordEncoder;

    public StudentController(final StudentService studentService, JwtUtil util, PasswordEncoder passwordEncoder) {
        this.studentService = studentService;
        this.util = util;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(path = {"/new"})
    public ResponseEntity<UserTokenDTO> postStudentAction(@Validated @RequestBody final StudentForm form) {
        final StudentEntity entity = form.toEntity();
        entity.setRole(RoleType.USER);

        StudentEntity registeredStudent = this.studentService.register(entity);
        UserTokenDTO dto = UserTokenDTO.fromEntity(registeredStudent);
        String token = util.generateToken(registeredStudent);
        dto.setToken(token);

        // return
        // ResponseEntity.status(HttpStatus.CREATED).body(StudentVO.fromBLL(entity));
        return ResponseEntity.ok(dto);
    }

    @PostMapping(path = {"/returning"})
    public ResponseEntity<UserTokenDTO> signInStudentAction(@Validated @RequestBody final StudentForm form) {
        final StudentEntity registeredStudent = (StudentEntity) studentService.loadUserByUsername(form.email);

        if (passwordEncoder.matches(form.password, registeredStudent.getPassword())) {
            // StudentEntity registeredStudent = this.studentService.register(entity);
            UserTokenDTO dto = UserTokenDTO.fromEntity(registeredStudent);
            String token = util.generateToken(registeredStudent);
            dto.setToken(token);

            // return
            // ResponseEntity.status(HttpStatus.CREATED).body(StudentVO.fromBLL(entity));
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @PostMapping(path = {"/{id:[0-9]+}/photo"})
    @CrossOrigin(exposedHeaders = {"Set-Cookie"})
    public ResponseEntity postStudentPhotoAction(@RequestPart final MultipartFile file) {

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("in upload spring");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        System.out.println();
        System.out.println(file);
        System.out.println();

        System.out.println(file.isEmpty());

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        try {
            System.out.println("the file is not empty");
            System.out.println(file.getName());
            System.out.println(file.getOriginalFilename());
            // Get the file and save it somewhere
            final byte[] bytes = file.getBytes();
            System.out.println("bytes: \n" + bytes);
            final Path path = Path.of(
                    "C:\\Users\\gr.costache\\OneDrive - " +
                            "TechnofuturTIC\\FitWorld\\FitWorldAngular\\src" +
                            "\\assets\\images\\"
//                            + file.getName());
                            + file.getOriginalFilename());//
            System.out.println("path: \n" + path);
            Files.write(path, bytes);
            System.out.println("managed to write");
        } catch (final IOException e) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("didn't manage to save file");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            e.printStackTrace();
            // throw new RuntimeException(e);

            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(null);
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<StudentVO>> getAllAction(
            @RequestParam(defaultValue = "0", required = false) final int page,
            @RequestParam(defaultValue = "5", required = false) final int size) {
        final Page<StudentEntity> response = this.studentService.findByEnabledTrue(page,
                size);

        final List<StudentVO> students = response.map(StudentVO::fromBLL).toList();

        return ResponseEntity.ok(students);
    }

    /*
     * @GetMapping(path = "/{id:[0-9]+}/ownedEquipments") public
     * ResponseEntity<List<EquipmentOwnedVO>>
     * getAllEquimentsOwned(@PathVariable(name = "id") final int id) {
     *
     * final var entityOptional = this.studentService.findOneById(id);
     *
     * if (entityOptional.isPresent()) { final var entity = entityOptional.get();
     * return ResponseEntity.ok(StudentVO.fromBLL(entity)); } return
     * ResponseEntity.notFound().build(); }
     */

    @GetMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<StudentVO> getOneAction(@PathVariable(name = "id") final int id) {
        /*
         * final StudentEntity entity = this.studentService.findOneById(id)
         * .orElseThrow(() -> new NotFoundException("Student id=" + id + " not" +
         * " found"));
         */
        final Optional<StudentEntity> entityOptional = this.studentService.findOneById(id);

        if (entityOptional.isPresent()) {
            final StudentEntity entity = entityOptional.get();
            return ResponseEntity.ok(StudentVO.fromBLL(entity));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<Object> putOneAction(@PathVariable(name = "id") final long id,
                                               @Validated @RequestBody final StudentForm form) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("trying to update a student...");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        final Optional<StudentEntity> entityOptional = this.studentService.findOneById(id);
        System.out.println("entityOptional : ");
        System.out.println(entityOptional);
        if (entityOptional.isPresent()) {
            System.out.println("entity optional is present...");
            System.out.println("about to update...");

            final StudentEntity entity = form.toEntity();
            entity.setRole(RoleType.USER);

            final StudentEntity updated = this.studentService.update(id,
                    entity);
            System.out.println("managed to update... ");
            System.out.println(updated);

            UserTokenDTO dto = UserTokenDTO.fromEntity(updated);
            String token = util.generateToken(updated);
            dto.setToken(token);

            return ResponseEntity.ok(dto);

            // return ResponseEntity.ok(StudentVO.fromBLL(updated));
        }
        final StudentEntity entity = form.toEntity();

        this.studentService.register(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(StudentVO.fromBLL(entity));
    }

    @DeleteMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<StudentVO> deleteOneAction(@PathVariable(name = "id") final int id) {

        final StudentEntity entity = this.studentService.findOneById(id)
                .orElseThrow(() -> new NotFoundException("Student id=" + id + " " + "not found"));

        this.studentService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(StudentVO.fromBLL(entity));
    }
}
