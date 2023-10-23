package org.corrigentia.fitrest.bbll.service;

import org.corrigentia.fitrest.adal.domain.entity.security.AdminEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public interface AdminService {
    AdminEntity insert(AdminEntity entity);

    Page<AdminEntity> findByEnabledTrue(int page, int size);

    Page<AdminEntity> findByEnabledTrue(int page, int size, Sort sort);

    Optional<AdminEntity> findOneById(long id);

    AdminEntity update(long id, AdminEntity entity);

    AdminEntity delete(long id);
}
