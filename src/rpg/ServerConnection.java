package rpg;

import java.net.URLConnection;
import java.io.*;
import java.net.URL;

public class ServerConnection {
	private URLConnection connection;
	private final String url = "";
	private final String charset = java.nio.charset.StandardCharsets.UTF_8.name();
	public ServerConnection() throws IOException
	{
		connection = new URL(url).openConnection();
		connection.setDoOutput(true);
	}
	public String loginRequest()
	{
		return "";
	}
	
	
}
