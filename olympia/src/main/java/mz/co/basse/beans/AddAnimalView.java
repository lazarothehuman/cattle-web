package mz.co.basse.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import mz.co.basse.cattlecore.managers.CattleManager;
import mz.co.basse.cattlecore.managers.CattleManagerImp;
import mz.co.basse.cattlecore.models.Coral;

@ManagedBean
public class AddAnimalView {
	
	private CattleManager cattleManager = new CattleManagerImp();

	private List<Coral> corais;
	private Coral selectedCoral;
	private String pesoTxt;
	private String alturaTxt;
	private String codeTxt;
	//private List<Tipo>
	
	@PostConstruct
	public void init() {
		corais = cattleManager.findCorais(Boolean.TRUE);
	}

	public Coral getSelectedCoral() {
		return selectedCoral;
	}

	public void setSelectedCoral(Coral selectedCoral) {
		this.selectedCoral = selectedCoral;
	}

	public List<Coral> getCorais() {
		return corais;
	}

	public void setCorais(List<Coral> corais) {
		this.corais = corais;
	}

	public String getPesoTxt() {
		return pesoTxt;
	}

	public void setPesoTxt(String pesoTxt) {
		this.pesoTxt = pesoTxt;
	}

	public String getAlturaTxt() {
		return alturaTxt;
	}

	public void setAlturaTxt(String alturaTxt) {
		this.alturaTxt = alturaTxt;
	}
	
	public String getCodeTxt() {
		return codeTxt;
	}

	public void setCodeTxt(String codeTxt) {
		this.codeTxt = codeTxt;
	}

	public void addAnimal() {
		
	}

}
