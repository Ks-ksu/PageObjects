package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAllsetup() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Alexovich");
        $("#userEmail").setValue("alex@egorov.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("89999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1995");
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text("6")).click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("label[for=hobbies-checkbox-2]").click();
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        $("#currentAddress").setValue("Russia");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table").$(byText("Student Name")).sibling(0).shouldHave(text("Alex Alexovich"));
        $(".table").$(byText("Student Email")).sibling(0).shouldHave(text("alex@egorov.com"));
        $(".table").$(byText("Gender")).sibling(0).shouldHave(text("Female"));
        $(".table").$(byText("Mobile")).sibling(0).shouldHave(text("8999999999"));
        $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("06 April,1995"));
        $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Chemistry"));
        $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Reading"));
        $(".table").$(byText("Picture")).sibling(0).shouldHave(text("1.jpg"));
        $(".table").$(byText("Address")).sibling(0).shouldHave(text("Russia"));
        $(".table").$(byText("State and City")).sibling(0).shouldHave(text("NCR Delhi"));
    }
    @AfterEach
    void afterEachteardown() {
        Selenide.closeWebDriver();
    }
}