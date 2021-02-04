package ISA.Team54.drugAndRecipe.service.interfaces;

import java.util.List;

import ISA.Team54.drugAndRecipe.model.Drug;

public interface DrugService {
	public List<Drug> getDrugsForPatient(Long id);
}
