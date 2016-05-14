package cc.aisc.logistics.rest.controller;

import cc.aisc.logistics.model.corp.CorpRegInfo;
import cc.aisc.logistics.model.corp.Corporation;
import cc.aisc.logistics.rest.exception.DataBindingException;
import cc.aisc.logistics.service.corp.CorpRegInfoService;
import cc.aisc.logistics.service.corp.CorporationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by sjf on 16-5-14.
 */
@RestController
@RequestMapping("/corp")
public class CorpController {
    private final static Logger LOGGER = LoggerFactory.getLogger(CorpController.class);

    @Autowired
    private CorporationService corporationService;
    
    @Autowired
    private CorpRegInfoService corpRegInfoService;

    /*CRUD for corporations start*/
    @RequestMapping(value = "/corporations/{id}", method = RequestMethod.GET)
    public ResponseEntity<Corporation> getCorporationsById(@PathVariable Long id) throws Exception{
        Optional<Corporation> record = corporationService.findById(id);
        if (record.isPresent())
            return ResponseEntity.ok(record.get());
        else
            throw new NoSuchElementException("NO such element.");
    }

    @RequestMapping(value = "/corporations", method = RequestMethod.GET)//todo: page
    public ResponseEntity<List<Corporation>> getDriversByConditions(@ModelAttribute Corporation con) throws Exception{
        Optional<List<Corporation>> drivers = corporationService.findByConditions(con);
        if (drivers.isPresent() && drivers.get().size() > 0)
            return ResponseEntity.ok(drivers.get());
        else
            throw new NoSuchElementException("No such element!");
    }

    @RequestMapping(value = "/corporations", method = RequestMethod.POST)
    public ResponseEntity<Corporation> addCorporation(@Valid @ModelAttribute Corporation record,
                                                                BindingResult result) throws Exception{
        if (result.hasErrors())
            throw new DataBindingException(result);
        corporationService.insert(record);
        return ResponseEntity.ok(record);
    }

    @RequestMapping(value = "/corporations", method = RequestMethod.PUT)
    public ResponseEntity<Corporation> updateTrailer(@Valid @ModelAttribute Corporation record,
                                                BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        corporationService.updateSelective(record);
        return ResponseEntity.ok(record);
    }

    @RequestMapping(value = "/corporations/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCorporation(@PathVariable Long id) throws Exception{
        corporationService.delete(id);
        return ResponseEntity.ok("delete success.");
    }
    /*CRUD for corporations end*/

    /*CRUD for corp-reg-infos start*/
    @RequestMapping(value = "/corp-reg-infos/{id}", method = RequestMethod.GET)
    public ResponseEntity<CorpRegInfo> getCorpRegInfosById(@PathVariable Long id) throws Exception{
        Optional<CorpRegInfo> record = corpRegInfoService.findById(id);
        if (record.isPresent())
            return ResponseEntity.ok(record.get());
        else
            throw new NoSuchElementException("NO such element.");
    }

    @RequestMapping(value = "/corp-reg-infos", method = RequestMethod.GET)//todo: page
    public ResponseEntity<List<CorpRegInfo>> getDriversByConditions(@ModelAttribute CorpRegInfo con) throws Exception{
        Optional<List<CorpRegInfo>> drivers = corpRegInfoService.findByConditions(con);
        if (drivers.isPresent() && drivers.get().size() > 0)
            return ResponseEntity.ok(drivers.get());
        else
            throw new NoSuchElementException("No such element!");
    }

    @RequestMapping(value = "/corp-reg-infos", method = RequestMethod.POST)
    public ResponseEntity<CorpRegInfo> addCorpRegInfo(@Valid @ModelAttribute CorpRegInfo record,
                                                      BindingResult result) throws Exception{
        if (result.hasErrors())
            throw new DataBindingException(result);
        corpRegInfoService.insert(record);
        return ResponseEntity.ok(record);
    }

    @RequestMapping(value = "/corp-reg-infos", method = RequestMethod.PUT)
    public ResponseEntity<CorpRegInfo> updateTrailer(@Valid @ModelAttribute CorpRegInfo record,
                                                     BindingResult result) throws Exception{
        if (result.hasErrors()){
            throw new DataBindingException(result);
        }
        corpRegInfoService.updateSelective(record);
        return ResponseEntity.ok(record);
    }

    @RequestMapping(value = "/corp-reg-infos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCorpRegInfo(@PathVariable Long id) throws Exception{
        corpRegInfoService.delete(id);
        return ResponseEntity.ok("delete success.");
    }
    /*CRUD for corp-reg-infos end*/
}
