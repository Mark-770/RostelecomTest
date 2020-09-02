package ru.rostelecom.benedis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    AuthorizationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }


    void open() {
        driver.get("https://www.mantisbt.org/bugs/login_page.php");
    }

    void setLogin() {
        WebElement login = driver.findElement(By.xpath("//input[@id='username']"));
        login.clear();
        login.sendKeys("testPerson");
    }

    void pressButtonSubmitLogin() {
        WebElement buttonSubmitLogin = driver.findElement(By.xpath("//*[@id=\"login-form\"]//input[@value=\"Войти\"]"));
        buttonSubmitLogin.click();
    }

    void setPassword() {
        WebElement inputPassword = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        inputPassword.clear();
        inputPassword.sendKeys("1234567890");
    }

    void waitTitle(String title) {
        wait.until(ExpectedConditions.titleContains(title));
    }

    WebElement getLinkUserProfile() {
        return driver.findElement(By.xpath("//*[@id=\"breadcrumbs\"]//a"));
    }


}
