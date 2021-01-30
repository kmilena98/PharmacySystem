package ISA.Team54.drugOrdering.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import ISA.Team54.drugOrdering.enums.OrderStatus;
import ISA.Team54.users.model.PharmacyAdministrator;

@Entity
@Table(name="orders")
public class DrugsOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private Date dealine;
	
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Offer> offers;
	
	@Enumerated
	private OrderStatus status;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private PharmacyAdministrator administrator;

}
