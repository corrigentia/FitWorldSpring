package org.corrigentia.swagger_rest.b2_bll.service;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.MartialArtEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface MartialArtService {
    /**
     * @param page
     * @param size
     * @return
     */

    Page<MartialArtEntity> findAll(int page, int size);

    List<MartialArtEntity> findAll();


    Optional<MartialArtEntity> findOneById(long id);

    void insert(MartialArtEntity entity);
}
