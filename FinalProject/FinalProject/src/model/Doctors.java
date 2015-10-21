/**
 * Класс Doctors, представляющий собой модель данных.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Doctors {

	//Объявление переменных.
	private int id;
	private String name;
	private String degree;
	private Date dateOfBirth;
	private int yearEperience;
	private List<String> typeList;
	private boolean visible;
	private SimpleDateFormat format;
	
	/**
	 * Конструктор класса Doctors.
	 */
	public Doctors()
	{
		format = new SimpleDateFormat("yyyy-MM-dd");
		typeList = new ArrayList<String>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getYearEperience() {
		return yearEperience;
	}
	public void setYearEperience(int yearEperience) {
		this.yearEperience = yearEperience;
	}
	
	public List<String> getTypeList() {
		return typeList;
	}

	public void setTypeList(String type) {
		this.typeList.add(type);
	}

	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * Переопределение метода hashCOde().
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((degree == null) ? 0 : degree.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((typeList == null) ? 0 : typeList.hashCode());
		result = prime * result + (visible ? 1231 : 1237);
		result = prime * result + yearEperience;
		return result;
	}

	/**
	 * Переопределение метода equals().
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctors other = (Doctors) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (degree == null) {
			if (other.degree != null)
				return false;
		} else if (!degree.equals(other.degree))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (typeList == null) {
			if (other.typeList != null)
				return false;
		} else if (!typeList.equals(other.typeList))
			return false;
		if (visible != other.visible)
			return false;
		if (yearEperience != other.yearEperience)
			return false;
		return true;
	}

	/**
	 * Переопределение метода toString().
	 */
	@Override
	public String toString() {
		return "Доктор - Идентификатор:" + id + ", ФИО:" + name + ", Степень:" + degree + ", День рождение:" + format.format(dateOfBirth)
				+ ", Опыт работы(лет):" + yearEperience + ", Специализация:" + typeList + ", Рабочий день:" + visible + ".";
	}
}
