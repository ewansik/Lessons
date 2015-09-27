/**
 * ScreenView class.
 */

package Model;

public class ScreenView implements IÑlick{

	@Override
	public void onClick() {
		System.out.println("On click");
	}

	/**
	 * Method showUI.
	 */
	public void showUI()
	{
		Button button = new Button();
		
		button.setClick(this);
		
		button.test();
		
		System.out.println("Show UI");
	}
}
