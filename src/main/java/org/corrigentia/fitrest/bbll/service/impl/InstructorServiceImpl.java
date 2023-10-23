package org.corrigentia.fitrest.bbll.service.impl;

import jakarta.ws.rs.NotFoundException;
import org.corrigentia.fitrest.adal.domain.entity.security.InstructorEntity;
import org.corrigentia.fitrest.adal.domain.entity.security.RoleType;
import org.corrigentia.fitrest.adal.repo.InstructorRepository;
import org.corrigentia.fitrest.bbll.service.InstructorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository repository;

    public InstructorServiceImpl(InstructorRepository repository) {
        this.repository = repository;
    }

    @Override
    public InstructorEntity insert(InstructorEntity entity) {
        entity.setRole(RoleType.INSTRUCTOR);
        return this.repository.save(entity);
    }

    @Override
    public Page<InstructorEntity> findByEnabledTrue(int page, int size) {
        return this.repository.findAll(PageRequest.of(page, size,
                Sort.by("id").ascending()));
    }

    @Override
    public Page<InstructorEntity> findByEnabledTrue(int page,
                                                    int size, final Sort sort) {
        return this.repository.findAll(PageRequest.of(page, size,
                sort));
    }

    @Override
    public Optional<InstructorEntity> findOneById(long id) {
        return this.repository.findById(id);
        // return Optional.empty();
    }

    @Override
    public InstructorEntity update(final long id, final InstructorEntity entity) {
        // TODO Auto-generated method stub
        InstructorEntity toUpdate = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Equipment id=" + id + " not found"));

        toUpdate.setFirstName(entity.getFirstName());
        toUpdate.setLastName(entity.getLastName());
        toUpdate.setEmail(entity.getUsername());
        toUpdate.setPassword(entity.getPassword());
        toUpdate.setRanks(entity.getRanks());

        repository.save(toUpdate);
        return toUpdate;
        // return Optional.empty();
    }

    @Override
    public InstructorEntity delete(final long id) {
        Optional<InstructorEntity> toDelete = repository.findById(id);

        if (toDelete.isPresent()) {
            InstructorEntity entity = toDelete.get();
            entity.setEnabled(false);
            this.repository.save(entity);
            return entity;
        }
        throw new NotFoundException("Instructor id=" + id + " not found");
    }

    @Override
    public List<InstructorEntity> getByFirstName(final String firstName) {
        return repository.getByFirstName(firstName);
    }

    @Override
    public List<InstructorEntity> getByLastName(final String lastName) {
        return repository.getByLastName(lastName);
    }
}
