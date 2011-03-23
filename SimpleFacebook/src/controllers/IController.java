package controllers;

import java.util.HashMap;

import clients.builder.InterfaceBuilder;
import clients.builder.Style;
import clients.builder.Style.Align;

public abstract class IController {
	protected HashMap<String, String> vars = null;
	protected InterfaceBuilder builder = null;

	Object getVar(String name) {
		if (vars == null)
			return null;
		return vars.get(name);
	}
	
	public void setVars(HashMap<String, String> vars) {
		this.vars = vars;
	}
	
	public boolean isLogged() {
		return vars != null && vars.containsKey("userid") && !vars.get("userid").isEmpty();
	}
	
	public int userID() {
		if (!isLogged()) return -1;
		return Integer.parseInt(vars.get("userid"));
	}
	
	public void setBuilder(InterfaceBuilder builder) {
		this.builder = builder;
	}
	
	public InterfaceBuilder getBuilder() {
		return builder;
	}
	
	public HashMap<String, String> getVars() {
		return vars;
	}
	
	public void error(String error) {
		int page = builder.createPage("Error", new Style());
		int p = builder.createParagraph(page, null);
		builder.createText(p, error, new Style().align(Align.CENTER).font("Tahoma", 30).fullwidth());
	}
	
	
	public abstract void operation() throws Exception;
}
