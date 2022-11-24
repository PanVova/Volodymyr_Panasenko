package src.main.java.api;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.HashMap;

import static io.restassured.config.EncoderConfig.encoderConfig;

public class Request {
    private final Headers headers;
    private final RequestBody requestBody;
    private final RequestType methodType;
    private final String methodName;
    private final RequestSpecification request;

    public Request(Headers headers, RequestBody requestBody, BaseRequestAPI method) {
        this.headers = headers;
        if (requestBody == null) {
            requestBody = new RequestBody(EnumsData.JSON, new HashMap<>());
        }
        this.requestBody = requestBody;
        this.methodType = method.getType();
        this.methodName = method.getPath();

        RestAssured.config = RestAssured
                .config()
                .encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));
        this.request = RestAssured
                .given()
                .baseUri(method.getURL())
                .basePath(method.getPath())
                .headers(headers)
                .contentType(requestBody.type().asString());

        switch (requestBody.type()) {
            case FILE -> request.body((File) requestBody.object());
            case JSON -> request.body(requestBody.object());
            default -> throw new IllegalArgumentException("Invalid request body data type");
        }
    }

    public Response send() {
        return switch (methodType) {
            case POST -> request.post();
            case GET -> request.get();
        };
    }
}
