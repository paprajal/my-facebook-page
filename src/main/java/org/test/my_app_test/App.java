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

        driver.get("http://100.27.227.74:8081/contact.html");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        
        driver.findElement(By.name("your_name")).sendKeys("Prajal");
        driver.findElement(By.name("phone_number")).sendKeys("1233456789");
        driver.findElement(By.name("email_address")).sendKeys("prajal123@gmail.com");
        driver.findElement(By.name("your_message")).sendKeys("Hello, How are you!!");
        driver.findElement(By.id("my-button")).click();
        String message = driver.findElement(By.id("response")).getText();
        System.out.println(message);
		/*
		 * driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		 * 
		 * WebElement email = driver.findElement(By.name("email")); WebElement password
		 * = driver.findElement(By.name("pass")); WebElement submitButton =
		 * driver.findElement(By.xpath(
		 * "/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button"
		 * )); Thread.sleep(2000); email.sendKeys("patelprajal96@gmail.com");
		 * password.sendKeys("admin123"); Thread.sleep(2000); submitButton.click();
		 * Thread.sleep(2000);
		 */
        
       // WebElement message = driver.findElement(By.id("message"));
       // System.out.println(message.getText());

        
    
    
    TakesScreenshot srcShot = ((TakesScreenshot)driver); 
    File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
    File destFile = new File("test-report.jpg");
    FileUtils.copyFile(srcFile, destFile);
    driver.quit();
    System.out.println("result captured");
    }
}
