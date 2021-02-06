package ISA.Team54.drugAndRecipe.mapper;

import ISA.Team54.drugAndRecipe.dto.DrugSpecificationDTO;
import ISA.Team54.drugAndRecipe.model.DrugSpecification;

public class DrugSpecificationMapper {

	public DrugSpecificationDTO DrugSpecificationIntoDrugSpecificationDTO(DrugSpecification drugSpecification) {
		return new DrugSpecificationDTO(drugSpecification.getContraindications(),drugSpecification.getIngredients(),drugSpecification.getSuggestedDose());
	}
}
