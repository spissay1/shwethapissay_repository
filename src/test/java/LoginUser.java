public class LoginUser {
    private String userId;
    private String password;
    private Boolean rememberMe;

    public LoginUser(String userId, String password, Boolean rememberMe) {
        this.userId = userId;
        this.password = password;
        this.rememberMe = rememberMe;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
