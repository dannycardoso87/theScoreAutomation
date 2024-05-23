package extensions

import base.BaseTest
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.MobileElement

class ScreenshotOnFailure : TestExecutionExceptionHandler {
    override fun handleTestExecutionException(context: ExtensionContext, throwable: Throwable) {
        val driver = (context.requiredTestInstance as BaseTest).driver
        val screenshotPath = takeScreenshot(driver)
        println("Screenshot saved in: $screenshotPath")
        throw AssertionError("Test failed. See screenshot for details.", throwable)
    }

    private fun takeScreenshot(driver: AndroidDriver<MobileElement>): String {
        val screenshot = (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
        val screenshotDir = Paths.get("screenshots")
        Files.createDirectories(screenshotDir)
        val timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"))
        val screenshotPath = screenshotDir.resolve("screenshot_$timestamp.png")
        Files.copy(screenshot.toPath(), screenshotPath)
        return screenshotPath.toString()
    }
}
