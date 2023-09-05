package org.corrigentia.swagger_rest.a0_dal.repo;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.MartialArtClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MartialArtClassRepository extends JpaRepository<MartialArtClassEntity, Long>, JpaSpecificationExecutor<MartialArtClassEntity> {
}
