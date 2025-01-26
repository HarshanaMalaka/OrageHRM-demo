Here's the updated README that reflects the generation of the emailable report and removes the license section:  

---

# OrangeHRM Login Automation Project  

## Project Description  
This project automates the login functionality of the OrangeHRM application using Selenium and TestNG. It employs a data-driven testing approach with Apache POI to read test data from Excel files. The framework generates an emailable HTML report for detailed test execution results.  

## Features  
- Automated testing of the login functionality.  
- Data-driven testing with Apache POI for Excel-based test data.  
- Organized test scripts using the TestNG framework.  
- Emailable HTML report for test execution summary.  

## Technologies Used  
- **Programming Language**: Java  
- **Automation Tool**: Selenium WebDriver  
- **Testing Framework**: TestNG  
- **Data Handling**: Apache POI  
- **Reporting**: Emailable HTML Report (TestNG built-in)  

## Prerequisites  
- Java JDK 8 or later installed.  
- Apache Maven installed for dependency management.  
- IntelliJ IDEA, Eclipse, or any Java IDE.  
- WebDriver (e.g., ChromeDriver) added to the system PATH.  

## Installation  
1. Clone the repository:  
   ```bash  
   git clone https://github.com/HarshanaMalaka/OrageHRM-demo.git
2. Open the project in your preferred IDE.  
3. Update the `pom.xml` file (if using Maven) to download the necessary dependencies.  

## Usage  
1. Configure the test data file (Excel) and place it in the `resources` folder.  
2. Run the TestNG XML file (`testng.xml`) from the IDE to execute the tests.  
3. After execution, an emailable HTML report will be generated in the `test-output` folder.  

## Report Location  
The emailable HTML report is located in the `test-output` folder as `emailable-report.html`. Open it in a browser to view the results.  

## Future Enhancements  
- Expanding automation coverage to other OrangeHRM modules.  
- Integration with CI/CD pipelines for continuous testing.  
- Enhanced reporting with tools like ExtentReports or Allure.  

---

Let me know if you’d like any other modifications! 😊
