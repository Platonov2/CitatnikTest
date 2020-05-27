package CitatnikTests.Builders;

import io.restassured.specification.RequestSpecification;

import java.util.Properties;

public class DatasetRequestBuilder {
    private RequestSpecification requestSpecification;

    public DatasetRequestBuilder(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public DatasetRequestBuilder WithId(int id, Properties properties){
        String EndUrl = properties.getProperty("base_path") + String.valueOf(id);
        requestSpecification.basePath(EndUrl);
        return this;
    }

    public RequestSpecification build() {
        return requestSpecification;
    }
}
