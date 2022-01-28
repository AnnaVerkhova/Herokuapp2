package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IframesPage extends BasePage {

    private static final String BASE_URL = "http://the-internet.herokuapp.com/iframe";
    public static final By IFRAMES_TITLE = By.cssSelector("div [class='example']");
    public static final By IFRAME_TEXT = By.tagName("p");
    public static final By IFRAME_MESSAGE = By.id("mce_0_ifr");

    public IframesPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElement = IFRAMES_TITLE;
    }

}
