package cc.aisc.logistics.service.sys;

import cc.aisc.commons.base.BaseService;
import cc.aisc.logistics.model.sys.Category;
import cc.aisc.logistics.model.sys.type.CategoryType;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-5-13.
 */
public interface CategoryService extends BaseService<Category, Long> {
    Optional<List<Category>> findAllByType(CategoryType type);
}
