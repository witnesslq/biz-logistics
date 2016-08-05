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
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by sjf on 16-6-16.
 */
@RestController
public class StandardDistanceController extends AbstractController<StandardDistance, Long> implements IStandardDistanceController {

    @Autowired
    private StandardDistanceService standardDistanceService;

    @Override
    @RequestMapping(value = PATH_RUT_DISTANCE + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> getById(@PathVariable("id") Long aLong) throws Exception {
        return super.getById(aLong);
    }

    @RequestMapping(value = PATH_RUT_DISTANCE + PATH_QUERY, method = RequestMethod.GET)
    public ResponseEntity<Response> findList(@RequestParam HashMap<String, Object> o) throws Exception {
        return find(o);
    }

    @RequestMapping(value = PATH_RUT_DISTANCE, method = RequestMethod.GET)
    public ResponseEntity<Response> getList(@RequestParam HashMap<String, Object> o) throws Exception {
        return getDetails(o);
    }

    @Override
    @RequestMapping(value = PATH_RUT_DISTANCE, method = RequestMethod.POST)
    public ResponseEntity<Response> add(@Valid @RequestBody(required = true) StandardDistance record, BindingResult result) throws Exception {
        return super.add(record, result);
    }

    @Override
    @RequestMapping(value = PATH_RUT_DISTANCE, method = RequestMethod.PUT)
    public ResponseEntity<Response> update(@Valid @RequestBody(required = true) StandardDistance record, BindingResult result) throws Exception {
        return super.update(record, result);
    }

    @Override
    @RequestMapping(value = PATH_RUT_DISTANCE + "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable("id") Long aLong) throws Exception {
        return super.delete(aLong);
    }

    @RequestMapping(value = PATH_RUT_DISTANCE + "/dist", method = RequestMethod.GET)
    public ResponseEntity<Response> getDist(@RequestParam Long dept, @RequestParam Long dest, @RequestParam Long com) throws Exception {
        Optional<BigDecimal> dist = standardDistanceService.findDistByIds(dept,dest,com);
        if (!dist.isPresent())
            throw new NoSuchElementException("无数据");

        return ResponseEntity.ok(new Response(1, true, false, "", dist.get()));
    }

}
