package ISA.Team54.Examination.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Term {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	 @Column(unique = false,nullable = false)
	 private LocalDateTime start;
	 
	 @Column(unique = false,nullable = false)
	 private int duration;
	 
	@OneToMany(mappedBy="term",cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	private List<Examination> examinations = new ArrayList<Examination>();
		
	 
	public Term() {
		super();
	}
	public Term(int id, LocalDateTime start, int duration) {
		super();
		this.id = id;
		this.start = start;
		this.duration = duration;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

