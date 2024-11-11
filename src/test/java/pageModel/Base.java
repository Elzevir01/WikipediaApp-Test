package pageModel;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Base {
	WebDriver driver;
	WebElement elemento;

	String expectedTitle = "";

	///// CONSTRUCTOR/////
	public Base(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Base() {

	}
	//// METODOS/////

	public WebElement findElemento(By elemento) {
		return driver.findElement(elemento);
	}

	public void clickElemento(By elemento) {
		driver.findElement(elemento).click();
	}

	public String textoElemento(By elemento) {
		return driver.findElement(elemento).getText();
	}

	public void longClick(WebElement elemento) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) elemento).getId()));
	}

	public void scroll(WebElement elemento,String direccion) {// AndroidDriver driver

		//WebElement elemento = driver.findElement(AppiumBy.id("com.samsung.android.calendar:id/month_view_pager"));

		int centerX = elemento.getRect().x + (elemento.getSize().width / 2);
		int centerY = elemento.getRect().y + (elemento.getSize().width / 2);
		
		double startY=0;
		double endY=0;
		double startX=0;
		double endX=0;

		if (direccion == "arriba") {
			startY = elemento.getRect().y + (elemento.getSize().height * 0.9);
			endY = elemento.getRect().y + (elemento.getSize().height * 0.1);

		} else if (direccion == "abajo") {
			startY = elemento.getRect().y + (elemento.getSize().height * 0.1);
			endY = elemento.getRect().y + (elemento.getSize().height * 0.9);
		}
		if (direccion == "izquierda") {
			startX = elemento.getRect().x + (elemento.getSize().width * 0.9);
			endX = elemento.getRect().x + (elemento.getSize().width * 0.1);

		} else if (direccion == "derecha") {
			startX = elemento.getRect().x + (elemento.getSize().width * 0.1);
			endX = elemento.getRect().x + (elemento.getSize().width * 0.9);
		}
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

		Sequence swipe = new Sequence(finger, 1);
		
		if(direccion=="arriba" || direccion=="abajo") {
		swipe.addAction(
				finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), centerX, (int)startY));

		swipe.addAction(finger.createPointerDown(0));

		swipe.addAction(
				finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), centerX, (int)endY));
		}
		if(direccion=="izquierda" || direccion=="derecha") {
			swipe.addAction(
					finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), (int)startX, centerY));

			swipe.addAction(finger.createPointerDown(0));

			swipe.addAction(
					finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), (int)endX, centerY));
			}
		swipe.addAction(finger.createPointerUp(0));

		((AndroidDriver) driver).perform(Arrays.asList(swipe));
	}


}
