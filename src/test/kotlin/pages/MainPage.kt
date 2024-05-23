package pages

import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.junit.jupiter.api.Assertions

class MainPage(driver: AndroidDriver<MobileElement>) : BasePage(driver) {
    private val teamIconLocator = MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.TextView")""")

    fun clickTeamIcon(teamIconTitle: String) {
        val teamIcon = waitForClickableElement(teamIconLocator)
        Assertions.assertNotNull(teamIcon, "Team icon $teamIconTitle is not clickable.")
        safeClickElementWithText(teamIconLocator, teamIconTitle)
    }

    fun verifyTeamIcon(teamIconTitle: String): Boolean {
        val actualText = isElementWithTextPresent(teamIconLocator, teamIconTitle)
        Assertions.assertTrue(actualText, "The title is different from : $teamIconTitle")
        return actualText
    }
}
