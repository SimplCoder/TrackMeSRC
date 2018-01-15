package com.trackme.spring;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trackme.constants.Constant;
import com.trackme.spring.model.LogIndexSearch;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.model.VehicleSearchForm;
import com.trackme.spring.service.MapLatlngService;
import com.trackme.spring.service.UserMasterService;




@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private final String LANDING_PAGE = "liveIndexPage";
	private final String LIVE_MAP_PAGE = "index";
	
	@Autowired
	private MapLatlngService mapLatlngService;
	
	@Autowired
	UserMasterService userMasterService;
	
	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String home(Locale locale, Model model,Principal principal,HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);
		if (principal != null) {
			String userName = principal.getName();
			HttpSession session = request.getSession();
			UserMaster currentUser = (UserMaster) session.getAttribute(Constant.CURRENT_USER);
			if (currentUser == null) {
				currentUser = userMasterService.getUserMasterById(userName);
				session.setAttribute(Constant.CURRENT_USER, currentUser);
			}
		}
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		String allVehicleLocationJson = getAllVehicleLiveDataJSON(userMasterService.getCurrentUserUsingPrinciple(request));
		if(allVehicleLocationJson == null){
			model.addAttribute("errorMsg", "No data found.");
		}
		// System.out.println("JSON=== "+allVehicleLocationJson);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("allVehicleLocation", allVehicleLocationJson);
		model.addAttribute("VehicleSearchForm",new VehicleSearchForm());
		return LANDING_PAGE;
	}
	
	@RequestMapping(value = "/getLiveMap", method = RequestMethod.GET)
	public String getLiveMap(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response){
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		String allVehicleLocationJson = getAllVehicleLiveDataJSON(userMasterService.getCurrentUserUsingPrinciple(request));
		if(allVehicleLocationJson == null){
			model.addAttribute("errorMsg", "No data found.");
		}
		// System.out.println("JSON=== "+allVehicleLocationJson);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("allVehicleLocation", allVehicleLocationJson);
		model.addAttribute("VehicleSearchForm",new VehicleSearchForm());
		return LIVE_MAP_PAGE;
	}
	
	private String getAllVehicleLiveDataJSON(UserMaster userMaster){
		List mapLatlngList = mapLatlngService.getAllVehicleLocation(userMaster);

		ObjectMapper objectMapper = new ObjectMapper();
		String allVehicleLocationJson = null;
		try {
			allVehicleLocationJson = objectMapper
					.writeValueAsString(mapLatlngList);
		} catch (JsonProcessingException e) {
			logger.error("Exception Occured: "+e.getMessage());
		}
		return allVehicleLocationJson;
	}

	@RequestMapping(value = "/Vehicle_DetailedLogs")
	public String getDetailedLogsOfVehicle(@ModelAttribute("LogIndexSearch") LogIndexSearch logIndexSearch,HttpServletRequest request,
			Model model) {
		
		String fromDate=logIndexSearch.getFromDate();
		String toDate=logIndexSearch.getToDate();
		String formVehicleNo=logIndexSearch.getVehicleNo();
		String vehicleNo=request.getParameter("id");
		if(formVehicleNo==null||"".equals(formVehicleNo)){
		logIndexSearch.setVehicleNo(vehicleNo);
		}else{
			vehicleNo=formVehicleNo;
		}
		model.addAttribute("LogIndexSearch", logIndexSearch);

		String sqlFromDate=null;
		String sqlToDate=null;
		if((fromDate==null||"".equals(fromDate))&&(toDate==null||"".equals(toDate))){
			fromDate =mapLatlngService.getLastIngnitionOf(vehicleNo);
		}
		
		
		if (vehicleNo != null && !vehicleNo.isEmpty()) {
			List vehicleLatlngList = mapLatlngService
					.getLatlngDetailsByVehicleNo(vehicleNo, fromDate, toDate);
			ObjectMapper objMapper = new ObjectMapper();
			String vehicleLatlngListJSON = null;
			try {
				vehicleLatlngListJSON = objMapper
						.writeValueAsString(vehicleLatlngList);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("vehicleLatlngDetails", vehicleLatlngListJSON);
			model.addAttribute("vehicleName", vehicleNo);
		} else {
			model.addAttribute("errorMsg", "Vehicle no. is Empty.");
		}
		return "detailedLogIndex";
	}

	private String convertDateToSqlDate(Date date) {
		SimpleDateFormat sqlFormatter=new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate=sqlFormatter.format(date);
		return sqlDate;
	}

	private String convertStringToSqlDateFormat(String date) {
		String sqlDate=null;
		try {
		SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
		Date date1 = formatter.parse(date);
		sqlDate=convertDateToSqlDate(date1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return sqlDate;
	}
	

	@RequestMapping(value = "/emp/get/{id}", method = RequestMethod.GET)
	public String getEmployee(Locale locale, Model model,@PathVariable("id") int id) {
		logger.info("Welcome user! Requested Emp ID is: "+id);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("id", id);
		model.addAttribute("name", "Pankaj");
		
		return "employee";
	}
	
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request, Model model){
		return "login";
	}
	
	@RequestMapping(value="/logout")
	public String logout(){
		return "logout";
	} 
	
	@RequestMapping(value="/denied")
	public String denied( Model model){
		model.addAttribute("message", "You are not authorized to access");
		return "login";
	}
	
	@RequestMapping(value="/help")
	public String redirectOnHelpPage(HttpServletRequest request, Model model){
		return "help";
	}
}
