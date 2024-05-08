import org.junit.jupiter.api.Test
import sportsapp.utils.SportsEnum
import sportsapp.utils.PageActions

class SportsAppTest : BaseTest() {
    private val pageActions = PageActions()
    @Test
    //In SportsAppTest, you have a long method testAutomationFlow that
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
        pageActions.clickElementById(driver, SportsEnum.GET_STARTED_BUTTON.value)
    }
    private fun favoriteLeague() {
        pageActions.clickElementByCss(driver, SportsEnum.MLB_BASEBALL.value)
        pageActions.clickElementById(driver, SportsEnum.CONTINUE_BUTTON.value)
    }
    private fun chooseLocation() {
        pageActions.clickElementByCss(driver, SportsEnum.MAYBE_LATER_BUTTON.value)
    }
    private fun favoriteTeam() {
        pageActions.clickElementByCss(driver, SportsEnum.TORONTO_BLUE_JAYS.value)
        pageActions.clickElementById(driver, SportsEnum.CONTINUE_BUTTON.value)
        pageActions.clickElementById(driver, SportsEnum.DONE_BUTTON.value)
    }
    private fun dismissMessaging() {
        pageActions.clickElementByCss(driver, SportsEnum.MAYBE_LATER_BUTTON.value)
    }
    private fun allowNotifications() {
        pageActions.clickElementByClass(driver, SportsEnum.ALLOW_BUTTON.value)
        pageActions.clickElementByCss(driver, SportsEnum.OK_GOT_IT_BUTTON.value)
    }
    private fun navigateToTeamPage() {
        pageActions.clickElementByCss(driver, SportsEnum.TORONTO_BLUE_JAYS_ICON.value)
    }
    private fun dismissModal() {
        pageActions.clickDismissModal(driver)
    }
    private fun verifyCorrectPage() {
        pageActions.isElementPresent(driver, SportsEnum.TORONTO_BLUE_JAYS.value)
    }
    private fun navigateToTeamStatsPage() {
        pageActions.clickElementByCss(driver, SportsEnum.TEAM_STATS_PAGE.value)
    }
    private fun verifyStatsPageElements() {
        pageActions.isElementPresent(driver, SportsEnum.STATS_LABEL.value)
        pageActions.isElementPresent(driver, SportsEnum.RANK_LABEL.value)
    }
    private fun clickBackButton() {
        pageActions.clickBackButton(driver)
    }
    private fun verifyTeamPageIsDisplayed() {
        pageActions.isElementPresent(driver, SportsEnum.TORONTO_BLUE_JAYS_ICON.value)
    }
}
