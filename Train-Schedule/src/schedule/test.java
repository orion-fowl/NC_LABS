package schedule;

import schedule.Model.*;
import schedule.Controller.*;

public class test {

	public static void main(String[] args) {
		ScheduleData model = new ScheduleData();
	//	ConsoleView view;
		ConsoleController controller = new ConsoleController(model);
		while(true) {
		controller.parseAndPerform();
		}
	}
}
