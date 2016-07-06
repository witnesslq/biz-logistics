package cc.aisc.logistics.service.veh;

import cc.aisc.commons.base.BaseService;
import cc.aisc.logistics.model.veh.Trailer;
import cc.aisc.logistics.model.veh.type.VehicleStatus;

/**
 * Created by sjf on 16-4-26.
 */
public interface TrailerService extends BaseService<Trailer, Long> {
    boolean changeStatus(Long id, VehicleStatus status);
}
