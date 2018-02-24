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
import com.trackme.spring.model.CompanyMaster;
import com.trackme.spring.model.DeviceMaster;
import com.trackme.spring.model.Location;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.service.CompanyMasterService;
import com.trackme.spring.service.DeviceMasterService;
import com.trackme.spring.service.LocationService;

@Controller
public class LocationController extends BaseController{
	
	private LocationService locationService;
	
	@Autowired(required=true)
	@Qualifier(value="companyMasterService")
	private CompanyMasterService companyMasterService;
	
	
	public LocationService getLocationService() {
		return locationService;
	}

	@Autowired(required=true)
	@Qualifier(value="locationService")
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}



	
	@RequestMapping(value = "/LocationMasters", method = RequestMethod.GET)
	public String listLocationMasters(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("location", new Location());
	    List<Location> locationMasterList=this.locationService.listLocations();		
		ObjectMapper objectMapper = new ObjectMapper();
		String locationJSON=null;
		try {
			locationJSON = objectMapper.writeValueAsString(locationMasterList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("locationJSON", locationJSON);
		return "location_master_view";
	}
	
	/**
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/addLocationView", method = RequestMethod.GET)
	public String locationView(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("location", new Location());
		List<CompanyMaster> companyList=new ArrayList<CompanyMaster>();
		UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
		if(!currentUser.getRoleMaster().getRole().equals(Constant.ROLE_SUPERUSER)){
			companyList.add(currentUser.getCompanyMaster());	
		}else{
		 companyList = (ArrayList<CompanyMaster>)companyMasterService.listCompanyMasters();
		}
		model.addAttribute("companyList", companyList);
		return "location_master_entry";
	}
	
	
	@RequestMapping(value = "/EditLocationView", method = RequestMethod.GET)
	public String editLocation(Model model,@RequestParam("name") String name, HttpServletRequest request, HttpServletResponse response) {	
		Location location=this.locationService.getLocationByName(name);
		location.setEditFlag(true);
		List<CompanyMaster> companyList=new ArrayList<CompanyMaster>();
		UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
		if(!currentUser.getRoleMaster().getRole().equals(Constant.ROLE_SUPERUSER)){
			companyList.add(currentUser.getCompanyMaster());	
		}else{
		 companyList = (ArrayList<CompanyMaster>)companyMasterService.listCompanyMasters();
		}
		model.addAttribute("companyList", companyList);
		model.addAttribute("location", location);
		return "location_master_entry";
	}
	
	
	
	//For add and update VehicleMaster both
		@RequestMapping(value= "/AddOrUpdateLocationRecord", method = RequestMethod.POST)
		public String addLocation(@ModelAttribute("location") Location location, Model model, HttpServletRequest request, HttpServletResponse response){		
			//Add Driver
			Location locationExist=this.locationService.getLocationByName(location.getLocationName());
			List<CompanyMaster> companyList=new ArrayList<CompanyMaster>();
			UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
			if(!currentUser.getRoleMaster().getRole().equals(Constant.ROLE_SUPERUSER)){
				companyList.add(currentUser.getCompanyMaster());	
			}else{
			 companyList = (ArrayList<CompanyMaster>)companyMasterService.listCompanyMasters();
			}
			model.addAttribute("companyList", companyList);
			
			if(locationExist==null){
				location.setCreatedBy(currentUser.getUserName());
				location.setCreatedDate(new Date());
			
			locationService.addLocation(location);
			addSuccessMessage("Location details added successfully.");
			
			} else{
				if(location.isEditFlag()){
					location.setModifiedBy(currentUser.getUserName());
					location.setModifiedDate(new Date());
				
					locationService.updateLocation(location);	
				addSuccessMessage("Location details updated successfully.");
				}else{
					addErrorMessage("Location Name already exists. Please enter unique value.");
					addSuccessOrErrorMessageToModel(model);
					model.addAttribute("location", location);
					   return "location_master_entry";
				}
			}
			addSuccessOrErrorMessageToModel(model);
			return listLocationMasters(model,request,response);
			
		}
		
	
	@RequestMapping("/RemoveLocationRecord")
    public String removeDeviceMaster(@RequestParam("name") String name, Model model, HttpServletRequest request, HttpServletResponse response){
		
		locationService.removeLocation(name);
	     addSuccessMessage("Location details inactivated successfully.");
	        addSuccessOrErrorMessageToModel(model);
			
	        return listLocationMasters(model,request,response);
	    
    }
 

	


}
