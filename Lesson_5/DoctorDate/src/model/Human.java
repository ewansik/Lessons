/**
 * Super class human.
 */

package model;

public class Human {

	//Declaring variables.
	private String name;
	private String lastName;
	
	/**
	 * Class constructor.
	 * @param name
	 * @param lastName
	 */
	public Human(String name, String lastName)
	{
		this.setName(name);
		this.setLastName(lastName);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		name.toLowerCase();
		name = Character.toString(name.charAt(0)).toUpperCase()+name.substring(1);
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		lastName.toLowerCase();
		lastName = Character.toString(lastName.charAt(0)).toUpperCase()+lastName.substring(1);
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Human other = (Human) obj;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
