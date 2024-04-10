package db;

import java.sql.Connection;

import crud.RowInsert;

public class DbInit {

	public static void TableInit(Connection con) {
		//initialisation des tables
		CreateTable.createTableProm(con);
		CreateTable.createTableApprenant(con);
	}

	public static void InsertInit(Connection con) {
		//insert de données de base pour ne pas travailler sur rien
		RowInsert.createPromotion(con, "DI22");
		RowInsert.createPromotion(con, "DI23");
		RowInsert.createPromotion(con, "FRIR23");
		RowInsert.createPromotion(con, "FRIR24");
		RowInsert.createPromotion(con, "CDA23");
		RowInsert.createPromotion(con, "CDA24");

		RowInsert.createApprenant(con, 1, "Alexis", "Loison Luquet", "alexis.loison@viacesi.fr", "0641945146", false);
		RowInsert.createApprenant(con, 1, "Thomas", "Giresse", "thomas.giresse@viacesi.fr", "06xxxxxxxx", true);

		RowInsert.createApprenant(con, 2, "Virgil", "Markus", "virgil.markus@viacesi.fr", "06xxxxxxxx", false);
		RowInsert.createApprenant(con, 2, "Auri", "Roselli", "auri.roselli@viacesi.fr", "06xxxxxxxx", true);

		RowInsert.createApprenant(con, 3, "Marc", "Dubois", "marc.dubois@viacesi.fr", "06xxxxxxxx", false);
		RowInsert.createApprenant(con, 3, "Cécile", "Campagne", "cecile.campagne@viacesi.fr", "06xxxxxxxx", true);

		RowInsert.createApprenant(con, 4, "Hercule", "Poirot", "hercule.poirot@viacesi.fr", "06xxxxxxxx", false);
		RowInsert.createApprenant(con, 4, "Sherlock", "Holmes", "sherlock.holmes@viacesi.fr", "06xxxxxxxx", true);

		RowInsert.createApprenant(con, 5, "Laure", "Dartiguelongue", "laure.dartiguelongue@viacesi.fr", "06xxxxxxxx", false);
		RowInsert.createApprenant(con, 5, "Marie", "Lafargue", "marie.lafargue@viacesi.fr", "06xxxxxxxx", true);

		RowInsert.createApprenant(con, 6, "Eddy", "Pajot", "eddy.pajot@viacesi.fr", "06xxxxxxxx", false);
		RowInsert.createApprenant(con, 6, "Louise", "Bardou", "louise.bardou@viacesi.fr", "06xxxxxxxx", true);
	}
}
