import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulFillTestWithVariables() {
        String name = "Anton";
        String lastName = "Ippolitov";
        String userEmail = "aippolitov@email.com";
//        String gender = "male";
        String userNumber = "89001231234";
        String currentAdress = "Russia, willage";

        open("https://demoqa.com/automation-practice-form");

        $("#userName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);

        $("#userNumber").setValue("userNumber");
        $("#currentAddress").setValue("currentAdress");
        $("#submit").click();

    }
    /*
    @Test
    void successfulFillTestWithSearchInOutput() {
        $("#output").shouldHave(text(name), text("aa@aa.aa"));
    }
    */

}