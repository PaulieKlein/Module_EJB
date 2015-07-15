package com.bankonet.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Modelise un client de bankonet.
 *
 * <p>Un client est caracterise par :
 * <ul>
 * <li> son identifiant unique
 * <li> son nom
 * <li> son prenom
 * <li> la liste de ses comptes
 * </ul>
 *
 * @author Sysdeo (c) 
 */
@Entity

public class Client implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int identifiant;
	@Column(name="NOM")
	private String nom;
	@Column(name="PRENOM")
	private String prenom;
	@Column(name="LOGIN")
	private String login;
	


	


	@Column(name="MOTDEPASSE")
	private String password;


	/**
	 * @param nom
	 * @param prenom
	 * @param identifiant
	 */
	
	public Client(){}
	
	public Client( String nom, String prenom,String login, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}


	/**
	 * Retourne la liste des comptes courants du client (de taille 0 si pas de comptes courants).
	 * 
	 *
	 * @return List
	 */
	
	public int getIdentifiant() {
		return identifiant;
	}
	/**
	 * Retourne le nom du client.
	 *
	 * @return java.lang.String
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Retourne le prenom du client.
	 * 
	 * @return java.lang.String
	 */
	public String getPrenom() {
		return prenom;
	}
	
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
}
