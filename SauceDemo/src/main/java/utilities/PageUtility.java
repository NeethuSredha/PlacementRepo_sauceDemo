package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public void dropDownSelectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void dropDownSelectByIndex(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public void dropDownSelectByValue(WebElement element, String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	public void dragAndDrop(WebElement source, WebElement dest,WebDriver driver) {
		Actions action=new Actions(driver);
		action.dragAndDrop(source, dest).build().perform();
	}
	
	public void rightClick(WebElement element,WebDriver driver) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	
	public void hoverOver(WebElement element,WebDriver driver) {
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
		
	}
	
	public void javascriptClick(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void javascriptScrollDown(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,150)", element);
	}	
	
	public void javascriptScrollUp(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-150)", element);
	}	
	
	public void javascriptFullScroll(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", element);
	}
	
	public void javascriptValueInput(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='value';", element);
	}
}
