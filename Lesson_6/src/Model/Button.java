/**
 * Button class.
 */

package Model;

public class Button {

	//Declaring variable.
	private IÑlick click;

	public IÑlick getClick() {
		return click;
	}

	public void setClick(IÑlick click) {
		this.click = click;
		System.out.println("Set click");
	}
	
	public void test()
	{
		click.onClick();
		System.out.println("Test");
	}
}
