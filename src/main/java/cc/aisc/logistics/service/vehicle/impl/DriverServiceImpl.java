package cc.aisc.logistics.service.vehicle.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.vehicle.DriverMapper;
import cc.aisc.logistics.model.veh.Driver;
import cc.aisc.logistics.model.veh.type.DriverStatus;
import cc.aisc.logistics.service.vehicle.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-5-10.
 */
@Service
@Transactional
public class DriverServiceImpl extends AbstractService<Driver, Long> implements DriverService {

    @Autowired
    private DriverMapper driverMapper;

    @Override
    public Optional<List<Driver>> findByConditions(Driver mc) {
        return Optional.ofNullable(driverMapper.selectByMultiConditioned(mc));
    }

    @Override
    public boolean changeStatus(Long id, DriverStatus status) {
        Driver record = driverMapper.selectByPrimaryKey(id);
        record.setStatus(status);
        return driverMapper.updateByPrimaryKeySelective(record) > 0;
    }
}
