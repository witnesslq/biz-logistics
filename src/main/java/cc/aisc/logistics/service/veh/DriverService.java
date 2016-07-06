package cc.aisc.logistics.service.veh;

import cc.aisc.commons.base.BaseService;
import cc.aisc.logistics.model.veh.Driver;
import cc.aisc.logistics.model.veh.type.DriverStatus;

/**
 * Created by sjf on 16-4-26.
 */
public interface DriverService extends BaseService<Driver, Long> {
    boolean changeStatus(Long id, DriverStatus status);
}
