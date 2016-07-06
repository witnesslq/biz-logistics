package cc.aisc.logistics.service.veh.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.veh.TrailerMapper;
import cc.aisc.logistics.model.veh.Trailer;
import cc.aisc.logistics.model.veh.type.VehicleStatus;
import cc.aisc.logistics.service.veh.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 16-5-10.
 */
@Service
@Transactional
public class TrailerServiceImpl extends AbstractService<Trailer, Long> implements TrailerService {

    @Autowired
    private TrailerMapper trailerMapper;

    @Override
    public boolean changeStatus(Long id, VehicleStatus status) {
        Trailer record = trailerMapper.selectByPrimaryKey(id);
        record.setStatus(status);
        return trailerMapper.updateByPrimaryKeySelective(record) > 0;
    }
}
