package ru.yandex.praktikum.model;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private final static String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private final static By ORDER_HEADER_BUTTON = By.cssSelector("div.Header_Nav__AGCXC > button.Button_Button__ra12g");
    private final static By ORDER_ROADMAP_BUTTON = By.cssSelector("div.Home_RoadMap__2tal_ > div.Home_FinishButton__1_cWm > button");
    private final static By NAME = By.xpath("//div[@class='Order_Form__17u6u']/div[1]/input");
    private final static By SURNAME = By.xpath("//div[@class='Order_Form__17u6u']/div[2]/input");
    private final static By ADDRESS = By.xpath("//div[@class='Order_Form__17u6u']/div[3]/input");
    private final static By PHONE = By.xpath("//div[@class='Order_Form__17u6u']/div[5]/input");
    private final static By STATION = By.xpath("//div[@class='Order_Form__17u6u']/div[4]");
    private final static By STATION_CHOICE = By.xpath("//div[@class='select-search__select']/ul/li/button/div[2]");
    private final static By STATION_CHOICE2 = By.xpath("//div[@class='select-search__select']/ul/li[5]/button/div[2]");

    private final static By BUTTON_NEXT = By.cssSelector("div.Order_NextButton__1_rCA > button.Button_Middle__1CSJM");

    private final static By DATE = By.xpath("//div[@class='Order_Form__17u6u']/div/div/div/input");
    private final static By RENTAL_PERIOD = By.xpath("//div[@class='Dropdown-control']");
    private final static By RENTAL_PERIOD_CHOICE = By.xpath("//div[@class='Dropdown-menu']/div[2]");
    private final static By RENTAL_PERIOD_CHOICE2 = By.xpath("//div[@class='Dropdown-menu']/div[4]");

    private final static By COLOR = By.xpath("//div[@class='Order_Checkboxes__3lWSI']/label[1]");
    private final static By COLOR2 = By.xpath("//div[@class='Order_Checkboxes__3lWSI']/label[2]");
    private final static By COMMENT = (By.xpath("//div[@class='Input_InputContainer__3NykH']/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']"));

    private final static By ORDER_FORM_BUTTON = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[2]");
    private final static By ORDER_CONFIRM_BUTTON = By.xpath("//div[@class='Order_Modal__YZ-d3']/div[2]/button[2]");
    private final static By ORDER_CREATED_SUCCESSFULLY = By.xpath("//*[contains(text(), 'Заказ оформлен')]");
    private final WebDriver driver;

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
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(ORDER_ROADMAP_BUTTON));
        // Поиск элемента с кнопкой заказа из секции с road_map и скролл до нее

        Object elementOrderButton = driver.findElement(ORDER_ROADMAP_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementOrderButton);
    }
    public void clickRoadMapOrderButton() {
        driver.findElement(ORDER_ROADMAP_BUTTON).click();
    }

    public void fillingOrderForm_set1() {
        driver.findElement(NAME).sendKeys("Марина");
        driver.findElement(SURNAME).sendKeys("Асташкина");
        driver.findElement(ADDRESS).sendKeys("Адрес");
        driver.findElement(PHONE).sendKeys("+78009874500");
        driver.findElement(STATION).click();
        driver.findElement(STATION_CHOICE).click();

        driver.findElement(BUTTON_NEXT).click();

        driver.findElement(DATE).click();
        driver.findElement(DATE).sendKeys("10.10.2022");
        driver.findElement(DATE).sendKeys(Keys.ENTER);

        driver.findElement(RENTAL_PERIOD).click();
        driver.findElement(RENTAL_PERIOD_CHOICE).click();
        driver.findElement(COLOR).click();
        driver.findElement(COMMENT).sendKeys("Позвоните пожалуйста, за полчаса до прибытия");
        driver.findElement(ORDER_FORM_BUTTON).click();
        driver.findElement(ORDER_CONFIRM_BUTTON).click();
    }

    public void fillingOrderForm_set2() {
        driver.findElement(NAME).sendKeys("Иван");
        driver.findElement(SURNAME).sendKeys("Иванов");
        driver.findElement(ADDRESS).sendKeys("ул. Ивановская д.1, кв.1");
        driver.findElement(PHONE).sendKeys("+78009874511");
        driver.findElement(STATION).click();
        driver.findElement(STATION_CHOICE2).click();

        driver.findElement(BUTTON_NEXT).click();

        driver.findElement(DATE).click();
        driver.findElement(DATE).sendKeys("01.12.2022");
        driver.findElement(DATE).sendKeys(Keys.ENTER);

        driver.findElement(RENTAL_PERIOD).click();
        driver.findElement(RENTAL_PERIOD_CHOICE2).click();
        driver.findElement(COLOR2).click();
        driver.findElement(COMMENT).sendKeys("Проверьте работоспособность самоката");
        driver.findElement(ORDER_FORM_BUTTON).click();
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

