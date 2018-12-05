package org.primefaces.olympia.view;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import mz.co.basse.cattlecore.models.User;

@ManagedBean
@SessionScoped
public class GuestPreferences implements Serializable {

	private String menuMode = "layout-static";

	private String theme = "green-yellow";

	private String menuColor = "layout-menu-light";

	private String topBarColor = "layout-topbar-light";

	private String logo = "logo-olympia";
	
	private User currentUser;

	public User getCurrentUser() {
		return currentUser;
	}
	
	@PostConstruct
	public void init() {
		currentUser= (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userLogado");
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getMenuMode() {
		return this.menuMode;
	}

	public void setMenuMode(String menuMode) {
		this.menuMode = menuMode;
	}

	public String getMenuColor() {
		return this.menuColor;
	}

	public void setMenuColor(String menuColor) {
		this.menuColor = menuColor;
	}

	public String getTopBarColor() {
		return this.topBarColor;
	}

	public void setTopBarColor(String topBarColor, String logo) {
		this.topBarColor = topBarColor;
		this.logo = logo;
	}

	public String getLogo() {
		return this.logo;
	}

	public void addAnimal() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect(ec.getRequestContextPath() + "/AddAnimal.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void viewAnimal() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect(ec.getRequestContextPath() + "/ViewAnimais.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void addCoral() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect(ec.getRequestContextPath() + "/AddCoral.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void viewCoral() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect(ec.getRequestContextPath() + "/view-corais.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addProcedimento() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect(ec.getRequestContextPath() + "/add-procedimento.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void viewProcedimento() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect(ec.getRequestContextPath() + "/view-procedimentos.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void viewAnimais() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect(ec.getRequestContextPath() + "/view-animais.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void modifyAnimal() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect(ec.getRequestContextPath() + "/modify-animal.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void logout(ActionEvent event) {
		System.out.println("Loggin out");
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.getExternalContext().getSessionMap().remove("userLogado");
		NavigationHandler handler = facesContext.getApplication().getNavigationHandler();
		handler.handleNavigation(facesContext, null, "/login?faces-redirect=true");
		facesContext.renderResponse();
		
		
	}
}
