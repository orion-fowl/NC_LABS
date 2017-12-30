package schedule.utils;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

public class XMLValidator {
	private String xmlFile;
	private String schemaFile;
	public XMLValidator(String xmlName, String xsdName) {
		this.xmlFile = xmlName;
		this.schemaFile = xsdName;
	}
	public boolean validation() {
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		try {
			Schema schema = schemaFactory.newSchema(new File(new File("").getAbsolutePath() + "\\src\\" + schemaFile));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(new File("").getAbsolutePath() + "\\resources\\" + xmlFile)));
			return true;
		}
		catch (SAXException | IOException e) {
			return false;
		}
	}
}
