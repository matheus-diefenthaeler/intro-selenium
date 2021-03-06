package treinamentoINMSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DomainSpecificLanguage {

    private WebDriver driver;

    public DomainSpecificLanguage(WebDriver driver) {
        this.driver = driver;
    }

    public void escreverByName(String nameCamp, String texto) {
        driver.findElement(By.name(nameCamp)).sendKeys(texto);
    }

    public void escreverById(String idCamp, String texto) {
        driver.findElement(By.name(idCamp)).sendKeys(texto);
    }

    public void escreverByClass(String className) {
        driver.findElement(By.className(className)).click();
    }

    public void escreverByXPath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }



}
