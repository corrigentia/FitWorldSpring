package org.corrigentia.fitrest.bbll.service.mapper;

import jakarta.ws.rs.NotFoundException;
import org.corrigentia.fitrest.adal.domain.entity.MartialArtClassEntity;
import org.corrigentia.fitrest.adal.repo.InstructorRepository;
import org.corrigentia.fitrest.adal.repo.MartialArtRepository;
import org.corrigentia.fitrest.model.vo.MartialArtClassForm;
import org.springframework.stereotype.Service;

@Service
public class MartialArtClassMapper {
    private final MartialArtRepository martialArtRepository;
    private final InstructorRepository instructorRepository;

    public MartialArtClassMapper(final MartialArtRepository martialArtRepository, final InstructorRepository instructorRepository) {
        this.martialArtRepository = martialArtRepository;
        this.instructorRepository = instructorRepository;
    }


    public MartialArtClassEntity toEntity(MartialArtClassForm form) {
        if (null == form) {
            return null;
        }

        MartialArtClassEntity entity = new MartialArtClassEntity();


        entity.setDateTime(form.dateTime);
        entity.setPricePerHour(form.pricePerHour);

        entity.setMartialArt(martialArtRepository.findById(form.martialArtId)
                .orElseThrow(() -> new NotFoundException("Martial Art id=" + form.martialArtId + " not found")));
        entity.setInstructor(instructorRepository.findById(form.instructorId)
                .orElseThrow(() -> new NotFoundException("Instructor id=" + form.instructorId + " not found")));

        return entity;
    }
}
