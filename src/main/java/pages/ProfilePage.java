package pages;

import org.openqa.selenium.By;
import utilities.AutomationTool;

public class ProfilePage extends PageBase{
    private Navbar navbarDiv;

    private By editInfoBtnBy = By.xpath("//div[@class='summary-edit-button']");

    public ProfilePage(AutomationTool webTool, Navbar navbarDiv) {
        super(webTool);
        this.navbarDiv = navbarDiv;
    }

    public Navbar getNavbarDiv() {
        return navbarDiv;
    }

    public void editInfo(){}
}
