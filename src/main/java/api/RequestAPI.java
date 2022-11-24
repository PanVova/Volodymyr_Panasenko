package src.main.java.api;

import io.restassured.response.Response;
import requests.BaseRequest;
import requests.DeleteRequest;
import requests.GetFileMetadataRequest;
import requests.UploadRequest;

import java.util.Map;

public class RequestAPI {
    BaseRequest request;

    public RequestAPI(String url, Map<String, String> params) {
        if (url.matches("^.*/upload$")) uploadRequest(url, params);
        else if (url.matches("^.*/get_file_metadata$")) getFileMetadataRequest(url, params);
        else if (url.matches("^.*/delete_v2$")) deleteRequest(url, params);
        else throw new IllegalArgumentException("Invalid request url");
    }

    private void deleteRequest(String url, Map<String, String> params) {
        request = new DeleteRequest(params.get("filepath"), url);
    }

    private void getFileMetadataRequest(String url, Map<String, String> params) {
        request = new GetFileMetadataRequest(params.get("filepath"), url);
    }

    private void uploadRequest(String url, Map<String, String> params) {
        request = new UploadRequest(
                "src/test/resources" + params.get("filename"), params.get("dropbox_path"), url
        );
    }

    public Response send() {
        return request.sendRequest();
    }
}
