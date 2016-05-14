package cc.aisc.logistics.service.vehicle.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.vehicle.TruckMapper;
import cc.aisc.logistics.model.veh.Truck;
import cc.aisc.logistics.model.veh.type.DriverStatus;
import cc.aisc.logistics.model.veh.type.VehicleStatus;
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

    @Override
    public Truck currentlyInUse(Long id) {
        Truck record = truckMapper.selectByPrimaryKey(id);
        if (record != null
                && (record.getTractor().getStatus().equals(VehicleStatus.SERVING)
                && record.getTrailer().getStatus().equals(VehicleStatus.SERVING)
                && record.getDriver().getStatus().equals(DriverStatus.SERVING)))
            return record;
        else
            return null;
    }

    @Override
    public Truck setAvailable(Long id) {
        Truck record = truckMapper.selectByPrimaryKey(id);
        if (record != null
                && (record.getTractor().getStatus().equals(VehicleStatus.SERVING)
                && record.getTrailer().getStatus().equals(VehicleStatus.SERVING)
                && record.getDriver().getStatus().equals(DriverStatus.SERVING))) {
            record.setAvailable(true);
            truckMapper.updateByPrimaryKeySelective(record);
            return record;
        }
        return null;
    }

    @Override
    public Truck setNotAvailable(Long id) {
        Truck record = truckMapper.selectByPrimaryKey(id);
        if (record != null){
            record.setAvailable(false);
            truckMapper.updateByPrimaryKeySelective(record);
            return record;
        }
        return null;
    }
}
