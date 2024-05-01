package com.saif.montres.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


@Entity
public class Genre {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 

	private Long idGen;
	private String nomGen;
	private String descriptionGen;
	
	@OneToMany(mappedBy = "genre")
	@JsonIgnore

	
	private List<Montre> montres;

	
	public Genre() {
		super();
	}
	public Long getIdGen() {
		return idGen;
	}
	public void setIdGen(Long idGen) {
		this.idGen = idGen;
	}
	public String getNomGen() {
		return nomGen;
	}
	public void setNomGen(String nomGen) {
		this.nomGen = nomGen;
	}
	public String getDescriptionGen() {
		return descriptionGen;
	}
	public void setDescriptionGen(String descriptionGen) {
		this.descriptionGen = descriptionGen;
	}
	public List<Montre> getMontres() {
		return montres;
	}
	public void setMontres(List<Montre> montres) {
		this.montres = montres;
	}
	

}
