package automation.stepdefs;


import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import browsers.Hooks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import pages.FlipkartHomePage;
import pages.uiCatalogPage;

public class uiCatalogApp {
	AppiumDriver driver;
	private uiCatalogPage uicatlogpage;
	Hooks hooks = new Hooks();
	Logger log = LoggerFactory.getLogger(uiCatalogApp.class);
	
	public uiCatalogApp() throws IOException{
		this .driver=(AppiumDriver) hooks.getDriver();
		this.uicatlogpage = new uiCatalogPage(this.driver);
	}

	@Given("^uiCatalog app is launched$")
	public void uiCatalog_app_launched() throws MalformedURLException{
		Assert.assertTrue("page not displayed", uicatlogpage.isUiCatalogPageDisplayed());
		log.info("uiCatalog app launched");
	}
	
	@When("^user clicks on buttons$")
	public void user_Click_onButtons() throws InterruptedException{
		uicatlogpage.clickonButtons();
		
		log.info(" clicked on buttons ");
	}
	
	@Then("^buttons page displayed$")
	public void buttons_page_displayed(){
		Assert.assertEquals(uicatlogpage.verfyButtonsPage(), true);
		log.info("Verified the result");
	}
}
