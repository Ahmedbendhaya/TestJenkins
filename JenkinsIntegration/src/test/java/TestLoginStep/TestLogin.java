package TestLoginStep;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Login.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TestLogin {
	WebDriver driver= null;
	LoginPage login;

	@Given("We have access to TA")

	public void we_have_access_to_TA() {
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is : "+projectPath);			
	    System.setProperty("webdriver.Edge.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2)); 
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.navigate().to("https://www.talan-academy.com/");
		System.out.print(driver.getCurrentUrl());
		driver.manage().window().maximize();
	}

	@When("i click on the login button")
	public void i_click_on_the_login_button()  {
		login = new LoginPage(driver) ;
		login.AccessLogin();
	}

	@When("^tap my (.*) and (.*)$")
	public void tap_my_ahmed_baha_eddine_ben_dhaya_talan_com_and_22080023Ahm_d(String mail, String password) {
	   login.Login_information(mail, password);
	}

	@When("click on SE CONNECTER")
	public void click_on_SE_CONNECTER() {
		login.connect();
	}

	@Then("my account must be displayed")
	public void my_account_must_be_displayed() throws InterruptedException {
		if (driver.getCurrentUrl().contains("https://www.talan-academy.com/apprenti/dashboard"))
		login.Verifyconncorrect();
		else 
			login.VerifyconnIncorrect();
			}
		
		}

