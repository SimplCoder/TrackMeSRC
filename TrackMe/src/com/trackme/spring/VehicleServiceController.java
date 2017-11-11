package com.trackme.spring;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trackme.constants.Constant;
import com.trackme.spring.model.VehicleService;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.model.VehicleGroup;
import com.trackme.spring.model.VehicleMaster;
import com.trackme.spring.service.VehicleServiceService;
import com.trackme.spring.service.DeviceMasterService;
import com.trackme.spring.service.DriverMasterService;
import com.trackme.spring.service.LocationService;
import com.trackme.spring.service.VehicleGroupService;
import com.trackme.spring.service.VehicleMasterService;


@Controller
public class VehicleServiceController extends BaseController{

private VehicleServiceService vehicleServiceService;


@Autowired
private LocationService locationService;

@Autowired(required=true)
@Qualifier(value="driverMasterService")
private DriverMasterService driverMasterService;

@Autowired(required=true)
@Qualifier(value="vehicleMasterService")
private VehicleMasterService  vehicleMasterService;
	
	@Autowired(required=true)
	@Qualifier(value="vehicleServiceService")
	public void setVehicleServiceService(VehicleServiceService ds){
		this.vehicleServiceService = ds;
	}
	
	
	
	@RequestMapping(value = "/VehicleServices", method = RequestMethod.GET)
	public String listVehicleServices(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("VehicleService", new VehicleService());
	    List<VehicleService> vehicleService=this.vehicleServiceService.listVehicleServices();		
		ObjectMapper objectMapper = new ObjectMapper();
		String vehicleServiceJSON=null;
		try {
			vehicleServiceJSON = objectMapper.writeValueAsString(vehicleService);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("vehicleServiceJSON", vehicleServiceJSON);
		return "VehicleService_view";
	}
	
	@RequestMapping(value = "/addNoVehicleServices", method = RequestMethod.GET)
	public String altersView(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("VehicleService", new VehicleService());
		
		model.addAttribute("vehicleMasters", vehicleMasterService.listVehicleMasters());
		model.addAttribute("driverMasters", driverMasterService.getDriverMasterList());
		model.addAttribute("locationMasters", locationService.listLocations());
		return "VehicleService_entry";
	}
	
	@RequestMapping(value = "/EditVehicleServicesView", method = RequestMethod.GET)
	public String editVehicleServiceMasters(Model model,@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {	
		VehicleService vehicleService=this.vehicleServiceService.getVehicleServiceById(id);
		vehicleService.setEditFlag(true);
		
		model.addAttribute("vehicleMasters", vehicleMasterService.listVehicleMasters());
		model.addAttribute("driverMasters", driverMasterService.getDriverMasterList());
		model.addAttribute("locationMasters", locationService.listLocations());			
		model.addAttribute("VehicleService", vehicleService);
		return "VehicleService_entry";
	}
	
	//For add and update VehicleMaster both
	@RequestMapping(value= "/AddOrUpdateVehicleServicesRecord", method = RequestMethod.POST)
	public String addVehicleService(@ModelAttribute("VehicleService") VehicleService vehicleService, Model model, HttpServletRequest request, HttpServletResponse response){		
		//Add Driver
		
		
		
			VehicleService vehicleServiceExist=this.vehicleServiceService.getVehicleServiceById(String.valueOf(vehicleService.getServiceId()));
		
					
			if(vehicleServiceExist==null){
			UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
			vehicleService.setCreatedBy(currentUser.getUserName());
			vehicleService.setCreatedDate(new Date());
		
		vehicleServiceService.addVehicleService(vehicleService);
		addSuccessMessage("VehicleService details added successfully.");
		
		} else{
			if(vehicleService.isEditFlag()){
				UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
				vehicleService.setModifiedBy(currentUser.getUserName());
				vehicleService.setModifiedDate(new Date());
			
				vehicleServiceService.updateVehicleService(vehicleService);	
			addSuccessMessage("VehicleService details updated successfully.");
			}else{
				addErrorMessage("VehicleService already exists. Please enter unique vehicleService.");
				addSuccessOrErrorMessageToModel(model);
				model.addAttribute("VehicleService", vehicleService);
				   return "VehicleService_entry";
			}
		}
		addSuccessOrErrorMessageToModel(model);
		return listVehicleServices(model,request,response);
		
	}
	
	@RequestMapping("/RemoveVehicleServicesRecord")
    public String removeVehicleService(@RequestParam("id") String deviceNo, Model model, HttpServletRequest request, HttpServletResponse response){
		
		vehicleServiceService.removeVehicleService(deviceNo);
	     addSuccessMessage("VehicleService details removed successfully.");
	        addSuccessOrErrorMessageToModel(model);
			
	        return listVehicleServices(model,request,response);
	    
    }
 

	
}
