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
import com.trackme.spring.model.FuelDetail;
import com.trackme.spring.model.FuelDetail;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.service.FuelService;

@Controller
public class FuelController extends BaseController {

	private FuelService fuelService;

	@Autowired(required=true)
	@Qualifier(value="fuelService")
	public void setFuelService(FuelService fuelService) {
		this.fuelService = fuelService;
	}
	
	@RequestMapping(value = "/ViewFuelDetails", method = RequestMethod.GET)
	public String viewFuelDetails(Model model) {	
		model.addAttribute("FuelDetail", new FuelDetail());
	    List<FuelDetail> fuelDetails=this.fuelService.listFuelDetails();	
		ObjectMapper objectMapper = new ObjectMapper();
		String fuelDetailsJSON=null;
		try {
			fuelDetailsJSON = objectMapper.writeValueAsString(fuelDetails);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("FuelDetailsJSON", fuelDetailsJSON);
		return "fuel_view";
	}
	

	@RequestMapping(value = "/addFuelView", method = RequestMethod.GET)
	public String driverMasterMastersView(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("FuelDetail", new FuelDetail());
		return "fuel_master_entry";
	}
	
	@RequestMapping(value = "/EditFuelDetailsView", method = RequestMethod.GET)
	public String editDriverMasterMasters(Model model,@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {	
		FuelDetail FuelDetail=this.fuelService.getFuelDetailsById(id);
		FuelDetail.setEditFlag(true);
		model.addAttribute("FuelDetail", FuelDetail);
		return "fuel_master_entry";
	}
	
	//For add and update VehicleMaster both
	@RequestMapping(value= "/AddOrUpdateFuelDetailsRecord", method = RequestMethod.POST)
	public String addFuelDetail(@ModelAttribute("FuelDetail") FuelDetail FuelDetail, Model model, HttpServletRequest request, HttpServletResponse response){		
		//Add Driver
		FuelDetail FuelDetailExist=this.fuelService.getFuelDetailsById(String.valueOf(FuelDetail.getTranId()));
		if(FuelDetailExist==null){
			UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
			FuelDetail.setCreatedBy(currentUser.getUserName());
			FuelDetail.setCreatedDate(new Date());
		
			fuelService.addFuelDetails(FuelDetail);
		addSuccessMessage("Fuel details added successfully.");
		
		} else{
			if(FuelDetail.isEditFlag()){
				UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
				FuelDetail.setModifiedBy(currentUser.getUserName());
				FuelDetail.setModifiedDate(new Date());
			
				fuelService.updateFuelDetails(FuelDetail);	
			addSuccessMessage("Device details updated successfully.");
			}else{
				addErrorMessage("Device Number already exists. Please enter unique value.");
				addSuccessOrErrorMessageToModel(model);
				model.addAttribute("FuelDetail", FuelDetail);
				   return "fuel_master_entry";
			}
		}
		addSuccessOrErrorMessageToModel(model);
		return viewFuelDetails(model);
		
	}
	
	@RequestMapping("/RemoveFuelDetailsRecord")
    public String removeFuelDetail(@RequestParam("id") String deviceNo, Model model, HttpServletRequest request, HttpServletResponse response){
		
		fuelService.removeFuelDetail(deviceNo);
	     addSuccessMessage("Fuel details removed successfully.");
	        addSuccessOrErrorMessageToModel(model);
			
	        return viewFuelDetails(model);
	    
    }

	
}
