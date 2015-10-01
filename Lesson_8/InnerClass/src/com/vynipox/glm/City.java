/**
 * Inner class;
 */

package com.vynipox.glm;

import java.util.ArrayList;
import java.util.List;

public class City {
	//Variable declaration.
	private List<Outer> list = new ArrayList<Outer>();
	
	public List<Outer> getList() {
		return list;
	}

	public void createOuterClass(String parameters)
	{
		list.add(new Outer(parameters));
	}
	
	/**
	 * Outer class.
	 */
	public class Outer{
		
		//Variable declaration.
		private String parameters;
		
		/**
		 * Class constructor.
		 * @param parameters
		 */
		public Outer(String parameters)
		{
			this.setParameters(parameters);
		}
		
		public String getParameters() {
			return parameters;
		}

		public void setParameters(String parameters) {
			this.parameters = parameters;
		}
	}
}
