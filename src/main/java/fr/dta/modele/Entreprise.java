package fr.dta.modele;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
@Entity
@SequenceGenerator(name = "entrepriseSeq", allocationSize = 100)
public class Entreprise {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entrepriseSeq")
	@Column
	private Long id;
	@Column
	private String nom;
	@OneToMany(mappedBy ="entreprise")
	private List<Employee> listEmploye;

	public Entreprise(String nom, List<Employee> listEmploye) {
		this.nom = nom;
		this.listEmploye = listEmploye;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Employee> getListEmploye() {
		return listEmploye;
	}

	public void setListEmploye(List<Employee> listEmploye) {
		this.listEmploye = listEmploye;
	}

}
