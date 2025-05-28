package org.springframework.samples.petclinic.pettype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.pettype.model.PetTypeAttributes;

public interface PetTypeAttributesRepository extends JpaRepository<PetTypeAttributes, Integer> {
	PetTypeAttributes findByPetTypeId(Integer petTypeId);
}
