package cc.aisc.logistics.mapper.vehicle;

import cc.aisc.commons.base.BaseMapper;
import cc.aisc.logistics.model.vehicle.Trailer;

import java.util.List;

public interface TrailerMapper extends BaseMapper<Trailer, Long> {
    List<Trailer> selectByMultiConditioned(Trailer con);
}