package org.test.my_app_test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
        System.out.println( "Hello World!" );
        
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.facebook.com/");

        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

        WebElement email = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("pass"));
        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button"));
        Thread.sleep(2000);
        email.sendKeys("patelprajal96@gmail.com");
        password.sendKeys("admin123");
        Thread.sleep(2000);
        submitButton.click();
        Thread.sleep(2000);
        
       // WebElement message = driver.findElement(By.id("message"));
       // System.out.println(message.getText());

        
    
    
    TakesScreenshot srcShot = ((TakesScreenshot)driver); 
    File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
    File destFile = new File("test-report.jpg");
    FileUtils.copyFile(srcFile, destFile);
    driver.quit();
    }
}
