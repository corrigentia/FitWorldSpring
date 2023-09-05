package org.corrigentia.swagger_rest.b2_bll.service.impl;

import java.util.List;
import java.util.Optional;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.security.StudentEntity;
import org.corrigentia.swagger_rest.a0_dal.repo.StudentRepository;
import org.corrigentia.swagger_rest.b2_bll.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	private final StudentRepository studentRepository;

	public StudentServiceImpl(final StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<StudentEntity> findAll() {
		// TODO Auto-generated method stub
		return this.studentRepository.findAll();
	}

	/**
	 * @param page
	 * @param size
	 * @return
	 */
	@Override
	public Page<StudentEntity> findAll(final int page, final int size) {
		return this.studentRepository.findAll(PageRequest.of(page, size));
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
}
