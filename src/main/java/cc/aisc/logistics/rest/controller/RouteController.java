package cc.aisc.logistics.rest.controller;

import cc.aisc.logistics.model.rt.StandardDistance;
import cc.aisc.logistics.rest.exception.DataBindingException;
import cc.aisc.logistics.service.route.StandardDistanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by sjf on 16-5-11.
 */
@RestController
@RequestMapping("/route")
public class RouteController {


    private static final Logger LOGGER = LoggerFactory.getLogger(RouteController.class);

    /*@Autowired
    private RouteLocationService routeLocationService;*/
    @Autowired
    private StandardDistanceService standardDistanceService;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        DateFormatter dateFormatter = new DateFormatter("yyyy-MM-dd");
        binder.addCustomFormatter(dateFormatter);
    }

    /*CRUD for ROUTE-LOCATION start*/
    /*@RequestMapping(value = "/rt-locations", method = RequestMethod.GET)
    public ResponseEntity<List<RouteLocation>> getRouteLocations() throws Exception {
        Optional<Collection<RouteLocation>> locations = routeLocationService.findAll();
        if (locations.isPresent() && locations.get().size() > 0){
            List<RouteLocation> list = ((List<RouteLocation>)locations.get());
            TreeHelper<RouteLocation> helper = new TreeHelper<>();
            return ResponseEntity.ok(helper.getTree(list));
        }else {
            throw new NoSuchElementException("NO such element.");
        }
    }
    @RequestMapping(value = "/rt-locations/{id}", method = RequestMethod.GET)
    public ResponseEntity<RouteLocation> getRouteLocationsById(@PathVariable Long id) throws Exception{
        Optional<RouteLocation> location = routeLocationService.findById(id);
        if (location.isPresent())
            return ResponseEntity.ok(location.get());
        else
            throw new NoSuchElementException("NO such element.");
    }

    @RequestMapping(value = "/rt-locations", method = RequestMethod.POST)
    public ResponseEntity<RouteLocation> addRouteLocation(@Valid @ModelAttribute RouteLocation record,
                                                          BindingResult result) throws Exception{
        if (result.hasErrors())
            throw new DataBindingException(result);
        routeLocationService.insert(record);
        return ResponseEntity.ok(record);
    }

    @RequestMapping(value = "/rt-locations", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTrailer(@Valid @ModelAttribute RouteLocation record,
                                                BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        routeLocationService.updateSelective(record);
        return ResponseEntity.ok("update success.");
    }

    @RequestMapping(value = "/rt-locations/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteRouteLocation(@PathVariable Long id) throws Exception{
        routeLocationService.delete(id);
        return ResponseEntity.ok("delete success.");
    }*/
    /*CRUD for ROUTE-LOCATION end*/

    /*CRUD for standard-distance start*/
    @RequestMapping(value = "/standard-distances", method = RequestMethod.GET)
    public ResponseEntity<List<StandardDistance>> getStandardDistances() throws Exception {
        Optional<Collection<StandardDistance>> distances = standardDistanceService.findAll();
        if (distances.isPresent() && distances.get().size() > 0){
            List<StandardDistance> list = ((List<StandardDistance>)distances.get());
            return ResponseEntity.ok(list);
        }else {
            throw new NoSuchElementException("NO such element.");
        }
    }
    @RequestMapping(value = "/standard-distances/{id}", method = RequestMethod.GET)
    public ResponseEntity<StandardDistance> getStandardDistancesById(@PathVariable Long id) throws Exception{
        Optional<StandardDistance> location = standardDistanceService.findById(id);
        if (location.isPresent())
            return ResponseEntity.ok(location.get());
        else
            throw new NoSuchElementException("NO such element.");
    }

    @RequestMapping(value = "/standard-distances", method = RequestMethod.POST)
    public ResponseEntity<StandardDistance> addStandardDistance(@Valid @ModelAttribute StandardDistance record,
                                                          BindingResult result) throws Exception{
        if (result.hasErrors())
            throw new DataBindingException(result);
        standardDistanceService.insert(record);
        return ResponseEntity.ok(record);
    }

    @RequestMapping(value = "/standard-distances", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTrailer(@Valid @ModelAttribute StandardDistance record,
                                                BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        standardDistanceService.updateSelective(record);
        return ResponseEntity.ok("update success.");
    }

    @RequestMapping(value = "/standard-distances/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteStandardDistance(@PathVariable Long id) throws Exception{
        standardDistanceService.delete(id);
        return ResponseEntity.ok("delete success.");
    }
    /*CRUD for standard-distance end*/

}
