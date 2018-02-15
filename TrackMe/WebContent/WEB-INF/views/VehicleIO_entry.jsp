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
                    <h2>Vehicle IO Entry </h2>
                </div>
            </div>
            <div class="wrapper wrapper-content  animated fadeInRight">
                <div class="ibox-content">
                    <div class="row">
                        <form:form action="AddOrUpdateVehicleIOsRecord" commandName="VehicleIO">
<form:hidden path="status" value="Active"/>

                          
                                    
                                          
                                            <c:if test="${VehicleIO.editFlag==true }">
						            		<form:hidden path="id"/>
									
                                    	<form:hidden path="editFlag" value="${VehicleIO.editFlag}"/>
											<form:hidden path="createdBy" value="${VehicleIO.createdBy}"/>
								<form:hidden path="createdOnShow" value="${VehicleIO.createdOnShow}"/>
						
							</c:if>
							<c:if test="${VehicleIO.editFlag==false }">
							 	   	<form:hidden path="editFlag" value="${VehicleIO.editFlag}"/>
                                   
							</c:if>
                                           
                           
                          
						<div class="form-group col-sm-6">
							<label>Vehicle:</label>
							<form:select  path="vehicleNo" id="vehicleNo" class="form-control">
   <form:option value="" label="select" />
    <form:options items="${vehicleMasters}" itemValue="vehicleNo" itemLabel="vehicleNo"></form:options>
    </form:select>
							
						</div>
                         
                          
						<div class="form-group col-sm-6">
							<label>Device No:</label>
							<form:select  path="deviceNo" id="deviceNo" class="form-control">
   <form:option value="" label="select" />
    <form:options items="${deviceMasters}" itemValue="deviceNo" itemLabel="deviceNo"></form:options>
    </form:select>
							
						</div>
						
						
				  
						<div class="form-group col-sm-3">
						<label>GPO 1:</label>
							<form:input  path="gpo1" class="form-control"/>
						</div>
						<div class="form-group col-sm-3">
						<label>Type 1:</label>
							<form:input path="type1" class="form-control"/>
						</div>
						<div class="form-group col-sm-3">
						<label>Level Max 1:</label>
							<form:input path="leveMax1" class="form-control"/>
						</div>
							<div class="form-group col-sm-3">
						<label>Status Type 1:</label>
							<form:input path="statusType1" class="form-control"/>
						</div>	
						
						
						<div class="form-group col-sm-3">
						<label>GPO 2:</label>
							<form:input  path="gpo2" class="form-control"/>
						</div>
						<div class="form-group col-sm-3">
						<label>Type 2:</label>
							<form:input path="type2" class="form-control"/>
						</div>
						<div class="form-group col-sm-3">
						<label>Level Max 2:</label>
							<form:input path="leveMax2" class="form-control"/>
						</div>
							<div class="form-group col-sm-3">
						<label>Status Type 2:</label>
							<form:input path="statusType2" class="form-control"/>
						</div>	
                               
                         <div class="form-group col-sm-3">
						<label>GPO 3:</label>
							<form:input  path="gpo3" class="form-control"/>
						</div>
						<div class="form-group col-sm-3">
						<label>Type 3:</label>
							<form:input path="type3" class="form-control"/>
						</div>
						<div class="form-group col-sm-3">
						<label>Level Max 3:</label>
							<form:input path="leveMax3" class="form-control"/>
						</div>
							<div class="form-group col-sm-3">
						<label>Status Type 3:</label>
							<form:input path="statusType3" class="form-control"/>
						</div>	  
						
						<div class="form-group col-sm-3">
						<label>GPO 4:</label>
							<form:input  path="gpo4" class="form-control"/>
						</div>
						<div class="form-group col-sm-3">
						<label>Type 4:</label>
							<form:input path="type4" class="form-control"/>
						</div>
						<div class="form-group col-sm-3">
						<label>Level Max 4:</label>
							<form:input path="leveMax4" class="form-control"/>
						</div>
							<div class="form-group col-sm-3">
						<label>Status Type 4:</label>
							<form:input path="statusType4" class="form-control"/>
						</div>	    
                               
                               
                          <div class="form-group col-sm-3">
						<label>GPO 5:</label>
							<form:input  path="gpo5" class="form-control"/>
						</div>
						<div class="form-group col-sm-3">
						<label>Type 5:</label>
							<form:input path="type5" class="form-control"/>
						</div>
						<div class="form-group col-sm-3">
						<label>Level Max 5:</label>
							<form:input path="leveMax5" class="form-control"/>
						</div>
							<div class="form-group col-sm-3">
						<label>Status Type 5:</label>
							<form:input path="statusType5" class="form-control"/>
						</div>	
						
						<div class="form-group col-sm-3">
						<label>GPO 6:</label>
							<form:input  path="gpo6" class="form-control"/>
						</div>
						<div class="form-group col-sm-3">
						<label>Type 6:</label>
							<form:input path="type6" class="form-control"/>
						</div>
						<div class="form-group col-sm-3">
						<label>Level Max 6:</label>
							<form:input path="leveMax6" class="form-control"/>
						</div>
							<div class="form-group col-sm-3">
						<label>Status Type 6:</label>
							<form:input path="statusType6" class="form-control"/>
						</div>	
						        
						 <div class="form-group col-sm-6">
						<label>ADC 1:</label>
							<form:input path="adc1" class="form-control"/>
						</div>
							<div class="form-group col-sm-6">
						<label>ADC 2:</label>
							<form:input path="adc2" class="form-control"/>
						</div>	       
						          
                                       <div class="form-group col-sm-12 text-center">
                                  <c:if test="${VehicleIO.editFlag==true }">
						            	
                                <input name="action" type="submit" class="btn btn-primary" id="button" value="Update Vehicle IO">
                                </c:if>
                                 <c:if test="${VehicleIO.editFlag==false }">
						            	
                                <input name="action" type="submit" class="btn btn-primary" id="button" value="Add Vehicle IO">
                                </c:if>
                                <input name="button3" type="button" class="btn btn-danger" id="button3" onclick="location.href = 'VehicleIOs'" value="Exit">
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
    $('#hdr_configuration').addClass("dropdown active");
		$('#hdr_configuration_link').click();
		$('#hdr_vehicleIO').addClass("active");
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

<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">

</html>
