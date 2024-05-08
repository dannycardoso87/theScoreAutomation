package sportsapp.utils
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class PageActions {
    companion object {
        private const val TIMEOUT_SECONDS = 10
        private const val ACTION_BUTTON_ID = "com.fivemobile.thescore:id/action_button_text"
        private const val DISMISS_MODAL_ID = "com.fivemobile.thescore:id/dismiss_modal"
        private const val BACK_BUTTON_CLASS = "android.widget.ImageButton"
    }

    private fun getWebDriverWait(driver: AppiumDriver<MobileElement>): WebDriverWait {
        return WebDriverWait(driver, TIMEOUT_SECONDS.toLong())
    }
    fun clickElementById(driver: AppiumDriver<MobileElement>, elementIdentifier: String) {
        val wait = getWebDriverWait(driver)
        val element = wait.until(ExpectedConditions.elementToBeClickable(By.id(ACTION_BUTTON_ID)))
        if (element.text == elementIdentifier) {
            element.click()
        }
    }
    fun clickElementByCss(driver: AppiumDriver<MobileElement>, elementIdentifier: String) {
        val wait = getWebDriverWait(driver)
        val element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("android.widget.TextView[text='$elementIdentifier']")))
        element.click()
    }

    fun clickElementByClass(driver: AppiumDriver<MobileElement>, elementIdentifier: String) {
        val wait = getWebDriverWait(driver)
        val element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("android.widget.Button[text='$elementIdentifier']")))
        element.click()
    }

    fun isElementPresent(driver: AppiumDriver<MobileElement>, elementIdentifier: String): Boolean {
        val wait = getWebDriverWait(driver)
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("android.widget.TextView[text='$elementIdentifier']")))!= null
    }

    fun clickDismissModal(driver: AppiumDriver<MobileElement>) {
        val wait = getWebDriverWait(driver)
        val element = wait.until(ExpectedConditions.elementToBeClickable(By.id(DISMISS_MODAL_ID)))
        element.click()
    }

    fun clickBackButton(driver: AppiumDriver<MobileElement>) {
        val wait = getWebDriverWait(driver)
        val element = wait.until(ExpectedConditions.elementToBeClickable(By.className(BACK_BUTTON_CLASS)))
        element.click()
    }
}