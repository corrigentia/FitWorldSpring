package org.corrigentia.swagger_rest.b2_bll.service;

import java.util.List;
import java.util.Optional;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.security.StudentEntity;
import org.springframework.data.domain.Page;

public interface StudentService {
	List<StudentEntity> findAll();

	Page<StudentEntity> findAll(int page, int size);

	Optional<StudentEntity> findOneById(long id);

	void insert(StudentEntity entity);

}
