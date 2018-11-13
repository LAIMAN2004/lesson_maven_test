package org.itstep.qa.lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class lessontest2 {
    WebDriver driver;

    @BeforeClass
    public void initWebdriver() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver243.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--kiosk");
        driver = new ChromeDriver(options);
    }

    @BeforeMethod
    public void startUp() {
        driver.get("https://dev.by/registration");
    }

    @AfterMethod
    public void closeBrowser() {
    }

    @Test
    public void formDisplayTest() {
        //1 проверка отображения формы полей
        WebElement pageHeader =
                driver.findElement(By.xpath("//*[@id=\"user_username\"]"));
        Assert.assertTrue(pageHeader.isDisplayed(), "Не найдено поле для ввода");
        WebElement pageHeader2 =
                driver.findElement(By.xpath("//*[@id=\"user_email\"]"));
        Assert.assertTrue(pageHeader2.isDisplayed(), "Не найдено поле для ввода");
        WebElement pageHeader3 =
                driver.findElement(By.xpath("//*[@id=\"user_password\"]"));
        Assert.assertTrue(pageHeader3.isDisplayed(), "Не найдено поле для ввода");
        WebElement pageHeader4 =
                driver.findElement(By.xpath("//*[@id=\"user_password_confirmation\"]"));
        Assert.assertTrue(pageHeader4.isDisplayed(), "Не найдено поле для ввода");
        WebElement pageHeader5 =
                driver.findElement(By.xpath("//*[@id=\"user_first_name\"]"));
        Assert.assertTrue(pageHeader5.isDisplayed(), "Не найдено поле для ввода");
        WebElement pageHeader6 =
                driver.findElement(By.xpath("//*[@id=\"user_last_name\"]"));
        Assert.assertTrue(pageHeader6.isDisplayed(), "Не найдено поле для ввода");
        WebElement pageHeader7 =
                driver.findElement(By.xpath("//*[@id=\"user_current_position\"]"));
        Assert.assertTrue(pageHeader7.isDisplayed(), "Не найдено поле для ввода");
        WebElement pageHeader8 =
                driver.findElement(By.xpath("/html/body"));
        Assert.assertTrue(pageHeader8.isDisplayed(), "Не найдена отметка о согласии");
        WebElement pageHeader9 =
                driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[10]/div/div/input[5]"));
        Assert.assertTrue(pageHeader9.isDisplayed(), "Не найдена кнопка завершения регистрации");
    }

    @Test
    public void sendPasswordTest() {
        //2.1 проверка правильноести ввода пароля
        WebElement field =
                driver.findElement(By.xpath("//*[@id=\"user_password\"]"));
        field.sendKeys("12345" + Keys.ENTER);
        WebElement field2 =
                driver.findElement(By.cssSelector(".formErrorContent"));
        Assert.assertTrue(field2.isDisplayed(), "Не найдено сообщение о требованиях к паролю");
        String controlValue = "* Минимум 6 символа(ов)";
        Assert.assertEquals(field2.getText(), controlValue, "Текст в кнопке не " +
                "сответствует = " + controlValue);
    }

    @Test
    public void firstPasswordTest() {
        //2.2 проверка правильноести ввода подтверждения пароля
        WebElement field =
                driver.findElement(By.xpath("//*[@id=\"user_password\"]"));
        field.sendKeys("1234567" + Keys.ENTER);
        WebElement field2 =
                driver.findElement(By.xpath("//*[@id=\"user_password_confirmation\"]"));
        field2.sendKeys("1234576" + Keys.ENTER);
        WebElement field3 =
                driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[5]/div/div/div[1]/div[1]"));
        Assert.assertTrue(field3.isDisplayed(), "Не найдено сообщение о разных паролях");
        String controlValue = "* Поля не совпадают";
        Assert.assertEquals(field3.getText(), controlValue, "Текст в кнопке не " +
                "сответствует = " + controlValue);
    }

    @Test
    public void emailTest() {
        //3 проверка правильноести ввода email
        WebElement field =
                driver.findElement(By.xpath("//*[@id=\"user_email\"]"));
        field.sendKeys("laiman2004gmail.com" + Keys.ENTER);
        WebElement field2 =
                driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[4]/div/div/div/div[1]"));
        Assert.assertTrue(field2.isDisplayed(), "Не найдено сообщение об ощибке");
        String controlValue = "* Неверный формат email";
        Assert.assertEquals(field2.getText(), controlValue, "Текст не " +
                "сответствует = " + controlValue);
    }

    @Test
    public void userNameTest() {
        //4 проверка длинны ввода имени пользователя
        WebElement field =
                driver.findElement(By.xpath("//*[@id=\"user_username\"]"));
        field.sendKeys("laiman78910111213" + Keys.ENTER); // 17 simbols
        WebElement field2 =
                driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[3]/div/div/div/div[1]"));
        Assert.assertTrue(field2.isDisplayed(), "Не найдено сообщение об ощибке");
        String controlValue = "* Максимум 16 символа(ов)";
        Assert.assertEquals(field2.getText(), controlValue, "Текст не " +
                "сответствует = " + controlValue);
    }

    @Test
    public void nullFormDisplayTest() {
        // Проверка на пустые поля
        WebElement button =
                driver.findElement(By.
                        xpath("//*[@id=\"new_user\"]/div[10]/div/div/input[5]"));
        button.click();
        WebElement field2 =
                driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[3]/div/div/div/div[1]"));
        Assert.assertTrue(field2.isDisplayed(), "Не найдено сообщение об ощибке");
        String controlValue = "* Необходимо заполнить\n* Минимум 2 символа(ов)\n* Запрещены специальные символы";
        Assert.assertEquals(field2.getText(), controlValue, "Текст не " +
                "сответствует = " + controlValue);
        WebElement field3 =
                driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[4]/div/div/div/div[1]"));
        Assert.assertTrue(field3.isDisplayed(), "Не найдено сообщение об ощибке");
        String controlValue3 = "* Необходимо заполнить\n* Неверный формат email";
        Assert.assertEquals(field3.getText(), controlValue3, "Текст не " +
                "сответствует = " + controlValue3);
        WebElement field4 =
                driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[5]/div/div/div[1]/div[1]"));
        Assert.assertTrue(field4.isDisplayed(), "Не найдено сообщение об ощибке");
        String controlValue4 = "* Необходимо заполнить\n* Минимум 6 символа(ов)";
        Assert.assertEquals(field4.getText(), controlValue4, "Текст не " +
                "сответствует = " + controlValue4);
        WebElement field5 =
                driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[5]/div/div/div[2]/div[1]"));
        Assert.assertTrue(field5.isDisplayed(), "Не найдено сообщение об ощибке");
        String controlValue5 = "* Необходимо заполнить";
        Assert.assertEquals(field5.getText(), controlValue5, "Текст не " +
                "сответствует = " + controlValue5);
        WebElement field6 =
                driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[9]/div/div/span/div/div[1]"));
        Assert.assertTrue(field6.isDisplayed(), "Не найдено сообщение об ощибке");
        String controlValue6 = "* Необходимо отметить";
        Assert.assertEquals(field6.getText(), controlValue6, "Текст не " +
                "сответствует = " + controlValue6);
    }
}

