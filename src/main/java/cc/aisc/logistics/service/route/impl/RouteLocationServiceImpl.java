package cc.aisc.logistics.service.route.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.model.rt.RouteLocation;
import cc.aisc.logistics.service.route.RouteLocationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 16-5-11.
 */
@Service
@Transactional
public class RouteLocationServiceImpl extends AbstractService<RouteLocation, Long> implements RouteLocationService {
}
