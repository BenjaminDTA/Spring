package fr.dta.modele;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
	private Long id;
	private String prenom;
	private String nomFamille;
	private String secuSocial;
	private BigDecimal salaire;
	private LocalDate dateEmbauche;
	
	
	/*Constructeur*/
	public Employee(Long id, String prenom, String nomFamille, String secuSocial, BigDecimal salaire,
			LocalDate dateEmbauche) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nomFamille = nomFamille;
		this.secuSocial = secuSocial;
		this.salaire = salaire;
		this.dateEmbauche = dateEmbauche;
	
	}
	
	public Employee() {}
	
	/*Getters&Setters*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNomFamille() {
		return nomFamille;
	}
	public void setNomFamille(String nomFamille) {
		this.nomFamille = nomFamille;
	}
	public String getSecuSocial() {
		return secuSocial;
	}
	public void setSecuSocial(String secuSocial) {
		this.secuSocial = secuSocial;
	}
	public BigDecimal getSalaire() {
		return salaire;
	}
	public void setSalaire(BigDecimal salaire) {
		this.salaire = salaire;
	}
	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(LocalDate dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	
	
}
