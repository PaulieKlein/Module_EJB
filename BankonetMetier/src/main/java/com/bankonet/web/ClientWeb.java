package com.bankonet.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;






import com.bankonet.service.ClientService;
import com.bankonet.model.Client;


/**
 * Servlet implementation class ClientWeb
 */
@WebServlet("/clients")
public class ClientWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

 @EJB private ClientService clientService; 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter w = response.getWriter();
		w.print("<h1> Bienvenue sur Bankonet !!</h1>");
		w.print("</br>les clients de Bankonet: </br></br>");
		w.print("<table border='1' style='border-collapse: collapse'>");
		w.print("<tr>");
		w.print("<th> Identifiant </th>");
		w.print("<th> Nom </th>");
		w.print("<th> Prénom </th>");
		w.print("</tr>");
		
		 //ClientService clientService = new ClientService();
	      for(Client client : (List<Client>) clientService.findAll()){
	    	  w.print("<tr>");
	    	  w.print("<td> "+client.getIdentifiant()+" </td><td> "+client.getNom()+" </td><td> "+client.getPrenom()+" </td>");
	    	  w.print("</tr>");
	      }
	      
	      w.print("</table>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		clientService.createClient(nom,prenom ,login,password);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id")) ;	
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		clientService.modifClient(id,nom,prenom ,login,password);
		
		/*try (BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()))){
			String data = br.readLine();
			Client client = new Client();
			String[] params = data.split("&");
			for(String param : params){
				String[] keyValue = param.split("=");
				switch(keyValue[0]){
				case "password" : client.setPassword(keyValue[1]);break;
				case "login" : client.setLogin(keyValue[1]);break;
				case "prenom" : client.setPrenom(keyValue[1]);break;
				case "nom" : client.setNom(keyValue[1]);break;
				case "id" : client.setIdentifiant(Integer.valueOf(keyValue[1]));break;
				}
			}
			clientService.updateClient(client);
		}*/
	}

	
}
