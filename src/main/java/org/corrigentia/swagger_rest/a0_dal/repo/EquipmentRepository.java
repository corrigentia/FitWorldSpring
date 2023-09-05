package org.corrigentia.swagger_rest.a0_dal.repo;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EquipmentRepository
		extends JpaRepository<EquipmentEntity, Long>, JpaSpecificationExecutor<EquipmentEntity> {
}
