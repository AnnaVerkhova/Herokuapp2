package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePage {

    private static final String BASE_URL = "http://the-internet.herokuapp.com/upload";
    public static final By FILE_UPLOAD_TITLE = By.cssSelector("div>h3");
    private static final By SELECTION_BUTTON = By.id("file-upload");
    private static final By UPLOADED_BUTTON = By.cssSelector("input[type='submit']");
    public static final By FILEUPLOADED = By.id("uploaded-files");


    public FileUploadPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElement = FILE_UPLOAD_TITLE;
    }

    public void selectionFile(String filePath) {
        driver.findElement(SELECTION_BUTTON).sendKeys(filePath);
    }

    public void pushUploadedFile() {
        driver.findElement(UPLOADED_BUTTON).click();
    }
}
