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
                    <h2>Route Master Entry </h2>
                </div>
            </div>
            <div class="wrapper wrapper-content  animated fadeInRight"></div>
            <div class="ibox-content">
                <h3 class="m-t-none m-b">Add New Route </h3>
                <div class="row">
               <form:form action="AddOrUpdateRouteRecord" commandName ="routeMaster" >
			        <div class="row">
                            <div style="padding-left: 3%" class="form-group col-sm-4">
                                <label for="textfield">Route Name : </label>
                                
                                  <c:if test="${routeMaster.editFlag==true }">
							
                                    <form:input required="true" type="text"  path="routeName" disabled="true" id="primaryKey" class="form-control" />
                                    	<form:hidden path="editFlag" value="${routeMaster.editFlag}"/>
											<form:hidden path="createdBy" value="${routeMaster.createdBy}"/>
								<form:hidden path="createdDateShow" value="${routeMaster.createdDateShow}"/>
						
							</c:if>
							<c:if test="${routeMaster.editFlag==false }">
							 	  <form:input type="text" required="true" placeholder="Route Name" path="routeName"  id="primaryKey" class="form-control" />
                                  
							 <form:hidden path="editFlag" value="${routeMaster.editFlag}"/>
							</c:if>
                                
                            </div>

                        </div>

                        <div class="ibox-content">
                            <h3 class="m-t-none m-b">Assigned Location </h3>
                            <div class="row">
                                <div class="form-group col-sm-4">
                                    <label for="Location">Location : </label>
                                  
   
                                  
                                    <select name="location" id="location" class="form-control">
                                    <c:forEach var="location" items="${locations}">
                                     <option value="${location.locationName }">${location.locationName }</option>
                                    </c:forEach>
                                       
                                    </select>
                                </div>
                                <div class="form-group col-sm-4">
                                       <c:if test="${routeMaster.editFlag==true }">
										<c:forEach var="locatn" items="${routeMaster.locationsForRoute}">
									 <input type="hidden" name="locationsOfRoute" id="locationsOfRoute" value="${locatn.location.locationName }" />
	</c:forEach>
									</c:if>
                                    <input name="addlocation" type="button" class="btn  btn-primary" onclick="addLocation()" id="addlocation" value="Add Location" />
                                    <input type="hidden" name="rows" id="rows" />

                                </div>
                            </div>
                            <div class="table-responsive" style="width: 50%; border: 1px solid">
                                <table width="50%" border="1" cellpadding="0" cellspacing="0" id="entrydata" class="table table-striped table-bordered new-tbl">
                                    <tbody>
                                        <tr>
                                            <th width="20%" align="right" bgcolor="#CCC4C4">Sl no</th>
                                            <th width="50%" align="right" bgcolor="#CCC4C4">Location</th>
                                            <th width="30%" align="right" bgcolor="#CCC4C4">Action</th>
                                        </tr>
                                    </tbody>
                                </table>

                            </div>
                            <br />
                            <div style="text-align: center">
                               <c:if test="${routeMaster.editFlag==true }">
							
                                <input name="action" type="submit" onclick=" return validate()" class="btn  btn-primary" id="Submit1" value="Update Route" />
                            </c:if>
                             <c:if test="${routeMaster.editFlag==false }">
							     <input name="action" type="submit"  class="btn  btn-primary" id="Submit1" value="Add Route" />
                           </c:if>
                            
                                <input name="button3" type="button" class="btn btn-danger" onclick="location.href = 'ViewRouteDetails'" id="button3" value="Exit" />
                            </div>
                        </div>
                  </form:form>
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
 		$('#hdr_vehicleRoute').addClass("active");
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
		
		

		    $(document).ready(function () {
		    
		    	var prev_locations = document.getElementsByName("locationsOfRoute");
		    	for(var i=0;i< prev_locations.length;i++){
		        var location = prev_locations[i];
	            var table = document.getElementById("entrydata");
	            var rowCount = document.getElementById('entrydata').rows.length;
	            row = table.insertRow(rowCount);
	            row.className = "leftMenu";
	            cell = row.insertCell(0);
	            cell.innerHTML = rowCount;
	            cell = row.insertCell(1);
	            var input = document.createElement('input');
	            input.type = "input";
	            input.value = location.value;
	            input.id = "route" + rowCount;
	            input.name = "locations";
	            input.className = "form-control";

	            input.readOnly = true;
	            cell.appendChild(input);

	            cell = row.insertCell(2);
	            var btn = document.createElement('input');
	            btn.type = "button";
	            btn.className = "btn btn-primary";
	            btn.value = "Delete";
	            btn.onclick = (
	                function () {
	                    this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);
	                    var rows = document.getElementById("rows");
	                    rows.value = document.getElementById("rows").value - 1;
	                }
	            );
	            cell.appendChild(btn);

	            var rows = document.getElementById("rows");
	            rows.value = rowCount;
			}
		    });

        function addLocation() {
            var location = document.getElementById("location");
            var table = document.getElementById("entrydata");
            var rowCount = document.getElementById('entrydata').rows.length;
            row = table.insertRow(rowCount);
            row.className = "leftMenu";
            cell = row.insertCell(0);
            cell.innerHTML = rowCount;
            cell = row.insertCell(1);
            var input = document.createElement('input');
            input.type = "input";
            input.value = location.value;
            input.id = "route" + rowCount;
            input.name = "locations";
            input.className = "form-control";

            input.readOnly = true;
            cell.appendChild(input);

            cell = row.insertCell(2);
            var btn = document.createElement('input');
            btn.type = "button";
            btn.className = "btn btn-primary";
            btn.value = "Delete";
            btn.onclick = (
                function () {
                    this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);
                    var rows = document.getElementById("rows");
                    rows.value = document.getElementById("rows").value - 1;
                }
            );
            cell.appendChild(btn);

            var rows = document.getElementById("rows");
            rows.value = rowCount;
        }

    </script>
