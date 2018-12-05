package mz.co.basse.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import mz.co.basse.cattlecore.managers.CattleManager;
import mz.co.basse.cattlecore.managers.CattleManagerImp;
import mz.co.basse.cattlecore.models.Animal;
import mz.co.basse.cattlecore.models.Classificacao;
import mz.co.basse.cattlecore.models.Coral;
import mz.co.basse.cattlecore.models.Gado;
import mz.co.basse.cattlecore.models.Raca;
import mz.co.basse.cattlecore.models.Sexo;

@ManagedBean
public class ModifyAnimalView {

	private CattleManager cattleManager = new CattleManagerImp();

	private List<Classificacao> classificacoes;
	private List<Raca> racas;
	private List<Sexo> sexos;
	private List<Gado> tipos;

	private Sexo selectedSexo;
	private Raca selectedRaca;
	private Classificacao selectedClassificacao;
	private Gado selectedTipo;

	private String codeTxt;
	private String codePai;
	private String codeMae;

	private String cor;
	private Date dataNascimento;

	private String coralCode;

	private Animal selectedAnimal;

	private String searchCode;

	// private List<Tipo>

	public Animal getSelectedAnimal() {
		return selectedAnimal;
	}

	public void setSelectedRaca(Raca selectedRaca) {
		this.selectedRaca = selectedRaca;
	}

	public void setSelectedAnimal(Animal selectedAnimal) {
		this.selectedAnimal = selectedAnimal;
	}

	public String getSearchCode() {
		return searchCode;
	}

	public void setSearchCode(String searchCode) {
		this.searchCode = searchCode;
	}

	public String getCoralCode() {
		return coralCode;
	}

	public void setCoralCode(String coralCode) {
		this.coralCode = coralCode;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Gado[] getTipos() {
		return Gado.values();
	}

	public Classificacao[] getClassificacoes() {
		return Classificacao.values();
	}

	public CattleManager getCattleManager() {
		return cattleManager;
	}

	public void setCattleManager(CattleManager cattleManager) {
		this.cattleManager = cattleManager;
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

	public Sexo getSelectedSexo() {
		return selectedSexo;
	}

	public void setSelectedSexo(Sexo selectedSexo) {
		this.selectedSexo = selectedSexo;
	}

	public Classificacao getSelectedClassificacao() {
		return selectedClassificacao;
	}

	public void setSelectedClassificacao(Classificacao selectedClassificacao) {
		this.selectedClassificacao = selectedClassificacao;
	}

	public Raca getSelectedRaca() {
		return selectedRaca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@PostConstruct
	public void init() {
		setClassificacoes(Arrays.asList(Classificacao.values()));
		setRacas(Arrays.asList(Raca.values()));
		setSexos(Arrays.asList(Sexo.values()));
		setTipos(Arrays.asList(Gado.values()));
	}

	public List<Sexo> getSexos() {
		return sexos;
	}

	public void setSexos(List<Sexo> sexos) {
		this.sexos = sexos;
	}

	public List<Raca> getRacas() {
		return racas;
	}

	public void setRacas(List<Raca> racas) {
		this.racas = racas;
	}

	public String getCodeTxt() {
		return codeTxt;
	}

	public void setCodeTxt(String codeTxt) {
		this.codeTxt = codeTxt;
	}

	public void modifyAnimal() {
		Animal mae = cattleManager.findAnimal(codeMae);
		Animal pai = cattleManager.findAnimal(codePai);
		Coral coral = cattleManager.findCoral(coralCode);
		System.out.println(mae + "\n" + pai + "\n" + coral);
		selectedAnimal = (Animal) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("selectedAnimal");
		if (selectedAnimal != null) {
			if (coral != null && codeTxt != null && !codeTxt.isEmpty() && mae != null && pai != null) {
				selectedAnimal.setCode(codeTxt);
				selectedAnimal.setCoral(coral);
				selectedAnimal.setCor(cor);
				selectedAnimal.setSexo(selectedSexo);
				selectedAnimal.setRaca(selectedRaca);
				selectedAnimal.setClassificacao(selectedClassificacao);
				selectedAnimal.setMae(mae);
				selectedAnimal.setPai(pai);
				selectedAnimal.setDataNascimento(dataNascimento);
				selectedAnimal.setTipo(selectedTipo);
				coral.addAnimal(selectedAnimal);
				cattleManager.updateAnimal(selectedAnimal);
			}
		}
	}

	public List<String> searchMae(String query) {
		List<String> results = new ArrayList<String>();

		/*
		 * List<Animal> maes = cattleManager.findAnimais(); for (Animal animal : maes)
		 * results.add(animal.getCode()); return results;
		 */
		return results;
	}

	public List<String> searchPai(String query) {
		List<String> results = new ArrayList<String>();

		/*
		 * List<Animal> maes = cattleManager.findAnimais(); for (Animal animal : maes)
		 * results.add(animal.getCode()); return results;
		 */
		return results;
	}

	public void setClassificacoes(List<Classificacao> classificacoes) {
		this.classificacoes = classificacoes;
	}

	public void setTipos(List<Gado> tipos) {
		this.tipos = tipos;
	}

	public void search() {
		selectedAnimal = cattleManager.findAnimal(searchCode);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("selectedAnimal", selectedAnimal);
		if (selectedAnimal != null) {
			setCodeTxt(selectedAnimal.getCode());
			setSelectedClassificacao(selectedAnimal.getClassificacao());
			setSelectedRaca(selectedAnimal.getRaca());
			setSelectedSexo(selectedAnimal.getSexo());
			setSelectedTipo(selectedAnimal.getTipo());
			setCodeMae(selectedAnimal.getMae().getCode());
			setCodePai(selectedAnimal.getPai().getCode());
			setCoralCode(selectedAnimal.getCoral().getCode());
			setCor(selectedAnimal.getCor());
			setDataNascimento(selectedAnimal.getDataNascimento());
		}
	}

}
