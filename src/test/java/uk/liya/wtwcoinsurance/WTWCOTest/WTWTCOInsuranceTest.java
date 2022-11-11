package uk.liya.wtwcoinsurance.WTWCOTest;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import uk.liya.wtwcoinsurance.WTWCO.WTWCOInsurance;

public class WTWTCOInsuranceTest extends WTWCOInsurance {
	@Test(priority = 1, description = "Verifies if WTWCTO site is open")
	public void openWTWCOSiteTestTC01() {
		openWTWCOSite();
		assertEquals(actualText, "Menu");
	}

	@Test(priority = 2, description = "Verifies if WTWCO site has location set to US and language as English")
	public void changeLangToEngTestTC02() {
		changeLangToEng();
		assertEquals(actualText, "US | EN");
	}

	@Test(priority = 3, description = "Verifies if IFRS17 is searched in WTWCO web page and results page is displayed")
	public void searchForIFRS17TestTC03TC04() {
		searchForIFRS17();
		assertEquals(actualText, "Results");
	}

	@Test(priority = 4, description = "Verifies if WTWCO page search results are sorted by Date")
	public void sortByDateTC05() {
		sortByDate();
		assertEquals(actualText, "Date");
	}

	@Test(priority = 5, description = "Verifies if WTWCO page is filtered by content type as article")
	public void filterByArticleTC06() {

		filterByArticle();
		assertEquals(actualText, "Article");
	}

	@Test(priority = 6, description = "Verifies if all the search results url starts with 'https://www.wtwco.com/en-US/'")
	public void collectArticleLinksTest() {
		collectArticleLinks();
		assertEquals(validateURLs, "https://www.wtwco.com/en-US/");
	}

	@Test(priority = 7, description = "Verifies if browser is closed")
	public void closeBrowserTest() {
		closeBrowser();
	}

}
