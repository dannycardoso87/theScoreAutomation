import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

open class BaseTest {
    lateinit var driver: AppiumDriver<MobileElement>

    @BeforeEach
    fun setUp() {
        val capabilities = DesiredCapabilities()
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554")
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2")
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/danny/Downloads/Documents/theScore/thescore.apk")

        //In BaseTest, you have hardcoded values like "/Users/danny/Downloads/Documents/theScore/thescore.apk"
        // and "http://127.0.0.1:4723/". Consider using environment variables or a configuration file to store these values.
        driver = AndroidDriver(URL("http://127.0.0.1:4723/"), capabilities)
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}