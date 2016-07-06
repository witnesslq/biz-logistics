package cc.aisc.logistics.model.auth.dto;

/**
 * Created by sjf on 16-7-6.
 */
public class Authority {

    private String authName;
    private String [] mode;

    public Authority(String authName, String[] mode) {
        this.authName = authName;
        this.mode = mode;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String[] getMode() {
        return mode;
    }

    public void setMode(String[] mode) {
        this.mode = mode;
    }
}
