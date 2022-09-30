package ru.yandex.praktikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class MainPage {
    private final static String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    //кнопка закрытия поп-ап куки
    private final static By COOKIE_BUTTON = id("rcc-confirm-button"),
    QUESTIONS = xpath("//div[@class='Home_FourPart__1uthg']/div[1]"), //секция "Вопросы о важном"
    ACCORDION_HEADING0 = id("accordion__heading-0"), //аккордеон: первый вопрос
    ACCORDION_HEADING1 = id("accordion__heading-1"), //аккордеон: второй вопрос
    ACCORDION_HEADING2 = id("accordion__heading-2"), //аккордеон: третий вопрос
    ACCORDION_HEADING3 = id("accordion__heading-3"), //аккордеон: четвертый вопрос
    ACCORDION_HEADING4 = id("accordion__heading-4"), //аккордеон: пятый вопрос
    ACCORDION_HEADING5 = id("accordion__heading-5"), //аккордеон: шестой вопрос
    ACCORDION_HEADING6 = id("accordion__heading-6"), //аккордеон: седьмой вопрос
    ACCORDION_HEADING7 = id("accordion__heading-7"),//аккордеон: восьмой вопрос


    GET_TEXT_OF_ANSWER0 = xpath("//div[@id='accordion__panel-0']/p"), //аккордеон: первый ответ
    GET_TEXT_OF_ANSWER1 = xpath("//div[@id='accordion__panel-1']/p"), //аккордеон: второй ответ
    GET_TEXT_OF_ANSWER2 = xpath("//div[@id='accordion__panel-2']/p"), //аккордеон: третий ответ
    GET_TEXT_OF_ANSWER3 = xpath("//div[@id='accordion__panel-3']/p"), //аккордеон: четвертый ответ
    GET_TEXT_OF_ANSWER4 = xpath("//div[@id='accordion__panel-4']/p"), //аккордеон: пятый ответ
    GET_TEXT_OF_ANSWER5 = xpath("//div[@id='accordion__panel-5']/p"), //аккордеон: шестой ответ
    GET_TEXT_OF_ANSWER6 = xpath("//div[@id='accordion__panel-6']/p"), //аккордеон: седьмой ответ
    GET_TEXT_OF_ANSWER7 = xpath("//div[@id='accordion__panel-7']/p");//аккордеон: восьмой ответ

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(PAGE_URL);
    }

    public void clickCookieButton() {
        driver.findElement(COOKIE_BUTTON).click();
    }

    public void scrollToQuestions() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(QUESTIONS));

        // Поиск элемента с блоком аккордеона и скролл до него
        Object elementQuestions = driver.findElement(QUESTIONS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementQuestions);
    }

    public String getTextOfAnswer0() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(ACCORDION_HEADING0));
        driver.findElement(ACCORDION_HEADING0).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(GET_TEXT_OF_ANSWER0));
        String answerQuestion = driver.findElement(GET_TEXT_OF_ANSWER0).getText();

        return answerQuestion;
    }

    public String getTextOfAnswer1() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(ACCORDION_HEADING1));
        driver.findElement(ACCORDION_HEADING1).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(GET_TEXT_OF_ANSWER1));
        String answerQuestion = driver.findElement(GET_TEXT_OF_ANSWER1).getText();

        return answerQuestion;
    }

    public String getTextOfAnswer2() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(ACCORDION_HEADING2));
        driver.findElement(ACCORDION_HEADING2).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(GET_TEXT_OF_ANSWER2));
        String answerQuestion = driver.findElement(GET_TEXT_OF_ANSWER2).getText();

        return answerQuestion;
    }

    public String getTextOfAnswer3() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(ACCORDION_HEADING3));
        driver.findElement(ACCORDION_HEADING3).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(GET_TEXT_OF_ANSWER3));
        String answerQuestion = driver.findElement(GET_TEXT_OF_ANSWER3).getText();

        return answerQuestion;
    }

    public String getTextOfAnswer4() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(ACCORDION_HEADING4));
        driver.findElement(ACCORDION_HEADING4).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(GET_TEXT_OF_ANSWER4));
        String answerQuestion = driver.findElement(GET_TEXT_OF_ANSWER4).getText();

        return answerQuestion;
    }

    public String getTextOfAnswer5() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(ACCORDION_HEADING5));
        driver.findElement(ACCORDION_HEADING5).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(GET_TEXT_OF_ANSWER5));
        String answerQuestion = driver.findElement(GET_TEXT_OF_ANSWER5).getText();

        return answerQuestion;
    }

    public String getTextOfAnswer6() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(ACCORDION_HEADING6));
        driver.findElement(ACCORDION_HEADING6).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(GET_TEXT_OF_ANSWER6));
        String answerQuestion = driver.findElement(GET_TEXT_OF_ANSWER6).getText();

        return answerQuestion;
    }

    public String getTextOfAnswer7() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(ACCORDION_HEADING7));
        driver.findElement(ACCORDION_HEADING7).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(GET_TEXT_OF_ANSWER7));
        String answerQuestion = driver.findElement(GET_TEXT_OF_ANSWER7).getText();

        return answerQuestion;
    }
}
