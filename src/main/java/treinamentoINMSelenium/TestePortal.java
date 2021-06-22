package treinamentoINMSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestePortal {
    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver", "C:\\inmetrics\\chromedriver.exe");

        //Instanciando o driver
        WebDriver driver = new ChromeDriver();
        //Abrindo o browser do chrome na tela de login

        driver.get("http://www.inmrobo.tk/accounts/login/");

        //Informando o usuario, senha e clicando no botao
        driver.findElement(By.name("username")).sendKeys("diefenthaeler");
        driver.findElement(By.name("pass")).sendKeys("123321");
        driver.findElement(By.className("login100-form-btn")).click();

        //Clicar em novo Funcionario
        //*[@id="navbarSupportedContent"]/ul/li[2]/a
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a")).click();

        //Preencher Funcionario
        driver.findElement(By.id("inputNome")).sendKeys("Jairo" + (int)(Math.random() * 10) + "Vitar");
        driver.findElement(By.id("cpf")).sendKeys("725.052.470-48");

        WebElement element = driver.findElement(By.id("slctSexo"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Masculino");

        driver.findElement(By.id("inputAdmissao")).sendKeys("13-0p8-2018");
        driver.findElement(By.id("inputCargo")).sendKeys("Automatizador Pleno");
        driver.findElement(By.id("dinheiro")).sendKeys("1.000,00");
        driver.findElement(By.id("clt")).click();

        driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[3]/input")).click();

        driver.quit();

    }
}


