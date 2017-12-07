package schedule;

import schedule.utils.XMLCreator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

public class test {

	public static void main(String[] args) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
//		ScheduleData model = new ScheduleData();
//		ConsoleController controller = new ConsoleController(model);
//		while(true) {
//		controller.parseAndPerform();
//		}
		XMLCreator.createOutputFile();
	}
}
