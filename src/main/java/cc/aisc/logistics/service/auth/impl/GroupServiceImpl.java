package cc.aisc.logistics.service.auth.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.auth.GroupMapper;
import cc.aisc.logistics.mapper.auth.RoleMapper;
import cc.aisc.logistics.model.auth.Group;
import cc.aisc.logistics.model.auth.Role;
import cc.aisc.logistics.service.auth.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-7-4.
 */
@Service
@Transactional
public class GroupServiceImpl extends AbstractService<Group, Long> implements GroupService {

    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private RoleMapper roleMapper;

    public List<Role> getRoles(Long groupId) throws Exception{
        List<Role> list = new ArrayList<>();
        Optional<Group> record = Optional.ofNullable(groupMapper.selectByPrimaryKey(groupId));
        if (record.isPresent()) {
            int size = record.get().getRoleIds().size();
            for (int i = 0; i < size; i++){
                list.add(roleMapper.selectByPrimaryKey(record.get().getRoleIds().get(i)));
            }
        }
        return list;
    }
}
