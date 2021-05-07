package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class AutomationTool {
    private String browserName;
    private WebDriver driver;
    private WebDriverWait wait;

    public AutomationTool(){
        this.browserName = System.getProperty("BrowserName");
        this.driver = null;
        this.wait = null;
    }

    public void openBrowser(){
        if(browserName == "firefox"){
            WebDriverManager.firefoxdriver().setup();
            this.driver = new FirefoxDriver();
        }else if (browserName == "firefox"){
            WebDriverManager.edgedriver().setup();
            this.driver = new EdgeDriver();
        }else {
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
        }
        this.wait = new WebDriverWait(driver, 10);
        this.driver.manage().window().maximize();
    }

    public void goToPage(String url){
        this.driver.get(url);
    }

    public void closeBrowser (){
        this.driver.quit();
    }

    public WebElement waitAndReturnElement(By locator, boolean isClickable, String newUrl ) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if(isClickable)
            this.wait.until(ExpectedConditions.elementToBeClickable(locator));
        if(newUrl != null && !newUrl.isEmpty() && !newUrl.isBlank())
            waitUrlLoad(newUrl);

        return this.driver.findElement(locator);
    }
    
    public void waitUrlLoad(String url){
        this.wait.until(ExpectedConditions.urlContains(url));
    }

    public String getBrowserName() {
        return browserName;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
