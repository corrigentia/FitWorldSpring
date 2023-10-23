package org.corrigentia.fitrest.bbll.service;

import org.corrigentia.fitrest.adal.domain.entity.security.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface StudentService /* extends UserDetailsService */ {
    StudentEntity signIn(StudentEntity entity);

    StudentEntity register(StudentEntity entity);

    Page<StudentEntity> findByEnabledTrue(int page, int size);

    Page<StudentEntity> findByEnabledTrue(int page, int size, Sort sort);

    Optional<StudentEntity> findOneById(long id);

    StudentEntity update(long id, StudentEntity entity);

    StudentEntity delete(long id);

    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
