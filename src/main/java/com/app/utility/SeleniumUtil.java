package com.app.utility;

/**
 * The Class SeleniumUtil.
 */
public class SeleniumUtil {
	
	/**
	 * Instantiates Driver.
	 */
	public SeleniumUtil(){
		DriverUtil.setDriver();
	}
	
	/**
	 * Navigate to.
	 *
	 * @param URL the url
	 */
	public void navigateTo(String URL) {
		DriverUtil.getDriver().get(URL);
	}
	
	/**
	 * Gets the page title.
	 *
	 * @return the page title
	 */
	public String getPageTitle() {
		return DriverUtil.getDriver().getTitle();
	}
	
	/**
	 * Close driver.
	 */
	public void closeDriver() {
		DriverUtil.getDriver().quit();
	}
}
