package CitatnikTests.Builders;

import io.restassured.specification.RequestSpecification;

public class DatasetRequestBuilder {
    private RequestSpecification requestSpecification;

    public DatasetRequestBuilder(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public DatasetRequestBuilder getFields(String... fields) {
        requestSpecification.body(fields);
        return this;
    }

    public RequestSpecification build() {
        return requestSpecification;
    }
}
