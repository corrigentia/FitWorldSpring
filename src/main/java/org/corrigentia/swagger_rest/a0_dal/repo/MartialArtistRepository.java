package org.corrigentia.swagger_rest.a0_dal.repo;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.security.MartialArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MartialArtistRepository extends JpaRepository<MartialArtistEntity, Long>, JpaSpecificationExecutor<MartialArtistEntity> {
}
