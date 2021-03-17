import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;

public class PracticeFormTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulFillTestWithVariables() throws InterruptedException {
        String firstName = "Анна";
        String lastName = "Ипполитова";
        String userEmail = "aippolitov@email.com";
        String gender = "Female";
        String userNumber = "9001231234";
        String[] aSubjects = new String[]{"Computer Science", "English"};
        String[] aCharacteres;
        HashMap<String, String> hobbiesVals = new HashMap<>();
        hobbiesVals.put("Sports", "hobbies-checkbox-1");
        hobbiesVals.put("Reading", "hobbies-checkbox-2");
        hobbiesVals.put("Music", "hobbies-checkbox-3");
        File file = new File("src/test/resources/ApacheJmeter.ico");
        String currentAddress = "Россия, лучший город Земли, ул. Ленина, д.1";

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        //  DateOfBirth_example
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $("option[value='1995']").click();
        $(".react-datepicker__month-select").click();
        $("option[value='1']").click();
        $(".react-datepicker__day.react-datepicker__day--025").click();
        //  fill Subjects
        for (String sbjTemp : aSubjects) {
            aCharacteres = sbjTemp.split("");
            for (String aSymbol : aCharacteres) {
                $("#subjectsInput").sendKeys(aSymbol);
                sleep(50);
            }
            $("#subjectsInput").sendKeys(Keys.ENTER);
        }
        //  fill Hobbies
        for (Iterator hobbie = hobbiesVals.values().iterator(); hobbie.hasNext(); )
            $("label[for=" + hobbie.next() + "]").click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("currentAddress");
        $("#state").click();
        $(By.xpath("//div[contains(text(),'Rajasthan')]")).click();
        $("#city").click();
        $(By.xpath("//div[contains(text(),'Jaipur')]")).click();
        $("#submit").click();

        $(".modal-content").shouldHave(text(firstName), text(lastName),
                text(userEmail),
                text(gender),
                text(userNumber),
//  todo почитать про параметризирование и форматирование даты
                text("25 February,1995"),
                text(String.join(", ", aSubjects)),
                text(String.join(", ", hobbiesVals.keySet())),
                text(currentAddress),
                text("Rajasthan Jaipur")
        );
    }
}