<!DOCTYPE html>
<html>

<!-- Mirrored from kalkisoft.com/adhata/html/new-vehicle.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 30 Dec 2016 18:17:01 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>No Movement</title>
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
                    <h2>No Movement Entry </h2>
                </div>
            </div>
            <div class="wrapper wrapper-content  animated fadeInRight">
                <div class="ibox-content">
                    <div class="row">
                        <form:form action="AddOrUpdateMovementsRecord" commandName="Movement">
<form:hidden path="status" value="Active"/>

                            <div class="form-group col-sm-6">
                                <div class="radio i-checks">
                                                <label class="checkbox-inline i-checks">Is Group: </label>
                                                <c:if test="${Movement.editFlag==true }">
                                                    <form:checkbox disabled="true" path="groups"/>
                                                    </c:if>
                                                     <c:if test="${Movement.editFlag==false }">
                                                    <form:checkbox  path="groups"/>
                                                    </c:if>
                                            </div>
                               
                            </div>
                            <div class="form-group col-sm-6">
                                                                           <label>Vehicle No / Group Name</label>
                                          
                                            <c:if test="${Movement.editFlag==true }">
						          <form:input required="true" type="text"  path="vehicle" disabled="true" id="primaryKey" class="form-control" />
                                    		<form:hidden path="id"/>
									
                                    	<form:hidden path="editFlag" value="${Movement.editFlag}"/>
											<form:hidden path="createdBy" value="${Movement.createdBy}"/>
								<form:hidden path="createdDateShow" value="${Movement.createdDateShow}"/>
						
							</c:if>
							<c:if test="${Movement.editFlag==false }">
							 	   	<form:hidden path="editFlag" value="${Movement.editFlag}"/>
                                  	<form:select id="vehicleList" class="form-control" required="true" path="vehicle" items="${vehicleMasters}" itemLabel="vehicleNo" itemValue="vehicleNo"></form:select>
									 	<form:select id="groupList" disabled="true" cssStyle="display:none" class="form-control" required="true" path="vehicle" items="${vehicleGroups}" itemLabel="id" itemValue="id"></form:select>
								
							</c:if>
                                            <div class="clearfix"></div>
                                            <br>
                            </div>
                            <div class="form-group col-sm-6">
                                <label>Start Date:</label>
                                <div class="input-group date">
                                    <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                    <form:input type="text" placeholder="Start Date" path="startDateShow" id="startDate" class="form-control editor-field"/>
                                </div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label>End Date:</label>
                                <div class="input-group date">
                                    <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                    <form:input type="text" placeholder="End Date" path="endDateShow" id="endDate" class="form-control editor-field"/>
                                </div>
                            </div>
                            <div class="bootstrap-timepicker col-sm-6">
                                <div class="form-group">
                                    <label>Start Time:</label>
                                    <div class="input-group">
                                        <form:input type="text" placeholder="Start Time" path="startTime" id="startTime" class="form-control timepicker"/>
                                        <div class="input-group-addon">
                                            <i class="fa fa-clock-o"></i>
                                        </div>
                                    </div>
                                    <!-- /.input group -->
                                </div>
                            </div>
                            <div class="bootstrap-timepicker col-sm-6">
                                <div class="form-group">
                                    <label>End Time:</label>
                                    <div class="input-group">
                                        <form:input type="text" placeholder="End Time" path="endTime" id="endTime" class="form-control timepicker"/>
                                        <div class="input-group-addon">
                                            <i class="fa fa-clock-o"></i>
                                        </div>
                                    </div>
                                    <!-- /.input group -->
                                </div>
                            </div>
                            <div class="form-group col-sm-6">
                                 <label>Snooze Time </label>
                                     <form:input cssClass="timepicker form-control" path="fromSnooze" type="text" placeholder="From"  />
                                         <form:input cssClass="timepicker form-control" path="toSnooze" type="text" placeholder="To" />
                                               </div>
                            <div class="form-group col-sm-6">
                                <label for="RepeatOn"><b>Repeat On :</b></label>
                                <div class="clearfix"></div>
                                <label for="checkbox" class="checkbox-inline">Sunday </label>
                                <form:checkbox class="i-checks" path="sunday" id="sunday"  style="text-align: center; vertical-align: middle;"/>
                                <label for="checkbox2" class="checkbox-inline">Monday </label>
                                <form:checkbox class="i-checks" path="monday" id="monday"  style="text-align: center; vertical-align: middle;"/>
                                <label for="checkbox3" class="checkbox-inline">Tueday </label>
                                <form:checkbox class="i-checks" path="tuesday" id="tuesday"  style="text-align: center; vertical-align: middle;"/>
                                <label for="checkbox4" class="checkbox-inline">Wednesday</label>
                                <form:checkbox class="i-checks" path="wednesday" id="wednesday" style="text-align: center; vertical-align: middle;"/>
                                <label for="checkbox5" class="checkbox-inline">Thursday</label>
                                <form:checkbox class="i-checks" path="thursday" id="thursday" style="text-align: center; vertical-align: middle;" />
                                <label for="checkbox5" class="checkbox-inline">Friday</label>
                                <form:checkbox class="i-checks" path="friday"  id="friday" style="text-align: center; vertical-align: middle;"/>

                                <label for="checkbox5" class="checkbox-inline">Saturday</label>
                                <form:checkbox class="i-checks" path="saturday"  id="saturday" style="text-align: center; vertical-align: middle;"/>
                            </div>
                            <div class="form-group col-sm-12 text-center">
                                <input name="action" type="submit" class="btn btn-primary" id="button" value="Add Movement">
                                <input name="button3" type="button" class="btn btn-danger" id="button3" onclick="location.href = 'Movements'" value="Exit">
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
		$('#hdr_NoMovement').addClass("active");
       
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
