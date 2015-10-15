package com.vynipox.glm;

import constants.MyConstants;
import manager.ManagerJson;

import model.Hospital;


public class Main {

	public static void main(String[] args) {
		Hospital hospital;
		ManagerJson manager = new ManagerJson(MyConstants.JSON_URL);
		manager.start();
		
		try {
			manager.join();
			hospital = manager.getHospital();
			System.out.println(hospital.getName());
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
