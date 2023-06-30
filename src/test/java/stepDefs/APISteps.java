package stepDefs;

import ApiUtils.RestAssuredExtension;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.Matchers;
import utils.AssertionsUtility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class APISteps {
    private static ResponseOptions<Response> response;



    @Given("User Performs Put Operation on {string} resource to update the user details having {string}")
    public void userPerformsPutOperationOnResourceToUpdateTheUserDetailsHavingAs(String arg0, String arg1) {
        RestAssuredExtension.setUrl(arg0+arg1);
    }

    @When("User updates the body with Required Updates")
    public void userUpdatesTheBodyWithRequiredUpdates(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();
        Map<String, String> body = new HashMap<String, String>();
        body.put(data.get(0).get(1), data.get(1).get(1));
        body.put(data.get(0).get(2), data.get(1).get(2));
        String pathParameterKey=data.get(0).get(0);
        String pathParameterValue=data.get(1).get(0);
        response=RestAssuredExtension.PutWithPathParameterAndBody(pathParameterKey,pathParameterValue,body);

    }

    @Then("Status code should be {string}")
    public void thenStatusCodeShouldBe(String statusCode) {
        System.out.println(response.getBody().prettyPrint());
        System.out.println(response.getStatusCode());
        AssertionsUtility.getSoftAssert().assertEquals(""+response.getStatusCode(),statusCode);
    }

    @Given("User Performs Delete Operation on {string} resource to delete the user details with userId as {string}")
    public void userPerformsDeleteOperationOnResourceToDeleteTheUserDetails(String arg0,String arg1) {
        RestAssuredExtension.setUrl(arg0+arg1);
    }
    @When("user inputs the following {string}")
    public void userInputsTheFollowing(String pathParams) {
        response=RestAssuredExtension.DeleteOpsWithPathParams(pathParams);
    }
}
