package com.Amazon.pages;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Amazon.base.BasePageObject;


public class AmazonHomePage extends BasePageObject<AmazonHomePage> {
    private static final String URL = "https://www.amazon.in/";
    

    private By hamburgerMenu = By.cssSelector("a[data-csa-c-slot-id='HamburgerMenuDesktop']");
    private By tvAppliancesAndElectronics = By.xpath("//*[contains(text(), 'TV, Appliances, Electronics')]");
    private By tv =  By.linkText("Televisions");
    private By samsung = By.xpath("//span[contains(@class,'a-size-base a-color-base') and contains(text(), 'Samsung')]");
    private By sortBy = By.cssSelector("span.a-dropdown-label");
    private By highToLow = By.xpath("//a[contains(text(),'Price: High to Low')]");
    private By secondHighestPriceItem = By.cssSelector("div[data-cel-widget='search_result_3']");
    private By aboutText = By.xpath("//h1[contains(@class,'a-size-base-plus a-text-bold') and contains(text(), ' About this item ')]");
    
    
    public AmazonHomePage(WebDriver driver) {
		super(driver);
	}
	public void openAmazonPage(){
		getPage(URL);		
	}
	public void waitForAmazonHomePageLoad(){
		//waitForVisibilityOf(locator, timeOutInSeconds);
	}
	public void clickHamburgerMenu(){
		click(hamburgerMenu);	
	}
	public void clickTVAppliancesAndElectronicsCategory(){
		scrollDown(tvAppliancesAndElectronics);
		click(tvAppliancesAndElectronics);
	}
	public void clickOnTelevisions(){
		click(tv);	
	}
	public void clickOnSamsung() throws InterruptedException{
		Thread.sleep(5000);
		scrollDownToElement(samsung);
		click(samsung);
	}
	public void sortSamsungPriceHighToLow(){
		this.clickSortByDropDownButton();
		this.clickPriceHighToLowButton();
		
	}
	public void clickSortByDropDownButton(){
		click(sortBy);
	}
	public void clickPriceHighToLowButton(){
		click(highToLow);
	}
	public void clickOnSecondHighestPrice() throws InterruptedException{
		Thread.sleep(3000);
		scrollDownToElement(secondHighestPriceItem);
		click(secondHighestPriceItem);
	}
	public void switchTheWindow(){
		// It will return the parent window name as a String
		String parent=driver.getWindowHandle();

		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);

		System.out.println(driver.switchTo().window(child_window).getTitle());

		//driver.close();
		}

		}
		//switch to the parent window
		//driver.switchTo().window(parent);
	}
	public void assertAboutThisItemSection(){	
		String text = extractText(aboutText);
		Assert.assertEquals("About this item", text);
	}
	public String extractText(By element) {
		return find(element).getText();
	}
	


}
