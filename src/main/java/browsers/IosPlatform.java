package browsers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automation.config.PlatformDetails;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


public final class IosPlatform {
	static Logger log = LoggerFactory.getLogger(Hooks.class);

	
	public static WebDriver configuredIosBrowser() throws IOException{
		final int waitSeconds = 30;
		WebDriver driver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", PlatformDetails.getDeviceName());
		capabilities.setCapability("platformVersion", PlatformDetails.getPlatformVersion()); 
		capabilities.setCapability("platformName", PlatformDetails.getPlatformName());
		capabilities.setCapability("browserName", PlatformDetails.getBrowserName());
		capabilities.setCapability("udid","b6e918b041f8ca24fefa7ed5a7dc7379ac2cd4d6");
				//PlatformDetails.getDeviceUdid());
		driver = new RemoteWebDriver(new URL(PlatformDetails.getAppiumHubURL()), capabilities);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(waitSeconds, TimeUnit.SECONDS);
		log.info("Opening Browser Session on " + PlatformDetails.getDeviceName() + " on "
				+ PlatformDetails.getBrowserName());
		return driver;
	}
	
	public static AppiumDriver configuredIosApp() throws IOException{
		final int waitSeconds = 30;
		IOSDriver driver = null;
		//File app = new File(PlatformDetails.getApkPath(), PlatformDetails.getApkName());
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("deviceName", PlatformDetails.getDeviceName());
		capabilities.setCapability("platformVersion", PlatformDetails.getPlatformVersion()); 
		capabilities.setCapability("platformName", PlatformDetails.getPlatformName());
		capabilities.setCapability("bundleId", PlatformDetails.getBundleId());
		//capabilities.setCapability("bundleId", "com.htsu.hsbcpersonalbanking");
		//capabilities.setCapability("app", "/Users/hsbc/Desktop/ipa/Flipkart 5.0.3.app");
		capabilities.setCapability("udid", PlatformDetails.getDeviceUdid());
		driver = new IOSDriver(new URL(PlatformDetails.getAppiumHubURL()), capabilities);
		driver.manage().timeouts().implicitlyWait(waitSeconds, TimeUnit.SECONDS);
		log.info("Launching App Session on " + PlatformDetails.getDeviceName());		
		return driver;
	}
	
	private IosPlatform(final DesiredCapabilities cap){
		super();
	}
}
