package org.corrigentia.fitrest.bbll.service;

import org.corrigentia.fitrest.adal.domain.entity.EquipmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface EquipmentService {

    List<EquipmentEntity> getByName(String name);

    List<EquipmentEntity> getByPrice(double price);

    Page<EquipmentEntity> findByEnabledTrue(int page, int size);

    Page<EquipmentEntity> findByEnabledTrue(int page, int size, Sort sort);

    Optional<EquipmentEntity> findOneById(long id);

    void insert(EquipmentEntity entity);

    EquipmentEntity update(long id, EquipmentEntity entity);

    EquipmentEntity delete(long id);
}
