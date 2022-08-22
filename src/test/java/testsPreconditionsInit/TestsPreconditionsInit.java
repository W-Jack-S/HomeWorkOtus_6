package testsPreconditionsInit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pagesObjects.*;
import webDriverFactory.WebDriverFactory;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestsPreconditionsInit {

    public static Random random;
    public static int randomCity;
    public static WebDriver driver;
    public static String propLogin = System.getProperty("login");//
    public static String propPassword = System.getProperty("password");
    public static String firstName, lastName, birth, country, city, englishLevel, gender;
    public static String firstNameLatin = "Stas";
    public static String lastNameLatin = "Sinitsa";
    public static String blogName = "TestJack";
    public static String communicationType1 = "Facebook";
    public static String communicationType2 = "VK";
    public static String communicationAddress1 = "https://ru-ru.facebook.com/1";
    public static String communicationAddress2 = "https://vk.com/1";
    public static String company = "Рога и копыта";
    public static String work = "QA_tester";
    public static Authorization auth;
    public static PageActions act;
    public static HomePage homePage;
    public static RandomGen rand;
    public static CheckElement check;


    @BeforeEach
    public void webDriverStart(){
        driver = WebDriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        pagesObjectsInit();
    }

    @AfterEach
    public void exit(){
        if(driver != null) driver.quit();
    }

    public void pagesObjectsInit() {
        auth = new Authorization(driver);
        act = new PageActions(driver);
        homePage = new HomePage(driver);
        rand = new RandomGen(driver);
        random = new Random();
        check = new CheckElement(driver);

    }
}
