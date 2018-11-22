package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class QueryPanel extends JPanel implements Restorable{
	private Font fontButton = new Font("Tahoma", 0, 18);
	private Font fontLabel = new Font("Tahoma", 0, 18);
	private Font fontField = new Font("Tahoma", 0, 18);
	
    private JButton buttonClear;
    private JButton buttonSend;
    private JButton buttonStatistics;
    private JButton buttonLogout;
    private JButton buttonCreate;
    private JLabel label1;
    private JLabel label2;
    private JLabel labelQueryResult;
    private JScrollPane scrollPanelResult;
    private JTable tableResult;
    private DefaultTableModel tableResultModel;
    private JTextField tfieldQuery;
    
    private MouseAdapter mAdapterButton;
    
    public QueryPanel() {
    	this.initComponents();
    	this.arrangeComponents();
    	this.initListeners();
    	this.addListeners();
    }

    private void initComponents() {
    	this.buttonClear = new JButton("Clear");
    	this.buttonClear.setFont(fontButton);
    	this.buttonSend = new JButton("Send");
    	this.buttonSend.setFont(fontButton);
    	this.buttonStatistics = new JButton("Statistics");
    	this.buttonStatistics.setFont(fontButton);
    	this.buttonLogout = new JButton("Log out");
    	this.buttonLogout.setFont(fontButton);
    	this.buttonCreate = new JButton("Create");
    	this.buttonCreate.setFont(fontButton);
    
    	this.label1 = new JLabel("Query:");
    	this.label1.setFont(fontLabel);
    	
    	this.tfieldQuery = new JTextField();
    	this.tfieldQuery.setFont(fontField);
    	
    	this.tableResult = new JTable();
    	this.tableResultModel = new DefaultTableModel();
    	this.tableResult.setModel(this.tableResultModel);
    	
    	this.scrollPanelResult = new JScrollPane();
    	Dimension tempSize = new Dimension(1004, 603);
    	this.scrollPanelResult.setPreferredSize(tempSize);
    	this.scrollPanelResult.setSize(tempSize);
    	this.scrollPanelResult.setViewportView(this.tableResult);    	
    }
    
    private void arrangeComponents() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonLogout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonStatistics)
                        .addGap(24, 24, 24)
                        .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfieldQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonSend))
                    .addComponent(scrollPanelResult, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1)
                    .addComponent(tfieldQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSend))
                .addGap(18, 18, 18)
                .addComponent(scrollPanelResult, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonStatistics)
                    .addComponent(buttonClear)
                    .addComponent(buttonLogout)
                    .addComponent(buttonCreate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );    	
    }
    
    private void initListeners() {
    	this.mAdapterButton = new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent event) {
    			JButton source = (JButton) event.getSource();
    			
    			if (source == QueryPanel.this.buttonSend) {
    				
    			} 
    			if (source == QueryPanel.this.buttonLogout) {
    				//close current driver
    				
    				MainFrame.getInstance().showPanel(MainFrame.PanelId.LOGIN_PANEL);    				
    			}
    			if (source == QueryPanel.this.buttonCreate) {    				
    				MainFrame.getInstance().showPanel(MainFrame.PanelId.CREATE_PANEL);    				
    			}
    			if (source == QueryPanel.this.buttonClear) {
    				QueryPanel.this.restoreState();
    			}
    			if (source == QueryPanel.this.buttonStatistics) {    				
    			}
    		}    		
    	};
    }   
    
    public void addListeners() {
    	this.buttonSend.addMouseListener(this.mAdapterButton);
    	this.buttonClear.addMouseListener(this.mAdapterButton);
    	this.buttonStatistics.addMouseListener(this.mAdapterButton);
    	this.buttonLogout.addMouseListener(this.mAdapterButton);
    	this.buttonCreate.addMouseListener(this.mAdapterButton);
    }
    
    public void restoreState() {
    	
    }
}
