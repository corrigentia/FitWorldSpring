package org.corrigentia.fitrest.adal.repo;

import org.corrigentia.fitrest.adal.domain.entity.EquipmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepository
        extends JpaRepository<EquipmentEntity, Long>, JpaSpecificationExecutor<EquipmentEntity> {
    boolean existsByNameAndPriceAllIgnoreCase(String name, double price);

    Optional<EquipmentEntity> findFirstByNameAllIgnoreCase(String name);

    List<EquipmentEntity> getByName(String name);

    List<EquipmentEntity> getByPrice(double price);

    Page<EquipmentEntity> findByEnabledTrue(Pageable pageable);


//    List<EquipmentEntity> findByName(String name);
}
