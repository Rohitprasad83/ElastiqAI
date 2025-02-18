package org.elasticAI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public static WebDriver driver;
    public Logger logger;
    Properties properties;

    @BeforeSuite
    public void setup() {
        logger = LogManager.getLogger(getClass());
        logger.info("-----------------------------");
        logger.info("Starting the automation suite");

        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("config//config.properties");
            properties.load(fis);
        } catch (IOException e) {
            logger.info("file not loaded, check if the file exists");
        }
        String browser = properties.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
        } else {
            logger.error("Please check the properties file for browser type. Note - Supported Types are chrome, edge and firefox");
            return;
        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/table-sort-search-demo");
    }

    @AfterSuite
    public void tearDown() {
        logger.info("Closing the automation suite");
        if (driver != null) {
            driver.quit();
        }
    }
}
