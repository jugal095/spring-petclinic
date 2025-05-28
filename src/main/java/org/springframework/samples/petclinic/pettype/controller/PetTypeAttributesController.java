package org.springframework.samples.petclinic.pettype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.pettype.model.PetTypeAttributes;
import org.springframework.samples.petclinic.pettype.service.PetTypeAttributesService;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/pet-type-attributes")
public class PetTypeAttributesController {

	private final PetTypeAttributesService attributesService;

	@Autowired
	public PetTypeAttributesController(PetTypeAttributesService attributesService) {
		this.attributesService = attributesService;
	}

	@PostMapping
	public ResponseEntity<PetTypeAttributes> createPetTypeAttributes(@Valid @RequestBody PetTypeAttributes attributes) {
		PetTypeAttributes savedAttributes = attributesService.savePetTypeAttributes(attributes);
		return ResponseEntity.ok(savedAttributes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<PetTypeAttributes>> getPetTypeAttributes(@PathVariable Integer id) {
		PetTypeAttributes attributes = attributesService.findById(id);
		EntityModel<PetTypeAttributes> resource = EntityModel.of(attributes);
		resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PetTypeAttributesController.class)
			.getPetTypeAttributes(id)).withSelfRel());
		resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PetTypeAttributesController.class)
			.getAttributesByPetType(attributes.getPetType().getId())).withRel("petTypeAttributes"));
		return ResponseEntity.ok(resource);
	}

	@GetMapping("/pet-type/{petTypeId}")
	public ResponseEntity<List<PetTypeAttributes>> getAttributesByPetType(@PathVariable Integer petTypeId) {
		List<PetTypeAttributes> attributes = (List<PetTypeAttributes>) attributesService.findByPetTypeId(petTypeId);
		return ResponseEntity.ok(attributes);
	}
}
