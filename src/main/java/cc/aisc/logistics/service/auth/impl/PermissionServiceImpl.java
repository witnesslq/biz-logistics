package cc.aisc.logistics.service.auth.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.model.auth.Permission;
import cc.aisc.logistics.service.auth.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 16-7-6.
 */
@Service
@Transactional
public class PermissionServiceImpl extends AbstractService<Permission, Long> implements PermissionService {
}
