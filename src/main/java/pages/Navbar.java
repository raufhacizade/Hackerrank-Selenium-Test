package pages;

import org.openqa.selenium.By;
import pages.PageBase;
import utilities.AutomationTool;

public class Navbar extends PageBase {

    private By nameInputBoxBy = By.name("username");
    private By passwordInputBoxBy = By.name("password");
    private By navbarDropdownBtnBy = By.xpath("//div[@class='dropdown-handle nav_link toggle-wrap']");
    private By navbarDropdownLogoutBtnBy = By.xpath("//button[normalize-space()='Logout']");
    private By navbarLoginBtnBy = By.xpath("//button[normalize-space()='Log In']");
    private By profileBtnBy = By.xpath("//a[normalize-space()='Profile']");

    public Navbar(AutomationTool webTool) {
        super(webTool);
    }

    public void login(String username, String password, String redirectedUrl){
        webTool.waitAndReturnElement(nameInputBoxBy, true, null).sendKeys(username);
        webTool.waitAndReturnElement(passwordInputBoxBy, true, null).sendKeys(password+"\n");
    }

    public void logout(){
        webTool.waitAndReturnElement(navbarDropdownBtnBy, true, null).click();
        webTool.waitAndReturnElement(navbarDropdownLogoutBtnBy, true, null).click();
        webTool.waitAndReturnElement(navbarLoginBtnBy, true, null);
    }

    public PageBase goToProfilePage(){
        webTool.waitAndReturnElement(navbarDropdownBtnBy, true, null).click();
        webTool.waitAndReturnElement(profileBtnBy, true, null).click();
        return null;
    }

    public String getUserNameSapanText(){
        return  webTool.waitAndReturnElement(navbarDropdownBtnBy, false, null).getText();
    }
}
