package cc.aisc.logistics.service.veh;

import cc.aisc.commons.base.BaseService;
import cc.aisc.logistics.model.veh.Tractor;
import cc.aisc.logistics.model.veh.type.VehicleStatus;

/**
 * Created by sjf on 16-4-26.
 */
public interface TractorService extends BaseService<Tractor, Long> {
    boolean changeStatus(Long id, VehicleStatus status);
}
