package src.main.java.api;

public enum EnumsData {
    FILE ("application/octet-stream"), JSON ("application/json");

    private final String type;

    EnumsData(String type) {
        this.type = type;
    }

    public String asString() {
        return type;
    }
}
