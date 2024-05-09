package sportsapp.pages

import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver

class GetStartedPage(driver: AndroidDriver<MobileElement>) : BasePage(driver) {

    private val getStartedButtonLocator = MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.TextView").text("Get Started")""")
    fun clickGetStartedButton() {
        waitForClickableElement(getStartedButtonLocator).click()
    }

}
