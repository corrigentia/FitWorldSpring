package org.corrigentia.fitrest.adal.repo;

import org.corrigentia.fitrest.adal.domain.entity.security.AdminEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdminRepository extends JpaRepository<AdminEntity, Long>,
        JpaSpecificationExecutor<AdminEntity> {
    Page<AdminEntity> findByEnabledTrue(Pageable pageable);
}
