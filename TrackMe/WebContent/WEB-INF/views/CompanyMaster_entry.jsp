<!DOCTYPE html>
<html>

<!-- Mirrored from kalkisoft.com/adhata/html/new-vehicle.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 30 Dec 2016 18:17:01 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Company</title>
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
                   <c:if test="${CompanyMaster.editFlag==true }">
                    <h2>Company Modification </h2>
                    </c:if>
                       <c:if test="${CompanyMaster.editFlag==false }">
                      <h2>Company Entry </h2>
                       </c:if>
                </div>
            </div>
            <div class="wrapper wrapper-content  animated fadeInRight">
                <div class="ibox-content">
                    <div class="row">
                        <form:form action="AddOrUpdateCompanyMastersRecord" commandName="CompanyMaster" enctype="multipart/form-data">
<form:hidden path="status" value="Active"/>

                          
                            <div class="form-group col-sm-6">
                                                                           <label>Company Name</label>
                                          
                                       
									
                                          
                                            <c:if test="${CompanyMaster.editFlag==true }">
						            		
						            		   	<form:input type="text" class="form-control" required="true" path="companyName" readonly="true"></form:input>
									
						            		
						            		<form:hidden path="id"/>
									<form:hidden path="logoPath"/>
									
                                    	<form:hidden path="editFlag" value="${CompanyMaster.editFlag}"/>
											<form:hidden path="createdBy" value="${CompanyMaster.createdBy}"/>
								<form:hidden path="createdDateShow" value="${CompanyMaster.createdDateShow}"/>
						
							</c:if>
							<c:if test="${CompanyMaster.editFlag==false }">
							   	<form:input type="text" class="form-control" required="true" path="companyName"></form:input>
									
							 	   	<form:hidden path="editFlag" value="${CompanyMaster.editFlag}"/>
                                   
							</c:if>
                                            <div class="clearfix"></div>
                                            <br>
                            </div>
                            
                            
                            <div class="form-group col-sm-6">
                                    <label>Logo (*Width and height of Image Must be less than 50px):</label>
                                  <input class="form-control" type="file" accept="image/*" name="logo">
                                  
                                  <img alt="No Logo Preview" src="${CompanyMaster.logoPath}">
                                </div>
							
                           
                                       <div class="form-group col-sm-12 text-center">
                                  <c:if test="${CompanyMaster.editFlag==true }">
						            	
                                <input name="action" type="submit" class="btn btn-primary" id="button" value="Update Company">
                                </c:if>
                                 <c:if test="${CompanyMaster.editFlag==false }">
						            	
                                <input name="action" type="submit" class="btn btn-primary" id="button" value="Add Company">
                                </c:if>
                                <input name="button3" type="button" class="btn btn-danger" id="button3" onclick="location.href = 'CompanyMasters'" value="Exit">
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
		$('#hdr_CompanyMaster').addClass("active");
		
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
