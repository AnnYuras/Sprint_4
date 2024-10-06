package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;

    //URL тестируемой страницы
    private final String mainPageUrl = "https://qa-scooter.praktikum-services.ru";

    // Локатор для заголовков раскрывающегося блока
    private final By headerButton = By.className("accordion__button");

    // Абзац в раскрывающемся блоке
    private final By answerText = By.xpath(".//div[@class='accordion__panel']/p");

    //Кнопка "Принять куки"
    private final By cookieAcceptButton = By.id("rcc-confirm-button");

    // Локатор кнопки "Заказать" в шапке страницы
    private final By orderButtonHeader = By.xpath(".//button[@class='Button_Button__ra12g' and text()='Заказать']");

    // Локатор кнопки "Заказать" в теле страницы
    private final By orderButtonBody = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");


    //Конструктор класса MainPage
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для открытия главной страницы
    public void openMainPage() {
        driver.get(mainPageUrl);
    }


    //Метод для ожидания загрузки элемента
    public void waitForLoadItem(int index) {
        new WebDriverWait(this.driver, 3)
                .until(ExpectedConditions.visibilityOf(this.driver.findElements(this.answerText).get(index)));
    }

    // Метод для нажатия на кнопку "Принять куки"
    public void clickOnCookieAcceptButton() {
        this.driver.findElement(this.cookieAcceptButton).click();
    }

    //Метод для получения текста на заголовке блока
    public String getHeaderButtonText(int index) {
        return this.driver.findElements(this.headerButton).get(index).getText();
    }

    //Методя для получения текста из раскрывающегося блока
    public String getAnswerText(int index) {
        return this.driver.findElements(this.answerText).get(index).getText();
    }

    //Метод для нажатия на заголовок блока

    public void clickHeaderButton(int index) {
        this.driver.findElements(this.headerButton).get(index).click();
    }

    //Метод для проверки раскрытия блока
    public boolean isAnswerTextDisplayed(int index) {
        return this.driver.findElements(this.answerText).get(index).isDisplayed();
    }

    public void clickOrderButtonBody() {
        this.driver.findElement(this.orderButtonBody).click();
    }

    public void clickOrderButtonHeader() {
        this.driver.findElement(this.orderButtonHeader).click();
    }
}



