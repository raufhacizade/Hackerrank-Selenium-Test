package sites;

import pages.*;
import utilities.AutomationTool;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Hackerrank {
    private static final Properties properties = getProperties();

    public static final String siteUrl = properties.getProperty("siteUrl");
    public static final String userName = properties.getProperty("userName");
    public static final String userEmail = properties.getProperty("userEmail");
    public static final String userPassword = properties.getProperty("userPassword");

    private AutomationTool webTool;

    private HomePage homePage;
    private AccessAccountPage accessAccountPage;
    private DashboardPage dashboardPage;
    private LoginPage loginPage;

    public Hackerrank(AutomationTool webTool) {
        this.webTool = webTool;
        webTool.goToPage(siteUrl);
    }

    public boolean login() {
        homePage = new HomePage(webTool);
        accessAccountPage = homePage.login();
        loginPage = accessAccountPage.loginForDevelopers();
        dashboardPage = loginPage.login(userEmail, userPassword);
        return true;
    }

    public HomePage getHomePage() {
        return (homePage != null) ? homePage : new HomePage(webTool);
    }

    public AccessAccountPage getAccessAccountPage() {
        return (accessAccountPage != null) ? accessAccountPage : new AccessAccountPage(webTool);
    }

    public DashboardPage getDashboardPage() {
        return (dashboardPage != null) ? dashboardPage : new DashboardPage(webTool, new Navbar(webTool));
    }

    private static Properties getProperties() {
        String propFileName = "config.properties";
        InputStream inputStream = null;
        Properties prop = new Properties();
        try {
            inputStream = AutomationTool.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null)
                prop.load(inputStream);
            else
                throw new FileNotFoundException("Property file '" + propFileName + "' not found in the classpath");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                System.out.println("Exception: " + e);
                e.printStackTrace();
            }
        }

        return prop;
    }
}
