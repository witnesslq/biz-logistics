package cc.aisc.logistics;

import cc.aisc.BizLogisticsApplication;
import cc.aisc.commons.utils.BeanUtils;
import cc.aisc.logistics.model.biz.Car;
import cc.aisc.logistics.model.biz.Waybill;
import cc.aisc.logistics.model.biz.trspt.Schedule;
import cc.aisc.logistics.model.biz.type.CarStatus;
import cc.aisc.logistics.model.rut.RouteLocation;
import cc.aisc.logistics.model.rut.type.LevelType;
import cc.aisc.logistics.model.veh.Driver;
import cc.aisc.logistics.model.veh.Tractor;
import cc.aisc.logistics.model.veh.Trailer;
import cc.aisc.logistics.model.veh.Truck;
import cc.aisc.logistics.model.veh.type.*;
import cc.aisc.logistics.service.biz.CarService;
import cc.aisc.logistics.service.biz.WaybillService;
import cc.aisc.logistics.service.biz.trspt.ScheduleService;
import cc.aisc.logistics.service.corp.CorporationService;
import cc.aisc.logistics.service.rut.RouteLocationService;
import cc.aisc.logistics.service.veh.DriverService;
import cc.aisc.logistics.service.veh.TractorService;
import cc.aisc.logistics.service.veh.TrailerService;
import cc.aisc.logistics.service.veh.TruckService;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BizLogisticsApplication.class)
@WebAppConfiguration
public class BizLogisticsApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(BizLogisticsApplicationTests.class);

	@Autowired
	private DriverService driverService;
	@Autowired
	private TrailerService trailerService;
	@Autowired
	private TractorService tractorService;
	@Autowired
	private TruckService truckService;
	@Autowired
	private RouteLocationService routeLocationService;
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private CorporationService corporationService;
	@Autowired
	private WaybillService waybillService;
	@Autowired
	private CarService carService;

	@Test
	public void contextLoads() {
		/*List<Driver> driver = (ArrayList<Driver>)driverService.findAll().get();
		Driver driver1 = new Driver();
		driver1.setLicense("1133311111aaa1111");
		driver1.setLisnType(LicenseType.C1);
		driver1.setName("金老三");
		driver1.setMobile("1334567890");
		driver1.setStatus(DriverStatus.ASSIGNED);
		driver1.setPersonId(0L);
		//driverService.insert(driver1);
		System.out.println(driver1.toString());*/
	}

	@Test
	public void testInsertTruck(){
		/*Trailer t1 = new Trailer();
		t1.setStatus(VehicleStatus.SERVING);
		t1.setBridge("bridge1");
		t1.setPlateNo("鄂A78887");
		t1.setCorp(null);
		t1.setDrvLisn("drv-lisn-11");
		t1.setLiftType(TrailerType.LIFT_1);
		t1.setFrameType(TrailerType.FRAME_1);
		t1.setManufacturer("dong feng 1");
		t1.setMnftrDate(new Date());
		t1.setPucsDate(new Date());
		t1.setSlotAmt(8);
		t1.setVehModel("model-1");
		t1.setVehBrand("brand-1");
		t1.setSlotType(TrailerType.SLOT_1);
		t1.setTyreType(TrailerType.TYRE_1);
		t1.setYearInuse("2008");
		for (int i = 0 ; i < 50 ; i++) {
			t1.setVin("vin-1111111-"+i);
			trailerService.insert(t1);
		}*/
		/*Trailer t2 = new Trailer();
		t2.setPlateNo("黑B33333");
		t2.setTyreType(TrailerType.TYRE_3);
		trailerService.insert(t2);
		Driver d1 = new Driver();
		d1.setName("金老七");
		d1.setStatus(DriverStatus.BANNED);
		driverService.insert(d1);
		Truck t3 = new Truck();
		t3.setDriver(d1);
		t3.setItnlSn("200088");
		t3.setTractor(t1);
		t3.setTrailer(t2);
		t3.setStatus(TransportStatus.ON_STAND_BY);
		truckService.insert(t3);
		System.out.println(t1.getId());*/
	}

	@Test
	public void testQueryTruck(){
		/*Map<String, String> map = new HashMap<>();
		map.put("itnlSn", "200");
		map.put("driverName", "lao");
		List<Map<String,Object>> list = truckService.findByNested(map).get();

		System.out.println(list.toString());*/
	}

	@Test
	public void addSchedule(){
		/*Schedule s = new Schedule();
		Truck t = truckService.findById(2L).get();
		s.setTruck(t);
		RouteLocation l = routeLocationService.findById(6L).get();
		s.setDeptLoc(l);
		s.setStartAt(new Date());
		s.setCreateAt(new Date());
		s.setCreateBy(0L);
		for (int i=1;i<30;i++)
			scheduleService.insert(s);*/
	}

	@Test
	public void testInsertWb(){
		/*Waybill wb = new Waybill();
		wb.setSprCo(corporationService.findById(1L).get());
		wb.setRcvCo(corporationService.findById(2L).get());
		wb.setCrrCo(corporationService.findById(3L).get());
		wb.setCkotDist(new BigDecimal(1234.5));
		wb.setRcvCnt("老六");
		wb.setRcvCntInf("17177777777");
		wb.setDeptDate(new Date());
		wb.setDueDate(new DateTime().plusDays(3).toDate());
		wb.setLoadLoc(routeLocationService.findById(1L).get());
		wb.setUldLoc(routeLocationService.findById(2L).get());
		wb.setWbNo("wb_no_12345");
		List<Car> cars = new ArrayList<>();
		Car c1 = new Car();
		c1.setColor("white");
		c1.setVin("c1vin1111111111111");
		c1.setTypeId(1L);
		cars.add(c1);
		Car c2 = new Car();
		Car c3 = new Car();
		BeanUtils.copyPropertiesIgnoreNull(c1, c2);
		BeanUtils.copyPropertiesIgnoreNull(c1, c3);
		c2.setColor("red");
		c3.setColor("purple");
		cars.add(c2);
		cars.add(c3);
		wb.setCars(cars);
		Car cc = new Car();
		BeanUtils.copyPropertiesIgnoreNull(c3, cc);
		cc.setWbId(3L);
		cc.setStatus(CarStatus.PENDING);
		cc.setHasCtf(true);
		cc.setCurrLoc(wb.getLoadLoc());
		cc.setDestLoc(wb.getUldLoc());
		//carService.insert(cc);
		waybillService.insert(wb);*/
	}

}
