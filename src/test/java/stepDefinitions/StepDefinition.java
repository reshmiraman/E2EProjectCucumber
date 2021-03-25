package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.PortalHomePage;
import resources.Base;

public class StepDefinition extends Base {

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_Site(String arg1) throws Throwable {
		driver.get(arg1);
	}

	@Given("^Click on Login link in home page to land on Secure sign in Page$")
	public void click_on_Login_link_in_home_page_to_land_on_Secure_sign_in_Page() throws Throwable {

		LandingPage landing = new LandingPage(driver);
		if (landing.getPopUpSize() > 0) {
			landing.getPopUp().click();
		}
		landing.getLogin().click(); // driver.findElement(By.css()

	}

	@Then("^Verify that user is succesfully logged in$")
	public void verify_that_user_is_succesfully_logged_in() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		PortalHomePage p = new PortalHomePage(driver);
		Assert.assertTrue(p.getSearchBox().isDisplayed());
	}

	@When("^User enters (.+) and (.+) and logs in$")
	public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
	}

	@And("^close browsers$")
	public void close_browsers() throws Throwable {
		driver.quit();
	}

}
