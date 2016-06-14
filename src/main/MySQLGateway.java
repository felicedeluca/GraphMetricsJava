package main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



public class MySQLGateway {
	
	public final static int ALG_FMMM = 1;
	public final static int ALG_FR = 2;
	public final static int ALG_GEM = 3;
	public final static int ALG_KK = 4;
	public final static int ALG_PLANAR = 5;
	public final static int ALG_SM = 6;
	public final static int ALG_TREE = 7;
	public final static int ALG_RADTREE = 8;
	public final static int ALG_LINLOG = 9;


	public Connection connectionWithDatabase;
	

	//Database
	private static final String dbSchema = "ply";
	public static final String dbUser = "root";
	public static final String dbPassword = "toor";



	private static MySQLGateway instance = null;

	public static MySQLGateway getInstance()  throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		if(instance == null){
			instance = new MySQLGateway();
		}

		return instance;

	}

	private MySQLGateway() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{


		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connectionWithDatabase = DriverManager.getConnection("jdbc:mysql://localhost:3306/" 
				+ dbSchema, dbUser, dbPassword);

	}
	
	public Set<String> fetchGraphs(int family, String type_1, String type_2, String type_3, String instance, String idExperiment){
		
		String query = "SELECT filename FROM " + dbSchema + ".metrics where idfamily="+family+" and ply>0  and idtest = " + idExperiment +" ";
		
		
		if(type_1 != ""){ query += " and type_1= "+ type_1; }
		if(type_2 != ""){ query += " and type_2= "+ type_2; }
		if(type_3 != ""){ query += " and type_3= "+ type_3; }
		if(instance != ""){ query += " and instance= "+ instance; }

		query += " order by filename asc;";

		Set<String> fetched = new HashSet<String>();

		try{

			Statement statement = (Statement) connectionWithDatabase.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				String currFetch = rs.getString("filename");
				fetched.add(currFetch);
			}
		}catch(Exception e){
			System.out.println("Error fetching Metrics");
			e.printStackTrace();	
		}

		return fetched;
		
		
	}

	public Set<String> fetchMetrics(){

		String query = "SELECT * FROM " + dbSchema + ".metrics where ply>0 order by filename asc;";

		Set<String> fetched = new HashSet<String>();

		try{

			Statement statement = (Statement) connectionWithDatabase.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				String currFetch = rs.getString("filename");
				fetched.add(currFetch);
			}
		}catch(Exception e){
			System.out.println("Error fetching Metrics");
			e.printStackTrace();	
		}

		return fetched;
	}
	
	public ArrayList<Element> fetchElements(int family, String algorithm, String type_1, String type_2, String type_3, String instance, String measure1, String measure2, String idExperiment){
		
		String query = "SELECT * FROM " + dbSchema + ".metrics where idfamily="+family+" and ply > 0 and idtest = " + idExperiment +" ";
		

		
		if(algorithm != ""){ query += " and idalgorithm= "+ algorithm; }
		if(type_1 != ""){ query += " and type_1= "+ type_1; }
		if(type_2 != ""){ query += " and type_2= "+ type_2; }
		if(type_3 != ""){ query += " and type_3= "+ type_3; }
		if(instance != ""){ query += " and instance= "+ instance; query += " and idalgorithm <> 5"; }

		query += " order by filename asc;";
		
		System.out.println(query);

		
		//System.out.println(query);
				
		ArrayList<Element> fetched = new ArrayList<Element>();

		try{

			Statement statement = (Statement) connectionWithDatabase.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				
				String filename = rs.getString("filename");
				double v1 = rs.getDouble(measure1);
				double v2 = rs.getDouble(measure2);
				
				Element currFetch = new Element(filename, v1, v2);
				
				fetched.add(currFetch);
			}
		}catch(Exception e){
			System.out.println("Error fetching Metrics");
			e.printStackTrace();	
		}

		return fetched;
	}
	
public ArrayList<Element> fetchElements4(int family, String algorithm, String type_1, String type_2, String type_3, String instance, String measure1, String measure2, String measure3, String measure4, String idExperiment){
		
		String query = "SELECT * FROM " + dbSchema + ".metrics where idfamily="+family+" and ply > 0 and idtest = " + idExperiment +" ";
		

		
		if(algorithm != ""){ query += " and idalgorithm= "+ algorithm; }
		if(type_1 != ""){ query += " and type_1= "+ type_1; }
		if(type_2 != ""){ query += " and type_2= "+ type_2; }
		if(type_3 != ""){ query += " and type_3= "+ type_3; }
		if(instance != ""){ query += " and instance= "+ instance; query += " and idalgorithm <> 5"; }

		query += " order by filename asc;";
		
		System.out.println(query);

		
		//System.out.println(query);
				
		ArrayList<Element> fetched = new ArrayList<Element>();

		try{

			Statement statement = (Statement) connectionWithDatabase.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				
				String filename = rs.getString("filename");
				double v1 = rs.getDouble(measure1);
				double v2 = rs.getDouble(measure2);
				double v3 = rs.getDouble(measure3);
				double v4 = rs.getDouble(measure4);
				
				Element currFetch = new Element(filename, v1, v2, v3, v4);
				
				fetched.add(currFetch);
			}
		}catch(Exception e){
			System.out.println("Error fetching Metrics");
			e.printStackTrace();	
		}

		return fetched;
	}


	
	
	
	public ArrayList<Element> fetchElements(int family, int algorithm, String type_1 ,String v1Name, String v2Name, String idExperiment){
		
		String query = "SELECT * FROM " + dbSchema + ".metrics where idfamily="+family+" and ply>0 and idalgorithm="+ algorithm + " and type_1="+type_1+"  and idtest = " + idExperiment +"; ";

		ArrayList<Element> fetched = new ArrayList<Element>();

		try{

			Statement statement = (Statement) connectionWithDatabase.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				
				String filename = rs.getString("filename");
				double v1 = rs.getDouble(v1Name);
				double v2 = rs.getDouble(v2Name);
				
				Element currFetch = new Element(filename, v1, v2);
				
				fetched.add(currFetch);
			}
		}catch(Exception e){
			System.out.println("Error fetching Metrics");
			e.printStackTrace();	
		}

		return fetched;
		
	}
	
	
	public double avg(int family, String algorithm, String type_1, String type_2, String value, String idExperiment){
		
		String query = "SELECT avg("+value+") FROM " + dbSchema + ".metrics where idfamily="+family+" and ply>0 and idtest = " + idExperiment +" ";
		
		if(algorithm != ""){ query += " and idalgorithm= "+ algorithm; }
		if(type_1 != ""){ query += " and type_1= "+ type_1; }
		if(type_2 != ""){ query += " and type_2= "+ type_2; }

		query += " ;";
		
		//System.out.println(query);
				
		double fetched = -1;

		try{

			Statement statement = (Statement) connectionWithDatabase.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				
				fetched = rs.getDouble(1);
				
			}
		}catch(Exception e){
			System.out.println("Error fetching Metrics");
			e.printStackTrace();	
		}

		return fetched;
		
		
	}
	
}

