package cc.aisc.logistics.service.sys.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.sys.CategoryMapper;
import cc.aisc.logistics.model.sys.Category;
import cc.aisc.logistics.model.sys.type.CategoryType;
import cc.aisc.logistics.service.sys.CategoryService;
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
public class CategoryServiceImpl extends AbstractService<Category, Long> implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public Optional<List<Category>> findAllByType(CategoryType type) {
        return Optional.ofNullable(categoryMapper.selectAllByType(type));
    }
}
