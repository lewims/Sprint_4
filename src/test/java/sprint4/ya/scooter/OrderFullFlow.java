package sprint4.ya.scooter;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import sprint4.ya.scooter.pom.CredentialsForOrderPage;
import sprint4.ya.scooter.pom.MainPage;
import sprint4.ya.scooter.pom.RentDetailsPage;
import sprint4.ya.scooter.rules.BrowserRule;




@RunWith(Parameterized.class)
public class OrderFullFlow {





        private final String name;
        private final String surName;
        private final String address;
        private final By subwayStation;
        private final String phoneNumber;
        private  final String date;
        private  final String period;
        private final String color;
        private final String message;
        private final By orderButton;



        public OrderFullFlow(String name, String surName, String address, By subwayStation, String phoneNumber, String date, String period, String color, String message, By orderButton) {
            this.name = name;
            this.surName = surName;
            this.address = address;
            this.subwayStation = subwayStation;
            this.phoneNumber = phoneNumber;
            this.date = date;
            this.period = period;
            this.color = color;
            this.message = message;
            this.orderButton = orderButton;
        }



        @Parameterized.Parameters

    public static Object[][] getCredentials() {


        return new Object[][] {
                {"Николай", "Наумов", "ул.Пушкина, д.10", CredentialsForOrderPage.getSelectFirstInListStation(), "89697784499", "31 мая", "1 сутки", "чёрный", "Встречу у подъезда", MainPage.getUpperOrderButton()},
                {"Николай", "Наумов", "ул.Пушкина, д.10", CredentialsForOrderPage.getSelectFirstInListStation(), "89697784499", "31 мая", "1 сутки", "чёрный", "Встречу у подъезда", MainPage.getLowerOrderButton()},
                {"Григорий", "Распутин", "пр-т Водолазов, д.69", CredentialsForOrderPage.getSelectLastInListStation(), "89293332112", "1 июля", "7 суток", "серый", "Очень жду мой самокат ;)", MainPage.getLowerOrderButton()},
                {"Григорий", "Распутин", "пр-т Водолазов, д.69", CredentialsForOrderPage.getSelectLastInListStation(), "89293332112", "1 июля", "7 суток", "серый", "Очень жду мой самокат ;)", MainPage.getUpperOrderButton()},
            };
        }


    @Rule
    public BrowserRule browserRule = new BrowserRule();

        @Test
        public void fullFlowOfOrderPositiveTestUpperButton() {
            MainPage mainPage = new MainPage(browserRule.getWebDriver());
            CredentialsForOrderPage credentialsForOrderPage1 = new CredentialsForOrderPage(browserRule.getWebDriver());
            RentDetailsPage rentDetailsPage = new RentDetailsPage(browserRule.getWebDriver());

            mainPage.open()
                    .acceptCookie()
                    .clickOrderButton(orderButton);


            credentialsForOrderPage1.insertName(name)
                                    .insertSurname(surName)
                                    .insertAddress(address)
                                    .pickSubwayStation(subwayStation)
                                    .insertPhoneNumber(phoneNumber)
                                    .clickNextButton();

            rentDetailsPage.chooseArrivalDate(date)
                           .chooseRentPeriod(period)
                           .pickScooterColor(color)
                           .putMessageForCarrier(message)
                           .clickFinishOrderButton()
                           .confirmOrder();

            Assert.assertFalse("Заказ прошёл неудачно", rentDetailsPage.isDoneOrderNotificationShowed());

        }




    }


