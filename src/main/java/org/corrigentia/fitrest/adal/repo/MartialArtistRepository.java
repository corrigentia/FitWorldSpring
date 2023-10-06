package org.corrigentia.fitrest.adal.repo;

import org.corrigentia.fitrest.adal.domain.entity.security.MartialArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MartialArtistRepository extends JpaRepository<MartialArtistEntity, Long>, JpaSpecificationExecutor<MartialArtistEntity> {
}
