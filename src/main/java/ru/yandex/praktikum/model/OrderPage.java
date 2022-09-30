package ru.yandex.praktikum.model;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class OrderPage {
    private final static String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    private final static By
            ORDER_HEADER_BUTTON = cssSelector("div.Header_Nav__AGCXC > button.Button_Button__ra12g"), //кнопка "Заказать" вверху страницы
            ORDER_ROADMAP_BUTTON = cssSelector("div.Home_RoadMap__2tal_ > div.Home_FinishButton__1_cWm > button"), //кнопка "Заказать" внизу страницы
            NAME = xpath("//div[@class='Order_Form__17u6u']/div[1]/input"), //форма заказа: поле ввода имени
            SURNAME = xpath("//div[@class='Order_Form__17u6u']/div[2]/input"), //форма заказа: поле ввода фамилии
            ADDRESS = xpath("//div[@class='Order_Form__17u6u']/div[3]/input"), //форма заказа: поле ввода адреса
            PHONE = xpath("//div[@class='Order_Form__17u6u']/div[5]/input"), //форма заказа: поле ввода телефона
            STATION = xpath("//div[@class='Order_Form__17u6u']/div[4]"), //форма заказа: поле выбра станции, раскрытие выпадающего списка
            STATION_CHOICE = xpath("//div[@class='select-search__select']/ul/li/button/div[2]"), //форма заказа: поле выбра станции, выбор элемента списка для тестового набора 1
            BUTTON_NEXT = cssSelector("div.Order_NextButton__1_rCA > button.Button_Middle__1CSJM"), //форма заказа: кнопка "Далее", для перехода на 2ую страницу формы
            DATE = xpath("//div[@class='Order_Form__17u6u']/div/div/div/input"),  //форма заказа: поле для ввода даты
            RENTAL_PERIOD = xpath("//div[@class='Dropdown-control']"), //форма заказа: поле выбора периода аренды, раскрытие выпадающего списка
            RENTAL_PERIOD_CHOICE = xpath("//div[@class='Dropdown-menu']/div[2]"), //форма заказа: поле выбра периода аренды, выбор элемента списка
            COLOR = xpath("//div[@class='Order_Checkboxes__3lWSI']/label[1]"), //форма заказа: выбор цвета для тестового набора 1
            COMMENT = xpath("//div[@class='Input_InputContainer__3NykH']/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']"),  //форма заказа: поле ввода комментария
            ORDER_FORM_BUTTON = xpath("//div[@class='Order_Buttons__1xGrp']/button[2]"), //форма заказа: кнопка "Заказать" в конце формы
            ORDER_CONFIRM_BUTTON = xpath("//div[@class='Order_Modal__YZ-d3']/div[2]/button[2]"), //модальное окно подтверждения заказа, кнопка "Да"
            ORDER_CREATED_SUCCESSFULLY = xpath("//*[contains(text(), 'Заказ оформлен')]"); //модальное окно: Заказ оформлен

    private final WebDriver driver;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // готовим нужный форматтер
    String date = LocalDate.now().plusDays(2).format(formatter); // получаем текущую дату, прибавляем к ней 2 дня и форматируем

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(PAGE_URL);
    }

    public void clickHeaderOrderButton() {
        driver.findElement(ORDER_HEADER_BUTTON).click();
    }

    public void checkOrderButtonRoadMapClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(ORDER_ROADMAP_BUTTON));
    }

    public void scrollToOrderButtonRoadMap() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(ORDER_ROADMAP_BUTTON));
        // Поиск элемента с кнопкой заказа из секции с road_map и скролл до нее

        Object elementOrderButton = driver.findElement(ORDER_ROADMAP_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementOrderButton);
    }

    public void clickRoadMapOrderButton() {
        driver.findElement(ORDER_ROADMAP_BUTTON).click();
    }

    public void name(String name){
        driver.findElement(NAME).sendKeys(name);
    }
    public void surname(String surname) {
        driver.findElement(SURNAME).sendKeys(surname);
    }
    public void address(String address) {
        driver.findElement(ADDRESS).sendKeys(address);
    }
    public void phone(String phone) {
        driver.findElement(PHONE).sendKeys(phone);
    }
    public void station() {
        driver.findElement(STATION).click();
    }
    public void stationChoice() {
        driver.findElement(STATION_CHOICE).click();
    }
    public void buttonNext() {
        driver.findElement(BUTTON_NEXT).click();
    }
    public void date() {
        driver.findElement(DATE).click();
        driver.findElement(DATE).sendKeys(date);
        driver.findElement(DATE).sendKeys(Keys.ENTER);

    }
    public void rentalPeriod() {
        driver.findElement(RENTAL_PERIOD).click();
        driver.findElement(RENTAL_PERIOD_CHOICE).click();
    }
    public void color() {
        driver.findElement(COLOR).click();
    }
    public void comment(String comment) {
        driver.findElement(COMMENT).sendKeys(comment);
    }
    public void orderFormButton() {
        driver.findElement(ORDER_FORM_BUTTON).click();
    }
    public void orderConfirmButton() {
        driver.findElement(ORDER_CONFIRM_BUTTON).click();
    }


    public boolean isOrderCreated() {
        try {
            return driver.findElement(ORDER_CREATED_SUCCESSFULLY).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

