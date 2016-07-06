package cc.aisc.logistics.model.biz.trspt.type;

/**
 * Created by sjf on 16-6-21.
 */
public enum ScheduleStatus {
    CREATED(0, "新建调度单"),
    SETTLED(1, "结算完成"),
    ACCOUNTED(2, "核算完成"),
    PROCESSING(3, "任务进行中"),
    COMPLETED(4, "任务完成"),
    CANCELED(5, "任务取消");

    private Integer code;
    private String description;

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    ScheduleStatus(int code, String description){
        this.code = new Integer(code);
        this.description = description;
    }
}
