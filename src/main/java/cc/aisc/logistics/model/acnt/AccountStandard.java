package cc.aisc.logistics.model.acnt;

import cc.aisc.logistics.model.acnt.type.AccountType;
import cc.aisc.logistics.model.acnt.type.AccountUnit;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sjf on 16-8-3.
 * 结算价格标准
 * 包含：劳务费，燃油费，轮胎补贴，通信补贴
 */

public class AccountStandard {

    private Long id;
    private AccountType type;
    private Integer slotAmt;         //车位数量
    private BigDecimal distLwLim;    //任务里程数下限
    private BigDecimal distUpLim;    //任务里程数上限
    private Integer domAmt;          //装载国产车数量
    private Integer impAmt;          //装载进口车数量
    private Integer smlAmt;          //装载小车数量(重量？)
    private Integer bigAmt;          //装载大车数量(重量？)
    private BigDecimal unitPrice;    //结算单价(元rmb)
    private AccountUnit unit;        //结算单位
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Integer getSlotAmt() {
        return slotAmt;
    }

    public void setSlotAmt(Integer slotAmt) {
        this.slotAmt = slotAmt;
    }

    public BigDecimal getDistLwLim() {
        return distLwLim;
    }

    public void setDistLwLim(BigDecimal distLwLim) {
        this.distLwLim = distLwLim;
    }

    public BigDecimal getDistUpLim() {
        return distUpLim;
    }

    public void setDistUpLim(BigDecimal distUpLim) {
        this.distUpLim = distUpLim;
    }

    public Integer getDomAmt() {
        return domAmt;
    }

    public void setDomAmt(Integer domAmt) {
        this.domAmt = domAmt;
    }

    public Integer getImpAmt() {
        return impAmt;
    }

    public void setImpAmt(Integer impAmt) {
        this.impAmt = impAmt;
    }

    public Integer getSmlAmt() {
        return smlAmt;
    }

    public void setSmlAmt(Integer smlAmt) {
        this.smlAmt = smlAmt;
    }

    public Integer getBigAmt() {
        return bigAmt;
    }

    public void setBigAmt(Integer bigAmt) {
        this.bigAmt = bigAmt;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public AccountUnit getUnit() {
        return unit;
    }

    public void setUnit(AccountUnit unit) {
        this.unit = unit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public AccountStandard() {

    }
}
