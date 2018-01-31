package schedule.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import schedule.utils.JaxbWorker;
import schedule.utils.ResourceValidator;

@XmlRootElement (name = "schedules")
public class Schedule {
	private HashSet<ScheduleItem> content;
	public Schedule(File file) {
		this.content = JaxbWorker.xmlToObject(file).getContent();
	}
	public Schedule() {
		this.content = new HashSet<ScheduleItem>();
	}
	@XmlElement (name = "schedule")
	public void setContent(HashSet<ScheduleItem> content) {
		this.content = content;
	}
	public HashSet<ScheduleItem> getContent() {
		return content;
	}
	public boolean add(ScheduleItem item) {
		return this.content.add(item);
	}
	public void deleteItem(ScheduleItem item) {
		if (this.contains(item)) {
			this.content.remove(item);
		}
	}
	public void pullFromXml(File file) {
		this.content = JaxbWorker.xmlToObject(file).getContent();		
	}
	public void saveToXml(File file) {
		JaxbWorker.objectToXML(this, file);
	}
	public boolean contains(ScheduleItem item) {
		return this.content.contains(item);
	}
	public void merge(File file) {
		if (ResourceValidator.validate(file)) {
			Schedule source = JaxbWorker.xmlToObject(file);
			this.content.addAll(source.getContent());
		}
	}
}
