package ISA.Team54.Examination.dto;

import java.time.LocalDateTime;

public class DefinedExaminationDTO {
	private LocalDateTime examinationStart;
	private int price;
	public DefinedExaminationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DefinedExaminationDTO(LocalDateTime examinationStart, int price) {
		super();
		this.examinationStart = examinationStart;
		this.price = price;
	}
	public LocalDateTime getExaminationStart() {
		return examinationStart;
	}
	public void setExaminationStart(LocalDateTime examinationStart) {
		this.examinationStart = examinationStart;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
