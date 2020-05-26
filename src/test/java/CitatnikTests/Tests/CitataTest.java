package CitatnikTests.Tests;

import CitatnikTests.Models.CitataModel;
import CitatnikTests.Services.DatasetsService;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CitataTest {
    @Test(groups = "positiveTest")
    public void GetCitataPositiveTest (){
        DatasetsService datasetsService = new DatasetsService("https://localhost:44380/api/Citata/1/");

        RequestSpecification requestSpecification = datasetsService.requestBuilder()
                .getFields("title", "content")
                .build();

        CitataModel citata = datasetsService.getDatasets(requestSpecification);

        assertThat(citata.getTitle(), containsString("Title1"));
        assertThat(citata.getContent(), containsString("Content1"));
    }
}
