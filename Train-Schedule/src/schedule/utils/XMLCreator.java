package schedule.utils;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLCreator {
	private static boolean fileExists = false;
	private static boolean dirExists = false;
	private static void createFile() throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true); 
		Document doc = factory.newDocumentBuilder().newDocument();
		
		Element root = doc.createElement("root");
		root.setAttribute("xmlns", "http://www.javacore.ru/schemas/");
		doc.appendChild(root);
		
		Element item1 = doc.createElement("item");
		item1.setAttribute("val", "1");
		root.appendChild(item1);
		
		Element item2 = doc.createElement("item");
		item1.setAttribute("val", "2");
		root.appendChild(item2);
		
		Element item3 = doc.createElement("item");
		item1.setAttribute("val", "3");
		item2.appendChild(item3);
		
		File file = new File("resourses/schedules.xml");
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(new DOMSource(doc), new StreamResult(file));
		
		fileExists = true;
	}
	private static void createDir() {
		String path = new File("").getAbsolutePath();
		File folder = new File(path + "/resourses");
		folder.mkdir();
		dirExists = true;
	}
	public static boolean checkDir() {
		String path = new File("").getAbsolutePath() + "/resourses";
		File file = new File(path);
		return file.exists();
	}
	public static boolean checkFile() {
		String path = new File("").getAbsolutePath() + "/resourses/schedules.xml";
		File file = new File(path);
		return file.exists();
	}
	public static void createOutputFile() throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		if (!dirExists) {
			createDir();
		}
		if (!fileExists) {
			createFile();
		}
	}
}
