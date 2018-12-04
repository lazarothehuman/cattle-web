package mz.co.basse.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import mz.co.basse.cattlecore.managers.CattleManager;
import mz.co.basse.cattlecore.managers.CattleManagerImp;
import mz.co.basse.cattlecore.models.Animal;
import mz.co.basse.cattlecore.models.Coral;
import mz.co.basse.cattlecore.models.Gado;

@ManagedBean
public class AddAnimalView {
	
	private CattleManager cattleManager = new CattleManagerImp();

	private List<Coral> corais;
	private Coral selectedCoral;
	private String codeTxt;
	private String tipo;
	private Gado selectedTipo;
	private String codePai;
	private String codeMae;
	private String selectedSexo;
	private String selectedClassificacao;
	private String selectedRaca;
	private String cor;
	
	
	//private List<Tipo>
	
	public CattleManager getCattleManager() {
		return cattleManager;
	}

	public void setCattleManager(CattleManager cattleManager) {
		this.cattleManager = cattleManager;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Gado getSelectedTipo() {
		return selectedTipo;
	}

	public void setSelectedTipo(Gado selectedTipo) {
		this.selectedTipo = selectedTipo;
	}

	public String getCodePai() {
		return codePai;
	}

	public void setCodePai(String codePai) {
		this.codePai = codePai;
	}

	public String getCodeMae() {
		return codeMae;
	}

	public void setCodeMae(String codeMae) {
		this.codeMae = codeMae;
	}

	public String getSelectedSexo() {
		return selectedSexo;
	}

	public void setSelectedSexo(String selectedSexo) {
		this.selectedSexo = selectedSexo;
	}

	public String getSelectedClassificacao() {
		return selectedClassificacao;
	}

	public void setSelectedClassificacao(String selectedClassificacao) {
		this.selectedClassificacao = selectedClassificacao;
	}

	public String getSelectedRaca() {
		return selectedRaca;
	}

	public void setSelectedRaca(String selectedRaca) {
		this.selectedRaca = selectedRaca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

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
	
	public String getCodeTxt() {
		return codeTxt;
	}

	public void setCodeTxt(String codeTxt) {
		this.codeTxt = codeTxt;
	}

	public void addAnimal() {
		Animal animal = new Animal();
		cattleManager.createAnimal(animal);
		
	}

}
