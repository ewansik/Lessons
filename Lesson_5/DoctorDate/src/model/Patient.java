/**
 * Class patient.
 */

package model;

public class Patient extends Human{
	
	//Declaring variables.
	private int age;
	private String diagnosis;
	
	/**
	 * Class constructor.
	 * @param name
	 * @param lastName
	 * @param age
	 * @param diagnosis
	 */
	public Patient(String name, String lastName, int age, String diagnosis) {
		super(name, lastName);
		
		this.setAge(age);
		this.setDiagnosis(diagnosis);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((diagnosis == null) ? 0 : diagnosis.hashCode());
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
		Patient other = (Patient) obj;
		if (age != other.age)
			return false;
		if (diagnosis == null) {
			if (other.diagnosis != null)
				return false;
		} else if (!diagnosis.equals(other.diagnosis))
			return false;
		return true;
	}
}
