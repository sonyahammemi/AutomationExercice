
import org.apache.commons.io.input.WindowsLineEndingInputStream;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.animation.model.KeyframeStyle;

import java.io.File;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class paiement {
    public static void main(String[] args){
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("E:\\ProjectsWorkspace\\test\\src\\Adblocker\\AdBlock — le meilleur bloqueur de pubs - Chrome Web Store 6.5.0.0.crx"));
        WebDriver driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.automationexercise.com");

        //login
        WebElement login = driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]"));
        login.click();
        WebElement email = driver.findElement(By.xpath("//body/section[@id='form']/div[1]/div[1]/div[1]/div[1]/form[1]/input[2]"));
        email.sendKeys("sonyahmtest@gmail.com"+ Keys.ENTER);
        WebElement password = driver.findElement(By.xpath("//body/section[@id='form']/div[1]/div[1]/div[1]/div[1]/form[1]/input[3]"));
        password.sendKeys("sonia@123"+ Keys.ENTER);
        WebElement submit = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        submit.click();

        WebElement products = driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[2]/a"));
        products.click();
        //recuperer l'url actuelle de la page
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl="https://www.automationexercise.com/products";
        //comparaison entre url actuelle et url attendu
        if(actualUrl.equals(expectedUrl)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
            System.out.println("expectedUrl:"+ expectedUrl);
            System.out.println("actualUrl:"+ actualUrl);
        }
        //recuperer l'identification de le fenetre principale
        String mainWindowHandle = driver.getWindowHandle();
        //receuperer les identifications de toutes les fenetres ouvertes
        Set<String> windowHandles = driver.getWindowHandles();
        //parcourer toutes les fenetres ouvertes
        for (String windowHandle: windowHandles){
            if (!windowHandle.equals(mainWindowHandle)){
                //retour a la fenetre ad blocker
                driver.switchTo().window(windowHandle);
                driver.close();
            }
        }
        //revenir a la fenetre principale
        driver.switchTo().window(mainWindowHandle);
        //Ajouter des produits au panier
        WebElement Add = driver.findElement(By.xpath("//body/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]"));
        Add.click();
        WebElement Continue_shopping = driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]"));
        Continue_shopping.click();
        WebElement Add_Second_Prod = driver.findElement(By.xpath("//body/section[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]"));
        Add_Second_Prod.click();
        WebElement Add_third_Prod = driver.findElement(By.xpath("//body/section[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/a[1]"));
        Add_third_Prod.click();
        WebElement Cart = driver.findElement(By.xpath("//u[contains(text(),'View Cart')]"));
        Cart.click();
        System.out.println("les produits sont ajoutés au panier");
        //verification l'affichage de la page Cart
        String actualURL = driver.getCurrentUrl();
        String expectedURL ="https://www.automationexercise.com/view_cart";
        //Comparere les resultats
        if (actualURL.equals(expectedURL)) {
            System.out.println("URLs match, Test passed");
        } else {
            System.out.println("URLs do not match , Test failed");
            System.out.println("Expected URL:" + expectedURL);
            System.out.println("actual URL:" + actualURL);
        }
        //Remove Products From Cart
        WebElement Delete_Btn = driver.findElement(By.xpath("//tbody/tr[@id='product-1']/td[6]/a[1]"));
        Delete_Btn.click();


        //Checkout
        WebElement Checkout = driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]"));
        Checkout.click();
        // Creer une description

        WebElement description = driver.findElement(By.xpath("//body/section[@id='cart_items']/div[1]/div[6]/textarea[1]"));
        description.sendKeys("une description");
        //description.click();

        //placer l'ordre
        WebElement Order = driver.findElement(By.xpath("//a[contains(text(),'Place Order')]"));
        Order.click();
        //verification la page de paiement

        //payment
        WebElement Name_On_Card = driver.findElement(By.xpath("//body/section[@id='cart_items']/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]"));
        Name_On_Card.sendKeys("Azerty");
        WebElement Card_Number = driver.findElement(By.xpath("//body/section[@id='cart_items']/div[1]/div[3]/div[1]/div[2]/form[1]/div[2]/div[1]/input[1]"));
        Card_Number.sendKeys("123456789");
        WebElement CVC = driver.findElement(By.xpath("//body/section[@id='cart_items']/div[1]/div[3]/div[1]/div[2]/form[1]/div[3]/div[1]/input[1]"));
        CVC.sendKeys("333");
        WebElement Expiration = driver.findElement(By.xpath("//body/section[@id='cart_items']/div[1]/div[3]/div[1]/div[2]/form[1]/div[3]/div[2]/input[1]"));
        Expiration.sendKeys("October");
        WebElement Year = driver.findElement(By.xpath("//body/section[@id='cart_items']/div[1]/div[3]/div[1]/div[2]/form[1]/div[3]/div[3]/input[1]"));
        Year.sendKeys("2025");
        //Pay and comfirm order
        WebElement Pay = driver.findElement(By.xpath("//button[@id='submit']"));
        Pay.click();
        WebElement check_Order = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/p"));
        String actualmsg = check_Order.getText();
        //return actualmsg;
        String expectedmsg = "Congratulations! Your order has been confirmed!";
        Assert.assertEquals(actualmsg,expectedmsg);

        //Or
        String actualURL1 = driver.getCurrentUrl();
        String expectedURL1 ="https://www.automationexercise.com/payment_done/900";
        //Comparere les resultats
        if (actualURL1.equals(expectedURL1)) {
            System.out.println("URLs match, Test passed");
        } else {
            System.out.println("URLs do not match , Test failed");
            System.out.println("Expected URL:" + expectedURL1);
            System.out.println("actual URL:" + actualURL1);
        }


    }

}
