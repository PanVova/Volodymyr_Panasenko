package src.main.java.requests;

import api.Request;
import api.RequestBuilder;
import io.restassured.http.Header;
import io.restassured.response.Response;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseRequest {
    public static final String ACCESS_TOKEN = "sl.BTuMxZWGjrSFoPzWDg95FUqVMBqgYSfDZ8vJ4jwbLBBTNQkD0IMlaKnWKMV4kdIEO2y-TGdZKpXM-FC3DOSvP7dy90pd3m2yZCYQaj3P13yb1HnlUFwgegY_5sGpzKZQRhUiWL0_";

    protected RequestBuilder builder;
    protected Request request;
    protected URL url;

    public BaseRequest(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid request url");
        }
        builder = new RequestBuilder();
        builder.addHeader(new Header("Authorization", "Bearer " + ACCESS_TOKEN));
        builder.addHeader(new Header("Host", this.url.getHost()));
    }

    public Response sendRequest() {
        return request.send();
    }
}
