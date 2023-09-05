package org.corrigentia.swagger_rest.a0_dal.repo;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.security.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>, JpaSpecificationExecutor<StudentEntity> {
}
