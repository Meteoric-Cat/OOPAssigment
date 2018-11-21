package gui;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel{
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

    public LoginPanel() {
    	this.initComponents();
    	this.arrangeComponents();
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
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(454, 454, 454)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(label2)
                    .addComponent(label3))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfieldAccount, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(pfieldPassword))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(509, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonLogin, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                        .addGap(504, 504, 504))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label1)
                        .addGap(421, 421, 421))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(label1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label2)
                    .addComponent(tfieldAccount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label3)
                    .addComponent(pfieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonLogin)
                .addContainerGap(281, Short.MAX_VALUE))
        );    	
    }
}
