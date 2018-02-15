<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>NST-GPS System</title>
    <link href="html/css/css.css" rel="stylesheet" type="text/css" />
    <link href="html/css/bootstrap.min.css" rel="stylesheet">

    <link href="html/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="html/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="html/css/animate.css" rel="stylesheet">
    <link href="html/css/style.css" rel="stylesheet">
    <link href="html/css/custom.css" rel="stylesheet">
    <link href="html/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="html/css/buttons.dataTables.min.css" rel="stylesheet">
</head>
<body class="top-navigation" onload="loadData()">
 <jsp:directive.include file="header.jsp" />
    <div id="wrapper">
      

        <div id="page-wrapper2" class="gray-bg">
            <div class="rowx wrapper border-bottom white-bg page-heading">
                <div class="col-sm-6">
                    <h2>Fuel</h2>
                </div>
                <div class="col-sm-6">
                    <div class="text-right">
                        <a href="Fuel_interface_entry.html" target="_blank" style="width:120px" class="btn btn-primary">Add Nerw</a>
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
     
                                        <div class="table-responsive">
										  
          
                                            <table id="entrydata" class="table table-striped table-bordered new-tbl dt-responsive nowrap">
                                                <thead>
                                                    <tr>
                                                        <th></th>
														 <th></th>
                                                        <th>Vehicle No</th>
                                                        <th>Driver Name</th>
                                                        <th>Date</th>
                                                        <th>Time</th>
                                                        <th>Location</th>
                                                        <th>Station Name</th>
                                                        <th>Fuel/Litres</th>
                                                        <th>Amount</th>
                                                        <th>Bill No</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                            
                                                   </tbody>
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
       <jsp:directive.include file="footer.jsp" />

    </div>
    <script type="text/javascript" src="html/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="html/js/tether.min.js"></script>
    <script type="text/javascript" src="html/js/bootstrap.js"></script>
    <script type="text/javascript" src="html/js/angular.min.js"></script>
    <script type="text/javascript" src="html/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="html/js/dataTables.bootstrap.min.js"></script>

    <script type="text/javascript" src="html/js/dataTables.buttons.min.js"></script>
    <script type="text/javascript" src="html/js/buttons.flash.min.js"></script>
    <script type="text/javascript" src="html/js/jspdf.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
    <script type="text/javascript" src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js"></script>
    <script type="text/javascript" src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.2.4/js/buttons.html5.min.js"></script>
    <script type="text/javascript" src="html/js/icheck.min.js"></script>

<script>


var fuelDetailsJSON = ${FuelDetailsJSON};
    $(document).ready(function () {
    	
    	 $('#hdr_settings').addClass("dropdown active");
   		$('#hdr_settings_link').click();
   		$('#hdr_fuel').addClass("active");
        $('#entrydata').DataTable({
        	dom: 'Bfrtp',
        	data:fuelDetailsJSON,
            columns:[
                     {data: "tranid",
                    	 "render": function ( data, type, full, meta ) {
                    	      return '<a href=""><i class="fa fa-pencil-square-o iconedit"  aria-hidden="true"></i></a>';}
                    	 },
                     {data: "tranid",
                        	 "render": function ( data, type, full, meta ) {
                       	      return '<a href=""><i class="fa fa-trash  icondelete" aria-hidden="true"></i></a>';}
                       	
                    		 
                     },
                     {data: "vehicleNo"},
                     {data: "driverName"},
                     {data: "fillDate"},
					 {data: "time"},
                     {data: "location"},
                     {data: "stationName"},
                     {data: "fuelPerLitre"},
                     {data: "amount"},
                     {data: "billNo"},
                        
                    
					                  
                 ],
        	
			ordering:false,
            buttons: [
						
						                            'excelHtml5',
                            'pdfHtml5'
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
</body>
</html>
<script>
            $(document).ready(function () {
			
			$(".dt-buttons").addClass("pull-right");
					$("#entrydata_filter").addClass("pull-left");
                
            });
            
            $( document ).ready(function() {
                
            	try{

            	    $(".buttons-html5").removeClass("dt-button");
            	    $(".buttons-html5").html("");
            	    $(".buttons-pdf").addClass("fa-file-pdf-o");
            	    $(".buttons-excel").addClass("fa-file-excel-o");
            	        $(".fa-file-pdf-o").addClass(".buttons-pdf");
            	            $(".fa-file-excel-o").addClass(".buttons-excel");
            	        
            	    
            	$(".buttons-excel::before").css("font-size","23px !important");
            	$(".buttons-excel::before").css("padding-left","17px !important");

            	$(".buttons-pdf::before").css("font-size","23px !important");
            	$(".buttons-pdf::before").css("padding-left","10px !important");

            	$(".table-responsive").css("position","relative");

            	$(".dt-buttons").css("position","absolute");
            	$(".dt-buttons").css("left","20%");
            	$(".dt-buttons").css("top","1px");
            	$(".input-sm").css("height","25px");
            	}catch(err){}
            	});

        </script> 
