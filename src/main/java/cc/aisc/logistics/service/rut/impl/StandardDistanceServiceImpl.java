package cc.aisc.logistics.service.rut.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.rut.StandardDistanceMapper;
import cc.aisc.logistics.model.rut.StandardDistance;
import cc.aisc.logistics.service.rut.StandardDistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

/**
 * Created by sjf on 16-5-12.
 */
@Service
@Transactional
public class StandardDistanceServiceImpl extends AbstractService<StandardDistance, Long>
        implements StandardDistanceService {

    @Autowired
    private StandardDistanceMapper standardDistanceMapper;

    @Override
    public Optional<BigDecimal> findDistByIds(Long dept, Long dest, Long com) {
        return Optional.ofNullable(standardDistanceMapper.selectDistByIds(dept,dest,com));
    }
}
