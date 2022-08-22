package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckElement {
    public WebDriver driver;

    public CheckElement(WebDriver driver) {
        this.driver = driver;
    }

    public void dropBox(By elementBy, String expectedText) {
        assertEquals(driver.findElement(elementBy).getText(), expectedText);
    }

    public void input(By elementBy, String expectedText) {
        assertEquals(driver.findElement(elementBy).getAttribute("value"), expectedText);
    }

    public boolean findElement(By element){
        try{
            driver.findElement(element);
            return true;
        } catch (NoSuchElementException e) {return false;}
    }
}