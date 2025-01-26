package LoginTestCases;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;


public class LoginDataProviderExcelTest {

    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @DataProvider(name = "loginData")
    public String[][] excelData() throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ "\\test-data\\Input_Data.xlsx") ;
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int totalRows=sheet.getLastRowNum();
        int totalColumns=sheet.getRow(0).getLastCellNum();
        System.out.println("Total Rows: " + totalRows);
        System.out.println("Total Columns: "+totalColumns);

        String[][] testData = new String[totalRows][totalColumns];


        for(int r=1;r<=totalRows;r++){

            for(int c=0;c<totalColumns;c++){
                testData[r-1][c] = sheet.getRow(r).getCell(c).toString();  //In first iteration: 2nd row(index 1) , 1st cell(index 1) pass to Test data array 0th, 0th position
            }

        }

        workbook.close();

        file.close();

        return testData;  // when returning - void change to String[][] ; if String doesn't support go with Object[][]


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
