package cc.aisc.logistics.service.vehicle.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.vehicle.TractorMapper;
import cc.aisc.logistics.model.veh.Tractor;
import cc.aisc.logistics.model.veh.type.VehicleStatus;
import cc.aisc.logistics.service.vehicle.TractorService;
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
public class TractorServiceImpl extends AbstractService<Tractor, Long> implements TractorService {

    @Autowired
    private TractorMapper tractorMapper;

    @Override
    public Optional<List<Tractor>> findByConditions(Tractor con) {
        return Optional.ofNullable(tractorMapper.selectByMultiConditioned(con));
    }

    @Override
    public boolean changeStatus(Long id, VehicleStatus status) {
        Tractor record = tractorMapper.selectByPrimaryKey(id);
        record.setStatus(status);
        return tractorMapper.updateByPrimaryKeySelective(record) > 0;
    }
}
