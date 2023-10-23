package org.corrigentia.fitrest.cpl.controller;

import jakarta.ws.rs.NotFoundException;
import org.corrigentia.fitrest.adal.domain.entity.EquipmentEntity;
import org.corrigentia.fitrest.bbll.service.EquipmentService;
import org.corrigentia.fitrest.model.vo.EquipmentForm;
import org.corrigentia.fitrest.model.vo.EquipmentVO;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
@RequestMapping(path = "/api/equipments")
public class EquipmentController {

    private final EquipmentService service;

    public EquipmentController(final EquipmentService service) {
        this.service = service;
    }

    /*
     * @PreAuthorize(value = "hasAnyAuthority('ROLE_USER') or hasAnyAuthority" +
     * "('HR_GROUP')")
     */
    // @CrossOrigin
    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<EquipmentVO>> getAllAction(
            @RequestParam(defaultValue = "0", required = false, name = "page") final int page,
            @RequestParam(defaultValue = "5", required = false, name = "size") final int size) {
        System.out.println("get paged equipments");
        final Page<EquipmentEntity> response = this.service.findByEnabledTrue(page,
                size);

        final List<EquipmentVO> list = response.stream().map(EquipmentVO::fromBLL).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<EquipmentVO> getOneAction(@PathVariable(name = "id") final int id) {
        // EquipmentEntity entity = equipmentService.findOneById(id)
        // .orElseThrow(() -> new NotFoundException("Equipment id=" + id + " " + "not
        // found"));
        final Optional<EquipmentEntity> entityOptional = this.service.findOneById(id);

        if (entityOptional.isPresent()) {
            final EquipmentEntity entity = entityOptional.get();
            return ResponseEntity.ok(EquipmentVO.fromBLL(entity));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<EquipmentVO> postEquipmentAction(@Validated @RequestBody final EquipmentForm form) {
        final EquipmentEntity entity = form.toEntity();

        this.service.insert(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(EquipmentVO.fromBLL(entity));
    }

    @PutMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<EquipmentVO> putOneAction(@PathVariable(name = "id") final long id,
                                                    @Validated @RequestBody final EquipmentForm form) {

        System.out.println();
        System.out.println("got in equipment update");
        System.out.println();

        final Optional<EquipmentEntity> entityOptional = service.findOneById(id);

        if (entityOptional.isPresent()) {
            final EquipmentEntity updated = service.update(id, form.toEntity());

            return ResponseEntity.ok(EquipmentVO.fromBLL(updated));
        }
        final EquipmentEntity entity = form.toEntity();

        service.insert(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(EquipmentVO.fromBLL(entity));
    }

    @DeleteMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<EquipmentVO> deleteOneAction(@PathVariable(name = "id") final long id) {

        final EquipmentEntity entity = this.service.findOneById(id)
                .orElseThrow(() -> new NotFoundException("Equipment id=" + id + " " +
                        "not found"));

        service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(EquipmentVO.fromBLL(entity));
    }
}
