package schedule.View;

import java.util.Date;
import java.util.Scanner;

import schedule.utils.Commands;
import schedule.utils.TableDrawer;

public class View {
	public void showDateTime() {
		Date date = new Date();
		System.out.println(date.toString());
	}
	public void showData(String[][] data) {
		TableDrawer tDrawer = new TableDrawer();
		if (data == null) {
			tDrawer.drawTable();
		}
		else {
			tDrawer.drawTable(data);
		}
		System.out.print("\n\n\n\n\n");
	}
	public String getUserRespond() {
		System.out.print("Write command (type \"HELP\" for help)");
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	public void load() {
		showDateTime();
		showData(null);
		if (isValidInput(getUserRespond())) {
			System.out.println("works");
		}
	}
	public boolean isValidInput(String user_input) {
		for (Commands c : Commands.values()) {
			if (c.name().equals(user_input)) {
				return true;
			}
		}
		return false;
	}
}
