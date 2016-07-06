package cc.aisc.logistics.service.rut.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.rut.RouteLocationMapper;
import cc.aisc.logistics.model.rut.RouteLocation;
import cc.aisc.logistics.service.rut.RouteLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-5-11.
 */
@Service
@Transactional
public class RouteLocationServiceImpl extends AbstractService<RouteLocation, Long> implements RouteLocationService {

    @Autowired
    private RouteLocationMapper routeLocationMapper;

    @Override
    public Optional<List<RouteLocation>> findByLblName(String lblName) {
        return Optional.ofNullable(routeLocationMapper.selectByLblName(lblName));
    }
}
