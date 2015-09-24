/**
 * Class Square.
 */

package Model;

public class Square extends Shape{

	//Declaring variables.
	private double a;
	
	/**
	 * Class constructor.
	 * @param a
	 */
	public Square(double a)
	{
		this.setA(a);
	}

	public void setA(double a) {
		this.a = a;
	}

	@Override
	public void calculateArea() {
		this.setS(Math.pow(a, 2));
	}
}
