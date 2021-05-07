package pages;

import org.openqa.selenium.By;
import utilities.AutomationTool;

public class PageBase {
    protected static String siteUrl = System.getProperty("SiteUrl");
    protected AutomationTool webTool;

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

}
