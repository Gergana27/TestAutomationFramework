package jiratests.enums;

public enum IssueType {
    STORY("Story"),
    BUG("Bug"),
    TASK("Task"),
    EPIC("Epic");

    private final String typeName;

    IssueType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
