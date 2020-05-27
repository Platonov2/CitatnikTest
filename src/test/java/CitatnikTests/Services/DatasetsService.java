package CitatnikTests.Services;

import CitatnikTests.Builders.DatasetRequestBuilder;
import CitatnikTests.Models.CitataModel;
import CitatnikTests.Models.ErrorModel;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class DatasetsService extends BaseService {
    private static String Url;
    private static String Endpoint;

    public DatasetsService(Properties properties) {
        super(properties);
    }

    public DatasetRequestBuilder requestBuilder() {
        return new DatasetRequestBuilder(baseRequest());
    }

    public CitataModel getCitata(RequestSpecification requestSpecification) {
        return executeGet(requestSpecification).then()
                .extract()
                .body().as(CitataModel.class);
    }

    public ErrorModel getError(RequestSpecification requestSpecification) {
        return executeGet(requestSpecification).then()
                .extract()
                .body().as(ErrorModel.class);
    }

    public Response executeGet(RequestSpecification requestSpecification) {
        return requestSpecification.get();
    }
}
