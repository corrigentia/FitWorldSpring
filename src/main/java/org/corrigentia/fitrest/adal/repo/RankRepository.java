package org.corrigentia.fitrest.adal.repo;

import org.corrigentia.fitrest.adal.domain.entity.RankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RankRepository
		extends JpaRepository<RankEntity, Long>, JpaSpecificationExecutor<RankEntity> {
}
