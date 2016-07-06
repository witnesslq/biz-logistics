package cc.aisc.logistics.service.biz;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.biz.WaybillMapper;
import cc.aisc.logistics.model.biz.Waybill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-5-14.
 */
@Service
@Transactional
public class WaybillServiceImpl extends AbstractService<Waybill, Long> implements WaybillService {

    @Autowired
    private WaybillMapper waybillMapper;

    /*@Override
    //@CacheEvict(value = "deleteWaybillCache", keyGenerator = "redisKeyGenerator")
    public int delete(Long aLong) {
        return super.delete(aLong);
    }

    @Override
    //@CachePut(value = "insertWaybillCache", keyGenerator = "redisKeyGenerator")
    public int insert(Waybill record) {
        return super.insert(record);
    }

    @Override
    //@CachePut(value = "insertSelectiveWaybillCache", keyGenerator = "redisKeyGenerator")
    public int insertSelective(Waybill record) {
        return super.insertSelective(record);
    }

    @Override
    @Transactional(readOnly = true)
    //@Cacheable(value = "findWaybillByIdCache", keyGenerator = "redisKeyGenerator")
    public Optional<Waybill> findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    @Transactional(readOnly = true)
    //@Cacheable(value = "findWaybillBySelectiveCache", keyGenerator = "redisKeyGenerator")
    public Optional<? extends Collection<Waybill>> findBySelective(Object o) {
        return super.findBySelective(o);
    }

    @Override
    //@CachePut(value = "updateSelectiveWaybillCache", keyGenerator = "redisKeyGenerator")
    public int updateSelective(Waybill record) {
        return super.updateSelective(record);
    }

    @Override
    //@CachePut(value = "updateWithBlobsWaybillCache", keyGenerator = "redisKeyGenerator")
    public int updateWithBlobs(Waybill record) {
        return super.updateWithBlobs(record);
    }

    @Override
    //@CachePut(value = "updateWaybillCache", keyGenerator = "redisKeyGenerator")
    public int update(Waybill record) {
        return super.update(record);
    }

    @Override
    @Transactional(readOnly = true)
    //@Cacheable(value = "findAllWaybillCache", keyGenerator = "redisKeyGenerator")
    public Optional<? extends Collection<Waybill>> findAll() {
        return super.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    //@Cacheable(value = "findWaybillByConditionsCache", keyGenerator = "redisKeyGenerator")
    public Optional<? extends Collection<Waybill>> findByConditions(Waybill con) {
        return super.findByConditions(con);
    }*/
}
