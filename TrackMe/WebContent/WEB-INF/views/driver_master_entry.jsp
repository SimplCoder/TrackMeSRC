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
                    <h2>Driver Master Entry </h2>
                </div>
            </div>
            <div class="wrapper wrapper-content  animated fadeInRight">

                <div class="ibox-content">
                    <h3 class="m-t-none m-b">Driver Master Entry </h3>
                    <div class="row">
                       <form:form action="AddOrUpdateDriverMastersRecord" commandName ="DriverMaster" >

                            <div class="rowx ">
                                <div class="form-group col-sm-4">
                                    <label>Driver Id</label>
                                    <c:if test="${DriverMaster.editFlag==true }">
								<form:input pattern="\d*" required="true" title="It must be numberic data" type="text"  path="id" disabled="true" id="primaryKey" class="form-control" />
                                  <form:hidden path="createdBy" value="${DriverMaster.createdBy}"/>
								<form:hidden path="formatedCreatedDate" value="${DriverMaster.formatedCreatedDate}"/>
						  
								<form:hidden path="editFlag" value="${DriverMaster.editFlag}"/>
							</c:if>
							<c:if test="${DriverMaster.editFlag==false }">
								<form:input pattern="\d*" required="true" title="It must be numberic data" type="text"  path="id" id="primaryKey" class="form-control" />
                            <form:hidden path="editFlag" value="${DriverMaster.editFlag}"/>
							</c:if>
                                     
                                </div>
                                <div class="form-group col-sm-4">
                                    <label>Driver Name</label>
                                    <form:input required="true" type="text" path="driverName"  class="form-control" id="Text1" />

                                </div>
                                <div class="form-group col-sm-4">
                                    <label>Driving license</label>
                                    <form:input required="true" type="text" path="licenseNo" id="Text5" placeholder="Driving license No." class="form-control" />

                                </div>
                                <div class="form-group col-sm-4">
                                    <div id="data_1">
                                        <label>Driving license Expiry Date</label>
                                        <div class="input-group date">
                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                            <form:input required="true" type="text" path="formatedExpireDate" id="Text6" class="form-control" value="03/04/2014" />

                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-sm-4">
                                    <label>Issued RTO</label>
                                    <form:input required="true" type="text" id="Text7" placeholder="Issued RTO" path="rtoName" class="form-control" />

                                </div>
                                <div class="form-group col-sm-4">
                                    <label>Blood Group</label>
                                    <form:input required="true" type="text" placeholder="Blood Group" path="bloodGroup" id="Text8" class="form-control" />

                                </div>
                                <div class="form-group col-sm-4">
                                    <label>Driving Experience</label>
                                    <form:input required="true" type="text" placeholder="Driving Experience" id="Text9" path="driverexp" class="form-control"/>
                                </div>
                                <div class="form-group col-sm-4">
                                    <label>Contact 1</label>
                                    <form:input required="true" title="Please enter 10 digit number" pattern="[1-9]{1}[0-9]{9}" type="text" placeholder="Contact No" path="contact1" id="Text3" class="form-control"/>
                                </div>
                                <div class="form-group col-sm-4">
                                    <label>Contact 2</label>
                                    <form:input required="true" title="Please enter 10 digit number" pattern="[1-9]{1}[0-9]{9}" type="text" path="contact2" id="Text4" placeholder="Contact No" class="form-control"/>
                                </div>
                                <div class="form-group col-sm-4">
                                    <label>Address</label>
                                    <form:textarea class="form-control" type="text" path="address" id="Text2" rows="3" placeholder="Address"></form:textarea>

                                </div>
                                <div class="form-group col-sm-4">
                                    <label>Remark </label>
                                    <form:textarea path="remark" rows="2" maxlength="50" id="Textarea1" class="form-control"></form:textarea>
                                </div>
                            </div>
                            <div style="text-align: center">
                            <c:if test="${DriverMaster.editFlag==false }">
                                <input name="action" type="submit" class="btn  btn-primary" onclick=" return validate()" id="Submit1" value="Add Driver" />
                            </c:if>
                               <c:if test="${DriverMaster.editFlag==true }">
                                <input name="action" type="submit" class="btn  btn-primary" onclick=" return validate()" id="Submit1" value="Update Driver" />
                               </c:if>
                                <input name="button3" type="button" class="btn btn-danger" id="button1" onclick="location.href = 'DriverMasters'" value="Exit" />
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
	$('#hdr_DriverMasters').addClass("active");

    
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


