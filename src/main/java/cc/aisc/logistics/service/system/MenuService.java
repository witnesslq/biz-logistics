package cc.aisc.logistics.service.system;

import cc.aisc.commons.base.BaseService;
import cc.aisc.logistics.model.sys.Menu;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-5-13.
 */
public interface MenuService extends BaseService<Menu, Long> {
    Optional<List<Menu>> findByLevelLe(Integer lvl);
}
