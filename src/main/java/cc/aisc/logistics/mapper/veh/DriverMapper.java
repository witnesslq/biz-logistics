package cc.aisc.logistics.mapper.veh;

import cc.aisc.commons.base.BaseMapper;
import cc.aisc.logistics.model.veh.Driver;

import java.util.List;

public interface DriverMapper extends BaseMapper<Driver, Long>{
    List<Driver> selectByMultiConditioned(Driver con);
}