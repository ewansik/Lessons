/**
 * Class Circle.
 */

package Model;

public class Circle extends Shape{

	//Declaring variables.
	private final double p = 3.14;
	private double r;
	
	/**
	 * Class constructor.
	 * @param r
	 */
	public Circle(double r)
	{
		this.setR(r);
	}

	public void setR(double r) {
		this.r = r;
	}
	
	@Override
	public void calculateArea() {
		setS(p* Math.pow(r, 2));
	}
}
