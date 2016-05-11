package cc.aisc.logistics.model.vehicle;

import cc.aisc.logistics.model.vehicle.type.LicenseType;
import cc.aisc.logistics.model.vehicle.type.DriverStatus;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Driver {
    private Long id;

    @NotBlank
    @Length(min = 2, max = 12)
    private String name = "NOBODY";

    @NotBlank
    @Length(min = 12, max = 20)
    private String license = "LICENSE-NO";

    private LicenseType lisnType = LicenseType.A2;

    @Length(min = 10, max = 16)
    private String mobile = "MOBILE-NO1";


    private DriverStatus status = DriverStatus.SERVING;

    private Long personId = 0L;

    private Long belongComid = 0L;

    public Driver() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license == null ? null : license.trim();
    }

    public LicenseType getLisnType() {
        return lisnType;
    }

    public void setLisnType(LicenseType lisnType) {
        this.lisnType = lisnType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getBelongComid() {
        return belongComid;
    }

    public void setBelongComid(Long belongComid) {
        this.belongComid = belongComid;
    }
}