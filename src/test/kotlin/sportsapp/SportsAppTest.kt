import org.junit.jupiter.api.Test
import sportsapp.pages.*

class SportsAppTest : BaseTest() {

    @Test
    fun testAutomationFlow() {
        val getStartedPage = GetStartedPage(driver)
        val favoriteLeaguePage = FavoriteLeaguePage(driver)
        val basePage = BasePage(driver)
        val favoriteTeamPage = FavoriteTeamPage(driver)
        val mainPage = MainPage(driver)
        val teamPage = TeamPage(driver)

        getStartedPage.clickGetStartedButton()
        favoriteLeaguePage.clickFavoriteLeagueButton("MLB Baseball")
        basePage.clickContinueButton()
        basePage.clickMaybeLaterButton()
        favoriteTeamPage.clickFavoriteTeamButton("Toronto Blue Jays")
        basePage.clickContinueButton()
        basePage.clickDoneButton()
        basePage.clickMaybeLaterButton()
        basePage.clickAllowNotificationButton()
        basePage.clickOkGotItButton()
        mainPage.clickTeamIcon("TOR")
        basePage.clickCloseModalButton()
        teamPage.verifyPageTitle("Toronto Blue Jays")
        teamPage.clickTab("TEAM STATS")
        teamPage.verifyTabIsSelected("TEAM STATS")
        teamPage.verifyHeaderIsPresented("STATS")
        teamPage.verifyHeaderIsPresented("(RANK)")
        basePage.clickReturnButton()
        mainPage.verifyTeamIcon("TOR")
    }
}