package mainmenu;

import java.sql.Connection;
import java.util.Scanner;

import crud.RowDelete;
import crud.RowInsert;
import crud.RowUpdate;
import crud.TableRead;
import db.ConnectionClass;

public class MainMenu {
	private static final Scanner scanner = new Scanner(System.in);

	public static void mainMenu() {
		boolean running = true;
		while (running) {
			System.out.println("\n___ Main Menu ___");
			System.out.println("1/ Promotion management");
			System.out.println("2/ Apprenant management");
			System.out.println("3/ Exit");
			System.out.println("Select an option: ");

			int option = scanner.nextInt();
			scanner.nextLine(); // Consume the newline left-over

			switch (option) {
			case 1:
				promotionMenu();
				break;
			case 2:
				apprenantMenu();
				break;
			case 3:
				running = false;
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}

	private static void promotionMenu() {
		Connection con = ConnectionClass.connectToDb();
		boolean back = false;
		while (!back) {
			System.out.println("\n___ Promotion Management ___");
			System.out.println("1/ See promotions");
			System.out.println("2/ Create promotion");
			System.out.println("3/ Update promotion");
			System.out.println("4/ Delete promotion");
			System.out.println("5/ Back to main menu");
			System.out.println("Select an option: ");

			int option = scanner.nextInt();
			scanner.nextLine(); // Consume the newline left-over

			switch (option) {
			case 1:
				TableRead.readPromotion(con);
				break;
			case 2:
				System.out.println("New promotion's name: ");
				String x = scanner.nextLine();
				RowInsert.createPromotion(con, x);
				break;
			case 3:
				System.out.println("Promotion id to update : ");
				int y = scanner.nextInt();
				System.out.println("Promotion's new name : ");
				String vide = scanner.nextLine();
				String p = scanner.nextLine();
				RowUpdate.updatePromById(con, p, y);
				break;
			case 4:
				System.out.println("Delete promotion id : ");
				int z = scanner.nextInt();
				RowDelete.deletePromotion(con, z);
				break;
			case 5:
				back = true;
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}

	private static void apprenantMenu() {
		Connection con = ConnectionClass.connectToDb();
		boolean back = false;
		while (!back) {
			System.out.println("\n--- Apprenant Management ---");
			System.out.println("1/ See apprenants");
			System.out.println("2/ See apprenants By Id");
			System.out.println("3/ Create apprenant");
			System.out.println("4/ Update apprenant");
			System.out.println("5/ Delete apprenant");
			System.out.println("6/ Back to main menu");
			System.out.println("Select an option: ");

			int option = scanner.nextInt();
			scanner.nextLine(); // Consume the newline left-over

			switch (option) {
			case 1:
				apprenantSelectMenu();
				break;
			case 2:
				System.out.println("Apprenant id: ");
				int v = scanner.nextInt();
				TableRead.readAppByAppId(con, v);
				break;
			case 3:
				System.out.println("Promotion id : ");
				int x = scanner.nextInt();
				String vide = scanner.nextLine();
				System.out.println("First name : ");
				String y = scanner.nextLine();
				System.out.println("Last name : ");
				String z = scanner.nextLine();
				System.out.println("Email : ");
				String a = scanner.nextLine();
				System.out.println("Phone : ");
				String b = scanner.nextLine();
				System.out.println("Is the new apprenant a délégué ? f/t ");
				String c = scanner.nextLine();
				if (c.equals("f")) {
					Boolean boolDel = false;
					RowInsert.createApprenant(con, x, y, z, a, b, boolDel);
				} else {
					if (c.equals("t")) {
						Boolean boolDel = true;
						RowInsert.createApprenant(con, x, y, z, a, b, boolDel);
					}

				}
				break;
			case 4:
				System.out.println("Apprenant id : ");
				int d = scanner.nextInt();
				System.out.println("New number of absences : ");
				int e = scanner.nextInt();
				RowUpdate.updateApprenantById(con, e, d);
				break;
			case 5:
				System.out.println("Apprenant id: ");
				int f = scanner.nextInt();
				RowDelete.deleteApprenant(con, f);
				break;
			case 6:
				back = true;
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}

	private static void apprenantSelectMenu() {
		Connection con = ConnectionClass.connectToDb();
		boolean back = false;
		while (!back) {
			System.out.println("\n--- See All Apprenants ---");
			System.out.println("1/ See all Apprenants");
			System.out.println("2/ See all Apprenants order by");
			System.out.println("3/ See all Aprenants by promotion");
			System.out.println("4/ See number of abscence per promotion");
			System.out.println("5/ Back to main menu");
			System.out.println("Select an option: ");

			int option = scanner.nextInt();
			scanner.nextLine(); // Consume the newline left-over

			switch (option) {
			case 1:
				TableRead.readApprenant(con);
				break;
			case 2:
				System.out.println("Order by nbr_abs or first_name ?");
				String a = scanner.nextLine();
				System.out.println("asc or desc ?");
				String b = scanner.nextLine();
				TableRead.readAppOrderBy(con, a, b);
				break;
			case 3:
				System.out.println("Promotion id :");
				int c = scanner.nextInt();
				TableRead.readAppByProm(con, c);
				break;
			case 4:
				TableRead.readNbrAbsByProm(con);
				break;
			case 5:
				back = true;
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}
}
