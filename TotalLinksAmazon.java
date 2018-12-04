package com.ibm.seleniumassignments;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TotalLinksAmazon {
	public static void main(String[] args){
		//About the program
		System.out.println("This program will find out the total number of link under Laptops from Amazon");
		//Set property for chrome driver
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver chrdriver=new ChromeDriver();
		//Explicit Wait
		WebDriverWait wait=new WebDriverWait(chrdriver, 60); 
		//To maximize the window
		chrdriver.manage().window().maximize();
		//Implicit Wait
		chrdriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//Launch page
		chrdriver.get("https://www.amazon.in/");
		String url=chrdriver.getCurrentUrl();
		System.out.println("Application URL: "+url);
		String title=chrdriver.getTitle();
		System.out.println("Initial Page Title: "+title);
		//To find the search box
		WebElement searchEle= chrdriver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchEle.click();
		//To enter 'Laptop' text in search box
		searchEle.sendKeys("Laptops");
		//To find and click the search icon
		WebElement submitEle= chrdriver.findElement(By.xpath("//input[@value='Go']"));
		submitEle.click();
		//To find the no.of links in the loaded search result page
		List<WebElement> linksEle=chrdriver.findElements(By.tagName("a"));
		int noOfLinks=linksEle.size();
		System.out.println("No.of links in the loaded search result page is: "+noOfLinks);
		//To print the links
		for(int i=0;i<noOfLinks;i++)
		{
			WebElement linkEle= linksEle.get(i);
			String link=linkEle.getAttribute("href");
			System.out.println(link);
			String text= linkEle.getText();
			System.out.println(text);
		}
		System.out.println("This is the end of the program");
	}

}
