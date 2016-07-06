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

    @Override
    public int delete(Long aLong) {
        return super.delete(aLong);
    }

    @Override
    public int insert(StandardDistance record) {
        return super.insert(record);
    }

    @Override
    public int insertSelective(StandardDistance record) {
        return super.insertSelective(record);
    }

    @Override
    public Optional<StandardDistance> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Optional<? extends Collection<StandardDistance>> findBySelective(Object o) {
        return super.findBySelective(o);
    }

    @Override
    public int updateSelective(StandardDistance record) {
        return super.updateSelective(record);
    }

    @Override
    public int updateWithBlobs(StandardDistance record) {
        return super.updateWithBlobs(record);
    }

    @Override
    public int update(StandardDistance record) {
        return super.update(record);
    }

    @Override
    public Optional<? extends Collection<StandardDistance>> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<? extends Collection<StandardDistance>> findByConditions(StandardDistance con) {
        return super.findByConditions(con);
    }
}
