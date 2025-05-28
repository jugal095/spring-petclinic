package org.springframework.samples.petclinic.pettype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pettype.model.PetTypeAttributes;
import org.springframework.samples.petclinic.pettype.repository.PetTypeAttributesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PetTypeAttributesServiceImpl implements PetTypeAttributesService {

	@Autowired
	private PetTypeAttributesRepository attributesRepository;

	@Transactional
	public PetTypeAttributes save(PetTypeAttributes attributes) {
		return attributesRepository.save(attributes);
	}

	@Transactional(readOnly = true)
	public PetTypeAttributes findByPetTypeId(Integer petTypeId) {
		return attributesRepository.findByPetTypeId(petTypeId);
	}

	@Transactional
	public void delete(Integer id) {
		attributesRepository.deleteById(id);
	}
}
