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
    private By profileBtnBy = By.xpath("//a[@class='profile-nav-item-link profile-progress']");


    private By practicePageBtnBy = By.xpath("//a[@href='/dashboard']");
    private By cartificationPageBtnBy = By.xpath("//a[@href='/skills-verification']");
    private By competePageBtnBy = By.xpath("//a[@href='/contests']");
    private By jobsPageBtnBy = By.xpath("//a[@href='/jobs']");
    private By leaderboardPageBtnBy = By.xpath("//a[@href='/leaderboard']");

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

    public ProfilePage goToProfilePage(){
        webTool.waitAndReturnElement(navbarDropdownBtnBy, true, null).click();
        webTool.waitAndReturnElement(profileBtnBy, true, null).click();
        return new ProfilePage(webTool, this);
    }

    public String getUserNameSpanText(){
        return  webTool.waitAndReturnElement(navbarDropdownBtnBy, false, null).getText();
    }



}
