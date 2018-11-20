package org.primefaces.olympia.view.input;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class EmptyView {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void test() {
		System.out.println(this.nome + "hello");
		System.out.println(getNome() + "hey");
	}

}
