package ru.rostelecom.benedis;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main {
//    private AuthorizationPage auth;
//    private CreateTaskPage create;
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void openSite() {
        System.setProperty("webdriver.chrome.driver", "C:/Java/KrasnodarTest/src/main/resources/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
    }


    @Test
    public void testAuthorization() {
        String expectedTitle = "Обзор - MantisBT";
        AuthorizationPage auth = new AuthorizationPage(driver);
        auth.open();
        auth.setLogin();
        auth.pressButtonSubmitLogin();
        auth.setPassword();
        auth.pressButtonSubmitLogin();
        auth.waitTitle(expectedTitle);
        String actualText = auth.getLinkUserProfile().getText();
        String expectedText = "testPerson ( testPerson )";
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void testCreateTask() {
        CreateTaskPage create = new CreateTaskPage(driver);

        create.navMenu();
        create.setValueSelect();
        create.setTextTheme();
        create.setDescription();
        create.clickButtonCreate();
        String actualTextCreate = create.successful();
        String expectedTextCreate = "Действие успешно выполнено.";
        Assert.assertEquals(actualTextCreate, expectedTextCreate);

    }

    @Test
    public void testCheckTaskPage() {
        CheckTaskPage check = new CheckTaskPage(driver);

        check.open();

        String actualTextTheme = check.elementLastThem();
        String expectedTextThem = "Test Theme";
        Assert.assertEquals(actualTextTheme, expectedTextThem);

    }

    @AfterClass
    public void closeSite() {
        driver.quit();
    }

}
