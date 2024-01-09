package br.com.project;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;

@ManagedBean(name = "personBean")
@ViewScoped
public class PersonBean {

	private String name;

	private List<String> names = new ArrayList<String>();
	
	private HtmlCommandButton commandButton;

	public String addName() {
		names.add(name);
		
		if (names.size() > 3) {
			commandButton.setDisabled(true);
		}
		
		return "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}
	
	public HtmlCommandButton getCommandButton() {
		return commandButton;
	}
	
	public void setCommandButton(HtmlCommandButton commandButton) {
		this.commandButton = commandButton;
	}

}
