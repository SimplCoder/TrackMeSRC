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
import com.trackme.spring.model.VehicleIO;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.model.VehicleGroup;
import com.trackme.spring.model.VehicleMaster;
import com.trackme.spring.service.VehicleIOService;
import com.trackme.spring.service.DeviceMasterService;
import com.trackme.spring.service.VehicleGroupService;
import com.trackme.spring.service.VehicleMasterService;


@Controller
public class VehicleIOController extends BaseController{

private VehicleIOService vehicleIOService;

@Autowired(required=true)
@Qualifier(value="deviceMasterService")
private DeviceMasterService deviceMasterService;

@Autowired(required=true)
@Qualifier(value="vehicleMasterService")
private VehicleMasterService  vehicleMasterService;
	
	@Autowired(required=true)
	@Qualifier(value="vehicleIOService")
	public void setVehicleIOService(VehicleIOService ds){
		this.vehicleIOService = ds;
	}
	
	
	
	@RequestMapping(value = "/VehicleIOs", method = RequestMethod.GET)
	public String listVehicleIOs(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("VehicleIO", new VehicleIO());
	    List<VehicleIO> vehicleIO=this.vehicleIOService.listVehicleIOs();		
		ObjectMapper objectMapper = new ObjectMapper();
		String vehicleIOJSON=null;
		try {
			vehicleIOJSON = objectMapper.writeValueAsString(vehicleIO);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("vehicleIOJSON", vehicleIOJSON);
		return "VehicleIO_view";
	}
	
	@RequestMapping(value = "/addNoVehicleIOs", method = RequestMethod.GET)
	public String altersView(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("VehicleIO", new VehicleIO());
		
		model.addAttribute("vehicleMasters", vehicleMasterService.listVehicleMasters());
		model.addAttribute("deviceMasters", deviceMasterService.listDeviceMasters());
		return "VehicleIO_entry";
	}
	
	@RequestMapping(value = "/EditVehicleIOsView", method = RequestMethod.GET)
	public String editVehicleIOMasters(Model model,@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {	
		VehicleIO vehicleIO=this.vehicleIOService.getVehicleIOById(id);
		vehicleIO.setEditFlag(true);
		
		model.addAttribute("vehicleMasters", vehicleMasterService.listVehicleMasters());
		model.addAttribute("deviceMasters", deviceMasterService.listDeviceMasters());
				
		model.addAttribute("VehicleIO", vehicleIO);
		return "VehicleIO_entry";
	}
	
	//For add and update VehicleMaster both
	@RequestMapping(value= "/AddOrUpdateVehicleIOsRecord", method = RequestMethod.POST)
	public String addVehicleIO(@ModelAttribute("VehicleIO") VehicleIO vehicleIO, Model model, HttpServletRequest request, HttpServletResponse response){		
		//Add Driver
		
		
		
			VehicleIO vehicleIOExist=this.vehicleIOService.getVehicleIOById(String.valueOf(vehicleIO.getId()));
		
					
			if(vehicleIOExist==null){
			UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
			vehicleIO.setCreatedBy(currentUser.getUserName());
			vehicleIO.setCreatedDate(new Date());
		
		vehicleIOService.addVehicleIO(vehicleIO);
		addSuccessMessage("VehicleIO details added successfully.");
		
		} else{
			if(vehicleIO.isEditFlag()){
				UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
				vehicleIO.setModifiedBy(currentUser.getUserName());
				vehicleIO.setModifiedDate(new Date());
			
				vehicleIOService.updateVehicleIO(vehicleIO);	
			addSuccessMessage("VehicleIO details updated successfully.");
			}else{
				addErrorMessage("VehicleIO already exists. Please enter unique vehicleIO.");
				addSuccessOrErrorMessageToModel(model);
				model.addAttribute("VehicleIO", vehicleIO);
				   return "VehicleIO_entry";
			}
		}
		addSuccessOrErrorMessageToModel(model);
		return listVehicleIOs(model,request,response);
		
	}
	
	@RequestMapping("/RemoveVehicleIOsRecord")
    public String removeVehicleIO(@RequestParam("id") String deviceNo, Model model, HttpServletRequest request, HttpServletResponse response){
		
		vehicleIOService.removeVehicleIO(deviceNo);
	     addSuccessMessage("VehicleIO details removed successfully.");
	        addSuccessOrErrorMessageToModel(model);
			
	        return listVehicleIOs(model,request,response);
	    
    }
 

	
}
