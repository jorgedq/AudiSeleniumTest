package com.auditoriaEvaluacionData;

import java.util.ArrayList;

public class Data {
	
	private Data() {
		
		nameUser = "prueba final";
		
		emailUser = "final@gmail.com";
		
		passwordUser = "final12345";
		
		cardsList = new ArrayList();
		
		cardsList.add(new Card("Ninguno", "Tarea 1:" + nameUser, "esta es la descripcion de la tarea 1"));
		
		cardsList.add(new Card("Normal", "Tarea 2:" + nameUser, "esta es la descripcion de la tarea 2"));
		
		cardsList.add(new Card("Importante", "Tarea 3:" + nameUser, "esta es la descripcion de la tarea 3"));
		
		cardsList.add(new Card("Muy Importante", "Tarea 4:" + nameUser, "esta es la descripcion de la tarea 4"));
	}
	
	public static Data getDataInstance() {
		
		if(instance == null) {
			
			instance = new Data();
		
		}
		
		return instance;
		
	}
	
	public String getNameUser() {
		
		return nameUser;
	
	}

	public void setNameUser(String nameUser) {
	
		this.nameUser = nameUser;
	
	}

	public String getEmailUser() {
	
		return emailUser;
	
	}

	public void setEmailUser(String emailUser) {
	
		this.emailUser = emailUser;
	
	}

	public String getPasswordUser() {
	
		return passwordUser;
	
	}

	public void setPasswordUser(String passwordUser) {
	
		this.passwordUser = passwordUser;
	
	}

	public ArrayList<Card> getCardsList() {
	
		return cardsList;
	
	}

	public void setCardsList(ArrayList<Card> cardsList) {
	
		this.cardsList = cardsList;
	
	}
	
	private static Data instance;
	
	private String nameUser;
	
	private String emailUser;
	
	private String passwordUser;
	
	private ArrayList<Card> cardsList;
	
}
