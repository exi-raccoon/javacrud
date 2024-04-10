import java.sql.Connection;

import db.ConnectionClass;
import db.DbInit;
import mainmenu.MainMenu;

public class Launcher {
	public static void main(String[] args) {
		Connection con = ConnectionClass.connectToDb();
		// initialisation des tables de la base de données
		DbInit.TableInit(con);
		// initialisation des datas de la base de données -> a commenté si pas besoin
		DbInit.InsertInit(con);
		MainMenu.mainMenu();
	}
}
