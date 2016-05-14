package cc.aisc.logistics.service.biz;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.biz.WaybillMapper;
import cc.aisc.logistics.model.biz.Waybill;
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

    @Autowired
    private WaybillMapper waybillMapper;

    @Override
    public Optional<List<Waybill>> findByConditions(Waybill con) {
        return Optional.ofNullable(waybillMapper.selectByMultiConditioned(con));
    }
}
