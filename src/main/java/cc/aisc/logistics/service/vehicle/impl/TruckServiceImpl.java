package cc.aisc.logistics.service.vehicle.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.vehicle.TruckMapper;
import cc.aisc.logistics.model.vehicle.Truck;
import cc.aisc.logistics.service.vehicle.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by sjf on 16-5-10.
 */
@Service
@Transactional
public class TruckServiceImpl extends AbstractService<Truck, Long> implements TruckService {
    @Autowired
    private TruckMapper truckMapper;
    @Override
    public Optional<List<Truck>> findByConditions(Truck con) {
        return Optional.ofNullable(truckMapper.selectByMultiConditioned(con));
    }

    @Override
    public Optional<List<Map<String, Object>>> findByNested(Map<String, String> con) {
        return Optional.ofNullable(truckMapper.selectByNestedInfo(con));
    }
}
