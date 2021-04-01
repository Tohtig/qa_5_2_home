package pageobject.scenarios;

import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;

import java.util.Locale;

public class StudentsRegistrationFormTests {
    StudentsRegistrationFormPage studentsRegistrationFormPage;
    Faker faker;

    @Test
    void successfulFillFormTest() {
        studentsRegistrationFormPage = new StudentsRegistrationFormPage();
        studentsRegistrationFormPage.openPage();
        studentsRegistrationFormPage.fillForm();
        studentsRegistrationFormPage.checkData();
    }

    @Test
    void successfulFillFormTestWithFacker() {
        faker = new Faker(new Locale("en"));
        studentsRegistrationFormPage = new StudentsRegistrationFormPage(faker);
        studentsRegistrationFormPage.openPage();
        studentsRegistrationFormPage.fillForm();
        studentsRegistrationFormPage.checkData();
    }
}
