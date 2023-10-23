package org.corrigentia.fitrest.bbll.service.impl;

import jakarta.ws.rs.NotFoundException;
import org.corrigentia.fitrest.adal.domain.entity.security.RoleType;
import org.corrigentia.fitrest.adal.domain.entity.security.StudentEntity;
import org.corrigentia.fitrest.adal.repo.StudentRepository;
import org.corrigentia.fitrest.bbll.service.StudentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Primary
@Service
@Qualifier("studentServiceImpl")
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public StudentServiceImpl(final StudentRepository studentRepository, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public StudentEntity register(final StudentEntity entity) {
        entity.setRole(RoleType.USER);
        if (studentRepository.existsByEmailAllIgnoreCase(entity.getEmail())) {
            throw new RuntimeException("E-mail already taken.");
        }
        String encodedPassword = passwordEncoder.encode(entity.getPassword());
        entity.setPassword(encodedPassword);
        entity.setRole(RoleType.USER);
        return this.studentRepository.save(entity);
    }

    @Override
    public StudentEntity signIn(StudentEntity entity) {
        StudentEntity existingStudent =
                studentRepository.findFirstByEmailAllIgnoreCase(entity.getEmail()).orElseThrow(() -> new RuntimeException("wrong username"));

        if (!passwordEncoder.matches(entity.getPassword(),
                existingStudent.getPassword())) {
            throw new RuntimeException("Wrong password");
        }
        return existingStudent;
    }

    @Override
    public Page<StudentEntity> findByEnabledTrue(final int page, final int size) {
        return this.studentRepository.findByEnabledTrue(PageRequest.of(page, size,
                Sort.by("id").ascending()));
    }

    @Override
    public Page<StudentEntity> findByEnabledTrue(final int page, final int size, final Sort sort) {
        return this.studentRepository.findByEnabledTrue(PageRequest.of(page, size,
                sort));
    }

    @Override
    public Optional<StudentEntity> findOneById(final long id) {
        System.out.println("looking for student id=" + id);
        return this.studentRepository.findById(id);
        // return Optional.empty();
    }

    @Override
    public StudentEntity update(final long id, final StudentEntity entity) {
        System.out.println("in student service .update : ");
        // TODO Auto-generated method stub
        final StudentEntity toUpdate = this.studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student id=" + id +
                        " not found"));
        System.out.println("dbStudent : ");
        System.out.println(toUpdate);
        System.out.println(entity.getFirstName());
        System.out.println(entity.getLastName());
        System.out.println(entity.getUsername());
        System.out.println(entity.getPassword());
        toUpdate.setFirstName(entity.getFirstName());
        System.out.println("set given name");
        toUpdate.setLastName(entity.getLastName());
        System.out.println("set family");
        toUpdate.setEmail(entity.getUsername());
        System.out.println("set e-mail/username");


        String encodedPassword = passwordEncoder.encode(entity.getPassword());
        entity.setPassword(encodedPassword);
        entity.setRole(RoleType.USER);

        toUpdate.setPassword(entity.getPassword());
        System.out.println("set password");
        /*
        if (entity.getOwnedEquipments() != null) {
            System.out.println("has equipments");
            toUpdate.setOwnedEquipments(entity.getOwnedEquipments());
            System.out.println("set equipments");
        }
        if (entity.getClassesTaken() != null) {
            System.out.println("takes classes");
            toUpdate.setClassesTaken(entity.getClassesTaken());
            System.out.println("set classes");
        }
        */
        this.studentRepository.save(toUpdate);
        System.out.println("updated db");

        return toUpdate;
    }

    @Override
    public StudentEntity delete(final long id) {
        final Optional<StudentEntity> toDelete = this.studentRepository.findById(id);

        if (toDelete.isPresent()) {
            final StudentEntity entity = toDelete.get();
            entity.setEnabled(false);
            studentRepository.save(entity);
            return entity;
        }
        throw new NotFoundException("Student id=" + id + " not found");
    }

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may be case-sensitive, or case-insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested...
     *
     * @param email the e-mail identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return studentRepository.findFirstByEmailAllIgnoreCase(email).orElseThrow(() -> new UsernameNotFoundException("Email not registered"));
    }
}
