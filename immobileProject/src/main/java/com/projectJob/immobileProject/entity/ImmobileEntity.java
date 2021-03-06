package com.projectJob.immobileProject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name= "immobile")
public class ImmobileEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5915372342858662079L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_immobile")
	private Long id;
	
	@Column(name="cep", length=9, nullable=false)
	@NotBlank(message = " Cep é uma informação obrigatória.")
	private String cep;
	
	@Column(name="street", nullable=false)
	@NotBlank(message = " Rua é uma informação obrigatória.")
	private String street;
	
	@Column(name="number", length=4, nullable=false)
	@NotNull(message = " Número é uma informação obrigatória.")
	private Integer number;
	
	// BAIRRO
	@Column(name="neighborhood", nullable=false)
	@NotBlank(message = " Bairro é uma informação obrigatória.")
	private String neighborhood;
	
	@Column(name="complement")
	private String complement;
	
	@Column(name="city", nullable=false)
	@NotBlank(message = " Cidade é uma informação obrigatória.")
	private String city;
	
	@Column(name="state", nullable=false)
	@NotBlank(message = " Estado é uma informação obrigatória.")
	private String state;
	
	private String types;
	
	@Column(name="price", nullable=false)
	@NotBlank(message = " Preço é uma informação obrigatória.")
	private String price;

	@JoinColumn(name= "owner_id", nullable = false,
			foreignKey = @ForeignKey(value= ConstraintMode.CONSTRAINT, name = "owner_fk"))
	@ManyToOne
	private OwnerEntity owners;

	public ImmobileEntity() {
		
	}
	
	public ImmobileEntity(Long id, String cep, String street, Integer number, String neighborhood, String complement, String city, String state, String types, String price, OwnerEntity owners) {
		super();
		this.id = id;
		this.cep = cep;
		this.street = street;
		this.number = number;
		this.neighborhood = neighborhood;
		this.complement = complement;
		this.city = city;
		this.state = state;
		this.types = types;
		this.price = price;
		this.owners = owners;
	}
	
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

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
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


	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public OwnerEntity getOwners() {
		return owners;
	}

	public void setOwners(OwnerEntity owners) {
		this.owners = owners;
	}

	

	
}
