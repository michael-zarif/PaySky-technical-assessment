package pages;

import org.openqa.selenium.By;

public class ProductPage extends WebPage {

    public void addToCart() {
        clickById("btn-add-to-cart");
    }

    public void navigateToCart() {
        driver.findElement(By.cssSelector("a[aria-label='cart']")).click();
    }

}