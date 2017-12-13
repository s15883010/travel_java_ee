package ch.hevs.businessobject;

import javax.persistence.*;


@Entity
//@Table(name="Airport")
@Inheritance(strategy = InheritanceType.JOINED)

public class Airport {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="iata")
	private String iata;

	// relations
	@OneToMany
	private Flight flight;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public Airport() {
	}
	public Airport(String name, String iata) {

	}

	@PostPersist
	public void acknowledgePersist() {
		System.out.println("account persisted!!!");
	}
}
