package org.corrigentia.fitrest.bbll.service;

import org.corrigentia.fitrest.adal.domain.entity.MartialArtClassEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MartialArtClassService {
    List<MartialArtClassEntity> getByPricePerHour(double pricePerHour);

    List<MartialArtClassEntity> getByDateTime(LocalDateTime dateTime);

    List<MartialArtClassEntity> getByInstructorId(long id);

    List<MartialArtClassEntity> getByMartialArtId(long id);

    Page<MartialArtClassEntity> findByEnabledTrue(int page, int size);

    Page<MartialArtClassEntity> findByEnabledTrue(int page, int size, Sort sort);

    Optional<MartialArtClassEntity> findOneById(long id);

    void insert(MartialArtClassEntity entity);

    MartialArtClassEntity update(long id, MartialArtClassEntity entity);

    MartialArtClassEntity delete(long id);
}
