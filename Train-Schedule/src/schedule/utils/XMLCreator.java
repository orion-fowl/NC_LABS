package schedule.utils;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLCreator {
	private boolean fileExists = false;
	private boolean dirExists = false;
	public XMLCreator() {
		this.dirExists = checkDir();
		this.fileExists = checkFile();
	}
	private void createFile() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			
			Element root_element = doc.createElement("schedules");
			doc.appendChild(root_element);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			
			DOMSource source = new DOMSource(doc);
			StreamResult file = new StreamResult("resources/schedules.xml");
			transformer.transform(source,  file);
			
			this.fileExists = true;	
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
	private void createDir() {
		String path = new File("").getAbsolutePath();
		File folder = new File(path + "/resources");
		folder.mkdir();
		this.dirExists = true;
	}
	public boolean checkDir() {
		String path = new File("").getAbsolutePath() + "/resources";
		File file = new File(path);
		return file.exists();
	}
	public boolean checkFile() {
		String path = new File("").getAbsolutePath() + "/resources/schedules.xml";
		File file = new File(path);
		return file.exists();
	}
	public void start() {
		if (!dirExists) {
			createDir();
		}
		if (!fileExists) {
			createFile();
		}
	}
}
