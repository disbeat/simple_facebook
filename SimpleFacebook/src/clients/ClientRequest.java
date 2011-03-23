package clients;

import java.io.Serializable;
import java.util.HashMap;

public class ClientRequest implements Serializable {
	private static final long serialVersionUID = 4195173034106974210L;
	private String action;
	private HashMap<String, String> vars;

	public ClientRequest(String action, HashMap<String, String> vars) {
		this.action = action;
		this.vars = vars;
	}

	public String getAction() {
		return action;
	}
	
	public HashMap<String, String> getVars() {
		return vars;
	}
}
