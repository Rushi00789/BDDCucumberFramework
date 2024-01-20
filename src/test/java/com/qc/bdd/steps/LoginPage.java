package com.qc.bdd.steps;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage {
	WebDriver driver; 
	WebElement email; 
	WebElement pass;  
	WebElement submit;  
	WebElement logout;
	


	@Given("To launch the browser {string}")
	public void to_launch_the_browser(String browserName) {
		if (browserName.equals("chrome"))
		{    
		driver = new ChromeDriver();   
		   }else if(browserName.equals("edge")){
				driver = new EdgeDriver(); 
		   }
		
		else{ 
			driver = new FirefoxDriver();   
		}   
		driver.manage().window().maximize();
	}
	
	
	@Given("To enter the site url {string}")
	public void to_enter_the_site_url(String siteUrl) {
		driver.get(siteUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Given("To locate the elements")
	public void to_locate_the_elements() {
		email = driver.findElement(By.xpath("//input[@id='email']")); 
		pass = driver.findElement(By.xpath("//input[@id='password']"));   
		submit = driver.findElement(By.xpath("//button[@type='submit']")); 
		
		
	}
	@Given("To enter the uName {string}")
	public void to_enter_the_u_name(String username) {
	    email.clear();
		email.sendKeys(username);
		
	}
	@Given("To enter the uPass {string}")
	public void to_enter_the_u_pass(String password) {
	    pass.clear();
		pass.sendKeys(password);
		
	}
	@When("To click on submit button")
	public void to_click_on_submit_button() {
	    submit.click();
	}
		
	@Then("To validate the dashboard page title {string}")
	public void to_validate_the_dashboard_page_title(String expTitle) {
		String actualTitle = driver.getTitle();  
		Assert.assertEquals(actualTitle,expTitle);
	
		
	}
	@Then("To validate the Login page title {string}")
	public void to_validate_the_Login_page_title( String expTitle)  {
		String actualTitle = driver.getTitle();   
		Assert.assertEquals(actualTitle, expTitle);
	}
	
	@Then("To logout from the dashboard page")
	public void to_logout_from_the_dashboard_page() {
		logout = driver.findElement(By.id("hlogout"));
		logout.click();
	}

	@Then("To close the browser")
		public void to_close_the_browser() {
	    driver.close();
		}


}
