/**
 * Class doctor.
 */

package model;

import java.util.Calendar;

public class Doctor extends Human{

	//Declaring variables.
	private int cabinet;
	private String specialization;
	private Calendar calendar;
	/**
	 * Class constructor.
	 * @param name
	 * @param lastName
	 * @param cabinet
	 * @param specialization
	 */
	public Doctor(String name, String lastName, int cabinet, String specialization, Calendar calendar) {
		super(name, lastName);
		
		this.setCalendar(calendar);
		this.setCabinet(cabinet);
		this.setSpecialization(specialization);
	}

	public int getCabinet() {
		return cabinet;
	}

	public void setCabinet(int cabinet) {
		this.cabinet = cabinet;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
	
		this.calendar = calendar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + cabinet;
		result = prime * result + ((specialization == null) ? 0 : specialization.hashCode());
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
		Doctor other = (Doctor) obj;
		if (cabinet != other.cabinet)
			return false;
		if (specialization == null) {
			if (other.specialization != null)
				return false;
		} else if (!specialization.equals(other.specialization))
			return false;
		return true;
	}
}


