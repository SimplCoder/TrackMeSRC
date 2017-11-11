<!DOCTYPE html>
<html>

<!-- Mirrored from kalkisoft.com/adhata/html/new-vehicle.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 30 Dec 2016 18:17:01 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Report</title>
       <link href="html/css/css.css" rel="stylesheet" type="text/css" />
    <link href="html/css/bootstrap.css" rel="stylesheet">

    <link href="html/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="html/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="html/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="html/css/animate.css" rel="stylesheet">
    <link href="html/css/style1.css" rel="stylesheet">
    <link href="html/css/custom1.css" rel="stylesheet">
    <link href="html/css/bootstrap-timepicker.css" rel="stylesheet">
    <link href="html/css/datepicker3.css" rel="stylesheet"></head>


<body class="top-navigation" >
 <jsp:directive.include file="header.jsp" />
    <div id="wrapper">
     
       <div id="page-wrapper2" class="gray-bg">
            <div class="rowx wrapper border-bottom white-bg page-heading">
                <div class="col-sm-12">
                    <h2>Reports</h2>
                </div>
            </div>
            <div class="wrapper wrapper-content  animated fadeInRight">
                <div class="ibox-content">
                    <div class="row">
                        <form:form action="Reports" commandName="vehicleReport">
                           
                            <div class="form-group col-sm-6">
                                       <label>Report Type:</label>                                  
                                	<form:select id="reportList" class="form-control" required="true" path="reportName">
                                	<form:option  value="Consolidate Report">Consolidate Report</form:option>
                                	<form:option  value="Ignition Report">Ignition Report</form:option>
                                	<form:option  value="Interval Report">Interval Report</form:option>
                                	<form:option  value="Movement Report">Movement Report</form:option>
                                	<form:option  value="Overspeed Report">Overspeed Report</form:option>
                                	<form:option  value="Stoppage Report">Stoppage Report</form:option>
                                	<form:option  value="Harsh Break">Harsh Break</form:option>
                                	
                                	</form:select>
								
						
                                          
                                            
                            </div>
                            
                              <div class="form-group col-sm-6">
                                                                           <label>Vehicle No:</label>
                                	<form:select id="vehicleList" class="form-control" required="true" path="vehicle" items="${vehicleMasters}" itemLabel="vehicleNo" itemValue="vehicleNo"></form:select>
								
						
                                          
                                            
                            </div>
                            <div class="form-group col-sm-6">
                                <label>Start Date:</label>
                                <div class="input-group date">
                                    <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                    <form:input type="text" placeholder="Start Date" path="startDate" id="startDate" class="filthypillow-demo form-control editor-field"/>
                                </div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label>End Date:</label>
                                <div class="input-group date">
                                    <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                    <form:input type="text" placeholder="End Date" path="endDate" id="endDate" class="filthypillow-demo form-control editor-field"/>
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
                            
                            
                            <div class="form-group col-sm-12 text-center">
                                <input name="action" type="submit" class="btn btn-primary" id="button" value="Report">
                                <input name="button3" type="button" class="btn btn-danger" id="button3" onclick="location.href = 'Reports'" value="Reset">
                     
                         
                            </div>
                        </form:form>
                    </div>
                </div>



            </div>
      
              <div class="row">
                <div class="col-lg-12">
                    <div class="">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="ibox float-e-margins">
                                
                                
                                    <div class="ibox-content">



											<div id="editMovement">


                                            <div class="table-responsive">
								
                                                <table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" class="entrydata table table-striped table-bordered new-tbl" id="entrydata">
                                                   
                                                </table>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
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
       
        
        $('#successMessage').fadeOut(5000);
		$('#errorMessage').fadeOut(5000);
		
		
		$(document).ready(function(){
		    $('input.timepicker').timepicker({
		    	 scrollbar: true
		    });
		});
		
			
	
    $('#startDate').datepicker({
    	dateFormat: 'yy-mm-dd',
        autoclose: true,
        height: 100
       

    });
    $('#endDate').datepicker({
    	dateFormat: 'yy-mm-dd',
        autoclose: true,
        height: 100
        
    });
    
     </script>
</body>

<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">

</html>



<script>
  var reportJSON = ${reportJSON};
  
  var cols = [];

  var exampleRecord = reportJSON[0];

  var keys = Object.keys(exampleRecord);

  keys.forEach(function(k) {
    cols.push({
      title: k,
      data: k
        //optionally do some type detection here for render function
    });
  });
  
      $(document).ready(function () {
    	 
          $('#entrydata').DataTable({
        	  dom: '<"top"lBf>rt<"bottom"p><"clear">',
          	data:reportJSON,
          	 columns: cols,
          	
  			ordering:false,
  			 lengthMenu: [[10, 25, 50, -1], [10, 25, 50, "All"]],
 			buttons: [
 

 {
     extend: 'excelHtml5',
     text :''
  },{
 	    extend:'pdfHtml5',
 	    text :''
 	 }
 ]
          }); 
          if ($("input[type='search']").length > 0) {
              $("input[type='search']").addClass("form-control");
          }
          if ($("select[name='entrydata_length']").length > 0) {
              $("select[name='entrydata_length']").addClass("form-control");
          }
          $('.i-checks').iCheck({
              checkboxClass: 'icheckbox_square-green',
              radioClass: 'iradio_square-green',
          });
      });

   
  </script>

<style>

button.dt-button, div.dt-button, a.dt-button {
    position: relative;
    display: inline-block;
    box-sizing: border-box;
    margin-right: 0.333em;
    padding: 0.5em 0em;
    border: 0px solid #999;
    border-radius: 2px;
    cursor: pointer;
    font-size: 0.88em;
    color: black;
    white-space: nowrap;
    overflow: hidden;
    background-color: rgba(233, 233, 233, 0);
    background-image: -webkit-linear-gradient(top, #fff 0%, #e9e9e9 100%);
    background-image: -moz-linear-gradient(top, #fff 0%, #e9e9e9 100%);
    background-image: -ms-linear-gradient(top, #fff 0%, #e9e9e9 100%);
    background-image: -o-linear-gradient(top, #fff 0%, #e9e9e9 100%);
    background-image: linear-gradient(to bottom, #fff 0%, rgba(233, 233, 233, 0) 100%);
    filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,StartColorStr='white', EndColorStr='#e9e9e9');
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    text-decoration: none;
    outline: none;
}

</style>

<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
