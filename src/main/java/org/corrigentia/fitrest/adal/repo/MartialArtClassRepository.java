package org.corrigentia.fitrest.adal.repo;

import org.corrigentia.fitrest.adal.domain.entity.MartialArtClassEntity;
import org.corrigentia.fitrest.adal.domain.entity.MartialArtEntity;
import org.corrigentia.fitrest.adal.domain.entity.security.InstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDateTime;
import java.util.List;

public interface MartialArtClassRepository extends JpaRepository<MartialArtClassEntity, Long>, JpaSpecificationExecutor<MartialArtClassEntity> {
    List<MartialArtClassEntity> getByPricePerHour(double pricePerHour);

    List<MartialArtClassEntity> getByMartialArt(MartialArtEntity martialArt);

    List<MartialArtClassEntity> getByInstructor(InstructorEntity instructor);

    List<MartialArtClassEntity> getByDateTime(LocalDateTime dateTime);
}
