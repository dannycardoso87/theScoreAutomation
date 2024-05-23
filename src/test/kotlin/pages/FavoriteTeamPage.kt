package pages

import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.junit.jupiter.api.Assertions

class FavoriteTeamPage(driver: AndroidDriver<MobileElement>) : BasePage(driver) {

    private val favoriteTeamButtonLocator = MobileBy.AndroidUIAutomator("""new UiSelector().resourceId("com.fivemobile.thescore:id/txt_name")""")
    fun clickFavoriteTeamButton(teamIconTitle: String) {
        val favoriteTeamButton = waitForClickableElement(favoriteTeamButtonLocator)
        Assertions.assertNotNull(favoriteTeamButton, "Favorite Team button $teamIconTitle is not clickable.")
        safeClickElementWithText(favoriteTeamButtonLocator, teamIconTitle)
    }

}
