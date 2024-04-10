package crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class TableRead {
	private static final String SELECT_APPRENANT = "SELECT prom.name AS promotion_name, app.id_apprenant, app.first_name, app.last_name, app.email, app.phone, app.nbr_abs, app.delegue FROM apprenant app JOIN promotion prom ON prom.id_promotion = app.promotion_id";

	// fonction pour ne pas réécrire les colonnes à chaque fois
	public static void showTablesApp(ResultSet result, ResultSetMetaData rsmd) throws Exception {
		System.out.println(rsmd.getColumnLabel(1) + "\t\t" + rsmd.getColumnName(2) + "\t\t" + rsmd.getColumnName(3)
				+ "\t\t" + rsmd.getColumnName(4) + "\t\t" + rsmd.getColumnName(5) + "\t\t" + rsmd.getColumnName(6)
				+ "\t\t" + rsmd.getColumnName(7) + "\t\t" + rsmd.getColumnName(8));
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------");
		while (result.next()) {
			System.out.print(result.getString(1) + "\t|\t");
			System.out.print(result.getString(2) + "\t|\t");
			System.out.print(result.getString(3) + "\t|\t");
			System.out.print(result.getString(4) + "\t|\t");
			System.out.print(result.getString(5) + "\t|\t");
			System.out.print(result.getString(6) + "\t|\t");
			System.out.print(result.getString(7) + "\t|\t");
			System.out.println(result.getString(8));
		}
	}

	// fonction pour ne pas réécrire les colonnes à chaque fois
	public static void showTablesProm(ResultSet result, ResultSetMetaData rsmd) throws Exception {
		System.out.println(rsmd.getColumnName(1) + "\t\t" + rsmd.getColumnName(2));
		System.out.println("--------------------------------");
		while (result.next()) {
			System.out.print(result.getString(1) + "\t|\t");
			System.out.println(result.getString(2));
		}
	}

//SELECT des infos apprenants + nom de la formation en passant par un JOIN
	public static void readApprenant(Connection con) {
		Statement stm;
		ResultSet result;
		ResultSetMetaData rsmd;
		try {
			stm = con.createStatement();
			String query = SELECT_APPRENANT;
			result = stm.executeQuery(query);
			rsmd = result.getMetaData();
			showTablesApp(result, rsmd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
//même SELECT que au-dessus mais avec un orderby possible par chaque colonne
	public static void readAppOrderBy(Connection con, String column, String orderBy) {
		Statement stm;
		ResultSet result;
		ResultSetMetaData rsmd;
		try {
			stm = con.createStatement();
			String query = SELECT_APPRENANT + " ORDER BY " + column + " " + orderBy + ";";
			result = stm.executeQuery(query);
			rsmd = result.getMetaData();

			showTablesApp(result, rsmd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
//SELECT des apprenant en fonction de l'id de la promotion
	public static void readAppByProm(Connection con, Integer id) {
		Statement stm;
		ResultSet result;
		ResultSetMetaData rsmd;
		try {
			stm = con.createStatement();
			String query = SELECT_APPRENANT + " WHERE prom.id_promotion = " + id + ";";
			result = stm.executeQuery(query);
			rsmd = result.getMetaData();
			showTablesApp(result, rsmd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
//SELECT des infos apprenant en fonction de son id
	public static void readAppByAppId(Connection con, Integer id) {
		Statement stm;
		ResultSet result;
		ResultSetMetaData rsmd;
		try {
			stm = con.createStatement();
			String query = SELECT_APPRENANT + " WHERE app.id_apprenant = " + id + ";";
			result = stm.executeQuery(query);
			rsmd = result.getMetaData();
			showTablesApp(result, rsmd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
//SUM des abscences par promotion
	public static void readNbrAbsByProm(Connection con) {
		Statement stm;
		ResultSet result;
		ResultSetMetaData rsmd;
		try {
			stm = con.createStatement();
			String query = "SELECT prom.name, SUM(app.nbr_abs) AS nbr_abs FROM apprenant app JOIN promotion prom ON prom.id_promotion = app.promotion_id GROUP BY 1;";
			result = stm.executeQuery(query);
			rsmd = result.getMetaData();
			showTablesProm(result, rsmd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
//SELECT id promotion + nom promotion
	public static void readPromotion(Connection con) {
		Statement stm;
		ResultSet result;
		ResultSetMetaData rsmd;

		try {
			stm = con.createStatement();
			String query = "SELECT * FROM promotion ;";
			result = stm.executeQuery(query);
			rsmd = result.getMetaData();
			showTablesProm(result, rsmd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
