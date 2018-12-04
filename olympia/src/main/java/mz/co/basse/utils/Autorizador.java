package mz.co.basse.utils;

import java.io.IOException;

import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import mz.co.basse.cattlecore.models.User;

public class Autorizador implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.println();
		
		FacesContext facesContext = event.getFacesContext();
		String nomePagina = facesContext.getViewRoot().getViewId();
		if("/login.xhtml".equals(nomePagina))
			return;
		User user = (User) facesContext.getExternalContext().getSessionMap().get("userLogado");
		if (user != null) {
			return;
		}
		
		NavigationHandler handler = facesContext.getApplication().getNavigationHandler();
		handler.handleNavigation(facesContext, null, "/login?faces-redirect=true");
		facesContext.renderResponse();
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.RESTORE_VIEW;
	}

}
