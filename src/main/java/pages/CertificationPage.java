package pages;

import utilities.AutomationTool;

public class CertificationPage extends PageBase {

    public CertificationPage(AutomationTool webTool) {
        super(webTool);
    }

    @Override
    public String getPageTitle() {
        return "HackerRank";
    }

    @Override
    public String getPageUrl() {
        return super.getPageUrl() + "skills-verification";
    }
}
