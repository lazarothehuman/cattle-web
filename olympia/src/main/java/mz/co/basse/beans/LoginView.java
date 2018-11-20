package mz.co.basse.beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import mz.co.basse.cattlecore.managers.AccessControlManager;
import mz.co.basse.cattlecore.managers.AccessControlManagerImp;
import mz.co.basse.cattlecore.models.User;


@ManagedBean
public class LoginView {
	
	private AccessControlManager accessControlManager = new AccessControlManagerImp();

	private String user;
	private String passe;

	public LoginView() {

	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPasse() {
		return passe;
	}

	public void setPasse(String passe) {
		this.passe = passe;
	}

	public void aceder() {
		User selectedUser = accessControlManager.findUser(user);
		if(selectedUser!=null) {
			System.out.println("Name: "+selectedUser.getName());
			if(selectedUser.getPassword().equals(passe))
				System.out.println();
		}else {
			System.out.println("Not null");
		}
		/*
		 * User findUser = accessControlManager.findUser(this.user.getLogin());
		 * if(findUser!=null) { System.out.println("Is not null"); }else {
		 * System.out.println("Is null"); }
		 */

		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect(ec.getRequestContextPath() + "/view-corais.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
