import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.model.OrderPage;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class OrderTest {

    //WebDriver driver = new FirefoxDriver();
    WebDriver driver = new ChromeDriver();

    @Test
    public void checkOrderFromHeader_success(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        OrderPage orderPage = new OrderPage(driver);
        orderPage.open();
        orderPage.checkOrderButtonRoadMapClickable();
        orderPage.clickHeaderOrderButton();
        orderPage.fillingOrderForm_set1();

        assertTrue("Окно \"Заказ оформлен\" не появляется", orderPage.isOrderCreated());
    }

    @Test
    public void checkOrderFromRoadMapSection_success(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        OrderPage orderPage = new OrderPage(driver);
        orderPage.open();
        orderPage.scrollToOrderButtonRoadMap();
        orderPage.checkOrderButtonRoadMapClickable();
        orderPage.clickRoadMapOrderButton();
        orderPage.fillingOrderForm_set1();

        assertTrue("Окно \"Заказ оформлен\" не появляется", orderPage.isOrderCreated());
    }

    @Test
    public void checkOrderFromHeader_set2_success(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        OrderPage orderPage = new OrderPage(driver);
        orderPage.open();
        orderPage.checkOrderButtonRoadMapClickable();
        orderPage.clickHeaderOrderButton();
        orderPage.fillingOrderForm_set2();

        assertTrue("Окно \"Заказ оформлен\" не появляется", orderPage.isOrderCreated());
    }

    @Test
    public void checkOrderFromRoadMapSection_set2_success(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        OrderPage orderPage = new OrderPage(driver);
        orderPage.open();
        orderPage.scrollToOrderButtonRoadMap();
        orderPage.checkOrderButtonRoadMapClickable();
        orderPage.clickRoadMapOrderButton();
        orderPage.fillingOrderForm_set2();

        assertTrue("Окно \"Заказ оформлен\" не появляется", orderPage.isOrderCreated());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
