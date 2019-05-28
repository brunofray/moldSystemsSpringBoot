package com.projectJob.immobileProject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name= "owner")
public class OwnerEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="owner_id")
	private Long id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="cnpj")
	private String cnpj;
	
	@OneToMany(mappedBy= "owners", cascade= CascadeType.ALL)
	private List<ImmobileEntity> immobile;

	public OwnerEntity() {
		
	}
	
	public OwnerEntity(String name, String cpf, String cnpj) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.cnpj = cnpj;
	}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<ImmobileEntity> getImmobile() {
		return immobile;
	}

	public void setImmobile(List<ImmobileEntity> immobile) {
		this.immobile = immobile;
	}
	
	
	
}
