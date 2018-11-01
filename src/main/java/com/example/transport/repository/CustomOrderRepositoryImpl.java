package com.example.transport.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CustomOrderRepositoryImpl implements CustomOrderRepository {

	@Override
	public double calculate(String sourceAddress, String destinationAddress) {
		String key = "AIzaSyDGBhBYu1xbTGMhT-gHUs2evHxmsLdtSsU";
		String s = String.format(
				"https://maps.googleapis.com/maps/api/distancematrix/json?units=metric&origins=%s&destinations=%s&key=%s",
				sourceAddress, destinationAddress);
		try {
			URL url = new URL(s);
			HttpURLConnection yc = (HttpURLConnection) url.openConnection();
			yc.setRequestMethod("GET");
			yc.connect();

			BufferedReader sb = new BufferedReader(new InputStreamReader(yc.getInputStream()));

			String json = sb.toString();
			JSONObject obj = new JSONObject(json);

			double distance = obj.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(0)
					.getJSONObject("distance").getDouble("value");

			sb.close();
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