</body>
</html>































<!--
<body onload="getLocations()">
    <form action="http://166.62.56.246:8080/TrackMeWeb/TrackMeServlet" method="post">
        <table width="452" height="290" border="1" cellpadding="0" cellspacing="0" class="entrydata">
            <tbody>
                <tr>
                    <th width="446" height="23" align="left" valign="middle" bgcolor="#CCCCCC" style="font-family: Helvetica, Arial, sans-serif; font-weight: bold; font-style: inherit; font-size: 12px;">Route Creation </th>
                </tr>
                <tr>
                    <th height="87" align="left" valign="baseline" bgcolor="#FFFFFF" style="vertical-align: middle;">
                        <p>
                            <label for="textfield">Route Name : </label>
                            <input type="text" name="routename" id="routename">
                        </p>
                        <p>
                            <label for="Location">Location : </label>
                            <select name="location" id="location">
                                <option value=""></option>
                            </select>
                            <input name="addlocation" type="button" class="button" onclick="addLocation()" id="addlocation" value="Add Location">
                            <input type="hidden" name="rows" id="rows" />
                        </p>
                    </th>
                </tr>
                <tr>
                    <td width="446" height="18" align="left" valign="top" bgcolor="#CCCCCC" style="font-weight: bold; font-style: inherit;">Assigned Location</td>
                </tr>
                <tr>
                    <td valign="top">
                        <table width="449" border="1" cellpadding="0" cellspacing="0" class="entrydata" id="entrydata">
                            <tbody>
                                <tr>
                                    <th width="20%" bgcolor="#CCC4C4">Sl no</th>
                                    <th width="80%" bgcolor="#CCC4C4">Location</th>
                                </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td height="31" align="center" valign="middle" bgcolor="#999999">
                        <input name="action" type="submit" class="button" id="button" value="Add Route">
                        <input name="button3" type="submit" class="button" onclick="location.href = 'alert_master_view.html'" id="button3" value="Close">
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</body>-->
</html>
