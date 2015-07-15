package com.bankonet.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bankonet.model.*;
@Stateless
public class ClientService {
	
@PersistenceContext(unitName="Clients")private EntityManager em;

	public ClientService(){}
	
	public List<Client> findAll(){

	    
	    List<Client> clients = new ArrayList<Client>();
	    try{
			      String texteQuery1 = "Select c From Client as c";
			      Query query1 = em.createQuery(texteQuery1);
			      clients = (List<Client>) query1.getResultList();
			     
	    	} catch(Exception e){
	    		e.printStackTrace();
	    		
	    		
	    	} 
	    return clients;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createClient (String nom,String prenom,String login,String password){
		try{
	
			Client client = new Client(nom,prenom,login,password);
			em.persist(client);
			
		}catch(Exception e){
    		e.printStackTrace();
    	} 
		
	}
	
	public void modifClient(int id, String nom,String prenom,String login,String password){
	Client c = 	em.find(Client.class, id);
		if(c!=null){
			
			c.setNom(nom);
			c.setPrenom(prenom);
			c.setLogin(login);
			c.setPassword(password);

		}else{System.out.println("Ce client n'exite pas");}
		
	}
	
	public void updateClient(Client client){
		Client c = 	em.find(Client.class, client.getIdentifiant());
		if(c!=null){
			
			c.setNom(client.getNom());
			c.setPrenom(client.getPrenom());
			c.setLogin(client.getLogin());
			c.setPassword(client.getPassword());

		}else{System.out.println("Ce client n'exite pas");}
		
	}
}
