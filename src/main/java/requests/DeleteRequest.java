package src.main.java.requests;

import api.EnumsData;
import api.BaseRequestAPI;
import api.RequestBody;
import api.RequestType;

import java.util.HashMap;
import java.util.Map;

public class DeleteRequest extends BaseRequest {
    public DeleteRequest(String filepath, String url) {
        super(url);
        Map<String, String> jsonObj = new HashMap<>();
        jsonObj.put("path", filepath);
        builder.setBody(new RequestBody(EnumsData.JSON, jsonObj));
        builder.setMethod(new BaseRequestAPI(this.url, RequestType.POST));
        request = builder.build();
    }
}
