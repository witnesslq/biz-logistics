package cc.aisc.logistics.model.vehicle;

import cc.aisc.logistics.model.type.Constant;
import cc.aisc.logistics.model.vehicle.type.TrailerType;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class Trailer {
    private Long id;
    @Length(min = 12, max = 20)
    private String vin = "VIN-1234567890";
    @Length(min = 6, max = 12)
    private String plateNo = "PLATE-12345";
    @Length(min = 12, max = 20)
    private String drvLisn = "DRV_LISN-12345";
    @Length(min = 2, max = 20)
    private String manufacturer = "MANUFACTURER";
    @Length(min = 2, max = 20)
    private String vehBrand = "BRAND";
    @Length(min = 2, max = 20)
    private String vehModel = "MODEL";
    @Size(min = 0, max = 99)
    private Integer slotAmt = 8;

    private TrailerType slotType = TrailerType.SLOT_1;

    private TrailerType frameType = TrailerType.FRAME_1;
    @Length(min = 2, max = 20)
    private String bridge = "BRIDGE";

    private TrailerType tyreType = TrailerType.TYRE_1;

    private TrailerType liftType = TrailerType.LIFT_1;
    @Past
    private Date mnftrDate = Constant.PAST_DATE;
    @Past
    private Date pucsDate = Constant.PAST_DATE;
    @Length(min = 2, max = 4)
    private String yearInuse = "2010";
    @Size(min = 100, max = 99999)
    private Short vehLenght = 10000;
    @Size(min = 100, max = 99999)
    private Short vehWidth = 2800;
    @Size(min = 100, max = 99999)
    private Short vehHeight = 2800;
    @Length(min = 0, max = 1000)
    private String remark = "";

    private Long belongComid = 0L;

    public Trailer() {
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

    public Long getBelongComid() {
        return belongComid;
    }

    public void setBelongComid(Long belongComid) {
        this.belongComid = belongComid;
    }
}