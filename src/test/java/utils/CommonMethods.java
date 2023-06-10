package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonMethods {
    public static WebDriver driver;

    public static void setUp(){
        ConfigReader.readProperties(Constants.configurationFilePath);
        switch (ConfigReader.getPropertyValue("browser")){

            case "chrome":
              //  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver2.exe");
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "Firefox":
               // System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

    }


    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);

    }

    public static WebDriverWait getWait(){
        WebDriverWait wait=new WebDriverWait(driver, Constants.EXPLICITWAIT);
        return wait;
    }

    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }

    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        return js;
    }

    public static void jsClick(WebElement element){
        getJSExecutor().executeScript("arguments[0].click()", element);
    }

     public static byte[] takeScreeShot(String fileName){
         TakesScreenshot ts=(TakesScreenshot) driver;

         byte [] picBytes=ts.getScreenshotAs(OutputType.BYTES);

         File sourceFile=ts.getScreenshotAs(OutputType.FILE);
          try {
              FileUtils.copyFile(sourceFile, new File(Constants.screenShotPath + fileName +" " + timeStamp("yyyy-MM-dd-HH-mm-ss") +".png"));
          }catch (IOException e){
              e.printStackTrace();
          }
          return picBytes;
     }

     public static String timeStamp(String pattern){
         Date date=new Date();
         SimpleDateFormat sdf=new SimpleDateFormat(pattern);
         return sdf.format(date);
     }

    public void closBrowser(){
        driver.quit();
    }

}
