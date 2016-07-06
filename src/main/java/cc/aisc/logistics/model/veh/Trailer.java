package cc.aisc.logistics.model.veh;

import cc.aisc.logistics.model.corp.Corporation;
import cc.aisc.logistics.model.veh.type.TrailerType;
import cc.aisc.logistics.model.veh.type.VehicleStatus;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class Trailer {

    private Long id;

    @Length(min = 12, max = 20)
    private String vin;

    @Length(min = 6, max = 12)
    private String plateNo;

    @Length(min = 12, max = 20)
    private String drvLisn;

    @Length(min = 2, max = 20)
    private String manufacturer;

    @Length(min = 2, max = 20)
    private String vehBrand;

    @Length(min = 2, max = 20)
    private String vehModel;

    @Min(1)
    @Max(99)
    private Integer slotAmt;

    private TrailerType slotType;

    private TrailerType frameType;

    @Length(min = 2, max = 20)
    private String bridge;

    private TrailerType tyreType;

    private TrailerType liftType;

    @Past
    private Date mnftrDate;

    @Past
    private Date pucsDate;

    @Length(min = 2, max = 4)
    private String yearInuse;

    @Min(100)
    @Max(99999)
    private Short vehLenght;

    @Min(100)
    @Max(99999)
    private Short vehWidth;

    @Min(100)
    @Max(99999)
    private Short vehHeight;

    @Length(min = 0, max = 1000)
    private String remark;

    private Corporation corp;

    private VehicleStatus status;

    public Trailer() {
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

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin == null ? null : vin.trim();
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo == null ? null : plateNo.trim();
    }

    public String getDrvLisn() {
        return drvLisn;
    }

    public void setDrvLisn(String drvLisn) {
        this.drvLisn = drvLisn == null ? null : drvLisn.trim();
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

    public Integer getSlotAmt() {
        return slotAmt;
    }

    public void setSlotAmt(Integer slotAmt) {
        this.slotAmt = slotAmt;
    }

    public TrailerType getSlotType() {
        return slotType;
    }

    public void setSlotType(TrailerType slotType) {
        this.slotType = slotType;
    }

    public TrailerType getFrameType() {
        return frameType;
    }

    public void setFrameType(TrailerType frameType) {
        this.frameType = frameType;
    }

    public String getBridge() {
        return bridge;
    }

    public void setBridge(String bridge) {
        this.bridge = bridge == null ? null : bridge.trim();
    }

    public TrailerType getTyreType() {
        return tyreType;
    }

    public void setTyreType(TrailerType tyreType) {
        this.tyreType = tyreType;
    }

    public TrailerType getLiftType() {
        return liftType;
    }

    public void setLiftType(TrailerType liftType) {
        this.liftType = liftType;
    }

    public Date getMnftrDate() {
        return mnftrDate;
    }

    public void setMnftrDate(Date mnftrDate) {
        this.mnftrDate = mnftrDate;
    }

    public Date getPucsDate() {
        return pucsDate;
    }

    public void setPucsDate(Date pucsDate) {
        this.pucsDate = pucsDate;
    }

    public String getYearInuse() {
        return yearInuse;
    }

    public void setYearInuse(String yearInuse) {
        this.yearInuse = yearInuse;
    }

    public Short getVehLenght() {
        return vehLenght;
    }

    public void setVehLenght(Short vehLenght) {
        this.vehLenght = vehLenght;
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
