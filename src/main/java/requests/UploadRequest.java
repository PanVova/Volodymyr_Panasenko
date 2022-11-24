package src.main.java.requests;

import api.EnumsData;
import api.BaseRequestAPI;
import api.RequestBody;
import api.RequestType;
import io.restassured.http.Header;

import java.io.File;

public class UploadRequest extends BaseRequest {
    public UploadRequest(String filename, String dropbox_path, String url) {
        super(url);
        builder.addHeader(new Header("Dropbox-API-Arg", "{\"path\":\"" + dropbox_path + "\"}"));
        builder.setBody(new RequestBody(EnumsData.FILE, new File(filename)));
        builder.setMethod(new BaseRequestAPI(this.url, RequestType.POST));
        request = builder.build();
    }
}
