package br.scrumban.infraestrutura;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.TestCase;

import org.fluentlenium.adapter.FluentTest;
import org.hibernate.ejb.HibernateEntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import br.scrumban.Vendedor;


public class BaseAcceptanceTest 
{

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-test");
    protected WebDriver driver ;
	
    // Inicializa antes de cada teste que for rodado... Se usasse @BeforeClass inicializaria antes da classe de testes
    @Before
    public void inicializaBancoDadosESeleniumDriver()
    {
    
    	driver = new FirefoxDriver();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	
        InputStream testData = Vendedor.class.getResourceAsStream("/dados.xml");

        HibernateEntityManager em = (HibernateEntityManager) emf.createEntityManager();

        DbUnitDataLoader loader = new DbUnitDataLoader(testData, em.getSession().connection());

        try {
			loader.populateTestData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
   
    @After
    public void fechaBrowser(){
    	driver.close();
    }

 
}
