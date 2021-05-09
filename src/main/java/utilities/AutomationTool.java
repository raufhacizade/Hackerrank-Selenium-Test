package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sites.Hackerrank;

import java.util.HashMap;
import java.util.Map;

public class AutomationTool {
    private final String browserName;
    private WebDriver driver;
    private WebDriverWait wait;

    public AutomationTool() {
        this.browserName = System.getProperty("BrowserName");
        this.driver = null;
        this.wait = null;
    }

    public void openBrowser() {
        if (browserName == "firefox") {
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            firefoxProfile.setPreference("browser.download.dir", Hackerrank.downloadDirectory);

            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(new FirefoxProfile());

            this.driver = new FirefoxDriver(options);
            WebDriverManager.firefoxdriver().setup();
            System.out.println("Firefox driver is running");
        } else {
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.default_directory", Hackerrank.downloadDirectory);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("prefs", prefs);

            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver(chromeOptions);
            System.out.println("Chrome driver is running");
        }
        this.wait = new WebDriverWait(driver, 20);
        this.driver.manage().window().maximize();
    }

    public void goToPage(String url) {
        this.driver.get(url);
    }

    public void closeBrowser() {
        this.driver.quit();
    }

    public WebElement waitAndReturnElement(By locator, boolean isClickable) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if (isClickable)
            this.wait.until(ExpectedConditions.elementToBeClickable(locator));

        return this.driver.findElement(locator);
    }

    public void waitUrlLoad(String url) {
        this.wait.until(ExpectedConditions.urlContains(url));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String navigateBack() {
        driver.navigate().back();
        return getCurrentUrl();
    }
}
