package schedule.utils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import schedule.Model.Schedule;
import schedule.Model.ScheduleItem;

public class JaxbWorker {
	public static void objectToXML(Object obj, File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(obj, file);
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	public static Schedule xmlToObject(File file) {
		Schedule schedule = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Schedule.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			schedule = (Schedule)jaxbUnmarshaller.unmarshal(file);
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}
		return schedule;
	}
}