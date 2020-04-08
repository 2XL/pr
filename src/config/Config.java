package config;

import java.io.InputStream;
import java.util.Properties;

import android.view.View;

import com.pcrigger.thelastemperior.R;





public class Config {

	private static Config instance = null;

	private Properties config = null;

	private String protocol, serverside;
	private static String url = "http://tap-server.appspot.com/tapserver";

	private ServerFactory serverFactory;

	protected Config(View v) throws Exception {
		InputStream in = v.getResources().openRawResource(R.raw.appproperties);

		// Load Properties
		config = new Properties();
		config.load(in);

		// Choose the protocol: either xml or json
		protocol = config.getProperty("comm.protocol", "xml");
		protocol = protocol.substring(0, 1).toUpperCase().concat(protocol.substring(1).toLowerCase());

		// Get information about serverside and which url we'll use
		serverside = config.getProperty("server.type", "local").trim();
		url = config.getProperty("server.host." + serverside);

		// Create a new serverFactory using the protocol choosed in the step
		// before
		String prefix = protocol.toLowerCase() + ".".concat(protocol);
		String classname = prefix.concat("ServerFactory");
		serverFactory = (ServerFactory) Class.forName(classname).newInstance();
	}

	public static Config getConfig(View v) throws Exception {
		if (instance == null) {
			instance = new Config(v);
		}
		return instance;
	}

	public IServer getServer() {
		return serverFactory.getServer();
	}

	public String getProtocol() {
		return protocol;
	}

	public String getServerside() {
		return serverside;
	}

	public static String getUrl() {
		return url;
	}

}
