package CitatnikTests.Tests;

import CitatnikTests.Models.CitataModel;
import CitatnikTests.Models.ErrorModel;
import CitatnikTests.Services.DatasetsService;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CitataTest {
    @Test(groups = "positiveTest")
    public void GetCitataPositiveTest (){
        DatasetsService datasetsService = new DatasetsService("http://localhost:62146/api/Citata/1");

        RequestSpecification requestSpecification = datasetsService.requestBuilder()
                .getFields("citataId" ,"title", "content")
                .build();

        CitataModel citata = datasetsService.getCitata(requestSpecification);

        assertThat(citata.getCitataId(), equalTo(1));
        assertThat(citata.getTitle(), containsString("Title1"));
        assertThat(citata.getContent(), containsString("Content1"));
        assertThat(citata.getCretionDate(), notNullValue());
    }

    @Test(groups = "negativeTest")
    public void GetCitataNegativeTest (){
        DatasetsService datasetsService = new DatasetsService("http://localhost:62146/api/Citata/0");

        RequestSpecification requestSpecification = datasetsService.requestBuilder()
                .build();

        ErrorModel error = datasetsService.getError(requestSpecification);

        assertThat(error.getType(), notNullValue());
        assertThat(error.getTitle(), containsString("Not Found"));
        assertThat(error.getStatus(), containsString("404"));
        assertThat(error.getTraceId(), notNullValue());
    }
}
