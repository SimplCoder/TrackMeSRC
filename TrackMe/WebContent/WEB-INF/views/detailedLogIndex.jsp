<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Vehicle Service View</title>
<link href="html/css/css.css" rel="stylesheet" type="text/css"/>
<link href="html/css/bootstrap.min.css" rel="stylesheet">

<link href="html/font-awesome/css/font-awesome.css" rel="stylesheet">
<link href="html/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="html/css/animate.css" rel="stylesheet">
<link href="html/css/style1.css" rel="stylesheet">
<link href="html/css/custom1.css" rel="stylesheet">
<link href="html/css/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="html/css/buttons.dataTables.min.css" rel="stylesheet">

</head>
<body class="top-navigation">
<jsp:directive.include file="header.jsp" />
  <div id="page-wrapper2" class="gray-bg" style="top:112px !important">
      <form:form class="form-inline" action="Vehicle_DetailedLogs" commandName ="LogIndexSearch" >
      
                <div id="data_3" class="form-group" >
          <span id ='LogIndexSearchSpan' style="font-size:12pt"><b>Vehicle No. </b> :  ${vehicleName} &nbsp;&nbsp;&nbsp;</span>
     </div>
      
          <div id="data_1" class="form-group">
                                    <label>&nbsp;&nbsp;From Date:</label>
	<form:input type ="text" autocomplete="off" path="fromDate" id="fromDate"/>
	</div>
          <div id="data_2" class="form-group">
                                        <label>&nbsp;&nbsp;To Date:</label>
                                       <form:input type ="text" autocomplete="off" id="toDate" path="toDate" ></form:input>
                                    </div>
           <form:hidden path="vehicleNo"/>
          
         &nbsp;&nbsp;&nbsp;<input class="btn  btn-primary" type="submit" value="Go">
      
     </form:form>
     
    <!-- Rohan Code End 4 --> 
  
  
  
  

    <div class="row">
      <div class="col-lg-12">
        <div class="wrapper wrapper-content fadeInUp pad-bot-0">
          <div class="row">
            <div class="col-lg-12">
              <div class="ibox float-e-margins pad-bot-0" style="background:#fff;">
                <div class="row">
                  <div id="same-height" class="col-md-6 md-pad-left" style="padding-right:0;">
                   
                    <div class="ibox-content pad-bot-0">
                      <div class="table-responsive">
                          <!--Rohan code start 1 -->	
                        <table id="entrydata" class="table table-striped table-bordered new-tbl" style="width:100%">
                          <thead>
                          <tr class="leftMenu">
                                                    	 <th width="3%" align="center" valign="middle"></th>
				
                                                    <th width="12%" align="center" valign="middle">Date</th>
                                                    <th width="9%" align="center" valign="middle">Event</th>
                                                    <th width="4%" align="center" valign="middle">Speed</th>
                                                    <th width="17%" align="center" valign="middle">Location</th>
                                      
												
                                                </tr>
                          </thead>
                          
                        </table>
                          <input type="hidden" id="tempVehicleNo">
                          <!--Rohan code end 1 -->	
                      </div>
                    </div>
                  </div>
                  <div id="same-height2" class="col-md-6 md-pad-right" style="padding-left:0;">
                    <div class="ibox-title">
                      <div class="map-btns">
                      <a  id="play"></a>
                        <ul class="subnav-right az-move-right">
                       
                       
                          
                         <li class="map-reset"><a href="#" >&nbsp;</a></li>
                          <!--  <li class="map-actions"><a href="#" class="">&nbsp;</a> </li>-->
                          <!--  <li class="map-vehicles"><a href="#" class="">&nbsp;</a> </li>-->
                          <!--  <li class="map-landmarks"><a href="#" >&nbsp;</a></li>-->
                          <li class="map-geofences"><a href="#">&nbsp;</a> </li>
                        <li class="map-layout-toggle1"><a class="map-layout-togglea1 active" title="Vertical Split View" href="javascript:void(0)" onclick ="reSize('side')"></a> </li>
                          <li class="map-layout-toggle2"><a href="javascript:void(0)" title="Horizontal Split View" class="map-layout-togglea2" onclick ="reSize('wide')"></a></li>
                           <!--  <li class="map-icon-medium"><a class="active" href="#" >&nbsp;</a></li>-->
                          <!--  <li class="map-icon-large"><a href="#" class="">&nbsp;</a></li>-->
                          <!--  <li class="map-fullscreen"><a href="#">&nbsp;</a></li>-->
                        </ul>
                      </div>
                    </div>
                    <div class="ibox-content"> 
                         <div id="map" style="width:100%;height:480px;"></div>
                    

<!-- <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCeQdAwrHm8Zap7jwX_gNRA3dhH-CxdCWQ&callback=initialize"></script> -->
     <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCeQdAwrHm8Zap7jwX_gNRA3dhH-CxdCWQ&callback=showEmptyMap"></script>             
