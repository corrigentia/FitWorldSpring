package org.corrigentia.fitrest.cpl.controller;

import org.corrigentia.fitrest.bbll.service.EquipmentService;
import org.corrigentia.fitrest.model.vo.EquipmentVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/equipments")
public class EquipmentSearchController {
    private final EquipmentService service;


    public EquipmentSearchController(final EquipmentService service) {
        this.service = service;
    }

    // @GetMapping(path = "?name=\\^{name}\\$")
    // TODO: TODO @todo java.lang.IllegalArgumentException: Invalid character
    //  found in the request target [/api/equipments?name=^Bokken$ ]. The
    //  valid characters are defined in RFC 7230 and RFC 3986
    @GetMapping(path = "/find/name/{name}")
    public ResponseEntity<List<EquipmentVO>> getAllByNameAction(
            @PathVariable(name = "name", required = true) final String name) {
        System.out.println("get by name");
        final var response = this.service.getByName(name);

        var list = response.stream().map(EquipmentVO::fromBLL).toList();

        return ResponseEntity.ok(list);
    }


    //    @GetMapping(path = {"?price={price}$", "/?price={price}$"}, params =
    // java.lang.IllegalArgumentException: No capture groups allowed in the constraint regex: [+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)
//    @GetMapping(path = "/find/price/{price:[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)}", params = "price")
    // java.lang.IllegalArgumentException: No capture groups allowed in the constraint regex: [+-]?([0-9]*[.])?[0-9]+
//    @GetMapping(path = "/find/price/{price:[+-]?([0-9]*[.])?[0-9]+}", params = "price")
    // java.lang.IllegalArgumentException: No capture groups allowed in the constraint regex: ^([+-]?\\d*\\.?\\d*)$
//    @GetMapping(path = "/find/price/{price:^([+-]?\\\\d*\\\\.?\\\\d*)$}",
    // TODO: TODO @todo regex for float
    @GetMapping(path = "/find/price/{price}")
    public ResponseEntity<List<EquipmentVO>> getAllByPriceAction(
            @PathVariable(name = "price", required = true) final double price) {
        System.out.println("get equipments by price");
        final var response = this.service.getByPrice(price);

        final var list = response.stream().map(EquipmentVO::fromBLL).toList();

        return ResponseEntity.ok(list);
    }
}
