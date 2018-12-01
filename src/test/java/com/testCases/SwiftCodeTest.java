package com.testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.app.pages.MalaysiaSwiftCodePage;
import com.app.utility.Constant;
import com.app.utility.SeleniumUtil;

public class SwiftCodeTest {
	
	@Test(description="Assignment2", priority=2)
	public void testMalaysiaSwiftCodeTable() {
		System.out.println("********************************************************** ASSIGNMENT 2 Starting **********************************************************");
		SeleniumUtil seleniumUtilObj = new SeleniumUtil();
		MalaysiaSwiftCodePage swiftPageObj = new MalaysiaSwiftCodePage();
		seleniumUtilObj.navigateTo(Constant.SWIFTCODE_URL);
		String expectedTitle = "SWIFT Code for all Banks in Malaysia";
		AssertJUnit.assertEquals(seleniumUtilObj.getPageTitle(), expectedTitle);
		swiftPageObj.scrollToElement();
		List<WebElement> allBanks = swiftPageObj.fetchColumnData("Bank or Institution");
		List<WebElement> allSwiftCodes = swiftPageObj.fetchColumnData("Swift Code");
		if(allBanks.size() == allSwiftCodes.size()) {
			for(int i=0; i<allBanks.size(); i++) {
				System.out.println(allBanks.get(i).getText()+" --> "+allSwiftCodes.get(i).getText());
			}
		}
		else {
			System.out.println("---------------- UNEVEN LIST SIZE COMPARISON ----------------");
		}
		seleniumUtilObj.closeDriver();
		System.out.println("************************************************************* ASSIGNMENT 2 Ended **************************************************************");
	}
}
