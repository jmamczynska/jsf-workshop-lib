package pl.workshop.lib;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ComponentHelper implements Serializable {

	private static final long serialVersionUID = 1L;

	private String input;
	
	public String save() {
		return "saved";
	}
	
	public String cancel() {
		return "saved";
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

}
