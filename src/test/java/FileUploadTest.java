import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static web.pages.FileUploadPage.FILEUPLOADED;

public class FileUploadTest extends BaseTest {

    private final String PICTURE_PATH = "src/test/resources/zima-les.jpg";


    public void openFileUploaded() {
        fileUploadPage.open();
        Assert.assertTrue(fileUploadPage.isPageLoaded(), "File is not loaded");
    }

    @Test
    public void fileUploadedTest() {
        openFileUploaded();
        File filePath = new File(PICTURE_PATH);
        String absolutePath = filePath.getAbsolutePath();
        String fileName = filePath.getName();
        fileUploadPage.selectionFile(absolutePath);
        fileUploadPage.pushUploadedFile();
        Assert.assertEquals(driver.findElement(FILEUPLOADED).getText(), fileName, "File names is not correct");
    }


}
