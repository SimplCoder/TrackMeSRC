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
import com.trackme.spring.model.CompanyMaster;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.model.VehicleGroup;
import com.trackme.spring.model.VehicleMaster;
import com.trackme.spring.service.CompanyMasterService;
import com.trackme.spring.service.VehicleGroupService;
import com.trackme.spring.service.VehicleMasterService;


@Controller
public class CompanyMasterController extends BaseController{

private CompanyMasterService companyMasterService;

@Autowired(required=true)
@Qualifier(value="vehicleGroupService")
private VehicleGroupService vehicleGroupService;

@Autowired(required=true)
@Qualifier(value="vehicleMasterService")
private VehicleMasterService  vehicleMasterService;
	
	@Autowired(required=true)
	@Qualifier(value="companyMasterService")
	public void setCompanyMasterService(CompanyMasterService ds){
		this.companyMasterService = ds;
	}
	
	
	
	@RequestMapping(value = "/CompanyMasters", method = RequestMethod.GET)
	public String listCompanyMasters(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("CompanyMaster", new CompanyMaster());
	    List<CompanyMaster> companyMaster=this.companyMasterService.listCompanyMasters();		
		ObjectMapper objectMapper = new ObjectMapper();
		String companyMasterJSON=null;
		try {
			companyMasterJSON = objectMapper.writeValueAsString(companyMaster);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("companyMasterJSON", companyMasterJSON);
		return "CompanyMaster_view";
	}
	
	@RequestMapping(value = "/addNoCompanyMasters", method = RequestMethod.GET)
	public String altersView(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("CompanyMaster", new CompanyMaster());
		
		return "CompanyMaster_entry";
	}
	
	@RequestMapping(value = "/EditCompanyMastersView", method = RequestMethod.GET)
	public String editCompanyMasterMasters(Model model,@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {	
		CompanyMaster companyMaster=this.companyMasterService.getCompanyMasterById(id);
		companyMaster.setEditFlag(true);
		model.addAttribute("CompanyMaster", companyMaster);
		return "CompanyMaster_entry";
	}
	
	//For add and update VehicleMaster both
	@RequestMapping(value= "/AddOrUpdateCompanyMastersRecord", method = RequestMethod.POST)
	public String addCompanyMaster(@ModelAttribute("CompanyMaster") CompanyMaster companyMaster,@RequestParam("logo") MultipartFile file , Model model, HttpServletRequest request, HttpServletResponse response){		
		//Add Driver
		
			CompanyMaster companyMasterExist=this.companyMasterService.getCompanyMasterById(String.valueOf(companyMaster.getId()));
		
			String fileName="";
			String filePath ="";
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
	        fileName= file.getOriginalFilename();
					// Creating the directory to store file
					String rootPath = System.getenv("code_base")+File.separator+Constant.PROJECT_NAME+File.separator+Constant.logoPath;
					File dir = new File(rootPath);
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath()
							+ File.separator +fileName);
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();

					filePath = Constant.logoPath+File.separator+fileName;
					companyMaster.setLogoPath(filePath);
						} catch (Exception e) {
					}
			} else {
			}
			
			if(companyMasterExist==null){
			UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
			companyMaster.setCreatedBy(currentUser.getUserName());
			companyMaster.setCreatedDate(new Date());
		
		companyMasterService.addCompanyMaster(companyMaster);
		addSuccessMessage("CompanyMaster details added successfully.");
		
		} else{
			if(companyMaster.isEditFlag()){
				UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
				companyMaster.setModifiedBy(currentUser.getUserName());
				companyMaster.setModifiedDate(new Date());
			
				companyMasterService.updateCompanyMaster(companyMaster);	
			addSuccessMessage("CompanyMaster details updated successfully.");
			}else{
				addErrorMessage("CompanyMaster already exists. Please enter unique companyMaster.");
				addSuccessOrErrorMessageToModel(model);
				model.addAttribute("CompanyMaster", companyMaster);
				   return "CompanyMaster_entry";
			}
		}
		addSuccessOrErrorMessageToModel(model);
		return listCompanyMasters(model,request,response);
		
	}
	
	@RequestMapping("/RemoveCompanyMastersRecord")
    public String removeCompanyMaster(@RequestParam("id") String deviceNo, Model model, HttpServletRequest request, HttpServletResponse response){
		
		companyMasterService.removeCompanyMaster(deviceNo);
	     addSuccessMessage("CompanyMaster details removed successfully.");
	        addSuccessOrErrorMessageToModel(model);
			
	        return listCompanyMasters(model,request,response);
	    
    }
 

	
}
