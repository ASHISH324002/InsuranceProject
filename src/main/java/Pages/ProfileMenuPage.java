package Pages;

import Base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class ProfileMenuPage extends  BaseTest {
    // -------------------------

    // Profile Icon
    private final Locator profileIcon;

    // Profile Menu Links
    private final Locator yourProfileLink;
    private final Locator preferencesLink;
    private final Locator systemSettingsLink;
    private final Locator changeProductLink;

    // Quick Links
    private final Locator quickLinksHeader;
    private final Locator lastVisitedLink;
    private final Locator favouritesLink;
    private final Locator documentationLink;
    private final Locator visitUsLink;

    // Sign Out
    private final Locator signOutButton;

    // -------------------------
    // Constructor
    // -------------------------
    public ProfileMenuPage(Page page) {
        this.page = page;

        profileIcon = page.locator("(//div[@class='relative'])[2]");

        yourProfileLink = page.getByRole(com.microsoft.playwright.options.AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Your Profile"));

        preferencesLink = page.getByRole(com.microsoft.playwright.options.AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Preferences"));

        systemSettingsLink = page.getByRole(com.microsoft.playwright.options.AriaRole.LINK,
                new Page.GetByRoleOptions().setName("System Settings"));

        changeProductLink = page.getByRole(com.microsoft.playwright.options.AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Change Product"));

        quickLinksHeader = page.locator("div:has-text('QUICK LINKS')");

        lastVisitedLink = page.locator("a:has-text('Last Visited')");
        favouritesLink = page.locator("a:has-text('Favourites')");
        documentationLink = page.locator("a:has-text('Documentation')");
        visitUsLink = page.locator("a:has-text('Visit Us')");

        signOutButton = page.locator("button:has-text('Sign out')");
    }

    // =====================================================
    // Profile Icon
    // =====================================================

    public boolean isProfileIconPresent() {
        return isElementPresent(profileIcon);
    }

    public void assertProfileIconPresent() {
        assertTrue(isProfileIconPresent(), "Profile icon is not visible");
    }

    public void clickProfileIcon() {
        clickElement(profileIcon);
    }

    // =====================================================
    // Your Profile
    // =====================================================

    public boolean isYourProfilePresent() {
        return isElementPresent(yourProfileLink);
    }

    public void assertYourProfilePresent() {
        assertTrue(isYourProfilePresent(), "Your Profile link is not visible");
    }

    public void assertYourProfileText(String expectedText) {
        assertElementText(yourProfileLink, expectedText);
    }

    public void clickYourProfile() {
        clickElement(yourProfileLink);
    }

    // =====================================================
    // Preferences
    // =====================================================

    public boolean isPreferencesPresent() {
        return isElementPresent(preferencesLink);
    }

    public void assertPreferencesPresent() {
        assertTrue(isPreferencesPresent(), "Preferences link is not visible");
    }

    public void assertPreferencesText(String expectedText) {
        assertElementText(preferencesLink, expectedText);
    }

    public void clickPreferences() {
        clickElement(preferencesLink);
    }

    // =====================================================
    // System Settings
    // =====================================================

    public boolean isSystemSettingsPresent() {
        return isElementPresent(systemSettingsLink);
    }

    public void assertSystemSettingsPresent() {
        assertTrue(isSystemSettingsPresent(), "System Settings link is not visible");
    }

    public void assertSystemSettingsText(String expectedText) {
        assertElementText(systemSettingsLink, expectedText);
    }

    public void clickSystemSettings() {
        clickElement(systemSettingsLink);
    }

    // =====================================================
    // Change Product
    // =====================================================

    public boolean isChangeProductPresent() {
        return isElementPresent(changeProductLink);
    }

    public void assertChangeProductPresent() {
        assertTrue(isChangeProductPresent(), "Change Product link is not visible");
    }

    public void assertChangeProductText(String expectedText) {
        assertElementText(changeProductLink, expectedText);
    }

    public void clickChangeProduct() {
        clickElement(changeProductLink);
    }

    // =====================================================
    // Quick Links
    // =====================================================

    public boolean isQuickLinksHeaderPresent() {
        return isElementPresent(quickLinksHeader);
    }

    public void assertQuickLinksHeaderPresent() {
        assertTrue(isQuickLinksHeaderPresent(), "Quick Links header is not visible");
    }

    public void assertQuickLinksHeaderText(String expectedText) {
        assertElementText(quickLinksHeader, expectedText);
    }

    // =====================================================
    // Last Visited
    // =====================================================

    public boolean isLastVisitedPresent() {
        return isElementPresent(lastVisitedLink);
    }

    public void assertLastVisitedPresent() {
        assertTrue(isLastVisitedPresent(), "Last Visited link is not visible");
    }

    public void assertLastVisitedText(String expectedText) {
        assertElementText(lastVisitedLink, expectedText);
    }

    public void clickLastVisited() {
        clickElement(lastVisitedLink);
    }

    // =====================================================
    // Favourites
    // =====================================================

    public boolean isFavouritesPresent() {
        return isElementPresent(favouritesLink);
    }

    public void assertFavouritesPresent() {
        assertTrue(isFavouritesPresent(), "Favourites link is not visible");
    }

    public void assertFavouritesText(String expectedText) {
        assertElementText(favouritesLink, expectedText);
    }

    public void clickFavourites() {
        clickElement(favouritesLink);
    }

    // =====================================================
    // Documentation
    // =====================================================

    public boolean isDocumentationPresent() {
        return isElementPresent(documentationLink);
    }

    public void assertDocumentationPresent() {
        assertTrue(isDocumentationPresent(), "Documentation link is not visible");
    }

    public void assertDocumentationText(String expectedText) {
        assertElementText(documentationLink, expectedText);
    }

    public void clickDocumentation() {
        clickElement(documentationLink);
    }

    // =====================================================
    // Visit Us
    // =====================================================

    public boolean isVisitUsPresent() {
        return isElementPresent(visitUsLink);
    }

    public void assertVisitUsPresent() {
        assertTrue(isVisitUsPresent(), "Visit Us link is not visible");
    }

    public void assertVisitUsText(String expectedText) {
        assertElementText(visitUsLink, expectedText);
    }

    public void clickVisitUs() {
        clickElement(visitUsLink);
    }

    // =====================================================
    // Sign Out
    // =====================================================

    public boolean isSignOutPresent() {
        return isElementPresent(signOutButton);
    }

    public void assertSignOutPresent() {
        assertTrue(isSignOutPresent(), "Sign out button is not visible");
    }

    public void assertSignOutText(String expectedText) {
        assertElementText(signOutButton, expectedText);
    }

    public void clickSignOut() {
        clickElement(signOutButton);
    }
}

