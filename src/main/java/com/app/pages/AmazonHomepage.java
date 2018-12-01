package com.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.app.utility.DriverUtil;

/**
 * The Class AmazonHomepage.
 */
public class AmazonHomepage {
	
	/** images locator. */
	By locateImagesOnHomepage = By.xpath("//img/parent::a");
	
	/**
	 * Gets the images on amazon homepage.
	 *
	 * @return the list of images on amazon homepage
	 */
	private List<WebElement> getImagesOnHomepage() {
		 return DriverUtil.getDriver().findElements(locateImagesOnHomepage);
	}
	
	/**
	 * Prints the HREF of images.
	 */
	public void printHREF() {
		List<WebElement> allImages = getImagesOnHomepage();
		if(allImages.size() != 0) {
			System.out.println("******************** There are "+allImages.size()+" HREFs on Amazon Homepage ********************");
			for(WebElement element : allImages) {
				String href = element.getAttribute("href");
				System.out.println("----- "+href+ " -----");
			}
		}
		else {
			System.out.println("---------------- NO HREFs TO PRINT ----------------");
		}
	}
}
