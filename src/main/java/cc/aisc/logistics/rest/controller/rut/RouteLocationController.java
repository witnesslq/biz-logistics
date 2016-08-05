package cc.aisc.logistics.rest.controller.rut;

import cc.aisc.commons.base.AbstractController;
import cc.aisc.commons.exception.DataBindingException;
import cc.aisc.commons.response.Response;
import cc.aisc.logistics.model.rut.RouteLocation;
import cc.aisc.logistics.model.rut.type.LevelType;
import cc.aisc.logistics.model.rut.type.RegionType;
import cc.aisc.logistics.service.rut.RouteLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-6-16.
 */
@RestController
public class RouteLocationController extends AbstractController<RouteLocation, Long> implements IRouteLocationController {

    @Autowired
    private RouteLocationService routeLocationService;

    @Override
    @RequestMapping(value = PATH_RUT_LOCATION + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> getById(@PathVariable("id") Long aLong) throws Exception {
        return super.getById(aLong);
    }


    @RequestMapping(value = PATH_RUT_LOCATION + PATH_QUERY, method = RequestMethod.GET)
    public ResponseEntity<Response> findList(@RequestParam HashMap<String, Object> o) throws Exception {
        return find(o);
    }

    @RequestMapping(value = PATH_RUT_LOCATION, method = RequestMethod.GET)
    public ResponseEntity<Response> getList(@RequestParam HashMap<String, Object> o) throws Exception {
        return getDetails(o);
    }

    @Override
    @RequestMapping(value = PATH_RUT_LOCATION, method = RequestMethod.POST)
    public ResponseEntity<Response> add(@Valid @RequestBody(required = true) RouteLocation record, BindingResult result) throws Exception {
        return super.add(record, result);
    }

    @Override
    @RequestMapping(value = PATH_RUT_LOCATION, method = RequestMethod.PUT)
    public ResponseEntity<Response> update(@Valid @RequestBody(required = true) RouteLocation record, BindingResult result) throws Exception {
        return super.update(record, result);
    }

    @Override
    @RequestMapping(value = PATH_RUT_LOCATION + "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable("id") Long aLong) throws Exception {
        return super.delete(aLong);
    }

    /*@RequestMapping(value = PATH_RUT_LOCATION + "/insert", method = RequestMethod.GET)
    public void insertDistCode2(){
        *//*String[] arr = {"华北","东北","华东","华中","华南","西南","西北","台湾","港澳"};
        int d = 0;
        for (int i=0;i<arr.length;i++){
            d ++;
            Long id = d * 100L;
            RouteLocation n = new RouteLocation();
            if (arr[i].equals("华南")) {
                id = 401L;
                d = i;
            }
            n.setId(id);
            n.setName(arr[i]);
            n.setLblName(arr[i]);
            n.setRemark(arr[i]);
            n.setLevel(LevelType.REGION);
            n.setSort(i+1);
            n.setPid(1L);
            routeLocationService.insert(n);
        }*//*

        try{
            String encoding="UTF-8";
            File file = new File("/home/sjf/Desktop/code.txt");
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                String city = "";
                String prov = "";
                String pln = "";
                String cln = "";
                int provsort = 1;
                int citysort = 1;
                int coutsort = 1;
                Long ppid = 0L;
                Long cpid = 0L;
                while((lineTxt = bufferedReader.readLine().trim()) != null){
                    if (!lineTxt.isEmpty()){
                        RouteLocation loc = new RouteLocation();
                        LevelType lvl = null;
                        String name = null;
                        String lblName = null;
                        Long code = Long.valueOf(lineTxt.substring(0, 6));  //"00$" , "0000$"
                        String str = lineTxt.replaceAll("\\d", "");
                        if (code % 10000 == 0){
                            name = str;
                            lvl = LevelType.PROVINCE;
                            loc.setPid((int)(code/100000)==4?((int)(code/10000) >= 44?401L:400L):(code/100000)*100);
                            loc.setSort(provsort);
                            lblName = name;
                            pln = lblName;
                            provsort ++;
                            citysort = 1;
                            prov = str;
                            ppid = code;
                        }else if (code % 100 == 0){
                            name = str;
                            lvl = LevelType.MUNICIPAL;
                            loc.setPid(ppid);
                            loc.setSort(citysort);
                            citysort ++;
                            coutsort = 1;
                            city = str;
                            cpid = code;
                            if (str.equals("市辖区") || str.equals("县")) {
                                name = prov;
                                lblName = pln;
                            }else {
                                lblName = pln + "," + name;
                            }
                            cln = lblName;
                        }else{
                            name = str;
                            lvl = LevelType.COUNTY;
                            loc.setPid(cpid);
                            loc.setSort(coutsort);
                            coutsort ++;
                            if (str.equals("市辖区") || str.equals("县"))
                                name = city;

                            lblName = cln + "," + name;

                        }
                        loc.setId(code);
                        switch ((int) (code/100000)){
                            case 1:
                                loc.setRegion(RegionType.NORTH);
                                break;
                            case 2:
                                loc.setRegion(RegionType.NORTHEAST);
                                break;
                            case 3:
                                loc.setRegion(RegionType.EAST);
                                break;
                            case 4:
                                if ((int)(code/10000) < 44)
                                    loc.setRegion(RegionType.CENTRAL);
                                loc.setRegion(RegionType.SOUTH);
                                break;
                            case 5:
                                loc.setRegion(RegionType.SOUTHWEST);
                                break;
                            case 6:
                                loc.setRegion(RegionType.NORTHWEST);
                                break;
                            case 7:
                                loc.setRegion(RegionType.TAIWAN);
                                break;
                            case 8:
                                loc.setRegion(RegionType.HKMC);
                                break;
                        }
                        loc.setName(name);
                        loc.setLevel(lvl);
                        loc.setLblName(lblName);
                        loc.setRemark(lblName);
                        routeLocationService.insert(loc);
                        //loc.set
                    }

                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }*/
}
