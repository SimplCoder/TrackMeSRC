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
import com.trackme.spring.model.DriverMaster;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.service.DriverMasterService;


@Controller
public class DriverController extends BaseController {

   private DriverMasterService driverMasterService;
	
	@Autowired(required=true)
	@Qualifier(value="driverMasterService")
	public void setDriverMasterService(DriverMasterService ds){
		this.driverMasterService = ds;
	}
	
	@RequestMapping(value = "/DriverMasters", method = RequestMethod.GET)
	public String listDriverMasters(Model model) {	
		model.addAttribute("DriverMaster", new DriverMaster());
	    List<DriverMaster> driverMaster=this.driverMasterService.getDriverMasterList();		
		ObjectMapper objectMapper = new ObjectMapper();
		String driverMasterJSON=null;
		try {
			driverMasterJSON = objectMapper.writeValueAsString(driverMaster);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("DriverMasterJSON", driverMasterJSON);
		return "driver_master_view";
	}
	
	@RequestMapping(value = "/AddDriverMastersView", method = RequestMethod.GET)
	public String driverMasterMastersView(Model model) {	
		model.addAttribute("DriverMaster", new DriverMaster());
		return "driver_master_entry";
	}
	
	@RequestMapping(value = "/EditDriverMastersView", method = RequestMethod.GET)
	public String editDriverMasterMasters(Model model,@RequestParam("id") String id) {	
		DriverMaster driver=this.driverMasterService.getDriverMasterById(id); 
		driver.setEditFlag(true);
		model.addAttribute("DriverMaster",driver );
		return "driver_master_entry";
	}
	
	//For add and update VehicleMaster both
	@RequestMapping(value= "/AddOrUpdateDriverMastersRecord", method = RequestMethod.POST)
	public String addDriverMaster(@ModelAttribute("DriverMaster") DriverMaster driverMaster, Model model, HttpServletRequest request, HttpServletResponse response){		
		//Add Driver
		DriverMaster driverMasterExist=this.driverMasterService.getDriverMasterById(String.valueOf(driverMaster.getId()));
		if(driverMasterExist==null){
			UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
			driverMaster.setCreatedBy(currentUser.getUserName());
			driverMaster.setCreatedDate(new Date());
			
			driverMasterService.addDriverMaster(driverMaster);
			addSuccessMessage("Driver details added successfully.");
		
		} else{
			if(driverMaster.isEditFlag()){
				UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
				driverMaster.setModifiedBy(currentUser.getUserName());
				driverMaster.setModifiedDate(new Date());
				
				driverMasterService.updateDriverMaster(driverMaster);
			addSuccessMessage("Driver details updated successfully.");
			
			}else{
				addErrorMessage("Driver Number already exists. Please enter unique value.");
				addSuccessOrErrorMessageToModel(model);
				model.addAttribute("DriverMaster", driverMaster);
				   return "driver_master_entry";

				
			}
		}
		addSuccessOrErrorMessageToModel(model);
		return listDriverMasters(model);
		
		
	}
	
	@RequestMapping("/RemoveDriverMastersRecord")
    public String removeDriverMaster(@RequestParam("id") String driverId ,Model model){
		
		driverMasterService.removeDriverMaster(driverId);
		  addSuccessMessage("Driver details removed successfully.");
	        addSuccessOrErrorMessageToModel(model);
			
	        return listDriverMasters(model);
	    
	}
 

	
}
