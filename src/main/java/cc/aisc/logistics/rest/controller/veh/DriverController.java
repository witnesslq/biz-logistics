package cc.aisc.logistics.rest.controller.veh;

import cc.aisc.commons.base.AbstractController;
import cc.aisc.commons.response.Response;
import cc.aisc.logistics.model.veh.Driver;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by sjf on 16-6-16.
 */
@RestController
public class DriverController extends AbstractController<Driver, Long> implements IDriverController {

    private final static String PATH_VEH = "/veh";
    private final static String PATH_END = "/drivers";

    @Override
    @RequestMapping(value = PATH_VEH + PATH_END + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> getById(@PathVariable("id") Long aLong) throws Exception {
        return super.getById(aLong);
    }

    @Override
    @RequestMapping(value = PATH_VEH + PATH_END + "/query", method = RequestMethod.GET)
    public ResponseEntity<Response> find(@RequestParam("param") Object o) throws Exception {
        return super.find(o);
    }

    @Override
    @RequestMapping(value = PATH_VEH + PATH_END, method = RequestMethod.GET)
    public ResponseEntity<Response> getByConditions(@RequestBody(required = false) Driver record, @RequestParam int page, @RequestParam int size) throws Exception {
        return super.getByConditions(record, page, size);
    }

    @Override
    @RequestMapping(value = PATH_VEH + PATH_END, method = RequestMethod.POST)
    public ResponseEntity<Response> add(@Valid @RequestBody(required = true) Driver record, BindingResult result) throws Exception {
        return super.add(record, result);
    }

    @Override
    @RequestMapping(value = PATH_VEH + PATH_END, method = RequestMethod.PUT)
    public ResponseEntity<Response> update(@Valid @RequestBody(required = true) Driver record, BindingResult result) throws Exception {
        return super.update(record, result);
    }

    @Override
    @RequestMapping(value = PATH_VEH + PATH_END + "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable("id") Long aLong) throws Exception {
        return super.delete(aLong);
    }
}
