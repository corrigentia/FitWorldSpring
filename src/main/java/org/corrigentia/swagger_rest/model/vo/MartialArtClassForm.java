package org.corrigentia.swagger_rest.model.vo;

import jakarta.validation.constraints.Positive;
import jakarta.ws.rs.NotFoundException;
import org.corrigentia.swagger_rest.a0_dal.domain.entity.MartialArtClassEntity;
import org.corrigentia.swagger_rest.a0_dal.repo.InstructorRepository;
import org.corrigentia.swagger_rest.a0_dal.repo.MartialArtRepository;

import java.time.LocalDateTime;

public class MartialArtClassForm {
    private final InstructorRepository instructorRepository;
    private final MartialArtRepository martialArtRepository;
    @Positive
    public long martialArtId;
    @Positive
    public long instructorId;
    public LocalDateTime dateTime;
    @Positive
    public double pricePerHour;

    public MartialArtClassForm(InstructorRepository instructorRepository, MartialArtRepository martialArtRepository) {
        this.instructorRepository = instructorRepository;
        this.martialArtRepository = martialArtRepository;
    }

    public MartialArtClassEntity toEntity() {
        MartialArtClassEntity entity = new MartialArtClassEntity();

        entity.setDateTime(dateTime);
        entity.setPricePerHour(pricePerHour);
        entity.setInstructor(instructorRepository.findById(instructorId).orElseThrow(() -> new NotFoundException("Instructor id=" + instructorId + " not found")));
        entity.setMartialArt(martialArtRepository.findById(martialArtId).orElseThrow(() -> new NotFoundException("Martial Art id=" + martialArtId + " not found")));

        return entity;
    }
}
