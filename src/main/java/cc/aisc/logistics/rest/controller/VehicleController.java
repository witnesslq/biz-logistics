package cc.aisc.logistics.rest.controller;

import cc.aisc.logistics.model.veh.Driver;
import cc.aisc.logistics.model.veh.Tractor;
import cc.aisc.logistics.model.veh.Trailer;
import cc.aisc.logistics.model.veh.Truck;
import cc.aisc.logistics.model.veh.type.DriverStatus;
import cc.aisc.logistics.model.veh.type.VehicleStatus;
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
@RequestMapping("/vehicle")
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
    @RequestMapping(value = "/trailers/{id}", method = RequestMethod.GET)
    public ResponseEntity<Trailer> getTrailerById(@PathVariable Long id) throws Exception {
        Optional<Trailer> trailer = trailerService.findById(id);
        if (trailer.isPresent())
            return ResponseEntity.ok(trailer.get());
        else
            throw new NoSuchElementException("No such element!");
    }
    @RequestMapping(value = "/trailers", method = RequestMethod.GET)
    public ResponseEntity<List<Trailer>> getTrailersByConditions(@ModelAttribute Trailer con) throws Exception {
        Optional<List<Trailer>> trailers = trailerService.findByConditions(con);
        if (trailers.isPresent() && trailers.get().size() > 0)
            return ResponseEntity.ok(trailers.get());
        else
            throw new NoSuchElementException("No such element!");
    }
    @RequestMapping(value = "/trailers", method = RequestMethod.POST)
    public ResponseEntity<String> addTrailer(@Valid @ModelAttribute Trailer record, BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        trailerService.insertSelective(record);
        return ResponseEntity.ok("insert success.");
    }

    @RequestMapping(value = "/trailers", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTrailer(@Valid @ModelAttribute Trailer record, BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        trailerService.updateSelective(record);
        return ResponseEntity.ok("update success.");
    }

    @RequestMapping(value = "/trailer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTrailer(@PathVariable Long id) throws Exception{
        Optional<Trailer> result = trailerService.findById(id);
        if (result.isPresent()){
            result.get().setStatus(VehicleStatus.DISABLED);
            trailerService.updateSelective(result.get());
            return ResponseEntity.ok("delete success.");
        }else {
            throw new NoSuchElementException("NO SUCH ELEMENT.");
        }


    }
    /*CRUD for TRAILERS end*/
    /*CRUD for TRACTORS start*/
    @RequestMapping(value = "/tractors/{id}", method = RequestMethod.GET)
    public ResponseEntity<Tractor> getTractorById(@PathVariable Long id) throws Exception {
        Optional<Tractor> tractor = tractorService.findById(id);
        if (tractor.isPresent())
            return ResponseEntity.ok(tractor.get());
        else
            throw new NoSuchElementException("No such element!");
    }
    @RequestMapping(value = "/tractors", method = RequestMethod.GET)
    public ResponseEntity<List<Tractor>> getTractorsByConditions(@ModelAttribute Tractor con) throws Exception {
        Optional<List<Tractor>> tractors = tractorService.findByConditions(con);
        if (tractors.isPresent() && tractors.get().size() > 0)
            return ResponseEntity.ok(tractors.get());
        else
            throw new NoSuchElementException("No such element!");
    }
    @RequestMapping(value = "/tractors", method = RequestMethod.POST)
    public ResponseEntity<String> addTractor(@Valid @ModelAttribute Tractor record, BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        tractorService.insertSelective(record);
        return ResponseEntity.ok("insert success.");
    }

    @RequestMapping(value = "/tractors", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTractor(@Valid @ModelAttribute Tractor record, BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        tractorService.updateSelective(record);
        return ResponseEntity.ok("update success.");
    }

    @RequestMapping(value = "/tractors/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTractor(@PathVariable Long id) throws Exception{
        Optional<Tractor> result = tractorService.findById(id);
        if (result.isPresent()){
            result.get().setStatus(VehicleStatus.DISABLED);
            tractorService.updateSelective(result.get());
            return ResponseEntity.ok("delete success.");
        }else {
            throw new NoSuchElementException("NO SUCH ELEMENT.");
        }

    }
    /*CRUD for TRACTORS end*/

    /*CRUD for DRIVERS start*/
    @RequestMapping(value = "/drivers/{id}", method = RequestMethod.GET)
    public ResponseEntity<Driver> getDriverById(@PathVariable Long id) throws Exception {
        Optional<Driver> driver = driverService.findById(id);
        if (driver.isPresent())
            return ResponseEntity.ok(driver.get());
        else
            throw new NoSuchElementException("No such element!");
    }

    @RequestMapping(value = "/drivers", method = RequestMethod.GET)
    public ResponseEntity<List<Driver>> getDriversByConditions(@ModelAttribute Driver con) throws Exception{
        Optional<List<Driver>> drivers = driverService.findByConditions(con);
        if (drivers.isPresent() && drivers.get().size() > 0)
            return ResponseEntity.ok(drivers.get());
        else
            throw new NoSuchElementException("No such element!");
    }

    @RequestMapping(value = "/drivers", method = RequestMethod.POST)
    public ResponseEntity<String> addDriver(@Valid @ModelAttribute Driver record, BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        driverService.insertSelective(record);
        return ResponseEntity.ok("insert success.");
    }

    @RequestMapping(value = "/drivers", method = RequestMethod.PUT)
    public ResponseEntity<String> updateDriver(@Valid @ModelAttribute Driver record, BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        driverService.updateSelective(record);
        return ResponseEntity.ok("update success.");
    }

    @RequestMapping(value = "/drivers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteDriver(@PathVariable Long id) throws Exception{
        Optional<Driver> result = driverService.findById(id);
        if (result.isPresent()){
            result.get().setStatus(DriverStatus.BANNED);
            driverService.updateSelective(result.get());
            return ResponseEntity.ok("delete success.");
        }else {
            throw new NoSuchElementException("NO SUCH ELEMENT.");
        }
    }
    /*CRUD for DRIVERS end*/

    /*CRUD for DRIVERS start*/
    @RequestMapping(value = "/trucks/{id}", method = RequestMethod.GET)
    public ResponseEntity<Truck> getTruckById(@PathVariable Long id) throws Exception {
        Optional<Truck> truck = truckService.findById(id);
        if (truck.isPresent())
            return ResponseEntity.ok(truck.get());
        else
            throw new NoSuchElementException("No such element!");
    }

    @RequestMapping(value = "/trucks", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public ResponseEntity<List<Truck>> getTrucksByConditions(@ModelAttribute Truck con) throws Exception{
        Optional<List<Truck>> trucks = truckService.findByConditions(con);
        if (trucks.isPresent() && trucks.get().size() > 0)
            return ResponseEntity.ok(trucks.get());
        else
            throw new NoSuchElementException("No such element!");
    }

    @RequestMapping(value = "/trucks", method = RequestMethod.POST)
    public ResponseEntity<String> addTruck(@Valid @ModelAttribute Truck record, BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        truckService.insertSelective(record);
        return ResponseEntity.ok("insert success.");
    }

    @RequestMapping(value = "/trucks", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTruck(@Valid @ModelAttribute Truck record, BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        truckService.updateSelective(record);
        return ResponseEntity.ok("update success.");
    }

    @RequestMapping(value = "/trucks/{id}", method = {RequestMethod.PUT})
    public ResponseEntity<String> setTruckAvailableOrNot(@PathVariable Long id, @RequestParam("av") boolean av) throws Exception{
        Truck record = av ? truckService.setAvailable(id) : truckService.setNotAvailable(id);
        if (record != null)
            return ResponseEntity.ok("operate success.");
        return ResponseEntity.ok("operate failed.");
    }
    /*CRUD for DRIVERS end*/
}
