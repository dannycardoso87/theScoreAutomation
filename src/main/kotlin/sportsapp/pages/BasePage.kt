package sportsapp.pages
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import io.appium.java_client.android.AndroidDriver

open class BasePage(protected val driver: AndroidDriver<MobileElement>) {

    private val continueButtonLocator = MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.TextView").text("Continue")""")
    private val maybeLaterButtonLocator = MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.TextView").text("Maybe Later")""")
    private val doneButtonLocator = MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.TextView").text("Done")""")
    private val allowNotificationButtonLocator = MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.Button").text("Allow")""")
    private val okGotItButtonLocator = MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.TextView").text("Ok, Got It")""")
    private val closeModalButton = MobileBy.AndroidUIAutomator("""new UiSelector().resourceId("com.fivemobile.thescore:id/dismiss_modal")""")
    private val returnButtonLocator = MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.ImageButton").description("Navigate up")""")

    fun waitForClickableElement(locator: By): MobileElement {
        val wait = WebDriverWait(driver, 10)
        return wait.until(ExpectedConditions.elementToBeClickable(locator)) as MobileElement
    }

    fun isElementWithTextAndSelectedPresent(locator: By, textToFind: String): Boolean {
        val wait = WebDriverWait(driver, 10)
        val elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator))

        for (element in elements) {
            if (element.text == textToFind && element.isSelected) {
                return true
            }
        }

        return false
    }
    fun confirmElement(locator: By, expectedText: String): Boolean {
        val wait = WebDriverWait(driver, 10)
        val element = wait.until(ExpectedConditions.presenceOfElementLocated(locator))
        println("Attribute value 'text': ${element.text}")
        return element.text == expectedText
    }
    fun clickElementWithText(locator: By, textToClick: String) {
        val wait = WebDriverWait(driver, 10)
        val elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator))

        for (element in elements) {
            if (element.text == textToClick) {
                val clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element))
                clickableElement.click()
                return
            }
        }

        throw NoSuchElementException("Element with text '$textToClick' not found in the list.")
    }

    fun isElementWithTextPresent(locator: By, textToFind: String): Boolean {
        val wait = WebDriverWait(driver, 10)
        val elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator))
        for (element in elements) {
            if (element.text == textToFind) {
                return true
            }
        }
        return false
    }
    fun clickContinueButton() {
        waitForClickableElement(continueButtonLocator).click()
    }
    fun clickMaybeLaterButton() {
        waitForClickableElement(maybeLaterButtonLocator).click()
    }
    fun clickDoneButton() {
        waitForClickableElement(doneButtonLocator).click()
    }
    fun clickAllowNotificationButton() {
        waitForClickableElement(allowNotificationButtonLocator).click()
    }
    fun clickOkGotItButton() {
        waitForClickableElement(okGotItButtonLocator).click()
    }
    fun clickCloseModalButton() {
        waitForClickableElement(closeModalButton).click()
    }
    fun clickReturnButton() {
        waitForClickableElement(returnButtonLocator).click()
    }
}