package cc.aisc.logistics.service.sys.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.sys.MenuMapper;
import cc.aisc.logistics.model.sys.Menu;
import cc.aisc.logistics.service.sys.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-5-13.
 */
@Service
@Transactional
public class MenuServiceImpl extends AbstractService<Menu, Long> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Optional<List<Menu>> findByLevelLe(Integer lvl) {
        return Optional.ofNullable(menuMapper.selectAllByLevelLe(lvl));
    }
}
