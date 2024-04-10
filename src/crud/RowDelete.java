package crud;

import java.sql.Connection;
import java.sql.Statement;

public class RowDelete {
	private static final String DELETE_DATA_APP = "DELETE FROM apprenant WHERE id_apprenant = ";
	private static final String DELETE_DATA_PROM = "DELETE FROM promotion WHERE id_promotion = ";
	public static void deleteApprenant(Connection con, Integer id) {
		Statement stm;
		
		try {
			String query = DELETE_DATA_APP + id + " AND delegue IS NOT TRUE;"; 
			stm = con.createStatement();
			stm.executeUpdate(query);
			System.out.println("Row deleted if not delegue");
		} catch (Exception e) {
			System.out.println("Exception caugh in deleteApprenant.");
		}
	}
	
	public static void deletePromotion(Connection con, Integer id) {
		Statement stm;
		
		try {
			String query = DELETE_DATA_PROM + id + ";"; 
			stm = con.createStatement();
			stm.executeUpdate(query);
			System.out.println("Promotion "+ id +" deleted.");
		} catch (Exception e) {
			System.out.println("Exception caugh in deletePromotion.");
		}
	}
}
