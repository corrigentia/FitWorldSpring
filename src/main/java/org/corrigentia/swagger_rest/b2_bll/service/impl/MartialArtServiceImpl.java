package org.corrigentia.swagger_rest.b2_bll.service.impl;

import java.util.List;
import java.util.Optional;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.MartialArtEntity;
import org.corrigentia.swagger_rest.a0_dal.repo.MartialArtRepository;
import org.corrigentia.swagger_rest.b2_bll.service.MartialArtService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MartialArtServiceImpl implements MartialArtService {

	private final MartialArtRepository martialArtRepository;

	public MartialArtServiceImpl(final MartialArtRepository martialArtRepository) {
		this.martialArtRepository = martialArtRepository;
	}

	/**
	 * @param page
	 * @param size
	 * @return
	 */
	@Override
	public List<MartialArtEntity> findAll() {
		return this.martialArtRepository.findAll();
	}

	/**
	 * @param page
	 * @param size
	 * @return
	 */
	@Override
	public Page<MartialArtEntity> findAll(final int page, final int size) {
		return this.martialArtRepository.findAll(PageRequest.of(page, size));
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public Optional<MartialArtEntity> findOneById(final long id) {
		return this.martialArtRepository.findById(id);
//        return Optional.empty();
	}

	/**
	 * @param entity
	 */
	@Override
	public void insert(final MartialArtEntity entity) {
		this.martialArtRepository.save(entity);
	}
}
