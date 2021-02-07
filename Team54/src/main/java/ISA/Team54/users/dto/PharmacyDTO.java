package ISA.Team54.users.dto;

public class PharmacyDTO {
	
	private String name;
	private String address;
	private String city;
	private String country;
	
	public PharmacyDTO() {
		super();
	}
	
	public PharmacyDTO(String name, String address,String city,String country) {
		super();
		
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
