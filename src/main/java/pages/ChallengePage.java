package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.AutomationTool;

import java.util.HashMap;
import java.util.Map;

public class ChallengePage extends PageBase{
    private String challengePageTitle;
    private String challengeName;
    private By downloadSampleTestCasesBtnBy = By.xpath("//span[normalize-space()='Download sample test cases']");

    public ChallengePage(AutomationTool webTool, String challengePageTitle, String challengeName) {
        super(webTool);
        this.challengePageTitle = challengePageTitle;
        this.challengeName = challengeName;
    }

    @Override
    public String getPageTitle() {
        return challengePageTitle;
    }

    public String getChallengeName() {
        return challengeName;
    }

    @Override
    public String getPageUrl() {
        return super.getPageUrl() + "challenges/" + challengeName + "/problem";
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
