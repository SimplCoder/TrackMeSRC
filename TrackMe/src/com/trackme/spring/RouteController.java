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
import com.trackme.spring.model.DeviceMaster;
import com.trackme.spring.model.DriverMaster;
import com.trackme.spring.model.Location;
import com.trackme.spring.model.LocationsForRoute;
import com.trackme.spring.model.Route;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.service.DriverMasterService;
import com.trackme.spring.service.LocationService;
import com.trackme.spring.service.RouteService;

@Controller
public class RouteController extends BaseController {

private RouteService routeService;
	
	@Autowired(required=true)
	@Qualifier(value="routeService")
	public void setRouteService(RouteService routeService) {
		this.routeService = routeService;
	}
	
	private LocationService locationService;
	
	
	
	public LocationService getLocationService() {
		return locationService;
	}

	@Autowired(required=true)
	@Qualifier(value="locationService")
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}


	
	@RequestMapping(value = "/ViewRouteDetails", method = RequestMethod.GET)
	public String viewRouteDetails(Model model) {	
		model.addAttribute("Route", new Route());
	    List<Route> routeList=this.routeService.listRouteDetails();		
		ObjectMapper objectMapper = new ObjectMapper();
		String routeJSON=null;
		try {
			routeJSON = objectMapper.writeValueAsString(routeList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("RouteJSON", routeJSON);
		return "route_view";
	}

	
	@RequestMapping(value = "/addRouteMastersView", method = RequestMethod.GET)
	public String routeView(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("routeMaster", new Route());
		model.addAttribute("locations",locationService.listLocations());
		return "route_master_entry";
	}
	
	@RequestMapping(value = "/editRouteMastersView", method = RequestMethod.GET)
	public String editRouteMaster(Model model,@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {	
		Route routeMaster=this.routeService.getRouteDetailsById(id);
		routeMaster.setEditFlag(true);
		model.addAttribute("routeMaster", routeMaster);
		model.addAttribute("locations",locationService.listLocations());
			
		return "route_master_entry";
	}
	
	//For add and update VehicleMaster both
	@RequestMapping(value= "/AddOrUpdateRouteRecord", method = RequestMethod.POST)
	public String addRoute(@ModelAttribute("routeMaster") Route routeMaster, Model model, HttpServletRequest request, HttpServletResponse response){		
		//Add Driver
		Route routeMasterExist=this.routeService.getRouteDetailsById(String.valueOf(routeMaster.getRouteName()));
		if(routeMasterExist==null){
			List<LocationsForRoute> listOfLocationsForRoiute=new ArrayList<>();
			int count=1;
			for(String location:routeMaster.getLocations()){
				LocationsForRoute locationForRoute = new LocationsForRoute();
				Location locationMaster=locationService.getLocationByName(location);
				locationForRoute.setRoute(routeMaster);
				locationForRoute.setLocation(locationMaster);
				locationForRoute.setSequence(count);
				listOfLocationsForRoiute.add(locationForRoute);
				count++;
			}
			routeMaster.setLocationsForRoute(listOfLocationsForRoiute);
			UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
			routeMaster.setCreatedBy(currentUser.getUserName());
			routeMaster.setCreatedDate(new Date());
			routeMaster.setStatus(Constant.STATUS_ACTIVE);
		routeService.addRouteDetails(routeMaster);
		addSuccessMessage("Route details added successfully.");
		
		} else{
			if(routeMaster.isEditFlag()){
				
				List<LocationsForRoute> listOfLocationsForRoiute=routeMasterExist.getLocationsForRoute();
				listOfLocationsForRoiute.removeAll(listOfLocationsForRoiute);
				int count=1;
				for(String location:routeMaster.getLocations()){
					LocationsForRoute locationForRoute = new LocationsForRoute();
					Location locationMaster=locationService.getLocationByName(location);
					locationForRoute.setRoute(routeMaster);
					locationForRoute.setLocation(locationMaster);
					locationForRoute.setSequence(count);
					listOfLocationsForRoiute.add(locationForRoute);
					count++;
				}
				//routeMasterExist.setLocationsForRoute(listOfLocationsForRoiute);
				
				UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
				routeMasterExist.setModifiedBy(currentUser.getUserName());
				routeMasterExist.setModifiedDate(new Date());
				
				routeService.updateRouteDetails(routeMasterExist);	
			addSuccessMessage("Route details updated successfully.");
			}else{
				addErrorMessage("Route Number already exists. Please enter unique value.");
				addSuccessOrErrorMessageToModel(model);
				model.addAttribute("locations",locationService.listLocations());
				
				model.addAttribute("routeMaster", routeMaster);
				   return "route_master_entry";
			}
		}
		addSuccessOrErrorMessageToModel(model);
		return viewRouteDetails(model);
		
	}
	
	@RequestMapping("/RemoveRouteMasterRecord")
    public String removeRouteMaster(@RequestParam("id") String routeName, Model model, HttpServletRequest request, HttpServletResponse response){
		
		routeService.removeRouteDetails(routeName);
	     addSuccessMessage("Route details removed successfully.");
	        addSuccessOrErrorMessageToModel(model);
			
	        return viewRouteDetails(model);
	    
    }
 
}
