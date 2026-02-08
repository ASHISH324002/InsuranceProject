import Base.BaseTest;
import Base.ConfigReader;
import Pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LoginTest extends BaseTest {
    LoginPage loginPage;
    String env = ConfigReader.get("env");
    @BeforeEach
    public void call() {
        setup();
        loginPage = new LoginPage(page);
    }

    @Test
    public void logincall() {
        loginPage.login(ConfigReader.get(env + "." + "username"), ConfigReader.get(env + "." + "password"));
    }
}
