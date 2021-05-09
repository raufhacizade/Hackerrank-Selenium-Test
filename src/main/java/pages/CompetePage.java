package pages;

import utilities.AutomationTool;

public class CompetePage extends PageBase {

    public CompetePage(AutomationTool webTool) {
        super(webTool);
    }

    @Override
    public String getPageTitle() {
        return "Contests | HackerRank";
    }

    @Override
    public String getPageUrl() {
        return super.getPageUrl() + "contests";
    }
}
