package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchPage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(name = "btnk")
    private WebElement searchButton;

    @FindBy(xpath = "//body")
    private WebElement pageBody;

    @FindBy(css = "div.XDyW0e")
    private WebElement searchByVoiceButton;

    public SearchPage() {
        super();
    }

    public void fillSearchField(String text) {
        searchField.click();
        searchField.sendKeys(text);
    }

    public void pasteToSearchField(String text) {
        searchField.click();
        pasteTextToElementFromClipboard(searchField, text);

    }

    public void pressEnter() {
        searchField.sendKeys(Keys.RETURN);
    }

    public void clickSearchButtonOrPressEnter() throws InterruptedException {
        if (isElementFound(By.name("btnk"), 3)) {
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            clickWithJavascript(searchButton);
        } else {
            pressEnter();
        }
    }

    public void moveToVoiceSearchButton() {
        builder.moveToElement(searchByVoiceButton).build().perform();
    }

    public void assertThatVoiceSearchTooltipContainsText(String text) {
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + text + "']")));
        assertThat(pageBody.findElements(By.xpath("//div[text()='" + text + "']")).size()).
                as("Expected tooltip " + text + " was not found").isNotZero();
    }

}

