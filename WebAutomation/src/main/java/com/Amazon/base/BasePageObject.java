package com.Amazon.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject<T> {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	protected BasePageObject(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 40);
	}
	@SuppressWarnings("unchecked")
	protected T getPage(String url){
		driver.get(url);
		return (T) this; 
	}
	protected void type(String text, By element){
		find(element).sendKeys(text);
	}
	protected WebElement find(By element) {
		return driver.findElement(element);
	}
	protected void click(By element){
		find(element).click();
	}
	protected void clear(By element){
		find(element).clear();
	}
	protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds){
		int attempts = 0;
		while (attempts < 2){
			try{
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator), (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
			} catch (StaleElementReferenceException e){			
			}	
			attempts ++;
			}
		}
	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds){
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30; 
			wait.until(condition);
	}
	protected void scrollDown(By element){
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	protected void scrollUp(By element){
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_UP).build().perform();
	}
	protected void scrollDownToElement(By element){
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(element));
		actions.perform();
	}
	
}

