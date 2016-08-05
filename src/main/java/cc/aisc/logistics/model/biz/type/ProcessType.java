package cc.aisc.logistics.model.biz.type;

/**
 * Created by sjf on 16-5-17.
 */
public enum ProcessType {
    LOAD(0, "装车"),
    UNLOAD(1, "卸车"),
    TRANSPORT(2, "运输"),
    ACCIDENT(2, "事故");

    private Integer code;
    private String description;

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    ProcessType(int code, String description){
        this.code = code;
        this.description = description;
    }
}
