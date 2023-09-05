package org.corrigentia.swagger_rest.c3_pl.controller;

import java.util.List;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.MartialArtEntity;
import org.corrigentia.swagger_rest.b2_bll.service.MartialArtService;
import org.corrigentia.swagger_rest.model.vo.MartialArtForm;
import org.corrigentia.swagger_rest.model.vo.MartialArtVO;
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
@RequestMapping(path = { "/martial-arts" })
public class MartialArtController {

	private final MartialArtService martialArtService;

	public MartialArtController(final MartialArtService martialArtService) {
		this.martialArtService = martialArtService;
	}

	@GetMapping(path = { "/all" })
	public ResponseEntity<List<MartialArtVO>> getAllAction() {
		final List<MartialArtEntity> response = this.martialArtService.findAll();

		final List<MartialArtVO> martialArts = response.stream().map(MartialArtVO::fromBLL).toList();

		return ResponseEntity.ok(martialArts);
	}

	@GetMapping(path = { "", "/" })
	public ResponseEntity<List<MartialArtVO>> getAllAction(
			@RequestParam(defaultValue = "0", required = false) final int page,
			@RequestParam(defaultValue = "5", required = false) final int size) {
		final Page<MartialArtEntity> response = this.martialArtService.findAll(page, size);

		final List<MartialArtVO> martialArts = response.stream().map(MartialArtVO::fromBLL).toList();

		return ResponseEntity.ok(martialArts);
	}

	@GetMapping(path = { "/{id:[0-9]+}" })
	public ResponseEntity<MartialArtVO> getOneAction(@PathVariable(name = "id") final int id) {
		final MartialArtEntity entity = this.martialArtService.findOneById(id)
				.orElseThrow(() -> new NotFoundException("Martial Art id=" + id + " not found"));

		return ResponseEntity.ok(MartialArtVO.fromBLL(entity));
	}

	@PostMapping(path = { "", "/" })
	public ResponseEntity<MartialArtVO> postMartialArtAction(@Validated @RequestBody final MartialArtForm form) {
		final MartialArtEntity entity = form.toEntity();

		this.martialArtService.insert(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(MartialArtVO.fromBLL(entity));
	}
}
