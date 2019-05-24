package com.projectMoldSystems.immobile.model;

import java.util.List;

import com.projectMoldSystems.immobile.entity.OwnerEntity;



public class ImmobileModel {
	
	private Long id;
	private String cep;
	private String street;
	private int number;
	private int complement;
	private String neighborhood;
	private String city;
	private String state;
	private List<Long> types;
	private double price;
	private List<Long> owners;

	public ImmobileModel() {
		
	}
	public ImmobileModel(Long id, String cep, String street, int number, int complement, String neighborhood, String city, String state, List<Long> types, double price, List<Long> owners) {
		super();
		this.id = id;
		this.cep = cep;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.neighborhood = neighborhood;
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

	public List<Long> getTypes() {
		return types;
	}

	public void setTypes(List<Long> types) {
		this.types = types;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public List<Long> getOwners() {
		return owners;
	}
	public void setOwners(List<Long> owners) {
		this.owners = owners;
	}
	
	
}
