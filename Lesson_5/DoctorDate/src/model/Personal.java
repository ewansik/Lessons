/**
 * Class personal.
 */

package model;

public class Personal extends Human{

	//Declaring variables.
	private String position;
	
	/**
	 * Class constructor.
	 * @param name
	 * @param lastName
	 * @param position
	 */
	public Personal(String name, String lastName,String position) {
		super(name, lastName);
		
		this.setPosition(position);
		
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personal other = (Personal) obj;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}
	
	
}
