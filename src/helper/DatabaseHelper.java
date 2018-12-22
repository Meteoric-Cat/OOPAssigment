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

import model.Country;
import model.EntityRelationShipManager;
import model.MainEntity;
import model.Organization;
import model.Person;
import model.Query;
import model.Relationship;

public class DatabaseHelper {

	// 1, Sua ham createEntity di, thay MERGE cho CREATE de tranh duplicate doi
	// tuong cung identifier, hoac match(doi tuong voi identier roi moi tao cho a)
	// 2, xem lai cac thuoc tinh cua cac class khi tao
	// 3, Truong Origin gio la mot danh sach nhe, a DOC THIEU DE nen khong chu y den
	// 4, Viet a mot cai method deleteEntity, deleteRelationship, theo y hieu cua m,
	// a co de example day nhung lam theo y m di.
	// 5, Xem lai luc tao quan he thi thoi gian trich rut cua 2 doi tuong la nhu
	// nhau

	private static DatabaseHelper instance;
	private String account;
	private String password;
	private Driver driver;

	public static DatabaseHelper getInstance() { // getInstance
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

	private DatabaseHelper() { // constructor default
	}

//	public DatabaseHelper(DatabaseHelper instance, String account, String password, Driver driver) {
//		setAccount(account);
//		setPassword(password);
//		setDriver(driver);
//	}

	public void createEntity(MainEntity entity, int number) {
		try (Session session = driver.session()) {
			// get id base
			int lastIndex = entity.getIdentifier().lastIndexOf("_");
			String idBase = entity.getIdentifier().substring(0, lastIndex + 1);
			int rootID = Integer.parseInt(entity.getIdentifier().substring(lastIndex + 1));

			int i = 0; // đếm số lượng entity đã tạo ra

			if (entity.getType() == "PERSON") {
				while (i != number) {
					session.run("MERGE (n:" + entity.getType() + "{identifier:'" + idBase + (rootID + i) + "', label:'"
							+ entity.getLabel() + "', description: '" + entity.getDescription() + "', origin: '"
							+ entity.getOriginsAsString() + "', position:'" + ((Person) entity).getPosition() + "'})");
					i++; // quantityCreatedEntity == i
				}
				JOptionPane.showMessageDialog(null, "Đã tạo thành công : " + i + " thực thể");

			} else if (entity.getType() == "COUNTRY") {
				while (i != number) {
					session.run("MERGE (n:" + entity.getType() + "{identifier:'" + idBase + (rootID + i) + "', label:'"
							+ entity.getLabel() + "', description: '" + entity.getDescription() + "', origin: '"
							+ entity.getOriginsAsString() + "', continent: '" + ((Country) entity).getContinent()
							+ "'})");
					i++; // quantityCreatedEntity == i
				}
				JOptionPane.showMessageDialog(null, "Đã tạo thành công : " + i + " thực thể");

			} else if (entity.getType() == "ORGANIZATION") {
				while (i != number) {
					session.run("MERGE (n:" + entity.getType() + "{identifier:'" + idBase + (rootID + i) + "', label:'"
							+ entity.getLabel() + "', description: '" + entity.getDescription() + "', origin: '"
							+ entity.getOriginsAsString() + "', headquater: '"
							+ ((Organization) entity).getHeadquarter() + "'})");
					i++; // quantityCreatedEntity == i
				}
				JOptionPane.showMessageDialog(null, "Đã tạo thành công : " + i + " thực thể");

			} else {
				while (i != number) {
					session.run("MERGE (n:" + entity.getType() + "{identifier:'" + idBase + (rootID + i) + "', label:'"
							+ entity.getLabel() + "', description: '" + entity.getDescription() + "', origin: '"
							+ entity.getOriginsAsString() + "'})");
					i++; // quantityCreatedEntity == i
				}
				JOptionPane.showMessageDialog(null, "Đã tạo thành công : " + i + " thực thể");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public StatementResult processQuery(Query query) {
		try (Session session = driver.session()) {
			Statement statement = new Statement(query.getContent());
			StatementResult result = session.run(statement);
			return result;

		} catch (Exception e) {
			return null;
		}
	}

	public void closeDriver() throws Exception {
		driver.close();
	}

	public void initData(EntityRelationShipManager entityRelationshipManager) { //
		try (Session session = driver.session()) {
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
				entityRelationshipManager.setRelationshipAmount(Integer.parseInt(record.get("count(*)").toString()));
				// JOptionPane.showMessageDialog(null, "Số lượng relationship:
				// "+record.get("count(*)").toString());
			}

			result = session.run(statementPersonQuantity);
			while (result.hasNext()) {
				Record record = result.next();
				entityRelationshipManager.setPersonAmount(Integer.parseInt(record.get("count(*)").toString()));
			}

			result = session.run(statementOrganizationQuantity);
			while (result.hasNext()) {
				Record record = result.next();
				entityRelationshipManager.setOrganizationAmount(Integer.parseInt(record.get("count(*)").toString()));
			}

			result = session.run(statementCountryQuantity);
			while (result.hasNext()) {
				Record record = result.next();
				entityRelationshipManager.setCountryAmount(Integer.parseInt(record.get("count(*)").toString()));
			}

			result = session.run(statementEventQuantity);
			while (result.hasNext()) {
				Record record = result.next();
				entityRelationshipManager.setEventAmount(Integer.parseInt(record.get("count(*)").toString()));
			}

			result = session.run(statementLocationQuantity);
			while (result.hasNext()) {
				Record record = result.next();
				entityRelationshipManager.setLocationAmount(Integer.parseInt(record.get("count(*)").toString()));
			}

		} catch (Exception e) {

		}
	}

	public void createDriver(String account, String password) throws Exception {
		// bolt://localhost:7687 : Bolt port
		driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic(account, password));
		this.account = account;
		this.password = password;
	}

	public void deleteEntity(MainEntity entity, int number) {
		try (Session session = driver.session()) {
			// get id base
			int lastIndex = entity.getIdentifier().lastIndexOf("_");
			String idBase = entity.getIdentifier().substring(0, lastIndex + 1);
			int rootID = Integer.parseInt(entity.getIdentifier().substring(lastIndex + 1));

			int i = 0;

			while (i != number) {
				session.run("MATCH (n:" + entity.getType() + ")  WHERE (n.identifier ='" + idBase + (rootID + i)
						+ "') DETACH DELETE n;");
				i++;
			}
			JOptionPane.showMessageDialog(null, "Đã xóa thành công " + i + " thực thể ");

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void createRelationship(Relationship relationship, int number) {
		try (Session session = driver.session()) {

			// get id base of NodeStart
			int lastIndexStart = relationship.getStart().getIdentifier().lastIndexOf("_");
			String idBaseStart = relationship.getStart().getIdentifier().substring(0, lastIndexStart + 1);
			int rootIDStart = Integer.parseInt(relationship.getStart().getIdentifier().substring(lastIndexStart + 1));
			// get id base of NodeEnd
			int lastIndexEnd = relationship.getEnd().getIdentifier().lastIndexOf("_");
			String idBaseEnd = relationship.getEnd().getIdentifier().substring(0, lastIndexEnd + 1);
			int rootIDEnd = Integer.parseInt(relationship.getEnd().getIdentifier().substring(lastIndexEnd + 1));

			int i = 0; // đánh số ID định danh

			while (i != number) {
				session.run("MATCH (a:" + relationship.getStart().getType() + "), (b: "
						+ relationship.getEnd().getType() + " )  " + "WHERE a.identifier = '" + idBaseStart
						+ (rootIDStart + i) + "' AND b.identifier = '" + idBaseEnd + (rootIDEnd + i)
						+ "' CREATE (a)-[r:" + relationship.getType() + "]->(b) ");
				i++;
			}
			JOptionPane.showMessageDialog(null, "Đã tạo thành công " + i + " quan hệ");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void deleteRelationship(Relationship relationship, int number) {
		try (Session session = driver.session()) {

			// get id base of NodeStart
			int lastIndexStart = relationship.getStart().getIdentifier().lastIndexOf("_");
			String idBaseStart = relationship.getStart().getIdentifier().substring(0, lastIndexStart + 1);
			int rootIDStart = Integer.parseInt(relationship.getStart().getIdentifier().substring(lastIndexStart + 1));
			// get id base of NodeEnd
			int lastIndexEnd = relationship.getEnd().getIdentifier().lastIndexOf("_");
			String idBaseEnd = relationship.getEnd().getIdentifier().substring(0, lastIndexEnd + 1);
			int rootIDEnd = Integer.parseInt(relationship.getEnd().getIdentifier().substring(lastIndexEnd + 1));

			int i = 0; // đánh số ID định danh

			while (i != number) {
				session.run("MATCH (a:" + relationship.getStart().getType() + ") -[r]-> (b: "
						+ relationship.getEnd().getType() + " )  " + "WHERE a.identifier = '" + idBaseStart
						+ (rootIDStart + i) + "' AND b.identifier = '" + idBaseEnd + (rootIDEnd + i) + "' DELETE r ");
				i++;
			}
			JOptionPane.showMessageDialog(null, "Đã xóa thành công " + i + " quan hệ");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
