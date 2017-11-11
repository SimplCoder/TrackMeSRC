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
import com.trackme.spring.model.VehicleReport;
import com.trackme.spring.service.MovementService;
import com.trackme.spring.service.VehicleGroupService;
import com.trackme.spring.service.VehicleMasterService;
import com.trackme.spring.service.VehicleReportService;


@Controller
public class VehicleReportController extends BaseController{

@Autowired(required=true)	
private VehicleReportService  vehicleReportService;

@Autowired(required=true)
@Qualifier(value="vehicleGroupService")
private VehicleGroupService vehicleGroupService;

@Autowired(required=true)
@Qualifier(value="vehicleMasterService")
private VehicleMasterService  vehicleMasterService;
	
	
	
	
	@RequestMapping(value = "/Reports")
	public String ListReport(@ModelAttribute VehicleReport vehicleReport,Model model, HttpServletRequest request, HttpServletResponse response ) {
		ArrayList<VehicleMaster> vehicleMasters = (ArrayList<VehicleMaster>) vehicleMasterService.listVehicleMasters();
		model.addAttribute("vehicleMasters", vehicleMasters);
		List report = vehicleReportService.getReport(vehicleReport);
		List reportHeaders = vehicleReportService.getReportHeaders(report);
		String reportJSON= vehicleReportService.getReportJSON(report);
	    model.addAttribute("report", report);
	    model.addAttribute("reportHeaders", reportHeaders);
	    model.addAttribute("reportJSON", reportJSON);
	    
		return "report";
	}
	
	
	
}
