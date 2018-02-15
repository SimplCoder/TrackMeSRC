<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
 
<!DOCTYPE html>
<html>
<style>

    

    </style>

<!-- Mirrored from kalkisoft.com/adhata/html/new-vehicle.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 30 Dec 2016 18:17:01 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vehicle Master</title>
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
<div id="wrapper">
     <jsp:directive.include file="header.jsp" />
  <div id="page-wrapper2" class="gray-bg">
    <div class="rowx wrapper border-bottom white-bg page-heading">
      <div class="col-sm-12">
        <h2>Vehicle Master Entry</h2>
      </div>
    </div>
    
    <div class="wrapper wrapper-content  animated fadeInRight">
      <div class="ibox">
        <div class="ibox-content">
          <h3 class="m-t-none m-b">Vehicle Entry</h3>
          <div class="row">
			<form:form action="VehicleMasterSave" commandName ="VehicleMaster" >
				<div class="col-sm-12 ">
					<div class="row">
					`<div class="form-group col-sm-4">
							<label>Vehicle No:</label>
							
								<form:hidden path="status" value="Active"/>
							
							<c:if test="${VehicleMaster.editFlag==true }">
								<form:input path="vehicleNo" type="text" disabled="true" id="primaryKey" class="form-control"></form:input>
								<form:hidden path="editFlag" value="${VehicleMaster.editFlag}"/>
								<form:hidden path="createdBy" value="${VehicleMaster.createdBy}"/>
								<form:hidden path="createdOnShow" value="${VehicleMaster.createdOnShow}"/>
							</c:if>
							<c:if test="${VehicleMaster.editFlag==false }">
							<form:input path="vehicleNo" required="true" type="text" id="primaryKey" class="form-control"></form:input>
							<form:hidden path="editFlag" value="${VehicleMaster.editFlag}"/>
							</c:if>
						</div>
						
						 <div class="form-group col-sm-4">
                                    <label>Company</label>
                                   <form:select class="form-control" required="true" path="companyMaster.id" items="${companyMasters}" itemLabel="companyName" itemValue="id"></form:select>
                                </div>
                            
						
						<div class="form-group col-sm-4">
							<label>Serial No:</label>
							<form:input path="unitNo" pattern="\d*" required="true" title="It must be numberic data" type="text" id="unitNo" class="form-control"></form:input>
						</div>
						<div class="form-group col-sm-4">
							<label>Vehicle Type:</label>
							<form:input path="vehicleType" type="text" id="vehicleType" class="form-control"></form:input>
						</div>
						
						
						
						<div class="form-group col-sm-4">
							<label>Make:</label>
							<form:input  path="vehicleMake" type="text" id="vehicleMake" class="form-control"></form:input>
						</div>
						<div class="form-group col-sm-4">
							<label>Vehicle NP:</label>
							<form:input  path="nationalPermitNo" type="text" id="vehicleNP"  class="form-control"></form:input>
						</div>
						<div class="form-group col-sm-4">
							<label>NP Expiry Date:</label>
							<div class="input-group date">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
								<form:input  type="text" path="nationalPermitExpiryDateShow" id="Datepicker1" class="form-control"></form:input>
							</div>
						</div>
						<div class="form-group col-sm-4">
							<label>Issued RTO:</label>
							<form:input  path="issuedRTO" type="text" id="issuedRto" class="form-control"></form:input>
						</div>
						<div class="form-group col-sm-4">
							<label>Insurance No:</label>
							<form:input  path="insuranceNo" type="text" id="insuranceNo" class="form-control"></form:input>
						</div>
						<div class="form-group col-sm-4">
							<label>Insurance By:</label>
							<form:input path="insuranceIssuedBy" type="text" id="insuranceBy" class="form-control"></form:input>
						</div>
						<div class="form-group col-sm-4">
							<label>Insurance Date:</label>
							<div class="input-group date">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
								<form:input  type="text" id="Datepicker2" path="insuranceDateShow" class="form-control"></form:input>
							</div>
						</div>
						<div class="form-group col-sm-4">
							<label>Expiry Date:</label>
							<div class="input-group date">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
								<form:input  type="text" path="insuranceExpiryDateShow" id="Datepicker3" class="form-control"></form:input>
							</div>
						</div>
						<div class="form-group col-sm-4">
							<label>Odi. Meter:</label>
							<form:input  path="currentOdiMeter" pattern="\d*" title="It must be numberic data" type="text" id="odo" size="15" class="form-control"></form:input>
						</div>
						<div class="form-group col-sm-4">
							<label>Current Fuel:</label>
							<form:input  path="currentFuel" type="text" pattern="\d*" title="It must be numberic data" id="fuel" class="form-control"></form:input>
						</div>
						<div class="form-group col-sm-4">
							<label>Service(Km):</label>
							<form:input  path="serviceKm" type="text" pattern="\d*" title="It must be numberic data" id="service" class="form-control"></form:input>
						</div>
						<div class="form-group col-sm-4">
							<label>Service Date:</label>
							<div class="input-group date">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
								<form:input  type="text" path="serviceDateShow"  id="Datepicker4" class="form-control"></form:input>
							</div>
						</div>
						<div class="form-group col-sm-4">
							<label>Owner:</label>
							<form:input  path="ownerCompanyName" type="text" id="owner" class="form-control"></form:input>
						</div>
						<div class="form-group col-sm-4">
							<label>Contact 1:</label>
							<form:input  path="ownerContact1" type="text"  id="owner1" title="Please enter 10 digit number" pattern="[1-9]{1}[0-9]{9}" class="form-control"></form:input>
						</div>
						<div class="form-group col-sm-4">
							<label>Contact 2:</label>
							<form:input  path="ownerContact2" title="Please enter 10 digit number" pattern="[1-9]{1}[0-9]{9}" type="text" id="owner2"  class="form-control"></form:input>
						</div>
						<div class="form-group col-sm-4">
							<label>Email:</label>
							<form:input  path="ownerEmail" type="text" title="Please enter valid email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" id="email"  class="form-control"></form:input>
						</div>
						<div class="form-group col-sm-4">
							<label>Address:</label>
							<form:textarea  path="ownerAddress1" rows="2" maxlength="30" wrap="soft" id="address" class="form-control"></form:textarea>
						</div>
						<div class="form-group col-sm-4">
							<label>City:</label>
							<form:input  path="ownerCity" type="text"  id="city" class="form-control"></form:input>
						</div>
						<div class="form-group col-sm-4">
							<label>Pin:</label>
							<form:input path="ownerPinCode" pattern="\d*" title="It must be numberic data" type="text" id="pin" class="form-control"></form:input>
						</div>
						
					</div>
					<div class="form-group" style="text-align:center">
					<c:if test="${VehicleMaster.editFlag==false }">
						<input type="submit" class="btn  btn-primary" onclick=" return validate()" name="action" value="Save Vehicle">
					</c:if>
				<c:if test="${VehicleMaster.editFlag==true }">
							<input type="submit" class="btn  btn-primary" onclick=" return validate()" name="action" value="Update Vehicle">
				
				</c:if>
						<input type="button" class="btn  btn-danger" id="Exit"  onClick="location.href='VehicleMasters'" value="Close" >
                    </div>
				</div>

			</form:form>
		  </div>
        </div>
      </div>
    </div>
  </div>
  <jsp:directive.include file="footer.jsp" />
    </div>

    <!-- Mainly script
    s -->
    <script type="text/javascript" src="html/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="html/js/tether.min.js"></script>
    <script type="text/javascript" src="html/js/bootstrap.js"></script>
    <script type="text/javascript" src="html/js/angular.min.js"></script>
    <script type="text/javascript" src="html/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="html/js/dataTables.bootstrap.min.js"></script>
    <script src="html/js/bootstrap-datepicker.js" type="text/javascript"></script>
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
    
    $('#hdr_configuration').addClass("dropdown active");
	$('#hdr_configuration_link').click();
	$('#hdr_vehicleMaster').addClass("active");
    
        $('#Datepicker1').datepicker({
            autoclose: true
        });
		$('#Datepicker2').datepicker({
            autoclose: true
        });
		$('#Datepicker3').datepicker({
            autoclose: true
        });
		$('#Datepicker4').datepicker({
            autoclose: true
        });
		
        $(".timepicker").timepicker({
            showInputs: false
        });
		$('.i-checks').iCheck({
                    checkboxClass: 'icheckbox_square-green',
                    radioClass: 'iradio_square-green',
                });
		$('#errorMessage').fadeOut(5000);
		function validate(){
			$('#primaryKey').prop('disabled', false);
			return true;
		}
    </script>

</body>

<!-- Mirrored from kalkisoft.com/adhata/html/new-vehicle.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 30 Dec 2016 18:17:01 GMT -->
</html>
