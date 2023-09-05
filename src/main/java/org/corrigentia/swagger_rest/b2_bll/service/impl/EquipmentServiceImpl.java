package org.corrigentia.swagger_rest.b2_bll.service.impl;

import java.util.List;
import java.util.Optional;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.EquipmentEntity;
import org.corrigentia.swagger_rest.a0_dal.repo.EquipmentRepository;
import org.corrigentia.swagger_rest.a0_dal.repo.InstructorRepository;
import org.corrigentia.swagger_rest.a0_dal.repo.MartialArtistRepository;
import org.corrigentia.swagger_rest.a0_dal.repo.StudentRepository;
import org.corrigentia.swagger_rest.a0_dal.repo.UserRepository;
import org.corrigentia.swagger_rest.b2_bll.service.EquipmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jakarta.ws.rs.NotFoundException;

@Service
public class EquipmentServiceImpl implements EquipmentService {

	private final EquipmentRepository equipmentRepository;

	public EquipmentServiceImpl(final EquipmentRepository equipmentRepository,
			final StudentRepository studentRepository, final InstructorRepository instructorRepository,
			final MartialArtistRepository martialArtistRepository, final UserRepository userRepository) {
		this.equipmentRepository = equipmentRepository;
	}

	@Override
	public List<EquipmentEntity> findAll() {
		// TODO Auto-generated method stub
		return this.equipmentRepository.findAll();
	}

	@Override
	public Page<EquipmentEntity> findAll(final int page, final int size) {
		return this.equipmentRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Optional<EquipmentEntity> findOneById(final long id) {
		return this.equipmentRepository.findById(id);
	}

	/**
	 * @param entity
	 */
	@Override
	public void insert(final EquipmentEntity entity) {
		this.equipmentRepository.save(entity);
	}

	@Override
	public EquipmentEntity update(final long id, final EquipmentEntity entity) {
		// TODO Auto-generated method stub
		final EquipmentEntity toUpdate = this.equipmentRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Equipment id=" + id + " not found"));
		toUpdate.setPrice(entity.getPrice());
		toUpdate.setName(entity.getName());

		this.equipmentRepository.save(toUpdate);

		return toUpdate;

//        return Optional.empty();
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
