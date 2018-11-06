package com.example.transport.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomOrderRepositoryImpl implements CustomOrderRepository {

	@Override
	public double calculate(String sourceAddress, String destinationAddress) {

		String key = "XXX";
		String s = String.format(
				"http://www.mapquestapi.com/directions/v2/routematrix?key=%s",
				key);
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		
		
		
		
		// wysłać JSON
		
		// odczytać odebraną odpowiedź
		
		
//		ObjectNode locationsJson = mapper.createObjectNode();
//
//		ArrayNode locationsArray = mapper.createArrayNode();
//		locationsArray.add(sourceAddress + ", Polska");
//		locationsArray.add(destinationAddress + ", Polska");
//
//		locationsJson.putPOJO("locations", locationsArray);

//		System.out.println(locationsJson.toString());

		try {
			String temp = String.format(
					"{ \"locations\": [%s+ \", Polska\",%s+ \", Polska\"] }",
					sourceAddress, destinationAddress);
			JSONObject locationsJson = new JSONObject(temp);
			
			
			URL url = new URL(s);
			HttpURLConnection yc = (HttpURLConnection) url.openConnection();
			yc.setRequestMethod("GET");
			yc.connect();

			Scanner scan = new Scanner(url.openStream());
		    String str = new String();
		    while (scan.hasNext())
		        str += scan.nextLine();
		    scan.close();
		    
//			BufferedReader sb = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		    JSONObject json = new JSONObject(str);
			
			

			double distance = json.getJSONArray("distance").getDouble(1);
			
			//sb.close();
			return distance;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
