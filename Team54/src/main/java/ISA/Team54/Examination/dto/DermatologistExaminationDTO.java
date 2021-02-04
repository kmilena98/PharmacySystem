package ISA.Team54.Examination.dto;

import java.util.List;

import ISA.Team54.drugAndRecipe.dto.DrugDTO;

	public class DermatologistExaminationDTO {
	private ExaminationDTO soonestExamination;
	private List<ExaminationDTO> historyExaminations;
	private List<DrugDTO> drugsForPatient;
	
	public DermatologistExaminationDTO() {
		super();
	}
	public DermatologistExaminationDTO(ExaminationDTO soonestExamination, List<ExaminationDTO> historyExaminations,
			List<DrugDTO> drugsForPatient) {
		super();
		this.soonestExamination = soonestExamination;
		this.historyExaminations = historyExaminations;
		this.drugsForPatient = drugsForPatient;
	}
	public ExaminationDTO getSoonestExamination() {
		return soonestExamination;
	}
	public void setSoonestExamination(ExaminationDTO soonestExamination) {
		this.soonestExamination = soonestExamination;
	}
	public List<ExaminationDTO> getHistoryExaminations() {
		return historyExaminations;
	}
	public void setHistoryExaminations(List<ExaminationDTO> historyExaminations) {
		this.historyExaminations = historyExaminations;
	}
	public List<DrugDTO> getDrugsForPatient() {
		return drugsForPatient;
	}
	public void setDrugsForPatient(List<DrugDTO> drugsForPatient) {
		this.drugsForPatient = drugsForPatient;
	}


}
