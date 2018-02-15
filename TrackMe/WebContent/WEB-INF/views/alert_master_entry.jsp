<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>

<!-- Mirrored from kalkisoft.com/adhata/html/new-vehicle.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 30 Dec 2016 18:17:01 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alert</title>
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

<body class="top-navigation">
 <jsp:directive.include file="header.jsp" />

    <div id="wrapper">
       <div id="page-wrapper2" class="gray-bg">
        
            <div class="rowx wrapper border-bottom white-bg page-heading">
                <div class="col-sm-12">
                    <h2>
                      <c:if test="${Alert.editFlag==true }">
                                                    Alert Update </c:if>
                                                     <c:if test="${Alert.editFlag==false }">
                                                     Alert Entry
                                                    </c:if>
                    
                    </h2>
                </div>
            </div>
            <div class="wrapper wrapper-content  animated fadeInRight">
                <div class="ibox">
                    <div class="ibox-content">
                       
                        <div class="row">
                            <form:form  action="AddOrUpdateAlertsRecord" commandName="Alert">
                              <form:hidden path="status" value="Active"/>

							 <div class="col-sm-12 ">
                                    <div class="row">
                                        <div class="form-group col-sm-6">
                                           
                                            <div class="radio i-checks">
                                                <label class="checkbox-inline i-checks">Grouped : </label>
                                                <c:if test="${Alert.editFlag==true }">
                                                    <form:checkbox disabled="true" path="group"/>
                                                    </c:if>
                                                     <c:if test="${Alert.editFlag==false }">
                                                    <form:checkbox  path="group"/>
                                                    </c:if>
                                            </div>
                                        </div>
                                        <div class="form-group col-sm-6">
                                            <label>Vehicle No / Group Name</label>
                                          
                                            <c:if test="${Alert.editFlag==true }">
						          <form:input required="true" type="text"  path="vehicleNo" disabled="true" id="primaryKey" class="form-control" />
                                    	<form:hidden path="editFlag" value="${Alert.editFlag}"/>
											<form:hidden path="createdBy" value="${Alert.createdBy}"/>
								<form:hidden path="createdDateShow" value="${Alert.createdDateShow}"/>
						
							</c:if>
							<c:if test="${Alert.editFlag==false }">
							 	   	<form:hidden path="editFlag" value="${Alert.editFlag}"/>
                                  	<form:select id="vehicleList" class="form-control" required="true" path="vehicleNo" items="${vehicleMasters}" itemLabel="vehicleNo" itemValue="vehicleNo"></form:select>
									 	<form:select id="groupList" disabled="true" cssStyle="display:none" class="form-control" required="true" path="vehicleNo" items="${vehicleGroups}" itemLabel="id" itemValue="id"></form:select>
								
							</c:if>
                                            <div class="clearfix"></div>
                                            <br>
                                        </div>

                                        <div class="form-group col-sm-6">
                                            <label>Snooze Time </label>
                                     <form:input cssClass="timepicker form-control" path="fromSnooze" type="text" placeholder="From"  />
                                         <form:input cssClass="timepicker form-control" path="toSnooze" type="text" placeholder="To" />
                                     
                                        </div>
                                        <div class="form-group col-sm-6">
                                            <label>Schedule Type</label>
                                            <div class="clearfix"></div>
                                            <label class="checkbox-inline i-checks">Over Speed: </label>
                                            <form:checkbox path="overSpeed"  class="i-checks" id="Checkbox1" />&nbsp;&nbsp;
                      
					 

                                            <label class="checkbox-inline i-checks">Sudden Break: </label>
                                            <form:checkbox path="suddenBreak"  class="i-checks" id="Checkbox2" />&nbsp;&nbsp;
                      
                     

                                            <label class="checkbox-inline i-checks">Idle Time: </label>
                                            <form:checkbox class="i-checks" path="idleTime" id="Checkbox3"/>&nbsp;&nbsp;
                      
                     

                                            <label class="checkbox-inline i-checks">Panic: </label>
                                            <form:checkbox class="i-checks" path="panic"  id="Checkbox4"/>&nbsp;&nbsp;
                      
                     

                                            <label class="checkbox-inline i-checks">Geofence:  </label>
                                            <form:checkbox class="i-checks" path="geofency"  id="Checkbox5"/>&nbsp;&nbsp;
				 
                                        </div>
                                        <div class="form-group col-sm-6">
                                            <label>Alert By</label>
                                            <div class="clearfix"></div>
                                            <label class="checkbox-inline i-checks">SMS: </label>
                                            <form:checkbox path="alertBySms"  class="i-checks" id="SMSCheckbox"/>&nbsp;&nbsp;
                    
                   

                                            <label class="checkbox-inline i-checks">Mail: </label>
                                            <form:checkbox class="i-checks" path="alertByMail" id="mailCheckbox"/>&nbsp;&nbsp;
                   
                 
                                        </div>
                                        <div class="clearfix"></div>
                                        <div class="form-group col-sm-6">
                                            <label>Contact No</label>
                                            <form:input path="contactNo" type="text" placeholder="Contact No" id="SMSCheckbox" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="col-sm-12 text-center ">
                                       <c:if test="${Alert.editFlag==true }">
							
                                <input name="action" type="submit" onclick=" return validate()" class="btn  btn-primary" id="Submit1" value="Update Alert" />
                            </c:if>
                            <c:if test="${Alert.editFlag==false }">
							     <input name="action" type="submit" class="btn  btn-primary" id="Submit1" value="Save Alert" />
                           </c:if>
                                <input name="button3" type="button" class="btn btn-danger" id="button1" onclick="location.href = 'Alerts'" value="Exit" />
                              </div>
                                </div>
                            </form:form >
                        </div>
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
		$('#hdr_Alerts').addClass("active");
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green'
            
        });
        $('#hdr_configuration').addClass("dropdown active");
  		$('#hdr_configuration_link').click();
  		$('#hdr_Alerts').addClass("active");
  		$('#successMessage').fadeOut(5000);
		$('#errorMessage').fadeOut(5000);
		function validate(){
			$('#primaryKey').prop('disabled', false);
			$('#group').prop('disabled', false);
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
    </script>
</body>

<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
<!-- Mirrored from kalkisoft.com/adhata/html/new-vehicle.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 30 Dec 2016 18:17:01 GMT -->
</html>
