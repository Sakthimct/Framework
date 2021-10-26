package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.utilities.BaseClass;

public class MavenTest extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.
		
		loadUrl("https://en-gb.facebook.com/");
		
		winMax();
		
		printTitle();
		
		WebElement user = driver.findElement(By.id("email"));
		
		Fill(user, "Greens");
		
		WebElement pass = driver.findElement(By.id("pass"));
		
		Fill(pass, "greens@123");
		
		WebElement login = driver.findElement(By.xpath("//button[@name='login']"));
		
		clk(login);
		
		Thread.sleep(2000);
		
		printCurrentUrl();

		
	}
	
	
}
