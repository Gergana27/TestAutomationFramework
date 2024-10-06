package jiratests.enums;

public enum LinkedIssueType {
    BLOCKS("blocks"),
    IS_BLOCKED_BY("is blocked by"),
    RELATES("relates"),
    RELATES_TO("relates to"),
    DUPLICATES("duplicates"),
    IS_DUPLICATED_BY("is duplicated by"),
    CLONES("clones"),
    IS_CLONED_BY("is cloned by"),
    CREATED("created"),
    CREATED_BY("created by"),
    TESTS("tests"),
    IS_TESTED_BY("is tested by");

    private final String linkedIssueName;

    LinkedIssueType(String linkedIssueName) {
        this.linkedIssueName = linkedIssueName;
    }

    public String getLinkedIssueName() {
        return linkedIssueName;
    }
}
