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

@Entity(name="type_immobile")
public class TypeImmobileEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_type")
	private Long id;
	
	@Column(name="description")
	private String description;
	
	@ManyToMany
	@JoinTable(
			name="TB_IMMOBILE_X_TYPE",
			joinColumns=@JoinColumn(name="id_type", referencedColumnName="id_type"),
			inverseJoinColumns=@JoinColumn(name="id_immobile", referencedColumnName="id_immobile")
			)
	private List<ImmobileEntity> immobile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ImmobileEntity> getImmobile() {
		return immobile;
	}

	public void setImmobile(List<ImmobileEntity> immobile) {
		this.immobile = immobile;
	}
	
	
}
