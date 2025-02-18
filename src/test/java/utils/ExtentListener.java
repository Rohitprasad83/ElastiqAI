package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import org.elasticAI.BaseTest;

public class ExtentListener implements ITestListener {
    private ExtentTest test;
    
    @Override
    public void onTestStart(ITestResult result) {
        test = ExtentReportManager.getReportInstance().createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, result.getName() + " Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, result.getThrowable());
        
        // Take screenshot using static driver from BaseTest
        String screenshotPath = takeScreenshot(BaseTest.driver, result.getName());
        try {
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, result.getName() + " Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.getReportInstance().flush();
    }

    private String takeScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            return null;
        }
        
        File screenshotsDir = new File("test-output/screenshots");
        if (!screenshotsDir.exists()) {
            screenshotsDir.mkdirs();
        }
        
        // Save screenshot with relative path
        String fileName = "screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
        String filePath = System.getProperty("user.dir") + "/test-output/" + fileName;
        
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File(filePath);
            FileUtils.copyFile(source, destination);
            return fileName; // Return relative path for report
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
