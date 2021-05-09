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

    @Override
    public String getPageTitle() {
        return "Dashboard | HackerRank";
    }

    @Override
    public String getPageUrl() {
        return super.getPageUrl() + "dashboard";
    }
}
