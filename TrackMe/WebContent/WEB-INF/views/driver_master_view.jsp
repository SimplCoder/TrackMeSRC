<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
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
</head>
<body class="top-navigation" onload="loadData()">
     <jsp:directive.include file="header.jsp" />
        <div id="page-wrapper2" class="gray-bg">
            <div class="rowx wrapper border-bottom white-bg page-heading">
                <div class="col-sm-6">
                    <h2>Driver Detials</h2>
                </div>
                <div class="col-sm-6">
                    <div class="text-right">
                        <a href="AddDriverMastersView" class="btn btn-primary">Add Driver</a>
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
										
							
                                            <div id="editDriver">

                                                <div class="table-responsive">

                                                   <table width="100%" id="entrydata" class="entrydata table table-striped table-bordered new-tbl">
                                                        <thead>
                                                            <tr class="leftMenu">
                                                                <th ></th>
																   <th ></th>
                                                                <th>Driver Name</th>
                                                                <th>Address</th>
                                                                <th>Phone</th>
                                                                <th>Lic. Expiry Date</th>
                                                                <th>Issued RTO</th>
                                                                <th>Blood Group</th>
                                                                <th>Created By</th>
                                                                <th>Created Date</th>
                                                                <th>Modify By</th>
                                                                <th>Modify Date</th>
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


            </div>
           <jsp:directive.include file="footer.jsp" />
        </div>
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
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.2.4/js/buttons.colVis.min.js"></script>

<script>
  var driverMasterJSON = ${DriverMasterJSON};
      $(document).ready(function () {
    	  
    	  $('#hdr_configuration').addClass("dropdown active");
    		$('#hdr_configuration_link').click();
    		$('#hdr_DriverMasters').addClass("active");
    		$('#successMessage').fadeOut(5000);
    		$('#errorMessage').fadeOut(5000);

          $('#entrydata').DataTable({
        	  dom: '<"top"lBf>rt<"bottom"p><"clear">',
          	data:driverMasterJSON,
              columns:[
                       {data: "id",
                    	 "render": function ( data, type, full, meta ) {
                    	      return '<a title="Edit" href="EditDriverMastersView?id='+data+'"><i class="fa fa-pencil-square-o iconedit"  aria-hidden="true"></i></a>';}
                    	 },
                     {data: "id",
                        	 "render": function ( data, type, full, meta ) {
                       	      return '<a title="Delete" href="RemoveDriverMastersRecord?id='+data+'"><i class="fa fa-trash  icondelete" aria-hidden="true"></i></a>';}           	
                    		 
                     },
                       {data: "driverName"},
                       {data: "address"},
                       {data: "contact1"},
                       {data: "formatedExpireDate"},
                       {data: "rtoName"},
                       {data: "bloodGroup"},
                       {data: "createdBy"},
                       {data: "formatedCreatedDate"},
                       {data: "modifiedBy"},  
                       {data: "formatedModifiedDate"},
                                          
                   ],
          	
  			ordering:false,
  			 lengthMenu: [[10, 25, 50, -1], [10, 25, 50, "All"]],
				buttons: [
	{
	    extend: 'colvis',
	    text:'',
	    titleAttr :'Column Selection',
	    columns: ':gt(2)'
	},

	{
	    extend: 'excelHtml5',
	    text:'',
	    titleAttr :'Excel Export'
	 },{
		    extend:'pdfHtml5',
		    text:'',
		    titleAttr :'Pdf Export'
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
</html>
