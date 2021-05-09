package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.AutomationTool;

import java.util.HashMap;

public class Navbar extends PageBase {

    private By nameInputBoxBy = By.xpath("//input[@name='username']");
    private By passwordInputBoxBy = By.xpath("//input[@name='password']");
    private By navbarDropdownBtnBy = By.xpath("//div[@class='dropdown profile-menu theme-m-content']");
    private By navbarDropdownLogoutBtnBy = By.xpath("//button[normalize-space()='Logout']");
    private By profileMenuDivBy = By.xpath("//div[@role='menu']");
    private By navbarLoginBtnBy = By.xpath("//button[normalize-space()='Log In']");
    private By profileBtnBy = By.xpath("//a[@class='profile-nav-item-link profile-progress']");


    private By practicePageBtnBy = By.xpath("//a[@href='/dashboard']");
    private By cartificationPageBtnBy = By.xpath("//span[normalize-space()='Certification']");
    private By competePageBtnBy = By.xpath("//a[@href='/contests']");
    private By jobsPageBtnBy = By.xpath("//a[@href='/jobs']");
    private By leaderboardPageBtnBy = By.xpath("//a[@href='/leaderboard']");

    public Navbar(AutomationTool webTool) {
        super(webTool);
    }

    public void login(String userEmail, String userPassword, String redirectedUrl){
        webTool.waitAndReturnElement(nameInputBoxBy, true).sendKeys(userEmail);
        webTool.waitAndReturnElement(passwordInputBoxBy, true).sendKeys(userPassword+"\n");
        if(redirectedUrl != null)
            webTool.waitUrlLoad(redirectedUrl);
    }

    public void logout(){
        webTool.waitAndReturnElement(navbarDropdownBtnBy, true).click();
//        webTool.waitAndReturnElement(profileMenuDivBy, false);
        webTool.waitAndReturnElement(navbarDropdownLogoutBtnBy, true).click();
        webTool.waitAndReturnElement(navbarLoginBtnBy, true);
    }

    public String getUserNameSpanText(){
        return  webTool.waitAndReturnElement(navbarDropdownBtnBy, false).getText();
    }

    public ProfilePage goToProfilePage(){
        webTool.waitAndReturnElement(navbarDropdownBtnBy, true).click();
        webTool.waitAndReturnElement(profileMenuDivBy, false);
        webTool.waitAndReturnElement(profileBtnBy, true).click();
        return new ProfilePage(webTool, this);
    }

    public DashboardPage goToPracticePage(){
        webTool.waitAndReturnElement(practicePageBtnBy, true).click();
        DashboardPage page = new DashboardPage(webTool, this);
        webTool.getWait().until(ExpectedConditions.titleContains(page.getPageTitle()));
        return page;
    }

    public CertificationPage goToCertificationPage(){
        webTool.waitAndReturnElement(cartificationPageBtnBy, true).click();
        CertificationPage page = new CertificationPage(webTool);
        webTool.getWait().until(ExpectedConditions.titleContains(page.getPageTitle()));
        return page;
    }

    public CompetePage goToCompetePage(){
        webTool.waitAndReturnElement(competePageBtnBy, true).click();
        CompetePage page = new CompetePage(webTool);
        webTool.getWait().until(ExpectedConditions.titleContains(page.getPageTitle()));
        return page;
    }

    public JobsPage goToJobsPage(){
        webTool.waitAndReturnElement(jobsPageBtnBy, true).click();
        JobsPage page = new JobsPage(webTool);
        webTool.getWait().until(ExpectedConditions.titleContains(page.getPageTitle()));
        return page;
    }

    public LeaderboardPage goToLeaderboardPagePage(){
        webTool.waitAndReturnElement(leaderboardPageBtnBy, true).click();
        LeaderboardPage page = new LeaderboardPage(webTool);
        webTool.getWait().until(ExpectedConditions.titleContains(page.getPageTitle()));
        return page;
    }

    public PageBase goToPageByName(String pageName){
        if(pageName == "Certification")
            return goToCertificationPage();
        if(pageName == "Compete")
            return goToCompetePage();
        if(pageName == "Jobs")
            return goToJobsPage();
        if(pageName == "Leaderboard")
            return goToLeaderboardPagePage();
        else
            return goToPracticePage();
    }
}
