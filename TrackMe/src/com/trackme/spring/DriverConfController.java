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
import com.trackme.spring.model.DriverConf;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.model.VehicleGroup;
import com.trackme.spring.model.VehicleMaster;
import com.trackme.spring.service.DriverConfService;
import com.trackme.spring.service.DriverMasterService;
import com.trackme.spring.service.DeviceMasterService;
import com.trackme.spring.service.LocationService;
import com.trackme.spring.service.RouteScheduleService;
import com.trackme.spring.service.RouteService;
import com.trackme.spring.service.VehicleGroupService;
import com.trackme.spring.service.VehicleMasterService;


@Controller
public class DriverConfController extends BaseController{

private DriverConfService driverConfService;

@Autowired(required=true)
@Qualifier(value="driverMasterService")
private DriverMasterService driverMasterService;

@Autowired(required=true)
@Qualifier(value="vehicleMasterService")
private VehicleMasterService  vehicleMasterService;


@Autowired(required=true)
@Qualifier(value="routeScheduleService")
private RouteScheduleService  routeScheduleService   ;
	
	@Autowired(required=true)
	@Qualifier(value="driverConfService")
	public void setDriverConfService(DriverConfService ds){
		this.driverConfService = ds;
	}
	
	
	
	@RequestMapping(value = "/DriverConfs", method = RequestMethod.GET)
	public String listDriverConfs(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("DriverConf", new DriverConf());
	    List<DriverConf> driverConf=this.driverConfService.listDriverConfs();		
		ObjectMapper objectMapper = new ObjectMapper();
		String driverConfJSON=null;
		try {
			driverConfJSON = objectMapper.writeValueAsString(driverConf);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("driverConfJSON", driverConfJSON);
		return "DriverConf_view";
	}
	
	@RequestMapping(value = "/addNoDriverConfs", method = RequestMethod.GET)
	public String altersView(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("DriverConf", new DriverConf());
		
		model.addAttribute("vehicles", vehicleMasterService.listVehicleMasters());
		model.addAttribute("drivers", driverMasterService.getDriverMasterList());
		return "DriverConf_entry";
	}
	
	@RequestMapping(value = "/EditDriverConfsView", method = RequestMethod.GET)
	public String editDriverConfMasters(Model model,@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {	
		DriverConf driverConf=this.driverConfService.getDriverConfById(id);
		driverConf.setEditFlag(true);
		
		model.addAttribute("vehicles", vehicleMasterService.listVehicleMasters());
		model.addAttribute("drivers", driverMasterService.getDriverMasterList());
				
		model.addAttribute("DriverConf", driverConf);
		return "DriverConf_entry";
	}
	
	//For add and update VehicleMaster both
	@RequestMapping(value= "/AddOrUpdateDriverConfsRecord", method = RequestMethod.POST)
	public String addDriverConf(@ModelAttribute("DriverConf") DriverConf driverConf, Model model, HttpServletRequest request, HttpServletResponse response){		
		//Add Driver
		
		
		
			DriverConf driverConfExist=this.driverConfService.getDriverConfById(String.valueOf(driverConf.getId()));
		
					
			if(driverConfExist==null){
			UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
			driverConf.setCreatedBy(currentUser.getUserName());
			driverConf.setCreatedDate(new Date());
		
		driverConfService.addDriverConf(driverConf);
		addSuccessMessage("DriverConf details added successfully.");
		
		} else{
			if(driverConf.isEditFlag()){
				UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
				driverConf.setModifiedBy(currentUser.getUserName());
				driverConf.setModifiedDate(new Date());
			
				driverConfService.updateDriverConf(driverConf);	
			addSuccessMessage("DriverConf details updated successfully.");
			}else{
				addErrorMessage("DriverConf already exists. Please enter unique driverConf.");
				addSuccessOrErrorMessageToModel(model);
				model.addAttribute("DriverConf", driverConf);
				   return "DriverConf_entry";
			}
		}
		addSuccessOrErrorMessageToModel(model);
		return listDriverConfs(model,request,response);
		
	}
	
	@RequestMapping("/RemoveDriverConfsRecord")
    public String removeDriverConf(@RequestParam("id") String deviceNo, Model model, HttpServletRequest request, HttpServletResponse response){
		
		driverConfService.removeDriverConf(deviceNo);
	     addSuccessMessage("DriverConf details removed successfully.");
	        addSuccessOrErrorMessageToModel(model);
			
	        return listDriverConfs(model,request,response);
	    
    }
 

	
}
