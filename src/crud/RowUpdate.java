package crud;

import java.sql.Connection;
import java.sql.Statement;

public class RowUpdate {
	//update du nbr d'abscence en fonction du id de l'apprenant
	public static void updateApprenantById(Connection con, Integer newData, Integer id) {
		Statement stm;
		
		try {
			stm = con.createStatement();
			String query = String.format("UPDATE apprenant SET nbr_abs = %d WHERE id_apprenant = %d", newData, id);
			stm.executeUpdate(query);
			System.out.println("nbr_abs of apprenant updated.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//changer nom d'une promotion
	public static void updatePromById(Connection con, String newData, Integer id) {
		Statement stm;
		
		try {
			stm = con.createStatement();
			String query = String.format("UPDATE promotion SET name = '%s' WHERE id_promotion = %d", newData, id);
			stm.executeUpdate(query);
			System.out.println("name of promotion updated.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
