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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trackme.constants.Constant;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.model.VehicleGroup;
import com.trackme.spring.model.VehicleMaster;
import com.trackme.spring.service.VehicleGroupService;
import com.trackme.spring.service.VehicleMasterService;

@Controller
public class VehicleGroupController extends BaseController{
	
	private VehicleGroupService vehicleGroupService;
	
	@Autowired
	private VehicleMasterService vehicleMasterService;
	
	@Autowired(required=true)
	@Qualifier(value="vehicleGroupService")
	public void setVehicleGroupService(VehicleGroupService vehicleGroupService){
		this.vehicleGroupService = vehicleGroupService;
	}
	
	@RequestMapping(value = "/VehicleGroupView", method = RequestMethod.GET)
	public String vehicleGroupView(Model model) {	
		 List<VehicleGroup> vehicleGroupList=	this.vehicleGroupService.listVehicleGroup();
			
			ObjectMapper objectMapper = new ObjectMapper();
			String vehicleGroupJSON=null; 
			try {
				vehicleGroupJSON = objectMapper.writeValueAsString(vehicleGroupList);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			model.addAttribute("vehicleGroupJSON", vehicleGroupJSON);
		return "VehicleGroup_view";
	}
	
	
	    //For add and update VehicleMaster both
		@RequestMapping(value= "/AddOrUpdateVehicleGroup", method = RequestMethod.POST)
		public String addVehicleGroup(@ModelAttribute("VehicleGroup") VehicleGroup vehicleGroup,Model model, HttpServletRequest request, HttpServletResponse response){		
			//Add Driver
			UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
			
			model.addAttribute("vehicles", vehicleMasterService.listVehicleMasters());
			VehicleGroup vehicleGroupExist=this.vehicleGroupService.getVehicleGroupById(vehicleGroup.getId());
			if(vehicleGroupExist==null){
				vehicleGroup.setCreatedBy(currentUser.getUserName());
					vehicleGroup.setCreatedDate(new Date());
				
				vehicleGroupService.addVehicleGroup(vehicleGroup);
				addSuccessMessage("Vehicle group details added successfully.");
				
			} else{
				if(vehicleGroup.isEditFlag()){
					vehicleGroup.setModifiedBy(currentUser.getUserName());
					vehicleGroup.setModifiedDate(new Date());
				   
				vehicleGroupService.reomoveExistingVehiclesFromGroup(vehicleGroup.getId());	
				vehicleGroupService.updateVehicleGroup(vehicleGroup);
				addSuccessMessage("Vehicle group details updated successfully.");
				}else{
					addErrorMessage("Vehicle group name already exists. Please enter unique value.");
					addSuccessOrErrorMessageToModel(model);
					model.addAttribute("VehicleGroup", vehicleGroup);
					  }

			}
			addSuccessOrErrorMessageToModel(model);
			
			 return vehicleGroupView(model);
						
		}
		
		
		@RequestMapping(value= "/NewVehicleGroup", method = RequestMethod.GET)
		public String newVehicleGroup(Model model, HttpServletRequest request, HttpServletResponse response){		
			//Add Driver
			model.addAttribute("vehicles", vehicleMasterService.listVehicleMasters());
			VehicleGroup vehicleGroup=new VehicleGroup();
			vehicleGroup.setEditFlag(false);
			
			model.addAttribute("VehicleGroup", vehicleGroup);
						
			 return "VehicleGroup_entry";
						
		}
		
		@RequestMapping(value= "/editVehicleGroup", method = RequestMethod.GET)
		public String editVehicleGroup(Model model,@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response){		
			//Add Driver
			model.addAttribute("vehicles", vehicleMasterService.listVehicleMasters());
			VehicleGroup vehicleGroupExist=this.vehicleGroupService.getVehicleGroupById(id);
			vehicleGroupExist.setEditFlag(true);
			
			model.addAttribute("VehicleGroup", vehicleGroupExist);
						
			 return "VehicleGroup_entry";
						
		}
		
		
		@RequestMapping("/RemoveVehicleGroupRecord")
	    public String removeDriverMaster( Model model,@RequestParam("id") String vehicleGroupId){
			
			vehicleGroupService.removeVehicleGroup(vehicleGroupId);
			  addSuccessMessage("Vehicle group removed successfully.");
		        addSuccessOrErrorMessageToModel(model);
			
	        return vehicleGroupView(model) ;
	    }
}
