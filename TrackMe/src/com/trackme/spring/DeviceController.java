package com.trackme.spring;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trackme.constants.Constant;
import com.trackme.spring.model.DeviceMaster;
import com.trackme.spring.model.DriverMaster;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.service.DeviceMasterService;
import com.trackme.spring.service.DriverMasterService;


@Controller
public class DeviceController extends BaseController{

private DeviceMasterService deviceMasterService;
	
	@Autowired(required=true)
	@Qualifier(value="deviceMasterService")
	public void setDeviceMasterService(DeviceMasterService ds){
		this.deviceMasterService = ds;
	}
	
	@RequestMapping(value = "/DeviceMasters", method = RequestMethod.GET)
	public String listDriverMasters(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("DeviceMaster", new DeviceMaster());
	    List<DeviceMaster> deviceMaster=this.deviceMasterService.listDeviceMasters();		
		ObjectMapper objectMapper = new ObjectMapper();
		String deviceMasterJSON=null;
		try {
			deviceMasterJSON = objectMapper.writeValueAsString(deviceMaster);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("deviceMasterJSON", deviceMasterJSON);
		return "device_master_view";
	}
	
	@RequestMapping(value = "/addDeviceMastersView", method = RequestMethod.GET)
	public String driverMasterMastersView(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("DeviceMaster", new DeviceMaster());
		return "device_master_entry";
	}
	
	@RequestMapping(value = "/EditDeviceMastersView", method = RequestMethod.GET)
	public String editDriverMasterMasters(Model model,@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {	
		DeviceMaster deviceMaster=this.deviceMasterService.getDeviceMasterById(id);
		deviceMaster.setEditFlag(true);
		model.addAttribute("DeviceMaster", deviceMaster);
		return "device_master_entry";
	}
	
	//For add and update VehicleMaster both
	@RequestMapping(value= "/AddOrUpdateDeviceMastersRecord", method = RequestMethod.POST)
	public String addDeviceMaster(@ModelAttribute("DeviceMaster") DeviceMaster deviceMaster, Model model, HttpServletRequest request, HttpServletResponse response){		
		//Add Driver
		DeviceMaster deviceMasterExist=this.deviceMasterService.getDeviceMasterById(String.valueOf(deviceMaster.getDeviceNo()));
		if(deviceMasterExist==null){
			UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
			deviceMaster.setCreatedBy(currentUser.getUserName());
			deviceMaster.setCreatedDate(new Date());
		
		deviceMasterService.addDeviceMaster(deviceMaster);
		addSuccessMessage("Device details added successfully.");
		
		} else{
			if(deviceMaster.isEditFlag()){
				UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
				deviceMaster.setModifiedBy(currentUser.getUserName());
				deviceMaster.setModifiedDate(new Date());
			
				deviceMasterService.updateDeviceMaster(deviceMaster);	
			addSuccessMessage("Device details updated successfully.");
			}else{
				addErrorMessage("Device Number already exists. Please enter unique value.");
				addSuccessOrErrorMessageToModel(model);
				model.addAttribute("DeviceMaster", deviceMaster);
				   return "device_master_entry";
			}
		}
		addSuccessOrErrorMessageToModel(model);
		return listDriverMasters(model,request,response);
		
	}
	
	@RequestMapping("/RemoveDeviceMastersRecord")
    public String removeDeviceMaster(@RequestParam("id") String deviceNo, Model model, HttpServletRequest request, HttpServletResponse response){
		
		deviceMasterService.removeDeviceMaster(deviceNo);
	     addSuccessMessage("Device details removed successfully.");
	        addSuccessOrErrorMessageToModel(model);
			
	        return listDriverMasters(model,request,response);
	    
    }
 

	
}
