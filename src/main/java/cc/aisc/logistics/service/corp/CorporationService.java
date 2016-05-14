package cc.aisc.logistics.service.corp;

import cc.aisc.commons.base.BaseService;
import cc.aisc.logistics.model.corp.Corporation;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-5-14.
 */
public interface CorporationService extends BaseService<Corporation, Long> {
    Optional<List<Corporation>> findByConditions(Corporation con);
}
