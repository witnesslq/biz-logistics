package cc.aisc.logistics.rest.controller;

import cc.aisc.logistics.model.vehicle.Driver;
import cc.aisc.logistics.model.vehicle.Tractor;
import cc.aisc.logistics.model.vehicle.Trailer;
import cc.aisc.logistics.model.vehicle.Truck;
import cc.aisc.logistics.rest.exception.DataBindingException;
import cc.aisc.logistics.service.vehicle.DriverService;
import cc.aisc.logistics.service.vehicle.TractorService;
import cc.aisc.logistics.service.vehicle.TrailerService;
import cc.aisc.logistics.service.vehicle.TruckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by sjf on 16-5-10.
 */
@RestController
@RequestMapping("/vehicle/v1")
public class VehicleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleController.class);

    private final DriverService driverService;
    private final TractorService tractorService;
    private final TrailerService trailerService;
    private final TruckService truckService;

    @Autowired
    public VehicleController(DriverService driverService, TractorService tractorService, TrailerService trailerService, TruckService truckService) {
        this.driverService = driverService;
        this.tractorService = tractorService;
        this.trailerService = trailerService;
        this.truckService = truckService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        DateFormatter dateFormatter = new DateFormatter("yyyy-MM-dd");
        binder.addCustomFormatter(dateFormatter);
    }
    /*CRUD for TRAILERS start*/
    @RequestMapping(value = "/trailers/{id}/get", method = RequestMethod.GET)
    public ResponseEntity<Trailer> getTrailerById(@PathVariable Long id) throws Exception {
        Optional<Trailer> trailer = trailerService.findById(id);
        if (trailer.isPresent())
            return ResponseEntity.ok(trailer.get());
        else
            throw new NoSuchElementException("No such element!");
    }
    @RequestMapping(value = "/trailers/get", method = RequestMethod.GET)
    public ResponseEntity<List<Trailer>> getTrailersByConditions(@ModelAttribute Trailer con) throws Exception {
        Optional<List<Trailer>> trailers = trailerService.findByConditions(con);
        if (trailers.isPresent() && trailers.get().size() > 0)
            return ResponseEntity.ok(trailers.get());
        else
            throw new NoSuchElementException("No such element!");
    }
    @RequestMapping(value = "/trailer/add", method = RequestMethod.POST)
    public ResponseEntity<String> addTrailer(@Valid @ModelAttribute Trailer record, BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        trailerService.insertSelective(record);
        return ResponseEntity.ok("insert success.");
    }

    @RequestMapping(value = "/trailer/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTrailer(@Valid @ModelAttribute Trailer record, BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        trailerService.updateSelective(record);
        return ResponseEntity.ok("update success.");
    }

    @RequestMapping(value = "/trailer/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTrailer(Long id) throws Exception{
        trailerService.delete(id);
        return ResponseEntity.ok("delete success.");
    }
    /*CRUD for TRAILERS end*/
    /*CRUD for TRACTORS start*/
    @RequestMapping(value = "/tractors/{id}/get", method = RequestMethod.GET)
    public ResponseEntity<Tractor> getTractorById(@PathVariable Long id) throws Exception {
        Optional<Tractor> tractor = tractorService.findById(id);
        if (tractor.isPresent())
            return ResponseEntity.ok(tractor.get());
        else
            throw new NoSuchElementException("No such element!");
    }
    @RequestMapping(value = "/tractors/get", method = RequestMethod.GET)
    public ResponseEntity<List<Tractor>> getTractorsByConditions(@ModelAttribute Tractor con) throws Exception {
        Optional<List<Tractor>> tractors = tractorService.findByConditions(con);
        if (tractors.isPresent() && tractors.get().size() > 0)
            return ResponseEntity.ok(tractors.get());
        else
            throw new NoSuchElementException("No such element!");
    }
    @RequestMapping(value = "/tractor/add", method = RequestMethod.POST)
    public ResponseEntity<String> addTractor(@Valid @ModelAttribute Tractor record, BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        tractorService.insertSelective(record);
        return ResponseEntity.ok("insert success.");
    }

    @RequestMapping(value = "/tractor/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTractor(@Valid @ModelAttribute Tractor record, BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        tractorService.updateSelective(record);
        return ResponseEntity.ok("update success.");
    }

    @RequestMapping(value = "/tractor/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTractor(Long id) throws Exception{
        tractorService.delete(id);
        return ResponseEntity.ok("delete success.");
    }
    /*CRUD for TRACTORS end*/

    /*CRUD for DRIVERS start*/
    @RequestMapping(value = "/drivers/{id}/get", method = RequestMethod.GET)
    public ResponseEntity<Driver> getDriverById(@PathVariable Long id) throws Exception {
        Optional<Driver> driver = driverService.findById(id);
        if (driver.isPresent())
            return ResponseEntity.ok(driver.get());
        else
            throw new NoSuchElementException("No such element!");
    }

    @RequestMapping(value = "/drivers/get", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public ResponseEntity<List<Driver>> getDriversByConditions(@ModelAttribute Driver con) throws Exception{
        Optional<List<Driver>> drivers = driverService.findByConditions(con);
        if (drivers.isPresent() && drivers.get().size() > 0)
            return ResponseEntity.ok(drivers.get());
        else
            throw new NoSuchElementException("No such element!");
    }

    @RequestMapping(value = "/driver/add", method = RequestMethod.POST)
    public ResponseEntity<String> addDriver(@Valid @ModelAttribute Driver record, BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        driverService.insertSelective(record);
        return ResponseEntity.ok("insert success.");
    }

    @RequestMapping(value = "/driver/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateDriver(@Valid @ModelAttribute Driver record, BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        driverService.updateSelective(record);
        return ResponseEntity.ok("update success.");
    }

    @RequestMapping(value = "/driver/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteDriver(Long id) throws Exception{
        driverService.delete(id);
        return ResponseEntity.ok("delete success.");
    }
    /*CRUD for DRIVERS end*/

    /*CRUD for DRIVERS start*/
    @RequestMapping(value = "/trucks/{id}/get", method = RequestMethod.GET)
    public ResponseEntity<Truck> getTruckById(@PathVariable Long id) throws Exception {
        Optional<Truck> truck = truckService.findById(id);
        if (truck.isPresent())
            return ResponseEntity.ok(truck.get());
        else
            throw new NoSuchElementException("No such element!");
    }

    @RequestMapping(value = "/trucks/get", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public ResponseEntity<List<Truck>> getTrucksByConditions(@ModelAttribute Truck con) throws Exception{
        Optional<List<Truck>> trucks = truckService.findByConditions(con);
        if (trucks.isPresent() && trucks.get().size() > 0)
            return ResponseEntity.ok(trucks.get());
        else
            throw new NoSuchElementException("No such element!");
    }

    @RequestMapping(value = "/truck/add", method = RequestMethod.POST)
    public ResponseEntity<String> addTruck(@Valid @ModelAttribute Truck record, BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        truckService.insertSelective(record);
        return ResponseEntity.ok("insert success.");
    }

    @RequestMapping(value = "/truck/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTruck(@Valid @ModelAttribute Truck record, BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        truckService.updateSelective(record);
        return ResponseEntity.ok("update success.");
    }

    @RequestMapping(value = "/truck/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTruck(Long id) throws Exception{
        truckService.delete(id);
        return ResponseEntity.ok("delete success.");
    }
    /*CRUD for DRIVERS end*/
}
