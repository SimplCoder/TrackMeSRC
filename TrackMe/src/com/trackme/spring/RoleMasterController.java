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
import com.trackme.spring.model.LinkConf;
import com.trackme.spring.model.RoleMaster;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.model.VehicleGroup;
import com.trackme.spring.model.VehicleMaster;
import com.trackme.spring.service.RoleMasterService;
import com.trackme.spring.service.DeviceMasterService;
import com.trackme.spring.service.LinkConfService;
import com.trackme.spring.service.VehicleGroupService;
import com.trackme.spring.service.VehicleMasterService;


@Controller
public class RoleMasterController extends BaseController{

private RoleMasterService roleMasterService;


@Autowired(required=true)
@Qualifier(value="linkConfService")
private LinkConfService  linkConfService;
	
	@Autowired(required=true)
	@Qualifier(value="roleMasterService")
	public void setRoleMasterService(RoleMasterService ds){
		this.roleMasterService = ds;
	}
	
	
	
	@RequestMapping(value = "/RoleMasters", method = RequestMethod.GET)
	public String listRoleMasters(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("RoleMaster", new RoleMaster());
	    List<RoleMaster> roleMaster=this.roleMasterService.listRoleMasters();		
		ObjectMapper objectMapper = new ObjectMapper();
		String roleMasterJSON=null;
		try {
			roleMasterJSON = objectMapper.writeValueAsString(roleMaster);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("roleMasterJSON", roleMasterJSON);
		return "RoleMaster_view";
	}
	
	@RequestMapping(value = "/addNoRoleMasters", method = RequestMethod.GET)
	public String altersView(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("RoleMaster", new RoleMaster());
		
		model.addAttribute("links", linkConfService.listLinkConfs());
		return "RoleMaster_entry";
	}
	
	@RequestMapping(value = "/EditRoleMastersView", method = RequestMethod.GET)
	public String editRoleMasterMasters(Model model,@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {	
		RoleMaster roleMaster=this.roleMasterService.getRoleMasterById(id);
		roleMaster.setEditFlag(true);
		
		model.addAttribute("links", linkConfService.listLinkConfs());
				
		model.addAttribute("RoleMaster", roleMaster);
		return "RoleMaster_entry";
	}
	
	//For add and update VehicleMaster both
	@RequestMapping(value= "/AddOrUpdateRoleMastersRecord", method = RequestMethod.POST)
	public String addRoleMaster(@ModelAttribute("RoleMaster") RoleMaster roleMaster, Model model, HttpServletRequest request, HttpServletResponse response){		
		//Add Driver
		
		
		
			RoleMaster roleMasterExist=this.roleMasterService.getRoleMasterById(String.valueOf(roleMaster.getId()));
		
					
			if(roleMasterExist==null){
			UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
			roleMaster.setCreatedBy(currentUser.getUserName());
			roleMaster.setCreatedDate(new Date());
		
		roleMasterService.addRoleMaster(roleMaster);
		addSuccessMessage("RoleMaster details added successfully.");
		
		} else{
			if(roleMaster.isEditFlag()){
				
				UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
				roleMaster.setModifiedBy(currentUser.getUserName());
				roleMaster.setModifiedDate(new Date());
			    roleMasterService.removeExistingLink(roleMaster);
				roleMasterService.updateRoleMaster(roleMaster);	
			addSuccessMessage("RoleMaster details updated successfully.");
			}else{
				addErrorMessage("RoleMaster already exists. Please enter unique roleMaster.");
				addSuccessOrErrorMessageToModel(model);
				model.addAttribute("RoleMaster", roleMaster);
				   return "RoleMaster_entry";
			}
		}
		addSuccessOrErrorMessageToModel(model);
		return listRoleMasters(model,request,response);
		
	}
	
	@RequestMapping("/RemoveRoleMastersRecord")
    public String removeRoleMaster(@RequestParam("id") String deviceNo, Model model, HttpServletRequest request, HttpServletResponse response){
		
		roleMasterService.removeRoleMaster(deviceNo);
	     addSuccessMessage("RoleMaster details removed successfully.");
	        addSuccessOrErrorMessageToModel(model);
			
	        return listRoleMasters(model,request,response);
	    
    }
 

	
}
