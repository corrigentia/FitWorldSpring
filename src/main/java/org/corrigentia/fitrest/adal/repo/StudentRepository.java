package org.corrigentia.fitrest.adal.repo;

import org.corrigentia.fitrest.adal.domain.entity.security.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>, JpaSpecificationExecutor<StudentEntity> {
    Optional<StudentEntity> findFirstByEmailAllIgnoreCase(String email);

    boolean existsByEmailAllIgnoreCase(String email);

    Page<StudentEntity> findByEnabledTrue(Pageable pageable);
}
