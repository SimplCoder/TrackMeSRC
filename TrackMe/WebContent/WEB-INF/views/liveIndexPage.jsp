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
	
	.padding-bottom-50 {
	   padding-bottom: 10px;
	}
	
	.linkButton {
	    display: block;
	    width: 85px;
	    height: 25px;
	    background: #4E9CAF;
	    padding: 10px;
	    text-align: center;
	    border-radius: 5px;
	    color: white;
	    font-size: 100% !important;
	    font-weight: bold;
	}
</style>

</head>

<body class="top-navigation">
    <div class="se-pre-con"></div>
    <jsp:directive.include file="header.jsp" />
    <div id="page-wrapper2" class="gray-bg">
        <div class="rowx wrapper border-bottom white-bg page-heading">
            <div class="col-sm-12">

                <div class="graphs">
                    <div class="graph-in">
                        <div class="graph-img">
                            <canvas id="doughnutChart" height="100"></canvas>
                        </div>
                        <div class="graph-txt">Ign Off</div>
                    </div>
                    <div class="graph-in">
                        <div class="graph-img">
                            <canvas id="doughnutChart2" height="100"></canvas>
                        </div>
                        <div class="graph-txt">Ign On</div>
                    </div>
                    <div class="graph-in">
                        <div class="graph-img">
                            <canvas id="doughnutChart3" height="100"></canvas>
                        </div>
                        <div class="graph-txt">Moving</div>
                    </div>
                    
                    <div class="graph-in">
                        <div class="graph-img">
                            <canvas id="doughnutChart5" height="100"></canvas>
                        </div>
                        <div class="graph-txt">Idle</div>
                    </div>
                    <div class="graph-in">
                        <div class="graph-img">
                            <canvas id="doughnutChart4" height="100"></canvas>
                        </div>
                        <div class="graph-txt">Alert</div>
                    </div>

                    

                    <div class="graph-in" >

                       
                        <div class="graph-img" >
                           <canvas id="doughnutChart6" height="100"></canvas>
                        </div>

                        <div class="graph-txt">
                            Total Unit Count

                        </div>
                    </div>
                </div>


            </div>
        </div>
        <div class="row">
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

                                                            <th width="12%" align="center" valign="middle">Vehicle No</th>
                                                             <th width="10%" align="center" valign="middle">Date/Time</th>
                                                            
                                                            <th width="10%" align="center" valign="middle">Status</th>
                                                                <th width="48%" align="center" valign="middle">Location</th>
                                                        
                                                            <th width="4%" align="center" valign="middle">Speed</th>
                                                           <th width="4%" align="center" valign="middle">Dist</th>                     
                                                            <th width="6%" align="center" valign="middle">AC</th>
                                                           
                                                            <th width="12%" align="center" title="(dd:hh:mm)" valign="middle">Idle Time</th>

                                                        </tr>
                                                    </thead>

                                                </table>
                                                <input type="hidden" id="tempVehicleNo">
                                              	<!--Rohan code end 1 -->
                                            </div>
                                            <div class="padding-bottom-50">
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
                $(".se-pre-con").fadeOut("slow");
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
                                 
                                	//updateMarker(allVehicleAjaxArr, data);
                                	
                                    return '<div ><img  style="width:15px;height:15px;" onClick="showVehicleDetails(\''+full.vehicleno+'\',\''+full.ownername+'\',\''+full.deviceno+'\',\''+full.nextservice+'\',\''+full.imeino+'\',\''+full.drivername+'\',\''+full.driverphone+'\',\''+full.gsmnumber+'\',\''+full.odometer+'\',\''+full.ownerphone+'\',\''+full.vehicletype+'\')" src="html/images/plus.png">&nbsp; &nbsp<a style="color:black" target="_blank" title="Retrac view" href="Vehicle_DetailedLogs?id=' + data + '" rel="external">  <b>' + data + '</b></a></div>';
                                }
                            }
                            ,
                            {
                                data: "datetime1"
                            },
                            {
                                data: "description",
                                "render": function(data, type, full, meta) {
                                    debugger;
                                //	updateMarker(allVehicleAjaxArr, data);
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
                            },
                            {
                                data: "location",
                                "render": function(data, type, full, meta) {
                                	if(typeof data == 'undefined' ||data == null||data == ''){
                                		return getAddressFromLatLong(full.latitude,
                                		full.longitude);
                                	}
                                	return data;
                                }
                            }
                            ,
                        
                            {
                                data: "speed"
                            },
                           
                            {
                                data: "distance"
                            }
                            ,    {
                                data: "acstatus"
                                    ,
                                   "render": function(data, type, full, meta) {
                                       
                                   //	updateMarker(allVehicleAjaxArr, data);
                                   	var bgColor = '#ffffff';
                                       
                                   /*	if (data == 'AC OFF') {
                                            bgColor = '#d60002';
                                       }	*/
                                   	 if (data == null){
                                   	 	return '<span  style="color:#000;"><span>';
                                   	 }
                                       return '<span  style="color:#000;">' + data + '<span>';
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
                                text: '',
                                titleAttr:'Select Columns',
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
                            	text: 'Show Map',
                            	className: 'linkButton showMap',
                            	titleAttr:'Switch To Map View',
                                action: function ( e, dt, node, config ) {
                                	window.location.href = "getLiveMap";
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
                labelColor: 'black'

            },
            {
                value: igniOff,
                color: "#ff0000",
                labelFontSize: '2',
                labelColor: 'black'

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
                color: "#4253f4",
                highlight: "#4253f4",
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
                color: "#23c920",
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
                color: "#ffb049",
                highlight: "#00aeff",
                label: ""
            }
        ];

        var ctx4 = document.getElementById("doughnutChart5").getContext("2d");
        var myNewChart4 = new Chart(ctx4).Doughnut(doughnutData4, doughnutOptions);


        var doughnutData6 = [

            {
                value: totalVeh ,
                color: "#d9d9d9",
                highlight: "#d9d9d9",
                label: ""
            }
        ];

        var doughnutOptions = {
        		
                segmentShowStroke: false,
                segmentStrokeColor: "#fff",
                segmentStrokeWidth: 0,
                percentageInnerCutout: 95,
                animationSteps: 100,
                animationEasing: "easeOutBounce",
                animateRotate: false,
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
                tooltipFillColor: "#fff",


                // String - Tooltip label font declaration for the scale label
                tooltipFontFamily: "'Helvetica Neue', 'Helvetica', 'Arial', sans-serif",

                // Number - Tooltip label font size in pixels
                tooltipFontSize: 24,

                // String - Tooltip font weight style
                tooltipFontStyle: "normal",


                // String - Tooltip title font colour
                tooltipTitleFontColor: "#fff",
                tooltipFontColor: "#000",
                // Number - pixel width of padding around tooltip text
                tooltipYPadding: 13,

                // Number - pixel width of padding around tooltip text
                tooltipXPadding: 3,

                // Number - Size of the caret on the tooltip
                tooltipCaretSize: 4,

                // Number - Pixel radius of the tooltip border
                tooltipCornerRadius: 2,

                // Number - Pixel offset from point x to tooltip edge
                tooltipXOffset: 20,
                tooltipYOffset: 20

            };

        
        var ctx6 = document.getElementById("doughnutChart6").getContext("2d");
        var myNewChart6 = new Chart(ctx6).Doughnut(doughnutData6, doughnutOptions);





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
        height: 100% !important;
        background-color: white;
        position: absolute;
        width: 100%;
        float: left;
    }

</style>
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

a.dt-button.linkButton.showMap {
    background-color: #68A229;
    font-weight: bolder;
    height: 23px;
    margin-bottom: 4px;
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