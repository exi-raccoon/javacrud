package crud;

import java.sql.Connection;
import java.sql.Statement;

public class RowInsert {
	public static void createApprenant(Connection con, Integer promotion, String firstName, String lastName,
			String email, String phone, Boolean delegue) {
		Statement stm;
		try {
			String query = String.format(
					"INSERT INTO apprenant (promotion_id, first_name, last_name, email, phone, nbr_abs, delegue) VALUES (%d,'%s','%s','%s','%s',0,%b) ON CONFLICT DO NOTHING;",
					promotion, firstName, lastName, email, phone, delegue);
			stm = con.createStatement();
			stm.executeUpdate(query);
			// System.out.println("Inserted successfully.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void createPromotion(Connection con, String name) {
		Statement stm;
		try {
			String query = String.format("INSERT INTO promotion (name) VALUES ('%s') ON CONFLICT DO NOTHING;", name);
			stm = con.createStatement();
			stm.executeUpdate(query);
			// System.out.println("Inserted successfully.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
