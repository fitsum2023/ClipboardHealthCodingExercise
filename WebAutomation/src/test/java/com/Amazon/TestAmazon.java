package com.Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Amazon.pages.AmazonHomePage;

public class TestAmazon {
	 WebDriver driver;
	@Test
	public void testAmazonSearchFilter() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		AmazonHomePage homepage = new AmazonHomePage(driver);
		homepage.openAmazonPage();
		homepage.clickHamburgerMenu();
		homepage.clickTVAppliancesAndElectronicsCategory();
		homepage.clickOnTelevisions();
		homepage.clickOnSamsung();
		homepage.sortSamsungPriceHighToLow();
		homepage.clickOnSecondHighestPrice();
		homepage.switchTheWindow();
		homepage.assertAboutThisItemSection();
	}

	@AfterMethod
	public void tearDown() {
		WebDriver driver = new ChromeDriver();
		driver.close();
		driver.quit();
	}
}
