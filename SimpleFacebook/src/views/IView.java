package views;

import java.util.HashMap;

import controllers.IController;

import clients.builder.InterfaceBuilder;

public abstract class IView {
	protected HashMap<String, String> vars = null;
	protected InterfaceBuilder b = null;
	protected IController controller;

	Object getVar(String name) {
		if (vars == null)
			return null;
		return vars.get(name);
	}

	public void setVars(HashMap<String, String> vars) {
		this.vars = vars;
	}

	public IView(IController controller) {
	    this.controller = controller;
	    this.vars = controller.getVars();
		this.b = controller.getBuilder();	
	}

	public void setBuilder(InterfaceBuilder builder) {
		this.b = builder;
	}

	public InterfaceBuilder getBuilder() {
		return b;
	}
}
