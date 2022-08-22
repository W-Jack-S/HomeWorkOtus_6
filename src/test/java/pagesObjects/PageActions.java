package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.By.xpath;

public class PageActions {
    public WebDriver driver;

    public PageActions(WebDriver driver){
        this.driver = driver;
    }

    public void moveCursor(By elementBy){
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(elementBy)).build().perform();
    }

    public void click(By elementBy){
        driver.findElement(elementBy).click();
    }

    public void textInput(By elementBy, String text) {
        String input = driver.findElement(elementBy).getAttribute("value");
        driver.findElement(elementBy).click();
        if (input != "") {
            driver.findElement(elementBy).clear();
        }
        //!!!!МЕТОД .clear() ОТРАБАТЫВАЕТ НЕ ВСЕГДА - ПРОБЛЕМЫ С ОЧИСТКОЙ ПОЛЕЙ С АВТОЗАПОЛНЕНИЕМ
        //НИЖЕ - АВАРИЙНЫЙ КОСТЫЛЬ: ЗАБИТЬ ПОЛЕ BackSpace'ом
        String inputAfter = driver.findElement(elementBy).getAttribute("value");
        while (inputAfter != "") {
            driver.findElement(elementBy).sendKeys("\b");
            inputAfter = driver.findElement(elementBy).getAttribute("value");
        }
        driver.findElement(elementBy).sendKeys(text);
    }
}
