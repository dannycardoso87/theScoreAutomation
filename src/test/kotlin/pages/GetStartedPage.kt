package pages

import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.junit.jupiter.api.Assertions

class GetStartedPage(driver: AndroidDriver<MobileElement>) : BasePage(driver) {

    private val getStartedButtonLocator = MobileBy.AndroidUIAutomator("""new UiSelector().resourceId("com.fivemobile.thescore:id/action_button_text").text("Get Started")""")
    fun clickGetStartedButton() {
        val getStartedButton = waitForClickableElement(getStartedButtonLocator)
        Assertions.assertNotNull(getStartedButton, "Get Started button is not clickable.")
        getStartedButton.click()
    }
}
