package sportsapp.pages

import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver

class FavoriteLeaguePage(driver: AndroidDriver<MobileElement>) : BasePage(driver) {

    private val favoriteLeagueButtonLocator = MobileBy.AndroidUIAutomator("""new UiSelector().className("android.widget.TextView")""")
    fun clickFavoriteLeagueButton(teamIconTitle: String) {
        clickElementWithText(favoriteLeagueButtonLocator, teamIconTitle)
    }
}
