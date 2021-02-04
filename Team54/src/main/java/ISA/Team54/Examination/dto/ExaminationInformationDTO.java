package ISA.Team54.Examination.dto;

import java.util.List;

import ISA.Team54.drugAndRecipe.dto.DrugDTO;

public class ExaminationInformationDTO {
	public int id;
	public String diagnosis;
	public List<DrugDTO> drugs;
	public ExaminationInformationDTO() {
		super();
	}
	public ExaminationInformationDTO(int id, String diagnosis, List<DrugDTO> drugs) {
		super();
		this.id = id;
		this.diagnosis = diagnosis;
		this.drugs = drugs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public List<DrugDTO> getDrugs() {
		return drugs;
	}
	public void setDrugs(List<DrugDTO> drugs) {
		this.drugs = drugs;
	}

	
}

