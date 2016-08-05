package cc.aisc.logistics.model.acnt;

import cc.aisc.logistics.model.acnt.type.SharePeriod;
import cc.aisc.logistics.model.acnt.type.ShareType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sjf on 16-8-3.
 */
//运输车辆费用分摊
public class FixedShare {

    private Long id;
    private Long vehSn;          //
    private ShareType type;     // 分摊类型
    private SharePeriod period;  // 分摊周期
    private BigDecimal total;    // 分摊总额
    private Date startDate;     // 分摊起始日期
    private Date endDate;       // 分摊终止日期
    private String remark;
    private Long createBy;
    private Long modifyBy;
    private Date createAt;
    private Date modifyAt;

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(Date modifyAt) {
        this.modifyAt = modifyAt;
    }

    public FixedShare() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVehSn() {
        return vehSn;
    }

    public void setVehSn(Long vehSn) {
        this.vehSn = vehSn;
    }

    public ShareType getType() {
        return type;
    }

    public void setType(ShareType type) {
        this.type = type;
    }

    public SharePeriod getPeriod() {
        return period;
    }

    public void setPeriod(SharePeriod period) {
        this.period = period;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
