package fr.dta.modele;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import fr.dta.repository.IoEntity;


@Entity
@SequenceGenerator(name = "employeeSeq", allocationSize = 100)
public class Employee implements IoEntity {

	private static final long serialVersionUID = -4575099570218633956L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeSeq")
	@Column
	private Long id;
	
	@Column
	private String prenom;
	
	@Column
	private String nomFamille;
	
	@Column
	private String secuSocial;
	
	@Column
	private BigDecimal salaire;
	
	@Column
	private LocalDate dateEmbauche;
	
	@ManyToOne
	private Entreprise entreprise;
	

	/* Constructeur */
	public Employee(String prenom, String nomFamille, String secuSocial, BigDecimal salaire,
			LocalDate dateEmbauche) {
		this.prenom = prenom;
		this.nomFamille = nomFamille;
		this.secuSocial = secuSocial;
		this.salaire = salaire;
		this.dateEmbauche = dateEmbauche;
	}

	public Employee() {
	}

	/* Getters&Setters */
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

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
