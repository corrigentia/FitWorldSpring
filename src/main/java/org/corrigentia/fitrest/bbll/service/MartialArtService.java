package org.corrigentia.fitrest.bbll.service;

import org.corrigentia.fitrest.adal.domain.entity.MartialArtEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface MartialArtService {
    /**
     * @param page
     * @param size
     * @return
     */

    Page<MartialArtEntity> findByEnabledTrue(int page, int size);

    Page<MartialArtEntity> findByEnabledTrue(int page, int size, Sort sort);


    List<MartialArtEntity> findByNameContainsIgnoreCase(String name);


    Optional<MartialArtEntity> findOneById(long id);

    void insert(MartialArtEntity entity);

    MartialArtEntity update(long id, MartialArtEntity entity);

    MartialArtEntity delete(long id);
}
