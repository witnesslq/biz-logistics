package cc.aisc.logistics.service.biz;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.biz.CarMapper;
import cc.aisc.logistics.mapper.biz.WaybillMapper;
import cc.aisc.logistics.model.biz.Car;
import cc.aisc.logistics.model.biz.Waybill;
import cc.aisc.logistics.model.biz.type.CarStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-5-14.
 */
@Service
@Transactional
public class WaybillServiceImpl extends AbstractService<Waybill, Long> implements WaybillService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WaybillService.class);

    @Autowired
    private WaybillMapper waybillMapper;
    @Autowired
    private CarMapper carMapper;

    @Override
    public int insertWithCars(Waybill wb) {
        int i = waybillMapper.insert(wb);
        List<Car> cars = wb.getCars();
        for (Car car : cars){
            car.setWbId(wb.getId());
            car.setStatus(CarStatus.PENDING);
            car.setCurrLoc(wb.getLoadLoc());
            car.setDestLoc(wb.getUldLoc());
        }
        carMapper.insertBatch(cars);
        return i;
    }

    @Override
    public Optional<Waybill> getDetailsWithCars(Long id) {
        return Optional.ofNullable(waybillMapper.selectDetailedWithCarsBySelective(id).get(0));
    }


}

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
