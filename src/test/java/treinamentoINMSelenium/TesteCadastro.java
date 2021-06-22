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
        driver.findElement(By.className("login100-form-btn")).click();

        Assertions.assertEquals("NOVO FUNCIONÁRIO",driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a")).getText());
    }

    @Test
    public void deveValidarLoginSemSucesso() throws InterruptedException{

        driver.get("http://www.inmrobo.tk/accounts/login/");
        driver.findElement(By.name("username")).sendKeys("diefenthaeler");
        driver.findElement(By.name("pass")).sendKeys("1111111");
        driver.findElement(By.className("login100-form-btn")).click();

        Assertions.assertTrue(driver.findElement(By.className("alert-danger")).getText().contains("ERRO! Usuário ou Senha inválidos"));
    }

    @Test
    public void deveValidarCadastroFuncionarioComSucesso() throws InterruptedException {

        driver.get("http://www.inmrobo.tk/accounts/login/");
        driver.findElement(By.name("username")).sendKeys("diefenthaeler");
        driver.findElement(By.name("pass")).sendKeys("123321");
        driver.findElement(By.className("login100-form-btn")).click();
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a")).click();

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

        Assertions.assertTrue(driver.findElement(By.className("alert-success")).getText().contains("SUCESSO! Usuário cadastrado com sucesso"));
    }

}
