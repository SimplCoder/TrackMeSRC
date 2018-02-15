<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home</title>
    <link href="html/css/css.css" rel="stylesheet" type="text/css" />
    <link href="html/css/bootstrap.min.css" rel="stylesheet">

    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="html/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="html/css/animate.css" rel="stylesheet">
    <link href="html/css/style1.css" rel="stylesheet">
    <link href="html/css/custom1.css" rel="stylesheet">
    <link href="html/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="html/css/buttons.dataTables.min.css" rel="stylesheet">
    <link href="https://cdn.datatables.net/select/1.2.1/css/select.dataTables.min.css" rel="stylesheet">
	<link href="html/css/jquery-ui.min.css" rel="stylesheet">
	
	
    
   <!-- <link href="html/css/jquery.mobile-1.4.5.css" rel="stylesheet"> -->
     
    <style>
.no-js #loader { display: none;  }
.js #loader { display: block; position: absolute; left: 100px; top: 0; }
.se-pre-con {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	background: url(html/images/loader4.gif) center no-repeat #fff;
}

a.dt-button.linkButton.closeMap {
    background-color: #68A229;
    font-weight: bolder;
    height: 20px;
    margin-bottom: 4px;
}
</style>

</head>

<body class="top-navigation">
    <div class="se-pre-con"></div>
    <jsp:directive.include file="header.jsp" />
    <div id="page-wrapper2" class="gray-bg">
        <div class="row">
            <div class="col-lg-12">
                <div class="wrapper wrapper-content fadeInUp pad-bot-0">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="ibox float-e-margins pad-bot-0" style="background:#fff;">
                                <div class="row wrap">
                                    <div id="same-height" class="resizable1 resizable col-md-6 md-pad-left">

                                        <div id="gridtoggle" class="ibox-content pad-bot-0">
                                            <div class="table-responsive">
                                                <!--Rohan code start 1 -->
                                                <table id="entrydata" class="table table-striped table-bordered new-tbl">
                                                    <thead>
                                                        <tr class="leftMenu">

                                                            <th width="16%" align="center" valign="middle">Vehicle No</th>
                                                           <th width="15%" align="center" valign="middle">Date/Time</th>
                                                            
                                                            <th width="14%" align="center" valign="middle">Status</th>
                                                            <th width="42%" align="center" valign="middle">Location</th>
                                                            
                                                             <th width="4%" align="center" valign="middle">Speed</th>
                                                            <th width="4%" align="center" valign="middle">Dist</th>                     
                                                            <th width="14%" align="center" valign="middle">AC</th>
                                                         
                                                            <th width="4%" align="center" title="(dd:hh:mm)" valign="middle">Idle Time</th>

                                                        </tr>
                                                    </thead>

                                                </table>
                                                <input type="hidden" id="tempVehicleNo">
                                                <!--Rohan code end 1 -->
                                            </div>
                                        </div>
                                    </div>
                                    <div id="same-height2" class="resizable2 resizable col-md-6 md-pad-right">
                                        <div class="ibox-title">
                                            <div class="map-btns">
                                                <ul class="subnav-right az-move-right">
                                                    <li class="map-actions"><a href="#myPopup" id="vehicleSearchFilterId" data-rel="popup" class="">&nbsp;</a>


                                                        <div data-role="popup" id="myPopup" title="Vehicle Search" class="ui-content" style="min-width:250px; position:relative">
                                                            <form:form class="form-inline" action="#" commandName="VehicleSearchForm">
                                                                <div>
                                                                   <!-- <h3>Vehicle Search</h3>  -->
                                                                    <div>
                                                                    <label class="ui-accessible"><h4>Location:</h4></label>
                                                                    </div>
                                                                    <div class="form-group">
                                                                    <form:input autocomplete="off" type="text" id="geocomplete" path="area" 
                                                                    class="form-control" size="30"></form:input>
                                                                    </div>
                                                                    <br/>
                                                                    <div class="form-group">
                                                                    <label for="distanceId" class="ui-accessible"><h4>Distance(KM):</h4></label>
                                                                    </div>
                                                                    <div class="form-group">
                                                                    <form:input autocomplete="off" type="text" id="distanceId" path="distance" 
                                                                    class="form-control" placeholder="Distance" maxlength="5" size="30"></form:input>
                                                                    </div>
                                                                    <form:hidden path="lat"/>
                                                                    <form:hidden path="lng"/>
                                                                    <input type="hidden" id="isSearchedId" value="false">
                                                                </div>
                                                            </form:form>
                                                        </div>
                                                    </li>
                                                    &nbsp;&nbsp;
                                                    <!--  <li class="map-vehicles"><a href="#" class="">&nbsp;</a> </li>-->
                                                    <!-- <li class="map-landmarks"><a href="#">&nbsp;</a></li>-->
                                                    <li class="map-layout-toggle1">
                                                        <a class="map-layout-togglea1 active" title="Vertical Split View" href="javascript:void(0)" onclick="reSize('side')"></a>
                                                    </li>
                                                    <li class="map-layout-toggle2">
                                                        <a href="javascript:void(0)" class="map-layout-togglea2" title="Horizontal Split View" onclick="reSize('wide')"></a>
                                                    </li>
                                                    <!-- <li class="map-icon-medium"><a class="active" href="#">&nbsp;</a></li>-->
                                                    <!-- <li class="map-icon-large"><a href="#" class="">&nbsp;</a></li>-->
                                                    <!-- <li class="map-fullscreen"><a href="#">&nbsp;</a></li>-->
                                                </ul>
                                            </div>
                                        </div>
                                        <div id="maptoggle" class="ibox-content">
                                            <div id="map" style="width:100%;height:480px"></div>
                                            <script src="https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyCeQdAwrHm8Zap7jwX_gNRA3dhH-CxdCWQ&ext=.js"></script>

                                            <!--Rohan code start 3 -->
                                            <script>
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
                                                        });form-inline
                                                      } */

                                                var MY_MAPTYPE_ID = 'custom_style';

                                                function initialize() {

                                                    var point = new google.maps.LatLng(16.8524,
                                                        74.5815);
                                                    var map_canvas = document.getElementById('map');
                                                    var map_options = {
                                                        center: new google.maps.LatLng(16.8524, 74.5815),
                                                        zoom: 10,
                                                        mapTypeId: google.maps.MapTypeId.ROADMAP
                                                    };
                                                    map = new google.maps.Map(map_canvas, map_options)

                                                    /*     new google.maps.Marker({
                                                          position: point,
                                                          map: map
                                                       }); */
                                                }

                                                initialize();
                                                //google.maps.event.addDomListener(window, 'load', initialize);
                                                
                                                 window.addEventListener('load',function(){
                                                      if(document.getElementById('map')){
                                                        //initialize();
                                                        //   drawTable(null);
                                                          table.ajax.reload();
                                                      }
                                                     if($('.pac-container')){
                                                         $('.pac-container.pac-logo').css({'z-index':'10000'});
                                                     }
                                                     $('a').prop('rel', 'external');
                                                     $("#vehicleSearchFilterId").removeProp('rel');
                                                     $(".se-pre-con").fadeOut("slow");
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


    <!-- Mainly scripts -->
    <script type="text/javascript" src="html/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="html/js/jquery.geocomplete.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.2/modernizr.js"></script>
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
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.2.4/js/buttons.html5.min.js"></script>
    <script type="text/javascript" src="html/js/icheck.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.2.4/js/buttons.colVis.min.js"></script>
<!--    <script type="text/javascript" src="html/js/jquery.mobile-1.4.5.js"></script>  -->
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(document).on('pagebeforecreate', function( e ) {
            $( "input, textarea, select, div, button", e.target ).attr( "data-role", "none" );
            $("#myPopup").removeAttr("data-role");
            $("#myPopup").children().each(function(){
                $(this).removeAttr("data-role");
            });
            //$('element').removeClass('ui-widget');
        });
        var table;
        var refreshOut;

        $(document).ready(function() {
            
            $("#myPopup").dialog({
                autoOpen: false,
                width: 250,
                position: [0,28],
                buttons: [
                    {
                        text: "Search",
                        click: function() {
                            if(($("#geocomplete").val()!="")&&($("#distanceId").val()!="")&&($("#lat").val()!="")&&($("#lng").val()!="")){
                               $("#vehicleSearchFilterId").addClass("active");
                               $("#isSearchedId").val("true");
                            }    
                                table.ajax.reload();
                            $( this ).dialog( "close" );
                        }
                    },
                    {
                        text: "Reset",
                        click: function() {
                            $("#geocomplete").val("");
                            $("#distanceId").val("");
                            $("#lat").val("");
                            $("#lng").val("");
                            $("#vehicleSearchFilterId").removeClass("active");
                            $("#isSearchedId").val("false");
                        }
                    }
                ]
            }).dialog('widget').position({ my: 'left', at: 'right', of: $(this) });

            $("#vehicleSearchFilterId").click(function(){
                 $( function() {
                    $( "#myPopup" ).dialog("open");
                  } );
            });
            
            $('a').prop('rel', 'external');
            $("#vehicleSearchFilterId").removeProp('rel');
            $('#hdr_live').addClass("dropdown active");

            // <!--Rohan code start 2 -->	

            /*  try{
		$('#entrydata').DataTable({
			dom: 'Bfrtp',
			ordering:false,
            
			buttons: [

						'excelHtml5',
						
						'pdfHtml5'
					]
		}); */
            //{"vehicleno":"","description":"Normal Direction","location":"Unnamed Road Bengaluru Karnataka 635103 India","datetime1":1464771657000,"speed":25}
            try {
                allVehicleLocationJSON = ${allVehicleLocation};
                drawTable(allVehicleLocationJSON);

                /*$('input[type=radio][name=Vehicleno]').each(function () {
                    var $this = $(this);
                    if ($(this).prop('checked')) {
                      var  id = $this.attr('id');
                         $.each(allVehicleLocationJSON, function(key,value){
                            if(value.vehicleno==id){
                                 globalLatitude=value.latitude;
                                globalLongitude=value.longitude;
                             }
                    });
                    }
                });*/


                $('#entrydata').on("change", 'input[type=radio][name=Vehicleno]', function() { //we have to register new event handler for dynamically loaded contents after AJAX
                    if ($(this).prop('checked')) {
                        var id = $(this).attr('id');
                        $('#tempVehicleNo').val(id); //set to display same vehicle locaion whenever reload
                        $.each(allVehicleAjaxArr, function(key, value) {
                            if (value.vehicleno == id) {
                                var map_canvas = document.getElementById('map');
                                var map_options = {
                                    center: new google.maps.LatLng(value.latitude, value.longitude),
                                    zoom: 50,
                                    mapTypeId: google.maps.MapTypeId.ROADMAP
                                }
                                map = new google.maps.Map(map_canvas, map_options)
                                setMarkers(map, new google.maps.LatLng(value.latitude,
                                    value.longitude), id, value.location, value.datetime1, value.description,value.ownername,value.nextservice,value.deviceno,value.imeino);
                            }
                        });
                    }
                });
                /*  $('input[type=radio][name=Vehicleno]').change(function() {
                {data: "location"},
                                 {data: "location"},
                                 {data: "datetime1"}
                    if ($(this).prop('checked')) {
                       var id = $(this).attr('id');
                         $('#tempVehicleNo').val(id); //set to display same vehicle locaion whenever reload
                        $.each(allVehicleLocationJSON, function(key,value){
                            if(value.vehicleno==id){
                                 var map_canvas = document.getElementById('map');
                                 var map_options = {
                                 center: new google.maps.LatLng(value.latitude, value.longitude),
                                 zoom: 10,
                                 mapTypeId: google.maps.MapTypeId.ROADMAP
                                               }   
                                 map = new google.maps.Map(map_canvas, map_options)
                                new google.maps.Marker({
                                position: new google.maps.LatLng(value.latitude, 
                                                          value.longitude),    
                                map: map
                                });
                            }
                        });
                    }
                 });*/


                /* (function update() {
                 $.ajax({
                    url : 'getAllVehicleLatestLoc',
                      dataType: 'json',
                         success : function(data) {
                             var resultStr=JSON.stringify(data);
                             var resultStrArr=jQuery.parseJSON(resultStr);
                             var vehicleLocationStr=JSON.stringify(resultStrArr.result);
                             var vehicleLocationArr=jQuery.parseJSON(vehicleLocationStr);
                            // drawTable(vehicleLocationArr);
                         }                       
                 }).then(function() {           // on completion, restart
                    setTimeout(update, 10000);  // function refers to itself
                 });
                 })(); */
                var callback = true; //made true to not show any vehicle on map upon loading the page 

                function drawTable(jsonArr) {

                    table = $('#entrydata').DataTable({
                        dom: '<"top"flB>rt<"bottom"p><"clear">',
                       //data:jsonArr,
                        ajax: {
                            "url": "getAllVehicleLatestLoc",
                           "data": function(d){d.formData=JSON.stringify(getFormData());},
                            "contentType":'application/json',
                            "dataSrc": function(json) {
                                allVehicleAjaxArr = json.result;
                                //alert(JSON.stringify(allVehicleAjaxArr));
                                return json.result;
                            }
                        }
                        ,
                        columns: [

                            {
                                data: "vehicleno",
                                "render": function(data, type, full, meta) {
                                 
                                	updateMarker(allVehicleAjaxArr, data);
                                	
                                    return '<div ><img  style="width:15px;height:15px;" onClick="showVehicleDetails(\''+full.vehicleno+'\',\''+full.ownername+'\',\''+full.deviceno+'\',\''+full.nextservice+'\',\''+full.imeino+'\',\''+full.drivername+'\',\''+full.driverphone+'\',\''+full.gsmnumber+'\',\''+full.odometer+'\',\''+full.ownerphone+'\',\''+full.vehicletype+'\')" src="html/images/plus.png">&nbsp; &nbsp<a target="_blank" style="color:black" title="Retrac View" href="Vehicle_DetailedLogs?id=' + data + '" rel="external">  <b>' + data + '</b></a></div>';
                                }
                            }, {
                                data: "datetime1"
                            }
                            ,
                            
                            {
                                data: "description",
                                "render": function(data, type, full, meta) {
                                	var bgColor = '#39d647';
									var textColor= 'black';
;                                    
                                	 if (full.description == 'Poll R' ||full.description == 'Ignition Off' || full.description == 'Health Check') {
                                         bgColor = '#ff5062fc';
                                         
                                     }
									if (full.description == 'Slow/Idling ' ) {
                                         bgColor = '#ffb049';
										
                                         
                                     }
									 if (full.description == 'Ignition On' ) {
                                         bgColor = '#4997ff';
                                       
                                     }
									 if (full.description == 'Moving' || full.description == 'Overspeed') {
                                         bgColor = '#80f282';
                                       
                                     }
									 
									 if (full.description == 'Overspeed' ||full.description == 'Harsh Break' || full.description == 'Harsh Accel Start') {
                                         
                                         textColor='red';
                                     }
									 
                                    return '<div style="background-color:'+bgColor+';margin: 0px -4px 0px -4px;"><span  style="color:'+textColor+'">' + data + '<span></div>';
                                }
                            },{
                                data: "location",
                                "render": function(data, type, full, meta) {
                                	if(typeof data == 'undefined' ||data == null||data == ''){
                                		return getAddressFromLatLong(full.latitude,
                                		full.longitude);
                                	}
                                	return data;
                                }
                            },
                           
                            {
                                data: "speed"
                            },
                            
                           {
                                data: "distance"
                            }
                            , {
                                data: "acstatus"
                                    ,
                                   "render": function(data, type, full, meta) {
                                       
                                   //	updateMarker(allVehicleAjaxArr, data);
                                   	var bgColor = '#1e8427';
                                       
                                   	 if (data == 'AC OFF') {
                                            bgColor = '#d60002';
                                         	}
                                   	 if (data == null){
                                   	 	return '<div style="background-color:#ffffff"><span  style="color:#fff;"><span></div>';
                                   	 }
                                       return '<div style="background-color:#ffffff"><span  style="color:#fff;">' + data + '<span></div>';
                                   } 
                               }, 
                            {
                                data: "idletime",
                                "render": function(data, type, full, meta) {
                                    return sformat(data);
                                }
                            }
                        ],
                        language: {
                            lengthMenu: "Show _MENU_ Entries"
                            
                        },
                        ordering: false,
                        lengthMenu: [
                            [-1,10, 25, 50],
                            ["All",10, 25, 50]
                        ],
                        buttons: [{
                                extend: 'colvis',
                                titleAttr:'Select Columns',
                                text: '',
                                columns: ':gt(1)'
                            },

                            {
                                extend: 'excelHtml5',
                                titleAttr:'Export To Excel',
                                text: ''
                            }, {
                                extend: 'pdfHtml5',
                                titleAttr:'Export To PDF',
                                text: ''
                            }, {
                            	text: 'Close Map',
                            	className: 'linkButton closeMap',
                            	titleAttr:'Go to home page',
                                action: function ( e, dt, node, config ) {
                                	window.location.href = "home";

                                }
                            }

                        ],
                        select: {
                            style: 'single'
                        }
                 
                    });
                }

                function sformat(s) {
                    var fm = [
                        Math.floor(s / 60 / 60 / 24), // DAYS
                        Math.floor(s / 60 / 60) % 24, // HOURS
                        Math.floor(s / 60) % 60 // MINUTES
                        // ,s % 60 // SECONDS
                    ];
                    return $.map(fm, function(v, i) {
                        return ((v < 10) ? '0' : '') + v;
                    }).join(':');
                }

                function updateMarker(jsonArrMarker, vehicleId) {

                    var map_canvas = document.getElementById('map');
                    var map_options = {
                        center: new google.maps.LatLng(jsonArrMarker[0].latitude, jsonArrMarker[0].longitude),
                        zoom: 10,
                        mapTypeId: google.maps.MapTypeId.ROADMAP
                    };
                    map = new google.maps.Map(map_canvas, map_options);
                    var bounds = new google.maps.LatLngBounds();
                    $.each(jsonArrMarker, function(key, value) {


                        setMarkers(map, new google.maps.LatLng(value.latitude,
                            value.longitude), value.vehicleno, value.location, value.datetime1, value.description,value.ownername,value.nextservice,value.deviceno,value.imeino);

                        bounds.extend(new google.maps.LatLng(value.latitude,
                            value.longitude));



                    });

                    map.fitBounds(bounds);
                }




                // <!--Rohan code end 2 -->  

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
            } catch (err) {}
        });



        function setMarkers(map, position, vehicleNo, location, datetime, description, ownerName, nextService, deviceNo, imeiNo) {

            var hoverDiv = '<div style="display:none" class="markerTooltip" id="markerhover' + vehicleNo + '"><p>' + vehicleNo + '</p><p>' + location + '</p><p>' + datetime + '</p></div>';
            // The final coordinate closes the poly by connecting to the first coordinate.
            var image = {
                url: 'html/images/vehiclemap.png',
                // This marker is 20 pixels wide by 32 pixels high.
                size: new google.maps.Size(50, 50),
                // The origin for this image is (0, 0).
                origin: new google.maps.Point(0, 0),
                // The anchor for this image is the base of the flagpole at (0, 32).
                anchor: new google.maps.Point(0, 32)
            };
            var bgColor = '#1e8427';
            if ( description == 'Poll R' || description == 'Ignition Off' || description == 'Health Check') {
                bgColor = '#d60002'
            }
            var marker = new MarkerWithLabel({
                position: position,
                map: map,
                icon: image,
                labelStyle: {
                    'background-color': bgColor,
                    opacity: 0.75
                },
                draggable: false,
                raiseOnDrag: true,
                labelContent: '<div>' + vehicleNo + '' + hoverDiv + '</div>',
                labelClass: "labels"
            });
            
             var infowindow = new google.maps.InfoWindow({
                 content: "<div  style=\"word-wrap: break-word;width:180px\"><span>Location : "+location+"</span></br>"+
                               
                            "</div>",
                  pixelOffset: new google.maps.Size(25,30)
             });
            
             marker.addListener('click', function() {
                 infowindow.open(map, marker);
             });
            
        }


        function show(id) {
            document.getElementById(id).style.display = "block";
            document.getElementById(id).style.zIndex = -3;

        }

        function hide(id) {
            document.getElementById(id).style.display = "none";
        }
        
        function getFormData(){
            var formData;
            if($("#isSearchedId").val()=="true"){
            formData = {"area":$("#geocomplete").val(),
                            "distance":$("#distanceId").val(),
                            "lat":$("#lat").val(),
                            "lng":$("#lng").val()
                           };
            }else{
                formData = {"area":"",
                            "distance":"",
                            "lat":"",
                            "lng":""                    
                            };
            }
            if(formData.area!=""&&formData.distance!=""&&formData.lat!=""&&formData.lng!=""){
                $("#vehicleSearchFilterId").addClass("active");
            }
            return formData;
        }
        

    </script>
    <style>
        .markerTooltip {
            color: #fff;
            font-family: "Lucida Grande", "Arial", sans-serif;
            width: 80px;
            position: relative;
            z-index: 10000000009;
            font-size: 11px;
            text-align: left;
            border-radius: 5px!important;
            border: 2px solid black;
        }
        
        .labels {
            color: #fff;
            font-family: "Lucida Grande", "Arial", sans-serif;
            font-size: 14px;
            font-weight: bold;
            text-align: center;
            width: 100px;
            border: 2px solid black;
            white-space: nowrap;
        }
        
    </style>

    <script>
        $(document).ready(function() {
            try {
                $(".dt-buttons").addClass("pull-right");
                $("#entrydata_filter").addClass("pull-left");
                $('.i-checks').iCheck({
                    checkboxClass: 'icheckbox_square-green',
                    radioClass: 'iradio_square-green',
                });
            } catch (err) {}

        });

    </script>

    <!-- ChartJS-->
    <script src="html/js/Chart.min.js"></script>

    <script>
        /* Thanks to CSS Tricks for pointing out this bit of jQuery
        http://css-tricks.com/equal-height-blocks-in-rows/
        It's been modified into a function called at page load and then each time the page is resized. One large modification was to remove the set height before each new calculation. */

        equalheight = function(container) {

            var currentTallest = 0,
                currentRowStart = 0,
                rowDivs = new Array(),
                $el,
                topPosition = 0;
            $(container).each(function() {

                $el = $(this);
                $($el).height('auto');
                topPostion = $el.position().top;

                if (currentRowStart != topPostion) {
                    for (currentDiv = 0; currentDiv < rowDivs.length; currentDiv++) {
                        rowDivs[currentDiv].height(currentTallest);
                    }
                    rowDivs.length = 0;
                    currentRowStart = topPostion;
                    currentTallest = $el.height();
                    rowDivs.push($el);
                } else {
                    rowDivs.push($el);
                    currentTallest = (currentTallest < $el.height()) ? ($el.height()) : (currentTallest);
                }
                for (currentDiv = 0; currentDiv < rowDivs.length; currentDiv++) {
                    rowDivs[currentDiv].height(currentTallest);
                }
            });
        }

    </script>
    <style>
        .google-map-live {
            bottom: 15px;
            height: auto !important;
            left: 0;
            position: absolute !important;
            right: 30px;
            top: 68px;
            width: auto;
        }
        
        @media(max-width:1125px) {
            .google-map-live {
                top: 100px;
            }
        }
        
        @media(max-width:991px) {
            .ibox-content {
                position: relative;
            }
            .google-map-live {
                position: static !important;
                height: 300px !important;
            }
        }

    </style>
    <script>
        $(window).load(function() {
            equalheight('.ibox.float-e-margins.pad-bot-0 .col-md-6');
        });


        $(window).resize(function() {
            equalheight('.ibox.float-e-margins.pad-bot-0 .col-md-6');
        });

    </script>
</body>



<script>
    jQuery(document).ready(function($) {


        searchViaAjax();
        $(".form-inline").css('visibility', 'visible');

    });

    function searchViaAjax() {

        var search = {}
        search["username"] = "";
        search["email"] = "";

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "searchStatusCounts",
            data: JSON.stringify(search),
            dataType: 'json',
            timeout: 100000,
            success: function(data) {
                console.log("SUCCESS: ", data);
                display(data);
            },
            error: function(e) {
                location.reload();
            },
            done: function(e) {
                console.log("DONE");

            }
        });

    }

    function searchViaAjaxVehicle() {

        var search = {}
        search["username"] = "";
        search["email"] = "";

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "getAllVehicleLatestLoc",
            data: JSON.stringify(search),
            dataType: 'json',
            timeout: 100000,
            success: function(data) {

                createGridVehicle(data);
            },
            error: function(e) {
                location.reload();

            },
            done: function(e) {
                console.log("DONE");

            }
        });

    }

    function createGridVehicle(data) {
        var vehicleData = data.allVehicle;

    }

    function display(data) {



        var doughnutOptions = {

            segmentShowStroke: true,
            segmentStrokeColor: "#fff",
            segmentStrokeWidth: 1,
            percentageInnerCutout: 0,
            animationSteps: 100,
            animationEasing: "easeOutBounce",
            animateRotate: true,
            animateScale: false,
            responsive: true,
            onAnimationComplete: function() {
                this.showTooltip(this.segments, true);

                //Show tooltips in bar chart (issue: multiple datasets doesnt work http://jsfiddle.net/5gyfykka/14/)
                //this.showTooltip(this.datasets[0].bars, true);

                //Show tooltips in line chart (issue: multiple datasets doesnt work http://jsfiddle.net/5gyfykka/14/)
                //this.showTooltip(this.datasets[0].points, true);  
            },

            tooltipEvents: [],

            showTooltips: true,

            // String - Tooltip background colour
            tooltipFillColor: "rgba(0,0,0,0.4)",


            // String - Tooltip label font declaration for the scale label
            tooltipFontFamily: "'Helvetica Neue', 'Helvetica', 'Arial', sans-serif",

            // Number - Tooltip label font size in pixels
            tooltipFontSize: 12,

            // String - Tooltip font weight style
            tooltipFontStyle: "normal",


            // String - Tooltip title font colour
            tooltipTitleFontColor: "#fff",

            // Number - pixel width of padding around tooltip text
            tooltipYPadding: 2,

            // Number - pixel width of padding around tooltip text
            tooltipXPadding: 3,

            // Number - Size of the caret on the tooltip
            tooltipCaretSize: 4,

            // Number - Pixel radius of the tooltip border
            tooltipCornerRadius: 2,

            // Number - Pixel offset from point x to tooltip edge
            tooltipXOffset: 2,
            tooltipYOffset: 1

        };
        var totalVeh = parseInt(data.result["0"].totalVehicle);
        var igniOn = parseInt(data.result["0"].ignitionOn);
        var igniOff = parseInt(data.result["0"].ignitionOff);

        var doughnutData = [{
                value: totalVeh - igniOff,
                labelFontSize: '2',
                color: "#d9d9d9",
                labelColor: 'blue'

            },
            {
                value: igniOff,
                color: "#ff0000",
                labelFontSize: '2',
                labelColor: 'blue'

            }
        ];

        var ctx = document.getElementById("doughnutChart").getContext("2d");
        var myNewChart = new Chart(ctx).Doughnut(doughnutData, doughnutOptions);




        /* -------------------2222222-------------------------------- */
        var doughnutData2 = [

            {
                value: totalVeh - igniOn,
                color: "#d9d9d9",
                highlight: "#d9d9d9",
                label: ""
            },
            {
                value: igniOn,
                color: "#00cc00",
                highlight: "#1cb295",
                label: ""
            }
        ];


        var ctx2 = document.getElementById("doughnutChart2").getContext("2d");
        var myNewChart2 = new Chart(ctx2).Doughnut(doughnutData2, doughnutOptions);

        var movingNo = parseInt(data.result["0"].moving);
        var idleNo = parseInt(data.result["0"].idle);

        /* -------------------3333-------------------------------- */
        var doughnutData3 = [

            {
                value: totalVeh-movingNo ,
                color: "#d9d9d9",
                highlight: "#d9d9d9",
                label: ""
            },
            {
                value: movingNo,
                color: "#00cc00",
                highlight: "#ff9000",
                label: ""
            }
        ];


        var ctx3 = document.getElementById("doughnutChart3").getContext("2d");
        var myNewChart3 = new Chart(ctx3).Doughnut(doughnutData3, doughnutOptions);



        /* -------------------444-------------------------------- */

        var alertNo = parseInt(data.result["0"].alert);

        var doughnutData4 = [

            {
                value: totalVeh - alertNo,
                color: "#d9d9d9",
                highlight: "#d9d9d9",
                label: ""
            },
            {
                value: alertNo,
                color: "#ed5564",
                highlight: "#00aeff",
                label: ""
            }
        ];

        var ctx4 = document.getElementById("doughnutChart4").getContext("2d");
        var myNewChart4 = new Chart(ctx4).Doughnut(doughnutData4, doughnutOptions);


        /* -------------------555-------------------------------- */


        var notResponding = parseInt(data.result["0"].notResponding);

        var doughnutData4 = [

            {
                value: totalVeh - idleNo,
                color: "#d9d9d9",
                highlight: "#d9d9d9",
                label: ""
            },
            {
                value: idleNo,
                color: "#ff0000",
                highlight: "#00aeff",
                label: ""
            }
        ];

        var ctx4 = document.getElementById("doughnutChart5").getContext("2d");
        var myNewChart4 = new Chart(ctx4).Doughnut(doughnutData4, doughnutOptions);


        var doughnutData6 = [

            {
                value: 0 ,
                color: "#d9d9d9",
                highlight: "#d9d9d9",
                label: ""
            }
        ];

        

        var doughnutOptions2 = {

            segmentShowStroke: false,
            segmentStrokeColor: "#fff",
            segmentStrokeWidth: 0,
            percentageInnerCutout: 20,
          //  animationSteps: 100,
          // animationEasing: "easeOutBounce",
           // animateRotate: false,
            animateScale: false,
            responsive: true,
            onAnimationComplete: function() {
                this.showTooltip(this.segments, true);

                //Show tooltips in bar chart (issue: multiple datasets doesnt work http://jsfiddle.net/5gyfykka/14/)
                //this.showTooltip(this.datasets[0].bars, true);

                //Show tooltips in line chart (issue: multiple datasets doesnt work http://jsfiddle.net/5gyfykka/14/)
                //this.showTooltip(this.datasets[0].points, true);  
            },

            tooltipEvents: [],

            showTooltips: true,

            // String - Tooltip background colour
            tooltipFillColor: "rgba(0,0,0,0.4)",


            // String - Tooltip label font declaration for the scale label
            tooltipFontFamily: "'Helvetica Neue', 'Helvetica', 'Arial', sans-serif",

            // Number - Tooltip label font size in pixels
            tooltipFontSize: 12,

            // String - Tooltip font weight style
            tooltipFontStyle: "normal",


            // String - Tooltip title font colour
            tooltipTitleFontColor: "#fff",

            // Number - pixel width of padding around tooltip text
            tooltipYPadding: 2,

            // Number - pixel width of padding around tooltip text
            tooltipXPadding: 3,

            // Number - Size of the caret on the tooltip
            tooltipCaretSize: 4,

            // Number - Pixel radius of the tooltip border
            tooltipCornerRadius: 2,

            // Number - Pixel offset from point x to tooltip edge
            tooltipXOffset: 0,
            tooltipYOffset: 0

        };

        var ctx6 = document.getElementById("doughnutChart6").getContext("2d");
        var myNewChart6 = new Chart(ctx6).Doughnut(doughnutData6, doughnutOptions2);





    }

