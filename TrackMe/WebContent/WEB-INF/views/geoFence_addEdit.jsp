<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>GroFence Service</title>
    <link href="html/css/css.css" rel="stylesheet" type="text/css" />
    <link href="html/css/bootstrap.min.css" rel="stylesheet">

    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="html/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="html/css/animate.css" rel="stylesheet">
    <link href="html/css/style.css" rel="stylesheet">
    <link href="html/css/custom.css" rel="stylesheet">
    <link href="html/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="html/css/buttons.dataTables.min.css" rel="stylesheet">

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

</head>

<body class="top-navigation">
    <jsp:directive.include file="header.jsp" />
    <div id="page-wrapper2" class="gray-bg" style="top:128px !important">
        <div class="rowx wrapper border-bottom white-bg page-heading">
            <div class="col-sm-12">
                <h2>Add GeoFence</h2>


            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="wrapper wrapper-content fadeInUp pad-bot-0">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="ibox float-e-margins pad-bot-0" style="background:#fff;">
                                <div class="row">
                                    <div id="same-height" class="col-md-6 md-pad-left" style="padding-right:0;">

                                        <form:form action="addOrUpdateGeoFenceDetail.html" commandName="GeoFenceDetail">
                                            <div class="form-group col-sm-12">
                                                <!-- <input id="geocomplete" type="text" placeholder="Type in an address" size="90" /> -->
                                                <label>GeoFence Zone:</label>
                                                <form:input required="true" path="location" type="text" id="geocomplete" placeholder="Type in an address" class="form-control"></form:input>
                                            </div>
                                            <div class="form-group col-sm-12">
                                                <label>GeoFence Name:</label>
                                                <form:input required="true" path="geoFenceName" type="text" id="geoFenceNameId" class="form-control"></form:input>
                                                <form:hidden path="latitude" id="latId"  />
                                                <form:hidden path="longitude" id="lngId"  />
                                                <form:hidden path="radius" id="radiusId"  />
                                                <form:hidden path="id" id="geoFenceId" />
                                            </div>
                                             <div class="form-group col-sm-12"  id="infoDiv" style="visibility: hidden; display:inline;">
                                                <label >Radius:</label>
                                               <span id="displayInfo" style="font-size:14px"></span><span style="font-size:12px" id="unit">&nbsp;K.M.</span>
                                            </div>
                                            
                                            
                                             <div class="rowx wrapper white-bg">
                                <div class="row">
                                    <div class="form-group col-sm-4">
                                        <label for="txtvehicle">Vehicle No </label>
                                      
                                    <select name="vehicle" id="vehicle" class="form-control">
                                    <c:forEach var="vehicle" items="${vehicles}">
                                     <option value="${vehicle.vehicleNo }">${vehicle.vehicleNo }</option>
                                    </c:forEach>
                                       
                                    </select>
                                      
                                    </div>
                                    <div class="form-group col-sm-4">
                                    
                                    
                                        <input name="buttaddvehicle" type="button" onclick="addVehicle()" class="btn btn-primary" id="buttaddvehicle" value="Add Vehicle" />
                                        <input type="hidden" name="rows" id="rows" />
                                    </div>
                                </div>
                            </div>
                            
                            <div class="rowx wrapper white-bg">
                                <div class="table-responsive" style="width: 50%; border: 1px solid;">
                                    <table width="50%" border="1" cellpadding="0" cellspacing="0" id="entrydata" class="table table-striped table-bordered new-tbl">
                                        <tbody>
                                            <tr>
                                                <th width="20%" align="center" bgcolor="#CCC4C4">Sl no</th>
                                                <th width="50%" align="center" bgcolor="#CCC4C4">Vehicle</th>
                                                <th width="30%" align="center" bgcolor="#CCC4C4">Action</th>
                                            </tr> 
                                             
                                             <c:if test="${isEdit=='1' }">
										
										<c:forEach var="vehicleVal" items="${GeoFenceDetail.vehicles}" varStatus="i">
									
	<tr class="leftMenu">
	<td>${i.index+1}</td>
	<td><input type="input" id="vehicles${i.index+1}" value="${vehicleVal}" name="vehicleShow" class="form-control" readonly=""></td>
	<td><input type="button" class="btn btn-primary deleterow" value="Delete">
	
	</c:forEach>
									</c:if>
                                            
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            
                            
                                            <div class="form-group col-sm-12">
                                                
                                                    <input type="submit" class="btn  btn-primary"  name="action" value="Save GeoFence" />
                                                	 <input type="button" class="btn  btn-danger" id="Exit" onclick="window.location.href='listGeoFenceDetails.html';" value="Close" />
                                                <!--<c:if test='true'>
                                                    <input type="submit" class="btn  btn-primary"  name="action" value="Update GeoFence">

                                                </c:if> -->
                                              
                                            </div>
                                        </form:form>
                                    </div>
                                     <c:if test="${not empty GeoFenceJSON}">
                                       
                                         <script>
                                          var geoFenceJSON = ${GeoFenceJSON};
                                        </script>
                                    </c:if>
                                     <c:if test="${empty GeoFenceJSON}">
                                         <script>
                                          var geoFenceJSON = null;
                                        </script>
                                    </c:if>
                                   
                                    <div id="same-height2" class="col-md-6 md-pad-right" style=" width:50%;height:80%;padding-left:0;">

                                        <div id="maptoggle" class="ibox-content">
                                            <div id="map" style="width:100%;height:400px"></div>
                                            <!-- <div id="info"></div>  -->

                                            <!--       <script async src="https://maps.googleapis.com/maps/api/js?libraries=geometry,places&key=AIzaSyCeQdAwrHm8Zap7jwX_gNRA3dhH-CxdCWQ&callback=initialize&ext=.js"></script>  -->

                                            <script async src="https://maps.googleapis.com/maps/api/js?libraries=geometry,places&key=AIzaSyCeQdAwrHm8Zap7jwX_gNRA3dhH-CxdCWQ&ext=.js"></script>

                                            <!--Rohan code start 3 -->
                                            <script>
                                                //  function initialize() {
                                                /*   function initMap() {
                                                        var uluru = {lat: 18.5679, lng: 73.9143};
                                                        var map = new google.maps.Map(document.getElementById('map'), {
                                                          zoom: 9,
                                                          center: uluru,
                                                          mapTypeId:google.maps.MapTypeId.ROADMAP

                                                        });
                                                        var marker = new google.maps.Marker({
                                                          position: uluru,
                                                          map: map
                                                        });
                                                      } */
                                                
                                                function geoFencyResizing() {
                                                    
                                                    function mapMarkerPlotingFunctionality(geoLat,geoLng,radius){
                                                        var tempRadius;
                                                        if(radius!=null&&radius!=''){
                                                            tempRadius=radius;
                                                        }else{
                                                            tempRadius=5;
                                                        }
                                                        map_options = {
                                                                center: new google.maps.LatLng(geoLat, geoLng),
                                                                zoom: 10,
                                                                customRadius:tempRadius,
                                                                mapTypeId: google.maps.MapTypeId.ROADMAP
                                                            };
                                                            var map = new google.maps.Map(map_canvas, map_options);

                                                            var distanceWidget = new DistanceWidget(map);
                                                        
                                                            displayInfo(distanceWidget);

                                                            google.maps.event.addListener(distanceWidget, 'distance_changed', function() {
                                                                displayInfo(distanceWidget);
                                                            });

                                                            google.maps.event.addListener(distanceWidget, 'position_changed', function() {
                                                                displayInfo(distanceWidget);
                                                            });
                                                    }
                                                    //geoFence Resizing START
                                                    /**
                                                     * A distance widget that will display a circle that can be resized and will
                                                     * provide the radius in km.
                                                     *
                                                     * @param {google.maps.Map} map The map to attach to.
                                                     *
                                                     * @constructor
                                                     */
                                                    function DistanceWidget(map) {
                                                        this.set('map', map);
                                                        this.set('position', map.getCenter());

                                                        var marker = new google.maps.Marker({
                                                            draggable: true,
                                                            title: 'Move me!'
                                                        });

                                                        // Bind the marker map property to the DistanceWidget map property
                                                        marker.bindTo('map', this);

                                                        // Bind the marker position property to the DistanceWidget position
                                                        // property
                                                        marker.bindTo('position', this);

                                                        // Create a new radius widget
                                                        var radiusWidget = new RadiusWidget(map.customRadius);

                                                        // Bind the radiusWidget map to the DistanceWidget map
                                                        radiusWidget.bindTo('map', this);

                                                        // Bind the radiusWidget center to the DistanceWidget position
                                                        radiusWidget.bindTo('center', this, 'position');

                                                        // Bind to the radiusWidgets' distance property
                                                        this.bindTo('distance', radiusWidget);

                                                        // Bind to the radiusWidgets' bounds property
                                                        this.bindTo('bounds', radiusWidget);
                                                    }
                                                    DistanceWidget.prototype = new google.maps.MVCObject();


                                                    /**
                                                     * A radius widget that add a circle to a map and centers on a marker.
                                                     *
                                                     * @constructor
                                                     */
                                                    function RadiusWidget(radius) {
                                                        var circle = new google.maps.Circle({
                                                            strokeWeight: 2
                                                        });

                                                        // Set the distance property value, default to 10km.
                                                        this.set('distance', radius);

                                                        // Bind the RadiusWidget bounds property to the circle bounds property.
                                                        this.bindTo('bounds', circle);

                                                        // Bind the circle center to the RadiusWidget center property
                                                        circle.bindTo('center', this);

                                                        // Bind the circle map to the RadiusWidget map
                                                        circle.bindTo('map', this);

                                                        // Bind the circle radius property to the RadiusWidget radius property
                                                        circle.bindTo('radius', this);
																
                                                        // Add the sizer marker
                                                        this.addSizer_();
                                                    }
                                                    RadiusWidget.prototype = new google.maps.MVCObject();


                                                    /**
                                                     * Update the radius when the distance has changed.
                                                     */
                                                    RadiusWidget.prototype.distance_changed = function() {
                                                        this.set('radius', this.get('distance') * 1000);
                                                    };


                                                    /**
                                                     * Add the sizer marker to the map.
                                                     *
                                                     * @private
                                                     */
                                                    RadiusWidget.prototype.addSizer_ = function() {
                                                        var sizer = new google.maps.Marker({
                                                            draggable: true,
                                                            title: 'Drag me!'
                                                        });

                                                        sizer.bindTo('map', this);
                                                        sizer.bindTo('position', this, 'sizer_position');

                                                        var me = this;
                                                        google.maps.event.addListener(sizer, 'drag', function() {
                                                            // As the sizer is being dragged, its position changes.  Because the
                                                            // RadiusWidget's sizer_position is bound to the sizer's position, it will
                                                            // change as well.
                                                            var min = 0.01;
                                                            var max = 15;
                                                            var pos = me.get('sizer_position');
                                                            var center = me.get('center');
                                                            var distance = google.maps.geometry.spherical.computeDistanceBetween(center, pos) / 1000;
                                                            if (distance < min) {
                                                                me.set('sizer_position', google.maps.geometry.spherical.computeOffset(center, min * 1000, google.maps.geometry.spherical.computeHeading(center, pos)));
                                                            } else if (distance > max) {
                                                                me.set('sizer_position', google.maps.geometry.spherical.computeOffset(center, max * 1000, google.maps.geometry.spherical.computeHeading(center, pos)));
                                                            }
                                                            // Set the circle distance (radius)
                                                            me.setDistance();
                                                        });
                                                    };


                                                    /**
                                                     * Update the center of the circle and position the sizer back on the line.
                                                     *
                                                     * Position is bound to the DistanceWidget so this is expected to change when
                                                     * the position of the distance widget is changed.
                                                     */
                                                    RadiusWidget.prototype.center_changed = function() {
                                                        var bounds = this.get('bounds');

                                                        // Bounds might not always be set so check that it exists first.
                                                        if (bounds) {
                                                            var lng = bounds.getNorthEast().lng();

                                                            // Put the sizer at center, right on the circle.
                                                            var position = new google.maps.LatLng(this.get('center').lat(), lng);
                                                            this.set('sizer_position', position);
                                                        }
                                                    };


                                                    /**
                                                     * Set the distance of the circle based on the position of the sizer.
                                                     */
                                                    RadiusWidget.prototype.setDistance = function() {
                                                        // As the sizer is being dragged, its position changes.  Because the
                                                        // RadiusWidget's sizer_position is bound to the sizer's position, it will
                                                        // change as well.
                                                        var pos = this.get('sizer_position');
                                                        var center = this.get('center');
                                                        var distance = google.maps.geometry.spherical.computeDistanceBetween(center, pos) / 1000;

                                                        // Set the distance property for any objects that are bound to it
                                                        this.set('distance', distance);
                                                    };
                                                    //geoFence Resizng END



                                                    var MY_MAPTYPE_ID = 'custom_style';

                                                    //function initialize() {
                                                    var map_options;
                                                    var map_canvas = document.getElementById('map');
                                                    // Create the map.
                                                    /*   var map_canvas = document.getElementById('map');
                                                       var map_options = {
                                                           center: new google.maps.LatLng(16.8524, 74.5815),
                                                           zoom: 10,
                                                           mapTypeId: google.maps.MapTypeId.ROADMAP
                                                       };
                                                       var map = new google.maps.Map(map_canvas, map_options); */

                                                    // Construct the circle for each value in citymap.
                                                    // Note: We scale the area of the circle based on the population.

                                                    //GeoPlaces Start

                                                    var options = {
                                                        map: map
                                                    };

                                                    var geoLocationLat;
                                                    var geoLocationLng;

                                                    $("#geocomplete").geocomplete(options)
                                                        .bind("geocode:result", function(event, result) {
                                                            geoLocationLat = result.geometry.location.lat();
                                                            geoLocationLng = result.geometry.location.lng();

                                                            /*
                                                            var cityCircle = new google.maps.Circle({
                                                                strokeColor: '#FF0000',
                                                                strokeOpacity: 0.8,
                                                                strokeWeight: 2,
                                                                fillColor: '#FF0000',
                                                                fillOpacity: 0.35,
                                                                map: map,
                                                                center: new google.maps.LatLng(geoLocationLat, geoLocationLng),
                                                                radius: 1000
                                                            });*/
                                                            mapMarkerPlotingFunctionality(geoLocationLat,geoLocationLng,null);
                                                        })
                                                        .bind("geocode:error", function(event, status) {})
                                                        .bind("geocode:multiple", function(event, results) {});
                                                    //GeoPlaces End

                                                    // Add the circle for this city to the map.



                                                    /*    var point = new google.maps.LatLng(16.8524,
                                                            74.5815);
                                                        var map_canvas = document.getElementById('map');
                                                        var map_options = {
                                                            center: new google.maps.LatLng(16.8524, 74.5815),
                                                            zoom: 10,
                                                            mapTypeId: google.maps.MapTypeId.ROADMAP
                                                        };
                                                        map = new google.maps.Map(map_canvas, map_options) */

                                                    /*     new google.maps.Marker({
                                                          position: point,
                                                          map: map
                                                       }); */
                                                    // } inner initialize END
                                                    if(geoFenceJSON!=null){
                                                        if(geoFenceJSON.latitude!=null&&geoFenceJSON.longitude!=null){
                                                            mapMarkerPlotingFunctionality(geoFenceJSON.latitude,geoFenceJSON.longitude,geoFenceJSON.radius);
                                                        }else{
                                                            console.error("latLng details are not found.")
                                                        }
                                                    }else{
                                                        map_options = {
                                                                center: new google.maps.LatLng(16.8524, 74.5815),
                                                                zoom: 10,
                                                                mapTypeId: google.maps.MapTypeId.ROADMAP
                                                            };
                                                            var map = new google.maps.Map(map_canvas, map_options);
                                                    }
                                                }
                                                //google.maps.event.addDomListener(window, 'load', initialize);
                                                // } outer initialize END

                                                function displayInfo(widget) {
                                                    $('#latId').val(widget.get('position').lat());
                                                    $('#lngId').val(widget.get('position').lng());
                                                    $('#radiusId').val(widget.get('distance'));
                                                    $('#infoDiv').css('visibility', 'visible');
                                                    $('#displayInfo').text(widget.get('distance').toFixed(2));
                                                    
                                                   // info.innerHTML = 'Position: ' + widget.get('position') + ', distance: ' +
                                                   //     widget.get('distance');
                                                   
                                                   
                                                }

                                                window.addEventListener('load', function() {
                                                    if (document.getElementById('map')) {
                                                        geoFencyResizing();
                                                        //initialize();
                                                    }
                                                });

                                            </script>
                                            <!--Rohan code end 3 -->
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

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script type="text/javascript" src="html/js/jquery.geocomplete.js"></script>
    <!-- Mainly scripts -->

    </body>
    <script>
    function addVehicle() {
        var location = document.getElementById("vehicle");
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
        input.id = "vehicles" + rowCount;
        input.name = "vehicleShow";
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
    
    $('.deleterow').click(function () {
        this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);
        var rows = document.getElementById("rows");
        rows.value = document.getElementById("rows").value - 1;
	 });
    
    
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

    
    </script>
</html>
