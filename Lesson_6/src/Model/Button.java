/**
 * Button class.
 */

package Model;

public class Button {

	//Declaring variable.
	private I�lick click;

	public I�lick getClick() {
		return click;
	}

	public void setClick(I�lick click) {
		this.click = click;
		System.out.println("Set click");
	}
	
	public void test()
	{
		click.onClick();
		System.out.println("Test");
	}
}
