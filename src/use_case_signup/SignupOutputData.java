//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package use_case_signup;

public class SignupOutputData {
    private final String username;
    private String creationTime;
    private boolean useCaseFailed;

    public SignupOutputData(String username, String creationTime, boolean useCaseFailed) {
        this.username = username;
        this.creationTime = creationTime;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return this.username;
    }

    public String getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
