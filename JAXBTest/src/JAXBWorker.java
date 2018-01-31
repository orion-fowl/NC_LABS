import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBWorker {
	public static void objectToXML(Object obj) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(obj, new File("data.xml"));
			jaxbMarshaller.marshal(obj, System.out);
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	public static EmployeesList xmlToObject(String path) {
		EmployeesList employees = null;
		try {
			File file = new File(path);
			JAXBContext jaxbContext = JAXBContext.newInstance(EmployeesList.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			employees = (EmployeesList)jaxbUnmarshaller.unmarshal(file);
			System.out.println(employees);
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}
		return employees;
	}
}
