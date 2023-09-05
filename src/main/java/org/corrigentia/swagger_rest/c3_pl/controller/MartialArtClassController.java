package org.corrigentia.swagger_rest.c3_pl.controller;

import jakarta.ws.rs.NotFoundException;
import org.corrigentia.swagger_rest.a0_dal.domain.entity.MartialArtClassEntity;
import org.corrigentia.swagger_rest.b2_bll.service.MartialArtClassService;
import org.corrigentia.swagger_rest.model.vo.MartialArtClassForm;
import org.corrigentia.swagger_rest.model.vo.MartialArtClassVO;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = {"/classes", "/martial-art-classes"})
public class MartialArtClassController {
    private final MartialArtClassService martialArtClassService;

    public MartialArtClassController(MartialArtClassService combatClassService) {
        martialArtClassService = combatClassService;
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
        Page<MartialArtClassEntity> response = martialArtClassService.findAll(page, size);

        List<MartialArtClassVO> martialArtClasss = response.stream().map(MartialArtClassVO::fromBLL).toList();

        return ResponseEntity.ok(martialArtClasss);
    }

    @GetMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<MartialArtClassVO> getOneAction(@PathVariable(name = "id") int id) {
        MartialArtClassEntity entity = martialArtClassService.findOneById(id)
                .orElseThrow(() -> new NotFoundException("MartialArtClass id=" + id + " " + "not found"));

        return ResponseEntity.ok(MartialArtClassVO.fromBLL(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<MartialArtClassVO> postMartialArtClassAction(
            @Validated @RequestBody final MartialArtClassForm form
    ) {
        final MartialArtClassEntity entity = form.toEntity();

        martialArtClassService.insert(entity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(MartialArtClassVO.fromBLL(entity));
    }

}
