package pages;

import utilities.AutomationTool;

public class LoginPage extends PageBase {
    public LoginPage(AutomationTool webTool) {
        super(webTool);
    }

    public DashboardPage login(String userName, String password){
        Navbar navbarDiv = new Navbar(webTool);
        navbarDiv.login(userName, password, null);
        webTool.waitUrlLoad(DashboardPage.getUrl());
        return new DashboardPage(webTool, navbarDiv);
    }
}
