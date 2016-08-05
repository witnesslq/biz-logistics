package cc.aisc.logistics.service.biz.trspt;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.model.biz.trspt.Schedule;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
