package ru.yandex.praktikum.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;

    // Локатор для заголовков раскрывающегося блока
    private final By accordionHeaders = By.className("accordion__button");
    // Абзац в раскрывающемся блоке
    private final By accordionItems = By.xpath(".//div[@class='accordion__panel']/p");
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

    //Метод для ожидания загрузки элемента аккордеона
    public void waitForLoadItem(int index) {
        new WebDriverWait(this.driver, 3)
                .until(ExpectedConditions.visibilityOf(this.driver.findElements(this.accordionItems).get(index)));
    }

    // Метод для нажатия на кнопку "Принять куки"
    public void clickOnCookieAcceptButton() {
        this.driver.findElement(this.cookieAcceptButton).click();
    }

    //Метод для получения текста на заголовке блока
    public String getAccordionHeaderText(int index) {
        return this.driver.findElements(this.accordionHeaders).get(index).getText();
    }

    //Методя для получения текста из раскрывающегося блока
    public String getAccordionItemText(int index) {
        return this.driver.findElements(this.accordionItems).get(index).getText();
    }

    //Метод для нажатия на заголовок блока

    public void clickAccordionHeader(int index) {
        this.driver.findElements(this.accordionHeaders).get(index).click();
    }

    //Метод для проверки раскрытия блока
    public boolean isAccordionItemDisplayed(int index) {
        return this.driver.findElements(this.accordionItems).get(index).isDisplayed();
    }

    public void clickOrderButtonBody() {
        this.driver.findElement(this.orderButtonBody).click();
    }

    public void clickOrderButtonHeader() {
        this.driver.findElement(this.orderButtonHeader).click();
    }
}

