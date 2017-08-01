package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import automation.config.GenericActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class uiCatalogPage extends MobileAppPage{
	GenericActions elements;
	
	@iOSFindBy(name = "UICatalog")
	protected WebElement uiCatlogHome;
	
	@iOSFindBy(name = "Buttons")
	protected WebElement buttons;
	
	
	
	@iOSFindBy(name = "SYSTEM (TEXT)")
	protected WebElement systenText;
	
	@iOSFindBy(name = "SYSTEM (CONTACT ADD)")
	protected WebElement systemContact;
	
	
	@iOSFindBy(name = "X Button")
	protected WebElement xbuttons;
	
	public uiCatalogPage(AppiumDriver driver) throws IOException{
		super(driver);
		elements = new GenericActions(driver);
	}
	
	public void clickonButtons(){
		if(elements.isElementPresent(buttons)){
			elements.click(buttons);
		}
	}
	
	public boolean verfyButtonsPage(){
		return elements.isElementPresent(systenText);
	}
	
	
	
	
	public boolean isUiCatalogPageDisplayed(){
		return elements.isElementPresent(uiCatlogHome);
	}
	
	
	
}
