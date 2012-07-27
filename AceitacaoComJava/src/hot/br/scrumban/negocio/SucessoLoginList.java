package br.scrumban.negocio;

import br.scrumban.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("sucessoLoginList")
public class SucessoLoginList extends EntityQuery<SucessoLogin> {

	private static final String EJBQL = "select sucessoLogin from SucessoLogin sucessoLogin";

	private static final String[] RESTRICTIONS = {};

	private SucessoLogin sucessoLogin = new SucessoLogin();

	public SucessoLoginList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public SucessoLogin getSucessoLogin() {
		return sucessoLogin;
	}
}
