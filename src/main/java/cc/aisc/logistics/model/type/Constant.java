package cc.aisc.logistics.model.type;

import java.util.Calendar;
import java.util.Date;


/**
 * Created by sjf on 16-5-11.
 */
public abstract class Constant {

    private static final Calendar cp = Calendar.getInstance();
    private static final Calendar cf = Calendar.getInstance();

    static{
        cp.set(1980,Calendar.JANUARY,1,0,0,0);
        cf.set(2099,Calendar.DECEMBER,21,24,59,59);
    }

    public static final Date PAST_DATE = cp.getTime();
    public static final Date Future_DATE = cf.getTime();


}
