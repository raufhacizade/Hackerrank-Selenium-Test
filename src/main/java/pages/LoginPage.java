package pages;

import utilities.AutomationTool;

public class LoginPage extends PageBase {
    public LoginPage(AutomationTool webTool) {
        super(webTool);
    }

    public DashboardPage login(String userEmail, String password) {
        Navbar navbarDiv = new Navbar(webTool);
        navbarDiv.login(userEmail, password, null);
        DashboardPage dashboardPage = new DashboardPage(webTool, navbarDiv);
        webTool.waitUrlLoad(dashboardPage.getPageUrl());
        return new DashboardPage(webTool, navbarDiv);
    }

    @Override
    public String getPageTitle() {
        return "Login - HackerRank";
    }

    @Override
    public String getPageUrl() {
        return super.getPageUrl() + "login";
    }
}
