<!DOCTYPE html>
<html>

<!-- Mirrored from kalkisoft.com/adhata/html/new-vehicle.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 30 Dec 2016 18:17:01 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Company</title>
       <link href="html/css/css.css" rel="stylesheet" type="text/css" />
    <link href="html/css/bootstrap.css" rel="stylesheet">

    <link href="html/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="html/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="html/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="html/css/animate.css" rel="stylesheet">
    <link href="html/css/style.css" rel="stylesheet">
    <link href="html/css/custom.css" rel="stylesheet">
    <link href="html/css/bootstrap-timepicker.css" rel="stylesheet">
    <link href="html/css/datepicker3.css" rel="stylesheet"></head>


<body class="top-navigation" >
 <jsp:directive.include file="header.jsp" />
    <div id="wrapper">
     
       <div id="page-wrapper2" class="gray-bg">
            <div class="rowx wrapper border-bottom white-bg page-heading">
                <div class="col-sm-12">
                    <h2>Vehicle Service Entry </h2>
                </div>
            </div>
            <div class="wrapper wrapper-content  animated fadeInRight">
                <div class="ibox-content">
                    <div class="row">
                        <form:form action="AddOrUpdateVehicleServicesRecord" commandName="VehicleService">
<form:hidden path="status" value="Active"/>

                          
                                    
                                          
                                            <c:if test="${VehicleService.editFlag==true }">
						            		<form:hidden path="serviceId"/>
									
                                    	<form:hidden path="editFlag" value="${VehicleService.editFlag}"/>
											<form:hidden path="createdBy" value="${VehicleService.createdBy}"/>
								<form:hidden path="createdOnShow" value="${VehicleService.createdOnShow}"/>
						
							</c:if>
							<c:if test="${VehicleService.editFlag==false }">
							 	   	<form:hidden path="editFlag" value="${VehicleService.editFlag}"/>
                                   
							</c:if>
                                           
                           
                          
	
							
						
						<div class="form-group col-sm-6">
                                <label>Select Vehicle</label>
                               <form:select  path="vehicleNo" id="vehicle" class="form-control">
   <form:option value="" label="select" />
    <form:options items="${vehicleMasters}" itemValue="vehicleNo" itemLabel="vehicleNo"></form:options>
    </form:select>    </div>
						
						<div class="form-group col-sm-6">
                                <label>Component Name</label>
                                <form:input type="text" placeholder="Component Name" path="componentDesc" id="textfield2" class="form-control editor-field"/>
                            </div>
						
						<div class="form-group col-sm-6">
                                <label>Select Driver</label>
                               <form:select  path="driverMaster.id" id="driver" class="form-control">
   <form:option value="" label="select" />
    <form:options items="${driverMasters}" itemValue="id" itemLabel="driverName"></form:options>
    </form:select>    </div>
						
							<div class="form-group col-sm-6">
                                <label>Bill No</label>
                                <form:input type="text" placeholder="Bill No" path="billNo" id="textfield5" class="form-control editor-field"/>
                            </div>
						        
						   <div class="form-group col-sm-6">
                                <label>Date</label>
                                <div class="input-group date">
                                    <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                    <form:input type="text" placeholder="Date" path="serviceDateShow" id="date" class="form-control editor-field"/>
                                </div>
                            </div>
						<div class="form-group col-sm-6">
                                <label>Service Station Name</label>
                                <form:input type="text" placeholder="Service Station Name" path="serviceStation" id="textfield8" class="form-control editor-field"/>
                            </div>
						
						 <div class="bootstrap-timepicker col-sm-6">
                                <div class="form-group">
                                    <label>From Time</label>

                                    <div class="input-group">
                                        <form:input type="text" placeholder="From Time" path="fromTime" class="form-control timepicker" id="time"/>

                                        <div class="input-group-addon">
                                            <i class="fa fa-clock-o"></i>
                                        </div>
                                    </div>
                                    <!-- /.input group -->
                                </div>
                            </div>
						
						<div class="form-group col-sm-6">
						<label>Amount:</label>
							<form:input  path="amount" class="form-control"/>
						</div>
						
						 <div class="bootstrap-timepicker col-sm-6">
                                <div class="form-group">
                                    <label>End Time</label>

                                    <div class="input-group">
                                        <form:input type="text" placeholder="End Time" path="toTime" class="form-control timepicker" id="time2"/>
                                        <div class="input-group-addon">
                                            <i class="fa fa-clock-o"></i>
                                        </div>
                                    </div>
                                    <!-- /.input group -->
                                </div>
                            </div>
						
						<div class="form-group col-sm-6">
						<label>Current Odo:</label>
							<form:input  path="currentOdo" class="form-control"/>
						</div>
						
						<div class="form-group col-sm-6">
                                <label>Select Location</label>
                               <form:select  path="serviceLocation" id="deviceNo" class="form-control">
   <form:option value="" label="select" />
    <form:options items="${locationMasters}" itemValue="locationName" itemLabel="locationName"></form:options>
    </form:select>    </div>
							<div class="form-group col-sm-6">
						<label>Next Odo:</label>
							<form:input  path="nextOdo" class="form-control"/>
						</div>
						 <div class="form-group col-sm-12">
                                <label>Service Description</label>
                                <form:textarea path="serviceDesc" type="text" placeholder="Service Description" class="form-control"></form:textarea>
                            </div>	       
						          
                                       <div class="form-group col-sm-12 text-center">
                                  <c:if test="${VehicleService.editFlag==true }">
						            	
                                <input name="action" type="submit" class="btn btn-primary" id="button" value="Update Vehicle Service">
                                </c:if>
                                 <c:if test="${VehicleService.editFlag==false }">
						            	
                                <input name="action" type="submit" class="btn btn-primary" id="button" value="Add Vehicle Service">
                                </c:if>
                                <input name="button3" type="button" class="btn btn-danger" id="button3" onclick="location.href = 'VehicleServices'" value="Exit">
                            </div>
                        </form:form>
                    </div>
                </div>


            </div>
        </div>
    </div>

 <jsp:directive.include file="footer.jsp" />


      <!-- Mainly scripts -->
    <script type="text/javascript" src="html/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="html/js/tether.min.js"></script>
