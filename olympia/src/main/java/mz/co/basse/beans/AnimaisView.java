package mz.co.basse.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import mz.co.basse.cattlecore.managers.CattleManager;
import mz.co.basse.cattlecore.managers.CattleManagerImp;
import mz.co.basse.cattlecore.models.Animal;
import mz.co.basse.cattlecore.models.Classificacao;
import mz.co.basse.cattlecore.models.Coral;
import mz.co.basse.cattlecore.models.Gado;
import mz.co.basse.cattlecore.models.Raca;

@ManagedBean
public class AnimaisView {
	
	CattleManager cattleManager = new CattleManagerImp();
	
	private String selectedCoral;
	private String selectedCode;
	
	private Raca selectedRaca;
	private Classificacao selectedClassificacao;
	private Gado selectedTipo;
	
	private Animal selectedAnimal;
	
	private List<Raca> racas;
	private List<Classificacao> classificacoes;
	private List<Gado> tipos;
	
	private List<Animal> animais = new ArrayList<Animal>();
	
	@PostConstruct
	private void init() {
		setClassificacoes(Arrays.asList(Classificacao.values()));
		setRacas(Arrays.asList(Raca.values()));
		setTipos(Arrays.asList(Gado.values()));
		animais= cattleManager.findAnimais(null, null, null, null, null, Boolean.TRUE);
	}
	
	
	public Raca getSelectedRaca() {
		return selectedRaca;
	}


	public void setSelectedRaca(Raca selectedRaca) {
		this.selectedRaca = selectedRaca;
	}


	public Classificacao getSelectedClassificacao() {
		return selectedClassificacao;
	}


	public void setSelectedClassificacao(Classificacao selectedClassificacao) {
		this.selectedClassificacao = selectedClassificacao;
	}


	public Gado getSelectedTipo() {
		return selectedTipo;
	}


	public void setSelectedTipo(Gado selectedTipo) {
		this.selectedTipo = selectedTipo;
	}


	public String getSelectedCoral() {
		return selectedCoral;
	}
	public void setSelectedCoral(String selectedCoral) {
		this.selectedCoral = selectedCoral;
	}
	public String getSelectedCode() {
		return selectedCode;
	}
	public void setSelectedCode(String selectedCode) {
		this.selectedCode = selectedCode;
	}
	public List<Raca> getRacas() {
		return racas;
	}
	public void setRacas(List<Raca> racas) {
		this.racas = racas;
	}
	public List<Classificacao> getClassificacoes() {
		return classificacoes;
	}
	public void setClassificacoes(List<Classificacao> classificacoes) {
		this.classificacoes = classificacoes;
	}
	public List<Gado> getTipos() {
		return tipos;
	}
	public void setTipos(List<Gado> tipos) {
		this.tipos = tipos;
	}
	
	public List<Animal> getAnimais() {
		return animais;
	}


	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}
	
	public Animal getSelectedAnimal() {
		return selectedAnimal;
	}


	public void setSelectedAnimal(Animal selectedAnimal) {
		this.selectedAnimal = selectedAnimal;
	}


	public void search() {
		Coral coral = cattleManager.findCoral(selectedCoral);
		if(selectedCode==null || selectedCode.isEmpty())
			selectedCode=null;
		List<Animal> selectedAnimais = cattleManager.findAnimais(selectedCode, selectedClassificacao, selectedRaca, selectedTipo, coral, Boolean.TRUE);
		if (selectedAnimais != null && !selectedAnimais.isEmpty()) {
			setAnimais(selectedAnimais);
		}
		
	}
	


}
