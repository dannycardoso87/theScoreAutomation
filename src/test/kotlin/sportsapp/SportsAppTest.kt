import base.BaseTest
import extensions.ScreenshotOnFailure
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pages.*

@ExtendWith(ScreenshotOnFailure::class)
class SportsAppTest : BaseTest() {
    @Test
    fun testAutomationFlow() {
        val getStartedPage = GetStartedPage(driver)
        val favoriteLeaguePage = FavoriteLeaguePage(driver)
        val basePage = BasePage(driver)
        val favoriteTeamPage = FavoriteTeamPage(driver)
        val mainPage = MainPage(driver)
        val teamPage = TeamPage(driver)

        navigateToGetStartedPage(getStartedPage)
        navigateToFavoriteLeaguePage(favoriteLeaguePage,basePage)
        declineLocationSharing(basePage)
        navigateToFavoriteTeamPage(favoriteTeamPage, basePage)
        verifyTeamAndLeagueNotification(basePage)
        declineNewsSharing(basePage)
        verifyAppNotification(basePage)
        verifyBettingPopup(basePage)
        navigateToTeamPage(mainPage)
        verifyTeamPage(teamPage)
        navigateToSubTabPage(teamPage)
        verifyToSubTabPage(teamPage)
        navigateBackToMainPage(basePage, mainPage)
    }
    private fun navigateToGetStartedPage(getStartedPage: GetStartedPage) {
        getStartedPage.clickGetStartedButton()
    }

    private fun navigateToFavoriteLeaguePage(favoriteLeaguePage: FavoriteLeaguePage, basePage: BasePage) {
        favoriteLeaguePage.clickFavoriteLeagueButton("MLB Baseball")
        basePage.clickContinueButton()
    }

    private fun declineLocationSharing(basePage: BasePage){
        basePage.clickMaybeLaterButton()
    }

    private fun navigateToFavoriteTeamPage(favoriteTeamPage: FavoriteTeamPage, basePage: BasePage){
        favoriteTeamPage.clickFavoriteTeamButton("Toronto Blue Jays")
        basePage.clickContinueButton()
    }

    private fun verifyTeamAndLeagueNotification(basePage: BasePage){
        basePage.clickDoneButton()
    }

    private fun declineNewsSharing(basePage: BasePage){
        basePage.clickMaybeLaterButton()
    }
    private fun verifyAppNotification(basePage: BasePage){
        basePage.clickAllowNotificationButton()
    }

    private fun verifyBettingPopup(basePage: BasePage){
        basePage.clickCloseModalButton()
    }

    private fun navigateToTeamPage(mainPage: MainPage) {
        mainPage.clickTeamIcon("TOR")
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