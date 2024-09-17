package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.WebDriverSetup;

import java.time.Duration;

public class WebPage {

    protected static WebDriver driver = WebDriverSetup.getChromeDriver();   // can be changed to any other browser defined in WebDriverSetup class

    public void openPage(String URL){
        driver.get(URL);
    }

    public void navigateToPage(String URL){
        driver.navigate().to(URL);
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void setSize(int width, int height){
        var dimension = new Dimension(width, height);
        driver.manage().window().setSize(dimension);
    }

    public WebElement webElementById(String id) {
        return driver.findElement(By.id(id));
    }

    public void sendKeysById(String id, String text) {
        driver.findElement(By.id(id)).sendKeys(text);
    }

    public void clickById(String id) {
        driver.findElement(By.id(id)).click();
    }

    public void clickLinkByText(String text) {
        driver.findElement(By.linkText(text)).click();
    }

    public Select selectDropdownById(String id) {
        return new Select(driver.findElement(By.id(id)));
    }

    public void addImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public void addWait(int seconds) {
        //  TimeUnit.SECONDS.sleep(seconds);    // needs exception handling
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void addDisplayedExplicitWait(int seconds, WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until((d -> webElement.isDisplayed()));
    }

    public void addClickableExplicitWait(int seconds, WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void closeBrowser() {
        driver.close();
    }

    public void tearDown() {
        driver.quit();
    }

}
