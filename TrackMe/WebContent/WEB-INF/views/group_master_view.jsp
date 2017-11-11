<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Vehicle Service View</title>
    <link href="html/css/css.css" rel="stylesheet" type="text/css" />
    <link href="html/css/bootstrap.min.css" rel="stylesheet">

    <link href="html/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="html/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="html/css/animate.css" rel="stylesheet">
    <link href="html/css/style.css" rel="stylesheet">
    <link href="html/css/custom.css" rel="stylesheet">
    <link href="html/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="html/css/buttons.dataTables.min.css" rel="stylesheet">
    <style type="text/css">
        input#addlocation {
            margin-top: 21px;
        }
    </style>
   
</head>
<body class="top-navigation" >
    <jsp:directive.include file="header.jsp" />
    <div id="wrapper">
        <div id="page-wrapper2" class="gray-bg">
            <div id="addGroup">
                <div class="rowx wrapper border-bottom white-bg page-heading">
                    <div class="col-sm-12">
                        <h2>Group View</h2>
                    </div>
                </div>
                <div class="">
                    <div class="ibox">
                        <div class="ibox-content">
                            <h3 class="m-t-none m-b">Group Entry</h3>
                            <div class="row">
                                <form:form action="AddOrUpdateVehicleGroup" commandName ="VehicleGroup" >
                                    <div id="Div1">

                                        <div class="col-sm-4 col-sm-offset-4">
                                            <div class="form-group">
                                                <label>Group Name</label>
                                                <form:input type="text" path="id" id="groupName" class="form-control" />
                                            </div>
                                        </div>
                                        <div class="col-sm-12 text-center">
                                            <input name="action" type="submit" class="btn btn-primary" id="button" value="Save Group" />
                                            <input name="button3" type="button" class="btn btn-danger" id="button3" onclick="location.href = 'group_master_view.html'" value="Close" />
                                        </div>
                                       
                                        <div class="col-sm-12">
                                        </br>
                                            <div class="table-responsive">
                                                <table class="table table-striped table-bordered new-tbl" id="entrydata1">
                                                    <thead>
                                                        <tr>
                                                            
                                                            <th>Group Name</th>

                                                        </tr>
                                                      
                                                    </thead>
                                                    <tbody>
                                                       

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>

                                    </div>
                                </form:form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

       <jsp:directive.include file="footer.jsp" />
    </div>
</body>
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
  var vehicleGroupJSON = ${vehicleGroupJSON};
      $(document).ready(function () {
    	  
    	  $('#hdr_configuration').addClass("dropdown active");
  		$('#hdr_configuration_link').click();
  		$('#hdr_VehicleGroupView').addClass("active");
  		$('#successMessage').fadeOut(5000);
		$('#errorMessage').fadeOut(5000);
		
          $('#entrydata1').DataTable({
          	dom: 'Bfrtp',
          	data:vehicleGroupJSON,
              columns:[
                       
                    
                       {data: "id"}
                                                                
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
            	$(".dt-buttons").css("top","3px");
            	$(".input-sm").css("height","25px");
            	}catch(err){}
            	});

        </script> 