<script type="text/javascript" src="html/js/bootstrap.js"></script>
<script type="text/javascript" src="html/js/angular.min.js"></script>
<script type="text/javascript" src="html/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="html/js/dataTables.bootstrap.min.js"></script>

<script type="text/javascript" src="html/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="html/js/bootstrap-timepicker.js"></script>
<script type="text/javascript" src="html/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="html/js/buttons.flash.min.js"></script>
<script type="text/javascript" src="html/js/jspdf.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
<script type="text/javascript" src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.2.4/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="html/js/icheck.min.js"></script>
    <!-- iCheck -->
    <script>
    $('#hdr_vehicle').addClass("dropdown active");
		$('#hdr_vehicleLink').click();
		$('#hdr_vehicleService').addClass("active");
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green'
            
        });
        $('#successMessage').fadeOut(5000);
		$('#errorMessage').fadeOut(5000);
		function validate(){
			$('#primaryKey').prop('disabled', false);
			$('#groups').prop('disabled', false);
			return true;
		}
		
		
		
		$('input').on('ifChecked', function(event){
			$('#vehicleList').prop('disabled', true);
	    	$('#vehicleList').hide();
	    	$('#groupList').prop('disabled', false);
	    	$('#groupList').show();
			});
		
		
		$('input').on('ifUnchecked', function (event) {
			$('#groupList').prop('disabled', true);
	    	$('#groupList').hide();
	    	$('#vehicleList').prop('disabled', false);
	    	$('#vehicleList').show();
		});
		$(document).ready(function(){
		    $('input.timepicker').timepicker({
		    	 scrollbar: true
		    });
		});
		
	
    $('#date').datepicker({
        autoclose: true,
        height: 100

    });
   
		
    </script>
</body>

<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">

</html>
