package tests;

import org.testng.annotations.Test;
import pages.SearchPage;
import pages.SearchResultPage;


public class SearchTest extends BaseTest {

    @Test(dataProvider = "dataProvider")
    public void searchInGoogle(String text) throws InterruptedException {
        SearchPage searchPage = new SearchPage();
        searchPage.pasteToSearchField(text);
        searchPage.clickSearchButtonOrPressEnter();
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.assertThatFirstResultRawIsDisplayed();
        searchResultPage.assertThatTopResultContainsCorrectText("Selenium");

    }

    @Test
    public void verifySearchByVoiceTooltipOnGoogle() {
        SearchPage searchPage = new SearchPage();
        searchPage.moveToVoiceSearchButton();
        searchPage.assertThatVoiceSearchTooltipContainsText("Search by voice");
    }

}
