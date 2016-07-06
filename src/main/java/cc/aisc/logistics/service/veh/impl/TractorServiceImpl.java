package cc.aisc.logistics.service.veh.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.veh.TractorMapper;
import cc.aisc.logistics.model.veh.Tractor;
import cc.aisc.logistics.model.veh.type.VehicleStatus;
import cc.aisc.logistics.service.veh.TractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 16-5-10.
 */
@Service
@Transactional
public class TractorServiceImpl extends AbstractService<Tractor, Long> implements TractorService {

    @Autowired
    private TractorMapper tractorMapper;


    @Override
    public boolean changeStatus(Long id, VehicleStatus status) {
        Tractor record = tractorMapper.selectByPrimaryKey(id);
        record.setStatus(status);
        return tractorMapper.updateByPrimaryKeySelective(record) > 0;
    }
}
