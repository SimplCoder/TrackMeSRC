package com.trackme.spring;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import com.trackme.spring.model.Student;
import com.trackme.spring.model.UserMaster;
import com.trackme.spring.model.VehicleGroup;
import com.trackme.spring.model.VehicleMaster;
import com.trackme.spring.service.StudentService;
import com.trackme.spring.service.DeviceMasterService;
import com.trackme.spring.service.LocationService;
import com.trackme.spring.service.RouteScheduleService;
import com.trackme.spring.service.RouteService;
import com.trackme.spring.service.VehicleGroupService;
import com.trackme.spring.service.VehicleMasterService;


@Controller
public class StudentController extends BaseController{

private StudentService studentService;

@Autowired(required=true)
@Qualifier(value="routeService")
private RouteService routeService;

@Autowired(required=true)
@Qualifier(value="locationService")
private LocationService  locationService;

@Autowired
private VehicleGroupService vehicleGroupService;




@Autowired(required=true)
@Qualifier(value="routeScheduleService")
private RouteScheduleService  routeScheduleService   ;
	
	@Autowired(required=true)
	@Qualifier(value="studentService")
	public void setStudentService(StudentService ds){
		this.studentService = ds;
	}
	
	
	
	@RequestMapping(value = "/Students", method = RequestMethod.GET)
	public String listStudents(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("Student", new Student());
		model.addAttribute("routeScheduleList", routeScheduleService.listRouteScheduleDetails());
	    List<Student> student=this.studentService.listStudents();		
		ObjectMapper objectMapper = new ObjectMapper();
		String studentJSON=null;
		try {
			studentJSON = objectMapper.writeValueAsString(student);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("studentJSON", studentJSON);
		return "Student_view";
	}
	
	@RequestMapping(value = "/addNoStudents", method = RequestMethod.GET)
	public String altersView(Model model, HttpServletRequest request, HttpServletResponse response) {	
		model.addAttribute("Student", new Student());
		
		model.addAttribute("routeSchedules", routeScheduleService.listRouteScheduleDetails());
		model.addAttribute("routes", routeService.listRouteDetails());
		model.addAttribute("locations", locationService.listLocations());
		return "Student_entry";
	}
	
	@RequestMapping(value = "/EditStudentsView", method = RequestMethod.GET)
	public String editStudentMasters(Model model,@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {	
		Student student=this.studentService.getStudentById(id);
		student.setEditFlag(true);
		
		model.addAttribute("routeSchedules", routeScheduleService.listRouteScheduleDetails());
		model.addAttribute("routes", routeService.listRouteDetails());
		model.addAttribute("locations", locationService.listLocations());
				
		model.addAttribute("Student", student);
		return "Student_entry";
	}
	
	//For add and update VehicleMaster both
	@RequestMapping(value= "/AddOrUpdateStudentsRecord", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("Student") Student student, Model model, HttpServletRequest request, HttpServletResponse response){		
		//Add Driver
		
		
		
			Student studentExist=this.studentService.getStudentById(String.valueOf(student.getId()));
		
					
			if(studentExist==null){
			UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
			student.setCreatedBy(currentUser.getUserName());
			student.setCreatedDate(new Date());
		
		studentService.addStudent(student);
		addSuccessMessage("Student details added successfully.");
		
		} else{
			if(student.isEditFlag()){
				UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
				student.setModifiedBy(currentUser.getUserName());
				student.setModifiedDate(new Date());
			
				studentService.updateStudent(student);	
			addSuccessMessage("Student details updated successfully.");
			}else{
				addErrorMessage("Student already exists. Please enter unique student.");
				addSuccessOrErrorMessageToModel(model);
				model.addAttribute("Student", student);
				   return "Student_entry";
			}
		}
		addSuccessOrErrorMessageToModel(model);
		return listStudents(model,request,response);
		
	}
	
	@RequestMapping("/RemoveStudentsRecord")
    public String removeStudent(@RequestParam("id") String deviceNo, Model model, HttpServletRequest request, HttpServletResponse response){
		
		studentService.removeStudent(deviceNo);
	     addSuccessMessage("Student details removed successfully.");
	        addSuccessOrErrorMessageToModel(model);
			
	        return listStudents(model,request,response);
	    
    }
 
	
	@RequestMapping(value="/uploadStudentsRecord" , method = RequestMethod.POST)
    public String uploadStudent(@RequestParam("routeSchedule") String  routeSchedule,@RequestParam("dropRouteScheduleId") String  dropRouteScheduleId,
    		  @RequestParam("studentfile") MultipartFile file , Model model, HttpServletRequest request, HttpServletResponse response){
		   	
	       	
		        String fileName="";
				String filePath ="";
				if (!file.isEmpty()) {
					try {
						byte[] bytes = file.getBytes();
		        fileName= file.getOriginalFilename();
						// Creating the directory to store file
						String rootPath = Constant.STUDENT_UPLOAD_PATH+File.separator+Constant.PROJECT_NAME;
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

						filePath = dir+File.separator+fileName;
						
						String s =studentService.uploadStudentRecord(filePath,routeSchedule,dropRouteScheduleId);
						if(s!=null)
						  addSuccessMessage("Records inserted successfully.");
						else
							addErrorMessage("No record inserted. File formar should be as per given template.");
						
								} catch (Exception e) {					
									  addErrorMessage("No record inserted. File format should be as per given template.");
												}
					
			}else{
			  addErrorMessage("File not upload. Kindly select csv file");
				}
				  addSuccessOrErrorMessageToModel(model);		
	        return listStudents(model,request,response); 
	}


	@RequestMapping("/downloadStudentsTemplate")  
	public void downloadPDFResource( HttpServletRequest request, 
            HttpServletResponse response
         ) 
{
		String dataDirectory = System.getenv("code_base")+File.separator+Constant.PROJECT_NAME+File.separator+Constant.STUDENT_BULK_TEMPLATE_Path;
		String  fileName = "studentBulk.csv";
//Authorized user will download the file
//String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/downloads/pdf/");
Path file = Paths.get(dataDirectory, fileName);
if (Files.exists(file)) 
{
response.setContentType("application/csv");
response.addHeader("Content-Disposition", "attachment; filename="+fileName);
try
{
Files.copy(file, response.getOutputStream());
response.getOutputStream().flush();
} 
catch (IOException ex) {
ex.printStackTrace();
}
}
}
	
	
	
	
	
}
