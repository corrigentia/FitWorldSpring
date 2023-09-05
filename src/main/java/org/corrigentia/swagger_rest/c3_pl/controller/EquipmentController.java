package org.corrigentia.swagger_rest.c3_pl.controller;

import java.util.List;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.EquipmentEntity;
import org.corrigentia.swagger_rest.b2_bll.service.EquipmentService;
import org.corrigentia.swagger_rest.model.vo.EquipmentForm;
import org.corrigentia.swagger_rest.model.vo.EquipmentVO;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.ws.rs.NotFoundException;

@RestController
@CrossOrigin
@RequestMapping(path = {"/equipments"})
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(final EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    /*
     * @PreAuthorize(value = "hasAnyAuthority('ROLE_USER') or hasAnyAuthority" +
     * "('HR_GROUP')")
     */
    // @CrossOrigin
    @GetMapping(path = {"/all"})
    public ResponseEntity<List<EquipmentVO>> getAllAction() {
        final List<EquipmentEntity> response = this.equipmentService.findAll();

        final List<EquipmentVO> equipments = response.stream().map(EquipmentVO::fromBLL).toList();

        return ResponseEntity.ok(equipments);
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<EquipmentVO>> getAllAction(
            @RequestParam(defaultValue = "0", required = false) final int page,
            @RequestParam(defaultValue = "5", required = false) final int size) {
        final Page<EquipmentEntity> response = this.equipmentService.findAll(page, size);

        final List<EquipmentVO> equipments = response.stream().map(EquipmentVO::fromBLL).toList();

        return ResponseEntity.ok(equipments);
    }

    @GetMapping(path = {"/{id:[0-9]+}"})
    public ResponseEntity<EquipmentVO> getOneAction(@PathVariable(name = "id") final int id) {
        final EquipmentEntity entity = this.equipmentService.findOneById(id)
                .orElseThrow(() -> new NotFoundException("Equipment id=" + id + " " + "not found"));

        return ResponseEntity.ok(EquipmentVO.fromBLL(entity));
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<EquipmentVO> postEquipmentAction(@Validated @RequestBody final EquipmentForm form) {
        final EquipmentEntity entity = form.toEntity();

        this.equipmentService.insert(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(EquipmentVO.fromBLL(entity));
    }

    @PutMapping(path = {"/{id:[0-9]+}"})
    public ResponseEntity<EquipmentVO> putOneAction(@PathVariable(name = "id") final int id,
                                                    @Validated @RequestBody final EquipmentForm form) {
        this.equipmentService.findOneById(id)
                .orElseThrow(() -> new NotFoundException("Equipment id=" + id + " " + "not found"));

        final EquipmentEntity updated = this.equipmentService.update(id, form.toEntity());

        return ResponseEntity.ok(EquipmentVO.fromBLL(updated));
    }

}
