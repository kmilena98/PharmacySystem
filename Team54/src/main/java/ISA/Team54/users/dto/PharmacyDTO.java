package ISA.Team54.users.dto;

public class PharmacyDTO {
	
	private long id;
	private String name;
	private String address;
	private String description;
	private double rating;
	private double pharmacistPrice;	
	
	public PharmacyDTO() {
		super();
	}
	
	public PharmacyDTO(long id, String name, String address, String description, double rating, double pharmacistPrice) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.rating = rating;
		this.pharmacistPrice = pharmacistPrice;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getRating() {
		return rating;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public double getPharmacistPrice() {
		return pharmacistPrice;
	}
	
	public void setPharmacistPrice(double pharmacistPrice) {
		this.pharmacistPrice = pharmacistPrice;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
}
