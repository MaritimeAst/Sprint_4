import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.model.MainPage;

import java.time.Duration;

import static junit.framework.TestCase.assertEquals;

public class QuestionsTest {

    WebDriver driver = new FirefoxDriver();
    //WebDriver driver = new ChromeDriver();

    @Test
    public void checkAnswer1_success(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scrollToQuestions();
        mainPage.checkAccordionElementClickable();
        mainPage.clickAccordionHeading0();

        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", mainPage.getTextOfAnswer0());
    }

    @Test
    public void checkAnswer2_success(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scrollToQuestions();
        mainPage.checkAccordionElementClickable();
        mainPage.clickAccordionHeading1();
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", mainPage.getTextOfAnswer1());
    }

    @Test
    public void checkAnswer3_success(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scrollToQuestions();
        mainPage.checkAccordionElementClickable();
        mainPage.clickAccordionHeading2();
        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", mainPage.getTextOfAnswer2());
    }

    @Test
    public void checkAnswer4_success(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scrollToQuestions();
        mainPage.checkAccordionElementClickable();
        mainPage.clickAccordionHeading3();
        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", mainPage.getTextOfAnswer3());
    }

    @Test
    public void checkAnswer5_success(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scrollToQuestions();
        mainPage.checkAccordionElementClickable();
        mainPage.clickAccordionHeading4();
        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", mainPage.getTextOfAnswer4());
    }

    @Test
    public void checkAnswer6_success(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scrollToQuestions();
        mainPage.checkAccordionElementClickable();
        mainPage.clickAccordionHeading5();
        assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", mainPage.getTextOfAnswer5());
    }

    @Test
    public void checkAnswer7_success(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scrollToQuestions();
        mainPage.checkAccordionElementClickable();
        mainPage.clickAccordionHeading6();
        assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", mainPage.getTextOfAnswer6());
    }

    @Test
    public void checkAnswer8_success(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scrollToQuestions();
        mainPage.checkAccordionElementClickable();
        mainPage.clickAccordionHeading7();
        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", mainPage.getTextOfAnswer7());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}