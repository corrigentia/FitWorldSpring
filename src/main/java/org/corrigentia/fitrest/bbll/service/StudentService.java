package org.corrigentia.fitrest.bbll.service;

import org.corrigentia.fitrest.adal.domain.entity.security.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public interface StudentService {

    Page<StudentEntity> findByEnabledTrue(int page, int size);

    Page<StudentEntity> findByEnabledTrue(int page, int size, Sort sort);

    Optional<StudentEntity> findOneById(long id);

    void insert(StudentEntity entity);

    StudentEntity update(long id, StudentEntity entity);

    StudentEntity delete(long id);

}
