/**
 * Class Rectangle.
 */

package Model;

public class MyRectangle extends Shape{

	//Declaring variables.
	private double a;
	private double b;
	
	/**
	 * Class constructor.
	 * @param a
	 * @param b
	 */
	public MyRectangle(double a, double b)
	{
		this.setA(a);
		this.setB(b);
	}

	public void setA(double a) {
		this.a = a;
	}

	public void setB(double b) {
		this.b = b;
	}

	@Override
	public void calculateArea() {
		this.setS(a * b);
	}
}
