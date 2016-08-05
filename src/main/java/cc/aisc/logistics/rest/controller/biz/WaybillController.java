package cc.aisc.logistics.rest.controller.biz;

import cc.aisc.commons.base.AbstractController;
import cc.aisc.commons.exception.DataBindingException;
import cc.aisc.commons.response.Response;
import cc.aisc.logistics.model.biz.Car;
import cc.aisc.logistics.model.biz.Waybill;
import cc.aisc.logistics.service.biz.CarService;
import cc.aisc.logistics.service.biz.WaybillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by sjf on 16-6-16.
 */
@RestController
public class WaybillController extends AbstractController<Waybill, Long> implements IWaybillController {

    @Autowired
    private WaybillService waybillService;

    @Override
    @RequestMapping(value = PATH_BIZ_WAYBILL + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> getById(@PathVariable("id") Long aLong) throws Exception {
        return super.getById(aLong);
    }


    @RequestMapping(value = PATH_BIZ_WAYBILL + PATH_QUERY, method = RequestMethod.GET)
    public ResponseEntity<Response> findList(@RequestParam HashMap<String, Object> o) throws Exception {
        return find(o);
    }

    @RequestMapping(value = PATH_BIZ_WAYBILL, method = RequestMethod.GET)
    public ResponseEntity<Response> getList(@RequestParam HashMap<String, Object> o) throws Exception {
        return getDetails(o);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = PATH_BIZ_WAYBILL + "/{id}/cars", method = RequestMethod.GET)
    public ResponseEntity<Response> getWithCars(@PathVariable("id") Long id) throws Exception {
        Optional records =  waybillService.getDetailsWithCars(id);
        if(!records.isPresent())
            throw new NoSuchElementException("无数据");
        HashMap map = new HashMap();
        map.put("totalItems", 1);
        map.put("data", records.get());
        return ResponseEntity.ok(new Response(100001, true, false, "查询成功", map));
    }

    @Override
    @RequestMapping(value = PATH_BIZ_WAYBILL, method = RequestMethod.POST)
    public ResponseEntity<Response> add(@Valid @RequestBody(required = true) Waybill record, BindingResult result) throws Exception {
        if(result.hasErrors()) {
            throw new DataBindingException(result);
        } else {
            this.waybillService.insertWithCars(record);
            return ResponseEntity.ok(new Response(100003, true, true, "添加成功", record));
        }
    }

    @Override
    @RequestMapping(value = PATH_BIZ_WAYBILL, method = RequestMethod.PUT)
    public ResponseEntity<Response> update(@Valid @RequestBody(required = true) Waybill record, BindingResult result) throws Exception {
        return super.update(record, result);
    }

    @Override
    @RequestMapping(value = PATH_BIZ_WAYBILL + "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable("id") Long aLong) throws Exception {
        return super.delete(aLong);
    }
}
