package mz.co.basse.beans;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import mz.co.basse.cattlecore.managers.CattleManager;
import mz.co.basse.cattlecore.managers.CattleManagerImp;
import mz.co.basse.cattlecore.models.Coral;

@ManagedBean
public class AddCoralView {

	private String localizacaoTxt;
	private String codigoTxt;
	private CattleManager cattleManager = new CattleManagerImp();

	public String getLocalizacaoTxt() {
		return localizacaoTxt;
	}

	public void setLocalizacaoTxt(String localizacaoTxt) {
		this.localizacaoTxt = localizacaoTxt;
	}

	public String getCodigoTxt() {
		return codigoTxt;
	}

	public void setCodigoTxt(String codigoTxt) {
		this.codigoTxt = codigoTxt;
	}

	public void addCoral() {
		System.out.println(localizacaoTxt);
		System.out.println(codigoTxt);

		if (localizacaoTxt != null && !localizacaoTxt.isEmpty() && codigoTxt != null && !codigoTxt.isEmpty()) {
			Coral coral = new Coral();
			coral.setCode(codigoTxt);
			coral.setLocalizacao(localizacaoTxt);
			cattleManager.createCoral(coral);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Coral adicionado com sucesso"));
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			try {
				ec.redirect(ec.getRequestContextPath() + "/dashboard.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na inserção de dados!", "Insira a informação em todos os campos"));
		}
	}

}
