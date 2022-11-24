package src.test.java.stepdefs;

import io.cucumber.java.en.And;
import java.util.HashMap;

public class DeleteOrGetMetadataStepdefs {
    @And("I want to (get metadata of)/delete file by existing path/filepath {string}")
    public void iWantToGetMetadataByFilepath(String filepath) {
        GeneralRequestsStepdefs.parameters = new HashMap<>();
        GeneralRequestsStepdefs.parameters.put("filepath", filepath);
    }
}