<!--Rohan code start 3 -->
    <script>
    var map;
     var isDataPresent;
     var vehicleLocationJSON1; 
         var startPos;
        if(${vehicleLatlngDetails}==""){
            isDataPresent=false;
            //console.error("no data");
        }else{
        vehicleLocationJSON=${vehicleLatlngDetails}; 
        vehicleLocationJSON1=${vehicleLatlngDetails}; 
            startPos = [vehicleLocationJSON[0].latitude, vehicleLocationJSON[0].longitude];
               isDataPresent=true;
        } 
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
	  
	   //Snap to road API
        var latLngString='';
        /*jQuery.each(vehicleLocationJSON, function(key,value){
            latLngString+=value.latitude+','+value.longitude+'|';
        });*/
        if(isDataPresent){
        vehicleLocationJSON.forEach(function(value){
            if(value!=undefined||value!=null||value!=''){
                latLngString+=value.latitude+','+value.longitude+'|'; 
            }
        });
        latLngString=latLngString.slice(0,-1);
        var app_Key='AIzaSyCeQdAwrHm8Zap7jwX_gNRA3dhH-CxdCWQ';
        var api_Url='https://roads.googleapis.com/v1/snapToRoads?path='+latLngString+'&interpolate=true&key='+app_Key;
        var snapResult = new Array();
        $(function() {
               $.ajax({
                    type: 'POST',
                    url: api_Url,
                    dataType: 'json',
                    contentType: 'application/json; charset=utf-8',
                    success: function(response) {
                        if(response.snappedPoints!=undefined){
                             response.snappedPoints.forEach(function(value){
                                        snapResult.push(value.location);

                            });
                        }
                    
                    vehicleLocationJSON=  snapResult;  
                    startPathPlay();
                    
                    },
                    error: function(error) {
                        console.log(error);
                    }
                });
        });
        
        }else{
            
            //showEmptyMap();  
            
        }
        
        function showEmptyMap(){
              var map_canvas = document.getElementById('map');
                var map_options = {
                    center: {lat: 18.5204, lng: 73.8567},
                    zoom: 16,
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                }   
             map = new google.maps.Map(map_canvas, map_options)
        }
       
	   function startPathPlay(){     
       
       var playBool=false;
        var marker;
        var speed = 1000; // km/h
        var delay = 100; 
        
        var MY_MAPTYPE_ID = 'custom_style';  
            //function initialize() {
          // var locations=jQuery.parseJSON(vehicleLocationJSON);
           var routeLineCoordinates=[];
           
            if(isDataPresent==true){
               for(index=0;index<vehicleLocationJSON.length; index++){
                   routeLineCoordinates.push(new google.maps.LatLng(vehicleLocationJSON[index].latitude,vehicleLocationJSON[index].longitude));
               }


               var point = new google.maps.LatLng(vehicleLocationJSON[0].latitude,vehicleLocationJSON[0].longitude);    //keep marker at center of map, need to change hard coding
            
                                               
            var map_canvas = document.getElementById('map');
            var map_options = {
            center: new google.maps.LatLng(vehicleLocationJSON[0].latitude,vehicleLocationJSON[0].longitude),
            zoom: 16,
            mapTypeId: google.maps.MapTypeId.ROADMAP
                              }   
             map = new google.maps.Map(map_canvas, map_options)
				
				var image = {
                url: 'html/images/gps.svg',
                // This marker is 20 pixels wide by 32 pixels high.
                size: new google.maps.Size(50, 50),
                // The origin for this image is (0, 0).
                origin: new google.maps.Point(0, 0),
                // The anchor for this image is the base of the flagpole at (0, 32).
                anchor: new google.maps.Point(15, 15)
              };
		 
             marker= new google.maps.Marker({
              position: point,
              map: map,
              icon:image
           });

                     var routePath = new google.maps.Polyline({
                    map: map,
                    path: routeLineCoordinates,
                    strokeColor: "#0000FF",
                    strokeOpacity: 0.50,
                    strokeWeight: 2
                });

                    var coordsStr="[";
                    for(index=0;index<vehicleLocationJSON.length; index++){
                       coordsStr=coordsStr+"["+vehicleLocationJSON[index].latitude+","+vehicleLocationJSON[index].longitude+"]";
                        if(index!=vehicleLocationJSON.length-1){
                          coordsStr=coordsStr+",";  
                        }
                    }
                    coordsStr=coordsStr+"]";
                    //var coordsJSONArr=jQuery.parseJSON(coordsStr);
                    var coordsJSONArr=JSON.parse(coordsStr);
                    google.maps.event.addListenerOnce(map, 'idle', function()
                    {
                        animateMarker(marker, coordsJSONArr, speed);
                    }); 
                }else{
                    var map_canvas = document.getElementById('map');
                    var map_options = {
                    center: {lat: 18.5204, lng: 73.8567},
                    zoom: 16,
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                                      }   
                     map = new google.maps.Map(map_canvas, map_options)
                }
           // }
        
        function animateMarker(marker, coords, km_h)
        {
            var target = 0;
            var endFlag=false;
            var km_h = km_h || 50;
         //  coords.push([startPos[0], startPos[1]]);

            function goToPoint()
            {
                var lat = marker.position.lat();
                var lng = marker.position.lng();
                var step = (km_h * 1000 * delay) / 3600000; // in meters

                var dest = new google.maps.LatLng(
                coords[target][0], coords[target][1]);
                //alert(coords[target][0]+" "+coords[target][1]);
                
                var distance =
                google.maps.geometry.spherical.computeDistanceBetween(
                dest, marker.position); // in meters

                var numStep = distance / step;
                var i = 0;
                var deltaLat = (coords[target][0] - lat) / numStep;
                var deltaLng = (coords[target][1] - lng) / numStep;

                function moveMarker()
                {
                    if(playBool){
                    lat += deltaLat;
                    lng += deltaLng;
                    i += step;

                    if (i < distance)
                    {
                        marker.setPosition(new google.maps.LatLng(lat, lng));
                        setTimeout(moveMarker, delay);
                    }
                    else
                    {   marker.setPosition(dest);
                        target++;
                        if (target == coords.length){ 
                            //target = 0; 
                            endFlag=true;
                        playBool=false;
                             $('#play').toggleClass("pause1");
                        }

                        setTimeout(goToPoint, delay);
                    }
                    }
                }
                moveMarker();
            }
            goToPoint();
            
            $('#play').click(function(){
                playBool=!playBool;
                if(endFlag){
                    endFlag=false;
                    target = 0;
                    marker.setPosition(new google.maps.LatLng(coords[0][0], coords[0][1]));
                } 
                if(playBool){
                    goToPoint();
                }
            $(this).toggleClass("pause1");
            });
        } 
       
   } 
       
          //  google.maps.event.addDomListener(window, 'load', initialize);
        /*  window.addEventListener('load',function(){
        	  if(document.getElementById('map')){
        		  showEmptyMap();
        	  }
          }); */
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
</div>

