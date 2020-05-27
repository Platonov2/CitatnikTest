package CitatnikTests.Tests;

import CitatnikTests.Models.CitataModel;
import CitatnikTests.Models.ErrorModel;
import CitatnikTests.Services.DatasetsService;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CitataTest extends BaseTest {
    @Test(groups = "positiveTest")
    public void GetCitataPositiveTest (){
        DatasetsService datasetsService = new DatasetsService(properties);

        RequestSpecification requestSpecification = datasetsService.requestBuilder()
                .WithId(1, properties)
                .build();

        ValidatableResponse response = datasetsService.executeGet(requestSpecification)
                .then()
                .assertThat()
                .body("citataId", equalTo(1))
                .and().body("title", equalTo("Title1"))
                .and().body("content", equalTo("Content1"))
                .and().body("creationDate", notNullValue());
    }

    @Test(groups = "negativeTest")
    public void GetCitataNegativeTest (){
        DatasetsService datasetsService = new DatasetsService(properties);

        RequestSpecification requestSpecification = datasetsService.requestBuilder()
                .WithId(0, properties)
                .build();

        ErrorModel error = datasetsService.getError(requestSpecification);

        assertThat(error.getType(), notNullValue());
        assertThat(error.getTitle(), containsString("Not Found"));
        assertThat(error.getStatus(), containsString("404"));
        assertThat(error.getTraceId(), notNullValue());
    }
}
