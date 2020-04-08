package config;
 

import message.must.serve.Message;
import client.must.eat.Client;
import client.must.eat.Group;
import client.must.eat.Person;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class XStreamFactory {

	public static XStream getXStream(){
		XStream xStream = new XStream(new XppDriver());
		xStream.alias("IServer", IServer.class);
		xStream.alias("Message", Message.class);
		xStream.alias("Client", Client.class);
		xStream.alias("Person", Person.class);
		xStream.alias("Group", Group.class);
		xStream.alias("Request", Request.class);
		xStream.alias("Response", Response.class);
		return xStream;
	}
	
	public static XStream getXStreamJson(){
		XStream xStream = new XStream(new JsonHierarchicalStreamDriver());
		xStream.setMode(XStream.NO_REFERENCES);
		xStream.alias("IServer", IServer.class);
		xStream.alias("Message", Message.class);
		xStream.alias("Client", Client.class);
		xStream.alias("Person", Person.class);
		xStream.alias("Group", Group.class);
		xStream.alias("Request", Request.class);
		xStream.alias("Response", Response.class);
		return xStream;
	}
}
