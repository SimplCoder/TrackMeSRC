<!DOCTYPE html>
<html>

<!-- Mirrored from kalkisoft.com/adhata/html/new-vehicle.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 30 Dec 2016 18:17:01 GMT -->
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Driver Schedule</title>
<link href="html/css/css.css" rel="stylesheet" type="text/css" />
<link href="html/css/bootstrap.css" rel="stylesheet">

<link href="html/css/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="html/font-awesome/css/font-awesome.css" rel="stylesheet">
<link href="html/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="html/css/animate.css" rel="stylesheet">
<link href="html/css/style.css" rel="stylesheet">
<link href="html/css/custom.css" rel="stylesheet">
<link href="html/css/bootstrap-timepicker.css" rel="stylesheet">
<link href="html/css/datepicker3.css" rel="stylesheet">
</head>


<body class="top-navigation">
	<jsp:directive.include file="header.jsp" />
	<div id="wrapper">

		<div id="page-wrapper2" class="gray-bg">
			<div class="rowx wrapper border-bottom white-bg page-heading">
				<div class="col-sm-12">
					<h2>Driver Schedule Entry</h2>
				</div>
			</div>
			<div class="wrapper wrapper-content  animated fadeInRight">
				<div class="ibox-content">
					<div class="row">
						<form:form action="AddOrUpdateDriverConfsRecord"
							commandName="DriverConf">
							<form:hidden path="status" value="Active" />




							<c:if test="${DriverConf.editFlag==true }">
								<form:hidden path="id" />

								<form:hidden path="editFlag" value="${DriverConf.editFlag}" />
								<form:hidden path="createdBy" value="${DriverConf.createdBy}" />
								<form:hidden path="createdOnShow"
									value="${DriverConf.createdOnShow}" />

							</c:if>
							<c:if test="${DriverConf.editFlag==false }">
								<form:hidden path="editFlag" value="${DriverConf.editFlag}" />

							</c:if>


							<div class="form-group col-sm-6">
								<label>Driver:</label>
							<form:select path="driverId.id" id="driverId"
									class="form-control">
<form:option value="" label="select" />
									<form:options items="${drivers}" itemValue="id"
										itemLabel="driverName"></form:options>
								</form:select></div>
								
								<div class="form-group col-sm-6">
								<label>Vehicle:</label>
								<form:select path="vehicleNo" id="vehicleN" class="form-control">
									<form:option value="" label="select" />

									<form:options items="${vehicles}" itemValue="vehicleNo"
										itemLabel="vehicleNo"></form:options>
								</form:select>
							</div>

							
							                                    
                                        <div class="form-group col-sm-6">
                                            <label>Start Date:</label>
                                            <div class="input-group date">
                                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>

                                                <form:input  placeholder="Start Date" path="startDate" id="startDate" autocomplete="off" class="form-control editor-field"/>
                                            </div>
                                            <!--<label for="date" class="user-label">Start Date:</label>
                                            <input name="date" type="date" id="date" autocomplete="on" class="form-control" />-->
                                        </div>
                                        <div class="form-group col-sm-6">
                                            <label>End Date:</label>
                                            <div class="input-group date">
                                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>

                                                <form:input placeholder="End Date" path="endDate" autocomplete="off" class="form-control editor-field"/>
                                            </div>

                                        </div>
                                   
                                        <div class="bootstrap-timepicker col-sm-6">
                                            <div class="form-group">
                                                <label>Start Time:</label>
                                                <div class="input-group">
                                                    <form:input placeholder="Start Time" path="startTime" id="startTime" class="form-control timepicker"/>
                                                    <div class="input-group-addon">
                                                        <i class="fa fa-clock-o"></i>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                        <div class="bootstrap-timepicker col-sm-6">
                                            <div class="form-group">
                                                <label>End Time:</label>
                                                <div class="input-group">
                                                   <form:input placeholder="Start Time" path="endTime" id="endTime" class="form-control timepicker"/>
                                                    <div class="input-group-addon">
                                                        <i class="fa fa-clock-o"></i>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    

                                        <div class="form-group col-sm-6">
                                            <label for="textfield3" class="user-label">Shift Name:</label>
                                            <form:input path="shiftName" class="form-control" />
                                        </div>
                                        <div class="form-group col-sm-6">
                                            <label for="textfield4" class="user-label">Trip Id:</label>
                                            <form:input path="tripId" class="form-control" />
                                        </div>
                                  
							
 <br />
                            <div style="text-align: center">
							<c:if test="${DriverConf.editFlag==true }">

								<input name="action" type="submit" class="btn btn-primary"
									id="button" value="Update Driver Schedule">
							</c:if>
							<c:if test="${DriverConf.editFlag==false }">

								<input name="action" type="submit" class="btn btn-primary"
									id="button" value="Add Driver Schedule">
							</c:if>
							<input name="button3" type="button" class="btn btn-danger"
								id="button3" onclick="location.href = 'DriverConfs'" value="Exit">
								</div>
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
	<script type="text/javascript"
		src="html/js/dataTables.bootstrap.min.js"></script>

	<script type="text/javascript" src="html/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="html/js/bootstrap-timepicker.js"></script>
	<script type="text/javascript" src="html/js/dataTables.buttons.min.js"></script>
	<script type="text/javascript" src="html/js/buttons.flash.min.js"></script>
	<script type="text/javascript" src="html/js/jspdf.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/buttons/1.2.4/js/buttons.html5.min.js"></script>
	<script type="text/javascript" src="html/js/icheck.min.js"></script>
	<!-- iCheck -->
	<script>
	  $('#hdr_settings').addClass("dropdown active");
		$('#hdr_settings_link').click();
		$('#hdr_driverConfs').addClass("active");
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
		
		
	
		
		$(document).ready(function(){
		    $('input.timepicker').timepicker({
		    	 scrollbar: true
		    });
		});
		
	
    $('#startDate').datepicker({
        autoclose: true,
        height: 100

    });
    $('#endDate').datepicker({
        autoclose: true,
        height: 100
    });
    
		
    </script>
</body>

<script
	src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
<script type="text/javascript" src="html/js/bootstrap-timepicker.js"></script>


</html>
