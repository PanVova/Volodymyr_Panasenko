package src.test.java.stepdefs;

import api.RequestAPI;
import api.Authentication;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GeneralRequestsStepdefs {
    public Response response;
    public static Map<String, String> parameters;

    @Given("User authorized")
    public void userAuthorized() {
        assertEquals(
                200,
                new Authentication("https://api.dropboxapi.com/2/check/user").sendRequest().statusCode()
        );
    }

    @When("I send POST request to {string}")
    public void postRequest(String url) {
        response = new RequestAPI(url, parameters).send();
    }
}
