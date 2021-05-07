import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.DashboardPage;
import sides.Hackerrank;
import utilities.AutomationTool;

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

        assertNotNull(hackerrank.getHomePage());
        assertNotNull(hackerrank.getAccessAccountPage());
        assertNotNull(hackerrank.getDashboardPage());

        String expectedUrl = DashboardPage.getUrl();
        String currentUrl = webTool.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl);

        String expectedUserName = System.getProperty("MockUserName");
        String currentUserName = hackerrank.getDashboardPage().getNavbarDiv().getUserNameSapanText();
        Assert.assertEquals(expectedUserName, currentUserName);

        System.out.println("Login was succesfull");

        hackerrank.getDashboardPage().getNavbarDiv().logout();
        Assert.assertEquals(DashboardPage.getUrl(), webTool.getCurrentUrl());

        System.out.println("Logout was succesfull");
    }

    @After
    public void close() {
        webTool.closeBrowser();
    }
}
