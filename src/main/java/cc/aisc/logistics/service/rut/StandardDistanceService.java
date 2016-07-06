package cc.aisc.logistics.service.rut;

import cc.aisc.commons.base.BaseService;
import cc.aisc.logistics.model.rut.StandardDistance;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Optional;

/**
 * Created by sjf on 16-5-12.
 */
public interface StandardDistanceService extends BaseService<StandardDistance, Long> {
    Optional<BigDecimal> findDistByIds(Long dept, Long dest, Long com);
}
