package uk.liya.wtwcoinsurance.WTWCO;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
*All the selenium functions are available in the class file
*/
public class SeleniumFunction {

	public static WebDriver driver = null;
	static Properties data = ReadPropertyFile.loadPropertyFile("src\\resources\\data.properties");
	public static WebElement ele, elemt, element = null;
	public List<WebElement> eleList, elemtList = null;
	public List<WebElement> tst = null;
	public String textValue = null;
	public ArrayList<String> textValueList = new ArrayList<String>();

	/*
	 * To open a and maximize the chrome browser
	 */
	public void openURLInBrowser(String driverName, String driverExeLocation, String URL) {
		try {
			System.setProperty(data.getProperty(driverName),
					System.getProperty("user.dir") + data.getProperty(driverExeLocation));
			driver = new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			driver.manage().window().maximize();
			driver.get(data.getProperty(URL));
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

	/*
	 * Selenium function to find web element
	 */
	public WebElement findElement(String elementType, String elementKey) {
		try {
			switch (elementType) {
			case "xpath":
				elemt = driver.findElement(By.xpath(data.getProperty(elementKey)));
				break;
			case "id":
				elemt = driver.findElement(By.id(data.getProperty(elementKey)));
				break;
			case "class":
				elemt = driver.findElement(By.className(data.getProperty(elementKey)));
				break;
			case "name":
				elemt = driver.findElement(By.name(data.getProperty(elementKey)));
				break;
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return elemt;
	}

	/*
	 * Selenium function to find web elements
	 */
	public List<WebElement> findElements(String elementType, String elementKey) {
		try {
			switch (elementType) {
			case "xpath":
				elemtList = driver.findElements(By.xpath(data.getProperty(elementKey)));
				break;
			case "id":
				elemtList = driver.findElements(By.id(data.getProperty(elementKey)));
				break;
			case "class":
				elemtList = driver.findElements(By.className(data.getProperty(elementKey)));
				break;
			case "name":
				elemtList = driver.findElements(By.name(data.getProperty(elementKey)));
				break;
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return elemtList;
	}

	/*
	 * Selenium function to click
	 */
	public void click(String elementType, String elementKey) {
		try {
			ele = findElement(elementType, elementKey);
			ele.click();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

	/*
	 * Selenium function to get text value of a web element
	 */
	public String getText(String elementType, String elementKey) {
		try {
			ele = findElement(elementType, elementKey);
			textValue = ele.getText();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return textValue;
	}

	/*
	 * Selenium function to get web elements text values list
	 */
	public ArrayList<String> getTextList(String elementType, String elementKey) {
		try {
			eleList = findElements(elementType, elementKey);
			for (WebElement eleArticle : eleList) {
				textValueList.add(eleArticle.getText());
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return textValueList;
	}

	/*
	 * Selenium function to enter text in web page
	 */
	public void sendKeys(String elementType, String elementKey, String searchTextValue) {
		try {
			ele = findElement(elementType, elementKey);
			ele.sendKeys(data.getProperty(searchTextValue));
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

	/*
	 * Selenium function to enter any key in a web page
	 */
	public void sendKeysEnter() {
		try {
			ele.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

	/*
	 * Selenium function to scroll till bottom of the web page
	 */
	public void scrollToBottomOfPage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

	/*
	 * Selenium function to scroll till the element is visible in web page
	 */
	public void scrollPageUntilVisible(String elementType, String pathKey) {
		try {
			element = findElement(elementType, pathKey);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

	/*
	 * Selenium function to close the browser
	 */
	public void close() {
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

}
