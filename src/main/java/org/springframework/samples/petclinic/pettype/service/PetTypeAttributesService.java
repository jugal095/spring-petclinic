package org.springframework.samples.petclinic.pettype.service;

import org.springframework.samples.petclinic.pettype.model.PetTypeAttributes;

public interface PetTypeAttributesService {

	PetTypeAttributes save(PetTypeAttributes attributes);

	PetTypeAttributes findByPetTypeId(Integer petTypeId);

	void delete(Integer id);
}
