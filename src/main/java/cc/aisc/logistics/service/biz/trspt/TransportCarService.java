package cc.aisc.logistics.service.biz.trspt;

import cc.aisc.commons.base.BaseService;
import cc.aisc.logistics.model.biz.trspt.TransportCar;

/**
 * Created by sjf on 16-5-17.
 */
public interface TransportCarService extends BaseService<TransportCar, Long> {
    int delete(TransportCar record);
}
