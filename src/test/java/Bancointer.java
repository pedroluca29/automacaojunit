import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;

public class Bancointer { 
	
		
	WebDriver driver;
	@Before
	public void setUp() throws Exception {
		//codigo  para indicar e navegar
		System.setProperty("webdriver.chrome.driver", 
				"./Driver/chromedriver.exe");
		// comando para chamar o driver dentro do before
		driver = new ChromeDriver ();
		//processando com javascript
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.open()");
		//comando para indicar URL
		driver.get("https://www.4devs.com.br/gerador_de_pessoas");
		//comando para maximizar a tela
		driver.manage().window().maximize();
		//comando para interagir com o elemento
		driver.findElement(By.cssSelector("#bt_gerar_pessoa")).click();
		Thread.sleep(3000);
		String nome= driver.findElement(By.cssSelector("#nome")).getText();
		String celular= driver.findElement(By.cssSelector("#telefone_fixo")).getText();
		String email= driver.findElement(By.cssSelector("#email")).getText();
		String cpf= driver.findElement(By.cssSelector("#cpf")).getText();
		String dataNascimento= driver.findElement(By.cssSelector("#data_nasc")).getText();
		//driver.quit();
		//abrir duas guia
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		//numero significa numero de abas a serem abertas
		driver.switchTo().window(tabs.get(1));
		//driver= new ChromeDriver ();
		
		
		//comando para indicar URL
		driver.get("https://www.bancointer.com.br/");
		//comando para maximizar a tela
				driver.manage().window().maximize();
				//comando para interagir com o elemento
				driver.findElement(By.cssSelector("#gatsby-focus-wrapper > div > header > section > div > div > div > div > div.styles__LogoNIcons-sc-1gbjc3e-6.gjJzHM > div.styles__SearchNFlags-sc-1gbjc3e-8.yVPnY > div.styles__ButtonsWrapper-sc-1gbjc3e-9.PKrxs > button:nth-child(1)")).click();
				Thread.sleep(3000);
				driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();
				driver.findElement(By.name("nome")).sendKeys(nome);
				driver.findElement(By.id("celular")).sendKeys(celular);
				driver.findElement(By.id("email")).sendKeys(email);
				driver.findElement(By.id("cpf")).sendKeys(cpf);
				driver.findElement(By.id("dataNascimento")).sendKeys(dataNascimento);
				driver.findElement(By.cssSelector("body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center > div > div:nth-child(2) > form > div > div:nth-child(6) > div > label")).click();
			    driver.findElement(By.cssSelector("body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center > div > div:nth-child(2) > form > div > div.col-12.text-center > button")).click();
			    
			    //tirar print 
			    File foto_tela=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			    Files.copy(foto_tela,new File("C:\\Users\\Pichau\\Desktop\\Screenshots\\bancointer.jpg"));

		

			}
	


			@After
			public void tearDown() throws Exception {
				driver.quit();
			}

			@Test
			public void test() throws InterruptedException {
				Thread.sleep(3000);
				String texto = driver.findElement(By.cssSelector("body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center.sent > div > p")).getText();
			    System.out.println(texto);
			    assertEquals("Prontinho! Recebemos os seus dados.", texto);
			}

		}
