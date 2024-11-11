package driver;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


public class BrowserFactory {
	AndroidDriver driver;
	

	public BrowserFactory() {

	}

	private static DriverFactory instance = new DriverFactory();

	public static DriverFactory getInstance() {
		return instance;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriver setDriver(String nodeURL) throws MalformedURLException {
		System.getProperty("java.classpath");
		new DesiredCapabilities();
			try {
					UiAutomator2Options options = new UiAutomator2Options()
						.setPlatformName("Android")
						.setDeviceName("emulator-5554")
						.setUdid("emulator-5554")
						.setPlatformVersion("11.0")
						.setAdbExecTimeout(Duration.ofSeconds(150))
						.setAutomationName("UiAutomator2")
						.setAppPackage("org.wikipedia")
						.setAppActivity("org.wikipedia.main.MainActivity")
						.setNewCommandTimeout(Duration.ofSeconds(60))
						.setAdbExecTimeout(Duration.ofSeconds(60))
						.setApp(appPath())
						.setChromedriverUseSystemExecutable(true);
						
						
				driver = new AndroidDriver(new URL(nodeURL),options);//RemoteWebDriver AppiumDriver AndroidDriver
				
			}catch(Exception exp) {
				System.out.println("Cause is : "+exp.getCause());
				System.out.println("Message is : "+exp.getMessage());
				exp.printStackTrace();
			}
			
		return driver;

	}

	public void removeDriver() {
		driver.close();
		driver.quit();

	}
	public void installApp(String appName) {
		String actualDir = System.getProperty("user.dir"+File.separator+"APK"+File.separator);
		System.out.println(actualDir+appName);
	    driver.installApp(actualDir+appName);
	    System.out.println("App instalada exitosamente.");
	}
	public String appPath() {
		String actualDir = System.getProperty("user.dir"+File.separator+"APK"+File.separator);
		String fullPath = actualDir+"Wikipedia_2.7.50508-r-2024-11-06_APKPure";
		return  fullPath;
	}

}
