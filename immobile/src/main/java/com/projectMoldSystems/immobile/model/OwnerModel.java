package com.projectMoldSystems.immobile.model;

public class OwnerModel {

	
	private Long id;
	private String name;
	private String cpf;
	private String cnpj;
	private Boolean checkedOwner;
	
	public OwnerModel() {
		
	}
	
	public OwnerModel(Long id, String name, String cpf) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
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

	public Boolean getCheckedOwner() {
		return checkedOwner;
	}

	public void setCheckedOwner(Boolean checkedOwner) {
		this.checkedOwner = checkedOwner;
	}

	
	
}
