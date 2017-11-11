<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Vehicle Service View</title>
<link href="html/css/css.css" rel="stylesheet" type="text/css"/>
<link href="html/css/bootstrap.min.css" rel="stylesheet">

<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
<link href="html/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="html/css/animate.css" rel="stylesheet">
<link href="html/css/style.css" rel="stylesheet">
<link href="html/css/custom.css" rel="stylesheet">
<link href="html/css/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="html/css/buttons.dataTables.min.css" rel="stylesheet">
<link href="https://cdn.datatables.net/select/1.2.1/css/select.dataTables.min.css" rel="stylesheet">
</head>
<body class="top-navigation">
<jsp:directive.include file="header.jsp" />
  <div id="page-wrapper2" class="gray-bg" >
  
   <div id="messagePrepender" class="rowx wrapper border-bottom white-bg page-heading">
            <div class="col-sm-6">
                <h2>Vehicle View</h2>
              
            </div>
           
		   
        </div>
   <div class="row">
      <div class="col-lg-12">
          <div class="row">
            <div class="col-lg-12">
              <div class="ibox float-e-margins">
                 <div class="ibox-content">
                             
                  <div class="table-responsive">
                        <table width="100%" id="entrydata"  class="entrydata table table-striped table-bordered new-tbl" >
                          <thead>
                          <tr class="leftMenu" >
                                                    	 
                                                    <th width="8%" align="center" valign="middle">Vehicle No</th>
                                                    <th width="15%" align="center" valign="middle">Status</th>
                                                    <th width="5%" align="center" valign="middle">Speed</th>                                               
                                                    <th width="45%" align="center" valign="middle">Location</th>
                                                    <th width="20%" align="center" valign="middle">Date/Time</th>
                                                    <th width="7%" align="center" valign="middle">Idle Time (dd:hh:mm)</th>
												
                                                </tr>
                          </thead>
                          
                        </table>
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

<!-- Mainly scripts --> 
<script type="text/javascript" src="html/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="html/js/tether.min.js"></script>
<script type="text/javascript" src="html/js/bootstrap.js"></script>
<script type="text/javascript" src="html/js/angular.min.js"></script>
<script type="text/javascript" src="html/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="html/js/dataTables.bootstrap.min.js"></script>

<script type="text/javascript" src="html/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="html/js/buttons.flash.min.js"></script>
<script type="text/javascript" src="html/js/markerwithlabel.js"></script>

<script type="text/javascript" src="html/js/jspdf.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
<script type="text/javascript" src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js"></script>
<script 1type="text/javascript" src="https://cdn.datatables.net/buttons/1.2.4/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="html/js/icheck.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.2.4/js/buttons.colVis.min.js"></script>


<script>
var table;
var refreshOut;
	
function sformat(s) {
    var fm = [
          Math.floor(s / 60 / 60 / 24), // DAYS
          Math.floor(s / 60 / 60) % 24, // HOURS
          Math.floor(s / 60) % 60 // MINUTES
         // ,s % 60 // SECONDS
    ];
    return $.map(fm, function(v, i) { return ((v < 10) ? '0' : '') + v; }).join(':');
}	
	
	$(document).ready(function () {
		 $('#hdr_vehicle').addClass("dropdown active");
		 $('#hdr_vehicleLink').click();
			$('#hdr_vehicleView').addClass("active");
		
        
        var allVehicleLocationJSON=${allVehicleLocation};
       
  
        
    $('#entrydata').DataTable({
			dom: '<"top"flB>rt<"bottom"p><"clear">',
		  data:allVehicleLocationJSON,
           
             columns:[
                    
                     {data: "vehicleno"},
                    	
                     {data: "description"},
                     {data: "speed"},
                     {data: "location"},
                     {data: "datetime1"},
                     {data: "idletime",
                         "render": function (data,type,full,meta){
                            return sformat(data); 
                         }}
                    ],
            ordering:true,
			 lengthMenu: [[10, 25, 50, -1], [10, 25, 50, "All"]],
			buttons: [
{
    extend: 'colvis',
   text :'',
    columns: ':gt(1)'
},

{
    extend: 'excelHtml5',
    text :''
 },{
	    extend:'pdfHtml5',
	    text :''
	 }
],
select: {
    style: 'single'
}
		}); 
    
    
      
    
    
            
     // <!--Rohan code end 2 -->  
            
		if($("input[type='search']").length>0){
			$("input[type='search']").addClass("form-control");
		}
		if($("select[name='entrydata_length']").length>0){
			$("select[name='entrydata_length']").addClass("form-control");
		}
		$('.i-checks').iCheck({
                    checkboxClass: 'icheckbox_square-green',
                    radioClass: 'iradio_square-green',
                });
        });
     
	
	
	
	
</script>





	


</body>


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

</html>

