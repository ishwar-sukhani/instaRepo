package com.app.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.app.utility.DriverUtil;

/**
 * The Class MalaysiaSwiftCodePage.
 */
public class MalaysiaSwiftCodePage {
	
	/** table locator. */
	String locateTable = "//table[@class='swift']";
	
	/**
	 * Scroll to element.
	 */
	public void scrollToElement() {
		String script = "arguments[0].scrollIntoView();";
		((JavascriptExecutor)DriverUtil.getDriver()).executeScript(script, DriverUtil.getDriver().findElement(By.xpath(locateTable)));
	}
	
	/**
	 * Fetch column position.
	 *
	 * @param columnHeading the column heading
	 * @return the int position of column
	 */
	private int fetchColumnPosition(String columnHeading) {
		int position = -1;
		String tableHeaderXPath = locateTable + "//th";
		List<WebElement> tableHeaderList = DriverUtil.getDriver().findElements(By.xpath(tableHeaderXPath));
		for(WebElement e : tableHeaderList) {
			if(e.getText().equalsIgnoreCase(columnHeading))
				position = tableHeaderList.indexOf(e) + 1;
		}
		return position;
	}
	
	/**
	 * Fetch column data.
	 *
	 * @param columnHeading the column heading
	 * @return the list of column data
	 */
	public List<WebElement> fetchColumnData(String columnHeading) {
		int colPos = fetchColumnPosition(columnHeading);
		String tableDataXPath = "";
		if(colPos != -1) {
			tableDataXPath = locateTable + "//tr/td["+ colPos + "]";
			return DriverUtil.getDriver().findElements(By.xpath(tableDataXPath));
		}
		else {
			System.out.println("---------------- INVALID COLUMN POSITION or VALUE IN XPATH FOR COLUMN = " +columnHeading+" ----------------");
			return new ArrayList<WebElement>();
		}
			
	}
}
