package mz.co.basse.manager;

import java.io.IOException;

import javax.faces.context.FacesContext;

import mz.co.basse.cattlecore.models.Transaction;
import mz.co.basse.cattlecore.models.User;
import mz.co.basse.cattlecore.models.dao.TransactionDao;
import mz.co.basse.cattlecore.models.dao.jpa.TransactionJpaDao;
import mz.co.basse.utils.RedirectManager;

public class TransactionManagerImp implements TransactionManager {

	TransactionDao transaccaoDao = new TransactionJpaDao();
	User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userLogado");

	public void viewCorais() {
		// TODO Auto-generated method stub

	}

	public void addCural() {
		// TODO Auto-generated method stub

	}

	public void addAnimal() {
		// TODO Auto-generated method stub

	}

	public void viewAnimais() {
		Transaction transaccao = transaccaoDao.find("302");
		if (user.getProfile().getTransactions().contains(transaccao)) 
			RedirectManager.redirect(transaccao.getUrl());
		else {
			//show message de erro de permissao	
		}
	}

	public void viewAnimal() {
		// TODO Auto-generated method stub

	}

	public void addProcedimento() {
		// TODO Auto-generated method stub

	}

	public void viewProcedimentos() {
		// TODO Auto-generated method stub

	}

	public void addSaida() {
		// TODO Auto-generated method stub

	}

	public void viewSaidas() {
		// TODO Auto-generated method stub

	}

	public void addProcedimentoToAnimal() {
		// TODO Auto-generated method stub

	}

}
