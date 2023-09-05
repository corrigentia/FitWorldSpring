package org.corrigentia.swagger_rest.b2_bll.service;

import java.util.List;
import java.util.Optional;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.EquipmentEntity;
import org.springframework.data.domain.Page;

public interface EquipmentService {
	List<EquipmentEntity> findAll();

	Page<EquipmentEntity> findAll(int page, int size);

	Optional<EquipmentEntity> findOneById(long id);

	void insert(EquipmentEntity entity);

	EquipmentEntity update(long id, EquipmentEntity entity);
}
