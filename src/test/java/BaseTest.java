import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import web.pages.ContextMenuPage;
import web.pages.DynamicControlsPage;
import web.pages.FileUploadPage;
import web.pages.IframesPage;

import java.io.File;
import java.util.HashMap;

public class BaseTest {
    protected WebDriver driver;
    protected ContextMenuPage contextMenuPage;
    protected DynamicControlsPage dynamicControlsPage;
    protected FileUploadPage fileUploadPage;
    protected IframesPage iframesPage;

    public static final String PICTURE_PATH = "src/test/resources";
    public static final File FILEPATH = new File(PICTURE_PATH);
    public static final String ABSOLUT_PATH = FILEPATH.getAbsolutePath();
    File FILE = new File(ABSOLUT_PATH);


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-popup-blocking");
        chromeOptions.addArguments("--ignore-certificate-errors");

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", ABSOLUT_PATH);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);

        driver = new ChromeDriver(chromeOptions);
        contextMenuPage = new ContextMenuPage(driver);
        dynamicControlsPage = new DynamicControlsPage(driver);
        fileUploadPage = new FileUploadPage(driver);
        iframesPage = new IframesPage(driver);

    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.close();
        driver.quit();
    }
}

