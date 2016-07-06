package cc.aisc.logistics.rest.controller.rut;

import cc.aisc.commons.base.AbstractController;
import cc.aisc.commons.response.Response;
import cc.aisc.logistics.model.rut.RouteLocation;
import cc.aisc.logistics.model.rut.type.LevelType;
import cc.aisc.logistics.service.rut.RouteLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by sjf on 16-6-16.
 */
@RestController
public class RouteLocationController extends AbstractController<RouteLocation, Long> implements IRouteLocationController {

    @Autowired
    private RouteLocationService routeLocationService;

    private final static String PATH_RUT = "/rut";
    private final static String PATH_END = "/route-locations";

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
    public ResponseEntity<Response> getByConditions(@RequestBody(required = false) RouteLocation record, @RequestParam int page, @RequestParam int size) throws Exception {
        return super.getByConditions(record, page, size);
    }

    @Override
    @RequestMapping(value = PATH_RUT + PATH_END, method = RequestMethod.POST)
    public ResponseEntity<Response> add(@Valid @RequestBody(required = true) RouteLocation record, BindingResult result) throws Exception {
        String lbl = record.getName();
        if (record.getLevel().ordinal() > LevelType.REGION.ordinal()) {
            Optional<RouteLocation> loc = routeLocationService.findById(record.getPid());
            lbl = loc.get().getLblName() + lbl;
        }
        record.setLblName(lbl);
        return super.add(record, result);
    }

    @Override
    @RequestMapping(value = PATH_RUT + PATH_END, method = RequestMethod.PUT)
    public ResponseEntity<Response> update(@Valid @RequestBody(required = true) RouteLocation record, BindingResult result) throws Exception {
        return super.update(record, result);
    }

    @Override
    @RequestMapping(value = PATH_RUT + PATH_END + "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable("id") Long aLong) throws Exception {
        return super.delete(aLong);
    }
}
