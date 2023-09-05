package org.corrigentia.swagger_rest.a0_dal.repo;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.MartialArtEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MartialArtRepository extends JpaRepository<MartialArtEntity, Long>, JpaSpecificationExecutor<MartialArtEntity> {
}
