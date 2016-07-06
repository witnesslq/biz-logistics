package cc.aisc.logistics.service.biz;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.biz.CarMapper;
import cc.aisc.logistics.model.biz.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-5-17.
 */
@Service
@Transactional
public class CarServiceImpl extends AbstractService<Car, Long> implements CarService {
    @Autowired
    private CarMapper carMapper;
}
