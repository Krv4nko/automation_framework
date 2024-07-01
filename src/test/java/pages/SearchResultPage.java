package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@class='hlcw0c']//h3[@class='LC20lb MBeuO DKV0Md']")
    private WebElement resultRow;

    @FindBy(xpath = "//div[@class='hlcw0c']//h3[@class='LC20lb MBeuO DKV0Md']")
    private List<WebElement> resultRows;

    public SearchResultPage() {
        super();
    }


    public void assertThatFirstResultRawIsDisplayed() {
        assertThat(resultRow.isDisplayed()).as("First result raw is not displayed")
                .isTrue();
    }

    public void assertThatTopResultContainsCorrectText(String expected) {
        wait.until(ExpectedConditions.visibilityOfAllElements(resultRows));
        assertThat(resultRows.stream().map(e -> e.getText()).collect(Collectors.toList()).toString()).as("First result raw text is differ from expected")
                .contains(expected);
    }


}
