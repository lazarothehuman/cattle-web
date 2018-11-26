package mz.co.basse.beans;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import mz.co.basse.cattlecore.managers.CattleManager;
import mz.co.basse.cattlecore.managers.CattleManagerImp;
import mz.co.basse.cattlecore.models.Procedimento;
import mz.co.basse.cattlecore.models.User;

@ManagedBean
public class AddProcedimentoView {

	private String nome;
	private String descricao;
	private User registrador;
	private CattleManager cattleManager = new CattleManagerImp();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public User getRegistrador() {
		return registrador;
	}

	public void setRegistrador(User registrador) {
		this.registrador = registrador;
	}

	public void addProcedimento() {
		
		if(nome!=null && !nome.isEmpty() && descricao!=null && !descricao.isEmpty()) {
			Procedimento procedimento = new Procedimento();
			procedimento.setNome(nome);
			procedimento.setDescricao(descricao);
			cattleManager.createProcedimento(procedimento);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Procedimento adicionado com sucesso"));
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
