package cc.aisc.logistics.service.biz;

import cc.aisc.commons.base.BaseService;
import cc.aisc.logistics.model.biz.Waybill;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-5-14.
 */
public interface WaybillService extends BaseService<Waybill, Long> {
    Optional<List<Waybill>> findByConditions(Waybill con);
}
