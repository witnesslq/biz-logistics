package cc.aisc.logistics.model.veh;

import cc.aisc.commons.costant.Constant;
import cc.aisc.logistics.model.corp.Corporation;
import cc.aisc.logistics.model.veh.type.EmsStdType;
import cc.aisc.logistics.model.veh.type.VehicleStatus;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class Tractor {

    private Long id;

    @Length(min = 6, max = 12)
    private String plateNo;
    @Length(min = 2, max = 20)
    private String manufacturer;
    @Length(min = 2, max = 20)
    private String vehBrand;
    @Length(min = 2, max = 20)
    private String vehModel;
    @Size(min = 1, max = 999)
    private Short power;

    private String style;

    private VehicleStatus status;

    @Length(min = 12, max = 20)
    private String vin;

    @Length(min = 12, max = 20)
    private String drvLisn;

    @Length(min = 12, max = 20)
    private String logiLisn;

    private Long isrnDtlId;

    @Past
    private Date prdtDate;

    @Past
    private Date pucsDate;

    @Length(min = 2, max = 4)
    private String lisnDate;

    @Length(min = 12, max = 20)
    private String chassisNo;

    private EmsStdType emsStd;

    @Size(min = 100, max = 99999)
    private Short vehLength;
    @Size(min = 100, max = 99999)
    private Short vehWidth;
    @Size(min = 100, max = 99999)
    private Short vehHeight;

    @Length(min = 0, max = 1000)
    private String remark;

    private Corporation corp;

    public Tractor() {
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo == null ? null : plateNo.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public String getVehBrand() {
        return vehBrand;
    }

    public void setVehBrand(String vehBrand) {
        this.vehBrand = vehBrand == null ? null : vehBrand.trim();
    }

    public String getVehModel() {
        return vehModel;
    }

    public void setVehModel(String vehModel) {
        this.vehModel = vehModel == null ? null : vehModel.trim();
    }

    public Short getPower() {
        return power;
    }

    public void setPower(Short power) {
        this.power = power;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin == null ? null : vin.trim();
    }

    public String getDrvLisn() {
        return drvLisn;
    }

    public void setDrvLisn(String drvLisn) {
        this.drvLisn = drvLisn == null ? null : drvLisn.trim();
    }

    public String getLogiLisn() {
        return logiLisn;
    }

    public void setLogiLisn(String logiLisn) {
        this.logiLisn = logiLisn == null ? null : logiLisn.trim();
    }

    public Long getIsrnDtlId() {
        return isrnDtlId;
    }

    public void setIsrnDtlId(Long isrnDtlId) {
        this.isrnDtlId = isrnDtlId;
    }

    public Date getPrdtDate() {
        return prdtDate;
    }

    public void setPrdtDate(Date prdtDate) {
        this.prdtDate = prdtDate;
    }

    public Date getPucsDate() {
        return pucsDate;
    }

    public void setPucsDate(Date pucsDate) {
        this.pucsDate = pucsDate;
    }

    public String getLisnDate() {
        return lisnDate;
    }

    public void setLisnDate(String lisnDate) {
        this.lisnDate = lisnDate;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo == null ? null : chassisNo.trim();
    }

    public EmsStdType getEmsStd() {
        return emsStd;
    }

    public void setEmsStd(EmsStdType emsStd) {
        this.emsStd = emsStd;
    }

    public Short getVehLength() {
        return vehLength;
    }

    public void setVehLength(Short vehLength) {
        this.vehLength = vehLength;
    }

    public Short getVehWidth() {
        return vehWidth;
    }

    public void setVehWidth(Short vehWidth) {
        this.vehWidth = vehWidth;
    }

    public Short getVehHeight() {
        return vehHeight;
    }

    public void setVehHeight(Short vehHeight) {
        this.vehHeight = vehHeight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Corporation getCorp() {
        return corp;
    }

    public void setCorp(Corporation corp) {
        this.corp = corp;
    }
}