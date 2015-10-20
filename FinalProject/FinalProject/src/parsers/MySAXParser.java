package parsers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.Doctors;
import model.Hospital;

public class MySAXParser extends DefaultHandler{

	private String element;
	boolean check = false;
	boolean checkType = false;
	private Doctors doctor;
	private SimpleDateFormat format;
	private Hospital hospital;

	public MySAXParser()
	{
		format = new SimpleDateFormat("yyyy-MM-dd");
		hospital = new Hospital();
	}
	
	@Override
	public void startElement(String namespace, String localName, String qName, Attributes attr) throws SAXException
	{
		element = qName;
	}
	
	@Override
	public void endElement(String namespace, String localName, String qName) throws SAXException
	{
		element = "";
	}
	
	@Override 
	public void characters(char[] ch,int start,int length) throws SAXException
	{
		switch(element)
		{
			case "location":
				hospital.setLocation(new String(ch,start,length));
				break;
				
			case "id":
				check = true;
				doctor = new Doctors();
				doctor.setId(Integer.valueOf(new String(ch,start,length)));
				break;
				
			case "name":
				if(check)
				{
					doctor.setName(new String(ch,start,length));
				}
				else
				{
					hospital.setName(new String(ch,start,length));
				}
				break;
				
			case "degree":
				doctor.setDegree(new String(ch,start,length));
				break;
				
			case "dateOfBirth":
				try
				{
					doctor.setDateOfBirth(format.parse(new String(ch,start,length)));
				} 
				catch (ParseException e) 
				{
					System.out.println(e.getMessage());
				}
				break;
				
			case "yearEperience":
				doctor.setYearEperience(Integer.valueOf(new String(ch,start,length)));
				break;
				
			case "type":
				doctor.setTypeList(new String(ch,start,length));
				break;
				
			case "visible":
				doctor.setVisible(Boolean.valueOf(new String(ch,start,length)));
				hospital.setList(doctor);
				break;
		}
	}

	public Hospital getHospital()
	{
		return hospital;
	}
}
