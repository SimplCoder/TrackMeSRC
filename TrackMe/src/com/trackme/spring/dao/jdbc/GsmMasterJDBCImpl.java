package com.trackme.spring.dao.jdbc;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trackme.constants.Constant;
import com.trackme.spring.model.UserMaster;

@Repository("GsmMasterJDBC")
public class GsmMasterJDBCImpl implements GsmMasterJDBC {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  

	@Override
	public int getVehicleCountByStatus(String status,UserMaster userMaster) {
		int total=0;
		try{
		StringBuilder queryStr=new StringBuilder();
		queryStr.append("select count(*)  from vehiclemaster vm join gsmstatus gsm on ( vm.unitno= gsm.unitNo and LOWER(vm.status)=LOWER('ACTIVE')) ");
		queryStr.append(" where gsm.status in("+status);
		queryStr.append(")");
		 if(!userMaster.getRoleMaster().getRole().equalsIgnoreCase(Constant.ROLE_SUPERUSER)){
			 queryStr.append(" and vm.company = " +userMaster.getCompanyMaster().getId() );
			}
		 total = jdbcTemplate.queryForInt(queryStr.toString());
		return total;}catch(Exception e){
			return total;
		}
	}

	@Override
	public int getNotRespondingVehicleCount(UserMaster user) {
		// TODO Auto-generated method stub
		int total = 0;
		try{
		String query =			
               " select count(*) from gsmstatus gm join vehiclemaster vm on (gm.unitno= vm.unitno "+
				" and vm.status like 'Active') where  "+
				" ((DATE_PART('day', now()::timestamp - (gm.datetimedate+gm.datetime) ) * 24 +  "+
				"  DATE_PART('hour', now()::timestamp - (gm.datetimedate+gm.datetime))) * 60+  "+
				" DATE_PART('minute', now()::timestamp- (gm.datetimedate+gm.datetime)))/60 > 6 ";
		 total = jdbcTemplate.queryForInt(query);
		 return total;
		}catch(Exception e){
			
		}	
		
		return 0;
	}


}
