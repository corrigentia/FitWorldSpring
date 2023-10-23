package org.corrigentia.fitrest.bbll.service.impl;

import jakarta.ws.rs.NotFoundException;
import org.corrigentia.fitrest.adal.domain.entity.MartialArtEntity;
import org.corrigentia.fitrest.adal.repo.MartialArtRepository;
import org.corrigentia.fitrest.bbll.service.MartialArtService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MartialArtServiceImpl implements MartialArtService {

    private final MartialArtRepository repository;

    public MartialArtServiceImpl(final MartialArtRepository repository) {
        this.repository = repository;
    }

    /**
     * @return
     */
    @Override
    public List<MartialArtEntity> findByNameContainsIgnoreCase(final String name) {
        return this.repository.findByNameContainsIgnoreCase(name);
    }

    /**
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<MartialArtEntity> findByEnabledTrue(final int page, final int size) {
        return this.repository.findByEnabledTrue(PageRequest.of(page, size, Sort.by("id").ascending()));
    }

    @Override
    public Page<MartialArtEntity> findByEnabledTrue(final int page,
            final int size,
            final Sort sort) {
        return this.repository.findByEnabledTrue(PageRequest.of(page, size, sort));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<MartialArtEntity> findOneById(final long id) {
        return this.repository.findById(id);
        // return Optional.empty();
    }

    /**
     * @param entity
     */
    @Override
    public MartialArtEntity insert(final MartialArtEntity entity) {
        return this.repository.save(entity);
    }

    @Override
    public MartialArtEntity update(long id, MartialArtEntity entity) {
        // TODO Auto-generated method stub
        MartialArtEntity toUpdate = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Martial Art id=" + id + " not found"));

        toUpdate.setName(entity.getName());

        repository.save(toUpdate);

        return toUpdate;

        // return Optional.empty();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public MartialArtEntity delete(long id) {
        Optional<MartialArtEntity> toDelete = repository.findById(id);

        if (toDelete.isPresent()) {
            MartialArtEntity entity = toDelete.get();
            entity.setEnabled(false);
            this.repository.save(entity);
            return entity;
        }
        throw new NotFoundException("Martial Art id=" + id + " not found");
    }
}