<!-- Mainly scripts --> 
<script type="text/javascript" src="html/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="html/js/tether.min.js"></script>
<script type="text/javascript" src="html/js/bootstrap.js"></script>
<script type="text/javascript" src="html/js/angular.min.js"></script>
<script type="text/javascript" src="html/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="html/js/dataTables.bootstrap.min.js"></script>
<!-- Rohan Code Start 6 -->
<script type="text/javascript" src="html/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="html/js/bootstrap-timepicker.js"></script>
  <!-- Rohan Code end 6 -->  
<script type="text/javascript" src="html/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="html/js/buttons.flash.min.js"></script>
<script type="text/javascript" src="html/js/jspdf.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
<script type="text/javascript" src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.2.4/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="html/js/icheck.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.2.4/js/buttons.colVis.min.js"></script>
<script type="text/javascript" src="http://www.datejs.com/build/date.js"></script>


<script type="text/javascript">   
        $('#data_1 .input-group.date').datepicker({
            autoclose: true
        });
        $('#data_2 .input-group.date').datepicker({
            autoclose: true
        });
    </script>
<script>
	$(document).ready(function () {
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
        try{
        vehicleLocationJSON=${vehicleLatlngDetails};
        vehicleLocationJSON1=${vehicleLatlngDetails};
        drawTable(vehicleLocationJSON); 
     
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
            

  /*  $('#entrydata').on("change",'input[type=radio][name=Vehicleno]',function(){ //we have to register new event handler for dynamically loaded contents after AJAX
        if ($(this).prop('checked')) {
           var id = $(this).attr('id');
             $('#tempVehicleNo').val(id); //set to display same vehicle locaion whenever reload
            $.each(allVehicleAjaxArr, function(key,value){
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
    }); */
    /*  $('input[type=radio][name=Vehicleno]').change(function() {
    
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
       url : 'api/getAllVehicleLatestLoc',
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
 //   var callback=true;//made true to not show any vehicle on map upon loading the page 
 //   var table;        
//{"vehicleno":"8585","latitude":"18.5119380950","description":"Health Check","location":"Ramchandra Mane Rd Sahakar Vrinda Society Ramkrishna Paramhans Nagar Kothrud Pune Maharashtra 411038 India","datetime1":1463626537000,"speed":0,"longitude":"73.8057861328"}
    function drawTable(jsonArr){
        //alert(jsonArr[0]);
      table= $('#entrydata').DataTable({
    	  dom: '<"top"flB>rt<"bottom"p><"clear">',
    		scrollY:        '68vh',
	        scrollCollapse: true,
            data:jsonArr,
           /* ajax : {
        "url" : "api/getAllVehicleLatestLoc",
        "dataSrc" : function (json) {
           // alert(json.result);
            allVehicleAjaxArr=json.result;
            //alert(JSON.stringify(allVehicleAjaxArr));
            return json.result;
        }}, */
             columns:[
                    {data: "datetime1",
                    	 "render": function ( data, type, full, meta ) {
                                     return '<input type="checkbox" id="' + data + '" name="Vehicleno" value="'+data+'">';
                                  
                            }
                    	 },
                     {data: "datetime1","render":function(data, type, full, meta){
                          //var tempDate = new Date(data);
                           // return  tempDate.getDate() +'/'+ (tempDate.getMonth() + 1) + '/' + tempDate.getFullYear() + " " + tempDate.getHours() + ":" + tempDate.getMinutes() + ":" + tempDate.getSeconds();
							return new Date(data).toString("yyyy-MM-dd hh:mm tt");
                     }},
                     {data: "description"},
                     {data: "speed"},
                     {data: "location",
                         "render": function(data, type, full, meta) {
                         	if(typeof data == 'undefined' ||data == null||data == ''){
                         		return getAddressFromLatLong(full.latitude,
                         		full.longitude);
                         	}
                         	return data;
                         }
                    	 
                     }
                    ],   ordering:false,
       			 lengthMenu: [[10, 25, 50, -1], [10, 25, 50, "All"]],
       			 language: {
                     lengthMenu: "Show _MENU_ Entries"
                     
                 },
     			buttons: [
    
     {
         extend: 'excelHtml5',
         text :''
      },{
     	    extend:'pdfHtml5',
     	    text :''
     	 }
     ]
		}); 
    }
    
    /*function updateMarker(jsonArrMarker,vehicleId){
     //   alert(jsonArrMarker+vehicleId);
        $.each(jsonArrMarker, function(key,value){
                if(value.vehicleno==vehicleId){
                    if(!callback){
                         var map_canvas = document.getElementById('map');
                         var map_options = {
                         center: new google.maps.LatLng(value.latitude, value.longitude),
                         zoom: 10,
                         mapTypeId: google.maps.MapTypeId.ROADMAP
                                       }   
                         map = new google.maps.Map(map_canvas, map_options) 
                    }
                    new google.maps.Marker({
                    position: new google.maps.LatLng(value.latitude, 
                                              value.longitude),    
                    map: map
                    });
                }
            });
    }
            
    setInterval( function () {
        table.ajax.reload();
        }, 5000000 );*/
            
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
        }catch(err){}
        });
        
