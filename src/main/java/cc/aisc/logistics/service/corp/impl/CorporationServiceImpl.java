package cc.aisc.logistics.service.corp.impl;

import cc.aisc.commons.base.AbstractService;
import cc.aisc.logistics.mapper.corp.CorporationMapper;
import cc.aisc.logistics.model.corp.Corporation;
import cc.aisc.logistics.service.corp.CorporationService;
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
public class CorporationServiceImpl extends AbstractService<Corporation, Long> implements CorporationService {

    @Autowired
    private CorporationMapper corporationMapper;
}
