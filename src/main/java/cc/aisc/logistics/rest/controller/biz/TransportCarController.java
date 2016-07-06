package cc.aisc.logistics.rest.controller.biz;

import cc.aisc.commons.base.AbstractController;
import cc.aisc.commons.response.Response;
import cc.aisc.logistics.model.biz.trspt.TransportCar;
import cc.aisc.logistics.service.biz.trspt.TransportCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by sjf on 16-6-16.
 */
@RestController
public class TransportCarController extends AbstractController<TransportCar, Long> implements ITransportCarController {

    @Autowired
    private TransportCarService transportCarService;

    private final static String PATH_BIZ = "/biz";
    private final static String PATH_END = "/transport-cars";

    @Override
    @RequestMapping(value = PATH_BIZ + PATH_END + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> getById(@PathVariable("id") Long aLong) throws Exception {
        return super.getById(aLong);
    }

    @Override
    @RequestMapping(value = PATH_BIZ + PATH_END + "/query", method = RequestMethod.GET)
    public ResponseEntity<Response> find(@RequestParam("param") Object o) throws Exception {
        return super.find(o);
    }

    @Override
    @RequestMapping(value = PATH_BIZ + PATH_END, method = RequestMethod.GET)
    public ResponseEntity<Response> getByConditions(@RequestBody(required = false) TransportCar record, @RequestParam int page, @RequestParam int size) throws Exception {
        return super.getByConditions(record, page, size);
    }

    @Override
    @RequestMapping(value = PATH_BIZ + PATH_END, method = RequestMethod.POST)
    public ResponseEntity<Response> add(@Valid @RequestBody(required = true) TransportCar record, BindingResult result) throws Exception {
        return super.add(record, result);
    }

    @Override
    @RequestMapping(value = PATH_BIZ + PATH_END, method = RequestMethod.PUT)
    public ResponseEntity<Response> update(@Valid @RequestBody(required = true) TransportCar record, BindingResult result) throws Exception {
        return super.update(record, result);
    }

    @RequestMapping(value = PATH_BIZ + PATH_END, method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@RequestBody TransportCar record) throws Exception {
        if (transportCarService.delete(record) > 0)
            return ResponseEntity.ok(new Response(1,true,"删除成功",null));
        else
            return ResponseEntity.ok(new Response(1,true,"删除失败",null));
    }
}
