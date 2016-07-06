package cc.aisc.logistics.rest.controller.sys;

import cc.aisc.commons.base.AbstractController;
import cc.aisc.commons.response.Response;
import cc.aisc.logistics.model.sys.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by sjf on 16-7-4.
 */
@RestController
public class ResourceController extends AbstractController<Resource, Long> implements IResourceController {
    private final static String PATH_PRE = "/sys";
    private final static String PATH_END = "/resources";

    @Override
    @RequestMapping(value = PATH_PRE + PATH_END + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> getById(@PathVariable("id") Long aLong) throws Exception {
        return super.getById(aLong);
    }

    @Override
    @RequestMapping(value = PATH_PRE + PATH_END + "/query", method = RequestMethod.GET)
    public ResponseEntity<Response> find(@RequestParam("param") Object o) throws Exception {
        return super.find(Long.valueOf((String)o));
    }

    @Override
    @RequestMapping(value = PATH_PRE + PATH_END, method = RequestMethod.GET)
    public ResponseEntity<Response> getByConditions(@RequestBody(required = false) Resource record, @RequestParam int page, @RequestParam int size) throws Exception {
        return super.getByConditions(record, page, size);
    }

    @Override
    @RequestMapping(value = PATH_PRE + PATH_END, method = RequestMethod.POST)
    public ResponseEntity<Response> add(@Valid @RequestBody(required = true) Resource record, BindingResult result) throws Exception {
        return super.add(record, result);
    }

    @Override
    @RequestMapping(value = PATH_PRE + PATH_END, method = RequestMethod.PUT)
    public ResponseEntity<Response> update(@Valid @RequestBody(required = true) Resource record, BindingResult result) throws Exception {
        return super.update(record, result);
    }

    @Override
    @RequestMapping(value = PATH_PRE + PATH_END + "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable("id") Long aLong) throws Exception {
        return super.delete(aLong);
    }
}
