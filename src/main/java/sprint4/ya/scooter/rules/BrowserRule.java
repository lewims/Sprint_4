package sprint4.ya.scooter.rules;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserRule extends ExternalResource {

    private WebDriver webDriver;

    protected void before() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    protected void after() {
        webDriver.quit();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

}
