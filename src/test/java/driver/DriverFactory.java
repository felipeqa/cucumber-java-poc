package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();


    public static WebDriver getDriver(){
        if(webDriver.get() == null){
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    public static WebDriverWait waitElement(){
        return new WebDriverWait(webDriver.get(), Duration.ofSeconds(10));
    }

    private static WebDriver createDriver() {
        WebDriver driver = null;

        switch (getBrowserType()){
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", "/opt/homebrew/bin/geckodriver");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static String getBrowserType() {
        String browserType = null;

        try {
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/properties/config.properties");
            properties.load(file);
            browserType = properties.getProperty("browser").toLowerCase().trim();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return browserType;

    }

    public static void cleanupDriver(){
        webDriver.get().quit();
        webDriver.remove();
    }
}
