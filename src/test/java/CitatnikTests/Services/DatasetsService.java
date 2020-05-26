package CitatnikTests.Services;

import CitatnikTests.Builders.DatasetRequestBuilder;
import CitatnikTests.Models.CitataModel;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class DatasetsService {
    private static String Url;
    private final RequestSpecification spec;

    public DatasetsService(String url) {
        Url = url;

        System.setProperty("com.sun.security.enableAIAcaIssuers", "false");

        RequestSpecBuilder specBuilder = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(url);

        spec = specBuilder.build();
    }

    private RequestSpecification baseRequest() {
        return given().spec(spec);
    }

    public DatasetRequestBuilder requestBuilder() {
        return new DatasetRequestBuilder(baseRequest());
    }

    public CitataModel getDatasets(RequestSpecification requestSpecification) {
        return executePostDatasets(requestSpecification).then()
                .extract()
                .body().as(CitataModel.class);
    }

    public Response executePostDatasets(RequestSpecification requestSpecification) {
        return requestSpecification.post(Url);
    }
}
