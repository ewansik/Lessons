/**
 * Abstract class Shape;
 */

package Model;

public abstract class Shape {

	//Declaring variables;
	private double s;
	
	public double getS() {
		return s;
	}

	public void setS(double s) {
		this.s = s;
	}
	
	/**
	 * Abstract method for calculating shape area.
	 */
	public abstract void calculateArea();
}
