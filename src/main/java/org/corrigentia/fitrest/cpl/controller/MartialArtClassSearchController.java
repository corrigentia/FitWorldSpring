package org.corrigentia.fitrest.cpl.controller;


import org.corrigentia.fitrest.bbll.service.MartialArtClassService;
import org.corrigentia.fitrest.model.vo.MartialArtClassVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = {"/api/classes", "/api/martial-art-classes"})
public class MartialArtClassSearchController {
    private final MartialArtClassService service;

    public MartialArtClassSearchController(final MartialArtClassService service) {
        this.service = service;
    }

    @GetMapping(path = "/find/pricePerHour/{pricePerHour}")
    public ResponseEntity<List<MartialArtClassVO>> getAllByPricePerHourAction(
            @PathVariable(name = "pricePerHour", required = true) double pricePerHour) {
        System.out.println("get martial art classes by price");
        var response = service.getByPricePerHour(pricePerHour);
        var list = response.stream().map(MartialArtClassVO::fromBLL).toList();
        return ResponseEntity.ok(list);
    }


    @GetMapping(path = "/find/dateTime/{dateTime}")
    public ResponseEntity<List<MartialArtClassVO>> getAllByDateTimeAction(
            @PathVariable(required = true) LocalDateTime dateTime) {
        System.out.println("get martial art classes by dateTime");
        var response = service.getByDateTime(dateTime);
        var list = response.stream().map(MartialArtClassVO::fromBLL).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/find/instructorId/{instructorId}")
    public ResponseEntity<List<MartialArtClassVO>> getAllByInstructorIdAction(
            @PathVariable(name = "instructorId", required = true) long instructorId) {
        System.out.println("get martial art classes by instructorId");
        var response = service.getByInstructorId(instructorId);
        var list = response.stream().map(MartialArtClassVO::fromBLL).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/find/martialArtId/{martialArtId}")
    public ResponseEntity<List<MartialArtClassVO>> getAllByMartialArtIdAction(
            @PathVariable(name = "martialArtId", required = true) long martialArtId) {
        System.out.println("get martial art classes by martialArtId");
        var response = service.getByMartialArtId(martialArtId);
        var list = response.stream().map(MartialArtClassVO::fromBLL).toList();
        return ResponseEntity.ok(list);
    }
}
