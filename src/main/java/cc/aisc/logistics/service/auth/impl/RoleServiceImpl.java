package cc.aisc.logistics.service.auth.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.auth.RoleMapper;
import cc.aisc.logistics.model.auth.Permission;
import cc.aisc.logistics.model.auth.Role;
import cc.aisc.logistics.service.auth.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-7-4.
 */
@Service
@Transactional
public class RoleServiceImpl extends AbstractService<Role, Long> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public List<Permission> getPermissions(Long roleId) throws Exception{
        Optional<Role> record = Optional.ofNullable(roleMapper.selectByPrimaryKey(roleId));
        if (record.isPresent()) {
            return roleMapper.selectByPrimaryKey(roleId).getPermissions();
        }
        return null;
    }
}
