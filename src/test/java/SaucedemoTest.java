// 1 - Bibliotecas/ imports
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static java.lang.Thread.sleep;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; //biblioteca principal do Selenium
import org.openqa.selenium.chrome.ChromeDriver; //biblioteca principal do ChromeDriver


// 2 - Classe 
public class SaucedemoTest {
// 2.1 - Atributos
  private WebDriver driver; // objeto do Selenium

// 2.2 - Funções e Métodos
// Antes do Teste
  @BeforeEach
  public void iniciar() {
    ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-password-manager-reauthentication");
        options.addArguments("--disable-features=PasswordLeakDetection");
    driver = new ChromeDriver(options); // instanciar o objeto do Selenimum como ChromeDriver
    driver.manage().window().maximize(); // maximiza a janela do navegador
  }

  // Depois do Teste
  @AfterEach
  public void finalizar() {
    driver.quit(); //destroi o objeto do Selenium
  }

  //Teste
  @Test
  public void saucedemoTest() throws InterruptedException {
    driver.get("https://www.saucedemo.com/");
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
    driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"shopping-cart-link\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"checkout\"]")).click();
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("*[data-test=\"firstName\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"firstName\"]")).sendKeys("Lilian");
    driver.findElement(By.cssSelector("*[data-test=\"lastName\"]")).sendKeys("Dias");
    driver.findElement(By.cssSelector("*[data-test=\"postalCode\"]")).sendKeys("08220000");
    driver.findElement(By.cssSelector("*[data-test=\"continue\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"item-quantity\"]")).click();
    assertEquals(driver.findElement(By.cssSelector("*[data-test=\"item-quantity\"]")).getText(), "1");
    driver.findElement(By.cssSelector(".cart_item_label")).click();
    assertEquals(driver.findElement(By.cssSelector("*[data-test=\"inventory-item-name\"]")).getText(), "Sauce Labs Backpack");
    driver.findElement(By.cssSelector(".item_pricebar")).click();
    assertEquals(driver.findElement(By.cssSelector("*[data-test=\"inventory-item-price\"]")).getText(), "$29.99");
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("*[data-test=\"finish\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"back-to-products\"]")).click();
  }
}