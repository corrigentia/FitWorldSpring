package org.corrigentia.fitrest.adal.repo;

import org.corrigentia.fitrest.adal.domain.entity.EquipmentOwnedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EquipmentOwnedRepository extends JpaRepository<EquipmentOwnedEntity, Long>, JpaSpecificationExecutor<EquipmentOwnedEntity> {
}
