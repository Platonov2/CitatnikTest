package CitatnikTests.Services;

import CitatnikTests.Builders.DatasetRequestBuilder;
import CitatnikTests.Models.CitataModel;
import CitatnikTests.Models.ErrorModel;
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
                .setContentType(ContentType.JSON);

        spec = specBuilder.build();
    }

    public DatasetRequestBuilder requestBuilder() {
        return new DatasetRequestBuilder(given().spec(spec));
    }

    public CitataModel getCitata(RequestSpecification requestSpecification) {
        return executePostDatasets(requestSpecification).then()
                .extract()
                .body().as(CitataModel.class);
    }

    public ErrorModel getError(RequestSpecification requestSpecification) {
        return executePostDatasets(requestSpecification).then()
                .extract()
                .body().as(ErrorModel.class);
    }

    public Response executePostDatasets(RequestSpecification requestSpecification) {
        return requestSpecification.get(Url);
    }
}
