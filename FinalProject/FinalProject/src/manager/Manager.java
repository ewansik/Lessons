/**
 * Класс Manager. Содержит необходимые методы для реализации парсинга файлов.
 */

package manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import factory.ParserFactory;
import model.Doctors;
import model.Hospital;
import thread.MyThread;

public class Manager {

	//Объявление переменных.
	private Hospital hospital;
	
	/**
	 * Private конструктор класса Manager. 
	 */
	private Manager(){}

	/**
	 * Метод getParser(). Необходим для получения эеземпляра класса MyThread, в зависимости от заданного параметра.
	 * @param typeOfParsing
	 */
	public void getParser(String typeOfParsing)
	{
		this.startParsing(ParserFactory.getParser(typeOfParsing));
	}
	
	/**
	 * Метод startParsing() реализует запуск парсинга файла в отдельном потоке.
	 * @param myThread
	 */
	public void startParsing(MyThread myThread)
	{
		myThread.start();
		System.out.println("Парсер запущен...");
		
		try {
			myThread.join();
			this.setHospital(myThread.getHospital());
			System.out.println("Парсер завершил работу. Теперь вы можете приступить к работе с полученными данными.");
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Метод viewDoctors(). Необходим для просмотро всех докторов в больнице. 
	 */
	public void viewDoctors()
	{
		List<Doctors> list = hospital.getList();
		System.out.println();
		System.out.println("Наши доктора:");
		
		for (Doctors doctors : list) {
			System.out.println(doctors.toString());
		}
	}
	
	/**
	 * Метод findCoordinates() необходим для поиска и вывода информации о больнице.
	 */
	public void findCoordinates()
	{
		System.out.println();
		System.out.printf("Наша больница находится в городе %s. Название больницы: %s.", hospital.getLocation(), hospital.getName());
		System.out.println();
	}
	
	/**
	 * Метод findDoctor() реализует поиск доктора по заданной специализации.
	 * Поиск осуществлен на подобии оператора like, используемого в запросах SQL.
	 * @param Specialization
	 */
	public void findDoctor(String Specialization)
	{
		List<Doctors> list = hospital.getList();
		List<String> specializations = new ArrayList<String>();
		
		System.out.println();
		System.out.println("По вашему запросу найдены:");
		
		for (Doctors doctors : list) {
			
			specializations = doctors.getTypeList();
			for (String string : specializations) {
				if(string.toLowerCase().matches("^.*"+ Specialization.toLowerCase() +".*"))
				{
					System.out.println(doctors.toString());
				}
			}
		}
	}
	
	/**
	 * Метод comparator(). Реализует вызов необходимых классов сортировки по заданному параметру.
	 * @param type
	 */
	public void comparator(String type)
	{
		String message = "";
		List<Doctors> doctors = hospital.getList();
		if(type.equals("1")){
			message = "Доктора, отсортированные по опыту:";
			Collections.sort(doctors,new CompareExperience());
		}
		else if(type.equals("2")){
			message = "Доктора, отсортированные по имени:";
			Collections.sort(doctors,new CompareName());
		}
		
		System.out.println();
		System.out.println(message);
		for (Doctors doctor : doctors) {
			System.out.println(doctor.toString());
		}
	}
	
	/**
	 * Внутренний статический класс CompareName наследуемый от интерфейса Comparator<T>.
	 * @author gleb.maliborsky
	 *
	 */
	static class CompareName implements Comparator<Doctors>
	{
		/**
		 * Переопределенный метод compare(). Реализует сравнение объектов по имени и фамилии, если это необходимо.
		 */
		@Override
		public int compare(Doctors o1, Doctors o2) {
			String fullName1 = o1.getName();
			String fullName2 = o2.getName();
			String name1 = fullName1.substring(0, fullName1.indexOf(" "));
			String name2 = fullName2.substring(0, fullName2.indexOf(" "));
			
			//Если имена у докторов одинаковые, то сравнеие будет происходить по фамилии.
			if(name1.compareTo(name2) == 0)
			{
				String lastName1 = fullName1.substring(fullName1.indexOf(" "), fullName1.length());
				String lastName2 = fullName2.substring(fullName2.indexOf(" "), fullName2.length());
				
				return lastName1.compareTo(lastName2);
			}
			
			return name1.compareTo(name2);
		}
	}
	
	/**
	 * Внутренний статический класс CompareExperience наследуемый от интерфейса Comparator<T>.
	 * @author gleb.maliborsky
	 *
	 */
	static class CompareExperience implements Comparator<Doctors>
	{
		/**
		 * Переопределенный метод compare(). Реализует сравнение объектов по опыту.
		 */
		@Override
		public int compare(Doctors o1, Doctors o2) {
			int experience1 = o1.getYearEperience();
			int experience2 = o2.getYearEperience();
			
			if(experience1 > experience2){
				return 1;
			}
			else if(experience1 == experience2){
				return 0;
			}
			else{
				return -1;
			}
		}
	}
	
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}	
	
	public Hospital getHospital() {
		return hospital;
	}
	

	/**
	 * Статический класс SingletonHolder. Содержит статическую переменную, в которой хранится экземпляр класса Manager.
	 * @author gleb.maliborsky
	 *
	 */
	private static class SingletonHolder
	{
		private final static Manager INSTANCE = new Manager();
	}
	
	/**
	 * Метод getInstance() возвращает экземпляр класса Manager.
	 * @return
	 */
	public static Manager getInstance()
	{
		return SingletonHolder.INSTANCE;
	}
}
