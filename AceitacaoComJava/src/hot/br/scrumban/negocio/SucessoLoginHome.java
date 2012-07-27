package br.scrumban.negocio;

import br.scrumban.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("sucessoLoginHome")
public class SucessoLoginHome extends EntityHome<SucessoLogin> {

	public void setSucessoLoginSucessoLoginId(Integer id) {
		setId(id);
	}

	public Integer getSucessoLoginSucessoLoginId() {
		return (Integer) getId();
	}

	@Override
	protected SucessoLogin createInstance() {
		SucessoLogin sucessoLogin = new SucessoLogin();
		return sucessoLogin;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public SucessoLogin getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
