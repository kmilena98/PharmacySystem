package ISA.Team54.drugAndRecipe.service;

import java.util.List;

import ISA.Team54.drugAndRecipe.model.Drug;

public interface IDrugService {
	List<Drug> getAllDrugs();
	Drug findById(long id);
}
