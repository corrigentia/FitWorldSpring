package org.corrigentia.fitrest.adal.repo;

import org.corrigentia.fitrest.adal.domain.entity.security.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>, JpaSpecificationExecutor<StudentEntity> {
    Page<StudentEntity> findByEnabledTrue(Pageable pageable);
}
