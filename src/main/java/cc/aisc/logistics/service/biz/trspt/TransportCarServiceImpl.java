package cc.aisc.logistics.service.biz.trspt;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.biz.trspt.TransportCarMapper;
import cc.aisc.logistics.model.biz.trspt.TransportCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 16-5-17.
 */
@Service
@Transactional
public class TransportCarServiceImpl extends AbstractService<TransportCar, Long> implements TransportCarService {

    @Autowired
    private TransportCarMapper transportCarMapper;

    @Override
    public int delete(TransportCar record) {
        return transportCarMapper.deleteByPrimaryKey(record);
    }
}
