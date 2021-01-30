package ISA.Team54.users.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

import javax.persistence.CascadeType;
import javax.persistence.Column;


@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
public abstract class User {
	@Id
	@SequenceGenerator(name = "mySeqGen1", sequenceName = "mySeq1",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGen1")
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Email email;
	
	@Column(unique = false, nullable = false)
	private String password;
	@Column(unique = false, nullable = false)
	private String name;
	@Column(unique = false, nullable = false)
	private String surname;
	@Column(unique = false,nullable = true)
	private String address;
	@Column(unique = false,nullable = true)
	private String city;
	@Column(unique = false,nullable = true)
	private String country;
	@Column(unique = false,nullable = true)
	private String phoneNumber;	
	
	public User() {
		super();
	}

	public User(long id, Email email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	
}
