package cc.aisc.logistics.service.biz;

import cc.aisc.commons.base.BaseService;
import cc.aisc.logistics.model.biz.WbCar;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-5-14.
 */
public interface WbCarService extends BaseService<WbCar, Long> {
    Optional<List<WbCar>> findByConditions(WbCar con);
}
