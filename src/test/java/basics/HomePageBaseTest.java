package basics;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import pages.HomePage;

public class HomePageBaseTest {
    protected static HomePage homePage = new HomePage();

    @BeforeEach
    public void openPage() {
        homePage.openHomePage();
        homePage.maximizeWindow();
    }

    @AfterAll
    public static void tearDown() {
        homePage.tearDown();
    }
}
