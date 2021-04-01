package pageobject.scenarios;

import org.junit.jupiter.api.Test;

import java.util.Locale;

public class StudentsRegistrationFormTests {
    StudentsRegistrationFormPage studentsRegistrationFormPage;
    Faker faker = new Faker(new Locale("ru"));

    @Test
    void successfulFillFormTest() {
        studentsRegistrationFormPage = new StudentsRegistrationFormPage();
        studentsRegistrationFormPage.openPage();
        studentsRegistrationFormPage.fillForm();
        studentsRegistrationFormPage.checkData();
    }

    @Test
    void successfulFillFormTestWithJavaFaker(Faker faker) {
        studentsRegistrationFormPage = new StudentsRegistrationFormPage(faker);
        studentsRegistrationFormPage.openPage();
        studentsRegistrationFormPage.fillForm();
        studentsRegistrationFormPage.checkData();
    }
}
