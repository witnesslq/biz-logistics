package cc.aisc.logistics.rest.controller;

import cc.aisc.logistics.model.biz.Waybill;
import cc.aisc.logistics.model.biz.WbCar;
import cc.aisc.logistics.rest.exception.DataBindingException;
import cc.aisc.logistics.service.biz.WaybillService;
import cc.aisc.logistics.service.biz.WbCarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by sjf on 16-5-14.
 */
@RestController
@RequestMapping("/biz")
public class BizController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BizController.class);
    
    @Autowired
    private WaybillService waybillService;
    @Autowired
    private WbCarService wbCarService;

    /*CRUD for waybills start*/
    @RequestMapping(value = "/waybills/{id}", method = RequestMethod.GET)
    public ResponseEntity<Waybill> getWaybillsById(@PathVariable Long id) throws Exception{
        Optional<Waybill> record = waybillService.findById(id);
        if (record.isPresent())
            return ResponseEntity.ok(record.get());
        else
            throw new NoSuchElementException("NO such element.");
    }

    @RequestMapping(value = "/waybills", method = RequestMethod.GET)//todo: page
    public ResponseEntity<List<Waybill>> getDriversByConditions(@ModelAttribute Waybill con) throws Exception{
        Optional<List<Waybill>> drivers = waybillService.findByConditions(con);
        if (drivers.isPresent() && drivers.get().size() > 0)
            return ResponseEntity.ok(drivers.get());
        else
            throw new NoSuchElementException("No such element!");
    }

    @RequestMapping(value = "/waybills", method = RequestMethod.POST)
    public ResponseEntity<Waybill> addWaybill(@Valid @ModelAttribute Waybill record,
                                                      BindingResult result) throws Exception{
        if (result.hasErrors())
            throw new DataBindingException(result);
        waybillService.insert(record);
        return ResponseEntity.ok(record);
    }

    @RequestMapping(value = "/waybills", method = RequestMethod.PUT)
    public ResponseEntity<Waybill> updateTrailer(@Valid @ModelAttribute Waybill record,
                                                     BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        waybillService.updateSelective(record);
        return ResponseEntity.ok(record);
    }

    @RequestMapping(value = "/waybills/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteWaybill(@PathVariable Long id) throws Exception{
        waybillService.delete(id);
        return ResponseEntity.ok("delete success.");
    }
    /*CRUD for waybills end*/

    /*CRUD for wbCars start*/
    @RequestMapping(value = "/wbCars/{id}", method = RequestMethod.GET)
    public ResponseEntity<WbCar> getwbCarsById(@PathVariable Long id) throws Exception{
        Optional<WbCar> record = wbCarService.findById(id);
        if (record.isPresent())
            return ResponseEntity.ok(record.get());
        else
            throw new NoSuchElementException("NO such element.");
    }

    @RequestMapping(value = "/wbCars", method = RequestMethod.GET)//todo: page
    public ResponseEntity<List<WbCar>> getDriversByConditions(@ModelAttribute WbCar con) throws Exception{
        Optional<List<WbCar>> drivers = wbCarService.findByConditions(con);
        if (drivers.isPresent() && drivers.get().size() > 0)
            return ResponseEntity.ok(drivers.get());
        else
            throw new NoSuchElementException("No such element!");
    }

    @RequestMapping(value = "/wbCars", method = RequestMethod.POST)
    public ResponseEntity<WbCar> addWbCar(@Valid @ModelAttribute WbCar record,
                                          BindingResult result) throws Exception{
        if (result.hasErrors())
            throw new DataBindingException(result);
        wbCarService.insert(record);
        return ResponseEntity.ok(record);
    }

    @RequestMapping(value = "/wbCars", method = RequestMethod.PUT)
    public ResponseEntity<WbCar> updateTrailer(@Valid @ModelAttribute WbCar record,
                                               BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        wbCarService.updateSelective(record);
        return ResponseEntity.ok(record);
    }

    @RequestMapping(value = "/wbCars/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteWbCar(@PathVariable Long id) throws Exception{
        wbCarService.delete(id);
        return ResponseEntity.ok("delete success.");
    }
    /*CRUD for wbCars end*/
}
