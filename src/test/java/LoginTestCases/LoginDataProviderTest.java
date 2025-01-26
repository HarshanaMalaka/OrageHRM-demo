package LoginTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;


public class LoginDataProviderTest {

    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }


    @DataProvider( name= "loginData")
    public String[][] loginDataProvider(){
        String[][] data = {
                {"Admin","admin123","valid"},
                {"Admin123","Admin","invalid"},
                {"Admin123","admin123","invalid"},
                {"Admin","Admin123","invalid"}
        };
        return data;
    }



    @Test(dataProvider = "loginData")
    public void LoginTestScenario(String uName,String pass,String validation) throws InterruptedException {
        WebElement username= driver.findElement(By.xpath("//input[@Placeholder='Username']"));
        username.sendKeys(uName);
        WebElement password= driver.findElement(By.xpath("//input[@Placeholder='Password']"));
        password.sendKeys(pass);
        WebElement submit= driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();

        Thread.sleep(2000);

        boolean urlVerification = driver.getCurrentUrl().contains("dashboard");

        if (validation.equals("valid")){
            Assert.assertTrue(urlVerification,"Login Success but not redirecting to the Dashboard");

        }else{
            Assert.assertFalse(urlVerification,"Login Unsuccessful but redirecting to the dashboard ");
        }

    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }

}
