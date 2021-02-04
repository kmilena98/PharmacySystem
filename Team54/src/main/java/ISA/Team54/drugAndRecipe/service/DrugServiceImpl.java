package ISA.Team54.drugAndRecipe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.model.DrugAllergy;
import ISA.Team54.drugAndRecipe.repository.DrugAllergyRepository;
import ISA.Team54.drugAndRecipe.repository.DrugRepository;
import ISA.Team54.drugAndRecipe.service.interfaces.DrugService;
@Service
public class DrugServiceImpl implements DrugService {

	@Autowired
	private DrugRepository drugRepsoitory;
	
	@Autowired
	private DrugAllergyRepository drugAllergyRepsoitory;
	
	@Override
	public List<Drug> getDrugsForPatient(Long id) {
		List<Drug> drugsForPatient = drugRepsoitory.findAll();
		if(drugsForPatient== null) 
			return new ArrayList<Drug>();
		
		if(drugAllergyRepsoitory.getByPatientId(id)== null)
			return drugsForPatient;
		
		for(DrugAllergy drugAllergy : drugAllergyRepsoitory.getByPatientId(id)) {
			for(Drug drug : drugRepsoitory.findAll()) {
				if(drug.getId() == drugAllergy.getPatient().getId()) {
					drugsForPatient.remove(drug);
				}
			}
			
		}
		return drugsForPatient;
	}
}
