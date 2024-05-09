package sportsapp.pages

import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver

class TeamPage(driver: AndroidDriver<MobileElement>) : BasePage(driver) {

    private val pageTitleLocator = MobileBy.AndroidUIAutomator("""new UiSelector().resourceId("com.fivemobile.thescore:id/team_name")""")
    private val tabLocator = MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.TextView")""")
    private val headerLocator = MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.TextView")""")

    fun verifyPageTitle(pageTitle: String): Boolean {
        val actualText = confirmElement(pageTitleLocator, pageTitle)
        if (!actualText) {
            throw AssertionError("The title is different from : $pageTitle")
        }
        return actualText
    }

    fun clickTab(tabTitle: String) {
        clickElementWithText(tabLocator, tabTitle)
    }

    fun verifyTabIsSelected(tabTitle: String): Boolean {
        val isSelected = isElementWithTextAndSelectedPresent(tabLocator, tabTitle)
        if (!isSelected) {
            throw AssertionError("The TEAM STATS tab is not selected.")
        }
        return isSelected
    }
    fun verifyHeaderIsPresented(header: String): Boolean {
        val actualText = isElementWithTextPresent(headerLocator, header)
        if (!actualText) {
            throw AssertionError("$header is not presented.")
        }
        return actualText
    }
}