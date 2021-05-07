package pages;

import utilities.AutomationTool;

public class DashboardPage extends PageBase {
    private Navbar navbarDiv;

    public DashboardPage(AutomationTool webTool, Navbar navbarDiv) {
        super(webTool);
        this.navbarDiv = navbarDiv;
    }

    public Navbar getNavbar() {
        return navbarDiv;
    }

    public static String getUrl(){
        return siteUrl+"dashboard";
    }
}
