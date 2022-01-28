package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicControlsPage extends BasePage {
    private static final String BASE_URL = "http://the-internet.herokuapp.com/dynamic_controls";
    private static final By DYNAMIC_CONTROLS_TITLE = By.xpath("//div/h4");
    public static final By CHECKBOX_LOCATOR = By.id("checkbox");
    public static final By CHECKBOX_BUTTON = By.cssSelector("input[type='checkbox']");
    public static final By REMOVE_BUTTON = By.cssSelector("[onclick='swapCheckbox()']");
    public static final By MESSAGE = By.cssSelector("#message");
    public static final By INPUT_TEXT = By.cssSelector("input[type='text']");
    public static final By ENABLE_BUTTON = By.cssSelector("[onclick='swapInput()']");


    public DynamicControlsPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElement = DYNAMIC_CONTROLS_TITLE;
    }

    public void pushButton(By locator) {
        driver.findElement(locator).click();
    }
}
