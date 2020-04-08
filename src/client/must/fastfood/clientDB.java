package client.must.fastfood;

import java.util.LinkedList;

import client.must.eat.*;;

public class clientDB {

	private LinkedList<Client> clientList;

	public clientDB() {

		clientList = new LinkedList<Client>();
		this.clientList = null;
	}
	
	public void addClientDB(Client c){
		clientList.add(c);
	}

}
