/**
 * SAXPars class.
 */

package manager;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.People;

public class SAXPars extends DefaultHandler{

	//Variables declaration.
	private People people;
	private List<People> list;
	private String element;
	private boolean check = false;
	
	/**
	 * Class constructor.
	 */
	public SAXPars()
	{
		list = new ArrayList<People>();
	}
	
	@Override 
	public void startDocument() throws SAXException 
	{ 
	  System.out.println("Start parsing."); 
	} 		
	
	@Override
	public void endDocument() throws SAXException
	{
		System.out.println("End parsing."); 
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
			case "age":
				check = true;
				people = new People();
				people.setAge(Integer.valueOf(new String(ch,start,length)));
				break;
				
			case "id":
				people.setId(Integer.valueOf(new String(ch,start,length)));
				break;
				
			case "isDegree":
				people.setDegree(Boolean.valueOf(new String(ch,start,length)));
				break;
				
			case "name":
				if(check)
				{	
					people.setName(new String(ch,start,length));
				}
				
				break;
				
			case "surname":
				people.setSurname(new String(ch,start,length));
				list.add(people);
				break;
		}
	}
	
	/**
	 * Get list.
	 * @return
	 */
	public List<People> getList()
	{
		return list;
	}
}
