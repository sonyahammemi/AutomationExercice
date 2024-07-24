import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SearchProduct {
    public static void main(String[] arg) {
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://automationexercise.com/products");

        WebElement products = driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]"));
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
        WebElement Search = driver.findElement(By.xpath("//input[@id='search_product']"));
        Search.sendKeys("Stylish dress");
        //Search.click();
        WebElement Search_Btn = driver.findElement(By.xpath("//body/section[@id='advertisement']/div[1]/button[1]/i[1]"));
        Search_Btn.click();

        //Verify 'SEARCHED PRODUCTS' is visible
        //
        String actualURL2 = driver.getCurrentUrl();
        String expectedURL2 = "https://automationexercise.com/products?search=Stylish%20dress";
        if(actualURL2.equals(expectedURL2)){
            System.out.println("URLs match. produit recherché est affiché correctement");
        }else{
            System.out.println("URLs do not mutch. Test failed");
            System.out.println("Expected URL:" + expectedURL2);
            System.out.println("Actual URL:" + actualURL2);
        }

//ajouter ad blocker et crx : bloquer les publicités

    }


}
