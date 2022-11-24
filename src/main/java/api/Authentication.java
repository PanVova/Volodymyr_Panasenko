package src.main.java.api;

import requests.BaseRequest;

public class Authentication extends BaseRequest {
    public Authentication(String url) {
        super(url);
        builder.setMethod(new BaseRequestAPI(this.url, RequestType.POST));
        request = builder.build();
    }
}
