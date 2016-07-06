package cc.aisc.logistics.service.biz.trspt;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.biz.trspt.ScheduleMapper;
import cc.aisc.logistics.mapper.biz.trspt.TransportCarMapper;
import cc.aisc.logistics.model.biz.trspt.Schedule;
import cc.aisc.logistics.model.biz.trspt.type.ScheduleStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sjf on 16-5-17.
 */
@Service
@Transactional
public class ScheduleServiceImpl extends AbstractService<Schedule, Long> implements ScheduleService {
/*
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Autowired
    private TransportCarMapper transportCarMapper;

    @Override
    public Boolean addTask(Schedule schedule, List<Long> carIds) {
        schedule.setStatus(ScheduleStatus.CREATED);
        int ins = scheduleMapper.insert(schedule);

        return null;
    }*/
}
