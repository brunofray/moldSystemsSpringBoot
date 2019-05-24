package com.projectMoldSystems.immobile.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name= "owner")
public class OwnerEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_owner")
	private Long id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="cnpj")
	private String cnpj;
	
	@ManyToMany
	@JoinTable(
			name="TB_IMMOBILE_X_OWNER",
			joinColumns=@JoinColumn(name="id_owner", referencedColumnName="id_owner"),
			inverseJoinColumns=@JoinColumn(name="id_immobile", referencedColumnName="id_immobile")
			)
	private List<ImmobileEntity> immobile;

	public OwnerEntity() {
		super();
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
