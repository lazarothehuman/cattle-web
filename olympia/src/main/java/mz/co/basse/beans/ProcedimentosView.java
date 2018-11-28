package mz.co.basse.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mz.co.basse.cattlecore.managers.CattleManager;
import mz.co.basse.cattlecore.managers.CattleManagerImp;
import mz.co.basse.cattlecore.models.Procedimento;

@ManagedBean
@ViewScoped
public class ProcedimentosView {
	
	private String selectedNome;
	
	//checkbox
	

	private List<Procedimento> procedimentos = new ArrayList<Procedimento>();

	private Procedimento selectedProcedimento;

	CattleManager cattleManager = new CattleManagerImp();

	@PostConstruct
	public void init() {
		procedimentos = cattleManager.findProcedimentos(null, null, Boolean.TRUE);
	}

	public String getSelectedNome() {
		return selectedNome;
	}

	public void setSelectedNome(String selectedNome) {
		this.selectedNome = selectedNome;
	}

	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public Procedimento getSelectedProcedimento() {
		return selectedProcedimento;
	}

	public void setSelectedProcedimento(Procedimento selectedProcedimento) {
		this.selectedProcedimento = selectedProcedimento;
	}
	
	public void pesquisar() {
		List<Procedimento> selectedProcedimentos = cattleManager.findProcedimentos(selectedNome, null, Boolean.TRUE);
		if (selectedProcedimentos != null) {
			setProcedimentos(procedimentos);
		}
	}

}