</script>
<!--<script type="text/javascript">
        // When the window has finished loading google map
        google.maps.event.addDomListener(window, 'load', init);

        function init() {
            // Options for Google map
            // More info see: https://developers.google.com/maps/documentation/javascript/reference#MapOptions
            var mapOptions1 = {
                zoom: 11,
                center: new google.maps.LatLng(40.6700, -73.9400),
                // Style for Google Maps
                styles: [{"featureType":"water","stylers":[{"saturation":43},{"lightness":-11},{"hue":"#0088ff"}]},{"featureType":"road","elementType":"geometry.fill","stylers":[{"hue":"#ff0000"},{"saturation":-100},{"lightness":99}]},{"featureType":"road","elementType":"geometry.stroke","stylers":[{"color":"#808080"},{"lightness":54}]},{"featureType":"landscape.man_made","elementType":"geometry.fill","stylers":[{"color":"#ece2d9"}]},{"featureType":"poi.park","elementType":"geometry.fill","stylers":[{"color":"#ccdca1"}]},{"featureType":"road","elementType":"labels.text.fill","stylers":[{"color":"#767676"}]},{"featureType":"road","elementType":"labels.text.stroke","stylers":[{"color":"#ffffff"}]},{"featureType":"poi","stylers":[{"visibility":"off"}]},{"featureType":"landscape.natural","elementType":"geometry.fill","stylers":[{"visibility":"on"},{"color":"#b8cb93"}]},{"featureType":"poi.park","stylers":[{"visibility":"on"}]},{"featureType":"poi.sports_complex","stylers":[{"visibility":"on"}]},{"featureType":"poi.medical","stylers":[{"visibility":"on"}]},{"featureType":"poi.business","stylers":[{"visibility":"simplified"}]}]
            };

            var mapOptions2 = {
                zoom: 11,
                center: new google.maps.LatLng(40.6700, -73.9400),
                // Style for Google Maps
                styles: [{"featureType":"all","elementType":"all","stylers":[{"invert_lightness":true},{"saturation":10},{"lightness":30},{"gamma":0.5},{"hue":"#435158"}]}]
            };

            var mapOptions3 = {
                center: new google.maps.LatLng(36.964645, -122.01523),
                zoom: 18,
                mapTypeId: google.maps.MapTypeId.SATELLITE,
                // Style for Google Maps
                styles: [{"featureType":"road","elementType":"geometry","stylers":[{"visibility":"off"}]},{"featureType":"poi","elementType":"geometry","stylers":[{"visibility":"off"}]},{"featureType":"landscape","elementType":"geometry","stylers":[{"color":"#fffffa"}]},{"featureType":"water","stylers":[{"lightness":50}]},{"featureType":"road","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"transit","stylers":[{"visibility":"off"}]},{"featureType":"administrative","elementType":"geometry","stylers":[{"lightness":40}]}]
            };

            var mapOptions4 = {
                zoom: 11,
                center: new google.maps.LatLng(40.6700, -73.9400),
                // Style for Google Maps
                styles: [{"stylers":[{"hue":"#18a689"},{"visibility":"on"},{"invert_lightness":true},{"saturation":40},{"lightness":10}]}]
            };

            var fenway = new google.maps.LatLng(42.345573, -71.098326);
            var mapOptions5 = {
                zoom: 14,
                center: fenway,
                // Style for Google Maps
                styles: [{featureType:"landscape",stylers:[{saturation:-100},{lightness:65},{visibility:"on"}]},{featureType:"poi",stylers:[{saturation:-100},{lightness:51},{visibility:"simplified"}]},{featureType:"road.highway",stylers:[{saturation:-100},{visibility:"simplified"}]},{featureType:"road.arterial",stylers:[{saturation:-100},{lightness:30},{visibility:"on"}]},{featureType:"road.local",stylers:[{saturation:-100},{lightness:40},{visibility:"on"}]},{featureType:"transit",stylers:[{saturation:-100},{visibility:"simplified"}]},{featureType:"administrative.province",stylers:[{visibility:"off"}]/**/},{featureType:"administrative.locality",stylers:[{visibility:"off"}]},{featureType:"administrative.neighborhood",stylers:[{visibility:"on"}]/**/},{featureType:"water",elementType:"labels",stylers:[{visibility:"on"},{lightness:-25},{saturation:-100}]},{featureType:"water",elementType:"geometry",stylers:[{hue:"#ffff00"},{lightness:-25},{saturation:-97}]}]
            };

            var panoramaOptions = {
                position: fenway,
                pov: {
                    heading: 10,
                    pitch: 10
                }
            };
            var panorama = new google.maps.StreetViewPanorama(document.getElementById('pano'), panoramaOptions);

            // Get all html elements for map
            var mapElement1 = document.getElementById('map1');
            var mapElement2 = document.getElementById('map2');
            var mapElement3 = document.getElementById('map3');
            var mapElement4 = document.getElementById('map4');

            // Create the Google Map using elements
            var map1 = new google.maps.Map(mapElement1, mapOptions1);
            var map2 = new google.maps.Map(mapElement2, mapOptions2);
            var map3 = new google.maps.Map(mapElement3, mapOptions3);
            var map4 = new google.maps.Map(mapElement4, mapOptions4);
        }

var xmlHttpRequest = new XMLHttpRequest();
window.onload = function(){ 
	xmlHttpRequest.open("get", "/TrackMeWeb/TrackMeServlet?action=getLoginData", true);
	xmlHttpRequest.onreadystatechange = addDataToPage;
	xmlHttpRequest.send(null);
} ;
function addDataToPage()
{
if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200)
	{
		var table = document.getElementById("entrydata");
		var dom = (new DOMParser()).parseFromString(xmlHttpRequest.responseText, "text/xml");
		var data = dom.getElementsByTagName("vehicle");

	
		var i = 0;
		while(i < data.length )
		{
			row = table.insertRow( i+2 );
			row.className ="leftMenu";
			cell = row.insertCell(0);
			cell.innerHTML = data[i].childNodes[0].firstChild == null ? "" :data[i].childNodes[0].firstChild.nodeValue;
			cell = row.insertCell(1);
			cell.innerHTML = data[i].childNodes[1].firstChild == null ? "" :data[i].childNodes[1].firstChild.nodeValue;
			cell = row.insertCell(2);
			cell.innerHTML = data[i].childNodes[2].firstChild == null ? "" :data[i].childNodes[2].firstChild.nodeValue;
			//cell = row.insertCell(3);
			//cell.innerHTML = data[i].childNodes[3].firstChild == null ? "" :data[i].childNodes[3].firstChild.nodeValue;
			//cell = row.insertCell(4);
			//cell.innerHTML = data[i].childNodes[4].firstChild == null ? "" :data[i].childNodes[4].firstChild.nodeValue;
			cell = row.insertCell(5);
			cell.innerHTML = data[i].childNodes[5].firstChild == null ? "" :data[i].childNodes[5].firstChild.nodeValue;
			cell = row.insertCell(6);
			cell.innerHTML = data[i].childNodes[6].firstChild == null ? "" :data[i].childNodes[6].firstChild.nodeValue;
			cell = row.insertCell(7);
			cell.innerHTML = data[i].childNodes[7].firstChild == null ? "" :data[i].childNodes[7].firstChild.nodeValue;
			cell = row.insertCell(8);
			cell.innerHTML = data[i].childNodes[8].firstChild == null ? "" :data[i].childNodes[8].firstChild.nodeValue+" "+data[i].childNodes[9].firstChild.nodeValue;
			//cell = row.insertCell(9);
			//cell.innerHTML = data[i].childNodes[9].firstChild == null ? "" :data[i].childNodes[9].firstChild.nodeValue;
			i++;
		}
	}

}
    </script> -->

<script>
            $(document).ready(function () {
			try{
			$(".dt-buttons").addClass("pull-right");
					$("#entrydata_filter").addClass("pull-left");
                $('.i-checks').iCheck({
                    checkboxClass: 'icheckbox_square-green',
                    radioClass: 'iradio_square-green',
                });
			}catch(err){}
            
            });
            
        </script> 

<!-- ChartJS--> 
<!--<script src="html/js/Chart.min.js"></script> -->
<!--<script>
$(function () {    
    var doughnutData = [
        {
            value: 100,
            color: "#d9d9d9",
            highlight: "#d9d9d9",
            label: "Software"
        },
        {
            value: 75,
            color: "#ed5564",
            highlight: "#ed5564",
            label: "Laptop"
        }
    ];

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
    };

    var ctx = document.getElementById("doughnutChart").getContext("2d");
    var myNewChart = new Chart(ctx).Doughnut(doughnutData, doughnutOptions);
	
	
	
	/* -------------------2222222-------------------------------- */
	var doughnutData2 = [
 
        {
            value: 50,
            color: "#d9d9d9",
            highlight: "#d9d9d9",
            label: "Software"
        },
        {
            value: 150,
            color: "#1cb295",
            highlight: "#1cb295",
            label: "Laptop"
        }
    ];

    var doughnutOptions2 = {
        segmentShowStroke: true,
        segmentStrokeColor: "#fff",
        segmentStrokeWidth: 1,
        percentageInnerCutout: 0,
        animationSteps: 100,
        animationEasing: "easeOutBounce",
        animateRotate: true,
        animateScale: false,
        responsive: true,
    };

    var ctx2 = document.getElementById("doughnutChart2").getContext("2d");
    var myNewChart2 = new Chart(ctx2).Doughnut(doughnutData2, doughnutOptions2);
	
	
	/* -------------------3333-------------------------------- */
	var doughnutData3 = [
 
        {
            value: 100,
            color: "#d9d9d9",
            highlight: "#d9d9d9",
            label: "Software"
        },
        {
            value: 100,
            color: "#ff9000",
            highlight: "#ff9000",
            label: "Laptop"
        }
    ];

    var doughnutOptions3 = {
        segmentShowStroke: true,
        segmentStrokeColor: "#fff",
        segmentStrokeWidth: 1,
        percentageInnerCutout: 0,
        animationSteps: 100,
        animationEasing: "easeOutBounce",
        animateRotate: true,
        animateScale: false,
        responsive: true,
    };

    var ctx3 = document.getElementById("doughnutChart3").getContext("2d");
    var myNewChart3 = new Chart(ctx3).Doughnut(doughnutData3, doughnutOptions3);
	
	
	
	/* -------------------444-------------------------------- */
	var doughnutData4 = [
 
        {
            value: 50,
            color: "#d9d9d9",
            highlight: "#d9d9d9",
            label: "Software"
        },
        {
            value: 25,
            color: "#00aeff",
            highlight: "#00aeff",
            label: "Laptop"
        }
    ];

    var doughnutOptions4 = {
        segmentShowStroke: true,
        segmentStrokeColor: "#fff",
        segmentStrokeWidth: 1,
        percentageInnerCutout: 0,
        animationSteps: 100,
        animationEasing: "easeOutBounce",
        animateRotate: true,
        animateScale: false,
        responsive: true,
    };

    var ctx4 = document.getElementById("doughnutChart4").getContext("2d");
    var myNewChart4 = new Chart(ctx4).Doughnut(doughnutData4, doughnutOptions4);
	
	
	/* -------------------555-------------------------------- */
	var doughnutData5 = [
 
        {
            value: 50,
            color: "#d9d9d9",
            highlight: "#d9d9d9",
            label: "Software"
        },
        {
            value: 35,
            color: "#f8fb00",
            highlight: "#f8fb00",
            label: "Laptop"
        }
    ];

    var doughnutOptions5 = {
        segmentShowStroke: true,
        segmentStrokeColor: "#fff",
        segmentStrokeWidth: 1,
        percentageInnerCutout: 0,
        animationSteps: 100,
        animationEasing: "easeOutBounce",
        animateRotate: true,
        animateScale: false,
        responsive: true,
    };

    var ctx5 = document.getElementById("doughnutChart5").getContext("2d");
    var myNewChart5 = new Chart(ctx5).Doughnut(doughnutData5, doughnutOptions5);
	
	/* -------------------666-------------------------------- */
	var doughnutData6 = [
 
        {
            value: 150,
            color: "#d9d9d9",
            highlight: "#d9d9d9",
            label: "Software"
        },
        {
            value: 50,
            color: "#ed5564",
            highlight: "#ed5564",
            label: "Laptop"
        }
    ];

    var doughnutOptions6 = {
        segmentShowStroke: true,
        segmentStrokeColor: "#fff",
        segmentStrokeWidth: 1,
        percentageInnerCutout: 0,
        animationSteps: 100,
        animationEasing: "easeOutBounce",
        animateRotate: true,
        animateScale: false,
        responsive: true,
    };

    var ctx6 = document.getElementById("doughnutChart6").getContext("2d");
    var myNewChart6 = new Chart(ctx6).Doughnut(doughnutData6, doughnutOptions6);
	
	
	/* -------------------777-------------------------------- */
	var doughnutData7 = [
 
        {
            value: 50,
            color: "#d9d9d9",
            highlight: "#d9d9d9",
            label: "Software"
        },
        {
            value: 50,
            color: "#ff9000",
            highlight: "#ff9000",
            label: "Laptop"
        }
    ];

    var doughnutOptions7 = {
        segmentShowStroke: true,
        segmentStrokeColor: "#fff",
        segmentStrokeWidth: 1,
        percentageInnerCutout: 0,
        animationSteps: 100,
        animationEasing: "easeOutBounce",
        animateRotate: true,
        animateScale: false,
        responsive: true,
    };

    var ctx7 = document.getElementById("doughnutChart7").getContext("2d");
    var myNewChart7 = new Chart(ctx7).Doughnut(doughnutData7, doughnutOptions7);
	
	
	/* -------------------888-------------------------------- */
	var doughnutData8 = [
 
        {
            value: 150,
            color: "#d9d9d9",
            highlight: "#d9d9d9",
            label: "Software"
        },
        {
            value: 100,
            color: "#005ffb",
            highlight: "#005ffb",
            label: "Laptop"
        }
    ];

    var doughnutOptions8 = {
        segmentShowStroke: true,
        segmentStrokeColor: "#fff",
        segmentStrokeWidth: 1,
        percentageInnerCutout: 0,
        animationSteps: 100,
        animationEasing: "easeOutBounce",
        animateRotate: true,
        animateScale: false,
        responsive: true,
    };

    var ctx8 = document.getElementById("doughnutChart8").getContext("2d");
    var myNewChart8 = new Chart(ctx8).Doughnut(doughnutData8, doughnutOptions8);
	
	
	
});
</script> -->
<script>
	
