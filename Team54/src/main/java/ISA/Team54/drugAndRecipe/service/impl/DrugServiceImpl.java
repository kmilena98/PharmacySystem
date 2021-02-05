package ISA.Team54.drugAndRecipe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.repository.DrugRepository;
import ISA.Team54.drugAndRecipe.service.IDrugService;

@Service
public class DrugServiceImpl implements IDrugService {
	
	@Autowired
	private DrugRepository drugRepository;

	@Override
	public List<Drug> getAllDrugs() {
		return drugRepository.findAll();
	}

	@Override
	public Drug findById(long id) {
		return drugRepository.findById(id).orElse(null);
	}
	
	
}
