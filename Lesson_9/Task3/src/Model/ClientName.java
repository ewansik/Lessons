/**
 * Client name class.
 */

package Model;

public class ClientName {

	//Variable declaration
	private String name;
	private String lastName;
	private String patronymic;

	/**
	 * Class constructor.
	 * @param name
	 * @param lastName
	 * @param patronymic
	 */
	public ClientName(String name, String lastName, String patronymic)
	{
		this.setName(name);
		this.setLastName(lastName);
		this.setPatronymic(patronymic);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
}
