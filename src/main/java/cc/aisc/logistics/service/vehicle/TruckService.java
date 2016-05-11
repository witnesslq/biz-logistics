package cc.aisc.logistics.service.vehicle;

import cc.aisc.commons.base.BaseService;
import cc.aisc.logistics.model.vehicle.Truck;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by sjf on 16-4-27.
 */
public interface TruckService extends BaseService<Truck, Long> {
    Optional<List<Truck>> findByConditions(Truck con);
    Optional<List<Map<String, Object>>> findByNested(Map<String,String> con);
}
