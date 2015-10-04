/**
 * Manager class.
 */

package Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import Model.ClientName;

public class Manager {

	//Variable declaration.
	private String[] menNames = {"Greg","Pol","Aron"};
	private String[] womenNames = {"Suzan","Natali","Katrin"};
	private String[] lastNames = {"Vasilenko", "Korshun","Lashkevich","Klaksa"};
	private String[] womenpatronymics = {"Olegovna","Petrovna","Sergeevna"};
	private String[] menPatronymics = {"Olegovich","Petrovich","Sergeevich"};
	private String[] sex = {"man","woman"};
	
	private Random random;
	
	private List<ClientName> menList;
	private List<ClientName> womenList;
	
	private Map<String, List<ClientName>> map;
	
	/**
	 * Class constructor.
	 */
	public Manager()
	{
		random = new Random();
		
		menList = new ArrayList<ClientName>();
		womenList = new ArrayList<ClientName>();
		
		map = new HashMap<String, List<ClientName>>();
	}
	
	/**
	 * Method for creating new customers.
	 * @param name
	 * @param lastName
	 * @param patronymic
	 * @param sex
	 */
	public void createClient(String name, String lastName, String patronymic, String sex)
	{
		ClientName clientName = new ClientName(name, lastName, patronymic);	
		if(sex == this.sex[0])
		{
			menList.add(clientName);
			map.put(sex, menList);
		}
		else
		{
			womenList.add(clientName);
			map.put(sex, womenList);
		}
	}
	
	/**
	 * Method for creating new random men customers.
	 */
	public void createRandomManClient()
	{
		this.createClient(this.randomizeString(menNames), this.randomizeString(lastNames), this.randomizeString(menPatronymics),sex[0]);
	}
	
	/**
	 * Method for creating new random woman customers.
	 */
	public void createRandomWomanClient()
	{
		this.createClient(this.randomizeString(womenNames), this.randomizeString(lastNames), this.randomizeString(womenpatronymics),sex[1]);
	}
	
	/**
	 * Randomizer.
	 * @param strings
	 * @return
	 */
	public String randomizeString(String[] strings)
	{	
		return strings[random.nextInt(strings.length)];
	}
	
	/**
	 * Method for getting random customer.
	 * @param sex
	 */
	public void getClients(String sex)
	{
		ClientName clientName; 
		for (Entry<String, List<ClientName>> entry : map.entrySet() ) {
			if(entry.getKey().equals(sex))
			{
				clientName = entry.getValue().get(random.nextInt(entry.getValue().size()));
				
				System.out.printf("Client %s:",sex);
				System.out.printf("Name - %s, Last name - %s, Patronymic - %s\n",clientName.getName(),clientName.getLastName(),clientName.getPatronymic());
				System.out.println("-----------------------------------------------------------------------------------------------------------");
				break;
			}	
		}
	}
}
