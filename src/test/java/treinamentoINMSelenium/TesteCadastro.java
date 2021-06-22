package treinamentoINMSelenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {

    private WebDriver driver;
    private DomainSpecificLanguage dsl;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\inmetrics\\chromedriver.exe");
        driver = new ChromeDriver();
        dsl = new DomainSpecificLanguage(driver);
    }

    @AfterEach
    public void close() {
        driver.quit();
    }

    @Test
    public void deveValidarLoginComSucesso() throws InterruptedException {

        driver.get("http://www.inmrobo.tk/accounts/login/");
        dsl.escreverByName("username","diefenthaeler");
        dsl.escreverByName("pass","123321");
        dsl.escreverByClass("login100-form-btn");

        Assertions.assertEquals("NOVO FUNCIONÁRIO",driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a")).getText());
    }

    @Test
    public void deveValidarLoginSemSucesso() throws InterruptedException{

        driver.get("http://www.inmrobo.tk/accounts/login/");
        dsl.escreverByName("username","diefenthaeler");
        dsl.escreverByName("pass","1111111");
        dsl.escreverByClass("login100-form-btn");

        Assertions.assertTrue(driver.findElement(By.className("alert-danger")).getText().contains("ERRO! Usuário ou Senha inválidos"));
    }

    @Test
    public void deveValidarCadastroFuncionarioComSucesso() throws InterruptedException {

        driver.get("http://www.inmrobo.tk/accounts/login/");
        dsl.escreverByName("username","diefenthaeler");
        dsl.escreverByName("pass","123321");
        dsl.escreverByClass("login100-form-btn");
        dsl.escreverByXPath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a");

        driver.findElement(By.id("inputNome")).sendKeys("xzczxc" + (int)(Math.random() * 10) + "cxzdsa");
        dsl.escreverById("cpf","725.052.470-48");

        WebElement element = driver.findElement(By.id("slctSexo"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Masculino");

        driver.findElement(By.id("inputAdmissao")).sendKeys("13-0p8-2018");
        driver.findElement(By.id("inputCargo")).sendKeys("Automatizador Pleno");
        driver.findElement(By.id("dinheiro")).sendKeys("1.000,00");
        driver.findElement(By.id("clt")).click();

        dsl.escreverByXPath("/html/body/div/div[2]/div/form/div[3]/input");

        Assertions.assertTrue(driver.findElement(By.className("alert-success")).getText().contains("SUCESSO! Usuário cadastrado com sucesso"));
    }
}
