package org.corrigentia.fitrest.cpl.controller;

import org.corrigentia.fitrest.bbll.service.InstructorService;
import org.corrigentia.fitrest.model.vo.InstructorVO;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/instructors")
public class InstructorSearchController {
    private final InstructorService service;

    public InstructorSearchController(final InstructorService service) {
        this.service = service;
    }


    @GetMapping(path = "/find/lastName/{lastName}")
    public ResponseEntity<List<InstructorVO>> getAllByLastNameAction(
            @PathVariable(name = "lastName", required = false) @Nullable String lastName) {
        System.out.println("get by lastName");
        final var response = service.getByLastName(lastName);

        final var list = response.stream().map(InstructorVO::fromBLL).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/find/firstName/{firstName}")
    public ResponseEntity<List<InstructorVO>> getAllByFirstNameAction(
            @PathVariable(name = "firstName", required = true) String firstName) {
        System.out.println("get by firstName");
        final var response = service.getByFirstName(firstName);

        final var list = response.stream().map(InstructorVO::fromBLL).toList();

        return ResponseEntity.ok(list);
    }
}
