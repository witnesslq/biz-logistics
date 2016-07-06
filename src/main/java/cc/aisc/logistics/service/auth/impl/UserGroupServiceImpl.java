package cc.aisc.logistics.service.auth.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.model.auth.UserGroup;
import cc.aisc.logistics.service.auth.UserGroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 16-7-4.
 */
@Service
@Transactional
public class UserGroupServiceImpl extends AbstractService<UserGroup, Long> implements UserGroupService {
}
