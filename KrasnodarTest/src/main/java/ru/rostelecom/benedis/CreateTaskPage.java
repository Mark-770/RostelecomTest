package ru.rostelecom.benedis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateTaskPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CreateTaskPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    void open() {
        driver.get("https://www.mantisbt.org/bugs/my_view_page.php");
    }

   void navMenu() {
        wait.until(ExpectedConditions.titleContains("Обзор - MantisBT"));
        WebElement sidebar =  driver.findElement(By.xpath("//*[@id=\"sidebar\"]"));
        sidebar.findElement(By.xpath("//a/span[contains(.,'Создать задачу')]")).click();
    }

    void setValueSelect()  {

        Select category =  new Select (driver.findElement(By.xpath("//select[@id='category_id']")));
        category.selectByVisibleText("api rest");
    }
    void  setTextTheme() {
        WebElement inputTheme =  driver.findElement(By.xpath("//input[@id='summary']"));
        inputTheme.sendKeys("Test Theme");
    }
    void  setDescription() {
        WebElement inputDescription =  driver.findElement(By.xpath("//textarea[@id='description']"));
        inputDescription.sendKeys("Очень длинный текст Очень длинный текстОчень длинный текстОчень длинный текст");
    }

    void clickButtonCreate() {
        WebElement createButton =  driver.findElement(By.xpath("//input[@value='Создать задачу']"));
        createButton.click();
    }
      String successful() {

         System.out.println(driver.findElement(By.xpath("//*[@id=\"main-container\"]//p")).getText());
          String textSuccessful = driver.findElement(By.xpath("//*[@id=\"main-container\"]//p")).getText();
        return textSuccessful;
    }
    //*[@id="main-container"]/div[2]/div[2]/div/div/div/div[2]/p




}
