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
        this.webTool = webTool;
        this.usernName = AutomationTool.properties.getProperty("userEmail");
        this.userPswd = AutomationTool.properties.getProperty("userPswd");
        webTool.goToPage(AutomationTool.properties.getProperty("siteUrl"));
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
