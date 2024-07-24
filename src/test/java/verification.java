import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class verification {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10) );
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://automationexercise.com/");

        WebElement login= driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[4]/a"));
        login.click();

        WebElement mail= driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/form/input[2]"));
        mail.sendKeys("sonia.hm@gmail.com"+ Keys.ENTER);
        WebElement pwd= driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/form/input[3]"));
        pwd.sendKeys("sonia@123"+Keys.ENTER);
        WebElement loginBtn = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/form/button"));
        loginBtn.click();
//Verifier la visibilité de home page
        //recuperer l'url actuelle de la page
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl="https://automationexercice.com/";
        //comparaison entre url actuelle et url attendu
        if(actualUrl.equals(expectedUrl)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
            System.out.println("expectedUrl:"+ expectedUrl);
            System.out.println("actualUrl:"+ actualUrl);
        }



    }
}
