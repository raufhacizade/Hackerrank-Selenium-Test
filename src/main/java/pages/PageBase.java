package pages;

import sites.Hackerrank;
import utilities.AutomationTool;

public class PageBase {
    protected AutomationTool webTool;

    public PageBase(AutomationTool webTool) {
        this.webTool = webTool;
    }

    public String getPageTitle() {
        return "HackerRank";
    }

    public String getPageUrl() {
        return Hackerrank.siteUrl;
    }
}
