package pages;

import org.openqa.selenium.By;

public class HomePage extends WebPage {

    public void openHomePage(){
        openPage("https://practicesoftwaretesting.com");
        addImplicitWait(5);
    }

    public void selectProduct(String product) {
        driver.findElement(By.cssSelector(String.format("img[alt='%s']", product))).click();
    }

    public void openLoginPage() {
        clickLinkByText("Sign in");
    }

}