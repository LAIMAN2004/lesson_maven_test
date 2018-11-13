package org.itstep.qa.lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class lessontest {
    WebDriver driver;

    @BeforeClass
    public void initWebdriver() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver243.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--kiosk");
        driver = new ChromeDriver(options);
    }



    @AfterMethod
    public void closeBrowser() {
 //       driver.manage().deleteAllCookies();
   //     driver.quit();
    }

    @Test
    public void sendMessageTest() {
            driver.get("http://ya.ru");

        //проверка открытия страницы
        WebElement pageHeader =
                driver.findElement(By.xpath("//*[@id=\"text\"]"));
        Assert.assertTrue(pageHeader.isDisplayed(), "Не найден заголовок страницы");
        //находим и заполняем поле Погода в гомеле
        WebElement field =
                driver.findElement(By.xpath("//*[@id=\"text\"]"));
        field.sendKeys("Погода в Гомеле" + Keys.ENTER);
////////////////////////////////////////
    }
        @Test
        public void sendMessageTest2() {
        driver.get("http://google.by");

        WebElement pageHeader2 =
                driver.findElement(By.xpath("//*[@id=\"lst-ib\"]"));
        Assert.assertTrue(pageHeader2.isDisplayed(), "Не найден заголовок страницы");
        //находим и заполняем поле Погода в гомеле
        WebElement field2 =
                driver.findElement(By.xpath("//*[@id=\"lst-ib\"]"));
        field2.sendKeys("Погода в Гомеле"+ Keys.ENTER);
/*        WebElement button =
                driver.findElement(By.
                        xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]"));
        button.click();*/

    }
}
