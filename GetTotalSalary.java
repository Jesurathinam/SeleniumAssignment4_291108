package com.ibm.seleniumassignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetTotalSalary {
	public static void main(String[] args){
		//About the program
		System.out.println("This program will find out the total salary of all the employees in the page");
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
		chrdriver.get("https://datatables.net/");
		String url=chrdriver.getCurrentUrl();
		System.out.println("Application URL: "+url);
		String title=chrdriver.getTitle();
		System.out.println("Initial Page Title: "+title); 
		//To get the no.of rows in the table of a loaded page
		List<WebElement> rowCount= chrdriver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		int noOfRows=rowCount.size();
		System.out.println("No.of rows in the current table: "+noOfRows);
	    int totalSalary=0;
		for(int i=1;i<=(noOfRows*2);i++)
		{
			//To position the 'i'th row and first column of the table
			WebElement nameEle= chrdriver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[1]"));
			nameEle.click();
			String name1=nameEle.getText();
			//To position and to get the salary information displayed below the name
			WebElement salaryEle= chrdriver.findElement(By.xpath("//table[@id='example']/tbody/tr["+(i+1)+"]/td[1]"));
			//To get only the numeral part
			String empSalary=salaryEle.getText().trim().replace("Salary","").replace(" ","").replace("$","").replace(",","");
			System.out.println(name1+" Salary is: "+empSalary);
			//To convert string to integer
			totalSalary = totalSalary+Integer.parseInt(empSalary);
			i++;
		}
		System.out.println("Total salary on Page 1: "+totalSalary);
		System.out.println("This is the end of the program");
	}

}
