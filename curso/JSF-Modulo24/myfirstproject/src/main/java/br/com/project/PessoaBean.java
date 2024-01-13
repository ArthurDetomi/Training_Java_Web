package br.com.project;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;

@ViewScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {

	private String nome;
	private String senha;
	private String texto;
	private List<String> nomes = new ArrayList<String>();
	private HtmlCommandButton commandButton;
	
	
	public String addNome() {
		String nomePaginaRetorno = "";

		nomes.add(nome);

		if (nomes.size() > 3) {
			nomePaginaRetorno = "paginanavegada?faces-redirect=true";
			commandButton.setDisabled(true);
		}

		return nomePaginaRetorno;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getNomes() {
		return nomes;
	}

	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}

	public HtmlCommandButton getCommandButton() {
		return commandButton;
	}

	public void setCommandButton(HtmlCommandButton commandButton) {
		this.commandButton = commandButton;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
