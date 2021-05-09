package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.AutomationTool;

import java.util.HashMap;
import java.util.Map;

public class ChallengePage extends PageBase{
    private String challengePageTitle;
    private String challengePageUrl;
    private By downloadSampleTestCasesBtnBy = By.xpath("//span[normalize-space()='Download sample test cases']");

    public ChallengePage(AutomationTool webTool, String challengePageTitle, String challengePageUrl) {
        super(webTool);
        this.challengePageTitle = challengePageTitle;
        this.challengePageUrl = challengePageUrl;
    }

    @Override
    public String getPageTitle() {
        return challengePageTitle;
    }

    @Override
    public String getPageUrl() {
        return super.getPageUrl() + challengePageUrl;
    }

    public void downloadSampleTestCasesZip(){
        webTool.waitAndReturnElement(downloadSampleTestCasesBtnBy, true).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("downloadSampleTestCases() failed");
            e.printStackTrace();
        }
    }
}
