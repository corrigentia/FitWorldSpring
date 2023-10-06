package org.corrigentia.fitrest.cpl.controller;

import org.corrigentia.fitrest.adal.domain.entity.MartialArtEntity;
import org.corrigentia.fitrest.bbll.service.MartialArtService;
import org.corrigentia.fitrest.model.vo.MartialArtVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/martialArts")
public class MartialArtSearchController {
    private final MartialArtService service;

    public MartialArtSearchController(MartialArtService service) {
        this.service = service;
    }


    @GetMapping(path = {"", "/"}, params = "name")
    public ResponseEntity<List<MartialArtVO>> findByNameContainsIgnoreCase(
            @RequestParam(defaultValue = "", required = true, name = "name") String name
    ) {
        System.out.println("get by name");
        final List<MartialArtEntity> response
                = this.service.findByNameContainsIgnoreCase(name);

        final List<MartialArtVO> martialArts
                = response.stream().map(MartialArtVO::fromBLL).toList();

        return ResponseEntity.ok(martialArts);
    }
}
