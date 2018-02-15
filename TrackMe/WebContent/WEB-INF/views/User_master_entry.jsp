<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>

<!-- Mirrored from kalkisoft.com/adhata/html/new-vehicle.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 30 Dec 2016 18:17:01 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>NST GPS</title>
    <link href="html/css/css.css" rel="stylesheet" type="text/css" />
    <link href="html/css/bootstrap.min.css" rel="stylesheet">

    <link href="html/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="html/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="html/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="html/css/animate.css" rel="stylesheet">
    <link href="html/css/style.css" rel="stylesheet">
    <link href="html/css/custom.css" rel="stylesheet">
</head>

<body class="top-navigation">
    <div id="wrapper">
    
       <jsp:directive.include file="header.jsp" />
    
      <div id="page-wrapper2" class="gray-bg">
            <div class="rowx wrapper border-bottom white-bg page-heading">
                <div class="col-sm-12">
                	<c:if test="${UserMaster.editFlag==true }">
                    <h2>User Modification </h2></c:if>
                    
                    <c:if test="${UserMaster.editFlag==false }">
                    <h2>User Entry </h2></c:if>
                </div>
            </div>
            <div class="wrapper wrapper-content  animated fadeInRight">
                <div class="ibox-content">
                 	<c:if test="${UserMaster.editFlag==true }">
                    <h3 class="m-t-none m-b">Existing User</h3>
                    </c:if>
                    
                    <c:if test="${UserMaster.editFlag==false }">
                    <h3 class="m-t-none m-b">Add New User</h3>
                    </c:if>
                    
                    <div class="row">
                        <form:form role="form" action="UserMasterSave" commandName="UserMaster" method="post"  onsubmit="return myFunction()">
                                <div class="form-group col-sm-6">
                                    <label>User Name</label>
                                    <form:hidden path="status" value="Active"/>
										
                                   	<c:if test="${UserMaster.editFlag==true }">
							             <form:input path="userName" type="text" disabled="true" id="primaryKey"  class="form-control editor-field"/>
                            			<form:hidden path="editFlag" value="${UserMaster.editFlag}"/>
										<form:hidden path="createdBy" value="${UserMaster.createdBy}"/>
										<form:hidden path="createdDateShow" value="${UserMaster.createdDateShow}"/>
						
							</c:if>
							<c:if test="${UserMaster.editFlag==false }">
							<form:input path="userName" type="text"  id="primaryKey" class="form-control editor-field"/>
                            			
							<form:hidden path="editFlag" value="${UserMaster.editFlag}"/>
							</c:if>
							
							
                                </div>
                           
                           
                           
                            <div class="form-group col-sm-6">
                                    <label>Role</label>
                                   <form:select class="form-control" required="true" path="roleMaster.id" items="${roles}" itemLabel="role" itemValue="id"></form:select>
                                </div>
                            
                                <div class="form-group col-sm-6">
                                    <label>Password</label>
                                    <form:input path="password" type="password" id="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" class="form-control editor-field"/>
                                </div>
                           
                           
                                <div class="form-group col-sm-6">
                                    <label>Confirm Password</label>
                                    <input type="password" onChange="myFunction()" name="repassword" id="repassword" value="${UserMaster.password}" class="form-control editor-field">
                               		<p id="repass" ></p>
                                </div>
                          
                            
                                <div class="form-group col-sm-6">
                                    <label>Company</label>
                                   <form:select class="form-control" required="true" path="companyMaster.id" items="${companyMasters}" itemLabel="companyName" itemValue="id"></form:select>
                                </div>
                            
                          
                               
                            
                            <div class="text-center">
                            <c:if test="${UserMaster.editFlag==false }">
                                <input type="submit" onclick=" return validate()" name="action" id="button" class="btn btn-primary" value="Save User">
                             </c:if>
                             <c:if test="${UserMaster.editFlag==true }">
                                <input type="submit" onclick=" return validate()" name="action" id="button" class="btn btn-primary" value="Update User">
                             
                             </c:if>
                                <input type="button" name="button3" id="button3" value="Exit" class="btn btn-danger" onclick="location.href = 'UserMasters'">
                           
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
           <jsp:directive.include file="footer.jsp" />

    </div>
    <script type="text/javascript" src="html/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="html/js/tether.min.js"></script>
    <script type="text/javascript" src="html/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="html/js/angular.min.js"></script>
    <script type="text/javascript" src="html/js/datatables.min.js"></script>
    <script type="text/javascript" src="html/js/buttons.flash.min.js"></script>
    <script type="text/javascript" src="html/js/jspdf.min.js"></script>
    <script>
        $(document).ready(function () {
        	$('#hdr_configuration').addClass("dropdown active");
       		$('#hdr_configuration_link').click();
       		$('#hdr_UserMasters').addClass("active");
            $('#entrydata').DataTable();
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
            
            $('#errorMessage').fadeOut(5000);
        });
    </script>
    <script>

        function myFunction() {
            var pass1 = document.getElementById("password").value;
            var pass2 = document.getElementById("repassword").value;
            var ok = true;
            if (pass1 != pass2) {
                document.getElementById("password").style.borderColor = "#E34234";
                document.getElementById("repassword").style.borderColor = "#E34234";
                ok = false;
                document.getElementById("repass").innerHTML = "<br/><font color='red'>Password do not matched </font>";
            }
            else {
            	 document.getElementById("password").style.borderColor = "#82e334";
                 document.getElementById("repassword").style.borderColor = "#82e334";
                
                document.getElementById("repass").innerHTML = "<br/><font color='green'>Password  matched </font>";
                
            }
            return ok;
        }
        
		function validate(){
			$('#primaryKey').prop('disabled', false);
			return true;
		}

    </script>
</body>

<!-- Mirrored from kalkisoft.com/adhata/html/new-vehicle.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 30 Dec 2016 18:17:01 GMT -->
</html>
