import org.junit.jupiter.api.Test
import sportsapp.utils.SportsEnum
import sportsapp.BasePage

class SportsAppTest : BaseTest() {
    private val basePage = BasePage()
    @Test
    // In SportsAppTest, you have a long method testAutomationFlow that
    // performs multiple actions. Consider breaking it down into smaller,
    // more focused tests, each with a clear purpose. This will make the code
    // more maintainable and easier to understand.
    fun testAutomationFlow() {
        clickGetStartedButton()
        favoriteLeague()
        chooseLocation()
        favoriteTeam()
        dismissMessaging()
        allowNotifications()
        navigateToTeamPage()
        dismissModal()
        verifyCorrectPage()
        navigateToTeamStatsPage()
        verifyStatsPageElements()
        clickBackButton()
        verifyTeamPageIsDisplayed()
    }

    private fun clickGetStartedButton() {
        basePage.clickElementById(driver, SportsEnum.GET_STARTED_BUTTON.value)
    }
    private fun favoriteLeague() {
        basePage.clickElementByCss(driver, SportsEnum.MLB_BASEBALL.value)
        basePage.clickElementById(driver, SportsEnum.CONTINUE_BUTTON.value)
    }
    private fun chooseLocation() {
        basePage.clickElementByCss(driver, SportsEnum.MAYBE_LATER_BUTTON.value)
    }
    private fun favoriteTeam() {
        basePage.clickElementByCss(driver, SportsEnum.TORONTO_BLUE_JAYS.value)
        basePage.clickElementById(driver, SportsEnum.CONTINUE_BUTTON.value)
        basePage.clickElementById(driver, SportsEnum.DONE_BUTTON.value)
    }
    private fun dismissMessaging() {
        basePage.clickElementByCss(driver, SportsEnum.MAYBE_LATER_BUTTON.value)
    }
    private fun allowNotifications() {
        basePage.clickElementByClass(driver, SportsEnum.ALLOW_BUTTON.value)
        basePage.clickElementByCss(driver, SportsEnum.OK_GOT_IT_BUTTON.value)
    }
    private fun navigateToTeamPage() {
        basePage.clickElementByCss(driver, SportsEnum.TORONTO_BLUE_JAYS_ICON.value)
    }
    private fun dismissModal() {
        basePage.clickDismissModal(driver)
    }
    private fun verifyCorrectPage() {
        basePage.isElementPresent(driver, SportsEnum.TORONTO_BLUE_JAYS.value)
    }
    private fun navigateToTeamStatsPage() {
        basePage.clickElementByCss(driver, SportsEnum.TEAM_STATS_PAGE.value)
    }
    private fun verifyStatsPageElements() {
        basePage.isElementPresent(driver, SportsEnum.STATS_LABEL.value)
        basePage.isElementPresent(driver, SportsEnum.RANK_LABEL.value)
    }
    private fun clickBackButton() {
        basePage.clickBackButton(driver)
    }
    private fun verifyTeamPageIsDisplayed() {
        basePage.isElementPresent(driver, SportsEnum.TORONTO_BLUE_JAYS_ICON.value)
    }
}
