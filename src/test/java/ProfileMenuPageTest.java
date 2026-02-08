
import Base.BaseTest;
import Base.ConfigReader;
import Pages.LoginPage;
import Pages.ProfileMenuPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProfileMenuPageTest extends BaseTest {

    private ProfileMenuPage profileMenuPage;
    private LoginPage loginPage;
    String env = ConfigReader.get("env");

    @BeforeEach
    void setUpTest() {
        setup(); // comes from BaseTest
        profileMenuPage = new ProfileMenuPage(page);
        loginPage = new LoginPage(page);
        // Assumption: user is already logged in
        // and profile icon is visible after login
    }

    // =====================================================
    // Profile Icon & Menu Visibility
    // =====================================================

    @Test
    void verifyProfileMenuItemsAreVisible() {
        loginPage.login(ConfigReader.get(env + "." + "username"), ConfigReader.get(env + "." + "password"));
        profileMenuPage.assertProfileIconPresent();
        profileMenuPage.clickProfileIcon();

        profileMenuPage.assertYourProfilePresent();
        profileMenuPage.assertPreferencesPresent();
        profileMenuPage.assertSystemSettingsPresent();
        profileMenuPage.assertChangeProductPresent();

        profileMenuPage.assertQuickLinksHeaderPresent();
        profileMenuPage.assertLastVisitedPresent();
        profileMenuPage.assertFavouritesPresent();
        profileMenuPage.assertDocumentationPresent();
        profileMenuPage.assertVisitUsPresent();

        profileMenuPage.assertSignOutPresent();
    }

    // =====================================================
    // Text Validation
    // =====================================================



    // =====================================================
    // Navigation Tests
    // =====================================================


}

