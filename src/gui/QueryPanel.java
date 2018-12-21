package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.StatementResult;

import helper.DatabaseHelper;
import model.Query;

public class QueryPanel extends JPanel implements Restorable{
	//private final String LOGOUT_ERROR = "Logout failed";
	
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
    private JLabel labelQueryTime;
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
    	this.label2 = new JLabel("Time (seconds):");
    	this.label2.setFont(fontLabel);
    	this.labelQueryTime = new JLabel("0");
    	this.labelQueryTime.setFont(fontLabel);
    	
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
                        .addComponent(label2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelQueryTime)
                        .addGap(149, 149, 149)
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
                    .addComponent(buttonCreate)
                    .addComponent(label2)
                    .addComponent(labelQueryTime))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    
    private void initListeners() {
    	this.mAdapterButton = new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent event) {
    			JButton source = (JButton) event.getSource();
    			QueryPanel.this.restoreState();
    			
    			if (source == QueryPanel.this.buttonSend) {
    				Query query = new Query();
    				query.setContent(QueryPanel.this.tfieldQuery.getText());
    				
    				StatementResult result = DatabaseHelper.getInstance().processQuery(query);
    				Record record = null;
    				
    				boolean first = true;
    				while (result.hasNext()) {
    					record = result.next();
    					Map<String, Object> entityData = record.get(0).asMap();
    					
    					if (first) {
    						//add columns
    						Set<String> value = entityData.keySet();
    						Iterator<String> iter = value.iterator();
    						while (iter.hasNext()) {
    							QueryPanel.this.tableResultModel.addColumn(iter.next());    							
    						}
    						first = false;
    					}
    					
    					QueryPanel.this.tableResultModel.addRow(entityData.values().toArray());
    				}
    			} 
    			if (source == QueryPanel.this.buttonLogout) {
    				//close current driver    				
    				try {
    					DatabaseHelper.getInstance().closeDriver();
    					MainFrame.getInstance().showPanel(MainFrame.PanelId.LOGIN_PANEL);
    				} catch (Exception e) {
    					e.printStackTrace();
    					JOptionPane.showMessageDialog(null, MainFrame.getInstance().LOGOUT_ERROR);
    				}
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
    	this.tfieldQuery.setText("");
    	
    	this.tableResultModel.setRowCount(0);
    	this.tableResultModel.setColumnCount(0);
    	this.tableResult.revalidate();
    	this.tableResult.repaint();
    }
    
//	public void deleteRelationship(Relationship relationship, int startNumber, int endNumber ) {
//	try (Session session = this.driver.session()) {
//		//get identifier base
//		MainEntity startEntity = relationship.getStart();
//		MainEntity endEntity = relationship.getEnd();
//		
//		int temp = startEntity.getIdentifier().lastIndexOf("_") + 1;
//		String idBase1 = startEntity.getIdentifier().substring(0, temp);
//		int rootID1 = Integer.parseInt(startEntity.getIdentifier().substring(temp));
//		
//		temp = endEntity.getIdentifier().lastIndexOf("_") + 1;
//		String idBase2 = endEntity.getIdentifier().substring(0, temp);
//		int rootID2 = Integer.parseInt(endEntity.getIdentifier().substring(temp));
//		
//		StringBuilder queryBuilder = new StringBuilder();
//		//StringBuilder subBuilder = new StringBuilder();
//		queryBuilder.append("MATCH ");
//		//subBuilder.append(" DELETE ");
//		
//		temp = 0;
//		for (int i=1; i<=startNumber; i++) 
//			for (int j=1; j<= endNumber; j++) {
//				temp++;
//				queryBuilder.append("(n" + i + ":" + startEntity.getType() + "{identifier: $idn" + i + "})-[q" +
//						temp + ":[" + relationship.getType() + "]->(m" + j + ":" + endEntity.getType() + "{identifier: $idm"+ j + "}),");					
//			}		
//		queryBuilder.append("()");
//		queryBuilder.append(" DELETE ");
//		for (int i=1; i<=temp - 1; i++) {
//			queryBuilder.append("q" + i + ",");
//		}
//		queryBuilder.append("q" + temp);
//					
//		LinkedList<String> paramList = new LinkedList<String>();
//		for (int i=1; i<=startNumber; i++) {
//			paramList.add("idn" + i);
//			paramList.add(idBase1 + (rootID1 + i));
//		}
//		for (int i=1; i<=endNumber; i++) {
//			paramList.add("idm" + i);
//			paramList.add(idBase2 + (rootID2 + i));			
//		}
//		
//		Statement statement = new Statement(queryBuilder.toString());
//		session.runAsync(statement.withParameters(Values.parameters(paramList.toArray())))
//				.thenRun(
//						()-> JOptionPane.showMessageDialog(null, "Deleted relationships")
//				);
//	} catch (Exception e) {
//		e.printStackTrace();
//		JOptionPane.showMessageDialog(null, e.getMessage());
//	}
//}

//private Object[] getIDBase(String identifier) {
//	int lastIndex = identifier.indexOf("_");
//	return new String[] {
//			identifier.substring(0, lastIndex + 1), 
//			identifier.substring(lastIndex + 1)
//	};
//}

}
