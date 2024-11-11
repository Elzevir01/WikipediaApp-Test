package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;

public class WikipediaAppBase extends pageModel.Base {

private By saltar = AppiumBy.id("org.wikipedia:id/fragment_onboarding_skip_button");
private By buscar = By.xpath("//android.widget.TextView[@text=\"Buscar en Wikipedia\"]");
private By busquedaArgentina = AppiumBy.id("org.wikipedia:id/search_src_text");
private By primerResultado = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='org.wikipedia:id/search_results_list']/android.view.ViewGroup[1]");
//private By contenedor
	
public WikipediaAppBase(WebDriver driver) {
	super.driver = driver;
	PageFactory.initElements(driver, this);
}
public WikipediaAppBase() {
	
}
public void tapSaltar() {
	findElemento(saltar).click();
}
}

