package ISA.Team54.drugAndRecipe.mapper;

import ISA.Team54.drugAndRecipe.dto.ContraindicationDTO;
import ISA.Team54.drugAndRecipe.model.Contraindication;

public class ContraindicationMapper {
	
	public static Contraindication ContraindicationDTOToContraindication(ContraindicationDTO contraindicationDTO) {
		Contraindication contraindication = new Contraindication(contraindicationDTO.getName());
		contraindication.setId(contraindicationDTO.getId());
		return contraindication;
	}
}
