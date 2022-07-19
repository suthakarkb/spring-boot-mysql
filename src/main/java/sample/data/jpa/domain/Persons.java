package sample.data.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Persons implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="id_generator", sequenceName="id_sequence", initialValue = 101)
	@GeneratedValue(generator = "id_generator")
	private Long personid;

	@Column(nullable = true)
	private String lastname;
	
	@Column(nullable = true)
	private String firstname;	
	
	@Column(nullable = true)
	private String address;
	
	@Column(nullable = true)
	private String city;	
	
	public Long getPersonid() {
		return personid;
	}
	public void setPersonid(Long personid) {
		this.personid = personid;
	}

	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getName() {
		return this.firstname+" "+this.lastname;
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
		

	@Override
	public String toString() {
		return getPersonid() + "," + getName()+ "," + getCity();
	}

	protected Persons() {
	}

	public Persons(String name, String city) {
		super();
		this.firstname = name;
		this.city = city;
	}	

}
