package cc.aisc.logistics.service.auth.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.auth.GroupMapper;
import cc.aisc.logistics.mapper.auth.UserMapper;
import cc.aisc.logistics.model.auth.Group;
import cc.aisc.logistics.model.auth.User;
import cc.aisc.logistics.service.auth.UserService;
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
public class UserServiceImpl extends AbstractService<User, Long> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GroupMapper groupMapper;

    public List<Group> getGroups(Long userId) throws Exception{
        List<Group> list = new ArrayList<>();
        Optional<User> record = Optional.ofNullable(userMapper.selectByPrimaryKey(userId));
        if (record.isPresent()) {
            int size = record.get().getGroupIds().size();
            for (int i = 0; i < size; i++){
                list.add(groupMapper.selectByPrimaryKey(record.get().getGroupIds().get(i)));
            }
        }
        return list;
    }
}
