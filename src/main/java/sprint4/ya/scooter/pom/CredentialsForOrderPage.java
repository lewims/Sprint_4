package sprint4.ya.scooter.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CredentialsForOrderPage {

    private final WebDriver webDriver;

    private final By nameField = By.xpath(".//input[@placeholder = '* Имя']");
    private final By surnameField = By.xpath(".//input[@placeholder = '* Фамилия']");
    private final By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    private final By subwayStationField = By.xpath(".//div[@class='select-search__value']/input[@value]");
    private final By phoneNumberField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");


    private static final By selectFirstInListStation = By.xpath(".//li[@class='select-search__row'][1]/button[@class='Order_SelectOption__82bhS select-search__option']");
    private static final By selectLastInListStation = By.xpath(".//li[@class='select-search__row'][last()]/button[@class='Order_SelectOption__82bhS select-search__option']");



    private final By buttonNextOnOrderCredentialsPage = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']");

    public CredentialsForOrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public static By getSelectFirstInListStation() {
        return selectFirstInListStation;
    }


    public static By getSelectLastInListStation() {
        return selectLastInListStation;
    }

    public CredentialsForOrderPage insertName(String name) {
        webDriver.findElement(nameField).click();
        webDriver.findElement(nameField).sendKeys(name);
        return this;
    }

    public CredentialsForOrderPage insertSurname(String surname) {
        webDriver.findElement(surnameField).click();
        webDriver.findElement(surnameField).sendKeys(surname);
        return this;
    }

    public CredentialsForOrderPage insertAddress(String address) {
        webDriver.findElement(addressField).click();
        webDriver.findElement(addressField).sendKeys(address);
        return this;
    }

    public CredentialsForOrderPage pickSubwayStation(By station) {
        webDriver.findElement(subwayStationField).click();
        webDriver.findElement(station).click();
        return this;
    }

    public CredentialsForOrderPage insertPhoneNumber(String number) {
        webDriver.findElement(phoneNumberField).click();
        webDriver.findElement(phoneNumberField).sendKeys(number);
        return this;
    }

    public CredentialsForOrderPage clickNextButton() {
        webDriver.findElement(buttonNextOnOrderCredentialsPage).click();
            return this;
        }
    }



