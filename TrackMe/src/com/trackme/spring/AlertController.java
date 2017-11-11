package com.trackme.spring;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trackme.constants.Constant;
import com.trackme.spring.model.Alert;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.model.VehicleGroup;
import com.trackme.spring.model.VehicleMaster;
import com.trackme.spring.service.AlertService;
import com.trackme.spring.service.VehicleGroupService;
import com.trackme.spring.service.VehicleMasterService;


@Controller
public class AlertController extends BaseController{

private AlertService alertService;

@Autowired(required=true)
@Qualifier(value="vehicleGroupService")
private VehicleGroupService vehicleGroupService;

@Autowired(required=true)
@Qualifier(value="vehicleMasterService")
private VehicleMasterService  vehicleMasterService;
	
	@Autowired(required=true)
	@Qualifier(value="alertService")
	public void setAlertService(AlertService ds){
		this.alertService = ds;
	}
	
	
	
	@RequestMapping(value = "/Alerts", method = RequestMethod.GET)
	public String listAlerts(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("Alert", new Alert());
	    List<Alert> alert=this.alertService.listAlerts();		
		ObjectMapper objectMapper = new ObjectMapper();
		String alertJSON=null;
		try {
			alertJSON = objectMapper.writeValueAsString(alert);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("alertJSON", alertJSON);
		return "alert_master_view";
	}
	
	@RequestMapping(value = "/addAlertsView", method = RequestMethod.GET)
	public String altersView(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("Alert", new Alert());
		ArrayList<VehicleMaster> vehicleMasters = (ArrayList<VehicleMaster>) vehicleMasterService.listVehicleMasters();
		model.addAttribute("vehicleMasters", vehicleMasters);
		
		ArrayList<VehicleGroup> vehicleGroups = (ArrayList<VehicleGroup>) vehicleGroupService.listVehicleGroup();
		model.addAttribute("vehicleGroups", vehicleGroups);
		
		return "alert_master_entry";
	}
	
	@RequestMapping(value = "/EditAlertsView", method = RequestMethod.GET)
	public String editAlertMasters(Model model,@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {	
		Alert alert=this.alertService.getAlertById(id);
		alert.setEditFlag(true);
		model.addAttribute("Alert", alert);
		return "alert_master_entry";
	}
	
	//For add and update VehicleMaster both
	@RequestMapping(value= "/AddOrUpdateAlertsRecord", method = RequestMethod.POST)
	public String addAlert(@ModelAttribute("Alert") Alert alert, Model model, HttpServletRequest request, HttpServletResponse response){		
		//Add Driver
		
		ArrayList<VehicleMaster> vehicleMasters = (ArrayList<VehicleMaster>) vehicleMasterService.listVehicleMasters();
		model.addAttribute("vehicleMasters", vehicleMasters);
		
		ArrayList<VehicleGroup> vehicleGroups = (ArrayList<VehicleGroup>) vehicleGroupService.listVehicleGroup();
		model.addAttribute("vehicleGroups", vehicleGroups);
		Alert alertExist=this.alertService.getAlertById(String.valueOf(alert.getVehicleNo()));
		if(alertExist==null){
			UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
			alert.setCreatedBy(currentUser.getUserName());
			alert.setCreatedDate(new Date());
		
		alertService.addAlert(alert);
		addSuccessMessage("Alert details added successfully.");
		
		} else{
			if(alert.isEditFlag()){
				UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
				alert.setModifiedBy(currentUser.getUserName());
				alert.setModifiedDate(new Date());
			
				alertService.updateAlert(alert);	
			addSuccessMessage("Alert details updated successfully.");
			}else{
				addErrorMessage("Alert already exists. Please enter unique alert.");
				addSuccessOrErrorMessageToModel(model);
				model.addAttribute("Alert", alert);
				   return "alert_master_entry";
			}
		}
		addSuccessOrErrorMessageToModel(model);
		return listAlerts(model,request,response);
		
	}
	
	@RequestMapping("/RemoveAlertsRecord")
    public String removeAlert(@RequestParam("id") String deviceNo, Model model, HttpServletRequest request, HttpServletResponse response){
		
		alertService.removeAlert(deviceNo);
	     addSuccessMessage("Alert details removed successfully.");
	        addSuccessOrErrorMessageToModel(model);
			
	        return listAlerts(model,request,response);
	    
    }
 

	
}
