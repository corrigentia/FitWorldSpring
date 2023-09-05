package org.corrigentia.swagger_rest.b2_bll.service;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.MartialArtClassEntity;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface MartialArtClassService {
    Page<MartialArtClassEntity> findAll(int page, int size);

    Optional<MartialArtClassEntity> findOneById(long id);

    void insert(MartialArtClassEntity entity);
}
