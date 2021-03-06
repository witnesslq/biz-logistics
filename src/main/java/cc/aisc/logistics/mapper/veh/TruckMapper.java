package cc.aisc.logistics.mapper.veh;

import cc.aisc.commons.base.BaseMapper;
import cc.aisc.logistics.model.veh.Truck;

import java.util.List;
import java.util.Map;

public interface TruckMapper extends BaseMapper<Truck, Long> {
    List<Truck> selectByMultiConditioned(Truck con);
    List<Map<String, Object>> selectByNestedInfo(Map<String, String> con);
}