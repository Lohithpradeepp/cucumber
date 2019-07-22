package lp;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CS01 {
	 public static WebDriver driver;
	 public static WebDriverWait wait;

@Given("I want to Signup in the TestMeApp")
public void i_want_to_Signup_in_the_TestMeApp() {
    // Write code here that turns the phrase above into concrete actions
    
}

@When("I open the TestMeApp Using Url")
public void i_open_the_TestMeApp_Using_Url() {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\test\\Desktop\\pradeep\\chromedriver.exe");
	  
	  driver = new ChromeDriver();
	  
	  driver.get("http://192.168.40.4:8083/TestMeApp");
	  
	  driver.manage().window().maximize();
	  
	  driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	  
	  wait=new WebDriverWait(driver,120); 
}

@Then("Click on the SignUp Button")
public void click_on_the_SignUp_Button() {
	
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 
	  driver.findElement(By.linkText("SignUp")).click();
   
}

@Then("Fill the required fields")
public void fill_the_required_fields(io.cucumber.datatable.DataTable dataTable) {
	
	List<Map<String,String>> list = dataTable.asMaps(String.class,String.class);
	
	for ( int i=0 ; i<list.size();i++) {
	
	driver.findElement(By.id("userName")).sendKeys(list.get(i).get("UserName"));
	
	driver.findElement(By.id("firstName")).sendKeys(list.get(i).get("First Name"));
	  
	  driver.findElement(By.id("lastName")).sendKeys(list.get(i).get("Last Name"));
	  
	  driver.findElement(By.id("password")).sendKeys(list.get(i).get("Password"));
	  
	  driver.findElement(By.id("pass_confirmation")).sendKeys(list.get(i).get("Confirm Password"));
	  
	  switch (list.get(i).get("Gender")) {
	case "M":
		
		driver.findElement(By.xpath(".//span[contains(text(),'Male')]")).click();
		
		break;
	
	case "F":
		
		driver.findElement(By.xpath(".//span[contains(text(),'Female')]")).click();
	
		break;
	}
	  
	  driver.findElement(By.xpath(".//span[contains(text(),'Male')]")).click();
	
	  
	  driver.findElement(By.id("emailAddress")).sendKeys(list.get(i).get("E -Mail"));
	  
	  driver.findElement(By.id("mobileNumber")).sendKeys(list.get(i).get("Mobile Number"));
	  
	  driver.findElement(By.id("dob")).sendKeys(list.get(i).get("DOB"));
	  
	  driver.findElement(By.id("address")).sendKeys(list.get(i).get("Address"));
	  
	  driver.findElement(By.id("answer")).sendKeys(list.get(i).get("Answer"));
	
	} 
}

@Then("Click on the Register Button")
public void click_on_the_Register_Button() throws InterruptedException {
	
	 driver.findElement(By.name("Submit")).click();
	 Thread.sleep(3000);
	 driver.close();
   
 }

}
