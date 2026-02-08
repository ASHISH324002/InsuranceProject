package Base;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;



public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    String env;



    public void setup() {

        env = ConfigReader.get("env");
        String browserName = ConfigReader.get("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));

        String url = ConfigReader.get(env + ".url");

        playwright = Playwright.create();

        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
                .setHeadless(headless)
                .setArgs(List.of("--start-maximized"));

        switch (browserName.toLowerCase()) {
            case "firefox":
                browser = playwright.firefox().launch(options);
                break;
            case "webkit":
                browser = playwright.webkit().launch(options);
                break;
            default:
                browser = playwright.chromium().launch(options);
                break;
        }

        // Create fresh context (clears cache & cookies)
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

        // Clear cookies explicitly
        context.clearCookies();

        page = context.newPage();

        page.setDefaultTimeout(60000);
        page.setDefaultNavigationTimeout(60000);

        // Clear localStorage & sessionStorage
        page.addInitScript("() => { localStorage.clear(); sessionStorage.clear(); }");

        page.navigate(url);
    }
    public boolean isElementPresent(Locator locator) {
        try {
            return locator.isVisible();
        } catch (PlaywrightException e) {
            return false;
        }
    }
    public String getElementText(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        String text = locator.textContent();
        return text != null ? text.trim() : "";
    }
    public void assertElementText(Locator locator, String expectedText) {
        String actualText = getElementText(locator);
        assertEquals(expectedText, actualText,
                "Text assertion failed for locator: " + locator.toString());
    }

    protected void clickElement(Locator locator) {
        try {
            // Ensure element is in view
            locator.scrollIntoViewIfNeeded();

            // Wait until element is visible
            locator.waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(10_000));

            // Perform a real user-like click
            locator.click(new Locator.ClickOptions()
                    .setTimeout(10_000));

        } catch (PlaywrightException e) {
            // Fallback: JS force click (last resort)
            forceClick(locator);
        }

    }

    private void forceClick(Locator locator) {
        locator.evaluate("el => el.click()");
    }

    public void tearDown() {
        playwright.close();
    }
}
