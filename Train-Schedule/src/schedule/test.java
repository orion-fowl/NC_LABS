package schedule;

import schedule.View.View;
import schedule.utils.DirCreator;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.xml.sax.SAXException;

public class test {

	public static void main(String[] args) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException, SAXException, IOException {
		new DirCreator();
		String s = "4444 \"Station one\" \"Station two\" 2017-03-03 22:22 P3D";
		String s1 = "4445 \"Station one\" \"Station two\" 2017-03-03 22:22 P3D";
		String s2 = "4446 \"Станция\" \"Station two\" 2017-03-03 22:22 P3D";
		View v = new View();
		v.load();
	}
}
