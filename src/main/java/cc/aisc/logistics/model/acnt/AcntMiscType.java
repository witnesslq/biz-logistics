package cc.aisc.logistics.model.acnt;

import java.util.Date;

/**
 * Created by sjf on 16-8-5.
 * 结算杂项类型
 * 包含：带路费，洗车费，修理费，停车费，装车费，罚款，倒板费，绕路费，待令补贴，多点交车，交进口车......
 */
public class AcntMiscType {

    private Long id;
    private String typeNam;
    private String typeIdx;
    private String description;
    private Boolean isPublic;
    private Long createBy;
    private Date createAt;

}
