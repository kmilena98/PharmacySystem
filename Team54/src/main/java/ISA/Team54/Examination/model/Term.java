package ISA.Team54.Examination.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Embeddable
public class Term {
	 
	 private LocalDateTime start;
	 
	 private int duration;		
	 
	public Term() {
		super();
	}
	public Term(int id, LocalDateTime start, int duration) {
		super();
		this.start = start;
		this.duration = duration;
	}	
	public LocalDateTime getStart() {
		return start;
	}
	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}	 	 
}

