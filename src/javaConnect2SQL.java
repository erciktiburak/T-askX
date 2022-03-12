import java.sql.Connection;
import java.sql.DriverManager;

public class javaConnect2SQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String conUrl = "jdbc:sqlserver://'sqlservernama'; databaseName = ' '; integratedSecurity=true;";
		Connection con = null;
	
		try {    
			con = DriverManager.getConnection(conUrl);    
			System.out.println("Connected...");    
			System.out.println();    
			  
			System.out.println("Do here some database operations...");       
			} catch (Exception e) {    
			System.out.println("Failed...");    
			e.printStackTrace();   
			} finally {    
			if (con != null)     
			try {     
			con.close(); 
			     System.out.println();
			      System.out.println("Disconnected...");
			     } catch (Exception e) {     
			 System.out.println(e);     
			}   	
	}
	}
	
}