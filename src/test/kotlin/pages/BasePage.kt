package pages
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import io.appium.java_client.android.AndroidDriver
import org.junit.jupiter.api.Assertions
import java.util.concurrent.TimeoutException
import java.util.logging.Logger

open class BasePage(protected val driver: AndroidDriver<MobileElement>) {

    private val continueButtonLocator = MobileBy.AndroidUIAutomator("""new UiSelector().resourceId("com.fivemobile.thescore:id/action_button_text").text("Continue")""")
    private val maybeLaterButtonLocator = MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.TextView").text("Maybe Later")""")
    private val doneButtonLocator = MobileBy.AndroidUIAutomator("""new UiSelector().resourceId("com.fivemobile.thescore:id/action_button_text").text("Done")""")
    private val allowNotificationButtonLocator = MobileBy.AndroidUIAutomator("""new UiSelector().resourceId("com.android.permissioncontroller:id/permission_allow_button").text("Allow")""")
    private val closeModalButtonLocator = MobileBy.AndroidUIAutomator("""new UiSelector().resourceId("com.fivemobile.thescore:id/dismiss_modal")""")
    private val returnButtonLocator = MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.ImageButton").description("Navigate up")""")


    private val logger: Logger = Logger.getLogger(BasePage::class.java.name)
    private val defaultTimeout: Long = 10

    fun waitForClickableElement(locator: By, timeout: Long = defaultTimeout): MobileElement {
        logger.info("Waiting for element to be clickable: $locator with timeout: $timeout seconds")
        try {
            val wait = WebDriverWait(driver, timeout)
            val element = wait.until(ExpectedConditions.elementToBeClickable(locator)) as MobileElement
            return element
        } catch (e: TimeoutException) {
            val errorMessage = "Timeout waiting for element to be clickable: $locator after $timeout seconds"
            logger.severe(errorMessage)
            throw AssertionError(errorMessage, e)
        } catch (e: Exception) {
            val errorMessage = "An error occurred while waiting for element to be clickable: $locator"
            logger.severe(errorMessage)
            throw AssertionError(errorMessage, e)
        }
    }

    fun assertElementWithTextAndSelectedPresent(locator: By, textToFind: String, timeout: Long = defaultTimeout) {
        logger.info("Checking for element with text '$textToFind' and selected state at locator: $locator with timeout: $timeout seconds")
        try {
            val wait = WebDriverWait(driver, timeout)
            val elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator))

            for (element in elements) {
                if (element.text == textToFind && element.isSelected) {
                    return
                }
            }
            val errorMessage = "Element with text '$textToFind' and selected state not found at locator: $locator"
            throw NoSuchElementException(errorMessage)
        } catch (e: TimeoutException) {
            val errorMessage = "Timeout waiting for elements at locator: $locator after $timeout seconds"
            logger.severe(errorMessage)
            throw AssertionError(errorMessage, e)
        } catch (e: Exception) {
            val errorMessage = "An error occurred while checking elements at locator: $locator with text '$textToFind'"
            logger.severe(errorMessage)
            throw AssertionError(errorMessage, e)
        }
    }

    fun safeClickElementWithText(locator: By, textToClick: String, timeout: Long = defaultTimeout) {
        logger.info("Attempting to click element with text '$textToClick' at locator: $locator with timeout: $timeout seconds")
        try {
            val wait = WebDriverWait(driver, timeout)
            val elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator))

            for (element in elements) {
                if (element.text == textToClick) {
                    val clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element))
                    clickableElement.click()
                    return
                }
            }
            val errorMessage = "Element with text '$textToClick' not found in the list at locator: $locator"
            throw NoSuchElementException(errorMessage)
        } catch (e: TimeoutException) {
            val errorMessage = "Timeout waiting for element with text '$textToClick' to be clickable at locator: $locator after $timeout seconds"
            logger.severe(errorMessage)
            throw AssertionError(errorMessage, e)
        } catch (e: Exception) {
            val errorMessage = "An error occurred while attempting to click element with text '$textToClick' at locator: $locator"
            logger.severe(errorMessage)
            throw AssertionError(errorMessage, e)
        }
    }

    fun confirmElement(locator: By, expectedText: String, timeout: Long = defaultTimeout): Boolean {
        return try {
            val wait = WebDriverWait(driver, timeout)
            val element = wait.until(ExpectedConditions.presenceOfElementLocated(locator))
            val isTextMatching = element.text == expectedText
            if (isTextMatching) {
                logger.info("Element found and text matches the expected text: '$expectedText'.")
            } else {
                logger.warning("Element found but text does not match. Expected: '$expectedText', Found: '${element.text}'.")
            }
            isTextMatching
        } catch (e: TimeoutException) {
            val errorMessage = "Timeout waiting for element located by $locator with expected text '$expectedText' after $timeout seconds."
            logger.severe(errorMessage)
            throw AssertionError(errorMessage, e)
        } catch (e: Exception) {
            val errorMessage = "Exception occurred while confirming element located by $locator with expected text '$expectedText'."
            logger.severe("$errorMessage Exception: ${e.message}")
            throw e
        }
    }

    fun isElementWithTextPresent(locator: By, textToFind: String, timeout: Long = defaultTimeout): Boolean {
        return try {
            val wait = WebDriverWait(driver, timeout)
            val elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator))
            for (element in elements) {
                if (element.text == textToFind) {
                    logger.info("Element with text '$textToFind' found.")
                    return true
                }
            }
            logger.severe("Element with text '$textToFind' not found.")
            false
        } catch (e: TimeoutException) {
            val errorMessage = "Timeout waiting for elements located by $locator with text '$textToFind' after $timeout seconds."
            logger.severe(errorMessage)
            throw AssertionError(errorMessage, e)
        } catch (e: Exception) {
            val errorMessage = "Exception occurred while checking elements located by $locator with text '$textToFind'."
            logger.severe("$errorMessage Exception: ${e.message}")
            throw AssertionError(errorMessage, e)
        }
    }

    fun clickContinueButton() {
        val continueButton = waitForClickableElement(continueButtonLocator)
        Assertions.assertNotNull(continueButton, "Continue button is not clickable.")
        continueButton.click()
    }
    fun clickMaybeLaterButton() {
        val maybeLaterButton = waitForClickableElement(maybeLaterButtonLocator)
        Assertions.assertNotNull(maybeLaterButton, "Maybe Later button is not clickable.")
        maybeLaterButton.click()
    }
    fun clickDoneButton() {
        val doneButton = waitForClickableElement(doneButtonLocator)
        Assertions.assertNotNull(doneButton, "Done button is not clickable.")
        doneButton.click()
    }
    fun clickAllowNotificationButton() {
        val allowNotificationButton = waitForClickableElement(allowNotificationButtonLocator)
        Assertions.assertNotNull(allowNotificationButton, "Allow Notification button is not clickable.")
        allowNotificationButton.click()
    }

    fun clickCloseModalButton() {
        val closeModalButton = waitForClickableElement(closeModalButtonLocator)
        Assertions.assertNotNull(closeModalButton, "Close Modal button is not clickable.")
        closeModalButton.click()
    }

    fun clickReturnButton() {
        val returnButton = waitForClickableElement(returnButtonLocator)
        Assertions.assertNotNull(returnButton, "Return button is not clickable.")
        returnButton.click()
    }
}