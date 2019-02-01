package fr.dta.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.modele.Employee;
@Transactional
@Service
@Scope("prototype")
public class MailService {

		private String message;


		public void setMessage(String message) {
			this.message = message;
		}
		
		public void sendMail(Employee e) {
			System.out.println("Hello " +e.getNomFamille() +" "+ e.getPrenom()+", tu as reçu un message :" +message);
		}
}