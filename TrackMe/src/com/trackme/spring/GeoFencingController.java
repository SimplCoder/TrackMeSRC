package com.trackme.spring;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.trackme.constants.Constant;
import com.trackme.spring.model.DeviceMaster;
import com.trackme.spring.model.DriverMaster;
import com.trackme.spring.model.GeoFenceDetail;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.service.GeoFencingService;
import com.trackme.spring.service.VehicleMasterService;

@Controller
public class GeoFencingController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	GeoFencingService geoFencingService;

	@Autowired
	private VehicleMasterService vehicleMasterService;

	
	public GeoFencingService getGeoFencingService() {
		return geoFencingService;
	}

	public void setGeoFencingService(GeoFencingService geoFencingService) {
		this.geoFencingService = geoFencingService;
	}

	@RequestMapping(value = "/geoFence_addNew.html", method = RequestMethod.GET)
	public String home(Locale locale, Model model, Principal principal,
			HttpServletRequest request) {
		request.setAttribute("GeoFenceDetail", new GeoFenceDetail());
		model.addAttribute("vehicles",vehicleMasterService.listVehicleMasters());
		
		model.addAttribute("isEdit", 0);
		return "geoFence_addEdit";
	}

	@RequestMapping(value = "/editGeoFenceDetails.html", method = RequestMethod.GET)
	public String editGeoFence(Model model, @RequestParam("id") String id,@RequestParam("isEdit") String isEdit) {
		model.addAttribute("vehicles",vehicleMasterService.listVehicleMasters());
		
		try {
			int geoFenceId = 0;
			if (id != null && !id.equals("")) {
				geoFenceId = Integer.parseInt(id);
			}
			if (isEdit != null && !isEdit.equals("")&&isEdit.equals("1")) {
				model.addAttribute("isEdit", 1);
			}
			GeoFenceDetail geoFenceDetail = geoFencingService
					.getGeoFenceById(geoFenceId);
			model.addAttribute("GeoFenceDetail", geoFenceDetail);
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
			String geoFenceJSON = null;
			try {
				geoFenceJSON = objectMapper
						.writeValueAsString(geoFenceDetail);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

			model.addAttribute("GeoFenceJSON", geoFenceJSON);
		} catch (Exception e) {
			logger.error("Error in Method GeoFencingController.editGeoFence : "
					+ e.getMessage());
			addErrorMessage("Something went wrong while fething GeoFence, kindly contact system administrator.");
			addSuccessOrErrorMessageToModel(model);
		}
		return "geoFence_addEdit";
	}

	@RequestMapping(value = "/addOrUpdateGeoFenceDetail.html", method = RequestMethod.POST)
	public String saveOrUpdateGeoFence(
			@ModelAttribute("GeoFenceDetail") GeoFenceDetail geoFenceDetail,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		if (geoFenceDetail.getId() ==null ) {
			UserMaster currentUser = (UserMaster) request.getSession()
					.getAttribute(Constant.CURRENT_USER);
			geoFenceDetail.setCreatedBy(currentUser.getUserName());
			geoFenceDetail.setCreatedDate(new Date());
			geoFenceDetail.setUserName(currentUser.getUserName());
			geoFenceDetail.setStatus(Constant.STATUS_ACTIVE);
			geoFencingService.addGeoFence(geoFenceDetail);
			addSuccessMessage("GeoFence details added successfully.");

		} else {
            geoFencingService.deleteVehicleGeoFence(geoFenceDetail.getId().toString());
			UserMaster currentUser = (UserMaster) request.getSession()
					.getAttribute(Constant.CURRENT_USER);
			geoFenceDetail.setModifiedBy(currentUser.getUserName());
			geoFenceDetail.setModifiedDate(new Date());
			geoFenceDetail.setUserName(currentUser.getUserName());
			geoFenceDetail.setStatus(Constant.STATUS_ACTIVE);
			
			geoFencingService.updateGeoFence(geoFenceDetail);
			addSuccessMessage("GeoFence details updated successfully.");
		}
		addSuccessOrErrorMessageToModel(model);
		return listGeoFences(model, request, response);

	}

	@RequestMapping(value = "/listGeoFenceDetails.html", method = RequestMethod.GET)
	public String listGeoFences(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("GeoFenceDetail", new GeoFenceDetail());
		List<GeoFenceDetail> geoFenceDetailsList = geoFencingService
				.getGeoFenceList();
		ObjectMapper objectMapper = new ObjectMapper();
		String GeoFenceDetailsJSON = null;
		try {
			GeoFenceDetailsJSON = objectMapper
					.writeValueAsString(geoFenceDetailsList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		model.addAttribute("geoFenceDetailsJSON", GeoFenceDetailsJSON);
		return "geoFence_view";
	}

	@RequestMapping(value = "/removeGeoFenceDetails.html", method = RequestMethod.GET)
	public String removeGeoFence(@RequestParam("id") String id, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			int geoFenceId = 0;
			if (id != null && !id.equals("")) {
				geoFenceId = Integer.parseInt(id);
			}
			  geoFencingService.deleteVehicleGeoFence(id);
				
			geoFencingService.removeGeoFence(geoFenceId);
			addSuccessMessage("GeoFence detail removed successfully.");
			addSuccessOrErrorMessageToModel(model);

		} catch (Exception e) {
			logger.error("Error in Method GeoFencingController.editGeoFence : "
					+ e.getMessage());
			addErrorMessage("Something went wrong while fething GeoFence, kindly contact system administrator.");
			addSuccessOrErrorMessageToModel(model);
		}
		return listGeoFences(model, request, response);

	}

}