</script>

<style>
    button.dt-button,
    div.dt-button,
    a.dt-button {
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
        filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0, StartColorStr='white', EndColorStr='#e9e9e9');
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
        text-decoration: none;
        outline: none;
    }
    
    #same-height2 {
        margin: 0;
        padding: 0;
        height: 100%;
        width: 40%;
        height: 80%;
        position: absolute;
        float: left;
        right: 0px;
        z-index: 100;
    }
    
    #same-height {
        margin: 0;
        padding: 0;
        height: 100%;
        background-color: white;
        position: absolute;
        width: 60%;
        float: left;
    }

</style>
<script>
    function reSize(side) {
        var oldside = map.getBounds().getNorthEast().lng()
        if (side == "wide") {
            $(".vsplitbar").hide();
            document.getElementById("same-height2").style.width = "100%"
            document.getElementById("same-height2").style.height = "50%"
            //gridtoggle
            var sidetable = document.getElementById('same-height');

            sidetable.style.width = '100%';
            sidetable.style.top = '58%';
            sidetable.style.marginTop = null;
            $('#same-height').css({
                marginTop: '520px'
            });
            $(".map-layout-togglea1").removeClass("active");
            $(".map-layout-togglea2").addClass("active");
        } else {
            $(".vsplitbar").show();
            document.getElementById("same-height2").style.width = "40%"
            document.getElementById("same-height2").style.height = "100%"
            var sidetable = document.getElementById('same-height');
            sidetable.style.width = null;
            sidetable.style.top = null;
            sidetable.style.width = '60%';
            sidetable.style.marginTop = null;
            $(".map-layout-togglea2").removeClass("active");
            $(".map-layout-togglea1").addClass("active");




            side = "wide";
        }
        google.maps.event.trigger(map, 'resize');
        var newside = map.getBounds().getNorthEast().lng()
        var topan = oldside - newside;
        map.setCenter(new google.maps.LatLng(map.getCenter().lat(), map.getCenter().lng() + topan));
    }

