package com.goeuro.csv;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
//import java.util.ArrayList;
import java.util.Iterator;


import org.json.JSONArray;
import org.json.JSONObject;

public class CreateCSV {

	private static final String API_URL = "http://api.goeuro.com/api/v2/position/suggest/en/";
	
	private static final String FILE_NAME = "locations.csv";
	private static final String CSV_HEADER = " _id, name, type, latitude, longitude";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	
	private static final String EMPTY_CITY_NAME = "Please Enter Valid City Name";
	private static final String NO_MATCHES_FOUND = "No Matches Found!";
	private static final String INVALID_CITY_NAME_OR_INPUT = "Invalid city name or input!";
	

	
	public static void main(String[] args) throws IOException{
		
		String cityName = args[0];
		String apiURL = API_URL;
	
		if(cityName == null || cityName.trim().length() == 0){
			System.out.println(EMPTY_CITY_NAME);
			return;
		}		
		
		apiURL = apiURL + URLEncoder.encode(cityName, "UTF-8").replace("+", "%20");
		
		String response = getCitiesJSONResponse(apiURL);
		if(response.trim().length() == 0){
			System.out.println(NO_MATCHES_FOUND);
			return;			
		}
		
		JSONArray jsonArray = new JSONArray(response); 
		
		if(jsonArray.length() > 0){
			
			FileWriter fileWriter = null;
			fileWriter = new FileWriter(FILE_NAME);
			fileWriter.append(CSV_HEADER);
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			Iterator itr = jsonArray.iterator();
			
			//ArrayList<Location> locations = new ArrayList<Location>();
			while(itr.hasNext()){
				
				JSONObject cityJSONObject = (JSONObject) itr.next(); 
				JSONObject geoPositionJSONObject = cityJSONObject.getJSONObject("geo_position");
				
				Location location = new Location();
				location.set_id(cityJSONObject.getInt("_id"));
				location.setName(cityJSONObject.getString("name"));
				location.setType(cityJSONObject.getString("type"));
				location.setLatitude(geoPositionJSONObject.getDouble("latitude"));
				location.setLongitude(geoPositionJSONObject.getDouble("longitude"));
				
				//locations.add(location);
				
				fileWriter.append(location.toString());
				fileWriter.append(NEW_LINE_SEPARATOR);
			}	
			fileWriter.flush();
		    fileWriter.close();
		}else{
			System.out.println(NO_MATCHES_FOUND);			
		}				
			
	}
	
	public static String getCitiesJSONResponse(String url) throws MalformedURLException{
	   //Using StringBuilder instead of String as the latter is immutable and costs memory
	   StringBuilder response = new StringBuilder("");		
	   try {
			URL apiURLObj;
			apiURLObj = new URL(url);		
			InputStreamReader in = new InputStreamReader(apiURLObj.openStream());
			BufferedReader br = new BufferedReader(in);
			String nextLine = "";
			while((nextLine = br.readLine()) != null){
				response.append(nextLine);			
			}
		} catch (Exception e) {
			System.out.println(INVALID_CITY_NAME_OR_INPUT);			
		}
		
		return response.toString();
		
	}
	
	
}
