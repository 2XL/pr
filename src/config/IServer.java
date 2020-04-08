package config;

import java.util.List;

import message.must.serve.Message;
import client.must.eat.Client;
import client.must.eat.Person;



public interface IServer {

	public String addClient(Client c);

	public String removeClient(Client c);

	public String setMessage(Message m);

	public List<Message> getLastMessages(Person p);

	public List<Message> getListMessages(Person p);

}
