package br.scrumban.negocio;

import java.util.Date;

import javax.persistence.EntityManager;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

import br.scrumban.entity.SucessoLogin;
import br.scrumban.entity.Usuario;

@Name("authenticator")
public class Authenticator
{
    @Logger private Log log;

    @In(create=true) FalhaLoginHome falhaLoginHome;
    @In(create=true) SucessoLoginHome sucessoLoginHome; 
    
    @In EntityManager entityManager;
    @In Identity identity;
    
    @In Credentials credentials;

    public boolean authenticate()
    {
        log.info("authenticating {0}", credentials.getUsername());
        
        String query = "select u from Usuario u where u.login = :login and u.senha= :senha";
        Usuario u = (Usuario) entityManager.createQuery(query)
        			.setParameter("login", credentials.getUsername())
        			.setParameter("senha", credentials.getPassword())
        			.getSingleResult();
        
        if(u == null)
        {
        	
        	return false;
        }
        
        else{
        	
        	SucessoLogin sucessoLogin = new SucessoLogin();
        	sucessoLogin.setDataLogin(new Date());
        	sucessoLogin.setUsuarioId(u.getUsuarioId());
        	
        	sucessoLoginHome.setInstance(sucessoLogin);
        	sucessoLoginHome.persist();
        	
        	identity.addRole("admin");
        	
            return true;
        }
    }

}
