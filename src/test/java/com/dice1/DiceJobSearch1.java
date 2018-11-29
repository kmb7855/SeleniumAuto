package com.dice1;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch1 {
	public static void main(String[] args)throws Exception  {
				
				WebDriverManager.chromedriver().setup();
				WebDriver dr=new ChromeDriver();
				dr.manage().window().maximize();
				dr.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				
				
				dr.get("https://www.dice.com/");
				String key="SDET DEVELOPER";
				String act=dr.getTitle();
				String exp="Find Jobs in Tech | Dice.com";
				
				
				if (act.equals(exp)) {
					System.out.println("pass");
				}else {
					System.out.println("fail");
					throw new Exception("check again");
				}
				
				dr.findElement(By.id("search-field-keyword")).clear();
				dr.findElement(By.id("search-field-keyword")).sendKeys(key);
				String location="77478";
				dr.findElement(By.id("search-field-location")).clear();
				dr.findElement(By.id("search-field-location")).sendKeys(location+Keys.ENTER);
				String count=dr.findElement(By.id("posiCountMobileId")).getText();
				System.out.println(count);
				int crt=Integer.parseInt(count);
			
							
						if (crt>0) {
					System.out.println("Step pass. key :" +key +" search returned "+ crt +" result in " +location);
				}else {
					System.out.println("\"Step fail:  key :\" +key +\" search returned \"+ countR +\"result in \" +location..");
				}

				dr.close();
				System.out.println("Test completed : " +LocalDateTime.now());
					
				}
}
				
			




	