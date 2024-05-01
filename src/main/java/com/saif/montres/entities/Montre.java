package com.saif.montres.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Montre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long idMontre;
	private String nomMontre;
	private Double prixMontre;
	private Date dateCreation;
	
	@ManyToOne
	private Genre genre;
	
	
	public Montre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Montre(String nomMontre, Double prixMontre, Date dateCreation) {
		super();
		this.nomMontre = nomMontre;
		this.prixMontre = prixMontre;
		this.dateCreation = dateCreation;
	}


	public Long getIdMontre() {
		return idMontre;
	}
	public void setIdMontre(Long idMontre) {
		this.idMontre = idMontre;
	}
	public String getNomMontre() {
		return nomMontre;
	}
	public void setNomMontre(String nomMontre) {
		this.nomMontre = nomMontre;
	}
	public Double getPrixMontre() {
		return prixMontre;
	}
	public void setPrixMontre(Double prixMontre) {
		this.prixMontre = prixMontre;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	@Override
	public String toString() {
		return "Montre [idMontre=" + idMontre + ", nomMontre=" + nomMontre + ", prixMontre=" + prixMontre
				+ ", dateCreation=" + dateCreation + "]";
	}


	public Genre getGenre() {
		return genre;
	}


	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	

}
