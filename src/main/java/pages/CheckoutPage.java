package pages;

import org.openqa.selenium.By;

public class CheckoutPage extends WebPage {

    public void proceedToCheckout() {
        driver.findElement(By.cssSelector("button[data-test='proceed-1']")).click();
    }

    public void addLoginCredentials(String email, String password) {
        sendKeysById("email", email);
        sendKeysById("password", password);
    }

    public void clickLogin() {
        driver.findElement(By.cssSelector("input.btnSubmit")).click();
    }

    public void proceedToCheckout2() {
        driver.findElement(By.cssSelector("button[data-test='proceed-2']")).click();
    }

    public void addBillingData(String address, String city, String state, String country, String postcode) {
        sendKeysById("address", address);
        sendKeysById("city", city);
        sendKeysById("state", state);
        sendKeysById("country", country);
        sendKeysById("postcode", postcode);
    }

    public void proceedToCheckout3() {
        driver.findElement(By.cssSelector("button[data-test='proceed-3']")).click();
    }

    public void selectPaymentMethod(String paymentMethod) {
        selectDropdownById("payment-method").selectByVisibleText(paymentMethod);
    }

    public void clickConfirm() {
        driver.findElement(By.cssSelector("button[data-test='finish']")).click();
    }

    public String getConfirmMessage(){
        return driver.findElement(By.className("help-block")).getText();
    }

    public void signOut(){
//        addClickableExplicitWait(15, driver.findElement(By.cssSelector("a#menu")));
        addWait(5);
        driver.findElement(By.cssSelector("a#menu")).click();
        clickLinkByText("Sign out");
    }

}