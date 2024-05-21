package sprint4.ya.scooter.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class MainPage {

    private static final String MAINPAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    private final WebDriver webDriver;



    private static final By[] questions = {
            By.id("accordion__heading-0"), By.id("accordion__heading-1"), By.id("accordion__heading-2"), By.id("accordion__heading-3"),
            By.id("accordion__heading-4"), By.id("accordion__heading-5"), By.id("accordion__heading-6"), By.id("accordion__heading-7")
    };

    private static final By[] answers = {
            By.xpath(".//p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']"), By.xpath(".//p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']"),
            By.xpath(".//p[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']"),
            By.xpath(".//p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']"), By.xpath(".//p[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']"),
            By.xpath(".//p[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']"),
            By.xpath(".//p[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']"), By.xpath(".//p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']")
    };

    private static final By orderButtonUpper = By.xpath(".//button[@class='Button_Button__ra12g']");
    private static final By orderButtonLower = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");




    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
// создал конструктор класса MainPage

public MainPage open() {
    webDriver.get(MAINPAGE_URL);
    return this;
}
public MainPage acceptCookie() {
    webDriver.findElement(By.id("rcc-confirm-button")).click();
    return this;
}

public MainPage clickOrderButton(By orderButton) {
        webDriver.findElement(orderButton).click();
        return this;
}



public static By getUpperOrderButton() {
       return  orderButtonUpper;

}
 public static By getLowerOrderButton() {
       return orderButtonLower;

 }

    public static By getQuestion(int number) {
        return questions[number];
    }

    public static By getAnswer(int number) {
        return answers[number];
    }




    public MainPage clickQuestion(By question) {
        webDriver.findElement(question).click();
        return this;
    }

    public boolean isAnswerShowed(By answer) {
        return webDriver.findElement(answer).isDisplayed();
    }


}

