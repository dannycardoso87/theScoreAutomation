package sportsapp.pages

import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.By

class FavoriteTeamPage(driver: AndroidDriver<MobileElement>) : BasePage(driver) {

    private val favoriteTeamButtonLocator = MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.TextView")""")
    fun clickFavoriteTeamButton(teamIconTitle: String) {
        clickElementWithText(favoriteTeamButtonLocator, teamIconTitle)
    }

}
