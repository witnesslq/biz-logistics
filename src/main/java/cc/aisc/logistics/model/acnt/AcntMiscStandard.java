package cc.aisc.logistics.model.acnt;

import cc.aisc.logistics.model.acnt.type.AccountUnit;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sjf on 16-8-5.
 * 杂项结算标准
 *
 */
public class AcntMiscStandard {

    private Long id;
    private AcntMiscType type;
    private AccountUnit unit;
    private BigDecimal unitPrice;
    private String remark;
    private Long createBy;
    private Long modifyBy;
    private Date createAt;
    private Date modifyAt;

}
