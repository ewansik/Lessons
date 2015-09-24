/**
 * Class Triangle.
 */

package Model;

public class Triangle extends Shape{

	//Declaring variables;
	private double a;
	private double h;
	
	/**
	 * Class constructor.
	 * @param a
	 * @param h
	 */
	public Triangle(double a, double h) {
		this.setA(a);
		this.setH(h);
	}
	
	public void setA(double a) {
		this.a = a;
	}

	public void setH(double h) {
		this.h = h;
	}

	@Override
	public void calculateArea() {
		this.setS(0.5 * a * h);
	}
}
