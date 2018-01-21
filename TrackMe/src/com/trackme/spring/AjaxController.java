package com.trackme.spring;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trackme.constants.Constant;
import com.trackme.spring.jsonview.Views;
import com.trackme.spring.model.AjaxResponseBody;
import com.trackme.spring.model.SearchCriteria;
import com.trackme.spring.model.StatusCount;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.model.VehicleSearchForm;
import com.trackme.spring.service.GsmMasterService;
import com.trackme.spring.service.MapLatlngService;
import com.trackme.spring.service.UserMasterService;
import com.trackme.spring.service.VehicleMasterService;

@RestController
public class AjaxController {

	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	
	@Autowired
	@Qualifier(value="gsmMasterService")
	GsmMasterService gsmMasterService;
	
	
	@Autowired(required=true)
	@Qualifier(value="vehicleMasterService")
	private VehicleMasterService vehicleMasterService;
	
	@Autowired
	private MapLatlngService mapLatlngService;
	
	@Autowired
	private UserMasterService userMasterService;
	
	// @ResponseBody, not necessary, since class is annotated with @RestController
	// @RequestBody - Convert the json data into object (SearchCriteria) mapped by field name.
	// @JsonView(Views.Public.class) - Optional, limited the json data display to client.
	@JsonView(Views.Public.class)
	@RequestMapping(value = "/searchStatusCounts")
	public AjaxResponseBody getSearchResultViaAjax(HttpServletRequest request,@RequestBody SearchCriteria search) {
		Principal principal =request.getUserPrincipal();
		UserMaster currentUser=null;
		if (principal != null) {
			String userName = principal.getName();
			HttpSession session = request.getSession();
			currentUser = (UserMaster) session.getAttribute(Constant.CURRENT_USER);
			if (currentUser == null) {
				currentUser = userMasterService.getUserMasterById(userName);
				session.setAttribute(Constant.CURRENT_USER, currentUser);
			}
		}
		
		List<StatusCount> statusCounts= new ArrayList<>();

		AjaxResponseBody result = new AjaxResponseBody();

		StatusCount statusCount = new StatusCount();
		
		statusCount.setTotalVehicle(Integer.toString(vehicleMasterService.totaNoOffVehicle(currentUser)));
		statusCount.setIgnitionOn(Integer.toString(gsmMasterService.ignitionOnVehicleCount(currentUser)));
		statusCount.setIgnitionOff(Integer.toString(gsmMasterService.ignitionOffVehicleCount(currentUser)));
		statusCount.setMoving(Integer.toString(gsmMasterService.movingVehicleCount(currentUser)));
		statusCount.setIdle(Integer.toString(gsmMasterService.idleVehicleCount(currentUser)));
		statusCount.setAlert(Integer.toString(gsmMasterService.alertOnVehicleCount(currentUser)));
		//statusCount.setNotResponding(Integer.toString(gsmMasterService.getNotRespondingVehicleCount()));
		//List<StatusCount> statusCounts =statusCounts;
		statusCounts.add(statusCount);
			if (statusCounts.size() > 0) {
				result.setCode("200");
				result.setMsg("");
				result.setResult(statusCounts);
			} else {
				result.setCode("204");
				result.setMsg("No StatusCount!");
			}

		

		//AjaxResponseBody will be converted into json format and send back to client.
		return result;

	}
	
	@JsonView(Views.Public.class)
	@RequestMapping(value = "/getAllVehicleLatestLoc")
	public AjaxResponseBody getAllVehicleLatestLocAjax(@ModelAttribute VehicleSearchForm vehicleSearchForm, HttpServletRequest request){
		AjaxResponseBody result= new AjaxResponseBody();
		try {
			vehicleSearchForm = new ObjectMapper().readValue(request.getParameter("formData").trim(), VehicleSearchForm.class);
			userMasterService.getCurrentUserUsingPrinciple(request);
			List allVehicleLocationList=mapLatlngService.getAllVehicleLocation(userMasterService.getCurrentUserUsingPrinciple(request));
			if(Constant.isObjectNotNullOrNotEmpty(vehicleSearchForm.getArea())){
				if(Constant.isObjectNotNullOrNotEmpty(vehicleSearchForm.getDistance())){
					if(Constant.isObjectNotNullOrNotEmpty(vehicleSearchForm.getLat())){
						if(Constant.isObjectNotNullOrNotEmpty(vehicleSearchForm.getLng())){
							if (allVehicleLocationList != null || !allVehicleLocationList.isEmpty()) {
								List<Map<String, Object>> finalVehicleToPlotlist=new ArrayList<Map<String, Object>>();
								double lat1=Double.parseDouble(vehicleSearchForm.getLat().trim());
								double lng1=Double.parseDouble(vehicleSearchForm.getLng().trim());
								double lat2 = 0.0;
								double lng2 = 0.0;
								double distance2 = 0;
								for (Object object : allVehicleLocationList) {
									Map<String, Object> obj1 = (Map) object;
									for (Map.Entry<String, Object> entry : obj1.entrySet()) {
										if ("latitude".equals(entry.getKey())) {
											lat2 = Double.parseDouble(entry.getValue().toString().trim());
										}
										if ("longitude".equals(entry.getKey())) {
											lng2 = Double.parseDouble(entry.getValue().toString().trim());
										}
									}
									distance2 = mapLatlngService.getDistance(lat1, lng1, lat2,
											lng2, "K");
									if (Double.parseDouble(vehicleSearchForm.getDistance().trim()) >= distance2) {
										finalVehicleToPlotlist.add(obj1);
									}
								}
								allVehicleLocationList=finalVehicleToPlotlist;
							}
						}
					}
				}
			}
			if(allVehicleLocationList!=null ||!allVehicleLocationList.isEmpty()){
				result.setCode("200");
				result.setMsg("success");
				result.setResult(allVehicleLocationList);
			}else{
				result.setCode("204");
				result.setMsg("No records!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("exception occured in AjaxController.getAllVehicleLatestLocAjax.");
			logger.error(e.getMessage());
		} 
		return result;
	}



}
