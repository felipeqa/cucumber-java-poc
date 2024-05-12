package pageObject;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base_PO {

    public Base_PO() {
        PageFactory.initElements(getDriver_PO(), this);
    }

    public WebDriver getDriver_PO() {
        return DriverFactory.getDriver();
    }

    public void navigateTo_URL(String url) {
        getDriver_PO().get(url);
    }

    public String generateRandomNumber(int lenght) {
        return RandomStringUtils.randomNumeric(lenght);
    }

    public void sendKeys (By selectorType, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver_PO(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(selectorType)).sendKeys(textToType);
    }

    public void sendKeys (WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver_PO(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }

    public void waitFor(By by){
        WebDriverWait wait = new WebDriverWait(getDriver_PO(), Duration.ofSeconds(10));
        //apenas um
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        //no curso o exemplo é para a lista
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitFor(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver_PO(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForWebElementAndClick (By selectorType) {
        WebDriverWait wait = new WebDriverWait(getDriver_PO(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(selectorType)).click();
    }

    public void waitForWebElementAndClick (WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver_PO(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }



}
