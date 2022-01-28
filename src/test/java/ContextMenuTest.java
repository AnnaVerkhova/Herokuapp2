import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.pages.ContextMenuPage;

public class ContextMenuTest extends BaseTest {


    public void openContextMenuPage() {
        contextMenuPage.open();
        Assert.assertTrue(contextMenuPage.isPageLoaded(), "Page is not loaded");

    }

    @Test
    public void contextMenuTest() {
        openContextMenuPage();
        contextMenuPage.clickElement();
        contextMenuPage.wait.until(ExpectedConditions.alertIsPresent());
        String alert = driver.switchTo().alert().getText();
        Assert.assertEquals(alert, ContextMenuPage.ALERT, "Text is not correct");
        driver.switchTo().alert().accept();
        openContextMenuPage();

    }

}
