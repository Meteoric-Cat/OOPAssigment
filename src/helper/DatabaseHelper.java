package helper;


import java.util.Map;
import java.util.concurrent.CompletionStage;

import javax.swing.JOptionPane;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Statement;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.StatementResultCursor;
import org.neo4j.driver.v1.Transaction;
import org.neo4j.driver.v1.TransactionWork;
import org.neo4j.driver.v1.Value;
import org.neo4j.driver.v1.types.TypeSystem;

import model.business.EntityRelationShipManager;
import model.business.Relationship;
import model.database.MainEntity;

public class DatabaseHelper {
	
	private DatabaseHelper instance;
	private String account;
	private String password;
	private Driver driver;
	
	public DatabaseHelper getInstance() {				// getInstance
		if (instance == null) {
			instance = new DatabaseHelper();
		}
		return instance;
	}
	public void setInstance(DatabaseHelper instance) {
		this.instance = instance;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	
	public DatabaseHelper() {			// constructor default
		
	}
	public DatabaseHelper(DatabaseHelper instance, String account, String password, Driver driver) {
		setInstance(instance);
		setAccount(account);
		setPassword(password);
		setDriver(driver);
	}
	
	public void createEntity(MainEntity entity, int amount) {
		try(Session session = driver.session()){
			int i = 0;		// để đánh số id định danh
			int quantityCreatedEntity = 0;	// đếm số lượng entity đã tạo ra
			
			while (quantityCreatedEntity != amount) {			
				session.run("CREATE (n:"+entity.getLabel()+"{identifier:'"+entity.getIdentifier()+"_"+i+"', label:'"+entity.getLabel()+"', description: '"+entity.getDescription()+"', origin: '"+entity.getOrigin()+"'})"); 						
				quantityCreatedEntity++;
				i++;
				
			}
			JOptionPane.showMessageDialog(null, "Đã tạo thành công : "+quantityCreatedEntity+" thực thể");
		} catch (Exception e) {
			
		}
	}
	public void createRelationship(Relationship relationship, int amount) {
		try(Session session = driver.session()){
			int i=0, j=0;		// đánh số ID định danh
			int QuantityCreatedRelationship = 0;	// count CreatedRelationship
			while (QuantityCreatedRelationship != amount) {
				session.run("MATCH (a:"+relationship.getStart().getLabel() +"), (b: "+relationship.getEnd().getLabel()+" )  WHERE a.identifier = '"+ relationship.getStart().getIdentifier()+"_"+i+"' AND b.identifier = '" +  relationship.getEnd().getIdentifier()+"_"+j + "' CREATE (a)-[r:"+relationship.getType()+"]->(b) "); 									
				i++;
				j++;
				QuantityCreatedRelationship++;
			}
			JOptionPane.showMessageDialog(null, "Đã tạo thành công "+QuantityCreatedRelationship+" quan hệ");
		} catch (Exception e) {
			
		}
	}
	public StatementResult processQuery(String query) {
		try (Session session = driver.session()){				
			Statement statement = new Statement(query);
			StatementResult result =  session.run(statement);
			return result;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	public void closeDriver() {
		driver.close();
	}
	public void initData(EntityRelationShipManager entityRelationshipManager) {		//
		try(Session session = driver.session()){
			StatementResult result;
			// query quantity
			Statement statementRelationshipQuantity = new Statement("MATCH ()-->() return count(*)");		
			Statement statementPersonQuantity = new Statement("MATCH (n:Person) RETURN count(*)");	
			Statement statementOrganizationQuantity = new Statement("MATCH (n:Organization) RETURN count(*)");			
			Statement statementCountryQuantity = new Statement("MATCH (n:Country) RETURN count(*)");			
			Statement statementEventQuantity = new Statement("MATCH (n:Event) RETURN count(*)");			
			Statement statementLocationQuantity = new Statement("MATCH (n:Location) RETURN count(*)");			
			
			result = session.run(statementRelationshipQuantity);
			while (result.hasNext()) {
				Record record = result.next();
				entityRelationshipManager.setRelationshipAmount(Integer.parseInt( record.get("count(*)").toString()));
				//JOptionPane.showMessageDialog(null, "Số lượng relationship: "+record.get("count(*)").toString());		
			}
			
			result = session.run(statementPersonQuantity);
			while (result.hasNext()) {
				Record record = result.next();
				entityRelationshipManager.setPersonAmount(Integer.parseInt( record.get("count(*)").toString()));
			}
			
			result = session.run(statementOrganizationQuantity);
			while (result.hasNext()) {
				Record record = result.next();
				entityRelationshipManager.setOrganizationAmount(Integer.parseInt( record.get("count(*)").toString()));
			}
			
			result = session.run(statementCountryQuantity);
			while (result.hasNext()) {
				Record record = result.next();
				entityRelationshipManager.setCountryAmount(Integer.parseInt( record.get("count(*)").toString()));
			}
			
			result = session.run(statementEventQuantity);
			while (result.hasNext()) {
				Record record = result.next();
				entityRelationshipManager.setEventAmount(Integer.parseInt( record.get("count(*)").toString()));
			}
			
			result = session.run(statementLocationQuantity);
			while (result.hasNext()) {
				Record record = result.next();
				entityRelationshipManager.setLocationAmount(Integer.parseInt( record.get("count(*)").toString()));
			}
			
			
		} catch (Exception e) {
			
		}
	}
	public void createDriver(String account, String password) throws Exception {
			// bolt://localhost:7687 :  Bolt port 
			driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic(account, password));		
	}
	
	
}
