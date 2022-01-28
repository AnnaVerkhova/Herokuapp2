import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.pages.IframesPage;

public class IframesTest extends BaseTest {

    @Test
    public void iframesTest() {
        iframesPage.open();
        iframesPage.isPageLoaded();
        iframesPage.wait.until(ExpectedConditions.visibilityOf(driver.findElement(IframesPage.IFRAME_MESSAGE)));
        driver.switchTo().frame(driver.findElement(IframesPage.IFRAME_MESSAGE));
        iframesPage.wait.until(ExpectedConditions.visibilityOf(driver.findElement(IframesPage.IFRAME_TEXT)));
        Assert.assertEquals(driver.findElement(IframesPage.IFRAME_TEXT).getText(),
                "Your content goes here.",
                "Text is not correct");
        driver.switchTo().defaultContent();
    }
}
