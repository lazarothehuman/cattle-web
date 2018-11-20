package mz.co.basse.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mz.co.basse.cattlecore.managers.CattleManager;
import mz.co.basse.cattlecore.managers.CattleManagerImp;
import mz.co.basse.cattlecore.models.Coral;

@ManagedBean
@ViewScoped
public class CoraisView {

	private List<Coral> corais = new ArrayList<Coral>();

	private Coral selectedCoral;

	CattleManager cattleManager = new CattleManagerImp();

	@PostConstruct
	public void init() {
		corais = cattleManager.findCorais(Boolean.TRUE);
	}

	public List<Coral> getCorais() {
		return corais;
	}

	public void setCorais(List<Coral> corais) {
		this.corais = corais;
	}

	public Coral getSelectedCoral() {
		return selectedCoral;
	}

	public void setSelectedCoral(Coral selectedCoral) {
		this.selectedCoral = selectedCoral;
	}
	
	public void pesquisar() {
		setCorais(cattleManager.findCorais(Boolean.TRUE));		
	}

}
