package sprint4.ya.scooter;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import sprint4.ya.scooter.pom.MainPage;
import sprint4.ya.scooter.rules.BrowserRule;


public class QuestionsOfImportanceDrop {


@Rule
public BrowserRule browserRule = new BrowserRule();





    @Test
    public void droppedAnswersShowedAfterClickOnQuestions() {

        MainPage mainPage = new MainPage(browserRule.getWebDriver());

        mainPage.open()
                .acceptCookie();



        for (int i = 0; i <= 7; i = i + 1) {
            mainPage.clickQuestion(i);
            Assert.assertTrue("Ответ не появляется!", mainPage.isAnswerShowed(i));
            }

        }



}
