import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagesObjects.Authorization;
import pagesObjects.Locators;
import testsPreconditionsInit.TestsPreconditionsInit;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.*;

public class TestsHomeWorkOtus6 extends TestsPreconditionsInit {


    @Test
    public void testSavePersonalPage() throws InterruptedException {
        //Открыть https://otus.ru
        homePage.open();
        //Авторизоваться на сайте
        auth.authorization(propLogin, propPassword);
        //В разделе "О себе" заполнить все поля "Личные данные"
        act.moveCursor(xpath("//div[@class='header2-menu__icon']/../div[3]"));
        act.click(xpath("//a[@title='Личный кабинет']/../a[1]"));
        String[] fName = {"Даниил", "Максим", "Владислав", "Никита", "Артем", "Иван", "Кирилл", "Егор", "Илья", "Андрей"};
        String[] lName = {"Иванов", "Смирнов", "Кузнецов", "Попов", "Васильев", "Петров", "Соколов", "Лазарев", "Медведев", "Ершов"};
        int nfName = random.nextInt(fName.length-1);
        int nlName = random.nextInt(lName.length-1);
        firstName = fName[nfName];
        lastName = lName[nlName];
        firstNameLatin = faker.name().firstName();
        lastNameLatin = faker.name().lastName();
        birth = rand.genBirth();
        act.textInput(id("id_fname"),firstName);
        act.textInput(id("id_lname"),lastName);
        act.textInput(id("id_fname_latin"),firstNameLatin);
        act.textInput(id("id_lname_latin"),lastNameLatin);
        act.textInput(id("id_blog_name"),blogName);
        act.textInput(name("date_of_birth"),birth);

        act.click(xpath("//input[@name='country']/../div"));
        List<WebElement> countrys = driver.findElements(By.xpath("//input[@name='country']/../../div/div/button"));
        int nCountry = countrys.size()-2;
        int randomCountry = random.nextInt(nCountry)+ 2;
        act.click(xpath("//input[@name='country']/../../div/div/button[" + randomCountry + "]"));
        country = driver.findElement(xpath("//input[@name='country']/../div")).getText();
        act.waitElement(xpath("//input[@name='city']/../div"));

        act.click(xpath("//input[@name='city']/../div"));
        List<WebElement> citys = driver.findElements(By.xpath("//input[@name='city']/../../div/div/button"));
        int nCity = citys.size()-2;
        if (nCity > 0) randomCity = random.nextInt(nCity)+2;
        else randomCity = 2;
        act.click(xpath("//input[@name='city']/../../div/div/button[" + randomCity + "]"));
        city = driver.findElement(xpath("//input[@name='city']/../div")).getText();
        act.waitElement(xpath("//input[@name='english_level']/../div"));

        act.click(xpath("//input[@name='english_level']/../div"));
        List<WebElement> englishLevels  = driver.findElements(By.xpath("//input[@name='english_level']/../../div/div/button"));
        int nEnglishLevels = englishLevels.size()-2;
        int randomEnglishLevels = random.nextInt(nEnglishLevels)+2;
        act.click(xpath("//input[@name='english_level']/../../div/div/button[" + randomEnglishLevels + "]"));
        englishLevel = driver.findElement(xpath("//input[@name='english_level']/../div")).getText();

        Thread.sleep(500);
        int radButton = random.nextInt(1)+1;
        act.click(xpath("//input[@name='ready_to_relocate']/../../label[" + radButton + "]"));

        Thread.sleep(500);
        boolean checkbox1 = random.nextBoolean();
        if (checkbox1) act.click(xpath("//input[@title='Полный день']/.."));

        Thread.sleep(500);
        boolean checkbox2 = random.nextBoolean();
        if (checkbox2) act.click(xpath("//input[@title='Гибкий график']/.."));

        Thread.sleep(500);
        boolean checkbox3 = random.nextBoolean();
        if (checkbox3) act.click(xpath("//input[@title='Удаленно']/.."));
        //...и добавить не менее двух контактов
        Thread.sleep(500);
        act.click(xpath("//input[@name='contact-0-service']/.."));
        act.click(xpath("//button[@title='"+ communicationType1 +"']"));
        act.textInput(id("id_contact-0-value"),communicationAddress1);

        act.click(xpath("//button[text()='Добавить']"));
        act.click(xpath("//input[@name='contact-1-service']/.."));
        Thread.sleep(500);
        act.click(xpath("//input[@name='contact-1-id']/..//button[@title='"+ communicationType2 +"']"));
        act.textInput(id("id_contact-1-value"),communicationAddress2);

        act.click(xpath("//*[@id='id_gender']"));

        Thread.sleep(500);
        boolean checkbox4 = random.nextBoolean();
        if (checkbox4) {
            act.click(xpath("//*[@id='id_gender']/option[2]"));
            gender = driver.findElement(xpath("//*[@id='id_gender']/option[2]")).getText();
        }else {
            act.click(xpath("//*[@id='id_gender']/option[3]"));
            gender = driver.findElement(xpath("//*[@id='id_gender']/option[3]")).getText();
        }
        act.textInput(id("id_company"),company);
        act.textInput(id("id_work"),work);
        //Нажать сохранить
        act.click(xpath("//button[@title='Сохранить и продолжить']"));
        driver.quit();

        //Открыть https://otus.ru в "чистом браузере"
        webDriverStart();
        homePage.open();
        //Войти в личный кабинет
        auth.authorization(propLogin, propPassword);
        act.click(xpath("//div[@class='header2-menu__icon']/../div[3]"));
        act.click(xpath("//a[@title='Личный кабинет']/../a[1]"));
        //Проверить, что в разделе "О себе" отображаются указанные ранее данные
        check.input(id("id_fname"),firstName);
        check.input(id("id_lname"),lastName);
        check.input(id("id_fname_latin"),firstNameLatin);
        check.input(id("id_lname_latin"),lastNameLatin);
        check.input(id("id_blog_name"),blogName);
        check.input(name("date_of_birth"),birth);
        check.dropBox(xpath("//input[@name='country']/../div"),country);
        check.dropBox(xpath("//input[@name='city']/../div"),city);
        check.dropBox(xpath("//input[@name='english_level']/../div"),englishLevel);
        check.dropBox(xpath("//input[@name='contact-0-service']/.."),communicationType1);
        check.input(id("id_contact-0-value"),communicationAddress1);
        check.dropBox(xpath("//input[@name='contact-1-service']/.."),communicationType2);
        check.input(id("id_contact-1-value"),communicationAddress2);
        check.input(id("id_company"),company);
        check.input(id("id_work"),work);
    }

}