package cc.aisc.logistics.model.vehicle;

import cc.aisc.logistics.model.vehicle.type.EmsStdType;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class Tractor {

    private Long id;

    @Length(min = 6, max = 12)
    private String plateNo = "PLATE";
    @Length(min = 2, max = 20)
    private String manufacturer = "MANUFACTURER";
    @Length(min = 2, max = 20)
    private String vehBrand = "BRAND";
    @Length(min = 2, max = 20)
    private String vehModel = "MODEL";
    @Size(min = 1, max = 999)
    private Short power = 240;

    private String style = "STYLE-1";

    @Length(min = 12, max = 20)
    private String vin = "VIN-1234567890";

    @Length(min = 12, max = 20)
    private String drvLisn = "DRV_LISN-12345";

    @Length(min = 12, max = 20)
    private String logiLisn = "LOGI_LISN-12345";

    private Long isrnDtlId = 0L;

    @Past
    private Date prdtDate = cc.aisc.logistics.model.type.Constant.PAST_DATE;

    @Past
    private Date pucsDate = cc.aisc.logistics.model.type.Constant.PAST_DATE;

    @Length(min = 2, max = 4)
    private String lisnDate = "1980";

    @Length(min = 12, max = 20)
    private String chassisNo = "CHASSIS-12345";

    private EmsStdType emsStd = EmsStdType.GB_IV;

    @Size(min = 100, max = 99999)
    private Short vehLength = 10000;
    @Size(min = 100, max = 99999)
    private Short vehWidth = 2800;
    @Size(min = 100, max = 99999)
    private Short vehHeight = 2800;

    @Length(min = 0, max = 1000)
    private String remark = "";

    private Long belongComid = 0L;

    public Tractor() {
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

    public Long getBelongComid() {
        return belongComid;
    }

    public void setBelongComid(Long belongComid) {
        this.belongComid = belongComid;
    }
}