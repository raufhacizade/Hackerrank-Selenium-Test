package pages;

import utilities.AutomationTool;

public class JobsPage extends PageBase {

    public JobsPage(AutomationTool webTool) {
        super(webTool);
    }

    @Override
    public String getPageTitle() {
        return "Browse Jobs | HackerRank";
    }

    @Override
    public String getPageUrl() {
        return super.getPageUrl() + "jobs";
    }
}
