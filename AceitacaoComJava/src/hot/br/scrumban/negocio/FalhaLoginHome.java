package br.scrumban.negocio;

import br.scrumban.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("falhaLoginHome")
public class FalhaLoginHome extends EntityHome<FalhaLogin> {

	public void setFalhaLoginFalhaLoginId(Integer id) {
		setId(id);
	}

	public Integer getFalhaLoginFalhaLoginId() {
		return (Integer) getId();
	}

	@Override
	protected FalhaLogin createInstance() {
		FalhaLogin falhaLogin = new FalhaLogin();
		return falhaLogin;
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

	public FalhaLogin getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
