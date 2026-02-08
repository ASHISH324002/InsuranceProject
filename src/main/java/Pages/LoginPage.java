package Pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

public class LoginPage   
 {
    private final Page page;

    // Static locators
    static Locator username;
    static Locator password;
    static Locator loginBtn;
    // Constructor to initialize locators
    public LoginPage(Page page) {
        this.page=page;
        username = page.locator("input[placeholder='Username']");
        password = page.locator("input[placeholder='Password']");
        loginBtn = page.locator("button[type='submit']:has-text('Log in')");  
    }

    // Enter Username
    public static void enterUsername(String userName) {
        username.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        username.fill(userName);
    }

    // Enter Password
    public static void enterPassword(String passWord) {
        password.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        password.fill(passWord);
    }

    // Click Login Button
    public static void clickLogin() {
        loginBtn.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        loginBtn.click();
    }

    // Combined login method (optional but recommended)
    public void login(String userName, String passWord) {
        enterUsername(userName);
        enterPassword(passWord);
        clickLogin();
    }
}

