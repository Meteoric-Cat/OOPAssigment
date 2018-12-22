package gui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import helper.DatabaseHelper;

public class LoginPanel extends JPanel{
	//private final String LOGIN_ERROR = "Invalid account";
	
	private Font fontLabel1 = new Font("Tahoma", 1, 36);
	private Font fontLabel2 = new Font("Tahoma", 0, 18);
	private Font fontButton = new Font("Tahoma", 1, 18);
	private Font fontField = new Font("Tahoma", 0, 18);
	
    private JButton buttonLogin;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JPasswordField pfieldPassword;
    private JTextField tfieldAccount;

    private MouseAdapter mAdapterButton;
    
    public LoginPanel() {
    	this.initComponents();
    	this.arrangeComponents();
    	this.initListeners();
    	this.addListeners();
    }
    
    private void initComponents() {
        this.label1 = new JLabel();
        this.label2 = new JLabel();
        this.tfieldAccount = new JTextField();
        this.label3 = new JLabel();
        this.buttonLogin = new JButton();
        this.pfieldPassword = new JPasswordField();
        
        this.label1.setFont(fontLabel1);
        this.label1.setText("HELLO WORLD");
        
        this.label2.setFont(fontLabel2);
        this.label2.setText("Account:");
        
        this.label3.setFont(fontLabel2);
        this.label3.setText("Password:");
        
        this.tfieldAccount.setFont(fontField);
        this.pfieldPassword.setFont(fontField);
        
        this.buttonLogin.setFont(fontButton);
        this.buttonLogin.setText("Log in");      
        
    }
    
    private void arrangeComponents() {
        setLayout(null);

        add(label1);
        label1.setBounds(509, 274, 270, 44);

        add(label2);
        label2.setBounds(454, 349, 69, 22);

        add(tfieldAccount);
        tfieldAccount.setBounds(565, 346, 268, 28);

        add(label3);
        label3.setBounds(454, 395, 80, 22);

        add(buttonLogin);
        buttonLogin.setBounds(594, 438, 102, 31);

        add(pfieldPassword);
        pfieldPassword.setBounds(565, 392, 268, 28);
    }
    
    private void initListeners() {
    	this.mAdapterButton = new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent event) {
    			JButton source = (JButton) event.getSource();
    			
    			if (source == LoginPanel.this.buttonLogin) {
    				//check login then swap to query panel
    				try {
						DatabaseHelper.getInstance().createDriver(
								LoginPanel.this.tfieldAccount.getText(),
								String.valueOf(LoginPanel.this.pfieldPassword.getPassword())
								);
																		
						MainFrame.getInstance().showPanel(MainFrame.PanelId.QUERY_PANEL);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();					
						JOptionPane.showMessageDialog(null, MainFrame.getInstance().LOGIN_ERROR);
					}
    			}
    		}
    	};   	
    }
    
    private void addListeners() {
    	this.buttonLogin.addMouseListener(this.mAdapterButton);
    }
}
