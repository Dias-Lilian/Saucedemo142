// 1 - Bibliotecas/ imports
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; //biblioteca principal do Selenium
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver; //biblioteca principal do ChromeDriver
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

// 2 - Classe 
public class SaucedemoTest {
// 2.1 - Atributos
  private WebDriver driver; // objeto do Selenium
  private Map<String, Object> vars;
  private JavascriptExecutor js;

// 2.2 - Funções e Métodos
// Antes do Teste
  @BeforeEach
  public void iniciar() {
    driver = new ChromeDriver(); // instanciar o objeto do Selenimum como ChromeDriver
    driver.manage().window().maximize(); // maximiza a janela do navegador
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  // Depois do Teste
  @AfterEach
  public void finalizar() {
    driver.quit(); //destroi o objeto do Selenium
  }
  //Teste
  @Test
  public void SaucedemoTest() {
    driver.get("https://www.saucedemo.com/");
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
    driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"shopping-cart-link\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"checkout\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"firstName\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"firstName\"]")).sendKeys("Lilian");
    driver.findElement(By.cssSelector("*[data-test=\"lastName\"]")).sendKeys("Dias");
    driver.findElement(By.cssSelector("*[data-test=\"postalCode\"]")).sendKeys("08220000");
    driver.findElement(By.cssSelector("*[data-test=\"continue\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"item-quantity\"]")).click();
    assertEquals(driver.findElement(By.cssSelector("*[data-test=\"item-quantity\"]")).getText(), is("1"));
    driver.findElement(By.cssSelector(".cart_item_label")).click();
    assertEquals(driver.findElement(By.cssSelector("*[data-test=\"inventory-item-name\"]")).getText(), is("Sauce Labs Backpack"));
    driver.findElement(By.cssSelector(".item_pricebar")).click();
    assertEquals(driver.findElement(By.cssSelector("*[data-test=\"inventory-item-price\"]")).getText(), is("$29.99"));
    driver.findElement(By.cssSelector("*[data-test=\"finish\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"back-to-products\"]")).click();
  }
}