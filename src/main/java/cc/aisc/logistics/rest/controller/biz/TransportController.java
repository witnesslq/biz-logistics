package cc.aisc.logistics.rest.controller.biz;

import cc.aisc.commons.base.AbstractController;
import cc.aisc.commons.response.Response;
import cc.aisc.logistics.model.biz.trspt.Transport;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

/**
 * Created by sjf on 16-6-16.
 */
@RestController
public class TransportController extends AbstractController<Transport, Long> implements ITransportController {

    @Override
    @RequestMapping(value = PATH_BIZ_TRANSPORT + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> getById(@PathVariable("id") Long aLong) throws Exception {
        return super.getById(aLong);
    }

    @RequestMapping(value = PATH_BIZ_TRANSPORT + PATH_QUERY, method = RequestMethod.GET)
    public ResponseEntity<Response> findList(@RequestParam HashMap<String, Object> o) throws Exception {
        return find(o);
    }

    @RequestMapping(value = PATH_BIZ_TRANSPORT, method = RequestMethod.GET)
    public ResponseEntity<Response> getList(@RequestParam HashMap<String, Object> o) throws Exception {
        return getDetails(o);
    }

    @Override
    @RequestMapping(value = PATH_BIZ_TRANSPORT, method = RequestMethod.POST)
    public ResponseEntity<Response> add(@Valid @RequestBody(required = true) Transport record, BindingResult result) throws Exception {
        return super.add(record, result);
    }

    @Override
    @RequestMapping(value = PATH_BIZ_TRANSPORT, method = RequestMethod.PUT)
    public ResponseEntity<Response> update(@Valid @RequestBody(required = true) Transport record, BindingResult result) throws Exception {
        return super.update(record, result);
    }

    @Override
    @RequestMapping(value = PATH_BIZ_TRANSPORT + "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable("id") Long aLong) throws Exception {
        return super.delete(aLong);
    }
}
