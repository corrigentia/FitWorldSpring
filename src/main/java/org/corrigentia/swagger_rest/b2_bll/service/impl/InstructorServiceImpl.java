package org.corrigentia.swagger_rest.b2_bll.service.impl;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.security.InstructorEntity;
import org.corrigentia.swagger_rest.a0_dal.repo.InstructorRepository;
import org.corrigentia.swagger_rest.b2_bll.service.InstructorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    /**
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<InstructorEntity> findAll(int page, int size) {
        return this.instructorRepository.findAll(PageRequest.of(page, size));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<InstructorEntity> findOneById(long id) {
        return this.instructorRepository.findById(id);
//        return Optional.empty();
    }

    /**
     * @param entity
     */
    @Override
    public void insert(InstructorEntity entity) {
        this.instructorRepository.save(entity);
    }
}
