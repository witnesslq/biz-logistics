package cc.aisc.logistics.service.biz.trspt;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.model.biz.trspt.*;
import cc.aisc.logistics.model.biz.trspt.Process;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 16-5-17.
 */
@Service
@Transactional
public class ProcessServiceImpl extends AbstractService<Process, Long> implements ProcessService {
}
