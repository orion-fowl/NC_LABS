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

public class DirCreator {
	public static String PATH = new File("").getAbsolutePath() + "/resources/";
	private boolean dirExists = false;
	public DirCreator() {
		this.dirExists = checkDir();
		if (!this.dirExists) {
			this.createDir();
		}
	}
	private void createDir() {
		File folder = new File(this.PATH);
		folder.mkdir();
		this.dirExists = true;
	}
	public boolean checkDir() {
		File file = new File(this.PATH);
		return file.exists();
	}
}
