package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	private final int WIDTH = 1200;
	private final int HEIGHT = 750;
	private final int NO_PANEL = -1;
	private final String APPLICATION_NAME = "Testing";
	
	private JPanel mainPanel;
	private LoginPanel loginPanel;
	private QueryPanel queryPanel;
	private CreatePanel createPanel;
	
	private int currentPanelId;
	
	private static MainFrame instance;
	
	private MainFrame() {
		super();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(WIDTH, HEIGHT);
		this.setTitle(APPLICATION_NAME);
		this.setResizable(false);
		
		this.currentPanelId = NO_PANEL;
		
		this.initMainPanel();
		this.initLoginPanel();
		this.initCreatePanel();
		this.initQueryPanel();
		
		this.showPanel(PanelId.LOGIN_PANEL);
	}
	
	private void initMainPanel() {
		this.mainPanel = (JPanel) this.getContentPane();
		this.mainPanel.setLayout(null);
	}
	
	private void initLoginPanel() {
		this.loginPanel = new LoginPanel();
		this.enablePanel(this.loginPanel);
	}
	
	private void initCreatePanel() {
		this.createPanel = new CreatePanel();
		this.disablePanel(this.createPanel);
	}
	
	private void initQueryPanel() {
		this.queryPanel = new QueryPanel();
		this.disablePanel(this.queryPanel);
	}
	
	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();			
		}
		return instance;
	}

	public JPanel getPanelById(int id) {
		switch (id) {
		case PanelId.MAIN_PANEL: 
			return this.mainPanel; 
		case PanelId.LOGIN_PANEL:
			return this.loginPanel;
		case PanelId.CREATE_PANEL:
			return this.createPanel;
		case PanelId.QUERY_PANEL:
			return this.queryPanel;
		default:
			return null;
		}
	}
	
	public void showPanel(int id) {
		JPanel currentPanel;
		if (this.currentPanelId != NO_PANEL) {
			currentPanel = this.getPanelById(this.currentPanelId);
			this.mainPanel.remove(currentPanel);
			this.disablePanel(currentPanel);
		}
		
		//enable new panel
		currentPanel = this.getPanelById(id);
		this.enablePanel(currentPanel);
		if (currentPanel instanceof Restorable) {
			((Restorable)currentPanel).restoreState();
		}
		
		this.mainPanel.add(currentPanel);		
		currentPanel.setBounds(0, 0, WIDTH, HEIGHT);
	}
	
	public void enablePanel(JPanel panel) {
		panel.setVisible(true);
		panel.setEnabled(true);
	}
	
	public void disablePanel(JPanel panel) {
		panel.setVisible(false);
		panel.setEnabled(false);
	}
		
	public class PanelId {
		public static final int MAIN_PANEL = 0;
		public static final int LOGIN_PANEL = 1;
		public static final int CREATE_PANEL = 2;
		public static final int QUERY_PANEL = 3;
	}
}
