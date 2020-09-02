package ru.rostelecom.benedis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckTaskPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CheckTaskPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    void open() {
        driver.get("https://www.mantisbt.org/bugs/my_view_page.php");
    }


    String elementLastThem() {
        String lastThem = driver.findElement(By.xpath("//*[@id=\"reported\"]//span[1]/a[1]")).getText();
        return lastThem;
    }


}
