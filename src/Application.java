import gui.MainFrame;
import helper.DatabaseHelper;

public class Application {

	public static void main(String[] args) {
		//System.out.println("hello world");
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try {
					DatabaseHelper.getInstance().closeDriver();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		MainFrame.getInstance().setVisible(true);
	}

}
