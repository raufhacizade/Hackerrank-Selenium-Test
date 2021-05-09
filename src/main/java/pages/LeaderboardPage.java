package pages;

import utilities.AutomationTool;

public class LeaderboardPage extends PageBase {

    public LeaderboardPage(AutomationTool webTool) {
        super(webTool);
    }

    @Override
    public String getPageTitle() {
        return "Leaderboard | HackerRank";
    }

    @Override
    public String getPageUrl() {
        return super.getPageUrl() + "leaderboard";
    }
}
