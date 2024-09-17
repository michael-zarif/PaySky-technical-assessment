package pages;

import org.openqa.selenium.By;

public class LoginPage extends WebPage {

    public void openRegisterPage() {
        clickLinkByText("Register your account");
    }

    public boolean loginPageIsLoaded() {
        return driver.findElement(By.cssSelector("input[data-test='login-submit']")).isDisplayed();
    }

}