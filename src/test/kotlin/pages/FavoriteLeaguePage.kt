package pages

import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.junit.jupiter.api.Assertions

class FavoriteLeaguePage(driver: AndroidDriver<MobileElement>) : BasePage(driver) {

    private val favoriteLeagueButtonLocator = MobileBy.AndroidUIAutomator("""new UiSelector().resourceId("com.fivemobile.thescore:id/txt_name")""")

    fun clickFavoriteLeagueButton(teamIconTitle: String) {
        val favoriteLeagueButton = waitForClickableElement(favoriteLeagueButtonLocator)
        Assertions.assertNotNull(favoriteLeagueButton, "Favorite League button $teamIconTitle is not clickable.")
        safeClickElementWithText(favoriteLeagueButtonLocator, teamIconTitle)
    }
}
