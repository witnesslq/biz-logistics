package cc.aisc.logistics.rest.controller.biz;

import cc.aisc.commons.base.AbstractController;
import cc.aisc.commons.exception.InvalidParametersException;
import cc.aisc.commons.response.Response;
import cc.aisc.commons.utils.CollectionUtils;
import cc.aisc.logistics.model.biz.trspt.Schedule;
import cc.aisc.logistics.model.biz.type.ScheduleStatus;
import cc.aisc.logistics.model.veh.Truck;
import net.sf.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by sjf on 16-6-16.
 */
@RestController
public class ScheduleController extends AbstractController<Schedule, Long> implements IScheduleController {

    @Override
    @RequestMapping(value = PATH_BIZ_SCHEDULE + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> getById(@PathVariable("id") Long aLong) throws Exception {
        return super.getById(aLong);
    }

    /*
    * 以id作为参数查询
    * 参数类型 map<String,Long>  ("start", start) , ("end", end)
    * 代表开始id和结束id
    * */
    @RequestMapping(value = PATH_BIZ_SCHEDULE + PATH_QUERY, method = RequestMethod.GET)
    public ResponseEntity<Response> findByIdPage(@RequestParam HashMap<String, Object> o) throws Exception {
        String ps = String.valueOf(o.get("shdlId")).trim();  //var1 = searchId
        if (!ps.matches("^20[0-9]{0,10}"))
            throw new InvalidParametersException("参数无效");

        String start = ps;
        String end = ps;
        for (int i = 0; i < (12 - ps.length()); i++) {
            start += "0";
            end += "9";
        }
        o.remove("shdlId");
        o.put("start", Long.valueOf(start));
        o.put("end", Long.valueOf(end));
        return find(o);
    }

    @RequestMapping(value = PATH_BIZ_SCHEDULE, method = RequestMethod.GET)
    public ResponseEntity<Response> getList(@RequestParam HashMap<String, Object> o) throws Exception {
        return super.getDetails(o);
    }

    @Override
    @RequestMapping(value = PATH_BIZ_SCHEDULE, method = RequestMethod.POST)
    public ResponseEntity<Response> add(@Valid @RequestBody(required = true) Schedule record, BindingResult result) throws Exception {
        record.setStatus(ScheduleStatus.CREATED);
        return super.add(record, result);//TODO
    }

    @Override
    @RequestMapping(value = PATH_BIZ_SCHEDULE, method = RequestMethod.PUT)
    public ResponseEntity<Response> update(@Valid @RequestBody(required = true) Schedule record, BindingResult result) throws Exception {
        return super.update(record, result);
    }

    @Override
    @RequestMapping(value = PATH_BIZ_SCHEDULE + "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable("id") Long aLong) throws Exception {
        return super.delete(aLong);
    }

}
