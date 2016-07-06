package cc.aisc.logistics.service.sys.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.model.sys.Resource;
import cc.aisc.logistics.service.sys.ResourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 16-7-4.
 */
@Service
@Transactional
public class ResourceServiceImpl extends AbstractService<Resource, Long> implements ResourceService {
}
