package src.test.java.stepdefs;

import io.cucumber.java.en.Given;

import java.util.HashMap;

public class UploadFileStepdefs {
    @Given("I want upload {string} to folder {string} with name {string}")
    public void iWantUploadFileToFolder(String filename, String folder, String filename_dropbox) {
        GeneralRequestsStepdefs.parameters = new HashMap<>();
        GeneralRequestsStepdefs.parameters.put("filename", filename);
        GeneralRequestsStepdefs.parameters.put("dropbox_path", folder + "/" + filename_dropbox);
    }
}
