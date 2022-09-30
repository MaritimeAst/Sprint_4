import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.model.OrderPage;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest {

    //WebDriver driver = new FirefoxDriver();
    WebDriver driver = new ChromeDriver();

    private final String
            name,
            surname,
            address,
            phone,
            comment;

    public OrderTest(String name, String surname, String address, String phone, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.comment = comment;
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Марина", "Асташкина", "ул.Новая д.1", "+78009008787", "Позвоните пожалуйста за полчаса до прибыия"},
                {"Иван", "Иванов", "ул.Старая д.99", "+78004004444", "Проверьте пожалуйста работоспособность самоката"},
        };
    }

    @Test
    public void checkOrderFromHeader_success() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        OrderPage orderPage = new OrderPage(driver);
        orderPage.open();
        orderPage.clickHeaderOrderButton();
        orderPage.name(name);
        orderPage.surname(surname);
        orderPage.address(address);
        orderPage.phone(phone);
        orderPage.station();
        orderPage.stationChoice();
        orderPage.buttonNext();
        orderPage.date();
        orderPage.rentalPeriod();
        orderPage.color();
        orderPage.comment(comment);
        orderPage.orderFormButton();
        orderPage.orderConfirmButton();

        assertTrue("Окно \"Заказ оформлен\" не появляется", orderPage.isOrderCreated());
    }

    @Test
    public void checkOrderFromRoadMapSection_success() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        OrderPage orderPage = new OrderPage(driver);
        orderPage.open();
        orderPage.scrollToOrderButtonRoadMap();
        orderPage.checkOrderButtonRoadMapClickable();
        orderPage.clickRoadMapOrderButton();
        orderPage.name(name);
        orderPage.surname(surname);
        orderPage.address(address);
        orderPage.phone(phone);
        orderPage.station();
        orderPage.stationChoice();
        orderPage.buttonNext();
        orderPage.date();
        orderPage.rentalPeriod();
        orderPage.color();
        orderPage.comment(comment);
        orderPage.orderFormButton();
        orderPage.orderConfirmButton();

        assertTrue("Окно \"Заказ оформлен\" не появляется", orderPage.isOrderCreated());
    }
    
    @After
    public void teardown() {
        driver.quit();
    }
}
