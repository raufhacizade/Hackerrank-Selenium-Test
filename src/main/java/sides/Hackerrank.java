package sides;

import pages.AccessAccountPage;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.AutomationTool;

public class Hackerrank {
    private AutomationTool webTool;
    private String usernName;
    private String userPswd;

    private HomePage homePage;
    private AccessAccountPage accessAccountPage;
    private DashboardPage dashboardPage;
    private LoginPage loginPage;

    public Hackerrank(AutomationTool webTool){
        this.usernName = System.getProperty("MockUserEmail");
        this.userPswd = System.getProperty("MockUserPswd");
        this.webTool = webTool;
        webTool.goToPage(System.getProperty("SiteUrl"));
    }

    public boolean login(){
        homePage = new HomePage(webTool);
        accessAccountPage = homePage.login();
        loginPage = accessAccountPage.loginForDevelopers();
        dashboardPage = loginPage.login(usernName, userPswd);
        return true;
    }

    public boolean startAsGuestUser(){

        return true;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public AccessAccountPage getAccessAccountPage() {
        return accessAccountPage;
    }

    public DashboardPage getDashboardPage() {
        return dashboardPage;
    }

    public void close(){
        webTool.closeBrowser();
    }
}
