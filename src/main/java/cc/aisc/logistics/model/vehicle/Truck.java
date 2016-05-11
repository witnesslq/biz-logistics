package cc.aisc.logistics.model.vehicle;

import cc.aisc.logistics.model.vehicle.type.VehicleStatus;

public class Truck {
    private Long id;

    private String itnlSn = "INTLSN-001";

    private Tractor tractor;

    private Trailer trailer;

    private Driver driver;

    private Driver codrv;

    private VehicleStatus status = VehicleStatus.ON_STAND_BY;

    private String remark = "";

    private String gpsNo = "";

    public Truck() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItnlSn() {
        return itnlSn;
    }

    public void setItnlSn(String itnlSn) {
        this.itnlSn = itnlSn == null ? null : itnlSn.trim();
    }

    public Tractor getTractor() {
        return tractor;
    }

    public void setTractor(Tractor tractor) {
        this.tractor = tractor;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Driver getCodrv() {
        return codrv;
    }

    public void setCodrv(Driver codrv) {
        this.codrv = codrv;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getGpsNo() {
        return gpsNo;
    }

    public void setGpsNo(String gpsNo) {
        this.gpsNo = gpsNo == null ? null : gpsNo.trim();
    }
}