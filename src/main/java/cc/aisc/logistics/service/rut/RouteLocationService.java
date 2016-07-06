package cc.aisc.logistics.service.rut;

import cc.aisc.commons.base.BaseService;
import cc.aisc.logistics.model.rut.RouteLocation;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-5-11.
 */
public interface RouteLocationService extends BaseService<RouteLocation, Long>{
    Optional<List<RouteLocation>> findByLblName(String lblName);
}
