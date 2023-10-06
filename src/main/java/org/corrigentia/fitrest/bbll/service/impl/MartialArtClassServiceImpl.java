package org.corrigentia.fitrest.bbll.service.impl;

import jakarta.ws.rs.NotFoundException;
import org.corrigentia.fitrest.adal.domain.entity.MartialArtClassEntity;
import org.corrigentia.fitrest.adal.repo.InstructorRepository;
import org.corrigentia.fitrest.adal.repo.MartialArtClassRepository;
import org.corrigentia.fitrest.adal.repo.MartialArtRepository;
import org.corrigentia.fitrest.bbll.service.MartialArtClassService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MartialArtClassServiceImpl implements MartialArtClassService {
    private final MartialArtClassRepository martialArtClassRepository;
    private final MartialArtRepository martialArtRepository;
    private final InstructorRepository instructorRepository;

    public MartialArtClassServiceImpl(final MartialArtClassRepository classRepository, MartialArtRepository martialArtRepository, InstructorRepository instructorRepository) {
        this.martialArtClassRepository = classRepository;
        this.martialArtRepository = martialArtRepository;
        this.instructorRepository = instructorRepository;
    }

    /**
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<MartialArtClassEntity> findByEnabledTrue(final int page, final int size) {
        return martialArtClassRepository.findAll(PageRequest.of(page,
                size, Sort.by("id").ascending()));
    }

    @Override
    public Page<MartialArtClassEntity> findByEnabledTrue(final int page, final int size,
                                                         final Sort sort) {
        return martialArtClassRepository.findAll(PageRequest.of(page,
                size, sort));
    }

    /**
     * @param pricePerHour
     * @return
     */
    @Override
    public List<MartialArtClassEntity> getByPricePerHour(final double pricePerHour) {
        return martialArtClassRepository.getByPricePerHour(pricePerHour);
    }

    /**
     * @param dateTime
     * @return
     */
    @Override
    public List<MartialArtClassEntity> getByDateTime(final LocalDateTime dateTime) {
        return martialArtClassRepository.getByDateTime(dateTime);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<MartialArtClassEntity> getByInstructorId(final long id) {
        final var entity =
                instructorRepository.findById(id).orElseThrow(() -> new NotFoundException("Instructor id=" + id + " not found"));
        return martialArtClassRepository.getByInstructor(entity);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<MartialArtClassEntity> getByMartialArtId(final long id) {
        final var entity =
                martialArtRepository.findById(id).orElseThrow(() -> new NotFoundException("Martial Art id=" + id + " not found"));
        return martialArtClassRepository.getByMartialArt(entity);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<MartialArtClassEntity> findOneById(final long id) {
        return martialArtClassRepository.findById(id);
//        return Optional.empty();
    }

    /**
     * @param entity
     */
    @Override
    public void insert(final MartialArtClassEntity entity) {
        martialArtClassRepository.save(entity);
    }

    /**
     * @param id
     * @param entity
     * @return
     */
    @Override
    public MartialArtClassEntity update(final long id, final MartialArtClassEntity entity) {
        // TODO Auto-generated method stub
        final var toUpdate = this.martialArtClassRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Equipment id=" + id + " not found"));

        toUpdate.setMartialArt(entity.getMartialArt());
        toUpdate.setInstructor(entity.getInstructor());
        toUpdate.setDateTime(entity.getDateTime());
        toUpdate.setPricePerHour(entity.getPricePerHour());

        this.martialArtClassRepository.save(toUpdate);
        return toUpdate;
//        return Optional.empty();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public MartialArtClassEntity delete(final long id) {
        final var toDelete = this.martialArtClassRepository.findById(id);

        if (toDelete.isPresent()) {
            final var entity = toDelete.get();
            entity.setEnabled(false);
            martialArtClassRepository.save(entity);
            return entity;
        }
        throw new NotFoundException("Martial Art Class id=" + id + " not " +
                "found");
    }
}
