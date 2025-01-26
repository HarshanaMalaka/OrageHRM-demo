# OrangeHRM Login Automation Project  

## Project Description  
This project automates the login functionality of the OrangeHRM application using Selenium and TestNG. It employs a data-driven testing approach with Apache POI for reading test data from Excel files. The framework is also configured to generate detailed test execution reports.  

## Features  
- Automated login functionality testing.  
- Data-driven testing using Apache POI for Excel integration.  
- Organized test scripts using the TestNG framework.  
- Detailed reports generated for test execution results.  

## Technologies Used  
- **Programming Language**: Java  
- **Automation Tool**: Selenium WebDriver  
- **Testing Framework**: TestNG  
- **Data Handling**: Apache POI  
- **Reporting**: TestNG built-in reporting  

## Prerequisites  
- Java JDK 8 or later installed.  
- Apache Maven installed for dependency management.  
- IntelliJ IDEA, Eclipse, or any Java IDE.  
- WebDriver (e.g., ChromeDriver) added to the system PATH.  

## Installation  
1. Clone the repository:  
   ```bash  
   git clone [<repository-url>](https://github.com/HarshanaMalaka/OrageHRM-demo)  
   ```  
2. Open the project in your preferred IDE.  
3. Update the `pom.xml` file (if using Maven) to download the necessary dependencies.  

## Usage  
1. Configure the `config.properties` file to set up the base URL and other necessary parameters.  
2. Place the test data in the `resources` folder (Excel file).  
3. Run the TestNG XML file from the IDE to execute the tests.  

## Report Generation  
After test execution, reports are automatically generated in the `test-output` folder. Open the `index.html` file in a browser to view the detailed report.  

## Future Enhancements  
- Adding automation scripts for additional OrangeHRM modules.  
- Integration with CI/CD pipelines.  
- Enhanced reporting with third-party tools like ExtentReports or Allure.  

## License  
This project is licensed under the [MIT License](LICENSE).  


