import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.pages.DynamicControlsPage;

public class DynamicControlsTest extends BaseTest {
    public void openDCPage() {
        dynamicControlsPage.open();
        Assert.assertTrue(dynamicControlsPage.isPageLoaded(), "Page is not loaded");
    }

    @Test
    public void dynamicControlTest() {
        openDCPage();
        Assert.assertTrue(driver.findElement(DynamicControlsPage.CHECKBOX_BUTTON).isDisplayed());
        dynamicControlsPage.pushButton(DynamicControlsPage.REMOVE_BUTTON);
        dynamicControlsPage.wait.until(ExpectedConditions.textToBe(DynamicControlsPage.MESSAGE, "It's gone!"));
        Assert.assertTrue(driver.findElements(DynamicControlsPage.CHECKBOX_LOCATOR).isEmpty(),
                "Checkbox is not on the page");
        Assert.assertFalse(driver.findElement(DynamicControlsPage.INPUT_TEXT).isEnabled(), "input is disabled");
        dynamicControlsPage.pushButton(DynamicControlsPage.ENABLE_BUTTON);
        dynamicControlsPage.wait.until(ExpectedConditions.textToBe(DynamicControlsPage.MESSAGE,
                "It's enabled!"));
        Assert.assertTrue(driver.findElement(DynamicControlsPage.INPUT_TEXT).isDisplayed(), "Input is enabled");

    }

}
