package pages;

import sites.Hackerrank;
import utilities.AutomationTool;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PageBase {
    protected AutomationTool webTool;

    public PageBase(AutomationTool webTool){
        this.webTool = webTool;
    }

    public String getPageTitle(){
        return "HackerRank";
    }

    public String getPageUrl(){
        return Hackerrank.siteUrl;
    }

    private static Properties getProperties(){
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
