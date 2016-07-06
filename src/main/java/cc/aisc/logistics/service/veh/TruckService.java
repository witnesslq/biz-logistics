package cc.aisc.logistics.service.veh;

import cc.aisc.commons.base.BaseService;
import cc.aisc.logistics.model.veh.Truck;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by sjf on 16-4-27.
 */
public interface TruckService extends BaseService<Truck, Long> {
    Optional<List<Map<String, Object>>> findByNested(Map<String,String> con);
    Truck currentlyInUse(Long id);
    Truck setAvailable(Long id);
    Truck setNotAvailable(Long id);
}
