package com.projectMoldSystems.immobile.entity;

import java.security.acl.Owner;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name= "immobile")
public class ImmobileEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_immobile")
	private Long id;
	
	@Column(name="cep", nullable=false)
	private String cep;
	
	@Column(name="street", nullable=false)
	private String street;
	
	@Column(name="number", nullable=false)
	private int number;
	
	@Column(name="complement")
	private int complement;
	
	// BAIRRO
	@Column(name="neighborhood", nullable=false)
	private String neighborhood;
	
	@Column(name="city", nullable=false)
	private String city;
	
	@Column(name="state", nullable=false)
	private String state;
	
	@JoinTable(
			name="TB_IMMOBILE_X_TYPE",
			joinColumns=@JoinColumn(name="ID_IMMOBILE", referencedColumnName="ID_IMMOBILE"),
			inverseJoinColumns=@JoinColumn(name="ID_TYPE", referencedColumnName="ID_TYPE")
			)
	@ManyToMany(cascade ={ CascadeType.PERSIST, CascadeType.MERGE})
	private List<TypeImmobileEntity> type;
	
	@Column(name="price", nullable=false)
	private double price;

	@JoinTable(
			name="TB_IMMOBILE_X_OWNER",
			joinColumns=@JoinColumn(name="ID_IMMOBILE", referencedColumnName="ID_IMMOBILE"),
			inverseJoinColumns=@JoinColumn(name="ID_OWNER", referencedColumnName="ID_OWNER")
			)
	@ManyToMany(cascade ={ CascadeType.PERSIST, CascadeType.MERGE})
	private List<OwnerEntity> owner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getComplement() {
		return complement;
	}

	public void setComplement(int complement) {
		this.complement = complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<TypeImmobileEntity> getType() {
		return type;
	}

	public void setType(List<TypeImmobileEntity> type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<OwnerEntity> getOwner() {
		return owner;
	}

	public void setOwner(List<OwnerEntity> owner) {
		this.owner = owner;
	}



}
