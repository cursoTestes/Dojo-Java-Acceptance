package br.scrumban.negocio;

import br.scrumban.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("falhaLoginList")
public class FalhaLoginList extends EntityQuery<FalhaLogin> {

	private static final String EJBQL = "select falhaLogin from FalhaLogin falhaLogin";

	private static final String[] RESTRICTIONS = {};

	private FalhaLogin falhaLogin = new FalhaLogin();

	public FalhaLoginList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public FalhaLogin getFalhaLogin() {
		return falhaLogin;
	}
}
