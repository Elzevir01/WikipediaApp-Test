package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;

public class AppCalendario extends pageModel.Base {

	private By dia17 = By.xpath(
			"//android.view.View[@content-desc=\"miércoles, 17 de agosto, Sin eventos ni tareas\"]");
	//WebElement ele01 = driver.findElement(AppiumBy.id("com.samsung.android.calendar:id/month_view_pager"));

	private By contenedor = AppiumBy.id("com.samsung.android.calendar:id/month_view_pager");
	/////-- CONSTRUCTOR --/////
	public AppCalendario(WebDriver driver) {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//////--METODOS---///////
	public void longAlbum() {
		longClick(findElemento(dia17));
	}
	
	public WebElement container() {
		return findElemento(contenedor);
	}
}

