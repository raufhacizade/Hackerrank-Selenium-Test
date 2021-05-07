package pages;

import org.openqa.selenium.By;
import utilities.AutomationTool;

public class HomePage extends PageBase {
    private By accessAccountPageBtnBy = By.xpath("//*[@id=\"menu-item-2887\"]/a");

    public HomePage(AutomationTool webTool){
        super(webTool);
    }

    public AccessAccountPage login() {
        webTool.waitAndReturnElement(accessAccountPageBtnBy, true, null).click();
        return new AccessAccountPage(webTool);
    }

    public static String getUrl(){
        return siteUrl;
    }
}
