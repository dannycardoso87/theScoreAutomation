package sportsapp.pages

import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver

class MainPage(driver: AndroidDriver<MobileElement>) : BasePage(driver) {
    private val teamIconLocator = MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.TextView")""")
    fun clickTeamIcon(teamIconTitle: String) {
        clickElementWithText(teamIconLocator, teamIconTitle)
    }
    fun verifyTeamIcon(teamIconTitle: String): Boolean {
        val actualText = isElementWithTextPresent(teamIconLocator, teamIconTitle)
        if (!actualText) {
            throw AssertionError("The title is different from : $teamIconTitle")
        }
        return actualText
    }
}
