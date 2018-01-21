package com.trackme.constants;

import java.text.SimpleDateFormat;

public class Constant {

	public static final String dateFormat ="MM/dd/yyyy";
	public static final SimpleDateFormat dateFormater = new SimpleDateFormat(dateFormat);
	public static final String CURRENT_USER="currentUser";
	public static final String STATUS_ACTIVE="Active";
	public static final String STATUS_INACTIVE="Inactive";
	public static final String logoPath="html\\images\\logo";
	public static final String PROJECT_NAME = "TrackMe";
	public static final String STUDENT_BULK_TEMPLATE_Path="student\\excel";

	public static final String STUDENT_UPLOAD_PATH = "c:\\temp";
	public static final String ROLE_PARENT = "parent";
	public static final String ROLE_SUPERUSER = "superuser";
	
	public static boolean isObjectNotNullOrNotEmpty(Object obj){
		return obj!=null&&!obj.equals("")?true:false;
	}
}
