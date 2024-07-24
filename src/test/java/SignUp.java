
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SignUp {
    public static void main(String[] arg) {
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://automationexercise.com/");
        //Signup
        WebElement Signup = driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[4]/a"));
        Signup.click();

        WebElement Name = driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/input[2]"));
        Name.sendKeys("sonia" + Keys.ENTER);

        WebElement Email = driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/input[3]"));
        Email.sendKeys("sonyahmtest@gmail.com" + Keys.ENTER);

        WebElement Submit = driver.findElement(By.className("btn-default"));
        Submit.click();

        //comparaison entre actual url et expected url
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://automationexercise.com/signup";
        if (actualURL.equals(expectedURL)) {
            System.out.println("URL correct, Test passed");
        } else {
            System.out.println("URL wrong, Test failed");
            System.out.println("ExpectedURL:" + expectedURL);
            System.out.println("actualURL:" + actualURL);
        }
        //Enter account information
        //WebElement Mrs = driver.findElement(By.xpath("/html/body/section/div/div/div/div/form/div[1]/div[2]/label/div/span/input"));
        WebElement Mrs = driver.findElement(By.id("id_gender2"));

        Mrs.click();

        WebElement password = driver.findElement(By.xpath("/html/body/section/div/div/div/div/form/div[4]/input"));
        password.sendKeys("sonia@123");
        /*
        //Select method
        WebElement day;
        day = driver.findElement(By.xpath("/html/body/section/div/div/div/div/form/div[5]/div/div[1]/div/select"));
        Select select = new Select(day);
        select.deselectByValue("14");
        day.click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        WebElement month;
        month=driver.findElement(By.xpath("//*[@id=\"months\"]"));
        Select selectM = new Select(month);
        selectM.deselectByValue("10");
        month.click();
        Actions actionM = new Actions(driver);
        actionM.sendKeys(Keys.ENTER).perform();

        WebElement year;
        year=driver.findElement(By.xpath("//*[@id=\"years\"]"));
        Select selectY = new Select(year);
        selectY.deselectByValue("1991");
        month.click();
        Actions actionY = new Actions(driver);
        actionY.sendKeys(Keys.ENTER).perform();
*/
        //day
        WebElement day = driver.findElement(By.xpath("//*[@id=\"days\"]"));
        day.click();
        day.sendKeys("14");
        //month
        WebElement month = driver.findElement(By.xpath("//*[@id=\"months\"]"));
        month.click();
        month.sendKeys("october");
        //year
        WebElement year = driver.findElement(By.xpath("//*[@id=\"years\"]"));
        year.click();
        year.sendKeys("1991");

        WebElement newsletter = driver.findElement(By.xpath("/html/body/section/div/div/div/div/form/div[6]/div/span/input"));
        newsletter.click();
/*
        WebElement Firstname=driver.findElement(By.xpath("/html/body/section/div/div/div/div/form/p[1]/input"));
        Firstname.sendKeys("Sonia"+Keys.ENTER);
        WebElement Lastname= driver.findElement(By.xpath("/html/body/section/div/div/div/div/form/p[2]/input"));
        //Lastname.sendKeys("abcd"+Keys.ENTER);
        int deltaY = Lastname.getRect().y;
        new Actions(driver).scrollByAmount(40, deltaY).perform();
        Lastname.sendKeys("Ben mohamed");
        Lastname.click();
*/
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
        firstName.sendKeys("Sonia" + Keys.ENTER);
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
        lastName.sendKeys("abcd" + Keys.ENTER);

        WebElement address = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
        address.sendKeys("Cité el ghazela Ariana");
        address.click();

        WebElement Country = driver.findElement(By.xpath("//*[@id=\"country\"]"));
        Select selectC = new Select(Country);
        selectC.selectByValue("Canada");
        Country.click();
        Actions actionC = new Actions(driver);
        actionC.sendKeys(Keys.ENTER).perform();

        WebElement State = driver.findElement(By.xpath("//*[@id=\"state\"]"));
        State.sendKeys(" Ariana");
        State.click();

        WebElement City = driver.findElement(By.xpath("//*[@id=\"city\"]"));
        City.sendKeys(" Ariana");
        City.click();

        WebElement Zipcode = driver.findElement(By.xpath("//*[@id=\"zipcode\"]"));
        Zipcode.sendKeys(" 929");
        Zipcode.click();

        WebElement phone = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[10]/input[1]"));
        phone.sendKeys("  +1 613-957-0000");
        phone.click();

        WebElement create = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]"));
        create.click();
        //comparer url current et url expected
        String actualURL2 = driver.getCurrentUrl();
        String expectedURL2 = "https://automationexercise.com/account_created";
        if (actualURL2.equals(expectedURL2)) {
            System.out.println("URL2 correct, Test passed");
        } else {
            System.out.println("URL2 wrong, Test failed");
            System.out.println("ExpectedURL2:" + expectedURL2);
            System.out.println("actualURL2:" + actualURL2);
        }
        //Verifier que 'Logged in as username' est visible
        WebElement loggedInAsName = driver.findElement(By.className("fa"));
        if (loggedInAsName.isDisplayed()) {
            System.out.println("Logged is as username testing passed ");
        } else
            System.out.println("Logged is as username testing failed ");


        //delete account
       /* WebElement deleteAccount = driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[5]/a"));
        deleteAccount.click();
        //verifier que 'ACCOUNT DELETED!' est visible et cliquer le bouton 'Continue'
        //WebElement accountDeleted = driver.findElement(By.xpath("/html/body/section/div/div/div/h2"));
        String actualText = driver.findElement(By.xpath("/html/body/section/div/div/div/h2/b")).getText();
        String expectedMsg = "ACCOUNT DELETED!";
        //Assert.assertEquals(actualText,expectedMsg);

        if (actualText.equals(expectedMsg)) {
            System.out.println("account deleted! Test passed");
        } else
            System.out.println("account deleted! Test failed");
            */

// failed result

    }
}