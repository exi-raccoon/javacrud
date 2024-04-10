        // initialisation des tables de la base de données
		DbInit.TableInit(con);
		// initialisation des datas de la base de données -> a commenté si pas besoin
		DbInit.InsertInit(con);

		// CREATE

		// create un nouvel apprenant en ajoutant : promotion (int), firstName
		// (string), lastName (string), email (string), phone (string),delegue (boolean)
		//les heures d'absences sont automatiquement misent à 0 pour un nouvel apprenant
		RowInsert.createApprenant(con, 1, "Léo", "Munson", "leo.munson@viacesi.fr", "06xxxxxxxx", false);
		TableRead.readApprenant(con);

		// create une nouvelle promotion en ajoutant : name (varchar)
		RowInsert.createPromotion(con, "DI25");
		TableRead.readPromotion(con);

		// READ

		// read la table apprenant avec les noms des promotions plutôt que les id des
		// promotions
		TableRead.readApprenant(con);

		// read la table des promotions
		TableRead.readPromotion(con);

		// read la table des apprenants en l'ordonnant par une column
		TableRead.readAppOrderBy(con, "first_name", "asc");
		TableRead.readAppOrderBy(con, "nbr_abs", "desc");

		// read la table des apprenants en cherchant par id des apprenants
		TableRead.readAppByAppId(con, 2);

		// read la table des apprenant en cherchant par nom de promotion
		TableRead.readAppByProm(con, "DI22");

		// read la table des promotions avec le total d'absence de la promotion
		TableRead.readNbrAbsByProm(con);

		// UPDATE

		// update un champ de la table apprenant : columnName (string), newData
		// (string), id (int)
		RowUpdate.updateApprenantById(con, "nbr_abs", "1", 1);

		// DELETE
		// delete un apprenant si il n'est pas délégué
		RowDelete.deleteApprenant(con, 1); // Alexis n'est pas délégué donc il peut être deleted
		RowDelete.deleteApprenant(con, 2);// Thomas est délégué, il ne peut pas être deleted
		TableRead.readApprenant(con); // Thomas est toujours là mais Alexis n'est plus dans la liste
