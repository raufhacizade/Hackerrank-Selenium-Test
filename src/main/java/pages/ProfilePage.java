package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.AutomationTool;

public class ProfilePage extends PageBase{
    private Navbar navbarDiv;

    private By editIntroBtnBy = By.xpath("//div[@class='summary-edit-button']");
    private By firstNameInputBy = By.xpath("//input[@name='personal_first_name']");
    private By lastNameInputBy = By.xpath("//input[@name='personal_last_name']");
    private By headlineInputBy = By.xpath("//input[@name='jobs_headline']");
    private By websiteInputBy = By.xpath("//input[@name='website']");
    private By linkedinBy = By.xpath("//input[@name='linkedin_url']");
    private By saveIntroBtnBy = By.xpath("//button[@type='submit']");

    private By aboutMeBtnBy = By.xpath("//div[@class='profile-details-edit']");
    private By aboutMeTextareBy = By.xpath("//textarea[@name='shortBio']");
    private By saveAboutMeBy = By.xpath("//span[normalize-space()='Save']");

    private By profileHeadingBy = By.xpath("//h1[@class='profile-heading']");
    private By profileSubheadingBy = By.xpath("//p[@class='profile-subheading']");
    private By profileAboutMeBy = By.xpath("//p[@class='profile-details-value']");


    public ProfilePage(AutomationTool webTool, Navbar navbarDiv) {
        super(webTool);
        this.navbarDiv = navbarDiv;
    }

    public Navbar getNavbar() {
        return navbarDiv;
    }

    public String getProfileHeading(){
        return webTool.waitAndReturnElement(profileHeadingBy, false, null).getText();
    }

    public String getProfileSubheading(){
        return webTool.waitAndReturnElement(profileSubheadingBy, false, null).getText();
    }

    public void editIntro(String firstName, String lastName, String headline, String website, String linkedinUrl){
        webTool.waitAndReturnElement(editIntroBtnBy, true, null).click();

        if(firstName != null)
            webTool.waitAndReturnElement(firstNameInputBy, true, null)
                    .sendKeys(Keys.chord(Keys.CONTROL, "a"),firstName);

        if(lastName != null)
            webTool.waitAndReturnElement(lastNameInputBy, true, null)
                    .sendKeys(Keys.chord(Keys.CONTROL, "a"),lastName);

        if(headline != null)
            webTool.waitAndReturnElement(headlineInputBy, true, null)
                    .sendKeys(Keys.chord(Keys.CONTROL, "a"),headline);

        if(website != null)
            webTool.waitAndReturnElement(websiteInputBy, true, null)
                    .sendKeys(Keys.chord(Keys.CONTROL, "a"),website);
        if(linkedinUrl != null)
            webTool.waitAndReturnElement(linkedinBy, true, null)
                    .sendKeys(Keys.chord(Keys.CONTROL, "a"),linkedinUrl);

        webTool.waitAndReturnElement(saveIntroBtnBy, true, null).click();
        webTool.waitAndReturnElement(profileSubheadingBy, false, null);
    }

    public void editAbout(String aboutMe){
        System.out.println("Insode of editAbout1");
        webTool.waitAndReturnElement(aboutMeBtnBy, true, null).click();

        System.out.println("Insode of editAbout2");
        if(aboutMe != null)
            webTool.waitAndReturnElement(aboutMeTextareBy, true, null)
                    .sendKeys(Keys.chord(Keys.CONTROL, "a"),aboutMe);

        webTool.waitAndReturnElement(saveAboutMeBy, true, null).click();
        webTool.waitAndReturnElement(profileAboutMeBy, false, null);
        webTool.getWait().until(ExpectedConditions.invisibilityOfElementWithText(profileAboutMeBy, aboutMe));
    }

//    @Override
//    public String getPageTitle() {
//        return null;
//    }
}
