package fr.dta.modele;

import java.util.List;

public class Entreprise {
	private Long id;
	private String nom;
	private List<Employee> listEmploye;
	

	public Entreprise(Long id, String nom, List<Employee> listEmploye) {
		super();
		this.id = id;
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
