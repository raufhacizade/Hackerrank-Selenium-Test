package pages;

import org.openqa.selenium.By;
import utilities.AutomationTool;

public class HomePage extends PageBase {
    private By accessAccountPageBtnBy = By.xpath("//*[@id='menu-item-2887']/a");

    public HomePage(AutomationTool webTool){
        super(webTool);
    }

    public AccessAccountPage login() {
        webTool.waitAndReturnElement(accessAccountPageBtnBy, true).click();
        return new AccessAccountPage(webTool);
    }

    @Override
    public String getPageTitle() {
        return "HackerRank";
    }

    @Override
    public String getPageUrl() {
        return super.getPageUrl();
    }
}
