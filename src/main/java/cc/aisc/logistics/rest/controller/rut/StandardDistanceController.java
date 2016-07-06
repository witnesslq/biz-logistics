package cc.aisc.logistics.rest.controller.rut;

import cc.aisc.commons.base.AbstractController;
import cc.aisc.commons.response.Response;
import cc.aisc.logistics.model.rut.StandardDistance;
import cc.aisc.logistics.service.rut.StandardDistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by sjf on 16-6-16.
 */
@RestController
public class StandardDistanceController extends AbstractController<StandardDistance, Long> implements IStandardDistanceController {

    @Autowired
    private StandardDistanceService standardDistanceService;

    private final static String PATH_RUT = "/rut";
    private final static String PATH_END = "/standard-distances";

    @Override
    @RequestMapping(value = PATH_RUT + PATH_END + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> getById(@PathVariable("id") Long aLong) throws Exception {
        return super.getById(aLong);
    }

    @Override
    @RequestMapping(value = PATH_RUT + PATH_END + "/query", method = RequestMethod.GET)
    public ResponseEntity<Response> find(@RequestParam("param") Object o) throws Exception {
        return super.find(o);
    }

    @Override
    @RequestMapping(value = PATH_RUT + PATH_END, method = RequestMethod.GET)
    public ResponseEntity<Response> getByConditions(@RequestBody(required = false) StandardDistance record, @RequestParam int page, @RequestParam int size) throws Exception {
        return super.getByConditions(record, page, size);
    }

    @Override
    @RequestMapping(value = PATH_RUT + PATH_END, method = RequestMethod.POST)
    public ResponseEntity<Response> add(@Valid @RequestBody(required = true) StandardDistance record, BindingResult result) throws Exception {
        return super.add(record, result);
    }

    @Override
    @RequestMapping(value = PATH_RUT + PATH_END, method = RequestMethod.PUT)
    public ResponseEntity<Response> update(@Valid @RequestBody(required = true) StandardDistance record, BindingResult result) throws Exception {
        return super.update(record, result);
    }

    @Override
    @RequestMapping(value = PATH_RUT + PATH_END + "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable("id") Long aLong) throws Exception {
        return super.delete(aLong);
    }

    @RequestMapping(value = PATH_RUT + PATH_END + "/dist", method = RequestMethod.GET)
    public ResponseEntity<Response> getDist(@RequestParam Long dept, @RequestParam Long dest, @RequestParam Long com) throws Exception {
        Optional<BigDecimal> dist = standardDistanceService.findDistByIds(dept,dest,com);
        if (dist.isPresent()) {
            return ResponseEntity.ok(new Response(1, true, "", dist.get()));
        }else {
            throw new NoSuchElementException("无数据");
        }
    }

}
