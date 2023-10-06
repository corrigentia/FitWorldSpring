package org.corrigentia.fitrest.bbll.service.impl;

import jakarta.ws.rs.NotFoundException;
import org.corrigentia.fitrest.adal.domain.entity.EquipmentEntity;
import org.corrigentia.fitrest.adal.repo.*;
import org.corrigentia.fitrest.bbll.service.EquipmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository repository;

    public EquipmentServiceImpl(EquipmentRepository repository,
                                StudentRepository studentRepository, InstructorRepository instructorRepository,
                                MartialArtistRepository martialArtistRepository, UserRepository userRepository) {
        this.repository = repository;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public List<EquipmentEntity> getByName(final String name) {
        return repository.getByName(name);
    }

    /**
     * @param price
     * @return
     */
    @Override
    public List<EquipmentEntity> getByPrice(final double price) {
        return repository.getByPrice(price);
    }

    @Override
    public Page<EquipmentEntity> findByEnabledTrue(int page, int size,
                                                   Sort sort) {
        return repository.findByEnabledTrue(PageRequest.of(page
                , size, sort));
    }

    @Override
    public Page<EquipmentEntity> findByEnabledTrue(int page, int size) {
        return repository.findByEnabledTrue(PageRequest.of(page
                , size, Sort.by("id").ascending()));
    }

    @Override
    public Optional<EquipmentEntity> findOneById(long id) {
        return repository.findById(id);
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public void insert(EquipmentEntity entity) {
        repository.save(entity);
//        return entity;
    }

    @Override
    public EquipmentEntity update(long id, EquipmentEntity entity) {
        // TODO Auto-generated method stub
        var toUpdate = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Equipment id=" + id + " not found"));

        toUpdate.setPrice(entity.getPrice());
        toUpdate.setName(entity.getName());

        repository.save(toUpdate);
        return toUpdate;
//        return Optional.empty();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public EquipmentEntity delete(long id) {
        var toDelete = repository.findById(id);

        if (toDelete.isPresent()) {
            var entity = toDelete.get();
            entity.setEnabled(false);
            this.repository.save(entity);
            return entity;
        }
        throw new NotFoundException("Equipment id=" + id + " not found");
    }

    /*
     * @Override public void insert(EquipmentEntity entity/*, long ownerId
     */
    /*
     * ) {
     */
    /*
     * MartialArtistEntity owner =
     * this.martialArtistRepository.findById(ownerId).orElseThrow(() -> new
     * NotFoundException( "Martial Artist id=" + ownerId + " not found"));
     */
//        owner.ownedEquipmen
    /*
     * }
     */
}
