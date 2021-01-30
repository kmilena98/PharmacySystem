package ISA.Team54.drugOrdering.model;

import javax.persistence.*;

public class DrugInOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//private Drug drug;
	
	private int quantity;
	
	private DrugsOrder order;
}
