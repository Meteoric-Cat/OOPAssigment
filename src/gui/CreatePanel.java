package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CreatePanel extends JPanel implements Restorable{
	private final int MIN_NUMBER = 0;
	private final int MAX_NUMBER = 10000;
	private final int MIN_DAY = 1;
	private final int MAX_DAY = 31;
	private final int MIN_MONTH = 1;
	private final int MAX_MONTH = 12;
	private final int MIN_YEAR = 0;
	private final int MAX_YEAR = Integer.MAX_VALUE;
	
	private Font fontLabel1 = new Font("Tahoma", 1, 24);
	private Font fontLabel2 = new Font("Tahoma", 1, 18);
	private Font fontLabel3 = new Font("Tahoma", 0, 18);
	private Font fontField = new Font("Tahoma", 0, 18);
	private Font fontButton = new Font("Tahoma", 1, 18);
	private Font fontSpinner = new Font("Tahoma", 1, 18);
	private Font fontCBox = new Font("Tahoma", 0, 18);
	
	private final String[] entityType = {"Location", "Organization", "Country", "Person", "Event"};
	
    private JButton buttonECreate;
    private JButton buttonEDelete;
    private JButton buttonRCreate;
    private JButton buttonRDelete;
    private JButton buttonLogout;
    private JButton buttonQuery;
    private JComboBox<String> cboxE1Type;
    private JComboBox<String> cboxE2Type;
    private JComboBox<String> cboxType;
    private JLabel label1;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JLabel label16;
    private JLabel label17;
    private JLabel label18;
    private JLabel label19;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JPanel panelChild;
    private JSpinner spinnerDay;
    private JSpinner spinnerE1Number;
    private JSpinner spinnerE2Number;
    private JSpinner spinnerENumber;
    private JSpinner spinnerMonth;
    private JSpinner spinnerYear;
    private JTextField tfieldDiscription;
    private JTextField tfieldE1Identifier;
    private JTextField tfieldE2Identifier;
    private JTextField tfieldIdentifier;
    private JTextField tfieldLabel;
    private JTextField tfieldLink;
    private JTextField tfieldRelationship;   
    
    private MouseAdapter mAdapterButton;
    private ChangeListener cListenerSpinner;

    public CreatePanel() {
    	this.initComponents();
    	this.arrangeComponents();
    	this.initListeners();
    	this.addListeners();
    }
    
    private void initComponents() {
        label1 = new JLabel();
        label2 = new JLabel();
        tfieldIdentifier = new JTextField();
        label3 = new JLabel();
        tfieldLabel = new JTextField();
        label4 = new JLabel();
        tfieldDiscription = new JTextField();
        label5 = new JLabel();
        cboxType = new JComboBox<>();
        label6 = new JLabel();
        label7 = new JLabel();
        tfieldLink = new JTextField();
        label8 = new JLabel();
        buttonECreate = new JButton();
        buttonEDelete = new JButton();
        label9 = new JLabel();
        spinnerENumber = new JSpinner();
        spinnerDay = new JSpinner();
        spinnerMonth = new JSpinner();
        spinnerYear = new JSpinner();
        panelChild = new JPanel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        tfieldE1Identifier = new JTextField();
        label13 = new JLabel();
        cboxE1Type = new JComboBox<>();
        label14 = new JLabel();
        spinnerE1Number = new JSpinner();
        label15 = new JLabel();
        tfieldRelationship = new JTextField();
        label16 = new JLabel();
        label17 = new JLabel();
        tfieldE2Identifier = new javax.swing.JTextField();
        label18 = new JLabel();
        cboxE2Type = new JComboBox<>();
        label19 = new JLabel();
        spinnerE2Number = new JSpinner();
        buttonRCreate = new JButton();
        buttonRDelete = new JButton();
        buttonLogout = new JButton();
        buttonQuery = new JButton();
        
        
        this.label1.setFont(fontLabel1);
        this.label1.setText("Entity information");        
        this.label2.setFont(fontLabel3);
        this.label2.setText("Identifier:");        
        this.label3.setFont(fontLabel3);
        this.label3.setText("Label:");        
        this.label4.setFont(fontLabel3);
        this.label4.setText("Discription:");        
        this.label5.setFont(fontLabel3);
        this.label5.setText("Type:");        
        this.label6.setFont(fontLabel3);
        this.label6.setText("Origin:");        
        this.label7.setFont(fontLabel3);
        this.label7.setText("Link:");        
        this.label8.setFont(fontLabel3);
        this.label8.setText("Time:");        
        this.label9.setFont(fontLabel3);
        this.label9.setText("Number:");
        
        this.label10.setFont(fontLabel1);
        this.label10.setText("Relationship information");        
        this.label11.setFont(fontLabel2);
        this.label11.setText("Entity 1:");        
        this.label12.setFont(fontLabel3);
        this.label12.setText("Identifier:");        
        this.label13.setFont(fontLabel3);
        this.label13.setText("Type:");        
        this.label14.setFont(fontLabel3);
        this.label14.setText("Number:");        
        this.label15.setFont(fontLabel2);
        this.label15.setText("Relationship:");        
        this.label16.setFont(fontLabel2);
        this.label16.setText("Entity 2:");        
        this.label17.setFont(fontLabel3);
        this.label17.setText("Identifier");        
        this.label18.setFont(fontLabel3);
        this.label18.setText("Type:");        
        this.label19.setFont(fontLabel3);
        this.label19.setText("Number");
        
                
        this.spinnerENumber.setFont(fontSpinner);
        this.spinnerDay.setFont(fontSpinner);
        this.spinnerMonth.setFont(fontSpinner);
        this.spinnerYear.setFont(fontSpinner);
        
        this.spinnerE1Number.setFont(fontSpinner);
        this.spinnerE2Number.setFont(fontSpinner);        
        
        this.buttonECreate.setFont(fontButton);
        this.buttonECreate.setText("Create");
        this.buttonEDelete.setFont(fontButton);
        this.buttonEDelete.setText("Delete");
        
        this.buttonRCreate.setFont(fontButton);
        this.buttonECreate.setText("Create");
        this.buttonRDelete.setFont(fontButton);
        this.buttonRDelete.setText("Delete");
        this.buttonLogout.setFont(fontButton);
        this.buttonLogout.setText("Log out");
        this.buttonQuery.setFont(fontButton);
        this.buttonQuery.setText("Query");
        
        this.cboxType.setFont(fontCBox);
        this.cboxType.setModel(new DefaultComboBoxModel<>(this.entityType));
        
        this.cboxE1Type.setFont(fontCBox);
        this.cboxE1Type.setModel(new DefaultComboBoxModel<>(this.entityType));
        this.cboxE2Type.setFont(fontCBox);
        this.cboxE2Type.setModel(new DefaultComboBoxModel<>(this.entityType));
        
        Dimension tempSize = new Dimension(459, 63);
        this.panelChild.setPreferredSize(tempSize);
        this.panelChild.setSize(tempSize);;
        this.panelChild.setLayout(null);
        
        this.tfieldDiscription.setFont(fontField);
        this.tfieldIdentifier.setFont(fontField);
        this.tfieldLabel.setFont(fontField);
        this.tfieldLink.setFont(fontField);
        this.tfieldRelationship.setFont(fontField);        
        
        this.tfieldE1Identifier.setFont(fontField);
        this.tfieldE2Identifier.setFont(fontField);        
    }
    
    private void arrangeComponents() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label10)
                            .addComponent(label1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonLogout)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label2)
                                    .addComponent(label3)
                                    .addComponent(label4)
                                    .addComponent(label5)
                                    .addComponent(label9))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfieldIdentifier)
                                            .addComponent(tfieldLabel)
                                            .addComponent(tfieldDiscription, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                                            .addComponent(cboxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(48, 48, 48)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(label6)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(label7)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(tfieldLink, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(buttonECreate)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonEDelete))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(label8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(spinnerDay, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(23, 23, 23)
                                                .addComponent(spinnerMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(spinnerYear, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(spinnerENumber, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(732, 732, 732)
                            .addComponent(buttonRCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                            .addComponent(buttonRDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(183, 183, 183)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label15)
                                        .addComponent(label11)
                                        .addComponent(label16)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label12, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(label17, javax.swing.GroupLayout.Alignment.TRAILING))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfieldE1Identifier)
                                .addComponent(tfieldRelationship)
                                .addComponent(tfieldE2Identifier, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cboxE1Type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cboxE2Type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label19)
                                .addComponent(label14))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(spinnerE1Number, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(spinnerE2Number, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(label1)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label5)
                    .addComponent(cboxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label2)
                    .addComponent(tfieldIdentifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label7)
                    .addComponent(tfieldLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label3)
                    .addComponent(tfieldLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label8)
                    .addComponent(spinnerDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfieldDiscription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonECreate)
                        .addComponent(buttonEDelete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label9)
                    .addComponent(spinnerENumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label10)
                        .addGap(18, 18, 18)
                        .addComponent(label11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label12)
                            .addComponent(tfieldE1Identifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label13)
                            .addComponent(cboxE1Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label14)
                            .addComponent(spinnerE1Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(label15))
                    .addComponent(tfieldRelationship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(label16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label17)
                    .addComponent(tfieldE2Identifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label18)
                    .addComponent(cboxE2Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label19)
                    .addComponent(spinnerE2Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRCreate)
                    .addComponent(buttonRDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLogout)
                    .addComponent(buttonQuery))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(label1)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label5)
                    .addComponent(cboxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label2)
                    .addComponent(tfieldIdentifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label7)
                    .addComponent(tfieldLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label3)
                    .addComponent(tfieldLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label8)
                    .addComponent(spinnerDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfieldDiscription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonECreate)
                        .addComponent(buttonEDelete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label9)
                    .addComponent(spinnerENumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label10)
                        .addGap(18, 18, 18)
                        .addComponent(label11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label12)
                            .addComponent(tfieldE1Identifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label13)
                            .addComponent(cboxE1Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label14)
                            .addComponent(spinnerE1Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(label15))
                    .addComponent(tfieldRelationship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(label16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label17)
                    .addComponent(tfieldE2Identifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label18)
                    .addComponent(cboxE2Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label19)
                    .addComponent(spinnerE2Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRCreate)
                    .addComponent(buttonRDelete))
                .addContainerGap(86, Short.MAX_VALUE))
        );    	
    }

    private void initListeners() {
    	this.mAdapterButton = new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent event) {
    			JButton source = (JButton) event.getSource();
    			
    			if (source == CreatePanel.this.buttonLogout) {
    				//close current driver;
    				
    				MainFrame.getInstance().showPanel(MainFrame.PanelId.LOGIN_PANEL);
    				return;    				
    			}
    			
    			if (source == CreatePanel.this.buttonQuery) {
    				MainFrame.getInstance().showPanel(MainFrame.PanelId.QUERY_PANEL);
    				return;
    			}

    			if (source == CreatePanel.this.buttonECreate) {
    				
    			} 
    			if (source == CreatePanel.this.buttonEDelete) {
    				
    			}
    			if (source == CreatePanel.this.buttonRCreate) {
    				
    			}
    			if (source == CreatePanel.this.buttonRDelete) {
    				
    			}
    			//Query ...
    		}
    	};
    	
    	this.cListenerSpinner = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				// TODO Auto-generated method stub
				JSpinner source = (JSpinner) event.getSource();
				
				if (source == CreatePanel.this.spinnerENumber ||
						source == CreatePanel.this.spinnerE1Number || 
							source == CreatePanel.this.spinnerE2Number) {
					CreatePanel.this.adjustSpinner(source,
							CreatePanel.this.MIN_NUMBER,
							CreatePanel.this.MAX_NUMBER);
				}
				
				if (source == CreatePanel.this.spinnerDay) {
					CreatePanel.this.adjustSpinner(source,
							CreatePanel.this.MIN_DAY,
							CreatePanel.this.MAX_DAY);					
				}
				if (source == CreatePanel.this.spinnerMonth) {
					CreatePanel.this.adjustSpinner(source,
							CreatePanel.this.MIN_MONTH,
							CreatePanel.this.MAX_MONTH);
				}
				if (source == CreatePanel.this.spinnerYear) {
					CreatePanel.this.adjustSpinner(source,
							CreatePanel.this.MIN_YEAR,
							CreatePanel.this.MAX_YEAR);
				}
			}    		
    	};
    }    	
    
    public void adjustSpinner(JSpinner spinner, int minValue, int maxValue) {
    	int value = (int) spinner.getValue();
    	value = Math.max(minValue, value);
    	value = Math.min(maxValue, value);
    	spinner.setValue(value);
    }
    
    public void addListeners() {
    	this.buttonECreate.addMouseListener(this.mAdapterButton);
    	this.buttonEDelete.addMouseListener(this.mAdapterButton);
    	this.buttonRCreate.addMouseListener(this.mAdapterButton);
    	this.buttonRDelete.addMouseListener(this.mAdapterButton);
    	this.buttonQuery.addMouseListener(this.mAdapterButton);
    	this.buttonLogout.addMouseListener(this.mAdapterButton);
    	
    	this.spinnerDay.addChangeListener(this.cListenerSpinner);
    	this.spinnerMonth.addChangeListener(this.cListenerSpinner);
    	this.spinnerYear.addChangeListener(this.cListenerSpinner);
    	this.spinnerE1Number.addChangeListener(this.cListenerSpinner);
    	this.spinnerE2Number.addChangeListener(this.cListenerSpinner);
    	this.spinnerENumber.addChangeListener(this.cListenerSpinner);
    }
    
    public void restoreState() {
    	String initialFieldValue = "";
    	int initialSpinnerValue = 1;
    	
    	this.tfieldDiscription.setText(initialFieldValue);
    	this.tfieldIdentifier.setText(initialFieldValue);
    	this.tfieldLabel.setText(initialFieldValue);
    	this.tfieldLink.setText(initialFieldValue);
    	this.spinnerENumber.setValue(initialSpinnerValue);
    	this.spinnerDay.setValue(initialSpinnerValue);
    	this.spinnerMonth.setValue(initialSpinnerValue);
    	this.spinnerYear.setValue(initialSpinnerValue);
    	
    	this.tfieldE1Identifier.setText(initialFieldValue);
    	this.tfieldE2Identifier.setText(initialFieldValue);
    	this.tfieldRelationship.setText(initialFieldValue);
    	this.spinnerE1Number.setValue(initialSpinnerValue);
    	this.spinnerE2Number.setValue(initialSpinnerValue);
    }
}