</script>
<script>
    var refreshOut = setInterval(function() {
        //table.ajax.reload(null,false);

        table.ajax.reload();
        searchViaAjax();

    }, 300000);


    var timeOutIterval = 300000;
    $('.refreshC').change(function() {
        if ($('#refreshCheck').is(':checked')) {
            var mutliply = 1000;

            if ($('#refreshUnit').val() == 1) {
                mutliply = 1000 * 60;
            }
            if ($('#refreshUnit').val() == 2) {
                mutliply = 1000 * 60 * 60;
            }
            if ($('#refreshValue').val() != '' && $('#refreshValue').val() > 0) {
                mutliply = mutliply * $('#refreshValue').val();
                clearInterval(refreshOut);
                refreshOut = setInterval(function() {
                    //table.ajax.reload(null,false);
                    table.ajax.reload(null, false);
                    searchViaAjax();
                }, mutliply);
            } else {
                clearInterval(refreshOut);
            }


        } else {

        }

    });

    $('#refreshCheck').click(function() {

        if ($('#refreshCheck').is(':checked')) {

            var mutliply = 1000;

            if ($('#refreshUnit').val() == 1) {
                mutliply = 1000 * 60;
            }
            if ($('#refreshUnit').val() == 2) {
                mutliply = 1000 * 60 * 60;
            }
            if ($('#refreshValue').val() != '' && $('#refreshValue').val() > 0) {
                mutliply = mutliply * $('#refreshValue').val();
                clearInterval(refreshOut);
                refreshOut = setInterval(function() {
                    //table.ajax.reload(null,false);
                    table.ajax.reload(null, false);
                    searchViaAjax();
                }, mutliply);

            }
        } else {
            clearInterval(refreshOut);
        }
    });

    $('.fa-refresh').click(function() {
        table.ajax.reload(null, false);
        searchViaAjax();
    });

