package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.Select;
import pages.MedunnaHomePage;
import pages.MedunnaLoginPage;
import pages.MedunnaRoomPage;
import utils.Driver;
import utils.WaitUtils;

import static org.junit.Assert.assertTrue;

public class UI_StepDefs {

    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    MedunnaLoginPage medunnaLoginPage = new MedunnaLoginPage();
    MedunnaRoomPage medunnaRoomPage = new MedunnaRoomPage();


    @Given("user goes to {string}")
    public void user_goes_to(String url) {

        Driver.getDriver().get(url);

    }
    @When("user clicks on user icon")
    public void user_clicks_on_user_icon() {

        medunnaHomePage.userIcon.click();

    }
    @When("user clicks on sign in option")
    public void user_clicks_on_sign_in_option() {

        medunnaHomePage.signInOption.click();

    }



    @And("user enters username {string}")
    public void userEntersUsername(String username) {

        medunnaLoginPage.username.sendKeys(username);

    }

    @And("user enters  password {string}")
    public void userEntersPassword(String password) {

        medunnaLoginPage.password.sendKeys(password);

    }

    @When("user clicks on sign in submit button")
    public void user_clicks_on_sign_in_submit_button() {

        medunnaLoginPage.signInSubmit.click();

    }
    @Given("user clicks itemsAndTitles")
    public void user_clicks_items_and_titles() {

        medunnaHomePage.itemsAndTitles.click();

    }

    @When("user clicks on room option")
    public void user_clicks_on_room_option() {

        medunnaHomePage.roomLink.click();

    }
    @When("user clicks on create a new room link")
    public void user_clicks_on_create_a_new_room_link() {

        medunnaRoomPage.createANewRoomLink.click();

    }

    @When("user enters room number {string}")
    public void user_enters_room_number(String roomNumber) {

        int fakeRoomNumber = Faker.instance().number().numberBetween(100000,1000000);
        medunnaRoomPage.roomNumber.sendKeys(fakeRoomNumber+"");

    }
    @When("user selects {string}")
    public void user_selects(String roomType) {

        new Select(medunnaRoomPage.roomTypeDroDown).selectByVisibleText(roomType);

    }
    @When("user clicks on status")
    public void user_clicks_on_status() {

        medunnaRoomPage.roomStatusCheckBox.click();

    }
    @When("user enters price {string}")
    public void user_enters_price(String price) {

        medunnaRoomPage.roomPrice.sendKeys(price);

    }
    @When("user enters  description {string}")
    public void user_enters_description(String description) {

        medunnaRoomPage.roomDescription.sendKeys(description);

    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {

        medunnaRoomPage.saveButton.click();

    }


    @Then("assert alert message")
    public void assert_alert_message() {

        WaitUtils.waitFor(1);//For synchronization issue
        String alertText = medunnaRoomPage.alert.getText();
        assertTrue(alertText.contains("A new Room is created"));

    }

    @Then("close the app")
    public void close_the_app() {

        WaitUtils.waitFor(3);
        Driver.closeDriver();

    }



}