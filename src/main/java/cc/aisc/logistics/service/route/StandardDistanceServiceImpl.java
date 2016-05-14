package cc.aisc.logistics.service.route;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.route.StandardDistanceMapper;
import cc.aisc.logistics.model.rt.StandardDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 16-5-12.
 */
@Service
@Transactional
public class StandardDistanceServiceImpl extends AbstractService<StandardDistance, Long>
        implements StandardDistanceService {

    @Autowired
    private StandardDistanceMapper standardDistanceMapper;

}
