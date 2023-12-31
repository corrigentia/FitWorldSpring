package org.corrigentia.fitrest.adal.repo;

import org.corrigentia.fitrest.adal.domain.entity.MartialArtRankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MartialArtRankRepository
		extends JpaRepository<MartialArtRankEntity, Long>, JpaSpecificationExecutor<MartialArtRankEntity> {
}
