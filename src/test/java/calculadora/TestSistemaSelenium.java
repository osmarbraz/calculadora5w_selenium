package calculadora;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Testes de sistema utilizando o Selenium
 */
class TestSistemaSelenium {

    //Declarando um objeto do tipo WebDriver, utilizado pelo Selenium WebDriver.
    static WebDriver driver;
    //URL do Sistema
    static String URL_test = "http://localhost:8080/calculadora5w_selenium/";

    @BeforeAll
    static void inicializacao() {
        //Definindo o caminho para o executável do ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        //Inicializa o ChromeDriver
        driver = new ChromeDriver();
    }

    @Test
    void testSoma() {
        //Abre o navegador com a URL
        driver.get(URL_test);
        //Atraso para renderizar a página
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        
        // Procura os campos para entrar os números
        WebElement textBoxValorA = driver.findElement(By.name("ValorA"));
        textBoxValorA.sendKeys("10");        
        WebElement textBoxValorB = driver.findElement(By.name("ValorB"));
        textBoxValorB.sendKeys("20");        
        //Procura a caixa de seleção para a operação
        WebElement selectOperacao = driver.findElement(By.name("operacao"));
        selectOperacao.sendKeys("adicao");
        
        //Procura o botão Calcular
        WebElement submitButton = driver.findElement(By.name("Calcular"));
        submitButton.click();

        //Atraso para o processamento
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(250));
        
        //Verifica o texto de retorno da página
        WebElement corpoElementoTexto = driver.findElement(By.tagName("body"));
        String texto = corpoElementoTexto.getText();
        //System.out.println("Texto de retorno: " + texto);
        
        //Verifica se o texto da página está correto
        assertTrue(texto.contains("A soma de 10.0 + 20.0 = 30.0"));
    }
    
    @Test
    void testDiferenca() {
        //Abre o navegador com a URL
        driver.get(URL_test);
        //Atraso para renderizar a página
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        
        // Procura os campos para entrar os números
        WebElement textBoxValorA = driver.findElement(By.name("ValorA"));
        textBoxValorA.sendKeys("10");        
        WebElement textBoxValorB = driver.findElement(By.name("ValorB"));
        textBoxValorB.sendKeys("20");        
        //Procura a caixa de seleção para a operação
        WebElement selectOperacao = driver.findElement(By.name("operacao"));
        selectOperacao.sendKeys("subtracao");
        
        //Procura o botão Calcular
        WebElement submitButton = driver.findElement(By.name("Calcular"));
        submitButton.click();

        //Atraso para o processamento
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(250));
        
        //Verifica o texto de retorno da página
        WebElement corpoElementoTexto = driver.findElement(By.tagName("body"));
        String texto = corpoElementoTexto.getText();
        //System.out.println("Texto de retorno: " + texto);
        
        //Verifica se o texto da página está correto
        assertTrue(texto.contains("A diferenca de 10.0 - 20.0 = -10.0"));
    }
    
    @Test
    void testProduto() {
        //Abre o navegador com a URL
        driver.get(URL_test);
        //Atraso para renderizar a página
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        
        // Procura os campos para entrar os números
        WebElement textBoxValorA = driver.findElement(By.name("ValorA"));
        textBoxValorA.sendKeys("10");        
        WebElement textBoxValorB = driver.findElement(By.name("ValorB"));
        textBoxValorB.sendKeys("20");        
        //Procura a caixa de seleção para a operação
        WebElement selectOperacao = driver.findElement(By.name("operacao"));
        selectOperacao.sendKeys("multiplicacao");
        
        //Procura o botão Calcular
        WebElement submitButton = driver.findElement(By.name("Calcular"));
        submitButton.click();

        //Atraso para o processamento
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(250));
        
        //Verifica o texto de retorno da página
        WebElement corpoElementoTexto = driver.findElement(By.tagName("body"));
        String texto = corpoElementoTexto.getText();
        //System.out.println("Texto de retorno: " + texto);
        
        //Verifica se o texto da página está correto
        assertTrue(texto.contains("O produto de 10.0 * 20.0 = 200.0"));
    }
    
     @Test
    void testQuociente() {
        //Abre o navegador com a URL
        driver.get(URL_test);
        //Atraso para renderizar a página
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        
        // Procura os campos para entrar os números
        WebElement textBoxValorA = driver.findElement(By.name("ValorA"));
        textBoxValorA.sendKeys("10");        
        WebElement textBoxValorB = driver.findElement(By.name("ValorB"));
        textBoxValorB.sendKeys("20");        
        //Procura a caixa de seleção para a operação
        WebElement selectOperacao = driver.findElement(By.name("operacao"));
        selectOperacao.sendKeys("divisao");
        
        //Procura o botão Calcular
        WebElement submitButton = driver.findElement(By.name("Calcular"));
        submitButton.click();

        //Atraso para o processamento
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(250));
        
        //Verifica o texto de retorno da página
        WebElement corpoElementoTexto = driver.findElement(By.tagName("body"));
        String texto = corpoElementoTexto.getText();
        //System.out.println("Texto de retorno: " + texto);
        
        //Verifica se o texto da página está correto
        assertTrue(texto.contains("O quociente de 10.0 / 20.0 = 0.5"));
    }

    // Método que finaliza o teste, fechando a instância do WebDriver.
    @AfterAll
    static void finalizacao() {
        driver.quit();
    }
}
