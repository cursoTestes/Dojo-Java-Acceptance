package br.scrumban;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.scrumban.infraestrutura.BaseAcceptanceTest;

public class LoginAcceptanceTest extends BaseAcceptanceTest {

	@Test
	public void teste_login_com_sucesso_gera_entrada_na_tabela_auditoria() {
		Integer entradasEsperadasNaTabela = 1 ;
		String texto_mensagem_logado_com_sucesso = "Welcome, cfc!";
		
		driver.get("http://localhost:8080/AceitacaoComJava/login.seam");
		
		driver.findElement(By.id("loginForm:username")).sendKeys("cfc");
		driver.findElement(By.id("loginForm:password")).sendKeys("123456");
		driver.findElement(By.id("loginForm:submit")).click();
      
		WebElement element = driver.findElement(By.xpath("id('messages')/li[2]"));
		System.out.println("> >>>>>>>>>>>> " + element.getText() );
		 
		boolean acheiTextoLogadoSucesso = element.getText().equals(texto_mensagem_logado_com_sucesso);
		Assert.assertTrue(acheiTextoLogadoSucesso);
		
		Integer resultadoEntradasSucessoLog = (Integer)emf.createEntityManager().createNativeQuery("select count(*) from SucessoLogin").getSingleResult();
		Assert.assertEquals(entradasEsperadasNaTabela,resultadoEntradasSucessoLog);
		
	}
}
