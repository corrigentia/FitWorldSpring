package org.corrigentia.fitrest.bbll.service.impl;

import jakarta.ws.rs.NotFoundException;
import org.corrigentia.fitrest.adal.domain.entity.security.StudentEntity;
import org.corrigentia.fitrest.adal.repo.StudentRepository;
import org.corrigentia.fitrest.bbll.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * @param page
     * @param size
     * @return
     */
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

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<StudentEntity> findOneById(final long id) {
        return this.studentRepository.findById(id);
//        return Optional.empty();
    }

    /**
     * @param entity
     */
    @Override
    public void insert(final StudentEntity entity) {
        this.studentRepository.save(entity);
    }


    @Override
    public StudentEntity update(final long id, final StudentEntity entity) {
        // TODO Auto-generated method stub
        final var toUpdate = this.studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student id=" + id +
                        " not found"));

        toUpdate.setFirstName(entity.getFirstName());
        toUpdate.setLastName(entity.getLastName());
        toUpdate.setEmail(entity.getUsername());
        toUpdate.setPassword(entity.getPassword());
        toUpdate.setOwnedEquipments(entity.getOwnedEquipments());
        toUpdate.setClassesTaken(entity.getClassesTaken());

        this.studentRepository.save(toUpdate);

        return toUpdate;

//        return Optional.empty();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public StudentEntity delete(final long id) {
        final var toDelete = this.studentRepository.findById(id);

        if (toDelete.isPresent()) {
            final var entity = toDelete.get();
            entity.setEnabled(false);
            studentRepository.save(entity);
            return entity;
        }
        throw new NotFoundException("Student id=" + id + " not found");
    }
}