</script>


<style>
    .rowx.page-heading {
        padding: 0 0 0px !important;
    }
    
    .graphs {
        overflow: hidden;
        padding: 10px 0 0;
    }
    
    canvas {
        max-width: 200px !important;
        height: auto !important;
    }
    
    .auto-reloader-bar select {
        color: #012b73;
        padding: 0;
        height: 20px !important;
    }
    
    .form-control,
    .single-line {
        background-color: #FFFFFF;
        background-image: none;
        border: 1px solid #e5e6e7;
        border-radius: 1px;
        color: inherit;
        /* display: block; */
        padding: 6px 2px;
        transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
        width: 100%;
        font-size: 12px;
    }
    
    
    .input-sm {
    height: 25px;
    padding: 1px 10px;
    font-size: 12px;
    line-height: 1.5;
    border-radius: 3px;
}

select.input-sm {
    height: 25px;
}


    .top-navigation .wrapper.wrapper-content {
        padding: 2px 0 0;
    }
    
    @media (max-width: 991px) #page-wrapper2 {
        top: 132px;
    }

</style>

<script>
    /*
     * jQuery.splitter.js - two-pane splitter window plugin
     *
     * version 1.51 (2009/01/09) 
     * 
     * Dual licensed under the MIT and GPL licenses: 
     *   http://www.opensource.org/licenses/mit-license.php 
     *   http://www.gnu.org/licenses/gpl.html 
     */

    /**
     * The splitter() plugin implements a two-pane resizable splitter window.
     * The selected elements in the jQuery object are converted to a splitter;
     * each selected element should have two child elements, used for the panes
     * of the splitter. The plugin adds a third child element for the splitbar.
     * 
     * For more details see: http://methvin.com/splitter/
     *
     *
     * @example $('#MySplitter').splitter();
     * @desc Create a vertical splitter with default settings 
     *
     * @example $('#MySplitter').splitter({type: 'h', accessKey: 'M'});
     * @desc Create a horizontal splitter resizable via Alt+Shift+M
     *
     * @name splitter
     * @type jQuery
     * @param Object options Options for the splitter (not required)
     * @cat Plugins/Splitter
     * @return jQuery
     * @author Dave Methvin (dave.methvin@gmail.com)
     */
    ;
    (function($) {

        $.fn.splitter = function(args) {
            args = args || {};
            return this.each(function() {
                var zombie; // left-behind splitbar for outline resizes
                function startSplitMouse(evt) {
                    if (opts.outline)
                        zombie = zombie || bar.clone(false).insertAfter(A);
                    panes.css("-webkit-user-select", "none"); // Safari selects A/B text on a move
                    bar.addClass(opts.activeClass);
                    A._posSplit = A[0][opts.pxSplit] - evt[opts.eventPos];
                    $(document)
                        .bind("mousemove", doSplitMouse)
                        .bind("mouseup", endSplitMouse);
                }

                function doSplitMouse(evt) {
                    var newPos = A._posSplit + evt[opts.eventPos];
                    if (opts.outline) {
                        newPos = Math.max(0, Math.min(newPos, splitter._DA - bar._DA));
                        bar.css(opts.origin, newPos);
                    } else
                        resplit(newPos);
                }

                function endSplitMouse(evt) {
                    bar.removeClass(opts.activeClass);
                    var newPos = A._posSplit + evt[opts.eventPos];
                    if (opts.outline) {
                        zombie.remove();
                        zombie = null;
                        resplit(newPos);
                    }
                    panes.css("-webkit-user-select", "text"); // let Safari select text again
                    $(document)
                        .unbind("mousemove", doSplitMouse)
                        .unbind("mouseup", endSplitMouse);
                }

                function resplit(newPos) {
                    // Constrain new splitbar position to fit pane size limits
                    newPos = Math.max(A._min, splitter._DA - B._max,
                        Math.min(newPos, A._max, splitter._DA - bar._DA - B._min));
                    // Resize/position the two panes
                    bar._DA = bar[0][opts.pxSplit]; // bar size may change during dock
                    bar.css(opts.origin, newPos).css(opts.fixed, splitter._DF);
                    A.css(opts.origin, 0).css(opts.split, newPos).css(opts.fixed, splitter._DF);
                    B.css(opts.origin, newPos + bar._DA)
                        .css(opts.split, splitter._DA - bar._DA - newPos).css(opts.fixed, splitter._DF);
                    // IE fires resize for us; all others pay cash

                }

                function dimSum(jq, dims) {
                    // Opera returns -1 for missing min/max width, turn into 0
                    var sum = 0;
                    for (var i = 1; i < arguments.length; i++)
                        sum += Math.max(parseInt(jq.css(arguments[i])) || 0, 0);
                    return sum;
                }

                // Determine settings based on incoming opts, element classes, and defaults
                var vh = (args.splitHorizontal ? 'h' : args.splitVertical ? 'v' : args.type) || 'v';
                var opts = $.extend({
                    activeClass: 'active', // class name for active splitter
                    pxPerKey: 8, // splitter px moved per keypress
                    tabIndex: 0, // tab order indicator
                    accessKey: '' // accessKey for splitbar
                }, {
                    v: { // Vertical splitters:
                        keyLeft: 39,
                        keyRight: 37,
                        cursor: "e-resize",
                        splitbarClass: "vsplitbar",
                        outlineClass: "voutline",
                        type: 'v',
                        eventPos: "pageX",
                        origin: "left",
                        split: "width",
                        pxSplit: "offsetWidth",
                        side1: "Left",
                        side2: "Right",
                        fixed: "height",
                        pxFixed: "offsetHeight",
                        side3: "Top",
                        side4: "Bottom"
                    },
                    h: { // Horizontal splitters:
                        keyTop: 40,
                        keyBottom: 38,
                        cursor: "n-resize",
                        splitbarClass: "hsplitbar",
                        outlineClass: "houtline",
                        type: 'h',
                        eventPos: "pageY",
                        origin: "top",
                        split: "height",
                        pxSplit: "offsetHeight",
                        side1: "Top",
                        side2: "Bottom",
                        fixed: "width",
                        pxFixed: "offsetWidth",
                        side3: "Left",
                        side4: "Right"
                    }
                }[vh], args);

                // Create jQuery object closures for splitter and both panes
                var splitter = $(this).css({
                    position: "relative"
                });
                var panes = $(">*", splitter[0]).css({
                    position: "absolute", // positioned inside splitter container
                    "z-index": "1", // splitbar is positioned above
                    "-moz-outline-style": "none" // don't show dotted outline
                });
                var A = $(panes[0]); // left  or top
                var B = $(panes[1]); // right or bottom

                // Focuser element, provides keyboard support; title is shown by Opera accessKeys
                var focuser = $('<a href="javascript:void(0)"></a>')
                    .attr({
                        accessKey: opts.accessKey,
                        tabIndex: opts.tabIndex,
                        title: opts.splitbarClass
                    })
                    .bind("keydown", function(e) {
                        var key = e.which || e.keyCode;
                        var dir = key == opts["key" + opts.side1] ? 1 : key == opts["key" + opts.side2] ? -1 : 0;
                        if (dir)
                            resplit(A[0][opts.pxSplit] + dir * opts.pxPerKey, false);
                    })
                    .bind("blur", function() {
                        bar.removeClass(opts.activeClass)
                    });

                // Splitbar element, can be already in the doc or we create one
                var bar = $(panes[2] || '<div></div>')
                    .insertAfter(A).css("z-index", "100").append(focuser)
                    .attr({
                        "class": opts.splitbarClass,
                        unselectable: "on"
                    })
                    .css({
                        position: "absolute",
                        "user-select": "none",
                        "-webkit-user-select": "none",
                        "-khtml-user-select": "none",
                        "-moz-user-select": "none"
                    })
                    .bind("mousedown", startSplitMouse);
                // Use our cursor unless the style specifies a non-default cursor
                if (/^(auto|default|)$/.test(bar.css("cursor")))
                    bar.css("cursor", opts.cursor);

                // Cache several dimensions for speed, rather than re-querying constantly
                bar._DA = bar[0][opts.pxSplit];
                splitter._PBF = $.boxModel ? dimSum(splitter, "border" + opts.side3 + "Width", "border" + opts.side4 + "Width") : 0;
                splitter._PBA = $.boxModel ? dimSum(splitter, "border" + opts.side1 + "Width", "border" + opts.side2 + "Width") : 0;
                A._pane = opts.side1;
                B._pane = opts.side2;
                $.each([A, B], function() {
                    this._min = opts["min" + this._pane] || dimSum(this, "min-" + opts.split);
                    this._max = opts["max" + this._pane] || dimSum(this, "max-" + opts.split) || 9999;
                    this._init = opts["size" + this._pane] === true ?
                        parseInt($.curCSS(this[0], opts.split)) : opts["size" + this._pane];
                });

                // Determine initial position, get from cookie if specified
                var initPos = A._init;
                if (!isNaN(B._init)) // recalc initial B size as an offset from the top or left side
                    initPos = splitter[0][opts.pxSplit] - splitter._PBA - B._init - bar._DA;
                if (opts.cookie) {
                    if (!$.cookie)
                        alert('jQuery.splitter(): jQuery cookie plugin required');
                    var ckpos = parseInt($.cookie(opts.cookie));
                    if (!isNaN(ckpos))
                        initPos = ckpos;
                    $(window).bind("unload", function() {
                        var state = String(bar.css(opts.origin)); // current location of splitbar
                        $.cookie(opts.cookie, state, {
                            expires: opts.cookieExpires || 365,
                            path: opts.cookiePath || document.location.pathname
                        });
                    });
                }
                if (isNaN(initPos)) // King Solomon's algorithm
                    initPos = Math.round((splitter[0][opts.pxSplit] - splitter._PBA - bar._DA) / 2);

                // Resize event propagation and splitter sizing
                if (opts.anchorToWindow) {
                    // Account for margin or border on the splitter container and enforce min height
                    splitter._hadjust = dimSum(splitter, "borderTopWidth", "borderBottomWidth", "marginBottom");
                    splitter._hmin = Math.max(dimSum(splitter, "minHeight"), 20);
                    $(window).bind("resize", function() {
                        var top = splitter.offset().top;
                        var wh = $(window).height();
                        splitter.css("height", Math.max(wh - top - splitter._hadjust, splitter._hmin) + "px");

                    }).trigger("resize");
                } else if (opts.resizeToWidth)
                    $(window).bind("resize", function() {
                        splitter.trigger("resize");
                    });

                // Resize event handler; triggered immediately to set initial position
                splitter.bind("resize", function(e, size) {
                    // Custom events bubble in jQuery 1.3; don't Yo Dawg
                    if (e.target != this) return;
                    // Determine new width/height of splitter container
                    splitter._DF = splitter[0][opts.pxFixed] - splitter._PBF;
                    splitter._DA = splitter[0][opts.pxSplit] - splitter._PBA;
                    // Bail if splitter isn't visible or content isn't there yet
                    if (splitter._DF <= 0 || splitter._DA <= 0) return;
                    // Re-divvy the adjustable dimension; maintain size of the preferred pane
                    resplit(!isNaN(size) ? size : (!(opts.sizeRight || opts.sizeBottom) ? A[0][opts.pxSplit] :
                        splitter._DA - B[0][opts.pxSplit] - bar._DA));
                }).trigger("resize", [initPos]);
            });
        };

    })(jQuery);


    $().ready(function() {
        $(".wrap").splitter();
    });

