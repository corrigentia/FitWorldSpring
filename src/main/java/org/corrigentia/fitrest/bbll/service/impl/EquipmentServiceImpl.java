package org.corrigentia.fitrest.bbll.service.impl;

import jakarta.ws.rs.NotFoundException;
import org.corrigentia.fitrest.adal.domain.entity.EquipmentEntity;
import org.corrigentia.fitrest.adal.domain.entity.EquipmentEntity_;
import org.corrigentia.fitrest.adal.exceptions.EquipmentNamePriceException;
import org.corrigentia.fitrest.adal.exceptions.EquipmentNullException;
import org.corrigentia.fitrest.adal.repo.EquipmentRepository;
import org.corrigentia.fitrest.bbll.service.EquipmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository repository;

    public EquipmentServiceImpl(
            EquipmentRepository repository /* ,
            StudentRepository studentRepository,
            InstructorRepository instructorRepository,
            MartialArtistRepository martialArtistRepository,
            UserRepository userRepository
            */
    ) {
        this.repository = repository;
    }

    @Override
    public EquipmentEntity insert(EquipmentEntity entity) {
        if (entity == null) {
            throw new EquipmentNullException();
        }
        if (repository.existsByNameAndPriceAllIgnoreCase(entity.getName(),
                entity.getPrice())) {
            throw new EquipmentNamePriceException();
        }
        return repository.save(entity);
        // return entity;
    }

    private Optional<EquipmentEntity> findBySpec(Specification<EquipmentEntity> specification) {
        return this.repository.findBy(specification,
                FluentQuery.FetchableFluentQuery::first);
    }

    private Stream<EquipmentEntity> findAllBySpec(Specification<EquipmentEntity> specification) {
        return this.repository.findBy(specification,
                FluentQuery.FetchableFluentQuery::stream);
    }

    @Override
    public List<EquipmentEntity> getByName(final String name) {
        Specification<EquipmentEntity> nameSpec = ((root, query,
                                                    criteriaBuilder) -> criteriaBuilder.equal(root.get(EquipmentEntity_.NAME), name));
        return findAllBySpec(nameSpec).toList();
//        return repository.getByName(name);
    }

    @Override
    public List<EquipmentEntity> getByPrice(final double price) {
        return repository.getByPrice(price);
    }

    @Override
    public Page<EquipmentEntity> findByEnabledTrue(int page, int size,
                                                   Sort sort) {
        return repository.findByEnabledTrue(PageRequest.of(page, size, sort));
    }

    @Override
    public Page<EquipmentEntity> findByEnabledTrue(int page, int size) {
        return repository.findByEnabledTrue(PageRequest.of(page, size, Sort.by("id").ascending()));
    }

    @Override
    public Optional<EquipmentEntity> findOneById(long id) {
        return repository.findById(id);
    }

    @Override
    public EquipmentEntity update(long id, EquipmentEntity entity) {
        // TODO Auto-generated method stub
        EquipmentEntity toUpdate = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Equipment id=" + id + " not found"));

        toUpdate.setPrice(entity.getPrice());
        toUpdate.setName(entity.getName());

        repository.save(toUpdate);
        return toUpdate;
        // return Optional.empty();
    }

    @Override
    public EquipmentEntity delete(long id) {
        Optional<EquipmentEntity> toDelete = repository.findById(id);

        if (toDelete.isPresent()) {
            EquipmentEntity entity = toDelete.get();
            entity.setEnabled(false);
            this.repository.save(entity);
            return entity;
        }
        throw new NotFoundException("Equipment id=" + id + " not found");
    }

    @Override
    public EquipmentEntity findEquipmentByName(String name) throws NotFoundException {
        Optional<EquipmentEntity> entityOptional = repository.findFirstByNameAllIgnoreCase(name);

        if (entityOptional.isPresent()) {
            return entityOptional.get();
        }
        throw new NotFoundException("Equipment name=" + name + " not found");
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
    // owner.ownedEquipmen
    /*
     * }
     */
}
