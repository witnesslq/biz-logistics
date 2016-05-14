package cc.aisc.logistics.service.biz;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.biz.WbCarMapper;
import cc.aisc.logistics.model.biz.WbCar;
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
public class WbCarServiceImpl extends AbstractService<WbCar, Long> implements WbCarService {

    @Autowired
    private WbCarMapper wbCarMapper;

    @Override
    public Optional<List<WbCar>> findByConditions(WbCar con) {
        return Optional.ofNullable(wbCarMapper.selectByMultiConditioned(con));
    }
}
