package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import helper.DatabaseHelper;
import helper.EntityFactory;
import model.EntityRelationShipManager;
import model.MainEntity;
import model.Origin;
import model.Relationship;

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
    private JSpinner spinnerDay;
    private JSpinner spinnerRNumber;
    private JSpinner spinnerENumber;
    private JSpinner spinnerMonth;
    private JSpinner spinnerYear;
    private JTextField tfieldDescription;
    private JTextField tfieldE1Identifier;
    private JTextField tfieldE2Identifier;
    private JTextField tfieldIdentifier;
    private JTextField tfieldLabel;
    private JTextField tfieldLink;
    private JTextField tfieldRelationship;
    
    private JToggleButton buttonLinkPlus;
    
    private JPanel panelChild;
    private JLabel labelSP;
    private JTextField tfieldSP;
    
    private JPanel panelALink1;
    private JLabel label20, label21;
    private JTextField tfieldLink1;
    private JSpinner spinnerDay1, spinnerMonth1, spinnerYear1;
    private JToggleButton buttonLinkPlus1, buttonLinkClose1;
    
    private JPanel panelALink2;
    private JLabel label22, label23;
    private JTextField tfieldLink2;
    private JSpinner spinnerDay2, spinnerMonth2, spinnerYear2;
    private JToggleButton buttonLinkClose2;
    
    private MouseAdapter mAdapterButton, mAdapterToggleButton;
    private ChangeListener cListenerSpinner;
    private ItemListener iListenerCBox;
    

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
        tfieldDescription = new JTextField();
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
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        tfieldE1Identifier = new JTextField();
        label13 = new JLabel();
        cboxE1Type = new JComboBox<>();
        label14 = new JLabel();
        spinnerRNumber = new JSpinner();
        label15 = new JLabel();
        tfieldRelationship = new JTextField();
        label16 = new JLabel();
        label17 = new JLabel();
        tfieldE2Identifier = new javax.swing.JTextField();
        label18 = new JLabel();
        cboxE2Type = new JComboBox<>();
        label19 = new JLabel();

        buttonRCreate = new JButton();
        buttonRDelete = new JButton();
        buttonLogout = new JButton();
        buttonQuery = new JButton();
        buttonLinkPlus = new JToggleButton("+");
        
        panelChild = new JPanel();
        labelSP = new JLabel();
        tfieldSP = new JTextField();   
        
        panelALink1 = new JPanel();
        tfieldLink1 = new JTextField();
        spinnerYear1 = new JSpinner();
        spinnerMonth1 = new JSpinner();
        spinnerDay1 = new JSpinner();
        label21 = new JLabel();
        label20 = new JLabel();
        buttonLinkPlus1 = new JToggleButton("+");
        buttonLinkClose1 = new JToggleButton("x");
        
        panelALink2 = new JPanel();
        tfieldLink2 = new JTextField();
        spinnerYear2= new JSpinner();
        spinnerMonth2 = new JSpinner();
        spinnerDay2 = new JSpinner();
        label22 = new JLabel();
        label23 = new JLabel();
        buttonLinkClose2 = new JToggleButton("x");
        
        this.label1.setFont(fontLabel1);
        this.label1.setText("Entity information");        
        this.label2.setFont(fontLabel3);
        this.label2.setText("Identifier:");        
        this.label3.setFont(fontLabel3);
        this.label3.setText("Label:");        
        this.label4.setFont(fontLabel3);
        this.label4.setText("Description:");        
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
        
        this.spinnerRNumber.setFont(fontSpinner);
        
        this.buttonECreate.setFont(fontButton);
        this.buttonECreate.setText("Create");
        this.buttonEDelete.setFont(fontButton);
        this.buttonEDelete.setText("Delete");
        
        this.buttonRCreate.setFont(fontButton);
        this.buttonRCreate.setText("Create");
        this.buttonRDelete.setFont(fontButton);
        this.buttonRDelete.setText("Delete");
        this.buttonLogout.setFont(fontButton);
        this.buttonLogout.setText("Log out");
        this.buttonQuery.setFont(fontButton);
        this.buttonQuery.setText("Query");
        
        this.cboxType.setFont(fontCBox);
        this.cboxType.setModel(new DefaultComboBoxModel<>(EntityRelationShipManager.getInstance().ENTITY_TYPE));
        
        this.cboxE1Type.setFont(fontCBox);
        this.cboxE1Type.setModel(new DefaultComboBoxModel<>(EntityRelationShipManager.getInstance().ENTITY_TYPE));
        this.cboxE2Type.setFont(fontCBox);
        this.cboxE2Type.setModel(new DefaultComboBoxModel<>(EntityRelationShipManager.getInstance().ENTITY_TYPE));
        
        Dimension tempSize = new Dimension(459, 63);
        this.panelChild.setPreferredSize(tempSize);
        this.panelChild.setSize(tempSize);;
        this.panelChild.setLayout(null);
        this.labelSP.setFont(fontLabel3);
        this.labelSP.setText("Other:");
        this.tfieldSP.setFont(fontField);
        this.tfieldSP.setText("");        
        
        this.tfieldDescription.setFont(fontField);
        this.tfieldIdentifier.setFont(fontField);
        this.tfieldLabel.setFont(fontField);
        this.tfieldLink.setFont(fontField);
        this.tfieldRelationship.setFont(fontField);        
        
        this.tfieldE1Identifier.setFont(fontField);
        this.tfieldE2Identifier.setFont(fontField);        
        
        this.label20.setFont(fontLabel3);
        this.label20.setText("Link:");
        this.label21.setFont(fontLabel3);
        this.label21.setText("Time:");
        this.tfieldLink1.setFont(fontField);        

        this.label22.setFont(fontLabel3);
        this.label22.setText("Link:");
        this.label23.setFont(fontLabel3);
        this.label23.setText("Time:");
        this.tfieldLink2.setFont(fontField);
    }
    
    private void arrangeComponents() {
        setLayout(null);

        add(label1);
        label1.setBounds(143, 68, 218, 29);
        add(label2);
        label2.setBounds(206, 151, 77, 22);
        add(tfieldIdentifier);
        tfieldIdentifier.setBounds(333, 148, 332, 28);
        add(label3);
        label3.setBounds(206, 186, 47, 22);
        add(tfieldLabel);
        tfieldLabel.setBounds(333, 183, 332, 28);
        add(label4);
        label4.setBounds(206, 218, 88, 22);
        add(tfieldDescription);
        tfieldDescription.setBounds(333, 219, 332, 28);
        add(label5);
        label5.setBounds(206, 116, 45, 22);
        add(cboxType);
        cboxType.setBounds(333, 113, 132, 28);
        add(label6);
        label6.setBounds(690, 120, 80, 22);
        add(label7);
        label7.setBounds(710, 150, 38, 22);
        add(label8);
        label8.setBounds(710, 190, 45, 22);
        add(buttonECreate);
        buttonECreate.setBounds(710, 400, 100, 31);
        add(buttonEDelete);
        buttonEDelete.setBounds(830, 400, 100, 31);
        add(label9);
        label9.setBounds(206, 262, 68, 22);

        add(spinnerENumber);
        spinnerENumber.setBounds(333, 262, 101, 28);
        add(spinnerDay);
        spinnerDay.setBounds(780, 190, 71, 22);
        add(spinnerMonth);
        spinnerMonth.setBounds(859, 188, 80, 22);
        add(spinnerYear);
        spinnerYear.setBounds(957, 188, 110, 22);

        panelChild.setLayout(null);
        panelChild.add(labelSP);
        labelSP.setBounds(0, 3, 120, 22);
        panelChild.add(tfieldSP);
        tfieldSP.setBounds(125, 0, 330, 28);
        add(panelChild);
        panelChild.setBounds(206, 303, 480, 90);

        add(label10);
        label10.setBounds(140, 440, 295, 29);
        add(label11);
        label11.setBounds(330, 490, 75, 22);
        add(label12);
        label12.setBounds(370, 520, 77, 22);
        tfieldE1Identifier.setBounds(450, 520, 242, 28);
        add(label13);
        label13.setBounds(740, 520, 45, 22);
        add(cboxE1Type);
        cboxE1Type.setBounds(810, 520, 132, 28);
        add(label14);
        label14.setBounds(740, 570, 68, 22);
        add(spinnerRNumber);
        spinnerRNumber.setBounds(820, 570, 100, 28);
        add(label15);
        label15.setBounds(330, 570, 119, 22);
        add(tfieldRelationship);
        tfieldRelationship.setBounds(450, 570, 242, 28);
        add(label16);
        label16.setBounds(330, 610, 75, 22);
        add(label17);
        label17.setBounds(370, 640, 77, 22);
        add(tfieldE2Identifier);
        tfieldE2Identifier.setBounds(450, 630, 242, 28);
        add(label18);
        label18.setBounds(740, 630, 45, 22);
        add(cboxE2Type);
        cboxE2Type.setBounds(810, 630, 132, 28);

        add(buttonRCreate);
        buttonRCreate.setBounds(880, 680, 100, 31);
        add(buttonRDelete);
        buttonRDelete.setBounds(990, 680, 100, 31);
        add(buttonLogout);
        buttonLogout.setBounds(140, 680, 120, 31);
        add(buttonQuery);
        buttonQuery.setBounds(280, 680, 120, 31);

        buttonLinkPlus.setMaximumSize(new java.awt.Dimension(40, 25));
        buttonLinkPlus.setMinimumSize(new java.awt.Dimension(40, 25));
        add(buttonLinkPlus);
        buttonLinkPlus.setBounds(1090, 150, 50, 30);
        add(tfieldLink);
        tfieldLink.setBounds(780, 150, 300, 28);

        panelALink1.setLayout(null);
        panelALink1.add(label20);
        label20.setBounds(0, 10, 41, 22);

        panelALink1.add(tfieldLink1);
        tfieldLink1.setBounds(70, 0, 300, 28);

        panelALink1.add(label21);
        label21.setBounds(0, 39, 45, 22);
        panelALink1.add(spinnerDay1);
        spinnerDay1.setBounds(70, 40, 70, 22);
        panelALink1.add(spinnerMonth1);
        spinnerMonth1.setBounds(150, 40, 80, 22);
        panelALink1.add(spinnerYear1);
        spinnerYear1.setBounds(250, 40, 110, 22);

        buttonLinkPlus1.setMaximumSize(new java.awt.Dimension(50, 25));
        buttonLinkPlus1.setMinimumSize(new java.awt.Dimension(50, 25));
        buttonLinkPlus1.setPreferredSize(new java.awt.Dimension(50, 25));
        panelALink1.add(buttonLinkPlus1);
        buttonLinkPlus1.setBounds(380, 0, 50, 25);
        panelALink1.add(buttonLinkClose1);
        buttonLinkClose1.setBounds(440, 0, 50, 25);

        add(panelALink1);
        panelALink1.setBounds(710, 220, 490, 80);

        panelALink2.setLayout(null);
        panelALink2.add(label22);
        label22.setBounds(0, 0, 50, 22);
        panelALink2.add(label23);
        label23.setBounds(0, 40, 45, 22);
        
        panelALink2.add(spinnerDay2);
        spinnerDay2.setBounds(70, 40, 70, 22);
        panelALink2.add(spinnerMonth2);
        spinnerMonth2.setBounds(150, 40, 80, 22);
        panelALink2.add(spinnerYear2);
        spinnerYear2.setBounds(250, 40, 110, 22);
        panelALink2.add(buttonLinkClose2);
        buttonLinkClose2.setBounds(380, 0, 50, 25);
        panelALink2.add(tfieldLink2);
        tfieldLink2.setBounds(70, 0, 300, 28);

        add(panelALink2);
        panelALink2.setBounds(710, 300, 490, 80);
        
        panelChild.setVisible(false);
        panelALink1.setVisible(false);
        panelALink2.setVisible(false);
    }

    private void initListeners() {
    	this.mAdapterButton = new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent event) {
    			JButton source = (JButton) event.getSource();
    			
    			if (source == CreatePanel.this.buttonLogout) {
    				try {
    					DatabaseHelper.getInstance().closeDriver();
        				MainFrame.getInstance().showPanel(MainFrame.PanelId.LOGIN_PANEL);
    				} catch (Exception e) {
    					e.printStackTrace();
    					JOptionPane.showMessageDialog(null, MainFrame.getInstance().LOGOUT_ERROR);
    				}
    				return;    				
    			}
    			
    			if (source == CreatePanel.this.buttonQuery) {
    				MainFrame.getInstance().showPanel(MainFrame.PanelId.QUERY_PANEL);
    				return;
    			}

    			if (source == CreatePanel.this.buttonECreate || source == CreatePanel.this.buttonEDelete) {
    				int number = (int) CreatePanel.this.spinnerENumber.getValue();
    				if (number > 0) {
    					EntityFactory factory = new EntityFactory();
    					MainEntity mainEntity = factory.getEntity(
    							CreatePanel.this.cboxType.getSelectedIndex(),
    							CreatePanel.this.getEntityOrigins(),
    							CreatePanel.this.getEntityOtherData()
    					);
    					if (source == CreatePanel.this.buttonECreate) {
    						DatabaseHelper.getInstance().createEntity(mainEntity,
    							(int) CreatePanel.this.spinnerENumber.getValue());
    					}
    					else {
    						DatabaseHelper.getInstance().deleteEntity(mainEntity, number);
    					}    						
    				}    				
    			} 
    			if (source == CreatePanel.this.buttonRCreate || source == CreatePanel.this.buttonRDelete) {
    				int number = (int) CreatePanel.this.spinnerRNumber.getValue();
    				
    				if (number >= 0) {
    					EntityFactory factory = new EntityFactory();
    					MainEntity startEntity = factory.getEntity(
    							CreatePanel.this.cboxType.getSelectedIndex(),
    							CreatePanel.this.getEntityOrigins(),
    							CreatePanel.this.tfieldE1Identifier.getText(),
    							"",	"",	"",	"", "");
    					MainEntity endEntity = factory.getEntity(
    							CreatePanel.this.cboxE2Type.getSelectedIndex(),
    							CreatePanel.this.getEntityOrigins(),
    							CreatePanel.this.tfieldE2Identifier.getText(),
    							"", "", "", "", "");
    					Relationship relationship = new Relationship(CreatePanel.this.tfieldRelationship.getText());
    					
    					relationship.setStart(startEntity);
    					relationship.setEnd(endEntity);
    					
    					DatabaseHelper.getInstance().createRelationship(relationship, number);
    					if (source == CreatePanel.this.buttonRDelete) {
    						DatabaseHelper.getInstance().deleteRelationship(relationship, number);
    					} 
    				}
    			}
    		}
    	};
    	
    	this.mAdapterToggleButton = new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent event) {
    			JToggleButton source = (JToggleButton) event.getSource();
    			if (source == CreatePanel.this.buttonLinkPlus) {
    				CreatePanel.this.panelALink1.setVisible(true);
    			}
    			if (source == CreatePanel.this.buttonLinkPlus1) {
    				CreatePanel.this.panelALink2.setVisible(true);
    			}
    			if (source == CreatePanel.this.buttonLinkClose1) {
    				CreatePanel.this.panelALink1.setVisible(false);
    			}
    			if (source == CreatePanel.this.buttonLinkClose2) {
    				CreatePanel.this.panelALink2.setVisible(false);
    			}
    			
    			CreatePanel.this.revalidate();
    			CreatePanel.this.repaint();
    		}
    	};
    	
    	this.cListenerSpinner = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				// TODO Auto-generated method stub
				JSpinner source = (JSpinner) event.getSource();
				
				if (source == CreatePanel.this.spinnerENumber ||
						source == CreatePanel.this.spinnerRNumber) {
					CreatePanel.this.adjustSpinner(source,
							CreatePanel.this.MIN_NUMBER,
							CreatePanel.this.MAX_NUMBER);
				}
				
				if (source == CreatePanel.this.spinnerDay ||
						source == CreatePanel.this.spinnerDay1 ||
						source == CreatePanel.this.spinnerDay2) {
					CreatePanel.this.adjustSpinner(source,
							CreatePanel.this.MIN_DAY,
							CreatePanel.this.MAX_DAY);					
				}
				if (source == CreatePanel.this.spinnerMonth ||
						source == CreatePanel.this.spinnerMonth1 ||
						source == CreatePanel.this.spinnerMonth2) {
					CreatePanel.this.adjustSpinner(source,
							CreatePanel.this.MIN_MONTH,
							CreatePanel.this.MAX_MONTH);
				}
				if (source == CreatePanel.this.spinnerYear ||
						source == CreatePanel.this.spinnerYear1 ||
						source == CreatePanel.this.spinnerYear2) {
					CreatePanel.this.adjustSpinner(source,
							CreatePanel.this.MIN_YEAR,
							CreatePanel.this.MAX_YEAR);
				}
			}    		
    	};
    	
    	this.iListenerCBox = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent event) {
				// TODO Auto-generated method stub
				if (event.getStateChange() == ItemEvent.SELECTED) {
					String item = (String) event.getItem();
					//System.out.println(item);
					if (item.equalsIgnoreCase("PERSON") 
							|| item.equalsIgnoreCase("ORGANIZATION") 
							|| item.equalsIgnoreCase("COUNTRY")) {
//						CreatePanel.this.showSPFields(
//								EntityRelationShipManager.getInstance().typeProperty.get(item) + ":"
//						);
						CreatePanel.this.labelSP.setText(
								EntityRelationShipManager.getInstance().typeProperty.get(item) + ":"
						);
						CreatePanel.this.panelChild.setVisible(true);
						return;
					}; 
					
					CreatePanel.this.panelChild.setVisible(false);
//					CreatePanel.this.tfieldSP.setVisible(false);
//					CreatePanel.this.labelSP.setVisible(false);
				}
			}
    		
    	};
    }    	
    
    public String[] getEntityOtherData() {
    	LinkedList<String> list = new LinkedList<String>();
    	//list.add(this.tfieldLink.getText());
    	//list.add(date);
    	list.add(this.tfieldIdentifier.getText());
    	list.add(this.tfieldLabel.getText());
    	list.add(this.tfieldDescription.getText());
    	if (this.panelChild.isVisible()) {
    		list.add(this.tfieldSP.getText());
    	}
    	
    	Object[] array = list.toArray();
    	return Arrays.copyOf(array, array.length, String[].class);
    }
    
    public LinkedList<Origin> getEntityOrigins() {
    	String date = String.join("/", 
    			String.valueOf(this.spinnerDay.getValue()), 
    			String.valueOf(this.spinnerMonth.getValue()),
    			String.valueOf(this.spinnerYear.getValue())
    	);
    	
    	LinkedList<Origin> list = new LinkedList<Origin>();
    	list.add(new Origin(this.tfieldLink.getText(), date));//roi day
    	return list;
    }
    
    public void adjustSpinner(JSpinner spinner, int minValue, int maxValue) {
    	int value = (int) spinner.getValue();
    	//value = Math.max(minValue, value);
    	//value = Math.min(maxValue, value);
    	value = (value <= maxValue)? ((value < minValue)? maxValue : value) : minValue;    	
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
    	this.spinnerRNumber.addChangeListener(this.cListenerSpinner);
    	this.spinnerENumber.addChangeListener(this.cListenerSpinner);
    	
    	this.spinnerDay1.addChangeListener(this.cListenerSpinner);
    	this.spinnerMonth1.addChangeListener(this.cListenerSpinner);
    	this.spinnerYear1.addChangeListener(this.cListenerSpinner);
    	
    	this.spinnerDay2.addChangeListener(this.cListenerSpinner);
    	this.spinnerMonth2.addChangeListener(this.cListenerSpinner);
    	this.spinnerYear2.addChangeListener(this.cListenerSpinner);
    	
    	this.cboxType.addItemListener(this.iListenerCBox);
    	
    	this.buttonLinkClose1.addMouseListener(this.mAdapterToggleButton);
    	this.buttonLinkClose2.addMouseListener(this.mAdapterToggleButton);    	
    	
    	this.buttonLinkPlus.addMouseListener(this.mAdapterToggleButton);
    	this.buttonLinkPlus1.addMouseListener(this.mAdapterToggleButton);
    }
    
//    private void showSPFields(String text) {
//    	this.tfieldSP.setText("");
//    	this.tfieldSP.setVisible(true);
//    	
//    	this.labelSP.setText(text);
//    	this.labelSP.setVisible(true);
//    }    
    
    public void restoreState() {
    	String initialFieldValue = "";
    	int initialSpinnerValue = 1;
    	
    	this.tfieldDescription.setText(initialFieldValue);
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
    	this.spinnerRNumber.setValue(initialSpinnerValue);
    }    
    
}
