package org.corrigentia.swagger_rest.a0_dal.repo;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.MartialArtRankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MartialArtRankRepository
		extends JpaRepository<MartialArtRankEntity, Long>, JpaSpecificationExecutor<MartialArtRankEntity> {
}
