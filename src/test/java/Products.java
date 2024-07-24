import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Products {
    public static void main(String[] arg) {
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://automationexercise.com/");

        //verifier que la page home est affichée
        WebElement home = driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[1]/a"));
        Assert.assertTrue(home.isDisplayed());
        //Click on 'Products' button
        WebElement products = driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[2]/a"));
        products.click();
        //recuperer l'url actuelle de la page
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl="https://automationexercise.com/products";
        //comparaison entre url actuelle et url attendu
        if(actualUrl.equals(expectedUrl)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
            System.out.println("expectedUrl:"+ expectedUrl);
            System.out.println("actualUrl:"+ actualUrl);
        }
//cas de test 8
        //Click on 'View Product' of first product
        WebElement viewP = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a"));
        viewP.click();
        //List<String>motsRecherche

    }
}
