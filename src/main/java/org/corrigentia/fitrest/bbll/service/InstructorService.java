package org.corrigentia.fitrest.bbll.service;

import org.corrigentia.fitrest.adal.domain.entity.security.InstructorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface InstructorService {
    InstructorEntity insert(InstructorEntity entity);

    Page<InstructorEntity> findByEnabledTrue(int page, int size);

    Page<InstructorEntity> findByEnabledTrue(int page, int size, Sort sort);

    Optional<InstructorEntity> findOneById(long id);

    InstructorEntity update(long id, InstructorEntity entity);

    InstructorEntity delete(long id);

    List<InstructorEntity> getByLastName(String lastName);

    List<InstructorEntity> getByFirstName(String firstName);
}
