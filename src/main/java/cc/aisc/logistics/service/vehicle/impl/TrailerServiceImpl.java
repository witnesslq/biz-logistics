package cc.aisc.logistics.service.vehicle.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.vehicle.TrailerMapper;
import cc.aisc.logistics.model.vehicle.Trailer;
import cc.aisc.logistics.service.vehicle.TrailerService;
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
public class TrailerServiceImpl extends AbstractService<Trailer, Long> implements TrailerService {

    @Autowired
    private TrailerMapper trailerMapper;

    @Override
    public Optional<List<Trailer>> findByConditions(Trailer con) {
        return Optional.ofNullable(trailerMapper.selectByMultiConditioned(con));
    }
}
