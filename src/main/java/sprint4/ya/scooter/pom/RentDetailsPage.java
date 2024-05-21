package sprint4.ya.scooter.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentDetailsPage {
    private final WebDriver webDriver;

    private final By arrivalDateField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    private final By rentPeriodField = By.xpath(".//div[text() = '* Срок аренды']");
    private final By messageForСarrierField = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");

    private final By blackScooterColorButton = By.xpath(".//label[@for='black' and@class='Checkbox_Label__3wxSf']");
    private final By greyScooterColorButton = By.xpath(".//label[@for='grey' and@class='Checkbox_Label__3wxSf']");

    private final By arrivalDateNextMonthButton = By.xpath(".//button[@aria-label='Next Month']");

    private final By arrivalDate31ofMay2024 = By.xpath(".//div[@aria-label='Choose пятница, 31-е мая 2024 г.']");
    private final By arrivalDate1ofJuly2024 = By.xpath(".//div[@aria-label='Choose понедельник, 1-е июля 2024 г.']");

    private final By rentPeriodOneDay = By.xpath(".//div[text()='сутки']");
    private final By rentPeriodSevenDays = By.xpath(".//div[text()='семеро суток']");

    private final By finishOrderButton  = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    private final  By confirmOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    private final By successfulOrderNotification = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");
    public RentDetailsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public RentDetailsPage chooseArrivalDate(String date) {
        webDriver.findElement(arrivalDateField).click();
        if (date == "31 мая") {
            webDriver.findElement(arrivalDate31ofMay2024).click();
        }
else if (date == "1 июля") {
    webDriver.findElement(arrivalDateNextMonthButton).click();
            webDriver.findElement(arrivalDateNextMonthButton).click();
    webDriver.findElement(arrivalDate1ofJuly2024).click();
        }
return this;
    }

public RentDetailsPage chooseRentPeriod(String period) {
        webDriver.findElement(rentPeriodField).click();
        if (period == "1 сутки") {
            webDriver.findElement(rentPeriodOneDay).click();
        }
            else if (period == "7 суток") {
                webDriver.findElement(rentPeriodSevenDays).click();
            }
            return this;
        }

public RentDetailsPage pickScooterColor(String color) {
        if (color == "чёрный") {
            webDriver.findElement(blackScooterColorButton).click();
        }
        else if (color == "серый") {
            webDriver.findElement(greyScooterColorButton).click();
        }
        return this;
    }

public RentDetailsPage putMessageForCarrier(String message) {
        webDriver.findElement(messageForСarrierField).click();
        webDriver.findElement(messageForСarrierField).sendKeys(message);
        return this;
}


public RentDetailsPage clickFinishOrderButton() {
        webDriver.findElement(finishOrderButton).click();
        return this;
}

public RentDetailsPage confirmOrder() {
webDriver.findElement(confirmOrderButton).click();
return this;
}



public boolean isDoneOrderNotificationShowed() {
       return webDriver.findElements(successfulOrderNotification).isEmpty();

}

}






