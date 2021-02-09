package ISA.Team54.drugAndRecipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team54.drugAndRecipe.dto.ContraindicationDTO;
import ISA.Team54.drugAndRecipe.mapper.ContraindicationMapper;
import ISA.Team54.drugAndRecipe.model.Contraindication;
import ISA.Team54.drugAndRecipe.service.interfaces.ContraindicationService;

@RestController
@RequestMapping(value = "/contraindications", produces = MediaType.APPLICATION_JSON_VALUE)
public class ContraindicationControler {
	@Autowired
	private ContraindicationService contraindicationService;
	
	@PostMapping("/addIngredient")
	@PreAuthorize("hasRole('SYSTEM_ADMIN')")
	public  ResponseEntity<Contraindication> addDrug(@RequestBody ContraindicationDTO contraindicationDTO){
		return new ResponseEntity<>(contraindicationService.addContraindication(ContraindicationMapper.ContraindicationDTOToContraindication(contraindicationDTO)), HttpStatus.OK);	
	}
}
