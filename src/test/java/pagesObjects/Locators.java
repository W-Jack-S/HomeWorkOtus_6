package pagesObjects;

import org.openqa.selenium.By;



import static org.openqa.selenium.By.xpath;

public enum Locators {

    EMAIL(xpath(".//input[@name='email']")),
    PASSWORD(xpath(".//input[@name='password']")),
    AUTH_SUBMIT(xpath(".//button[@type='submit']")),
    LK(xpath("//a[@title='Личный кабинет']/../a[1]")),
    COUNTRY_INPUT(xpath("//input[@name='country']/../div")),
    COUNTRY(xpath("//input[@name='country']/../../div/div/button")),
    CITY_INPUT(xpath("//input[@name='city']/../div")),
    CITY(xpath("//input[@name='city']/../../div/div/button")),
    ENGLISH_LEVEL_INPUT(xpath("//input[@name='english_level']/../div")),
    ENGLISH_LEVEL(xpath("//input[@name='english_level']/../../div/div/button")),
    CHECKBOX_FULLDAY(xpath("//input[@title='Полный день']/..")),
    CHECKBOX_FLEX(xpath("//input[@title='Гибкий график']/..")),
    CHECKBOX_ONLINE(xpath("//input[@title='Удаленно']/..")),
    GENDER(xpath("//*[@id='id_gender']")),
    SAVE(xpath("//button[@title='Сохранить и продолжить']"));


    private By element;

    Locators(By element){
        this.element = element;
    }
}
