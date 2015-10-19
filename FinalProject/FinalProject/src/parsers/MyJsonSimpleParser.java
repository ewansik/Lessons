package parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Doctor;
import model.Hospital;

public class MyJsonSimpleParser {

	@SuppressWarnings("unchecked")
	public static Hospital jsonParser(BufferedReader bufferedReader)
	{
		Hospital hospital = new Hospital();
		Doctor doctor;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArray = new JSONArray();
		
		try {
			JSONObject jsonObject = (JSONObject)jsonParser.parse(bufferedReader);
			
			hospital.setName((String)jsonObject.get("name"));
			hospital.setLocation((String)jsonObject.get("location"));
			
			if(jsonObject.containsKey("doctors"))
			{
				jsonArray = (JSONArray)jsonObject.get("doctors");
			}
			else
			{
				System.out.println("You have wrong format of JSON document.");
			}
			
			Iterator<JSONObject> iterator = jsonArray.iterator();
			
			while(iterator.hasNext())
			{
				doctor = new Doctor();
				JSONObject obj = iterator.next();
				
				doctor.setId((int) (long) obj.get("id"));
				doctor.setName((String)obj.get("name"));
				doctor.setDegree((String)obj.get("degree"));
				doctor.setDateOfBirth(format.parse((String)obj.get("dateOfBirth")));
				doctor.setYearEperience((int) (long)obj.get("yearEperience"));
				
				JSONArray typeArray = (JSONArray)obj.get("type");
				
				for(int i = 0; i < typeArray.size();i++)
				{
					doctor.setTypeList((String)typeArray.get(i));
				}
				
				hospital.setList(doctor);
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		} catch (java.text.ParseException e) {
			System.out.println(e.getMessage());
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
		
		return hospital;
	}
}
