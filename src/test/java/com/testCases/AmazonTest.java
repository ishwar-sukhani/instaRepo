package com.testCases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.app.pages.AmazonHomepage;
import com.app.utility.Constant;
import com.app.utility.SeleniumUtil;

public class AmazonTest {
	
	@Test(description="Assignment1", priority=1)
	public void testImagesOnAmazonHomepage() {
		System.out.println("********************************************************** ASSIGNMENT 1 Starting **********************************************************");
		AmazonHomepage amazonHomepageObj = new AmazonHomepage();
		SeleniumUtil seleniumUtilObj = new SeleniumUtil();
		seleniumUtilObj.navigateTo(Constant.AMAZON_URL);
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		AssertJUnit.assertEquals(seleniumUtilObj.getPageTitle(), expectedTitle);
		amazonHomepageObj.printHREF();
		seleniumUtilObj.closeDriver();
		System.out.println("************************************************************* ASSIGNMENT 1 Ended **************************************************************");
	}
}
