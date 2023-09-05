package org.corrigentia.swagger_rest.b2_bll.service.impl;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.MartialArtClassEntity;
import org.corrigentia.swagger_rest.a0_dal.repo.MartialArtClassRepository;
import org.corrigentia.swagger_rest.b2_bll.service.MartialArtClassService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MartialArtClassServiceImpl implements MartialArtClassService {
    private final MartialArtClassRepository martialArtClassRepository;

    public MartialArtClassServiceImpl(MartialArtClassRepository combatClassRepository) {
        martialArtClassRepository = combatClassRepository;
    }

    /**
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<MartialArtClassEntity> findAll(int page, int size) {
        return this.martialArtClassRepository.findAll(PageRequest.of(page, size));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<MartialArtClassEntity> findOneById(long id) {
        return this.martialArtClassRepository.findById(id);
//        return Optional.empty();
    }

    /**
     * @param entity
     */
    @Override
    public void insert(MartialArtClassEntity entity) {
        this.martialArtClassRepository.save(entity);
    }
}
