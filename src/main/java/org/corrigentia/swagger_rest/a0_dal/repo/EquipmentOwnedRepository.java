package org.corrigentia.swagger_rest.a0_dal.repo;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.EquipmentOwnedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EquipmentOwnedRepository extends JpaRepository<EquipmentOwnedEntity, Long>, JpaSpecificationExecutor<EquipmentOwnedEntity> {
}
