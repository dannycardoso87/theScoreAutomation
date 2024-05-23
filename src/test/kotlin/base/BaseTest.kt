package base

import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.remote.DesiredCapabilities
import java.io.FileInputStream
import java.net.URL
import java.util.*

open class BaseTest {
    lateinit var driver: AndroidDriver<MobileElement>
    object Config {
        const val CONFIG_FILE_PATH = "config.properties"
    }
    @BeforeEach
    fun setUp() {
        val capabilities = DesiredCapabilities()
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        val deviceSerialNumber = Runtime.getRuntime().exec("adb devices").inputStream.bufferedReader().use { it.readText() }.trim().split("\n")[1].split("\\s+".toRegex())[0]
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceSerialNumber)
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2")
        val properties = Properties()
        properties.load(FileInputStream(Config.CONFIG_FILE_PATH))
        capabilities.setCapability(MobileCapabilityType.APP, properties.getProperty("apk_file_path"))
        val appiumServerUrl = properties.getProperty("appium_server_url")

        driver = AndroidDriver(URL(appiumServerUrl), capabilities)
    }
    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}