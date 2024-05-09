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

        performOnboardingFlow(getStartedPage, favoriteLeaguePage, basePage, favoriteTeamPage)
        navigateToTeamPage(mainPage, basePage)
        verifyTeamPage(teamPage)
        navigateToSubTabPage(teamPage)
        verifyToSubTabPage(teamPage)
        navigateBackToMainPage(basePage, mainPage)
    }
    private fun performOnboardingFlow(getStartedPage: GetStartedPage, favoriteLeaguePage: FavoriteLeaguePage, basePage: BasePage, favoriteTeamPage: FavoriteTeamPage,
    ) {
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
    }
    private fun navigateToTeamPage(mainPage: MainPage,basePage: BasePage) {
        mainPage.clickTeamIcon("TOR")
        basePage.clickCloseModalButton()
    }
    private fun verifyTeamPage(teamPage: TeamPage) {
        teamPage.verifyPageTitle("Toronto Blue Jays")
    }
    private fun navigateToSubTabPage(teamPage: TeamPage) {
        teamPage.clickTab("TEAM STATS")
    }
    private fun verifyToSubTabPage(teamPage: TeamPage) {
        teamPage.verifyTabIsSelected("TEAM STATS")
        teamPage.verifyHeaderIsPresented("STATS")
        teamPage.verifyHeaderIsPresented("(RANK)")
    }
    private fun navigateBackToMainPage(basePage: BasePage, mainPage: MainPage) {
        basePage.clickReturnButton()
        mainPage.verifyTeamIcon("TOR")
    }
}