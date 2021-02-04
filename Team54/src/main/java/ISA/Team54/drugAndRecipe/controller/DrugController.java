package ISA.Team54.drugAndRecipe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team54.drugAndRecipe.dto.DrugDTO;
import ISA.Team54.drugAndRecipe.mapper.DrugMapper;
import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.service.interfaces.DrugService;

@RestController
@RequestMapping(value = "/drugs", produces = MediaType.APPLICATION_JSON_VALUE)
public class DrugController {
	@Autowired
	private DrugService drugService;
	
	@GetMapping("forPatient/{patientId}")
	//@PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
	public List<DrugDTO> drugsForPatient(@PathVariable int patientId){
		List<DrugDTO> drugsForPatient = new ArrayList<DrugDTO>();
		for(Drug drug : drugService.getDrugsForPatient((long) patientId)) {
			drugsForPatient.add(new DrugMapper().DrugIntoDrugDTO(drug));
		}
		return drugsForPatient;
	}
}
