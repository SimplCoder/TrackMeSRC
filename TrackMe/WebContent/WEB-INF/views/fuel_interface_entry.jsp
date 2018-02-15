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
                    <h2>Fuel Entry</h2>
                </div>
            </div>
            <div class="wrapper wrapper-content  animated fadeInRight">
                <div class="ibox-content">
                    <h3 class="m-t-none m-b">Add New Vehicle</h3>

                        <div class="row">
                            <form role="form">
                                <div class="col-sm-12 ">
                                    <div class="row">
                                        <div class="form-group col-sm-6">
                                            <label for="textfield" class="user-label" style="width: 135px">Select Vehicle :</label>
                                            <input name="textfield" type="text" id="textfield" class="form-control" />
                                        </div>
                                        <div class="form-group col-sm-6">
                                            <label for="textfield2" class="user-label" style="width: 140px">Select Driver Name :</label>
                                            <input type="text" name="textfield2" id="textfield2" class="form-control" />
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-sm-6">
                                            <label for="date" class="user-label">Fuel/Litre :</label>
                                            <input name="textfield4" type="text" id="textfield4" class="form-control" />
                                        </div>
                                        <div class="form-group col-sm-6">
                                            <label for="date2" class="user-label">Quantity(in Rs.)</label>
                                            <input name="textfield9" type="text" class="form-control" id="textfield9" />
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-sm-6">
                                            <label>Date of Filling :</label>
                                            <div class="input-group date">
                                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                                <input type="text" placeholder="Start Date" name="date2" id="date2" class="form-control editor-field" />

                                            </div>
                                        </div>
                                        <div class="bootstrap-timepicker col-sm-6">
                                            <div class="form-group">
                                                <label>Felling Time :</label>
                                                <div class="input-group">
                                                    <input type="text" placeholder="Start Time" name="time" id="time" class="form-control timepicker" />
                                                    <div class="input-group-addon">
                                                        <i class="fa fa-clock-o"></i>
                                                    </div>
                                                </div>
                                                <!-- /.input group -->
                                            </div>
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="form-group col-sm-6">
                                            <label for="textfield3" class="user-label" style="width: auto">Service Station Name :</label>
                                            <input type="text" name="textfield8" id="textfield8" class="form-control" />
                                        </div>
                                        <div class="form-group col-sm-6">
                                            <label for="textfield4" class="user-label">Select Location :</label>
                                            <input type="text" name="textfield3" id="textfield3" class="form-control" />
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="form-group col-sm-6">
                                            <label for="textfield3" class="user-label">Bill No :</label>
                                            <input type="text" name="textfield5" id="textfield5" class="form-control" />
                                        </div>
                                        <div class="form-group col-sm-6">
                                            <label for="textfield4" class="user-label">Amount :</label>
                                            <input type="text" name="textfield6" id="textfield6" class="form-control" />
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="form-group col-sm-6">
                                            <label for="textfield3" class="user-label">Current Odo :</label>
                                            <input type="text" name="textfield7" id="textfield7" class="form-control" />
                                        </div>
                                    </div>
                                    <div align="center">

                                        <input name="button" type="button" class="btn btn-primary" id="button" value="Save" />
                                        <input name="button2" type="reset" class="btn btn-success" id="button2" value="Reset" />
                                        <input name="button3" type="button" class="btn btn-danger" id="button3" onclick="location.href = 'fuel.html'" value="Exit" />

                                    </div>
                                </div>
                            </form>
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
    $('#hdr_settings').addClass("dropdown active");
		$('#hdr_settings_link').click();
		$('#hdr_fuel').addClass("active");
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









