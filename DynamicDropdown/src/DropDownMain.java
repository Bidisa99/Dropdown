import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownMain {

	public static void main(String[] args) throws InterruptedException {
		
			WebDriver driver = new ChromeDriver();
			
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			
			
			driver.get("https://www.airindia.com/in/en/flights.html?route=&Header=true&Carousel="
					+ "false&promocode=true&usepoints=true&offers=false&FlywithMaharaja=true&utm_source="
					+ "google&utm_medium=cpc&utm_campaign=Acquisition_Perform_SEM_Alltraveltype_India_BAU_"
					+ "Prospecting_Brand_Terms_Allrout_Allsector_NullHaul_NullB_Desktop_EM&gad_source=1&gclid="
					+ "Cj0KCQjw5cOwBhCiARIsAJ5njubOt-beHvzx9hFb0Ub-4x4DkBHFfzu4E8cVvH0zYyaI_H3CjSj8u4QaAo1qEALw_wcB");
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			driver.manage().window().maximize();
			
			WebElement acceptButton = null;
			try {
			    acceptButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
			    wait.until(d -> driver.findElement(By.id("onetrust-accept-btn-handler")).isDisplayed());
							 
			} catch (org.openqa.selenium.NoSuchElementException e) {
			    // If the element is not found, acceptButton will remain null
			}

			// Check if the acceptButton WebElement is not null (i.e., the button is present)
			if (acceptButton != null && acceptButton.isDisplayed()) {
			    // Click on the accept button
			    acceptButton.click();
			    System.out.println("Cookiee button found and closed...");
			} else {
			    // If the button is not present or not visible, perform the next step of your automation
			    System.out.println("Accept button not found or not visible. Proceeding to the next step...");
			}
			
			driver.findElement(By.id("From")).click();
			driver.findElement(By.xpath("//div[@title=' Abu Dhabi, United Arab Emirates, AE']")).click();
			
			driver.findElement(By.id("To")).click();
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", 
					driver.findElement(By.xpath("//div[@title=' Bengaluru, India, IN']")));
			
			wait.until(d -> driver.findElement(By.xpath("//div[@title=' Bengaluru, India, IN']")).isDisplayed());

			driver.findElement(By.xpath("//div[@title=' Bengaluru, India, IN']")).click();
		
			System.out.println(driver.findElement(By.id("To")).getAttribute("value"));
			driver.quit();
	}

}
