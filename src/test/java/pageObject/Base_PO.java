package pageObject;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base_PO {

    public Base_PO() {
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

    public void sendKeys (By locator, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver_PO(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(textToType);
    }

}
