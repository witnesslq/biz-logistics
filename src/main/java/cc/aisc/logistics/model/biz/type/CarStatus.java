package cc.aisc.logistics.model.biz.type;

/**
 * Created by sjf on 16-6-30.
 */
public enum CarStatus {
    PENDING, ASSIGNED, DELIVERED, ACCIDENT, FINISHED;
    /*PENDING(0,"待运输"),
    ASSIGNED(1,"已指派"),
    DELIVERED(2,"已运输"),
    ACCIDENT(3,"发生事故"),
    FINISHED(4,"运输完成");

    private Integer code;
    private String description;

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    CarStatus(int code, String description){
        this.code = code;
        this.description = description;
    }*/
}
