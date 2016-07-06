package cc.aisc.logistics.mapper.veh;

import cc.aisc.commons.base.BaseMapper;
import cc.aisc.logistics.model.veh.Tractor;

import java.util.List;

public interface TractorMapper extends BaseMapper<Tractor, Long> {
    List<Tractor> selectByMultiConditioned(Tractor con);
}