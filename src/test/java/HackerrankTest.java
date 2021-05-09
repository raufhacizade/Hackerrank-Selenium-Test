import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;
import sites.Hackerrank;
import utilities.AutomationTool;

import java.io.File;

import static org.junit.Assert.assertNotNull;

public class HackerrankTest {
    public AutomationTool webTool;

    @Before
    public void setup(){
        webTool = new AutomationTool();
        webTool.openBrowser();
    }

    @Test
    public void testLoginandLogout(){
        Hackerrank hackerrank = new Hackerrank(webTool);
        hackerrank.login();

        DashboardPage dashboardPage = hackerrank.getDashboardPage();
        assertNotNull(hackerrank.getHomePage());
        assertNotNull(hackerrank.getAccessAccountPage());
        assertNotNull(dashboardPage);

        String expectedUrl = dashboardPage.getPageUrl();
        String currentUrl = webTool.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl);

        String expectedUserName = Hackerrank.userName;
        String currentUserName = dashboardPage.getNavbar().getUserNameSpanText();
        Assert.assertEquals(expectedUserName, currentUserName);

        System.out.println("Login was succesfull");

        dashboardPage.getNavbar().logout();
        Assert.assertEquals(dashboardPage.getPageUrl(), webTool.getCurrentUrl());

        System.out.println("Logout was succesfull");
    }

    @Test
    public void testProfilePage() {
        Hackerrank hackerrank = new Hackerrank(webTool);
        hackerrank.login();

        DashboardPage dashboardPage = hackerrank.getDashboardPage();
        ProfilePage profilePage = dashboardPage.getNavbar().goToProfilePage();

        String randomFirstName = RandomStringUtils.random(10, true, false);
        String randomLastName = RandomStringUtils.random(10, true, false);
        String randomHeadline = RandomStringUtils.random(15, true, false);
        String randomWebsite = "https://" + RandomStringUtils.random(20, true, false);
        String randomLinkedinUrl = "https://" + RandomStringUtils.random(20, true, false);

        profilePage.editIntro(randomFirstName, randomLastName, randomHeadline, randomWebsite, randomLinkedinUrl);

        String randomAboutMe = RandomStringUtils.random(100, true, true);
        profilePage.editAbout(randomAboutMe);

        randomFirstName = randomFirstName.substring(0, 1).toUpperCase() + randomFirstName.substring(1);
        randomLastName = randomLastName.substring(0, 1).toUpperCase() + randomLastName.substring(1);

        String expectedProfileHeading = randomFirstName + " " + randomLastName;
        String actualProfileHeading = profilePage.getProfileHeading();
        Assert.assertEquals(expectedProfileHeading, actualProfileHeading);
        Assert.assertEquals(randomHeadline, profilePage.getProfileSubheading());

        String currentUrl = webTool.navigateBack();
        String expectedUrl = dashboardPage.getPageUrl();
        Assert.assertTrue(currentUrl.contains(expectedUrl));
    }

    @Test
    public void testMultiplePages(){
        Navbar navbar = new Navbar(webTool);
        webTool.goToPage(Hackerrank.siteUrl+"dashboard");

        String[]  navbarPageArr = { "Certification", "Compete", "Jobs", "Leaderboard","Practice" };

        for (String pageName : navbarPageArr) {
            PageBase page = navbar.goToPageByName(pageName);
            Assert.assertTrue(webTool.getCurrentUrl().contains(page.getPageUrl()));
            Assert.assertTrue(webTool.getPageTitle().contains(page.getPageTitle()));
        }
    }

    @Test
    public void testDownloadMultipleFiles(){
        Hackerrank hackerrank = new Hackerrank(webTool);
        hackerrank.login();

        ChallengePage[] challengePages = {
                new ChallengePage(webTool, "Java If-Else | HackerRank", "java-if-else"),
                new ChallengePage(webTool, "Java Stdin and Stdout II | HackerRank", "java-stdin-stdout"),
                new ChallengePage(webTool, "Java Datatypes | HackerRank", "java-datatypes"),
                new ChallengePage(webTool, "Java End-of-file | HackerRank", "java-end-of-file"),
                new ChallengePage(webTool, "Java Static Initializer Block | HackerRank", "java-static-initializer-block"),
                new ChallengePage(webTool, "Java Int to String | HackerRank", "java-int-to-string")
        };

        for (ChallengePage challengePage: challengePages) {
            webTool.goToPage(challengePage.getPageUrl());

            Assert.assertTrue(webTool.getCurrentUrl().contains(challengePage.getPageUrl()));
            challengePage.downloadSampleTestCasesZip();
            String downloadedFilePath = Hackerrank.downloadDirectory + "\\" + challengePage.getChallengeName() + "-testcases.zip";
            Assert.assertTrue(new File(downloadedFilePath).exists());
        }
    }
    @After
    public void close() {
        webTool.closeBrowser();
    }
}
