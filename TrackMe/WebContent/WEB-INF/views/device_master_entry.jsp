<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>

<!-- Mirrored from kalkisoft.com/adhata/html/new-vehicle.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 30 Dec 2016 18:17:01 GMT -->
<head>
    <meta charset="utf-8">
    <meta path="viewport" content="width=device-width, initial-scale=1.0">
    <title>NST GPS</title>
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
                    <h2>Device Master Entry </h2>
                </div>
            </div>
            <div class="wrapper wrapper-content  animated fadeInRight">

                <div class="ibox-content">
                    <h3 class="m-t-none m-b">Device Master Entry </h3>
                    <div class="row">
                       <form:form action="AddOrUpdateDeviceMastersRecord" commandName ="DeviceMaster" >

                            <div class="rowx ">
                                <div class="form-group col-sm-4">
                                    <label>Device No</label>
                                    <c:if test="${DeviceMaster.editFlag==true }">
							
                                    <form:input required="true" type="text"  path="deviceNo" disabled="true" id="primaryKey" class="form-control" />
                                    	<form:hidden path="editFlag" value="${DeviceMaster.editFlag}"/>
											<form:hidden path="createdBy" value="${DeviceMaster.createdBy}"/>
								<form:hidden path="createdDateShow" value="${DeviceMaster.createdDateShow}"/>
						
							</c:if>
							<c:if test="${DeviceMaster.editFlag==false }">
							 	  <form:input type="text" required="true"  path="deviceNo"  id="primaryKey" class="form-control" />
                                  
							 <form:hidden path="editFlag" value="${DeviceMaster.editFlag}"/>
							</c:if>
							 
                                </div>
                                <div class="form-group col-sm-4">
                                    <label>Device IMEI</label>
                                    <form:input type="text" required="true"  path="deviceIMEI"  class="form-control" id="deviceIMEI" />

                                </div>
                                <div class="form-group col-sm-4">
                                    <label>Device Module </label>
                                    <form:input type="text" required="true" path="deviceModule" id="deviceModule" class="form-control" />

                                </div> 
                                <div class="form-group col-sm-4">
                                    <label>Sim Number </label>
                                    <form:input type="text" required="true" path="simNumber" id="simNumber" class="form-control" />

                                </div>
                                <div class="form-group col-sm-4">
                                    <label>Sim Provider </label>
                                    <form:input type="text" required="true" path="simProvider" id="simProvider" class="form-control" />

                                </div>

                            </div>
                            <div style="text-align: center">
                               <c:if test="${DeviceMaster.editFlag==true }">
							
                                <input name="action" type="submit" onclick=" return validate()" class="btn  btn-primary" id="Submit1" value="Update Device" />
                            </c:if>
                            <c:if test="${DeviceMaster.editFlag==false }">
							     <input name="action" type="submit" onclick=" return validate()" class="btn  btn-primary" id="Submit1" value="Save Device" />
                           </c:if>
                                <input name="button3" type="button" class="btn btn-danger" id="button1" onclick="location.href = 'DeviceMasters'" value="Exit" />
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
    <script type="text/javascript">
	  $('#hdr_configuration').addClass("dropdown active");
		$('#hdr_configuration_link').click();
		$('#hdr_DeviceMasters').addClass("active");
	
        $('#data_1 .input-group.date').datepicker({
            autoclose: true
        });
        $('#data_2 .input-group.date').datepicker({
            autoclose: true
        });
        $('#data_3 .input-group.date').datepicker({
            autoclose: true
        });
        $('#data_4 .input-group.date').datepicker({
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
</html>