/* Thanks to CSS Tricks for pointing out this bit of jQuery
http://css-tricks.com/equal-height-blocks-in-rows/
It's been modified into a function called at page load and then each time the page is resized. One large modification was to remove the set height before each new calculation. */

equalheight = function(container){

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
     for (currentDiv = 0 ; currentDiv < rowDivs.length ; currentDiv++) {
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
   for (currentDiv = 0 ; currentDiv < rowDivs.length ; currentDiv++) {
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
@media(max-width:1125px){
 .google-map-live {
   
    top: 100px;
   
}
}

@media(max-width:991px){
	.ibox-content{ position:relative;}
 .google-map-live {
   
    position:static !important; height:300px !important;
   
}
}

#play
{text-align:left !important;
	width:32px;
	height:32px;
	background-image: url(html/images/play1.png);
    background-size: 32px 32px;
    background-repeat: no-repeat;
	float:left;
} 
.pause1
{   text-align:left ;
	width:32px;
	height:32px;
	background-image: url(html/images/pause1.png) !important;
    background-size: 32px 32px;
    background-repeat: no-repeat;
	float:left;
}


	   </style>
	   <script>
	   $(window).load(function() {
		   equalheight('.ibox.float-e-margins.pad-bot-0 .col-md-6');
		 });


		 $(window).resize(function(){
		   equalheight('.ibox.float-e-margins.pad-bot-0 .col-md-6');
		 });
		 
		 
		 $(document).ready(function () {
				
				$(".dt-buttons").addClass("pull-right");
						$("#entrydata_filter").addClass("pull-left");
						
	                
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

#same-height2 {
margin: 0;
        padding: 0;
        height: 100%;
	width:50%;
	height:80%;
	position:absolute;
	float:left;
	right:0px;
	z-index:100;
	}
	#same-height {
	margin: 0;
        padding: 0;
        height: 100%;
	background-color:white;
	position:absolute;
	width:50%;
	float:left; 
	
    }


</style>

<script>
function reSize(side) {
	var oldside=map.getBounds().getNorthEast().lng()
	if (side=="wide"){

	document.getElementById("same-height2").style.width="100%"
	document.getElementById("same-height2").style.height="50%"
//gridtoggle
	var sidetable  = document.getElementById('same-height');

	sidetable.style.width = '100%'; 
	sidetable.style.top = '58%';
	sidetable.style.marginTop=null;
	$('#same-height').css({marginTop: '535px'});
	$(".map-layout-togglea1").removeClass("active");
	$(".map-layout-togglea2").addClass("active");
		} else {
	document.getElementById("same-height2").style.width="50%"
	document.getElementById("same-height2").style.height="100%"
	var sidetable  = document.getElementById('same-height');
	sidetable.style.width = null; 
	sidetable.style.top = null; 
	sidetable.style.width = '50%'; 
	sidetable.style.marginTop=null;
	$(".map-layout-togglea2").removeClass("active");
	$(".map-layout-togglea1").addClass("active");
	
	


	side="wide";
		} 
	google.maps.event.trigger(map,'resize');
	var newside=map.getBounds().getNorthEast().lng()
	var topan=oldside-newside;
	map.setCenter(new google.maps.LatLng(map.getCenter().lat(),map.getCenter().lng()+topan));	
	}





</script>
<script type="text/javascript" src="html/js/markerwithlabel.js"></script>


<script>

$('#entrydata').on("change",'input[type=checkbox][name=Vehicleno]',function(){ //we have to register new event handler for dynamically loaded contents after AJAX
    if ($(this).prop('checked')) {
     
    	var id = $(this).attr('value');
 //set to display same vehicle locaion whenever reload
        $.each(vehicleLocationJSON1, function(key,value){
          
        	if(value.datetime1==id){
                      	
            	
                 setMarkers(map,new google.maps.LatLng(value.latitude, 
                         value.longitude),id,value.location,value.datetime1);
              return false;
            }
        });
    }else{
    	
    	 var id = $(this).attr('value');
           $.each(vehicleLocationJSON1, function(key,value){
            if(value.datetime1==id){
                       	
            	 
                 removeMarkers(map,new google.maps.LatLng(value.latitude, 
                         value.longitude),id,value.location,value.datetime1);
                return false; 
            }
        });
    	
    }
});

var markers={};

function setMarkers(map,position,vehicleNo,location,datetime) { 
   
	  // The final coordinate closes the poly by connecting to the first coordinate.
   var image1 = {
      url: 'html/images/gps2.svg',
      // This marker is 20 pixels wide by 32 pixels high.
      size: new google.maps.Size(50, 50),
      // The origin for this image is (0, 0).
      origin: new google.maps.Point(0, 0),
      // The anchor for this image is the base of the flagpole at (0, 32).
      anchor: new google.maps.Point(15, 15)
    };
   markers[datetime] = new google.maps.Marker({
       position: position,
       map: map,
       icon:image1
    });
  
   /* 
    new MarkerWithLabel({
        position: position,
        map: map,
        icon: image,
        labelStyle: {opacity: 0.75},
        draggable: false,
        raiseOnDrag: true,
        labelContent: '<div onMouseOver="show(\'markerhover'+vehicleNo+'\')" onMouseOut="hide(\'markerhover'+vehicleNo+'\')">'+vehicleNo+''+hoverDiv+'</div>',
          labelClass :"labels"
      });
    */
  }	


function removeMarkers(map,position,vehicleNo,location,datetime) { 
  

 markers[datetime].setMap(null);

  }	

</script>
<script type="text/javascript" src="html/js/moment.js"></script>
   
<script>



</script>
<style>
#LogIndexSearchSpan {
    text-align: left;
  font-size:12pt;
}
#LogIndexSearch {
padding-left: 1%;
margin-left: -14px;
    margin-right: -14px;
    border-style: groove;
text-align: center; 
font-size:12pt; 
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
</style>
<!-- Mirrored from kalkisoft.com/adhata/html/ by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 30 Dec 2016 18:15:42 GMT -->
</html>
<link rel="stylesheet" type="text/css" href="html/css/jquery.datetimepicker.min.css"/>
<script type="text/javascript" src="html/js/jquery.datetimepicker.full.js"></script>
<script type="text/javascript">


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

$( document ).ready(function() {
var fromDateVal='${LogIndexSearch.fromDate}';
var toDateVal='${LogIndexSearch.toDate}';
if(toDateVal==''){ 
	var date = new Date()
	var today = new Date();;
	date.setDate(today.getDate()+1);
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var day = date.getDate();
	var hours = 00;
	var minutes = 00;
	var seconds = 00;

	toDateVal=year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;	
}

if(fromDateVal==''){ 
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var day = date.getDate();
	var hours = 00;
	var minutes = 00;
	var seconds = 00;

	fromDateVal=year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;
	console.log(fromDateVal);
}


$('#fromDate').datetimepicker({
dayOfWeekStart : 1,
format: 'Y-m-d H:i:s',
formatTime: 'H:i:s',
formatDate: 'Y-m-d',
yearStart:1950,
yearEnd:2050,

lang:'en'
});

$('#fromDate').datetimepicker({value:fromDateVal,step:10});

$('#toDate').datetimepicker({
	dayOfWeekStart : 1,
	format: 'Y-m-d H:i:s',
	formatTime: 'H:i:s',
	formatDate: 'Y-m-d',
	lang:'en',
	//disabledDates:['1986/01/08','1986/01/09','1986/01/10'],
	//startDate:	'1986/01/05'
	});
		
$('#toDate').datetimepicker({value:toDateVal,step:10});
});


</script>

<script>
</script>
