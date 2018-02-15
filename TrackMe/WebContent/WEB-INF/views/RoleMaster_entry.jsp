<!DOCTYPE html>
<html>

<!-- Mirrored from kalkisoft.com/adhata/html/new-vehicle.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 30 Dec 2016 18:17:01 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Role</title>
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
                <c:if test="${RoleMaster.editFlag==true }">
                    <h2>Role Modification </h2>
                    </c:if>
                    <c:if test="${RoleMaster.editFlag==false }"> <h2>Role Entry </h2>
                    </c:if>
                </div>
            </div>
            <div class="wrapper wrapper-content  animated fadeInRight">
                <div class="ibox-content">
                    <div class="row">
                        <form:form action="AddOrUpdateRoleMastersRecord" commandName="RoleMaster" enctype="multipart/form-data">
<form:hidden path="status" value="Active"/>

                          
                            <div class="form-group col-sm-12 ">
                             <div class="form-group col-sm-6 ">
                                                                           <label>Role:</label>
                                                    <c:if  test="${RoleMaster.editFlag == true}">
                                                            	<form:input style="width:350px;" type="text" class="form-control"  required="true" path="role" readonly="true"></form:input>
									
                                                    </c:if>
                                                    <c:if test="${RoleMaster.editFlag==false }">
                                                            	<form:input type="text"  style="width:350px;" class="form-control" required="true" path="role"></form:input>
									
                                                    </c:if>         
                                          
                                  </div>
                                          
                                            <c:if test="${RoleMaster.editFlag==true }">
						            		<form:hidden path="id"/>
									
                                    	<form:hidden path="editFlag" value="${RoleMaster.editFlag}"/>
											<form:hidden path="createdBy" value="${RoleMaster.createdBy}"/>
								<form:hidden path="createdDateShow" value="${RoleMaster.createdDateShow}"/>
						
							</c:if>
							<c:if test="${RoleMaster.editFlag==false }">
							 	   	<form:hidden path="editFlag" value="${RoleMaster.editFlag}" />
                                   
							</c:if>
                                            <div class="clearfix"></div>
                                            <br>
                            </div>
                             
                            <c:forEach items="${links}" var="link" varStatus="forStatus">
                           
                              <div class="form-group col-sm-3">
                                <div class="clearfix"></div>
                                <label for="checkbox" style="width:150px;" class="checkbox-inline">${link.name} </label>
                                <form:checkbox class="i-checks" path="linksId" value="${link.id}" style="text-align: center; vertical-align: middle;"/>
                               </div>
                  
                            </c:forEach>
                         
                           
                                       <div class="form-group col-sm-12 text-center">
                                  <c:if test="${RoleMaster.editFlag==true }">
						            	
                                <input name="action" type="submit" class="btn btn-primary" id="button" value="Update Role">
                                </c:if>
                                 <c:if test="${RoleMaster.editFlag==false }">
						            	
                                <input name="action" type="submit" class="btn btn-primary" id="button" value="Add Role">
                                </c:if>
                                <input name="button3" type="button" class="btn btn-danger" id="button3" onclick="location.href = 'RoleMasters'" value="Exit">
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
		$('#hdr_RoleMasters').addClass("active");
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
