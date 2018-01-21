package com.trackme.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
import com.trackme.spring.model.CompanyMaster;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.model.VehicleMaster;
import com.trackme.spring.service.CompanyMasterService;
import com.trackme.spring.service.MapLatlngService;
import com.trackme.spring.service.UserMasterService;
import com.trackme.spring.service.VehicleGroupService;
import com.trackme.spring.service.VehicleMasterService;

@Controller
public class VehicleMasterController extends BaseController {
	
	private VehicleMasterService vehicleMasterService;
	
	public VehicleGroupService VehicleGroupService;
	
	@Autowired
	private MapLatlngService mapLatlngService;
	
	@Autowired
	private UserMasterService userMasterService;
	
	
CompanyMasterService companyMasterService;
	
	@Autowired(required=true)
	@Qualifier(value="companyMasterService")
	public void setCompanyMasterServicee(CompanyMasterService ps){
		this.companyMasterService = ps;
	}
	
	
	public VehicleGroupService getVehicleGroupService() {
		return VehicleGroupService;
	}
	@Autowired(required=true)
	@Qualifier(value="vehicleGroupService")
	public void setVehicleGroupService(VehicleGroupService vehicleGroupService) {
		VehicleGroupService = vehicleGroupService;
	}

	@Autowired(required=true)
	@Qualifier(value="vehicleMasterService")
	public void setVehicleMasterService(VehicleMasterService ps){
		this.vehicleMasterService = ps;
	}
	
	@RequestMapping(value = "/VehicleMasters", method = RequestMethod.GET)
	public String listVehicleMasters(Model model , HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("VehicleMaster", new VehicleMaster());
	
	    List<VehicleMaster> vehicleMasters=	this.vehicleMasterService.listVehicleMasters();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String vehicleMastersJSON=null; 
		try {
			vehicleMastersJSON = objectMapper.writeValueAsString(vehicleMasters);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("vehicleMastersJSON", vehicleMastersJSON);
		return "Vehicle_master_view";
	}
	 
	//For add and update VehicleMaster both
	@RequestMapping(value= "/VehicleMasterSave", method = RequestMethod.POST)
	public String addVehicleMaster(@ModelAttribute("VehicleMaster") VehicleMaster p, Model model, HttpServletRequest request, HttpServletResponse response){
		if(vehicleMasterService.getVehicleMasterById(p.getVehicleNo()) ==null){
			//new VehicleMaster, add it
			UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
			p.setCreatedBy(currentUser.getUserName());
			p.setCreatedDate(new Date());
			p.setStatus(Constant.STATUS_ACTIVE);
			this.vehicleMasterService.addVehicleMaster(p);
			addSuccessMessage("Vehicle details added successfully.");
			
		}else{
			//existing VehicleMaster, call update
			if(p.isEditFlag()){
				UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
				p.setModifiedBy(currentUser.getUserName());
				p.setModifiedDate(new Date());
				this.vehicleMasterService.updateVehicleMaster(p);
				addSuccessMessage("Vehicle details updated successfully.");
			}else{
				addErrorMessage("Vehicle Number already exists. Please enter unique value.");
				addSuccessOrErrorMessageToModel(model);
				model.addAttribute("VehicleMaster", p);
				   return "Vehicle_master_addNew";
			}
		}
		addSuccessOrErrorMessageToModel(model);
		return listVehicleMasters(model,request,response);
		
	}
	
	@RequestMapping("/VehicleMasterRemove")
    public String removeVehicleMaster(@RequestParam("id") String id, Model model, HttpServletRequest request, HttpServletResponse response){
		
        this.vehicleMasterService.removeVehicleMaster(id);
        addSuccessMessage("Vehicle details removed successfully.");
        addSuccessOrErrorMessageToModel(model);
		
        return listVehicleMasters(model,request,response);
    }
  
    @RequestMapping("/VehicleMasterEdit")
    public String editVehicleMaster(@RequestParam("id") String id, Model model, HttpServletRequest request, HttpServletResponse response){
    	List<CompanyMaster> companyMasters=	this.companyMasterService.listCompanyMasters();
   	 model.addAttribute("companyMasters", companyMasters);
   	model.addAttribute("vehicleGroup",VehicleGroupService.listVehicleGroup());
    model.addAttribute("listVehicleMasters", this.vehicleMasterService.listVehicleMasters());
  	
    	if(id.equals("new")){
    		model.addAttribute("VehicleMaster", new VehicleMaster());
    	}else{
    		VehicleMaster vehicleMaster=vehicleMasterService.getVehicleMasterById(id);
    		vehicleMaster.setEditFlag(true);
        model.addAttribute("VehicleMaster",vehicleMaster );
        }
    	  return "Vehicle_master_addNew";
    }
    
    
    @RequestMapping("/VehicleView")
    public String showVehicleView(Locale locale,Model model, HttpServletRequest request, HttpServletResponse response){
    	List mapLatlngList = mapLatlngService.getAllVehicleLocation(userMasterService.getCurrentUserUsingPrinciple(request));

    	Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String allVehicleLocationJson = null;
		try {
			allVehicleLocationJson = objectMapper
					.writeValueAsString(mapLatlngList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("JSON=== "+allVehicleLocationJson);
		model.addAttribute("allVehicleLocation", allVehicleLocationJson);
		model.addAttribute("serverTime", formattedDate);
		
    	
    	
    	return "vehicle_view";
    }
	
	@RequestMapping(value = "/VehicleInfo", method = RequestMethod.GET)
	public String showVehicleInfo(Model model , HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("VehicleMaster", new VehicleMaster());
	
	    List<VehicleMaster> vehicleMasters=	this.vehicleMasterService.listVehicleMasters();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String vehicleMastersJSON=null; 
		try {
			vehicleMastersJSON = objectMapper.writeValueAsString(vehicleMasters);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("vehicleMastersJSON", vehicleMastersJSON);
		return "Vehicle_info_view";
	}
}
