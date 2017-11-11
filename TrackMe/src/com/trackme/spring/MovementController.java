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
import com.trackme.spring.model.Movement;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.model.VehicleGroup;
import com.trackme.spring.model.VehicleMaster;
import com.trackme.spring.service.MovementService;
import com.trackme.spring.service.VehicleGroupService;
import com.trackme.spring.service.VehicleMasterService;


@Controller
public class MovementController extends BaseController{

private MovementService movementService;

@Autowired(required=true)
@Qualifier(value="vehicleGroupService")
private VehicleGroupService vehicleGroupService;

@Autowired(required=true)
@Qualifier(value="vehicleMasterService")
private VehicleMasterService  vehicleMasterService;
	
	@Autowired(required=true)
	@Qualifier(value="movementService")
	public void setMovementService(MovementService ds){
		this.movementService = ds;
	}
	
	
	
	@RequestMapping(value = "/Movements", method = RequestMethod.GET)
	public String listMovements(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("Movement", new Movement());
	    List<Movement> movement=this.movementService.listMovements();		
		ObjectMapper objectMapper = new ObjectMapper();
		String movementJSON=null;
		try {
			movementJSON = objectMapper.writeValueAsString(movement);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("movementJSON", movementJSON);
		return "No_movements_view";
	}
	
	@RequestMapping(value = "/addNoMovements", method = RequestMethod.GET)
	public String altersView(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("Movement", new Movement());
		ArrayList<VehicleMaster> vehicleMasters = (ArrayList<VehicleMaster>) vehicleMasterService.listVehicleMasters();
		model.addAttribute("vehicleMasters", vehicleMasters);
		
		ArrayList<VehicleGroup> vehicleGroups = (ArrayList<VehicleGroup>) vehicleGroupService.listVehicleGroup();
		model.addAttribute("vehicleGroups", vehicleGroups);
		
		return "No_movements_entry";
	}
	
	@RequestMapping(value = "/EditMovementsView", method = RequestMethod.GET)
	public String editMovementMasters(Model model,@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {	
		Movement movement=this.movementService.getMovementById(id);
		movement.setEditFlag(true);
		model.addAttribute("Movement", movement);
		return "No_movements_entry";
	}
	
	//For add and update VehicleMaster both
	@RequestMapping(value= "/AddOrUpdateMovementsRecord", method = RequestMethod.POST)
	public String addMovement(@ModelAttribute("Movement") Movement movement, Model model, HttpServletRequest request, HttpServletResponse response){		
		//Add Driver
		
		ArrayList<VehicleMaster> vehicleMasters = (ArrayList<VehicleMaster>) vehicleMasterService.listVehicleMasters();
		model.addAttribute("vehicleMasters", vehicleMasters);
		
		ArrayList<VehicleGroup> vehicleGroups = (ArrayList<VehicleGroup>) vehicleGroupService.listVehicleGroup();
		model.addAttribute("vehicleGroups", vehicleGroups);
		Movement movementExist=this.movementService.getMovementById(String.valueOf(movement.getId()));
		if(movementExist==null){
			UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
			movement.setCreatedBy(currentUser.getUserName());
			movement.setCreatedDate(new Date());
		
		movementService.addMovement(movement);
		addSuccessMessage("Movement details added successfully.");
		
		} else{
			if(movement.isEditFlag()){
				UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
				movement.setModifiedBy(currentUser.getUserName());
				movement.setModifiedDate(new Date());
			
				movementService.updateMovement(movement);	
			addSuccessMessage("Movement details updated successfully.");
			}else{
				addErrorMessage("Movement already exists. Please enter unique movement.");
				addSuccessOrErrorMessageToModel(model);
				model.addAttribute("Movement", movement);
				   return "No_movements_entry";
			}
		}
		addSuccessOrErrorMessageToModel(model);
		return listMovements(model,request,response);
		
	}
	
	@RequestMapping("/RemoveMovementsRecord")
    public String removeMovement(@RequestParam("id") String deviceNo, Model model, HttpServletRequest request, HttpServletResponse response){
		
		movementService.removeMovement(deviceNo);
	     addSuccessMessage("Movement details removed successfully.");
	        addSuccessOrErrorMessageToModel(model);
			
	        return listMovements(model,request,response);
	    
    }
 

	
}
