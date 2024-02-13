package practiceprograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitstatments {

	 public static void main(String[] args) {
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        
	        // Click the button to show the alert
	        driver.findElement(By.id("alert")).click();
	        // Wait for the alert to be present
	        wait.until(ExpectedConditions.alertIsPresent());
	        // Switch to the alert and accept it
	        driver.switchTo().alert().accept();
	        System.out.println("Successfully Alert Clicked");

	        // Click the button to populate text
	        driver.findElement(By.id("populate-text")).click();
	        String expectedText = "Selenium Webdriver";
	        
	        
	        boolean elementVisible = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("h2"), expectedText));
	        
	        
	        if (elementVisible) {
	            System.out.println("Element with text '" + expectedText + "' became visible");
	        } else {
	            System.out.println("Element with text '" + expectedText + "' is still not visible");
	        }
	        
	        driver.findElement(By.xpath("//button[@id='display-other-button']")).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='hidden']")));
	        driver.findElement(By.xpath("//button[@id='hidden']")).click();
	        System.out.println("Buttion Enable");
	        
	        driver.findElement(By.xpath("//button[@id='checkbox']")).click();
	        wait.until(ExpectedConditions.elementToBeSelected(By.id("ch")));
	        System.out.println("Checkbox Clicked");
	        
	        driver.quit();
	    }
	}
