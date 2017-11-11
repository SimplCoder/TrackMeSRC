package com.trackme.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trackme.constants.Constant;
import com.trackme.spring.dao.VehicleMasterDAO;
import com.trackme.spring.dao.jdbc.VehicleReportJdbc;
import com.trackme.spring.model.GPSTracking;
import com.trackme.spring.model.VehicleMaster;
import com.trackme.spring.model.VehicleReport;

@Service("vehicleReportService")
public class VehicleReportService {
	
	@Autowired
	private VehicleReportJdbc vehicleReportJdbc;

	@Transactional
	public List<Map<String, Object>> getReport(VehicleReport report){
		if(report !=null){
			if("Consolidate Report".equalsIgnoreCase(report.getReportName())){
				return getConsolidateReport(report);
			}
			if("Ignition Report".equalsIgnoreCase(report.getReportName())){
				return getIgnitionReport(report);
			}
			if("Interval Report".equalsIgnoreCase(report.getReportName())){
				return getIntervalReport(report);
			}
			
			if("Movement Report".equalsIgnoreCase(report.getReportName())){
				return getMovementReport(report);
			}
			
			if("Overspeed Report".equalsIgnoreCase(report.getReportName())){
				return getOverSpeedReport(report);
			}
			
			if("Stoppage Report".equalsIgnoreCase(report.getReportName())){
				return getStopageReport(report);
			}
			
			if("Harsh Break".equalsIgnoreCase(report.getReportName())){
				return getHarshBrakeReport(report);
			}
			
			
		
		}
		
		return null;
		
	}
	
	
	
	@Transactional
	public String getReportJSON(List report){
		ObjectMapper objectMapper = new ObjectMapper();
		String reportJSON = null;
		try {
			reportJSON = objectMapper
					.writeValueAsString(report);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reportJSON;
	}
	
	@Transactional
	public List<Map<String, Object>> getConsolidateReport(VehicleReport p) {
		return this.vehicleReportJdbc.getConsolidateReport(p);
	}

	@Transactional
	public List<Map<String, Object>> getIgnitionReport(VehicleReport p) {
		return this.vehicleReportJdbc.getIgnitionReport(p);
	}
	
	@Transactional
	public List<Map<String, Object>> getIntervalReport(VehicleReport p) {
		return this.vehicleReportJdbc.getIntervalReport(p);
	}

	
	@Transactional
	public List<Map<String, Object>> getOverSpeedReport(VehicleReport p) {
		return this.vehicleReportJdbc.getOverSpeedReport(p);
	}

	@Transactional
	public List<Map<String, Object>> getHarshBrakeReport(VehicleReport p) {
		return this.vehicleReportJdbc.getHarshBreakReport(p);
	}
	
	@Transactional
	public List<Map<String, Object>> getStopageReport(VehicleReport p) {
		return this.vehicleReportJdbc.getStopageReport(p);
	}
	@Transactional
	public List<Map<String, Object>> getMovementReport(VehicleReport p) {
		return this.vehicleReportJdbc.getMovementReport(p);
	}
	
	public List<String> getReportHeaders(List<Map<String, Object>> report){
		List<String> reportHeaders=null;
if(report !=null && report.size()>0){
	Map<String,Object> reportHeaderMap= report.get(0);		
	reportHeaders =  new ArrayList<String>(reportHeaderMap.keySet());
		}
		return reportHeaders;
	}
}
