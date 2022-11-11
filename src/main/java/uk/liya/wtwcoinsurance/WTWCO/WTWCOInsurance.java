package uk.liya.wtwcoinsurance.WTWCO;

import java.util.ArrayList;

public class WTWCOInsurance {

	protected SeleniumFunction fncts = new SeleniumFunction();
	public String actualText, expectedText, validateURLs = null;
	public String totalArticles = null;
	public int i, total;
	public ArrayList<String> resultURLs, resultURLsList = new ArrayList<String>();

	/*
	 * Opens the WTWCTO site and accepts web page cookies
	 */
	public void openWTWCOSite() {
		try {
			fncts.openURLInBrowser("browser", "exeLocation", "url");
			fncts.click("id", "acceptCookies");
			actualText = fncts.getText("xpath", "menu");
			System.out.println(actualText);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
	}

	/*
	 * Changes location to US and language to English
	 */
	public void changeLangToEng() {
		try {
			Thread.sleep(5000);
			fncts.click("xpath", "langDropdown");
			fncts.click("xpath", "selectAmericas");
			fncts.scrollToBottomOfPage();
			fncts.click("xpath", "selectLangEng");
			actualText = fncts.getText("xpath", "getLocationLang").substring(9, 16);
			System.out.println(actualText);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
	}

	/*
	 * Search IFRS17 in WTWCO web page
	 */
	public void searchForIFRS17() {
		try {
			fncts.click("xpath", "searchButton");
			Thread.sleep(2000);
			fncts.sendKeys("xpath", "searchTextBox", "searchTextValue");
			Thread.sleep(2000);
			fncts.sendKeysEnter();
			Thread.sleep(7000);
			actualText = fncts.getText("xpath", "afterSearchText").substring(0, 7);
			System.out.println(actualText);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
	}

	/*
	 * Sort the search results by Date in WTWCO web page
	 */
	public void sortByDate() {
		try {
			fncts.click("xpath", "selectSortByDate");
			Thread.sleep(5000);
			actualText = fncts.getText("xpath", "selectSortByDate");
			System.out.println(actualText);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
	}

	/*
	 * Select filter by Article in WTWCO web page
	 */
	public void filterByArticle() {
		try {
			fncts.scrollPageUntilVisible("xpath", "filterArticle");
			fncts.click("xpath", "filterArticle");
			Thread.sleep(3000);
			fncts.scrollPageUntilVisible("xpath", "menu");
			actualText = fncts.getText("xpath", "filterSelection");
			System.out.println(actualText);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
	}

	/*
	 * Saving all the search result article links to validate
	 */
	public void collectArticleLinks() {
		try {
			totalArticles = fncts.getText("xpath", "totalNoOfArticles");
			total = Integer.parseInt(totalArticles) / 10;
			for (i = 0; i <= total; i++) {
				resultURLs = (fncts.getTextList("xpath", "resultURL"));
				if (i < 1) {
					fncts.scrollToBottomOfPage();
					fncts.click("xpath", "clickNextPageResults");
					Thread.sleep(5000);
					fncts.scrollPageUntilVisible("xpath", "menu");
				}
				resultURLsList.addAll(resultURLs);
			}
			System.out.println(resultURLsList);

			for (String urlsCheck : resultURLsList) {
				validateURLs = urlsCheck.substring(0, 28);
			}

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
	}

	/*
	 * To close WTWCO page
	 */
	public void closeBrowser() {
		fncts.close();
	}
}
