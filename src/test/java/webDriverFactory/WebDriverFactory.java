package webDriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.util.Locale;

public class WebDriverFactory {
    public static WebDriver getDriver(){

        String browser = System.getProperty("browser");
        String option = System.getProperty("option");

        if (browser == null) {
            WebDriverManager.chromedriver().setup();
            if (option == "headless") {
                ChromeOptions options = new ChromeOptions();
                options.addArguments(option);
            };
            return new ChromeDriver();
        }

        switch (browser.toLowerCase(Locale.ROOT).trim()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                if (option == "headless") {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(option);
                }
                return new ChromeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                if (option == "headless") {
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments(option);
                }
                return new FirefoxDriver();
            case "opera":
                WebDriverManager.operadriver().setup();
                if (option == "headless") {
                    OperaOptions options = new OperaOptions();
                    options.addArguments(option);
                }
                return new OperaDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                if (option == "headless") {
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments(option);
                }
                return new EdgeDriver();

        }
        return new ChromeDriver();
    }
}
