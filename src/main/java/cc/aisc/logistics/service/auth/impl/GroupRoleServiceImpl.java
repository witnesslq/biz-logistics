package cc.aisc.logistics.service.auth.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.model.auth.GroupRole;
import cc.aisc.logistics.service.auth.GroupRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 16-7-4.
 */
@Service
@Transactional
public class GroupRoleServiceImpl extends AbstractService<GroupRole, Long> implements GroupRoleService {
}
