package sprint4.ya.scooter;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import sprint4.ya.scooter.pom.MainPage;
import sprint4.ya.scooter.rules.BrowserRule;

@RunWith(Parameterized.class)
public class QuestionsOfImportanceDrop {


    private final By question;
    private final By answer;


    public QuestionsOfImportanceDrop(By question, By answer) {
        this.question = question;
        this.answer = answer;
    }


    @Parameterized.Parameters

    public static Object[][] getQA() {
        return new Object[][]{

                {MainPage.getQuestion(0), MainPage.getAnswer(0)},
                {MainPage.getQuestion(1), MainPage.getAnswer(1)},
                {MainPage.getQuestion(2), MainPage.getAnswer(2)},
                {MainPage.getQuestion(3), MainPage.getAnswer(3)},
                {MainPage.getQuestion(4), MainPage.getAnswer(4)},
                {MainPage.getQuestion(5), MainPage.getAnswer(5)},
                {MainPage.getQuestion(6), MainPage.getAnswer(6)},
                {MainPage.getQuestion(7), MainPage.getAnswer(7)},


        };
    }


    @Rule
    public BrowserRule browserRule = new BrowserRule();


    @Test
    public void droppedAnswersShowedAfterClickOnQuestions() {

        MainPage mainPage = new MainPage(browserRule.getWebDriver());

        mainPage.open()
                .acceptCookie()
                .clickQuestion(question);


        Assert.assertTrue("Ответ не появляется!", mainPage.isAnswerShowed(answer));


    }

}

