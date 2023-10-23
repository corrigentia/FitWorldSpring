package org.corrigentia.fitrest.cpl.controller;

import jakarta.ws.rs.NotFoundException;
import org.corrigentia.fitrest.adal.domain.entity.security.AdminEntity;
import org.corrigentia.fitrest.adal.domain.entity.security.RoleType;
import org.corrigentia.fitrest.bbll.service.AdminService;
import org.corrigentia.fitrest.model.vo.AdminForm;
import org.corrigentia.fitrest.model.vo.AdminVO;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
@RequestMapping(path = "/api/admins")
public class AdminController {

    private final AdminService service;

    public AdminController(final AdminService service) {
        this.service = service;
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<AdminVO> postEquipmentAction(@Validated @RequestBody final AdminForm form) {
        final AdminEntity entity = form.toEntity();
        entity.setRole(RoleType.ADMIN);

        this.service.insert(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(AdminVO.fromBLL(entity));
    }

    /*
     * @PreAuthorize(value = "hasAnyAuthority('ROLE_USER') or hasAnyAuthority" +
     * "('HR_GROUP')")
     */
    // @CrossOrigin
    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<AdminVO>> getAllAction(
            @RequestParam(defaultValue = "0", required = false, name = "page") final int page,
            @RequestParam(defaultValue = "5", required = false, name = "size") final int size) {
        System.out.println("get paged equipments");
        final Page<AdminEntity> response = this.service.findByEnabledTrue(page,
                size);

        final List<AdminVO> list =
                response.map(AdminVO::fromBLL).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<AdminVO> getOneAction(@PathVariable(name = "id") final int id) {
        // EquipmentEntity entity = equipmentService.findOneById(id)
        // .orElseThrow(() -> new NotFoundException("Equipment id=" + id + " " + "not
        // found"));
        final Optional<AdminEntity> entityOptional = this.service.findOneById(id);

        if (entityOptional.isPresent()) {
            final AdminEntity entity = entityOptional.get();
            return ResponseEntity.ok(AdminVO.fromBLL(entity));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<AdminVO> putOneAction(@PathVariable(name = "id") final long id,
                                                @Validated @RequestBody final AdminForm form) {

        System.out.println();
        System.out.println("got in admin update");
        System.out.println();

        final Optional<AdminEntity> entityOptional = service.findOneById(id);

        if (entityOptional.isPresent()) {
            final AdminEntity updated = service.update(id, form.toEntity());

            return ResponseEntity.ok(AdminVO.fromBLL(updated));
        }

        final AdminEntity entity = form.toEntity();

        service.insert(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(AdminVO.fromBLL(entity));

    }

    @DeleteMapping(path = "/{id:[0-9]+}")
    public ResponseEntity<AdminVO> deleteOneAction(@PathVariable(name = "id") final long id) {

        final AdminEntity entity = this.service.findOneById(id)
                .orElseThrow(() -> new NotFoundException("Admin id=" + id +
                        " " +
                        "not found"));

        service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(AdminVO.fromBLL(entity));
    }
}
