package pages

import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.junit.jupiter.api.Assertions.assertTrue

class TeamPage(driver: AndroidDriver<MobileElement>) : BasePage(driver) {

    private val pageTitleLocator = MobileBy.AndroidUIAutomator("""new UiSelector().resourceId("com.fivemobile.thescore:id/team_name")""")
    private val elementLocator = MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.TextView")""")

    fun verifyPageTitle(pageTitle: String): Boolean {
        val actualText = confirmElement(pageTitleLocator, pageTitle)
        assertTrue(actualText, "The title is different from: $pageTitle")
        return actualText
    }

    fun clickTab(tabTitle: String) {
        safeClickElementWithText(elementLocator, tabTitle)
    }

    fun verifyTabIsSelected(tabTitle: String) {
        assertElementWithTextAndSelectedPresent(elementLocator, tabTitle)
    }

    fun verifyHeaderIsPresented(header: String): Boolean {
        val actualText = isElementWithTextPresent(elementLocator, header)
        assertTrue(actualText, "$header is not presented.")
        return actualText
    }
}