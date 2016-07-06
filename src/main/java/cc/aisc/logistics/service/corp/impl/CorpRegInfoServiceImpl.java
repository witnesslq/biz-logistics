package cc.aisc.logistics.service.corp.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.corp.CorpRegInfoMapper;
import cc.aisc.logistics.model.corp.CorpRegInfo;
import cc.aisc.logistics.service.corp.CorpRegInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-5-14.
 */
@Service
@Transactional
public class CorpRegInfoServiceImpl extends AbstractService<CorpRegInfo, Long> implements CorpRegInfoService {

    @Autowired
    private CorpRegInfoMapper corpRegInfoMapper;

}
