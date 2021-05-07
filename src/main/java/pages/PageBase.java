package pages;

import org.openqa.selenium.By;
import utilities.AutomationTool;

public abstract class PageBase {
    protected AutomationTool webTool;
    protected static String siteUrl = AutomationTool.properties.getProperty("siteUrl");

    public PageBase(AutomationTool webTool){
        this.webTool = webTool;
    }

    public void openPage(String newPageUrl){
        webTool.goToPage(newPageUrl);
    }

    public boolean closeAll(){
        webTool.closeBrowser();
        return true;
    }

//    public abstract String getPageTitle();

}
