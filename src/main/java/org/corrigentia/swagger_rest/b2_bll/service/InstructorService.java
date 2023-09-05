package org.corrigentia.swagger_rest.b2_bll.service;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.security.InstructorEntity;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface InstructorService {
    Page<InstructorEntity> findAll(int page, int size);

    Optional<InstructorEntity> findOneById(long id);

    void insert(InstructorEntity entity);

}