</script>

<script>
   $(function(){
        $("#geocomplete").geocomplete({
          details: "form",
          types: ["geocode", "establishment"]
        });
       
        $("#geocomplete").focusout(function(){
            $("#geocomplete").trigger("geocode");
        });
   });
    
    jQuery.fn.ForceNumericOnly =
    function()
    {
        return this.each(function()
        {
            $(this).keydown(function(e)
            {
                var key = e.charCode || e.keyCode || 0;
                // allow backspace, tab, delete, enter, arrows, numbers and keypad numbers ONLY
                // home, end, period, and numpad decimal
                return (
                    key == 8 || 
                    key == 9 ||
                    key == 13 ||
                    key == 46 ||
                    //key == 110 ||     //.(numpad)
                   // key == 190 ||    //.>
                    (key >= 35 && key <= 40) ||
                    (key >= 48 && key <= 57) ||
                    (key >= 96 && key <= 105));
            });
        });
    };
    
    $(document).ready(function(){
        $('#distanceId').ForceNumericOnly(); 
        
        $("#btnReset").click(function(){
            $("#geocomplete").val("");
            $("#distanceId").val("");
            $("#lat").val("");
            $("#lng").val("");
            $("#vehicleSearchFilterId").removeClass("active");
            $("#isSearchedId").val("false");
        });
        
        $("#btnSearch").click(function(){
            if(($("#geocomplete").val()!="")&&($("#distanceId").val()!="")&&($("#lat").val()!="")&&($("#lng").val()!="")){
               $("#vehicleSearchFilterId").addClass("active");
               $("#isSearchedId").val("true");
            }    
                table.ajax.reload();
        });
        
    });
    
