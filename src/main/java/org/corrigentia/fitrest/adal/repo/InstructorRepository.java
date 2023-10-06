package org.corrigentia.fitrest.adal.repo;

import java.util.List;

import org.corrigentia.fitrest.adal.domain.entity.security.InstructorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<InstructorEntity, Long>, JpaSpecificationExecutor<InstructorEntity> {
    List<InstructorEntity> getByLastName(@Nullable String lastName);

    List<InstructorEntity> getByFirstName(String firstName);

    Page<InstructorEntity> findByEnabledTrue(Pageable pageable);

}
