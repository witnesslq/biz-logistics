package cc.aisc.logistics.service.vehicle;

import cc.aisc.commons.base.BaseService;
import cc.aisc.logistics.model.vehicle.Driver;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-4-26.
 */
public interface DriverService extends BaseService<Driver, Long> {
    Optional<List<Driver>> findByConditions(Driver mc);
}