</script>

</html>

<style>
    .wrap {
        height: 100%;
        width: 102% background-color: #00c0c0;
    }
    
    .vsplitbar {
        width: 10px;
        height: 500px !important;
        border-left: 1px solid #eeeeee;
        border-right: 1px solid #666666;
        background-color: #c0c0c0;
        border-color: #c0c0c0;
        background-image: url('html/images/scroller.png');
        box-sizing: border-box;
        left: 60%
    }
    
    .vsplitbar:hover {
        border-color: #040101;
    }
    
    .dataTables_scrollHead {
        width: 100%;
    }
    
    .new-tbl {
        width: 100% !important;
    }
    
    .dataTables_scrollHeadInner {
        width: 97.5% !important;
    }
    
    .ibox-content {
        background-color: #ffffff;
        color: inherit;
        padding: 3px 1px 1px 1px;
        border-color: #e7eaec;
        border-image: none;
        border-style: solid solid none;
        border-width: 1px 0;
    }

.dataTables_scroll
{
    overflow:auto;
}

.leftMenu {
    font-family: Arial, Helvetica, sans-serif;
    font-size: 12px;
    color: #1b110b;
    text-align: center;
    border-style: thin;
    background-color: #D9E4E6;
    border-color: #F2EFEF;
}


.rowx {
    margin-right: -15px;
    margin-left: -15px;
}
</style>
<script>
$('.dataTable').wrap('<div class="dataTables_scroll" />');
</script>
<script>
function showVehicleDetails(vehicleNo,ownerName,deviceNo,nextService,imeiNo,drivername,driverphone,gsmnumber,odometer,ownerphone,vehicletype){
	vehicleNo=vehicleNo=="null"?"":vehicleNo;
	vehicletype=vehicletype=="null"?"":vehicletype;
	ownerName=ownerName=="null"?"":ownerName;
	ownerphone=ownerphone=="null"?"":ownerphone;
	drivername=drivername=="null"?"":drivername;
	driverphone=driverphone=="null"?"":driverphone;
	nextService=nextService=="null"?"":nextService;
	odometer=odometer=="null"?"":odometer;
	deviceNo=deviceNo=="null"?"":deviceNo;
	gsmnumber=gsmnumber=="null"?"":gsmnumber;
	imeiNo=imeiNo=="null"?"":imeiNo;
	var textVehicle="<div><span>Vehical No. : "+vehicleNo+"</span></br>"+
	"<span>Vehicle Type : "+vehicletype+"</span></br>"+
    "<span>Owner Name : "+ownerName+"</span></br>"+
    "<span>Owner Phone : "+ownerphone+"</span></br>"+
    "<span>Driver Name : "+drivername+"</span></br>"+
    "<span>Driver Phone : "+driverphone+"</span></br>"+
    "<span>Next Service : "+nextService+"</span></br>"+
    "<span>Odometer : "+odometer+"</span></br>"+
    "<span>Device No. : "+deviceNo+"</span></br>"+
    "<span>GSM No. : "+gsmnumber+"</span></br>"+
    "<span>IMEI No. : "+imeiNo+"</span></br>"+
"</div>";
	$( "#dialogtest" ).html(textVehicle);
	$( "#dialogtest" ).dialog({position: [40,28]
	}).dialog('widget').position({ my: 'left', at: 'left', of: $(this) });
;
	
         
  }
  
  
  function  getAddressFromLatLong( lati , longi ){
	var theUrl ="http://maps.googleapis.com/maps/api/geocode/json?latlng="+lati+","+longi+"&sensor=true";
	var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
    xmlHttp.send( null );
    var textAddress=xmlHttp.responseText;
    try{
    	var jsonAdd= JSON.parse(textAddress);
    return jsonAdd.results["0"].formatted_address; }
    catch(e){
    	return "";
    }
     
  
  }
  
  </script>

<div id="dialogtest" title="Vehicle Info">
 </div>