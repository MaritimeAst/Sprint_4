package ru.yandex.praktikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    private final static String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private final static By COOKIE_BUTTON = By.id("rcc-confirm-button");
    private final static By QUESTIONS = By.xpath("//div[@class='Home_FourPart__1uthg']/div[1]");
    private final static By ACCORDION_HEADING0 = By.id("accordion__heading-0");
    private final static By ACCORDION_HEADING1 = By.id("accordion__heading-1");
    private final static By ACCORDION_HEADING2 = By.id("accordion__heading-2");
    private final static By ACCORDION_HEADING3 = By.id("accordion__heading-3");
    private final static By ACCORDION_HEADING4 = By.id("accordion__heading-4");
    private final static By ACCORDION_HEADING5 = By.id("accordion__heading-5");
    private final static By ACCORDION_HEADING6 = By.id("accordion__heading-6");
    private final static By ACCORDION_HEADING7 = By.id("accordion__heading-7");

    private final static By GET_TEXT_OF_ANSWER0 = By.xpath("//div[@id='accordion__panel-0']/p");
    private final static By GET_TEXT_OF_ANSWER1 = By.xpath("//div[@id='accordion__panel-1']/p");
    private final static By GET_TEXT_OF_ANSWER2 = By.xpath("//div[@id='accordion__panel-2']/p");
    private final static By GET_TEXT_OF_ANSWER3 = By.xpath("//div[@id='accordion__panel-3']/p");
    private final static By GET_TEXT_OF_ANSWER4 = By.xpath("//div[@id='accordion__panel-4']/p");
    private final static By GET_TEXT_OF_ANSWER5 = By.xpath("//div[@id='accordion__panel-5']/p");
    private final static By GET_TEXT_OF_ANSWER6 = By.xpath("//div[@id='accordion__panel-6']/p");
    private final static By GET_TEXT_OF_ANSWER7 = By.xpath("//div[@id='accordion__panel-7']/p");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(){
        driver.get(PAGE_URL);
    }

    public void clickCookieButton(){
        driver.findElement(COOKIE_BUTTON).click();
    }

    public void scrollToQuestions(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(QUESTIONS));

        // Поиск элемента с блоком аккордеона и скролл до него
        Object elementQuestions = driver.findElement(QUESTIONS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementQuestions);
    }
    public void checkAccordionElementClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(ACCORDION_HEADING0));
    }

    public void clickAccordionHeading0(){
        driver.findElement(ACCORDION_HEADING0).click();
    }

    public void clickAccordionHeading1(){
        driver.findElement(ACCORDION_HEADING1).click();
    }
    public void clickAccordionHeading2(){
        driver.findElement(ACCORDION_HEADING2).click();
    }
    public void clickAccordionHeading3(){
        driver.findElement(ACCORDION_HEADING3).click();
    }
    public void clickAccordionHeading4(){
        driver.findElement(ACCORDION_HEADING4).click();
    }
    public void clickAccordionHeading5(){
        driver.findElement(ACCORDION_HEADING5).click();
    }
    public void clickAccordionHeading6(){
        driver.findElement(ACCORDION_HEADING6).click();
    }
    public void clickAccordionHeading7(){
        driver.findElement(ACCORDION_HEADING7).click();
    }
    public String getTextOfAnswer0(){
        String answerQuestion = driver.findElement(GET_TEXT_OF_ANSWER0).getText();
        return answerQuestion;
    }
    public String getTextOfAnswer1(){
        String answerQuestion = driver.findElement(GET_TEXT_OF_ANSWER1).getText();
        return answerQuestion;
    }
    public String getTextOfAnswer2(){
        String answerQuestion = driver.findElement(GET_TEXT_OF_ANSWER2).getText();
        return answerQuestion;
    }
    public String getTextOfAnswer3(){
        String answerQuestion = driver.findElement(GET_TEXT_OF_ANSWER3).getText();
        return answerQuestion;
    }
    public String getTextOfAnswer4(){
        String answerQuestion = driver.findElement(GET_TEXT_OF_ANSWER4).getText();
        return answerQuestion;
    }
    public String getTextOfAnswer5(){
        String answerQuestion = driver.findElement(GET_TEXT_OF_ANSWER5).getText();
        return answerQuestion;
    }
    public String getTextOfAnswer6(){
        String answerQuestion = driver.findElement(GET_TEXT_OF_ANSWER6).getText();
        return answerQuestion;
    }
    public String getTextOfAnswer7(){
        String answerQuestion = driver.findElement(GET_TEXT_OF_ANSWER7).getText();
        return answerQuestion;
    }


}
