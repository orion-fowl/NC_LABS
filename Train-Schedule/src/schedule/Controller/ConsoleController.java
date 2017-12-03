package schedule.Controller;

import java.util.Scanner;
import schedule.Model.*;

public class ConsoleController {
	private ScheduleData model;
	public ConsoleController(ScheduleData model) {
		this.model = model;
	}
	public int parseAndPerform() {
		Scanner reader = new Scanner(System.in);
		String arg = reader.nextLine();
		String command = defineCommand(arg);
		if (command.equals("END")) {
			reader.close();
			System.exit(0);
		}
		String argument1 = defineArgument(arg);
		String argument2 = argument1;
		if (command.equals("UPDATE")) {
			argument2 = defineArgument(arg.substring(arg.indexOf("TO ") + 3));
		}
		if (argument1 == "") {
			command = "ERROR";
		}
		switch (command) {
			case "SEARCH":
				this.model.search(argument1);
					break;
			case "ADD":
				this.model.add(argument1);
					break;
			case "UPDATE":
				this.model.update(argument1, argument2);
					break;
			case "DELETE":
				this.model.delete(argument1);
					break;
			case "ADD FROM":
				this.model.addFrom(argument1);
					break;
			case "ERROR":
					break;
		}
		return 0;
	}
	private String defineCommand(String arg) {
		int sep_index = arg.indexOf(" \"");
		if (sep_index == -1) {
			if (arg.contains("END")) {
				return "END";
			}
			else {
				this.error("Wrong input");
				return "";
			}
		}
		else {
			return (arg.substring(0, sep_index));
		}
	}
	private String defineArgument(String arg) {
		int sep_index = arg.indexOf("\"");
		if (sep_index != -1 && arg.endsWith("\"")) {
			if (arg.contains("TO \"")) {
				return arg.substring(sep_index + 1, arg.indexOf("TO \"") - 2);
			}
			else {
				return arg.substring(sep_index + 1, arg.length() - 1);
			}
		}
		else {
			this.error("Wrong input");
			return "";
		}
	}
	public void error(String msg) {
		System.out.println(msg);
	}
}	
