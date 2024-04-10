package db;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTable {
	//creation des tables promotion et apprenants
	
	public static void createTableProm(Connection con) {
		Statement stm;
		try {
			//IF NOT EXISTS -> peut être relancé au tant de fois que besoin
			//UNIQUE -> pas de promo avec le même nom mais on garde la PRIMARY KEY propre en INT et SERIAL
			String query = "CREATE TABLE IF NOT EXISTS promotion (id_promotion SERIAL PRIMARY KEY, name VARCHAR(50) NOT NULL UNIQUE);";
			stm = con.createStatement();
			stm.executeUpdate(query);
			System.out.println("Table promotion OK.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void createTableApprenant(Connection con) {
		Statement stm;
		try {
			//IF NOT EXISTS -> peut être relancé au tant de fois que besoin
			//UNIQUE (x,y,z) -> pas d'apprenant avec la même combinaison de prénom, nom et email mais on garde la PRIMARY KEY propre en INT et SERIAL
			String query = "CREATE TABLE IF NOT EXISTS apprenant (id_apprenant SERIAL PRIMARY KEY, "
		+ "promotion_id INT, first_name VARCHAR(50) NOT NULL, last_name VARCHAR(50) NOT NULL, email VARCHAR(100) NOT NULL, phone VARCHAR(15), nbr_abs INT, delegue BOOL, "
		+"UNIQUE (first_name, last_name, email), "
		+" CONSTRAINT fk_promotion_id FOREIGN KEY (promotion_id) REFERENCES promotion (id_promotion));";
			stm = con.createStatement();
			stm.executeUpdate(query);
			System.out.println("Table apprenant OK.");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}