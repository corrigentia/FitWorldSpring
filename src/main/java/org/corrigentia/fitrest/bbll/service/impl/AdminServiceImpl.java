package org.corrigentia.fitrest.bbll.service.impl;

import jakarta.ws.rs.NotFoundException;
import org.corrigentia.fitrest.adal.domain.entity.security.AdminEntity;
import org.corrigentia.fitrest.adal.domain.entity.security.RoleType;
import org.corrigentia.fitrest.adal.repo.AdminRepository;
import org.corrigentia.fitrest.bbll.service.AdminService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository repository;

    public AdminServiceImpl(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public AdminEntity insert(AdminEntity entity) {
        entity.setRole(RoleType.ADMIN);
        return this.repository.save(entity);
    }

    @Override
    public Page<AdminEntity> findByEnabledTrue(int page, int size) {
        return this.repository.findByEnabledTrue(PageRequest.of(page, size,
                Sort.by("id").ascending()));
    }

    @Override
    public Page<AdminEntity> findByEnabledTrue(int page, int size, Sort sort) {
        return this.repository.findByEnabledTrue(PageRequest.of(page, size,
                sort));
    }

    @Override
    public Optional<AdminEntity> findOneById(long id) {
        return this.repository.findById(id);
//        return Optional.empty();
    }

    @Override
    public AdminEntity update(final long id, final AdminEntity entity) {
        final AdminEntity toUpdate = this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Admin id=" + id +
                        " not found"));

        toUpdate.setFirstName(entity.getFirstName());
        toUpdate.setLastName(entity.getLastName());
        toUpdate.setEmail(entity.getUsername());
        toUpdate.setPassword(entity.getPassword());

        this.repository.save(toUpdate);

        return toUpdate;
    }

    @Override
    public AdminEntity delete(final long id) {

        final Optional<AdminEntity> toDelete = this.repository.findById(id);

        if (toDelete.isPresent()) {
            final AdminEntity entity = toDelete.get();
            entity.setEnabled(false);
            repository.save(entity);
            return entity;
        }
        throw new NotFoundException("Admin id=" + id + " not found");
    }
}
