<!DOCTYPE html>
<html>

<!-- Mirrored from kalkisoft.com/adhata/html/new-vehicle.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 30 Dec 2016 18:17:01 GMT -->
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student</title>
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
					<h2>Student Entry</h2>
				</div>
			</div>
			<div class="wrapper wrapper-content  animated fadeInRight">
				<div class="ibox-content">
					<div class="row">
						<form:form action="AddOrUpdateStudentsRecord"
							commandName="Student">
							<form:hidden path="status" value="Active" />




							<c:if test="${Student.editFlag==true }">
								<form:hidden path="id" />

								<form:hidden path="editFlag" value="${Student.editFlag}" />
								<form:hidden path="createdBy" value="${Student.createdBy}" />
								<form:hidden path="createdOnShow"
									value="${Student.createdOnShow}" />

							</c:if>
							<c:if test="${Student.editFlag==false }">
								<form:hidden path="editFlag" value="${Student.editFlag}" />

							</c:if>


							<div class="form-group col-sm-6">
								<label>Student Id:</label>
								<form:input path="studentNo" id="studentNo" class="form-control" />
							</div>

							<div class="form-group col-sm-6">
								<label>Student Name:</label>
								<form:input path="studentName" id="studentName"
									class="form-control" />
							</div>
							
							<div class="form-group col-sm-6">
								<label>STD. :</label>
								<form:input path="std" id="std" class="form-control" />
							</div>
							
							<div class="form-group col-sm-6">
								<label>Division :</label>
								<form:input path="division" id="division" class="form-control" />
							</div>
							
							
							<div class="form-group col-sm-6">
								<label>Father Name. :</label>
								<form:input path="fatherName" id="fatherName" class="form-control" />
							</div>
							
							<div class="form-group col-sm-6">
								<label>Father Mobile No. :</label>
								<form:input path="fatherMobile" id="fatherMobile" class="form-control" />
							</div>
							
<div class="form-group col-sm-6">
								<label>Mother Name. :</label>
								<form:input path="motherName" id="motherName" class="form-control" />
							</div>
							
							<div class="form-group col-sm-6">
								<label>Mother Mobile No. :</label>
								<form:input path="motherMobile" id="motherMobile" class="form-control" />
							</div>
							
							
							<div class="form-group col-sm-6">
								<label>Gaurdian Name. :</label>
								<form:input path="gaurdianName" id="gaurdianName" class="form-control" />
							</div>
							
							<div class="form-group col-sm-6">
								<label>Gaurdian Mobile No. :</label>
								<form:input path="gaurdianMobile" id="gaurdianMobile" class="form-control" />
							</div>
							

							<div class="form-group col-sm-6">
								<label>Pick-Up Schedule:</label>
								<form:select path="routeScheduleId" id="routeScheduleId"
									class="form-control">
<form:option value="" label="select" />
									<form:options items="${routeSchedules}" itemValue="scheduleName"
										itemLabel="scheduleName"></form:options>
								</form:select>

							</div>
							
							
							<div class="form-group col-sm-6">
								<label>Drop Schedule:</label>
								<form:select path="dropRouteScheduleId" id="dropRouteScheduleId"
									class="form-control">

									<form:options items="${routeSchedules}" itemValue="scheduleName"
										itemLabel="scheduleName"></form:options>
								</form:select>

							</div>




						
							
							
														<div class="form-group col-sm-6">
								<label>Pickup Location:</label>
								<form:select path="pickUpLocation" id="pickuplocation" class="form-control">
<form:option value="" label="select" />
									<form:options items="${locations}" itemValue="locationName"
										itemLabel="locationName"></form:options>
								</form:select>

							</div>

														<div class="form-group col-sm-6">
								<label>Drop Location:</label>
								<form:select path="dropLocation" id="dropLocation" class="form-control">
<form:option value="" label="select" />
									<form:options items="${locations}" itemValue="locationName"
										itemLabel="locationName"></form:options>
								</form:select>

							</div>

							<c:if test="${Student.editFlag==true }">

								<input name="action" type="submit" class="btn btn-primary"
									id="button" value="Update Student">
							</c:if>
							<c:if test="${Student.editFlag==false }">

								<input name="action" type="submit" class="btn btn-primary"
									id="button" value="Add Student">
							</c:if>
							<input name="button3" type="button" class="btn btn-danger"
								id="button3" onclick="location.href = 'Students'" value="Exit">
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
	  $('#hdr_student').addClass("dropdown active");
		$('#hdr_student_link').click();
		$('#hdr_students').addClass("active");
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

</html>
