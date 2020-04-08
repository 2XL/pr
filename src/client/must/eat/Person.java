package client.must.eat;

import message.must.serve.Message;

public class Person extends Client {

	public Person() {
		super();
	}

	public Person(String id, String name) {
		super(id, name);
	}

	@Override
	public void setMessage(Message m) {
		lastMessages.add(m);		
	}

}
