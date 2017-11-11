package com.trackme.spring.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;


@Service
public class FirebaseService {

  private static final String FIREBASE_URL = "https://rdfirebase-482f0.firebaseio.com";

  private static final String NOTIFICATIONS = "/notifications/";

  private static final String FIRST_USER = "john-doe";

  private static final String SECOND_USER = "jane-doe";
  
  
  private static final long serialVersionUID = -8022560668279505764L;

  // Method to send Notifications from server to client end.
  public final static String AUTH_KEY_FCM = "AAAANHrAb_w:APA91bGGnsQinoYV5sBBfzkvUshRMtsgxl6-vpEY-lWPFwP7l_Y-tpkfQdqS0hFAfyzJQsSgnS_2T4_p8RgGq5mIc0y3F8P4m_xzUciLZeVVztFLhTxiL2k4QvFSYVVERBdU22knuJ6K";
  public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";
  public final static String DEVICE_ID = "EjvqLd6i43a9lJxId05ilBIIwdf1";



  

public void pushNotification(String deviceKey, String title, String body,String liveTime)  {
	  try{
	  HttpClient client = HttpClientBuilder.create().build();
	  HttpPost post = new HttpPost("https://fcm.googleapis.com/fcm/send");
	  post.setHeader("Content-type", "application/json");
	  post.setHeader("Authorization", "key="+"AAAANHrAb_w:APA91bGGnsQinoYV5sBBfzkvUshRMtsgxl6-vpEY-lWPFwP7l_Y-tpkfQdqS0hFAfyzJQsSgnS_2T4_p8RgGq5mIc0y3F8P4m_xzUciLZeVVztFLhTxiL2k4QvFSYVVERBdU22knuJ6K");

	  JSONObject message = new JSONObject();
	  message.put("to", deviceKey);
	  message.put("priority", "high");

	  JSONObject notification = new JSONObject();
	  notification.put("title", title);
	  notification.put("body", body);

	  message.put("notification", notification);

	  post.setEntity(new StringEntity(message.toString(), "UTF-8"));
	  HttpResponse response = client.execute(post);
	  System.out.println(response);
	  System.out.println(message);  
}catch(Exception e){
	  System.out.println(e.getMessage());
}
}

  public void pushNotification1(String deviceKey, String title, String body,String liveTime) {String DeviceIdKey = DEVICE_ID;
  String authKey = AUTH_KEY_FCM;
  String FMCurl = API_URL_FCM;

  try {
      URL url = new URL(FMCurl);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();

      conn.setUseCaches(false);
      conn.setDoInput(true);
      conn.setDoOutput(true);

      conn.setRequestMethod("POST");
      conn.setRequestProperty("Authorization", "key=" + authKey);
      conn.setRequestProperty("Content-Type", "application/json");
      System.out.println(deviceKey);
      JSONObject data = new JSONObject();
      data.put("to", DeviceIdKey.trim());
      JSONObject info = new JSONObject();
      info.put("title", title); // Notification title
      info.put("body", body); // Notification body
      data.put("data", info);
      System.out.println(data.toString());
      OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
      wr.write(data.toString());
      wr.flush();
      wr.close();

      int responseCode = conn.getResponseCode();
      SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
      System.out.println("Time: "+format.format(new Date())+" $ Response Code : " + responseCode);

      BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();

      while ((inputLine = in.readLine()) != null) {
          response.append(inputLine);
      }
      in.close();

  }
  catch(Exception e)
  {
      System.out.println(e);
  }

  }
}
