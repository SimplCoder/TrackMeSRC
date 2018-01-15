<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/spring/customTagLibrary" prefix="cg" %>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 <script>
 
 $(document).ready(function(){
	    $(".icondelete").click(function(){
	    	  if (!confirm("Do you want to inactivate ?")){
	  		      return false;
	    	  }
	    });
	});

</script>
<div  id="wrapper">
	<div class="navbar-fixed-top">
		
		<div class="row">
			<div class="col-xs-3 col-sm-3">
                    <a href="#" class="logo-img">
                        <img src="html/images/adhata.png" alt="" /></a>
                </div>
			<div class="col-xs-6 col-sm-6 text-center">
	 			<div class="top-title">Adhata Fleet Management System</div>
			</div>
			<div class="col-xs-3 col-sm-3 text-right">
				<div class="cust-logo"> <img src="${currentUser.companyMaster.logoPath}" alt=""/> <span>${currentUser.companyMaster.companyName}</span> </div>
			</div>
		</div>
		<div class="row border-bottom white-bgx">
                <div class="col-xs-12">
                    <nav class="navbar navbar-static-top" role="navigation">
				  <div class="navbar-header">
					<button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse" class="navbar-toggle collapsed" type="button"> <i class="fa fa-reorder"></i> </button> 
				  </div>
				  <div class="navbar-collapse collapse" id="navbar">
					<ul class="nav navbar-nav">
					 <c:if test="${cg:checkForModule(currentUser,'Live')}"> 
					  <li id="hdr_live"> <a aria-expanded="false" role="button" href="home">Live</a> </li> </c:if>
					 
					  <c:if test="${cg:checkForModule(currentUser,'Vehicle Information')}">
					  <li id="hdr_vehicle" class="dropdown"> <a id="hdr_vehicleLink" aria-expanded="false" role="button" href="#" class="dropdown-toggle">Vehicle Info<span class="caret"></span></a>
						<ul  role="menu" class="dropdown-menu">
						  <c:if test="${cg:checkForLink(currentUser,'Vehicle View')}"> 
					 
						  <li id="hdr_vehicleView" ><a href="VehicleView"><i class="fa fa-eye"></i>Vehicle View</a></li>
						  </c:if>
						  
						   <c:if test="${cg:checkForLink(currentUser,'Vehicle information')}"> 
					 
						  <li id="hdr_vehicleInfo" ><a href="VehicleInfo"><i class="fa fa-info-circle"></i>Vehicle information</a></li></c:if>
						  
					</ul>
					  </li></c:if>
					   <c:if test="${cg:checkForModule(currentUser,'Reports')}">
				
					  <li> <a aria-expanded="false" role="button" href="Reports">Reports</a> </li>
					  </c:if>
					  
					  <c:if test="${cg:checkForModule(currentUser,'Settings')}">
					  <li id="hdr_settings" class="dropdown"> <a aria-expanded="false" id="hdr_settings_link" role="button" href="#" class="dropdown-toggle" >Settings<span class="caret"></span></a>
						<ul role="menu" class="dropdown-menu">
						    <c:if test="${cg:checkForLink(currentUser,'Driver Scheduling')}"><li id="hdr_driverConfs"><a href="DriverConfs"><i class="fa fa-sitemap"></i>Driver Scheduling</a></li></c:if>
                                        <c:if test="${cg:checkForLink(currentUser,'Vehicle Service')}"><li id="hdr_vehicleService"><a href="VehicleServices"><i class="fa fa-car"></i>Vehicle Service</a></li></c:if>
                                       <c:if test="${cg:checkForLink(currentUser,'Geofences')}"> <li id="hdr_goeFence"><a href="listGeoFenceDetails.html"><i class="fa fa-tencent-weibo"></i>Geofences</a></li></c:if>
                                       <c:if test="${cg:checkForLink(currentUser,'Fuel')}"> <li id="hdr_vehicleFuel"><a href="ViewFuelDetails"><i class="fa fa-tint"></i>Fuel</a></li></c:if>
                                       <c:if test="${cg:checkForLink(currentUser,'Location Entry')}"> <li id="hdr_vehicleLocation"><a href="LocationMasters"><i class="fa fa-map-marker"></i>Location Entry</a></li></c:if>
                                       <c:if test="${cg:checkForLink(currentUser,'Route')}"> <li id="hdr_vehicleRoute"><a href="ViewRouteDetails"><i class="fa fa-road"></i>Route</a></li></c:if>
                                       <c:if test="${cg:checkForLink(currentUser,'Route Scheduling')}"> <li id="hdr_vehicleRouteSch"><a href="ViewRouteScheduleDetails"><i class="fa fa-line-chart"></i>Route Scheduling</a></li></c:if>
                                    </ul>
					  </li>
					  </c:if>
					  
					   <c:if test="${cg:checkForModule(currentUser,'Configuration')}">
					  <li id="hdr_configuration" class="dropdown"> <a aria-expanded="false" id="hdr_configuration_link" role="button" href="#" class="dropdown-toggle" >Configuration<span class="caret"></span></a>
						<ul role="menu" class="dropdown-menu">
						 <c:if test="${cg:checkForLink(currentUser,'Vehicle Master')}"> <li id="hdr_vehicleMaster" ><a href="VehicleMasters"> <i class="fa fa-car"></i>Vehicle Master</a></li></c:if>
						  <c:if test="${cg:checkForLink(currentUser,'Driver Details')}"><li id="hdr_DriverMasters"><a href="DriverMasters"> <i class="fa fa-user"></i>Driver Details</a></li></c:if>
						 <c:if test="${cg:checkForLink(currentUser,'Vehicle Groups')}"> <li id="hdr_VehicleGroupView"><a href="VehicleGroupView"> <i class="fa fa-bus"></i>Vehicle Groups</a></li></c:if>
						 <c:if test="${cg:checkForLink(currentUser,'Alert')}"> <li id="hdr_Alerts"><a href="Alerts"> <i class="fa fa-bell-o"></i>Alert</a></li></c:if>
						 <c:if test="${cg:checkForLink(currentUser,'User')}"> <li id="hdr_UserMasters"><a href="UserMasters"> <i class="fa fa-user"></i>User</a></li></c:if>
						  
						<c:if test="${cg:checkForLink(currentUser,'Roles')}">   <li id="hdr_RoleMasters"><a href="RoleMasters"> <i class="fa fa-user"></i>Roles</a></li></c:if>
						 
						<c:if test="${cg:checkForLink(currentUser,'No Movement')}">  <li id="hdr_NoMovement"><a href="Movements"> <i class="fa fa-stop"></i>No Movement</a></li></c:if>
						 <c:if test="${cg:checkForLink(currentUser,'Company')}">   <li id="hdr_CompanyMaster"><a href="CompanyMasters"> <i class="fa fa-stop"></i>Company</a></li></c:if>
					<c:if test="${cg:checkForLink(currentUser,'Device Master')}">	<li id="hdr_DeviceMasters"><a href="DeviceMasters"> <i class="fa fa-car"></i>Device Master</a></li></c:if>
						
								  
						   <c:if test="${cg:checkForLink(currentUser,'Vehicle I/O List')}"> 
					 <li id="hdr_vehicleIO"><a href="VehicleIOs"><i class="fa fa-list-ul"></i>Vehicle I/O List</a></li></c:if>
				
						 
						</ul>
					  </li>
					  </c:if>
					   <c:if test="${cg:checkForModule(currentUser,'School')}">
					  
					  <li id="hdr_student" class="dropdown"> <a aria-expanded="false" id="hdr_student_link" role="button" href="#" class="dropdown-toggle" >School<span class="caret"></span></a>
						<ul role="menu" class="dropdown-menu">
						 <c:if test="${cg:checkForLink(currentUser,'Student Entry')}">  <li id="hdr_students"><a href="Students"> <i class="fa fa-child"></i>Student Entry</a></li></c:if>
						</ul>
					  </li>
					  </c:if>
					   <c:if test="${cg:checkForModule(currentUser,'Help')}">
					  <li class="dropdown"> <a aria-expanded="false" role="button" href="help" class="dropdown-toggle" >Help</a>
						
					  </li>
					  </c:if>
					</ul>
					<ul class="nav navbar-top-links navbar-right">
					  <li><span class="cust-name">Welcome ${currentUser.userName } </span></li>
					  <li> <a href="j_spring_security_logout"> <i class="fa fa-sign-out"></i> Log out </a> </li>
					</ul>
				  </div>
				</nav>
                </div>
            </div>

		<c:if test="${showSuccessMessage!=null && showSuccessMessage==true }">
		  <div style="position: relative; left: 340px; top: -100px; width:50%;  height: 10% ; "   align="center" class="alert alert-success alert-dismissable" id="successMessage">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
    <strong>${successMessage}</strong>
  </div>
		
			
		</c:if>
		<c:if test="${showErrorMessage!=null && showErrorMessage==true}">
		
				  <div style="position: relative; left: 340px; top: -100px; width:50%;  height: 5% ; "   align="center" class="alert alert-danger alert-dismissable" id="errorMessage">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
    <strong>${errorMessage}</strong>
		</div>
			</c:if>
		

	</div>
	</div>
	
