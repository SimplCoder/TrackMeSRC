package com.trackme.spring.dao.jdbc;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trackme.spring.model.VehicleReport;

@Repository
public class VehicleReportJdbc {

	@Autowired
	private JdbcTemplate jdbcTemplate;  
	@Autowired
	private SessionFactory sessionFactory;
 
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public List<Map<String, Object>> getConsolidateReport(VehicleReport vehicleReport){
		Session session = this.sessionFactory.getCurrentSession();

String startTime = "12:00am";		
String endTime = "11:59pm";
if(vehicleReport.getStartTime()!=null &&!"".equalsIgnoreCase(vehicleReport.getStartTime())){
	startTime=vehicleReport.getStartTime();
}  

if(vehicleReport.getEndTime()!=null &&!"".equalsIgnoreCase(vehicleReport.getEndTime())){
endTime=vehicleReport.getEndTime();
}
String timeCheck1= " and gsm2.datetime >='"+startTime+"' and gsm2.datetime <='"+endTime+"'";
String timeCheck2= " and gsmlead.datetime >='"+startTime+"' and gsmlead.datetime <='"+endTime+"'";
String timeDiff = " case   round(cast(EXTRACT(EPOCH FROM to_timestamp('"+endTime+"' ,'HH12:MIam')-to_timestamp('"+startTime+"' ,'HH12:MIam'))/3600 as numeric),2)";
timeDiff =timeDiff+ "  when 23.98 then 24";
timeDiff = timeDiff+" else  round(cast(EXTRACT(EPOCH FROM to_timestamp('"+endTime+"' ,'HH12:MIam')-to_timestamp('"+startTime+"' ,'HH12:MIam'))/3600 as numeric),2) end ";

String query= "select vm.vehicleno as \"Vehicle No\", vm.unitno as \"Unit No\" ,to_char(min(gsm1.datetimedate+gsm1.datetime) , 'YYYY-MM-DD  HH:MI PM') as \"First Ignition On\", to_char(max(gsmoff.datetimedate+gsmoff.datetime) , 'YYYY-MM-DD  HH:MI PM')as \"Last Ingnition Off\", "+
"( select round(cast(sum(cast(gsm2.distance as integer))/1000 as numeric),2)  from gsmmaster gsm2  where gsm2.unitno=vm.unitno and gsm2.datetimedate= gsm1.datetimedate "+timeCheck1+") as \"Distance in km\"  , "+
"(select round(cast(sum(EXTRACT(EPOCH FROM x.stop-x.datetime)/3600 )as numeric),2) from ( select gsmlead.status,lead(gsmlead.status) over (order by gsmlead.datetime) as LeadStatus,   "+
"gsmlead.datetime ,lead(gsmlead.datetime) over (order by gsmlead.datetime) as stop, gsmlead.unitno from gsmmaster gsmlead  where gsmlead.unitno=vm.unitno and gsmlead.datetimedate =gsm1.datetimedate  "+timeCheck2+
" and gsmlead.status not in (select code from statusdesc where description  in ('Ignition Off','Health Check'))) as x ) as \"Operating time\",  "+
"(select  round(cast( "+timeDiff+" -sum(EXTRACT(EPOCH FROM x.stop-x.datetime)/3600 )as numeric),2)  "+
"from ( select gsmlead.status,lead(gsmlead.status) over (order by gsmlead.datetime) as LeadStatus,  gsmlead.datetime ,lead(gsmlead.datetime) over (order by gsmlead.datetime) as stop, gsmlead.unitno  "+
" from gsmmaster gsmlead  where gsmlead.unitno=vm.unitno and gsmlead.datetimedate =gsm1.datetimedate "+timeCheck2+" and gsmlead.status not in (select code from statusdesc where description  in ('Ignition Off','Health Check'))) as x ) as \"Ignition Off time\"  "+
"from  gsmmaster gsm1 join vehiclemaster vm on (gsm1.unitno= vm.unitno and gsm1.status=1)  join gsmmaster gsmoff on (gsmoff.unitno=vm.unitno and gsmoff.status=0)  "+
" where 1=1";

if(vehicleReport.getVehicle()!=null &&!"".equalsIgnoreCase(vehicleReport.getVehicle())){
query = query+ " and vm.vehicleno='"+vehicleReport.getVehicle()+"'";
}

if(vehicleReport.getStartDate()!=null &&!"".equalsIgnoreCase(vehicleReport.getStartDate())){
query = query+ " and gsm1.datetimedate>= to_date('"+vehicleReport.getStartDate()+"', 'mm-dd-yyyy') ";
}

if(vehicleReport.getEndDate()!=null &&!"".equalsIgnoreCase(vehicleReport.getEndDate())){
query = query+ " and gsm1.datetimedate<= to_date('"+vehicleReport.getEndDate()+"', 'mm-dd-yyyy') ";
}


if(vehicleReport.getStartTime()!=null &&!"".equalsIgnoreCase(vehicleReport.getStartTime())){
query = query+ " and gsm1.datetime>= '"+vehicleReport.getStartTime()+"'";
}  

if(vehicleReport.getEndTime()!=null &&!"".equalsIgnoreCase(vehicleReport.getEndTime())){
query = query+ " and gsmoff.datetime <= '"+vehicleReport.getEndTime()+"' ";
}




query =query+ " and gsm1.datetimedate= gsmoff.datetimedate group by vm.unitno,vm.vehicleno,gsm1.datetimedate, gsmoff.datetimedate  order by gsmoff.datetimedate " ;


try{
	
List<Map<String, Object>> report = jdbcTemplate.queryForList(query);
	return report;
	
}catch(Exception e){
	
}
		
		return null;
		
	}
	
	
public List getIgnitionReport(VehicleReport  vehicleReport){
	
String query= "";	
query=query+ " select gsmIgni.vehicleno as \"Vehicle No \",  gsmIgni.unitno as \"Unit No\", to_char(gsmIgni.teston , 'YYYY-MM-DD  HH:MI PM') as \"Ignition On\",to_char(gsmIgni.testoff , 'YYYY-MM-DD  HH:MI PM') as \"Ignition Off\", "+
	 " (select TO_CHAR((sum(EXTRACT(EPOCH FROM x.stop-x.datetime)) || ' second')::interval, 'HH24:MI:SS') from "+
	 " ( select gsmlead.status,lead(gsmlead.status) over (order by gsmlead.datetime) as LeadStatus,  "+
	 "  gsmlead.datetime ,lead(gsmlead.datetime) over (order by gsmlead.datetime) as stop, gsmlead.unitno "+
	 "  from gsmmaster gsmlead  where gsmlead.unitno=gsmIgni.unitno and gsmlead.datetimedate+gsmlead.datetime >=gsmIgni.teston and gsmlead.datetimedate+gsmlead.datetime <=gsmIgni.testoff "+
	 "  and gsmlead.status  in (select code from statusdesc where description  in ('Idle Excess','Idling Start' ,'Idling End'))) as x ) as \"idling time\", "+
	 " (select round(cast(sum(cast(gsmdist.distance as integer))/1000 as numeric),2) from gsmmaster gsmDist where gsmDist.unitno= gsmIgni.unitno and  "+
	 "  gsmDist.datetimedate+gsmDist.datetime>= gsmIgni.teston and gsmDist.datetimedate+gsmDist.datetime<= gsmIgni.testoff) as \"Distance\", "+
	 " TO_CHAR((EXTRACT(EPOCH FROM gsmIgni.testoff-gsmIgni.teston) || ' second')::interval, 'HH24:MI:SS') as \"Duration\", "+   
	 "  (select round(cast(AVG(cast(gsmdist.speed as integer)) as numeric),2) from gsmmaster gsmDist where gsmDist.unitno= gsmIgni.unitno and "+
	 "  gsmDist.datetimedate+gsmDist.datetime>= gsmIgni.teston and gsmDist.datetimedate+gsmDist.datetime<= gsmIgni.testoff) as \"Avg Speed\", "+
	 "  (select round(cast(MAX(cast(gsmdist.speed as integer)) as numeric),2) from gsmmaster gsmDist where gsmDist.unitno= gsmIgni.unitno and "+
	 " gsmDist.datetimedate+gsmDist.datetime>= gsmIgni.teston and gsmDist.datetimedate+gsmDist.datetime<= gsmIgni.testoff) as \"Max Speed\" "+
	 "  from (select vm.vehicleno as vehicleno, gsm.unitno as unitno, ( select max(gsmOn.datetimedate + gsmOn.datetime)  from gsmmaster gsmOn  "+
	 "    where gsm.unitno = gsmOn.unitno and  gsmOn.status in (select code from statusdesc where description  in ('Ignition On')) "+
	 "    and gsm.datetimedate+gsm.datetime >gsmOn.datetimedate+gsmOn.datetime ) as teston  , gsm.datetimedate+gsm.datetime  as testoff "+
	 " from gsmmaster  gsm join vehiclemaster vm on gsm.unitno=vm.unitno  where 1=1 ";



if(vehicleReport.getVehicle()!=null &&!"".equalsIgnoreCase(vehicleReport.getVehicle())){
query = query+ " and vm.vehicleno='"+vehicleReport.getVehicle()+"'";
}

if(vehicleReport.getStartDate()!=null &&!"".equalsIgnoreCase(vehicleReport.getStartDate())){
query = query+ " and gsm.datetimedate>= to_date('"+vehicleReport.getStartDate()+"', 'mm-dd-yyyy') ";
}

if(vehicleReport.getEndDate()!=null &&!"".equalsIgnoreCase(vehicleReport.getEndDate())){
query = query+ " and gsm.datetimedate<= to_date('"+vehicleReport.getEndDate()+"', 'mm-dd-yyyy') ";
}


if(vehicleReport.getStartTime()!=null &&!"".equalsIgnoreCase(vehicleReport.getStartTime())){
query = query+ " and gsm.datetime>= '"+vehicleReport.getStartTime()+"'";
}  

if(vehicleReport.getEndTime()!=null &&!"".equalsIgnoreCase(vehicleReport.getEndTime())){
query = query+ " and gsm.datetime <= '"+vehicleReport.getEndTime()+"' ";
}


query=query+ " and  gsm.status in (select code from statusdesc where description  in ('Ignition Off')) "+
     "  group by   vm.vehicleno,gsm.unitno , gsm.datetimedate,gsm.datetime  order by gsm.datetimedate+gsm.datetime ) as gsmIgni ";
	 
try{
	
List<Map<String, Object>> report = jdbcTemplate.queryForList(query);
	return report;
	
}catch(Exception e){
	
}

	
	return null;
	
	
}

public List getIntervalReport(VehicleReport vehicleReport){
	
String query= "";

query= query+" select gsmloc.vehicleno as \"Vehicle No\", gsmloc.unitno as \"Unit No\" , gsmloc.address as \"Location\", "+
 " to_char((select min(gsm1.datetimedate+gsm1.datetime) from gsmmaster gsm1 where gsm1.unitno= gsmloc.unitno and "+
" (point(cast(gsm1.latitude as float8),cast(gsm1.longitude as float8)) <@> point(cast(gsmloc.latitude as float8),cast(gsmloc.longitude as float8)))* 1609.344 = gsmloc.distance "+
"  group by gsm1.unitno ) , 'YYYY-MM-DD  HH:MI PM') as \"Report Time\", round(cast(gsmloc.distance as numeric),2) as \"Distance in m\" "+
" from(select gsm.unitno ,vm.vehicleno, "+
" to_timestamp(floor((extract('epoch' from gsm.datetimedate+ gsm.datetime) / 600 )) * 600 )::timestamp without time zone as loctime "+
"  ,lm.address ,  min((point(cast(gsm.latitude as float8),cast(gsm.longitude as float8)) <@> point(cast(lm.latitude as float8),cast(lm.longitude as float8)))* 1609.344) as distance, "+
"  lm.latitude, lm.longitude "+
"  from location lm join gsmmaster gsm on "+
"  (1000>(point(cast(gsm.latitude as float8),cast(gsm.longitude as float8)) <@> point(cast(lm.latitude as float8),cast(lm.longitude as float8)))* 1609.344) "+
" join vehiclemaster vm on vm.unitno= gsm.unitno "+
" where 1=1 ";

if(vehicleReport.getVehicle()!=null &&!"".equalsIgnoreCase(vehicleReport.getVehicle())){
query = query+ " and vm.vehicleno='"+vehicleReport.getVehicle()+"'";
}

if(vehicleReport.getStartDate()!=null &&!"".equalsIgnoreCase(vehicleReport.getStartDate())){
query = query+ " and gsm.datetimedate>= to_date('"+vehicleReport.getStartDate()+"', 'mm-dd-yyyy') ";
}

if(vehicleReport.getEndDate()!=null &&!"".equalsIgnoreCase(vehicleReport.getEndDate())){
query = query+ " and gsm.datetimedate<= to_date('"+vehicleReport.getEndDate()+"', 'mm-dd-yyyy') ";
}


if(vehicleReport.getStartTime()!=null &&!"".equalsIgnoreCase(vehicleReport.getStartTime())){
query = query+ " and gsm.datetime>= '"+vehicleReport.getStartTime()+"'";
}  

if(vehicleReport.getEndTime()!=null &&!"".equalsIgnoreCase(vehicleReport.getEndTime())){
query = query+ " and gsm.datetime <= '"+vehicleReport.getEndTime()+"' ";
}


query= query+"  group by vm.vehicleno, lm.address,gsm.unitno, loctime, lm.latitude,lm.longitude order by loctime ) as gsmloc"
		+ " group by gsmloc.vehicleno, gsmloc.unitno, gsmloc.distance, "
		+ "gsmloc.loctime, gsmloc.address ,gsmloc.latitude, gsmloc.longitude"
		+ " order by 4";
		

try{
	
List<Map<String, Object>> report = jdbcTemplate.queryForList(query);
	return report;
	
}catch(Exception e){
	
}


	
	return null;
	
}

public List getMovementReport(VehicleReport vehicleReport){
	String query = "";
	
	query = query+ " select vm.vehicleno as \"Vehicle No\" , gsm.unitno as \"Unit No\", to_char(gsm.datetimedate+gsm.datetime , 'YYYY-MM-DD  HH:MI PM' ) as \"Report Time\", "+
			" st.description as \"Status\",gsm.speed as \"Speed\", gsm.location as \"Location\" "+
			"  from gsmmaster gsm join vehiclemaster vm on gsm.unitno = vm.unitno "+
			" join statusdesc st on gsm.status=st.code "+
			"  where 1=1 "; 


if(vehicleReport.getVehicle()!=null &&!"".equalsIgnoreCase(vehicleReport.getVehicle())){
query = query+ " and vm.vehicleno='"+vehicleReport.getVehicle()+"'";
}

if(vehicleReport.getStartDate()!=null &&!"".equalsIgnoreCase(vehicleReport.getStartDate())){
query = query+ " and gsm.datetimedate>= to_date('"+vehicleReport.getStartDate()+"', 'mm-dd-yyyy') ";
}

if(vehicleReport.getEndDate()!=null &&!"".equalsIgnoreCase(vehicleReport.getEndDate())){
query = query+ " and gsm.datetimedate<= to_date('"+vehicleReport.getEndDate()+"', 'mm-dd-yyyy') ";
}


if(vehicleReport.getStartTime()!=null &&!"".equalsIgnoreCase(vehicleReport.getStartTime())){
query = query+ " and gsm.datetime>= '"+vehicleReport.getStartTime()+"'";
}  

if(vehicleReport.getEndTime()!=null &&!"".equalsIgnoreCase(vehicleReport.getEndTime())){
query = query+ " and gsm.datetime <= '"+vehicleReport.getEndTime()+"' ";
}

	
	query = query+ " order by  3";
			
	try{
		
		List<Map<String, Object>> report = jdbcTemplate.queryForList(query);
			return report;
			
		}catch(Exception e){
			
		}
	
	
	return null;
}

public List getOverSpeedReport(VehicleReport vehicleReport){
	String query = "";
		query= query+ "	select vm.vehicleno as \"Vehicle No\" , gsm.unitno as \"Unit No\", to_char(gsm.datetimedate+gsm.datetime , 'YYYY-MM-DD  HH:MI PM' ) as \"Report Time\", "+ 
				"	 gsm.location as \"Location\",gsm.speed as \"Speed\",st.description as \"Status\"  "+
				"	from gsmmaster gsm join vehiclemaster vm on gsm.unitno = vm.unitno  "+
				"	join statusdesc st on gsm.status=st.code and st.description like 'Overspeed' where 1=1 ";
		
		if(vehicleReport.getVehicle()!=null &&!"".equalsIgnoreCase(vehicleReport.getVehicle())){
			query = query+ " and vm.vehicleno='"+vehicleReport.getVehicle()+"'";
			}

			if(vehicleReport.getStartDate()!=null &&!"".equalsIgnoreCase(vehicleReport.getStartDate())){
			query = query+ " and gsm.datetimedate>= to_date('"+vehicleReport.getStartDate()+"', 'mm-dd-yyyy') ";
			}

			if(vehicleReport.getEndDate()!=null &&!"".equalsIgnoreCase(vehicleReport.getEndDate())){
			query = query+ " and gsm.datetimedate<= to_date('"+vehicleReport.getEndDate()+"', 'mm-dd-yyyy') ";
			}


			if(vehicleReport.getStartTime()!=null &&!"".equalsIgnoreCase(vehicleReport.getStartTime())){
			query = query+ " and gsm.datetime>= '"+vehicleReport.getStartTime()+"'";
			}  

			if(vehicleReport.getEndTime()!=null &&!"".equalsIgnoreCase(vehicleReport.getEndTime())){
			query = query+ " and gsm.datetime <= '"+vehicleReport.getEndTime()+"' ";
			}
				query= query+"order by 3  ";
	
				try{
					
					List<Map<String, Object>> report = jdbcTemplate.queryForList(query);
						return report;
						
					}catch(Exception e){
						
					}				
	return null;
}

public List getHarshBreakReport(VehicleReport vehicleReport){
	String query = "";
		query= query+ "	select vm.vehicleno as \"Vehicle No\" , gsm.unitno as \"Unit No\", to_char(gsm.datetimedate+gsm.datetime , 'YYYY-MM-DD  HH:MI PM' ) as \"Harsh Brake Time\", "+ 
				"	 gsm.location as \"Location\",gsm.speed as \"Speed\",st.description as \"Status\"  "+
				"	from gsmmaster gsm join vehiclemaster vm on gsm.unitno = vm.unitno  "+
				"	join statusdesc st on gsm.status=st.code and st.description like 'Harsh Brake' where 1=1 ";
		
		if(vehicleReport.getVehicle()!=null &&!"".equalsIgnoreCase(vehicleReport.getVehicle())){
			query = query+ " and vm.vehicleno='"+vehicleReport.getVehicle()+"'";
			}

			if(vehicleReport.getStartDate()!=null &&!"".equalsIgnoreCase(vehicleReport.getStartDate())){
			query = query+ " and gsm.datetimedate>= to_date('"+vehicleReport.getStartDate()+"', 'mm-dd-yyyy') ";
			}

			if(vehicleReport.getEndDate()!=null &&!"".equalsIgnoreCase(vehicleReport.getEndDate())){
			query = query+ " and gsm.datetimedate<= to_date('"+vehicleReport.getEndDate()+"', 'mm-dd-yyyy') ";
			}


			if(vehicleReport.getStartTime()!=null &&!"".equalsIgnoreCase(vehicleReport.getStartTime())){
			query = query+ " and gsm.datetime>= '"+vehicleReport.getStartTime()+"'";
			}  

			if(vehicleReport.getEndTime()!=null &&!"".equalsIgnoreCase(vehicleReport.getEndTime())){
			query = query+ " and gsm.datetime <= '"+vehicleReport.getEndTime()+"' ";
			}
				query= query+"order by 3  ";
	
				try{
					
					List<Map<String, Object>> report = jdbcTemplate.queryForList(query);
						return report;
						
					}catch(Exception e){
						
					}				
	return null;
}

public List getStopageReport(VehicleReport vehicleReport){
	
	String query = "";
	
	query= query + " select gsmIgni.vehicleno as \"Vehicle No \", "+
			"  to_char(gsmIgni.testoff , 'YYYY-MM-DD  HH:MI PM') as \"Ignition Off\",  "+
			"   TO_CHAR((EXTRACT(EPOCH FROM gsmIgni.teston-gsmIgni.testoff) || ' second')::interval, 'HH24:MI:SS') as \"Duration\", gsmIgni.location as \"Location\"  "+
			"  from (select vm.vehicleno as vehicleno, gsm.unitno as unitno,gsm.location , ( select min(gsmOn.datetimedate + gsmOn.datetime)  from gsmmaster gsmOn   "+    
			"  where gsm.unitno = gsmOn.unitno and  gsmOn.status in (select code from statusdesc where description  in ('Ignition On'))  "+   
			"  and gsm.datetimedate+gsm.datetime < gsmOn.datetimedate+gsmOn.datetime ) as teston  , gsm.datetimedate+gsm.datetime  as testoff  "+
			"   from gsmmaster  gsm join vehiclemaster vm on gsm.unitno=vm.unitno  where 1=1   ";
	
	if(vehicleReport.getVehicle()!=null &&!"".equalsIgnoreCase(vehicleReport.getVehicle())){
		query = query+ " and vm.vehicleno='"+vehicleReport.getVehicle()+"'";
		}

		if(vehicleReport.getStartDate()!=null &&!"".equalsIgnoreCase(vehicleReport.getStartDate())){
		query = query+ " and gsm.datetimedate>= to_date('"+vehicleReport.getStartDate()+"', 'mm-dd-yyyy') ";
		}

		if(vehicleReport.getEndDate()!=null &&!"".equalsIgnoreCase(vehicleReport.getEndDate())){
		query = query+ " and gsm.datetimedate<= to_date('"+vehicleReport.getEndDate()+"', 'mm-dd-yyyy') ";
		}


		if(vehicleReport.getStartTime()!=null &&!"".equalsIgnoreCase(vehicleReport.getStartTime())){
		query = query+ " and gsm.datetime>= '"+vehicleReport.getStartTime()+"'";
		}  

		if(vehicleReport.getEndTime()!=null &&!"".equalsIgnoreCase(vehicleReport.getEndTime())){
		query = query+ " and gsm.datetime <= '"+vehicleReport.getEndTime()+"' ";
		}
	
	
	query= query +	"   and  gsm.status in (select code from statusdesc where description  in ('Ignition Off'))   group by   vm.vehicleno,gsm.unitno ,  "+
			"   gsm.datetimedate,gsm.datetime  order by gsm.datetimedate+gsm.datetime ) as gsmIgni  ";
	
	try{
		
		List<Map<String, Object>> report = jdbcTemplate.queryForList(query);
			return report;
			
		}catch(Exception e){
			
		}	
	
	return null;
}
}
