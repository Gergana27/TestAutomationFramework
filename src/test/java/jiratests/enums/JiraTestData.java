package jiratests.enums;

public enum JiraTestData {
    USERNAME("gergana.georgieva.a61@learn.telerikacademy.com"),
    PASSWORD("dummyPass!1");

    final String value;

    JiraTestData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
