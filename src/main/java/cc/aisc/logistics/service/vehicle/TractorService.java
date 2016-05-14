package cc.aisc.logistics.service.vehicle;

import cc.aisc.commons.base.BaseService;
import cc.aisc.logistics.model.veh.Tractor;
import cc.aisc.logistics.model.veh.type.VehicleStatus;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-4-26.
 */
public interface TractorService extends BaseService<Tractor, Long> {
    Optional<List<Tractor>> findByConditions(Tractor con);
    boolean changeStatus(Long id, VehicleStatus status);
}
