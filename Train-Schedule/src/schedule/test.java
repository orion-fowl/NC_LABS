package schedule;

import schedule.utils.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.xml.sax.SAXException;

public class test {

	public static void main(String[] args) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException, SAXException, IOException {
//		ScheduleData model = new ScheduleData();
//		ConsoleController controller = new ConsoleController(model);
//		while(true) {
//		controller.parseAndPerform();
//		}
		XMLCreator creator = new XMLCreator();
		creator.start();
		
	}
}
