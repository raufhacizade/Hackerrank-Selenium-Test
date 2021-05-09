package pages;

import org.openqa.selenium.By;
import utilities.AutomationTool;

public class AccessAccountPage extends PageBase {
    private By loginMenuBtnBy = By.xpath("//a[@href='https://www.hackerrank.com/login?h_r=login&h_l=body_middle_left_button']");

    public AccessAccountPage(AutomationTool webTool) {
        super(webTool);
    }

    public LoginPage loginForDevelopers(){
        webTool.waitAndReturnElement(loginMenuBtnBy, true).click();
        return new LoginPage(webTool);
    }

    @Override
    public String getPageTitle() {
        return "Login - HackerRank";
    }

    @Override
    public String getPageUrl() {
        return super.getPageUrl() + "access-account";
    }
}
