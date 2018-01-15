 <div class="foot-fixed" style="height: 25px;">
    <div class="auto-reloader-bar">
      <div class="row">
        <div class="col-xs-6">
          <form role="form" class="form-inline" style="visibility:hidden;">
            <div class="form-group">
             
                <label style="font-size: 12px;">
                  <input  id="refreshCheck" type="checkbox" class="refreshC" style="zoom:1.75" value=1 checked>
              </label>
              
            </div>
            <div class="form-group">
                 
            <input type="text" placeholder="refresh" value="60"  id="refreshValue" style="color:black;height:20px; width:40px" class="refreshC input-sm form-control input-s-sm inline">
              <select id="refreshUnit" class="refreshC input-sm form-control input-s-sm inline" style="color:black;height:20px; width:60px">
                <option value="0">Sec.</option>
                
              </select>
              <span>&nbsp;&nbsp;<i class="fa fa-refresh" aria-hidden="true" style="font-size: 15px;cursor:pointer;cursor:hand"></i></span> </div>
          </form>
        </div>
        <div class="col-xs-6 text-right">
           <div class="copy-txt"><strong>Copyright</strong> Adhata Technologies LLP &copy; 2017-18 </div>
        </div>
      </div>
    </div>
  </div>
  <script>
  $("#refreshValue").bind('keydown', function(e){
     var targetValue = $(this).val();
     if (e.which ===8 || e.which === 13 || e.which === 37 || e.which === 39 || e.which === 46) { return; }

     if (e.which > 47 &&  e.which < 58  && targetValue.length < 3) {
        var c = String.fromCharCode(e.which);
        var val = parseInt(c);
        var textVal = parseInt(targetValue || "0");
        var result = textVal + val;

        if (result < 0 || result > 999) {
           e.preventDefault();
        }

        if (targetValue === "0") {
          $(this).val(val);
          e.preventDefault();
        }
     }
     else {
         e.preventDefault();
     }
  });
</script>
  </script>