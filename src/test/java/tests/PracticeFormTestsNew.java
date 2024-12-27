package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class PracticeFormTestsNew extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fullFillFormTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Alex")
                .setLastName("Alexovich")
                .setEmail("alex@egorov.com")
                .chooseGender("Female")
                .setMobileNumber("8922211111")
                .setBirthDate("6","April","1995")
                .setAndChooseSubject("Maths")
                .chooseHobbies("Sports")
                .uploadPicture("1.jpg")
                .setAddress("Russia")
                .chooseStateAndCity("NCR","Delhi")
                .clickSubmit();

        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name","Alex Alexovich")
                .verifyResult("Student Email","alex@egorov.com")
                .verifyResult("Gender","Female")
                .verifyResult("Mobile","8922211111")
                .verifyResult("Date of Birth","6 April,1995")
                .verifyResult("Subjects","Maths")
                .verifyResult("Hobbies","Sports")
                .verifyResult("Picture","1.jpg")
                .verifyResult("Address","Russia")
                .verifyResult("State and City","NCR Delhi");
    }

    @Test
    void minimalFillFormTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Alex")
                .setLastName("Alexovich")
                .chooseGender("Female")
                .setMobileNumber("8922211111")
                .setBirthDate("6", "April", "1995")
                .clickSubmit();

        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", "Alex Alexovich")
                .verifyResult("Gender", "Female")
                .verifyResult("Mobile", "8922211111")
                .verifyResult("Date of Birth", "6 April,1995");
    }

    @Test
    void negativeFillFormTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName("")
                .setLastName("")
                .setEmail("invalid-email")
                .setMobileNumber("LL22211111")
                .setBirthDate("6","April","1995")
                .setAddress("USA")
                .clickSubmit();

        registrationPage.firstNameFieldInvalidationCheck()
                .lasNameFieldInvalidationCheck()
                .userEmailFieldInvalidationCheck()
                .genderFieldInvalidationCheck()
                .mobileNumberFieldInvalidationCheck();
    }
}
