package pages;

import org.openqa.selenium.By;

public class RegisterPage extends WebPage {

    public void fillRegistrationForm(String firstName, String lastName, String dateOfBirth, String address, String postcode, String city, String state, String country, String phone, String email, String password) {
        sendKeysById("first_name", firstName);
        sendKeysById("last_name", lastName);
        sendKeysById("dob", dateOfBirth);
        sendKeysById("address", address);
        sendKeysById("postcode", postcode);
        sendKeysById("city", city);
        sendKeysById("state", state);
        selectDropdownById("country").selectByVisibleText(country);
        sendKeysById("phone", phone);
        sendKeysById("email", email);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);    // id of element is not unique
    }

    public void clickRegister() {
        driver.findElement(By.cssSelector("button[data-test='register-submit']")).click();
    }
}