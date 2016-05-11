package cc.aisc.logistics.service.vehicle;

import cc.aisc.commons.base.BaseService;
import cc.aisc.logistics.model.vehicle.Trailer;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-4-26.
 */
public interface TrailerService extends BaseService<Trailer, Long> {
    Optional<List<Trailer>> findByConditions(Trailer con);
}
