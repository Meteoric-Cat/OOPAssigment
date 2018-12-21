package helper;


import java.util.LinkedList;

import javax.swing.JOptionPane;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Statement;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;

import model.EntityRelationShipManager;
import model.MainEntity;
import model.Query;
import model.Relationship;

public class DatabaseHelper {
	
	//1, Sua ham createEntity di, thay MERGE cho CREATE de tranh duplicate doi tuong cung identifier, hoac match(doi tuong voi identier roi moi tao cho a)
	//2, xem lai cac thuoc tinh cua cac class khi tao
	//3, Truong Origin gio la mot danh sach nhe, a DOC THIEU DE nen khong chu y den
	//4, Viet a mot cai method deleteEntity, deleteRelationship, theo y hieu cua m, a co de  example day nhung lam theo y m di.
	//5, Xem lai luc tao quan he thi thoi gian trich rut cua 2 doi tuong la nhu nhau
	
	private static DatabaseHelper instance;
	private String account;
	private String password;
	private Driver driver;
	
	public static DatabaseHelper getInstance() {				// getInstance
		if (instance == null) {
			instance = new DatabaseHelper();
		}
		return instance;
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
		
	private DatabaseHelper() {			// constructor default		
	}
	
//	public DatabaseHelper(DatabaseHelper instance, String account, String password, Driver driver) {
//		setAccount(account);
//		setPassword(password);
//		setDriver(driver);
//	}
	
	public void createEntity(MainEntity entity, int number) {
		try(Session session = driver.session()){
			//get id base
			int lastIndex = entity.getIdentifier().lastIndexOf("_");
			String idBase = entity.getIdentifier().substring(0, lastIndex + 1);
			int rootID = Integer.parseInt(entity.getIdentifier().substring(lastIndex + 1));
			
			int i = 0;		// để đánh số id định danh
			int quantityCreatedEntity = 0;	// đếm số lượng entity đã tạo ra			
			
			//???????? class Country, Location, Person thieu thuoc tinh
			while (quantityCreatedEntity != number) {				
				session.run("MERGE (n:"+entity.getType()+"{identifier:'"+ idBase + (rootID + i ) + 
						"', label:'"+entity.getLabel()+"', description: '"+entity.getDescription()+"', origin: '"+entity.getOriginsAsString()+"'})"); 						
				quantityCreatedEntity++;          //?quantityCreatedEntity == i? => do we need something like i here?
				i++;				
			}
			JOptionPane.showMessageDialog(null, "Đã tạo thành công : "+quantityCreatedEntity+" thực thể");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void createRelationship(Relationship relationship, int number) {
		try(Session session = driver.session()){
			int i=0, j=0;		// đánh số ID định danh
			int QuantityCreatedRelationship = 0;	// count CreatedRelationship
			while (QuantityCreatedRelationship != number) {
				session.run("MATCH (a:"+relationship.getStart().getLabel() +"), (b: "+relationship.getEnd().getLabel()+" )  " +
						"WHERE a.identifier = '"+ relationship.getStart().getIdentifier()+"_"+i+"' AND b.identifier = '" + 
						relationship.getEnd().getIdentifier()+"_"+j + "' CREATE (a)-[r:"+relationship.getType()+"]->(b) "); 									
				i++;
				j++;
				QuantityCreatedRelationship++;
			}
			JOptionPane.showMessageDialog(null, "Đã tạo thành công "+QuantityCreatedRelationship+" quan hệ");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public StatementResult processQuery(Query query) {
		try (Session session = driver.session()){				
			Statement statement = new Statement(query.getContent());
			StatementResult result =  session.run(statement);
			return result;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	public void closeDriver() throws Exception {
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
			this.account = account;
			this.password = password;
	}
	
	//example 
//	public void deleteEntity(MainEntity entity, int number) {
//		try (Session session = this.driver.session()) {
//			//get id base	
//			int lastIndex = entity.getIdentifier().lastIndexOf("_") + 1;
//			String idBase = entity.getIdentifier().substring(0, 
//					lastIndex);
//			int rootID = Integer.parseInt(entity.getIdentifier().substring(lastIndex));					
//			
//			//build content of this query
//			StringBuilder queryBuilder = new StringBuilder();
//			LinkedList<String> paramList = new LinkedList<String>();			
//
//			queryBuilder.append("MATCH ");
//			for (int i = 1; i <= number; i++) {
//				queryBuilder.append("(n" + i + ":" + entity.getType() + "{identifier: $id" + i + "}),");
//				paramList.add("id" + i);
//				paramList.add(idBase + (i + rootID));
//			}
//			queryBuilder.append("() DETACH DELETE ");
//			
//			for (int i = 1; i <= number - 1; i++) {
//				queryBuilder.append("n"+ i + ","); 
//			}
//			queryBuilder.append("n" + number);
//			
//			//run query in async mode
//			Statement statement = new Statement(queryBuilder.toString());
//			session.runAsync(statement.withParameters(Values.parameters(paramList.toArray())))
//					.thenRun(
//						() -> JOptionPane.showMessageDialog(null, "Deleted entities")					
//					);
//		} catch (Exception e) {
//			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, e.getMessage());
//		}
//	}
	
}
