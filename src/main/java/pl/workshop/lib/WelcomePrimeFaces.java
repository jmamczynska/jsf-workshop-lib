package pl.workshop.lib;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class WelcomePrimeFaces implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private String password;
	
	public String login() {
		return "welcome";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
